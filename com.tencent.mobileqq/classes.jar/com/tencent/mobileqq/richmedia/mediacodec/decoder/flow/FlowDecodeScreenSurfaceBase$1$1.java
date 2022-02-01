package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.biz.qqstory.support.logging.SLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class FlowDecodeScreenSurfaceBase$1$1
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  FlowDecodeScreenSurfaceBase$1$1(FlowDecodeScreenSurfaceBase.1 param1) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.jdField_a_of_type_Int;
    arrayOfInt[1] = FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$1.a);
    arrayOfInt[2] = 12344;
    SLog.d("FlowEdit_FlowDecodeScreenSurfaceBase", "createContext, display=%s, config=%s, shaContext=%s", new Object[] { paramEGLDisplay, paramEGLConfig, FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$1.a) });
    EGLContext localEGLContext = FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$1.a);
    if (FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$1.a) != 0) {}
    for (;;)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      arrayOfInt = null;
    }
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      SLog.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
      SLog.c("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
      FlowDecodeScreenSurfaceBase.EglHelper.a("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.1.1
 * JD-Core Version:    0.7.0.1
 */