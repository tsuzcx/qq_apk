package com.tencent.qg.sdk;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract interface QGJavaScriptView$Renderer
{
  public abstract void onDrawFrame(GL10 paramGL10);
  
  public abstract void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2);
  
  public abstract void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig);
  
  public abstract void onSurfaceDestroy(GL10 paramGL10);
  
  public abstract void onSurfacePause(GL10 paramGL10);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.Renderer
 * JD-Core Version:    0.7.0.1
 */