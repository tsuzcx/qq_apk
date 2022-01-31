package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import java.util.Random;

public class GLAudioWave
  extends GLImageView
{
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Random jdField_a_of_type_JavaUtilRandom;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private float b;
  private float c;
  private float jdField_d_of_type_Float;
  private RectF jdField_d_of_type_AndroidGraphicsRectF;
  
  private void a(float paramFloat1, float paramFloat2)
  {
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
    int j = (int)paramFloat2;
    float f2 = paramFloat2 - j;
    int i = j;
    if (f2 > 0.0F) {
      i = j + 1;
    }
    paramFloat2 = f1;
    j = 0;
    if (j < i)
    {
      f1 = paramFloat2 - this.jdField_d_of_type_Float;
      this.jdField_d_of_type_AndroidGraphicsRectF.set(paramFloat1, f1, this.c + paramFloat1, paramFloat2);
      super.b(this.jdField_d_of_type_AndroidGraphicsRectF);
      if ((f2 > 0.0F) && (j == i - 1))
      {
        f1 = paramFloat2 - this.jdField_d_of_type_Float * f2;
        this.jdField_d_of_type_AndroidGraphicsRectF.set(paramFloat1, f1, this.c + paramFloat1, paramFloat2);
        super.d(this.jdField_d_of_type_AndroidGraphicsRectF);
        this.i = true;
        super.a();
      }
      for (paramFloat2 = f1;; paramFloat2 = f1)
      {
        paramFloat2 -= this.b;
        j += 1;
        break;
        super.d(this.jdField_d_of_type_AndroidGraphicsRectF);
        super.a();
      }
    }
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
  
  public void a()
  {
    f();
    float f = this.jdField_a_of_type_AndroidGraphicsRectF.left;
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    int j = arrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      a(f, arrayOfFloat[i]);
      f += this.b + this.c;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLAudioWave
 * JD-Core Version:    0.7.0.1
 */