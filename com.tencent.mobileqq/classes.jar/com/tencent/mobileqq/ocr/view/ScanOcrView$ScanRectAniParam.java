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
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("currAlpha = ").append(this.e).append("\n").append("currRect = ");
    if (this.jdField_c_of_type_AndroidGraphicsRect != null)
    {
      str = this.jdField_c_of_type_AndroidGraphicsRect.toShortString();
      localStringBuilder2 = localStringBuilder2.append(str).append("\n").append("radomAreaIndex = ").append(this.f).append("\n").append("radomRect = ");
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
        break label182;
      }
      str = this.jdField_a_of_type_AndroidGraphicsRect.toShortString();
      label95:
      localStringBuilder2 = localStringBuilder2.append(str).append("\n").append("gapDuration = ").append(this.jdField_c_of_type_Int).append("\n").append("startRect = ");
      if (this.b == null) {
        break label188;
      }
    }
    label182:
    label188:
    for (String str = this.b.toShortString();; str = "")
    {
      localStringBuilder2.append(str).append("\n").append("edageWidth = ").append(this.jdField_a_of_type_Int).append("\n");
      return localStringBuilder1.toString();
      str = "";
      break;
      str = "";
      break label95;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.ScanRectAniParam
 * JD-Core Version:    0.7.0.1
 */