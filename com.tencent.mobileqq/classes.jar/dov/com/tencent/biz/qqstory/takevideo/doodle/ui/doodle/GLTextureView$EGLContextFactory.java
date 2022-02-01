package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public abstract interface GLTextureView$EGLContextFactory
{
  public abstract EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
  
  public abstract void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView.EGLContextFactory
 * JD-Core Version:    0.7.0.1
 */