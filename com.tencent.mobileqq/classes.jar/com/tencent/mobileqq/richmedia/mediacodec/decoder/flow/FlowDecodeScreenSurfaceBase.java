package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import ahoe;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class FlowDecodeScreenSurfaceBase
{
  protected int a;
  private FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$EglHelper$FakeGLSurfaceView = new ahoe(this);
  private FlowDecodeScreenSurfaceBase.EglHelper jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$EglHelper;
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  protected int b;
  private int c = 2;
  
  FlowDecodeScreenSurfaceBase(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    if (paramEGLContext == null) {
      throw new IllegalArgumentException("eglContext should not be null");
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("both width and height should not be less than 0");
    }
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramEGLContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a()
  {
    SLog.b("FlowEdit_FlowDecodeScreenSurfaceBase", "release: ");
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$EglHelper.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$EglHelper.c();
  }
  
  public void c()
  {
    SLog.b("FlowEdit_FlowDecodeScreenSurfaceBase", "start: ");
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$EglHelper = new FlowDecodeScreenSurfaceBase.EglHelper(new WeakReference(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$EglHelper$FakeGLSurfaceView));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$EglHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$EglHelper.a(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase
 * JD-Core Version:    0.7.0.1
 */