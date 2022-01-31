package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import auye;
import auyi;
import auyj;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;
import urk;

public class FlowDecodeScreenSurfaceBase
{
  protected int a;
  private auyi jdField_a_of_type_Auyi;
  private auyj jdField_a_of_type_Auyj = new auye(this);
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
    urk.b("FlowEdit_FlowDecodeScreenSurfaceBase", "release: ");
    this.jdField_a_of_type_Auyi.b();
    this.jdField_a_of_type_Auyi.c();
  }
  
  public void c()
  {
    urk.b("FlowEdit_FlowDecodeScreenSurfaceBase", "start: ");
    this.jdField_a_of_type_Auyi = new auyi(new WeakReference(this.jdField_a_of_type_Auyj));
    this.jdField_a_of_type_Auyi.a();
    this.jdField_a_of_type_Auyi.a(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase
 * JD-Core Version:    0.7.0.1
 */