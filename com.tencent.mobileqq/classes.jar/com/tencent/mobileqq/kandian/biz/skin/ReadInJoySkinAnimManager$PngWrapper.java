package com.tencent.mobileqq.kandian.biz.skin;

import android.graphics.drawable.Drawable;

public class ReadInJoySkinAnimManager$PngWrapper
  implements Comparable<PngWrapper>
{
  public String a;
  public int b;
  public Drawable c;
  
  ReadInJoySkinAnimManager$PngWrapper(String paramString, int paramInt, Drawable paramDrawable)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramDrawable;
  }
  
  public int a(PngWrapper paramPngWrapper)
  {
    int i = this.b;
    int j = paramPngWrapper.b;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager.PngWrapper
 * JD-Core Version:    0.7.0.1
 */