package com.tencent.qg.sdk;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public abstract interface QGJavaScriptView$EGLConfigChooser
{
  public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.EGLConfigChooser
 * JD-Core Version:    0.7.0.1
 */