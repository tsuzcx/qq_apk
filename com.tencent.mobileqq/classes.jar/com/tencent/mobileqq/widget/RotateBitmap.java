package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class RotateBitmap
{
  private Bitmap a;
  private int b;
  
  public RotateBitmap(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.b = 0;
  }
  
  public RotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    this.a = paramBitmap;
    this.b = (paramInt % 360);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  public Bitmap b()
  {
    return this.a;
  }
  
  public Matrix c()
  {
    Matrix localMatrix = new Matrix();
    if (this.b != 0)
    {
      int i = this.a.getWidth() / 2;
      int j = this.a.getHeight() / 2;
      localMatrix.preTranslate(-i, -j);
      localMatrix.postRotate(this.b);
      localMatrix.postTranslate(f() / 2, e() / 2);
    }
    return localMatrix;
  }
  
  public boolean d()
  {
    return this.b / 90 % 2 != 0;
  }
  
  public int e()
  {
    if (d()) {
      return this.a.getWidth();
    }
    return this.a.getHeight();
  }
  
  public int f()
  {
    if (d()) {
      return this.a.getHeight();
    }
    return this.a.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateBitmap
 * JD-Core Version:    0.7.0.1
 */