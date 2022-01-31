package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import java.util.Random;

public class GLAudioWaveN
  extends GLImageView
{
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private float[] jdField_a_of_type_ArrayOfFloat = new float[15];
  private float b = DisplayUtils.a(2.0F);
  private float c = (this.jdField_a_of_type_ArrayOfFloat.length - 1) * this.b;
  private float jdField_d_of_type_Float = 4.0F * this.b;
  private RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF();
  private float e;
  private float f;
  private float g;
  
  public GLAudioWaveN(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
    int i = (int)paramFloat2;
    float f2 = i;
    float f3 = this.g;
    float f4 = this.b;
    float f5 = i;
    float f6 = this.g;
    this.jdField_d_of_type_AndroidGraphicsRectF.set(paramFloat1, f1 - ((paramFloat2 - f5) * f6 + f2 * (f3 + f4)), this.f + paramFloat1, f1);
    super.d(this.jdField_d_of_type_AndroidGraphicsRectF);
    this.jdField_d_of_type_AndroidGraphicsRectF.set(paramFloat1, f1 - this.e, this.f + paramFloat1, f1);
    super.b(this.jdField_d_of_type_AndroidGraphicsRectF);
    this.i = true;
    super.a();
  }
  
  private void f()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfFloat.length)
    {
      this.jdField_a_of_type_JavaUtilRandom.setSeed(System.nanoTime());
      this.jdField_a_of_type_ArrayOfFloat[i] = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * 5.0F);
      i += 1;
    }
  }
  
  private void g()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.b();
    int j = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.c();
    this.f = ((this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.c) / this.jdField_a_of_type_ArrayOfFloat.length);
    float f1 = j * 1.0F / i;
    float f2 = this.f;
    this.g = Math.min((this.jdField_a_of_type_AndroidGraphicsRectF.height() - this.jdField_d_of_type_Float) / 5.0F, f1 * f2);
    this.e = (this.g * 5.0F + this.jdField_d_of_type_Float);
  }
  
  public void a()
  {
    f();
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    int j = arrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      a(f1, arrayOfFloat[i]);
      f1 += this.b + this.f;
      i += 1;
    }
  }
  
  public void a(RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLAudioWaveN
 * JD-Core Version:    0.7.0.1
 */