package com.tencent.mobileqq.kandian.biz.skin;

import android.graphics.drawable.Drawable;

public class ReadInJoySkinAnimManager$PngWrapper
  implements Comparable<PngWrapper>
{
  public int a;
  public Drawable a;
  public String a;
  
  ReadInJoySkinAnimManager$PngWrapper(String paramString, int paramInt, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public int a(PngWrapper paramPngWrapper)
  {
    int i = this.jdField_a_of_type_Int;
    int j = paramPngWrapper.jdField_a_of_type_Int;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager.PngWrapper
 * JD-Core Version:    0.7.0.1
 */