package com.tencent.qg.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public class QGJavaScriptView
  extends SurfaceView
  implements SurfaceHolder.Callback2
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
  private static final String TAG = "EJJavaScriptView";
  protected static final QGJavaScriptView.GLThreadManager sGLThreadManager = new QGJavaScriptView.GLThreadManager(null);
  protected int mDebugFlags;
  protected boolean mDetached;
  protected QGJavaScriptView.EGLConfigChooser mEGLConfigChooser;
  protected int mEGLContextClientVersion;
  protected QGJavaScriptView.EGLContextFactory mEGLContextFactory;
  protected QGJavaScriptView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
  protected QGJavaScriptView.GLThread mGLThread;
  protected QGJavaScriptView.GLWrapper mGLWrapper;
  protected boolean mPreserveEGLContextOnPause;
  protected QGJavaScriptView.Renderer mRenderer;
  protected final WeakReference<QGJavaScriptView> mThisWeakRef = new WeakReference(this);
  protected EGLConfig sharedEGLConfig = null;
  protected EGLContext sharedEGLContext = null;
  
  public QGJavaScriptView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QGJavaScriptView(Context paramContext, AttributeSet paramAttributeSet)
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
  
  public static String getErrorString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0x" + Integer.toHexString(paramInt);
    case 12288: 
      return "EGL_SUCCESS";
    case 12289: 
      return "EGL_NOT_INITIALIZED";
    case 12290: 
      return "EGL_BAD_ACCESS";
    case 12291: 
      return "EGL_BAD_ALLOC";
    case 12292: 
      return "EGL_BAD_ATTRIBUTE";
    case 12293: 
      return "EGL_BAD_CONFIG";
    case 12294: 
      return "EGL_BAD_CONTEXT";
    case 12295: 
      return "EGL_BAD_CURRENT_SURFACE";
    case 12296: 
      return "EGL_BAD_DISPLAY";
    case 12297: 
      return "EGL_BAD_MATCH";
    case 12298: 
      return "EGL_BAD_NATIVE_PIXMAP";
    case 12299: 
      return "EGL_BAD_NATIVE_WINDOW";
    case 12300: 
      return "EGL_BAD_PARAMETER";
    case 12301: 
      return "EGL_BAD_SURFACE";
    }
    return "EGL_CONTEXT_LOST";
  }
  
  private void init()
  {
    getHolder().addCallback(this);
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mGLThread != null)
      {
        Log.e("EJJavaScriptView", "finalize");
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
      this.mGLThread = new QGJavaScriptView.GLThread(this.mThisWeakRef);
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
  
  public int presentRenderbuffer()
  {
    return this.mGLThread.swap();
  }
  
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
    setEGLConfigChooser(new QGJavaScriptView.ComponentSizeChooser(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(QGJavaScriptView.EGLConfigChooser paramEGLConfigChooser)
  {
    checkRenderThreadState();
    this.mEGLConfigChooser = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new QGJavaScriptView.SimpleEGLConfigChooser(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
  }
  
  public void setEGLContextFactory(QGJavaScriptView.EGLContextFactory paramEGLContextFactory)
  {
    checkRenderThreadState();
    this.mEGLContextFactory = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(QGJavaScriptView.EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    checkRenderThreadState();
    this.mEGLWindowSurfaceFactory = paramEGLWindowSurfaceFactory;
  }
  
  public void setGLWrapper(QGJavaScriptView.GLWrapper paramGLWrapper)
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
  
  public void setRenderer(QGJavaScriptView.Renderer paramRenderer)
  {
    checkRenderThreadState();
    if (this.mEGLConfigChooser == null) {
      this.mEGLConfigChooser = new QGJavaScriptView.SimpleEGLConfigChooser(this, true);
    }
    if (this.mEGLContextFactory == null) {
      this.mEGLContextFactory = new QGJavaScriptView.DefaultContextFactory(this, null);
    }
    if (this.mEGLWindowSurfaceFactory == null) {
      this.mEGLWindowSurfaceFactory = new QGJavaScriptView.DefaultWindowSurfaceFactory(null);
    }
    this.mRenderer = paramRenderer;
    this.mGLThread = new QGJavaScriptView.GLThread(this.mThisWeakRef);
    this.mGLThread.start();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mGLThread.onWindowResize(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mGLThread.surfaceCreated();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mGLThread.surfaceDestroyed();
  }
  
  @Deprecated
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceRedrawNeededAsync(SurfaceHolder paramSurfaceHolder, Runnable paramRunnable)
  {
    if (this.mGLThread != null) {
      this.mGLThread.requestRenderAndNotify(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView
 * JD-Core Version:    0.7.0.1
 */