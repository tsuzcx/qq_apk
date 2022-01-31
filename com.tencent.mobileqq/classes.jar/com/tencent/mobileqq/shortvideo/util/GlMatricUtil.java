package com.tencent.mobileqq.shortvideo.util;

import android.opengl.Matrix;
import java.util.Stack;

public class GlMatricUtil
{
  private Stack jdField_a_of_type_JavaUtilStack = new Stack();
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private float[] b = new float[16];
  private float[] c = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.c, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix.rotateM(this.c, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix.orthoM(this.b, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    Matrix.setLookAtM(this.jdField_a_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }
  
  public float[] a()
  {
    float[] arrayOfFloat = new float[16];
    Matrix.multiplyMM(arrayOfFloat, 0, this.jdField_a_of_type_ArrayOfFloat, 0, this.c, 0);
    Matrix.multiplyMM(arrayOfFloat, 0, this.b, 0, arrayOfFloat, 0);
    return arrayOfFloat;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.c, 0, paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.GlMatricUtil
 * JD-Core Version:    0.7.0.1
 */