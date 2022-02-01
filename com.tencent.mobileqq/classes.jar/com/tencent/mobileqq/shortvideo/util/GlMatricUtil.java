package com.tencent.mobileqq.shortvideo.util;

import android.opengl.Matrix;
import java.util.Arrays;
import java.util.Stack;

public class GlMatricUtil
{
  private float[] mMatrixCamera = new float[16];
  private float[] mMatrixCurrent = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private float[] mMatrixProjection = new float[16];
  private Stack<float[]> mStack = new Stack();
  
  public void clearStack()
  {
    this.mStack.clear();
  }
  
  public void frustum(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix.frustumM(this.mMatrixProjection, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public float[] getFinalMatrix()
  {
    float[] arrayOfFloat = new float[16];
    Matrix.multiplyMM(arrayOfFloat, 0, this.mMatrixCamera, 0, this.mMatrixCurrent, 0);
    Matrix.multiplyMM(arrayOfFloat, 0, this.mMatrixProjection, 0, arrayOfFloat, 0);
    return arrayOfFloat;
  }
  
  public void ortho(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix.orthoM(this.mMatrixProjection, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public void popMatrix()
  {
    this.mMatrixCurrent = ((float[])this.mStack.pop());
  }
  
  public void pushMatrix()
  {
    this.mStack.push(Arrays.copyOf(this.mMatrixCurrent, 16));
  }
  
  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix.rotateM(this.mMatrixCurrent, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.mMatrixCurrent, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setCamera(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    Matrix.setLookAtM(this.mMatrixCamera, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }
  
  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.mMatrixCurrent, 0, paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.GlMatricUtil
 * JD-Core Version:    0.7.0.1
 */