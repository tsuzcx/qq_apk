package com.tencent.qg.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qg.sdk.log.GLog;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public class QGGLSurfaceView
  extends QGJavaScriptView
{
  private static final String TAG = "QGGLSurfaceView";
  private final int QG_SURFACE_WIDTH = 720;
  private float[] gravity = new float[3];
  ModuleEngine mModuleEngine;
  QGJNIBridge mQGBridge;
  QGRenderer mRenderer;
  
  public QGGLSurfaceView(Context paramContext)
  {
    super(paramContext);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public QGGLSurfaceView(Context paramContext, int paramInt1, int paramInt2, EGLContext paramEGLContext, EGLConfig paramEGLConfig, String paramString)
  {
    super(paramContext);
    GLog.d("QGGLSurfaceView", "QGSDKVersion = V%s.%s", new Object[] { "1", "6" });
    this.sharedEGLContext = paramEGLContext;
    this.sharedEGLConfig = paramEGLConfig;
    setEGLContextClientVersion(2);
    int i = paramInt2 * 720 / paramInt1;
    getHolder().setFixedSize(720, i);
    this.mRenderer = new QGRenderer(paramContext, 720, i, paramString);
    this.mRenderer.setParent(this);
    setRenderer(this.mRenderer);
    this.mModuleEngine = new ModuleEngine();
    this.mQGBridge = new QGJNIBridge(getContext(), this.mModuleEngine);
    super.setOnTouchListener(new QGGLSurfaceView.1(this, 720 / paramInt1, i / paramInt2));
    new QGGLSurfaceView.2(this);
  }
  
  public static int getQGSubVersion()
  {
    try
    {
      int i = QGRenderer.nativeGetQGSubVersion();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.e("QGGLSurfaceView", "旧版so找不到子版本号");
    }
    return 0;
  }
  
  public static int getQGVersion()
  {
    try
    {
      int i = QGRenderer.nativeGetQGVersion();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.e("QGGLSurfaceView", "旧版so找不到版本号");
    }
    return 0;
  }
  
  public void addJavaScriptFile(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("QG Warning", "addJavaScriptFile filename is empty");
      return;
    }
    this.mRenderer.nativeAddJavaScriptFile(paramString);
  }
  
  public void addJavaScriptFileFromSDCard(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("QG Warning", "addJavaScriptFileFromSDCard filename is empty");
      return;
    }
    this.mRenderer.nativeAddJavaScriptFileFromSDCard(paramString);
  }
  
  public void clearCached()
  {
    this.mRenderer.clearCache();
  }
  
  public int getCanvasTexture(String paramString)
  {
    if (this.sharedEGLContext == null) {
      Log.e("QGGLSurfaceView", "ERROR::shared context is error!! you need update the EGLContext!!");
    }
    return this.mRenderer.nativeGetSharedTexture(paramString);
  }
  
  public int[] getFaceCanvasTexture()
  {
    return this.mRenderer.nativeGetFaceCanvasTexture();
  }
  
  public ModuleEngine getModuleEngine()
  {
    return this.mModuleEngine;
  }
  
  public QGJNIBridge getQGBridge()
  {
    return this.mQGBridge;
  }
  
  public String getQGBuildTimeStamp()
  {
    return this.mRenderer.nativeGetQGBuildTimeStamp();
  }
  
  public QGRenderer getRenderer()
  {
    return this.mRenderer;
  }
  
  public void loadJavaScriptFile(String paramString)
  {
    if (Thread.currentThread().getId() != this.mGLThread.getId()) {
      throw new RuntimeException("It is not allowed to call loadJS in non-GLThread");
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("QG Warning", "loadJavaScriptFile filename is empty");
      return;
    }
    this.mRenderer.nativeLoadJavaScriptFile(paramString);
  }
  
  public void loadJavaScriptFileFromSDCard(String paramString)
  {
    if (Thread.currentThread().getId() != this.mGLThread.getId()) {
      throw new RuntimeException("It is not allowed to call loadJS in non-GLThread");
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("QG Warning", "loadJavaScriptFile filename is empty");
      return;
    }
    this.mRenderer.nativeLoadJavaScriptFileFromSDCard(paramString);
  }
  
  public void loadOpenDataScriptFile(String paramString)
  {
    if (Thread.currentThread().getId() != this.mGLThread.getId()) {
      throw new RuntimeException("It is not allowed to call loadJS in non-GLThread");
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("QG Warning", "loadOpenDataScriptFile filename is empty");
      return;
    }
    this.mRenderer.nativeLoadOpenDataJavaScriptFile(paramString);
  }
  
  public void loadOpenDataScriptFileFromExternal(String paramString)
  {
    if (Thread.currentThread().getId() != this.mGLThread.getId()) {
      throw new RuntimeException("It is not allowed to call loadJS in non-GLThread");
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      Log.w("QG Warning", "loadOpenDataScriptFileFromExternal filename is empty");
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    this.mRenderer.nativeOnKeyDown(paramInt);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    this.mRenderer.nativeOnKeyUp(paramInt);
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.mRenderer.nativePause();
  }
  
  public void onResume()
  {
    this.mRenderer.nativeResume();
    super.onResume();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void reset()
  {
    this.mRenderer.reset();
    if (this.mQGBridge != null) {
      this.mQGBridge.clearRegisteredEvents();
    }
    if (QGBitmapLoader.etc1TextureHashMap != null) {
      QGBitmapLoader.etc1TextureHashMap.clear();
    }
  }
  
  public void setExtResPath(String paramString)
  {
    QGRenderer localQGRenderer = this.mRenderer;
    QGRenderer.extResPath = paramString;
    this.mRenderer.setExtResPath(paramString);
  }
  
  public void setLimitFrame(int paramInt)
  {
    this.mRenderer.setLimitFrame(paramInt);
  }
  
  public void setModuleEngin(ModuleEngine paramModuleEngine)
  {
    this.mModuleEngine = paramModuleEngine;
    this.mQGBridge = new QGJNIBridge(getContext(), this.mModuleEngine);
  }
  
  public void setOpenDataJsFile(String paramString)
  {
    this.mRenderer.setOpenDataJsFile(paramString);
  }
  
  public void setQGEventListener(QGRenderer.QGEventListener paramQGEventListener)
  {
    if (paramQGEventListener == null)
    {
      this.mRenderer.setOnCanvasCreatedListener(null);
      return;
    }
    this.mRenderer.setOnCanvasCreatedListener(new QGGLSurfaceView.3(this, paramQGEventListener));
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    if (this.mQGBridge != null) {
      this.mQGBridge.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.QGGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */