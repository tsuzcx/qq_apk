package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class GLImageView
  extends GlView
{
  protected GLImage a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  
  public GLImageView(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage = new GLImage();
    f(4);
  }
  
  public RectF a()
  {
    return this.b;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a(paramBitmap);
    this.f = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a();
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a(paramString);
      this.f = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a();
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = super.a();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Boolean = false;
    }
    return bool1;
  }
  
  public RectF a_()
  {
    return this.c;
  }
  
  public GLImage b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage;
  }
  
  public void b(RectF paramRectF)
  {
    if (!this.b.equals(paramRectF))
    {
      this.b.set(paramRectF);
      this.m = false;
      l();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void c(RectF paramRectF)
  {
    if (!this.b.equals(paramRectF))
    {
      this.b.set(paramRectF);
      this.c.set(paramRectF);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void d()
  {
    super.d();
  }
  
  public void d(RectF paramRectF)
  {
    if (!this.c.equals(paramRectF))
    {
      this.c.set(paramRectF);
      this.n = false;
      m();
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLImageView
 * JD-Core Version:    0.7.0.1
 */