package com.tencent.qq.effect.alphavideo.videoplayer.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.qq.effect.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

@TargetApi(14)
public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final int DEBUG_CHECK_GL_ERROR = 1;
  public static final int DEBUG_LOG_GL_CALLS = 2;
  private static final boolean LOG_ATTACH_DETACH = false;
  private static final boolean LOG_EGL = false;
  private static final boolean LOG_PAUSE_RESUME = false;
  private static final boolean LOG_RENDERER = false;
  private static final boolean LOG_RENDERER_DRAW_FRAME = false;
  private static final boolean LOG_SURFACE = false;
  private static final boolean LOG_THREADS = false;
  public static final int RENDERMODE_CONTINUOUSLY = 1;
  public static final int RENDERMODE_WHEN_DIRTY = 0;
  private static final String TAG = "GLTextureView";
  private static int sGLESVersion;
  private static final GLTextureView.GLThreadManager sGLThreadManager = new GLTextureView.GLThreadManager(null);
  private Runnable mCheckAlphaTask = new GLTextureView.1(this);
  private int mDebugFlags;
  private boolean mDetached;
  private GLTextureView.EGLConfigChooser mEGLConfigChooser;
  private int mEGLContextClientVersion;
  private GLTextureView.EGLContextFactory mEGLContextFactory;
  private GLTextureView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
  private GLTextureView.GLThread mGLThread;
  private GLTextureView.GLWrapper mGLWrapper;
  private boolean mPreserveEGLContextOnPause;
  private GLSurfaceView.Renderer mRenderer;
  int mSurfaceHeight = 0;
  private boolean mSurfaceTextureAvailable;
  int mSurfaceWidth = 0;
  private final WeakReference<GLTextureView> mThisWeakRef = new WeakReference(this);
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void checkRenderThreadState()
  {
    if (this.mGLThread != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  @SuppressLint({"UseValueOf"})
  public static Integer getInt(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (Integer)paramContext.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(paramContext, new Object[] { new String(paramString), new Integer(paramInt) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return Integer.valueOf(paramInt);
  }
  
  @TargetApi(14)
  private float getViewAlpha()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return getAlpha();
    }
    return 1.0F;
  }
  
  private void init()
  {
    sGLESVersion = getInt(getContext(), "ro.opengles.version", 0).intValue();
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(new GLTextureView.2(this));
  }
  
  @TargetApi(14)
  private void setViewAlpha(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      setAlpha(paramFloat);
      LogUtil.d("GLTextureView", "TextureView setAlpha,alpha:" + paramFloat);
    }
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mGLThread != null) {
        this.mGLThread.requestExitAndWait();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.mDebugFlags;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }
  
  public int getRenderMode()
  {
    return this.mGLThread.getRenderMode();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mDetached) && (this.mRenderer != null)) {
      if (this.mGLThread == null) {
        break label74;
      }
    }
    label74:
    for (int i = this.mGLThread.getRenderMode();; i = 1)
    {
      this.mGLThread = new GLTextureView.GLThread(this.mThisWeakRef);
      if (i != 1) {
        this.mGLThread.setRenderMode(i);
      }
      this.mGLThread.start();
      this.mDetached = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mGLThread != null) {
      this.mGLThread.requestExitAndWait();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    this.mGLThread.onPause();
  }
  
  public void onResume()
  {
    this.mGLThread.onResume();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mSurfaceTextureAvailable = true;
    this.mSurfaceWidth = 0;
    this.mSurfaceHeight = 0;
    Log.d("GLTextureView", "onSurfaceTextureAvailable");
    long l = System.currentTimeMillis();
    surfaceCreated(paramSurfaceTexture);
    postDelayed(this.mCheckAlphaTask, 250L);
    LogUtil.d("GLTextureView", " TextureView onSurfaceTextureAvailable surfaceCreated use:" + (System.currentTimeMillis() - l));
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurfaceTextureAvailable = false;
    Log.d("GLTextureView", "onSurfaceTextureDestroyed");
    surfaceDestroyed(paramSurfaceTexture);
    LogUtil.d("GLTextureView", " TextureView onSurfaceTextureDestroyed");
    setViewAlpha(0.0F);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    Log.d("GLTextureView", "onSurfaceTextureSizeChanged");
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
    LogUtil.d("GLTextureView", " TextureView onSurfaceTextureSizeChanged surfaceChanged use:" + (System.currentTimeMillis() - l));
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void queueEvent(Runnable paramRunnable)
  {
    this.mGLThread.queueEvent(paramRunnable);
  }
  
  public void requestRender()
  {
    this.mGLThread.requestRender();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new GLTextureView.ComponentSizeChooser(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(GLTextureView.EGLConfigChooser paramEGLConfigChooser)
  {
    checkRenderThreadState();
    this.mEGLConfigChooser = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new GLTextureView.SimpleEGLConfigChooser(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
  }
  
  public void setEGLContextFactory(GLTextureView.EGLContextFactory paramEGLContextFactory)
  {
    checkRenderThreadState();
    this.mEGLContextFactory = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(GLTextureView.EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    checkRenderThreadState();
    this.mEGLWindowSurfaceFactory = paramEGLWindowSurfaceFactory;
  }
  
  public void setGLWrapper(GLTextureView.GLWrapper paramGLWrapper)
  {
    this.mGLWrapper = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mGLThread.setRenderMode(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    checkRenderThreadState();
    if (this.mEGLConfigChooser == null) {
      this.mEGLConfigChooser = new GLTextureView.SimpleEGLConfigChooser(this, true);
    }
    if (this.mEGLContextFactory == null) {
      this.mEGLContextFactory = new GLTextureView.DefaultContextFactory(this, null);
    }
    if (this.mEGLWindowSurfaceFactory == null) {
      this.mEGLWindowSurfaceFactory = new GLTextureView.DefaultWindowSurfaceFactory(null);
    }
    this.mRenderer = paramRenderer;
    this.mGLThread = new GLTextureView.GLThread(this.mThisWeakRef);
    this.mGLThread.start();
  }
  
  public void surfaceChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    if ((this.mSurfaceWidth != paramInt2) || (this.mSurfaceHeight != paramInt3))
    {
      this.mSurfaceWidth = paramInt2;
      this.mSurfaceHeight = paramInt3;
      this.mGLThread.onWindowResize(paramInt2, paramInt3);
      LogUtil.d("GLTextureView", " surfaceChanged, onWindowResize");
    }
    removeCallbacks(this.mCheckAlphaTask);
    if ((this.mSurfaceTextureAvailable) && (getViewAlpha() != 1.0F)) {
      setViewAlpha(1.0F);
    }
    LogUtil.d("GLTextureView", " surfaceChanged, w:" + paramInt2 + ",h:" + paramInt3 + " use:" + (System.currentTimeMillis() - l));
  }
  
  public void surfaceCreated(SurfaceTexture paramSurfaceTexture)
  {
    this.mGLThread.surfaceCreated();
  }
  
  public void surfaceDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mGLThread.surfaceDestroyed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.GLTextureView
 * JD-Core Version:    0.7.0.1
 */