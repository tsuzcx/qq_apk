package org.libpag;

import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGLContext;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import org.extra.tools.BroadcastUtil;
import org.extra.tools.ScreenBroadcastReceiver.ScreenStateListener;

public class PAGView
  extends TextureView
  implements TextureView.SurfaceTextureListener, ScreenBroadcastReceiver.ScreenStateListener
{
  private static final int ANDROID_SDK_VERSION_O = 26;
  private static final int MSG_FLUSH = 0;
  private static final int MSG_HANDLER_THREAD_QUITE = 2;
  private static final int MSG_SURFACE_DESTROY = 1;
  private static final String TAG = "PAGView";
  private static final Object g_HandlerLock = new Object();
  private static volatile int g_HandlerThreadCount;
  private static PAGView.PAGRendererHandler g_PAGRendererHandler = null;
  private static HandlerThread g_PAGRendererThread = null;
  private Boolean _isAnimatorPreRunning = null;
  private boolean _isPlaying = false;
  private ValueAnimator animator;
  private volatile double animatorProgress;
  private volatile long currentPlayTime;
  private String filePath = "";
  private SparseArray<PAGImage> imageReplacementMap = new SparseArray();
  private boolean isAttachedToWindow = false;
  private Runnable mAnimatorCancelRunnable = new PAGView.5(this);
  private final AnimatorListenerAdapter mAnimatorListenerAdapter = new PAGView.2(this);
  private Runnable mAnimatorStartRunnable = new PAGView.4(this);
  private final ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener = new PAGView.1(this);
  private TextureView.SurfaceTextureListener mListener;
  private ArrayList<PAGView.PAGFlushListener> mPAGFlushListeners = new ArrayList();
  private boolean mSaveVisibleState;
  private ArrayList<PAGView.PAGViewListener> mViewListeners = new ArrayList();
  private PAGFile pagFile;
  private PAGPlayer pagPlayer;
  private PAGSurface pagSurface;
  private boolean preAggregatedVisible = true;
  private EGLContext sharedContext = null;
  private SparseArray<PAGText> textReplacementMap = new SparseArray();
  
  static
  {
    g_HandlerThreadCount = 0;
    BroadcastUtil.getInstance().registerScreenBroadcast();
  }
  
  public PAGView(Context paramContext)
  {
    super(paramContext);
    setupSurfaceTexture();
  }
  
  public PAGView(Context paramContext, EGLContext paramEGLContext)
  {
    super(paramContext);
    this.sharedContext = paramEGLContext;
    setupSurfaceTexture();
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setupSurfaceTexture();
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setupSurfaceTexture();
  }
  
  private static void DestroyHandlerThread()
  {
    try
    {
      g_HandlerThreadCount -= 1;
      int i = g_HandlerThreadCount;
      if (i != 0) {
        return;
      }
      if ((g_PAGRendererHandler != null) && (g_PAGRendererThread != null))
      {
        boolean bool = g_PAGRendererThread.isAlive();
        if (!bool) {
          return;
        }
        SendMessage(2, null);
        return;
      }
      return;
    }
    finally {}
  }
  
  private static void HandlerThreadQuit()
  {
    if (g_HandlerThreadCount != 0) {
      return;
    }
    if (g_PAGRendererHandler != null)
    {
      HandlerThread localHandlerThread = g_PAGRendererThread;
      if (localHandlerThread == null) {
        return;
      }
      if (!localHandlerThread.isAlive()) {
        return;
      }
      g_PAGRendererHandler.removeCallbacksAndMessages(null);
      if (Build.VERSION.SDK_INT > 18) {
        g_PAGRendererThread.quitSafely();
      } else {
        g_PAGRendererThread.quit();
      }
      g_PAGRendererThread = null;
      g_PAGRendererHandler = null;
    }
  }
  
  private static void NeedsUpdateView(PAGView paramPAGView)
  {
    PAGView.PAGRendererHandler localPAGRendererHandler = g_PAGRendererHandler;
    if (localPAGRendererHandler == null) {
      return;
    }
    localPAGRendererHandler.needsUpdateView(paramPAGView);
  }
  
  private static void SendMessage(int paramInt, Object paramObject)
  {
    Object localObject = g_PAGRendererHandler;
    if (localObject == null) {
      return;
    }
    localObject = ((PAGView.PAGRendererHandler)localObject).obtainMessage();
    ((Message)localObject).arg1 = paramInt;
    if (paramObject != null) {
      ((Message)localObject).obj = paramObject;
    }
    g_PAGRendererHandler.sendMessage((Message)localObject);
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      g_HandlerThreadCount += 1;
      if (g_PAGRendererThread == null)
      {
        g_PAGRendererThread = new HandlerThread("pag-renderer");
        g_PAGRendererThread.start();
      }
      if (g_PAGRendererHandler == null) {
        g_PAGRendererHandler = new PAGView.PAGRendererHandler(g_PAGRendererThread.getLooper());
      }
      return;
    }
    finally {}
  }
  
  private void applyReplacements()
  {
    PAGFile localPAGFile = (PAGFile)this.pagPlayer.getComposition();
    if (localPAGFile == null) {
      return;
    }
    int j = 0;
    int i = 0;
    while (i < this.textReplacementMap.size())
    {
      localPAGFile.replaceText(this.textReplacementMap.keyAt(i), (PAGText)this.textReplacementMap.valueAt(i));
      i += 1;
    }
    this.textReplacementMap.clear();
    i = j;
    while (i < this.imageReplacementMap.size())
    {
      localPAGFile.replaceImage(this.imageReplacementMap.keyAt(i), (PAGImage)this.imageReplacementMap.valueAt(i));
      i += 1;
    }
    this.imageReplacementMap.clear();
  }
  
  private void cancelAnimator()
  {
    if (isMainThread())
    {
      this.currentPlayTime = this.animator.getCurrentPlayTime();
      this.animator.cancel();
      return;
    }
    removeCallbacks(this.mAnimatorStartRunnable);
    post(this.mAnimatorCancelRunnable);
  }
  
  private void doPlay()
  {
    if (!this.isAttachedToWindow)
    {
      Log.e("PAGView", "doPlay: PAGView is not attached to window");
      return;
    }
    Log.i("PAGView", "doPlay");
    this.animator.setCurrentPlayTime(this.currentPlayTime);
    startAnimator();
  }
  
  private boolean isMainThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  private void onAnimationUpdate(double paramDouble)
  {
    this.animatorProgress = paramDouble;
    NeedsUpdateView(this);
  }
  
  private void pauseAnimator()
  {
    if (this._isAnimatorPreRunning == null) {
      this._isAnimatorPreRunning = Boolean.valueOf(this.animator.isRunning());
    }
    if (this.animator.isRunning()) {
      cancelAnimator();
    }
  }
  
  private void resumeAnimator()
  {
    if ((this._isPlaying) && (!this.animator.isRunning()))
    {
      Boolean localBoolean = this._isAnimatorPreRunning;
      if ((localBoolean == null) || (localBoolean.booleanValue()))
      {
        this._isAnimatorPreRunning = null;
        doPlay();
        return;
      }
    }
    this._isAnimatorPreRunning = null;
  }
  
  private void setupSurfaceTexture()
  {
    setOpaque(false);
    this.pagPlayer = new PAGPlayer();
    setSurfaceTextureListener(this);
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator.setRepeatCount(0);
    this.animator.setInterpolator(new LinearInterpolator());
  }
  
  private void startAnimator()
  {
    if (isMainThread())
    {
      this.animator.start();
      return;
    }
    removeCallbacks(this.mAnimatorCancelRunnable);
    post(this.mAnimatorStartRunnable);
  }
  
  private void updateView()
  {
    if (!this.isAttachedToWindow) {
      return;
    }
    this.pagPlayer.setProgress(this.animatorProgress);
    flush();
    if (!this.mPAGFlushListeners.isEmpty()) {
      post(new PAGView.3(this));
    }
  }
  
  @Deprecated
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.addListener(paramAnimatorListener);
  }
  
  public void addListener(PAGView.PAGViewListener paramPAGViewListener)
  {
    try
    {
      this.mViewListeners.add(paramPAGViewListener);
      return;
    }
    finally {}
  }
  
  public void addPAGFlushListener(PAGView.PAGFlushListener paramPAGFlushListener)
  {
    try
    {
      this.mPAGFlushListeners.add(paramPAGFlushListener);
      return;
    }
    finally {}
  }
  
  public boolean cacheEnabled()
  {
    return this.pagPlayer.cacheEnabled();
  }
  
  public float cacheScale()
  {
    return this.pagPlayer.cacheScale();
  }
  
  public long duration()
  {
    return this.pagPlayer.duration();
  }
  
  public boolean flush()
  {
    return this.pagPlayer.flush();
  }
  
  @Deprecated
  public boolean flush(boolean paramBoolean)
  {
    return flush();
  }
  
  public void freeCache()
  {
    PAGSurface localPAGSurface = this.pagSurface;
    if (localPAGSurface != null) {
      localPAGSurface.freeCache();
    }
  }
  
  public PAGComposition getComposition()
  {
    return this.pagPlayer.getComposition();
  }
  
  @Deprecated
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  public PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2)
  {
    return this.pagPlayer.getLayersUnderPoint(paramFloat1, paramFloat2);
  }
  
  public String getPath()
  {
    return this.filePath;
  }
  
  public double getProgress()
  {
    return this.pagPlayer.getProgress();
  }
  
  @Deprecated
  public PAGComposition getRootComposition()
  {
    return this.pagPlayer.getComposition();
  }
  
  public boolean isPlaying()
  {
    ValueAnimator localValueAnimator = this.animator;
    if (localValueAnimator != null) {
      return localValueAnimator.isRunning();
    }
    return false;
  }
  
  public Matrix matrix()
  {
    return this.pagPlayer.matrix();
  }
  
  public float maxFrameRate()
  {
    return this.pagPlayer.maxFrameRate();
  }
  
  protected void onAttachedToWindow()
  {
    this.isAttachedToWindow = true;
    super.onAttachedToWindow();
    this.animator.addListener(this.mAnimatorListenerAdapter);
    BroadcastUtil.getInstance().registerScreenBroadcast(this);
    synchronized (g_HandlerLock)
    {
      StartHandlerThread();
      resumeAnimator();
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.isAttachedToWindow = false;
    super.onDetachedFromWindow();
    BroadcastUtil.getInstance().unregisterScreenBroadcast(this);
    ??? = this.pagSurface;
    if (??? != null)
    {
      ((PAGSurface)???).release();
      this.pagSurface = null;
    }
    pauseAnimator();
    if (Build.VERSION.SDK_INT < 26) {
      synchronized (g_HandlerLock)
      {
        DestroyHandlerThread();
      }
    }
    this.animator.removeListener(this.mAnimatorListenerAdapter);
  }
  
  public void onScreenOff()
  {
    if (getVisibility() == 0)
    {
      this.mSaveVisibleState = true;
      setVisibility(4);
    }
  }
  
  public void onScreenOn()
  {
    if (this.mSaveVisibleState) {
      setVisibility(0);
    }
    this.mSaveVisibleState = false;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Object localObject = this.pagSurface;
    if (localObject != null)
    {
      ((PAGSurface)localObject).release();
      this.pagSurface = null;
    }
    this.pagSurface = PAGSurface.FromSurfaceTexture(paramSurfaceTexture, this.sharedContext);
    this.pagPlayer.setSurface(this.pagSurface);
    if (this.pagSurface == null) {
      return;
    }
    this.animator.addUpdateListener(this.mAnimatorUpdateListener);
    if (!this.mPAGFlushListeners.isEmpty())
    {
      this.pagSurface.clearAll();
      NeedsUpdateView(this);
    }
    else
    {
      flush();
    }
    localObject = this.mListener;
    if (localObject != null) {
      ((TextureView.SurfaceTextureListener)localObject).onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    this.pagPlayer.setSurface(null);
    Object localObject1 = this.mListener;
    if (localObject1 != null) {
      ((TextureView.SurfaceTextureListener)localObject1).onSurfaceTextureDestroyed(???);
    }
    localObject1 = this.pagSurface;
    if (localObject1 != null) {
      ((PAGSurface)localObject1).freeCache();
    }
    this.animator.removeUpdateListener(this.mAnimatorUpdateListener);
    localObject1 = g_PAGRendererHandler;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (??? != null)
      {
        SendMessage(1, ???);
        bool1 = false;
      }
    }
    if (Build.VERSION.SDK_INT >= 26) {
      synchronized (g_HandlerLock)
      {
        DestroyHandlerThread();
        return bool1;
      }
    }
    return bool1;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Object localObject = this.pagSurface;
    if (localObject != null)
    {
      ((PAGSurface)localObject).updateSize();
      if (!this.mPAGFlushListeners.isEmpty())
      {
        this.pagSurface.clearAll();
        NeedsUpdateView(this);
      }
      else
      {
        flush();
      }
    }
    localObject = this.mListener;
    if (localObject != null) {
      ((TextureView.SurfaceTextureListener)localObject).onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    TextureView.SurfaceTextureListener localSurfaceTextureListener = this.mListener;
    if (localSurfaceTextureListener != null) {
      localSurfaceTextureListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
  }
  
  public void onVisibilityAggregated(boolean paramBoolean)
  {
    super.onVisibilityAggregated(paramBoolean);
    if (this.preAggregatedVisible == paramBoolean) {
      return;
    }
    this.preAggregatedVisible = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVisibilityAggregated isVisible=");
    localStringBuilder.append(paramBoolean);
    Log.i("PAGView", localStringBuilder.toString());
    if (paramBoolean)
    {
      resumeAnimator();
      return;
    }
    pauseAnimator();
  }
  
  public void play()
  {
    this._isPlaying = true;
    this._isAnimatorPreRunning = null;
    doPlay();
  }
  
  @Deprecated
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.removeListener(paramAnimatorListener);
  }
  
  public void removeListener(PAGView.PAGViewListener paramPAGViewListener)
  {
    try
    {
      this.mViewListeners.remove(paramPAGViewListener);
      return;
    }
    finally {}
  }
  
  public void removePAGFlushListener(PAGView.PAGFlushListener paramPAGFlushListener)
  {
    try
    {
      this.mPAGFlushListeners.remove(paramPAGFlushListener);
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null)) {
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceImage(paramInt, paramPAGImage);
      return;
    }
    this.imageReplacementMap.put(paramInt, paramPAGImage);
  }
  
  public int scaleMode()
  {
    return this.pagPlayer.scaleMode();
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT < 24) && (paramDrawable != null)) {
      super.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    this.pagPlayer.setCacheEnabled(paramBoolean);
  }
  
  public void setCacheScale(float paramFloat)
  {
    this.pagPlayer.setCacheScale(paramFloat);
  }
  
  public void setComposition(PAGComposition paramPAGComposition)
  {
    this.filePath = null;
    this.pagFile = null;
    this.pagPlayer.setComposition(paramPAGComposition);
    long l = this.pagPlayer.duration();
    this.animator.setDuration(l / 1000L);
  }
  
  @Deprecated
  public void setFile(PAGFile paramPAGFile)
  {
    PAGFile localPAGFile;
    if (paramPAGFile != null) {
      localPAGFile = paramPAGFile.copyOriginal();
    } else {
      localPAGFile = null;
    }
    setComposition(localPAGFile);
    this.pagFile = paramPAGFile;
    if (this.pagFile != null) {
      applyReplacements();
    }
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    this.pagPlayer.setMatrix(paramMatrix);
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    this.pagPlayer.setMaxFrameRate(paramFloat);
  }
  
  public boolean setPath(String paramString)
  {
    PAGFile localPAGFile;
    if ((paramString != null) && (paramString.startsWith("assets://"))) {
      localPAGFile = PAGFile.Load(getContext().getAssets(), paramString.substring(9));
    } else {
      localPAGFile = PAGFile.Load(paramString);
    }
    setComposition(localPAGFile);
    this.filePath = paramString;
    return localPAGFile != null;
  }
  
  public void setProgress(double paramDouble)
  {
    paramDouble = Math.max(0.0D, Math.min(paramDouble, 1.0D));
    double d = this.animator.getDuration();
    Double.isNaN(d);
    this.currentPlayTime = ((d * paramDouble));
    this.animator.setCurrentPlayTime(this.currentPlayTime);
    onAnimationUpdate(paramDouble);
  }
  
  public void setRepeatCount(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.animator.setRepeatCount(i - 1);
  }
  
  public void setScaleMode(int paramInt)
  {
    this.pagPlayer.setScaleMode(paramInt);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    if (paramSurfaceTextureListener == this)
    {
      super.setSurfaceTextureListener(paramSurfaceTextureListener);
      return;
    }
    this.mListener = paramSurfaceTextureListener;
  }
  
  @Deprecated
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null)) {
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceText(paramInt, paramPAGText);
      return;
    }
    this.textReplacementMap.put(paramInt, paramPAGText);
  }
  
  public void setVideoEnabled(boolean paramBoolean)
  {
    this.pagPlayer.setVideoEnabled(paramBoolean);
  }
  
  public void stop()
  {
    Log.i("PAGView", "stop");
    this._isPlaying = false;
    this._isAnimatorPreRunning = null;
    cancelAnimator();
  }
  
  public boolean videoEnabled()
  {
    return this.pagPlayer.videoEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.PAGView
 * JD-Core Version:    0.7.0.1
 */