package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;

public class GLScoreBoard
  extends GLFrameImage
{
  private int jdField_a_of_type_Int;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private int[] jdField_a_of_type_ArrayOfInt = new int[5];
  private float jdField_b_of_type_Float = 0.25F;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private float c;
  private float jdField_d_of_type_Float = 0.0F;
  private RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private float jdField_e_of_type_Float = 0.0F;
  private RectF jdField_e_of_type_AndroidGraphicsRectF = new RectF();
  private float f;
  private float g;
  
  public GLScoreBoard(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    a(false);
  }
  
  private void i()
  {
    this.jdField_d_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRectF.left - this.jdField_d_of_type_AndroidGraphicsRectF.left);
    this.jdField_e_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRectF.top - this.jdField_d_of_type_AndroidGraphicsRectF.top);
  }
  
  private void j()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      GLImage localGLImage = a(0);
      this.c = (1.0F * localGLImage.b() / localGLImage.c() * this.jdField_a_of_type_AndroidGraphicsRectF.height());
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void s()
  {
    int i = 1;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_d_of_type_AndroidGraphicsRectF.left + this.jdField_d_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_d_of_type_AndroidGraphicsRectF.top + this.jdField_e_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_AndroidGraphicsRectF.left + this.f);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_a_of_type_AndroidGraphicsRectF.top + this.g);
    this.jdField_a_of_type_ArrayOfInt[4] = (this.jdField_a_of_type_Int / 10000);
    int j = this.jdField_a_of_type_Int % 10000;
    this.jdField_a_of_type_ArrayOfInt[3] = (j / 1000);
    j %= 1000;
    this.jdField_a_of_type_ArrayOfInt[2] = (j / 100);
    j %= 100;
    this.jdField_a_of_type_ArrayOfInt[1] = (j / 10);
    this.jdField_a_of_type_ArrayOfInt[0] = (j % 10);
    if (this.jdField_a_of_type_ArrayOfInt[4] == 0) {
      if (this.jdField_a_of_type_ArrayOfInt[3] == 0) {
        if (this.jdField_a_of_type_ArrayOfInt[2] == 0) {
          if (this.jdField_a_of_type_ArrayOfInt[1] != 0) {}
        }
      }
    }
    for (;;)
    {
      float f1 = i * this.c + (i - 1) * this.jdField_b_of_type_Int;
      float f2;
      float f4;
      float f3;
      if (this.jdField_a_of_type_AndroidGraphicsRectF.width() >= f1)
      {
        f2 = this.c;
        f4 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
        f3 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
        f1 = (this.jdField_a_of_type_AndroidGraphicsRectF.width() - f1) / 2.0F + this.jdField_a_of_type_AndroidGraphicsRectF.left - this.jdField_b_of_type_Float * f2;
        j = i;
        label284:
        if (j <= 0) {
          break label522;
        }
        if (j != i) {
          break label513;
        }
      }
      label513:
      for (int k = 0;; k = this.jdField_b_of_type_Int)
      {
        int m = this.jdField_a_of_type_ArrayOfInt[(j - 1)];
        f1 = k + f1;
        this.jdField_e_of_type_AndroidGraphicsRectF.set(f1, f4, f1 + f2, f3);
        super.d(this.jdField_e_of_type_AndroidGraphicsRectF);
        super.b(this.jdField_e_of_type_AndroidGraphicsRectF);
        super.c(m);
        super.a();
        f1 = this.jdField_e_of_type_AndroidGraphicsRectF.right;
        j -= 1;
        break label284;
        f1 = (i - 1) * this.jdField_b_of_type_Int;
        float f5 = (this.jdField_a_of_type_AndroidGraphicsRectF.width() - f1) / i;
        GLImage localGLImage = a(0);
        f1 = 1.0F * localGLImage.c() / localGLImage.b() * f5;
        if (f1 >= this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
        }
        for (f2 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;; f2 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom - f2)
        {
          f4 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
          f3 = f2;
          f2 = f4;
          f4 = f1;
          f1 = f2;
          f2 = f5;
          break;
          f2 = (this.jdField_a_of_type_AndroidGraphicsRectF.height() - f1) / 2.0F;
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.top + f2;
        }
      }
      label522:
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  public void a()
  {
    j();
    s();
  }
  
  public void a(RectF paramRectF)
  {
    if (!this.jdField_a_of_type_AndroidGraphicsRectF.equals(paramRectF))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
      this.f = this.jdField_a_of_type_AndroidGraphicsRectF.width();
      this.g = this.jdField_a_of_type_AndroidGraphicsRectF.height();
    }
    i();
  }
  
  public void a(RectF paramRectF1, RectF paramRectF2)
  {
    this.jdField_d_of_type_AndroidGraphicsRectF.set(paramRectF2);
    a(paramRectF1);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int > 99999) {
      this.jdField_a_of_type_Int = 99999;
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void e(RectF paramRectF)
  {
    this.jdField_d_of_type_AndroidGraphicsRectF.set(paramRectF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLScoreBoard
 * JD-Core Version:    0.7.0.1
 */