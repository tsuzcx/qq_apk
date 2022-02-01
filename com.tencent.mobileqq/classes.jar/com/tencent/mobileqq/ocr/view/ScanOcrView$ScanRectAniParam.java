package com.tencent.mobileqq.ocr.view;

import android.graphics.Rect;

class ScanOcrView$ScanRectAniParam
{
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect;
  int jdField_c_of_type_Int;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  int d;
  int e;
  int f;
  
  ScanOcrView$ScanRectAniParam()
  {
    this.b = new Rect();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currAlpha = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("currRect = ");
    Object localObject = this.jdField_c_of_type_AndroidGraphicsRect;
    String str = "";
    if (localObject != null) {
      localObject = ((Rect)localObject).toShortString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("\n");
    localStringBuilder.append("radomAreaIndex = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n");
    localStringBuilder.append("radomRect = ");
    localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    if (localObject != null) {
      localObject = ((Rect)localObject).toShortString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("\n");
    localStringBuilder.append("gapDuration = ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("startRect = ");
    Rect localRect = this.b;
    localObject = str;
    if (localRect != null) {
      localObject = localRect.toShortString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("\n");
    localStringBuilder.append("edageWidth = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.ScanRectAniParam
 * JD-Core Version:    0.7.0.1
 */