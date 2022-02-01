package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class RotateBitmap
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  public RotateBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Int = 0;
  }
  
  public RotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Int = (paramInt % 360);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Matrix a()
  {
    Matrix localMatrix = new Matrix();
    if (this.jdField_a_of_type_Int != 0)
    {
      int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2;
      int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2;
      localMatrix.preTranslate(-i, -j);
      localMatrix.postRotate(this.jdField_a_of_type_Int);
      localMatrix.postTranslate(c() / 2, b() / 2);
    }
    return localMatrix;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int / 90 % 2 != 0;
  }
  
  public int b()
  {
    if (a()) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  public int c()
  {
    if (a()) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateBitmap
 * JD-Core Version:    0.7.0.1
 */