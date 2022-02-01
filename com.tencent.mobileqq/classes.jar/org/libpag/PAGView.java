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
  private static final Object g_HandlerLock = new Object();
  private static volatile int g_HandlerThreadCount;
  private static PAGView.PAGRendererHandler g_PAGRendererHandler = null;
  private static HandlerThread g_PAGRendererThread = null;
  private boolean _isPlaying = false;
  private ValueAnimator animator;
  private float animatorProgress;
  private String filePath = "";
  private SparseArray<PAGImage> imageReplacementMap = new SparseArray();
  private boolean isAttachedToWindow = false;
  private Runnable mAnimatorCancelRunnable = new PAGView.4(this);
  private AnimatorListenerAdapter mAnimatorListenerAdapter = new PAGView.2(this);
  private Runnable mAnimatorStartRunnable = new PAGView.3(this);
  private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener = new PAGView.1(this);
  private TextureView.SurfaceTextureListener mListener;
  private boolean mSaveVisibleState;
  private ArrayList<PAGView.PAGViewListener> mViewListeners = new ArrayList();
  private PAGFile pagFile;
  private PAGPlayer pagPlayer;
  private PAGSurface pagSurface;
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
  
  /* Error */
  private static void DestroyHandlerThread()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 74	org/libpag/PAGView:g_HandlerThreadCount	I
    //   6: iconst_1
    //   7: isub
    //   8: putstatic 74	org/libpag/PAGView:g_HandlerThreadCount	I
    //   11: getstatic 74	org/libpag/PAGView:g_HandlerThreadCount	I
    //   14: istore_0
    //   15: iload_0
    //   16: ifeq +7 -> 23
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: getstatic 70	org/libpag/PAGView:g_PAGRendererHandler	Lorg/libpag/PAGView$PAGRendererHandler;
    //   26: ifnull -7 -> 19
    //   29: getstatic 72	org/libpag/PAGView:g_PAGRendererThread	Landroid/os/HandlerThread;
    //   32: ifnull -13 -> 19
    //   35: getstatic 72	org/libpag/PAGView:g_PAGRendererThread	Landroid/os/HandlerThread;
    //   38: invokevirtual 148	android/os/HandlerThread:isAlive	()Z
    //   41: ifeq -22 -> 19
    //   44: iconst_2
    //   45: aconst_null
    //   46: invokestatic 152	org/libpag/PAGView:SendMessage	(ILjava/lang/Object;)V
    //   49: goto -30 -> 19
    //   52: astore_1
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	2	0	i	int
    //   52	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	52	finally
    //   23	49	52	finally
  }
  
  private static void HandlerThreadQuit()
  {
    if (g_HandlerThreadCount != 0) {}
    while ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null) || (!g_PAGRendererThread.isAlive())) {
      return;
    }
    g_PAGRendererHandler.removeCallbacksAndMessages(null);
    if (Build.VERSION.SDK_INT > 18) {
      g_PAGRendererThread.quitSafely();
    }
    for (;;)
    {
      g_PAGRendererThread = null;
      g_PAGRendererHandler = null;
      return;
      g_PAGRendererThread.quit();
    }
  }
  
  private static void NeedsUpdateView(PAGView paramPAGView)
  {
    if (g_PAGRendererHandler == null) {
      return;
    }
    g_PAGRendererHandler.needsUpdateView(paramPAGView);
  }
  
  private static void SendMessage(int paramInt, Object paramObject)
  {
    if (g_PAGRendererHandler == null) {
      return;
    }
    Message localMessage = g_PAGRendererHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    g_PAGRendererHandler.sendMessage(localMessage);
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
    int j = 0;
    PAGFile localPAGFile = (PAGFile)this.pagPlayer.getComposition();
    if (localPAGFile == null) {
      return;
    }
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
      this.animator.cancel();
      return;
    }
    removeCallbacks(this.mAnimatorStartRunnable);
    post(this.mAnimatorCancelRunnable);
  }
  
  private void doPlay()
  {
    if (!this.isAttachedToWindow) {
      return;
    }
    double d = this.pagPlayer.getProgress();
    this.animator.setCurrentPlayTime((d * this.animator.getDuration()));
    startAnimator();
  }
  
  private boolean isMainThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
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
    setProgress(this.animatorProgress);
    flush();
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
  
  public boolean flush(boolean paramBoolean)
  {
    return flush();
  }
  
  public void freeCache()
  {
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
  }
  
  public PAGComposition getComposition()
  {
    return this.pagPlayer.getComposition();
  }
  
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
  
  public PAGComposition getRootComposition()
  {
    return this.pagPlayer.getComposition();
  }
  
  public boolean isPlaying()
  {
    if (this.animator != null) {
      return this.animator.isRunning();
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
    BroadcastUtil.getInstance().registerScreenBroadcast(this);
    synchronized (g_HandlerLock)
    {
      StartHandlerThread();
      if (this._isPlaying) {
        doPlay();
      }
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    boolean bool2 = false;
    this.isAttachedToWindow = false;
    super.onDetachedFromWindow();
    BroadcastUtil.getInstance().unregisterScreenBroadcast(this);
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      this.pagSurface = null;
    }
    boolean bool1 = bool2;
    if (this._isPlaying)
    {
      bool1 = bool2;
      if (this.animator.isRunning()) {
        bool1 = true;
      }
    }
    this._isPlaying = bool1;
    cancelAnimator();
    if (Build.VERSION.SDK_INT < 26) {
      synchronized (g_HandlerLock)
      {
        DestroyHandlerThread();
        return;
      }
    }
  }
  
  public void onScreenOff()
  {
    if (getVisibility() == 0) {
      this.mSaveVisibleState = true;
    }
  }
  
  public void onScreenOn()
  {
    if (this.mSaveVisibleState)
    {
      if (getVisibility() != 0) {
        break label29;
      }
      dispatchVisibilityChanged(this, getVisibility());
    }
    for (;;)
    {
      this.mSaveVisibleState = false;
      return;
      label29:
      setVisibility(0);
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      this.pagSurface = null;
    }
    this.pagSurface = PAGSurface.FromSurfaceTexture(paramSurfaceTexture, this.sharedContext);
    this.pagPlayer.setSurface(this.pagSurface);
    if (this.pagSurface == null) {}
    do
    {
      return;
      this.animator.addUpdateListener(this.mAnimatorUpdateListener);
      this.animator.addListener(this.mAnimatorListenerAdapter);
      this.pagPlayer.flush();
    } while (this.mListener == null);
    this.mListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    boolean bool2 = true;
    this.pagPlayer.setSurface(null);
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureDestroyed(???);
    }
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    this.animator.removeUpdateListener(this.mAnimatorUpdateListener);
    this.animator.removeListener(this.mAnimatorListenerAdapter);
    boolean bool1 = bool2;
    if (g_PAGRendererHandler != null)
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
    if (this.pagSurface != null)
    {
      this.pagSurface.updateSize();
      this.pagPlayer.flush();
    }
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
  }
  
  public void play()
  {
    this._isPlaying = true;
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
  
  public void setFile(PAGFile paramPAGFile)
  {
    if (paramPAGFile != null) {}
    for (PAGFile localPAGFile = paramPAGFile.copyOriginal();; localPAGFile = null)
    {
      setComposition(localPAGFile);
      this.pagFile = paramPAGFile;
      if (this.pagFile != null) {
        applyReplacements();
      }
      return;
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
    if ((paramString != null) && (paramString.startsWith("assets://"))) {}
    for (PAGFile localPAGFile = PAGFile.Load(getContext().getAssets(), paramString.substring(9));; localPAGFile = PAGFile.Load(paramString))
    {
      setComposition(localPAGFile);
      this.filePath = paramString;
      if (localPAGFile == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void setProgress(double paramDouble)
  {
    this.pagPlayer.setProgress(paramDouble);
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
    this._isPlaying = false;
    cancelAnimator();
  }
  
  public boolean videoEnabled()
  {
    return this.pagPlayer.videoEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.libpag.PAGView
 * JD-Core Version:    0.7.0.1
 */