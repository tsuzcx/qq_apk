package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.biz.qqstory.support.logging.SLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class EditorEGLContextFactory
  implements GLSurfaceView.EGLContextFactory
{
  private static int jdField_a_of_type_Int = 12440;
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  
  public EGLContext a()
  {
    SLog.d("FlowEdit_EditorEGLContextFactory", "getEGLContext, %s", new Object[] { this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext });
    return this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  }
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    SLog.d("FlowEdit_EditorEGLContextFactory", "createContext %s", new Object[] { this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext });
    return this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)) {
      SLog.e("FlowEdit_EditorEGLContextFactory", "EditorEGLContextDisplay, display: " + paramEGLDisplay + " context: " + paramEGLContext);
    }
    SLog.d("FlowEdit_EditorEGLContextFactory", "destroyContext, %s", new Object[] { this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext });
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.EditorEGLContextFactory
 * JD-Core Version:    0.7.0.1
 */