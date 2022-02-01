package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import baew;
import bafa;
import bafb;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;
import xvv;

public class FlowDecodeScreenSurfaceBase
{
  protected int a;
  private bafa jdField_a_of_type_Bafa;
  private bafb jdField_a_of_type_Bafb = new baew(this);
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  protected int b;
  private int c = 2;
  
  protected FlowDecodeScreenSurfaceBase(EGLContext paramEGLContext, int paramInt1, int paramInt2)
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
    xvv.b("FlowEdit_FlowDecodeScreenSurfaceBase", "release: ");
    this.jdField_a_of_type_Bafa.b();
    this.jdField_a_of_type_Bafa.c();
  }
  
  public void c()
  {
    xvv.b("FlowEdit_FlowDecodeScreenSurfaceBase", "start: ");
    this.jdField_a_of_type_Bafa = new bafa(new WeakReference(this.jdField_a_of_type_Bafb));
    this.jdField_a_of_type_Bafa.a();
    this.jdField_a_of_type_Bafa.a(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase
 * JD-Core Version:    0.7.0.1
 */