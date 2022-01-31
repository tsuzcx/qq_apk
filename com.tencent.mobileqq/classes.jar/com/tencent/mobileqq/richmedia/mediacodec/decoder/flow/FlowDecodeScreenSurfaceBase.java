package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import avxz;
import avyd;
import avye;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;
import ved;

public class FlowDecodeScreenSurfaceBase
{
  protected int a;
  private avyd jdField_a_of_type_Avyd;
  private avye jdField_a_of_type_Avye = new avxz(this);
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
    ved.b("FlowEdit_FlowDecodeScreenSurfaceBase", "release: ");
    this.jdField_a_of_type_Avyd.b();
    this.jdField_a_of_type_Avyd.c();
  }
  
  public void c()
  {
    ved.b("FlowEdit_FlowDecodeScreenSurfaceBase", "start: ");
    this.jdField_a_of_type_Avyd = new avyd(new WeakReference(this.jdField_a_of_type_Avye));
    this.jdField_a_of_type_Avyd.a();
    this.jdField_a_of_type_Avyd.a(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase
 * JD-Core Version:    0.7.0.1
 */