package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.support.annotation.NonNull;

public abstract class NickWrapper$TextUnit
{
  private int a;
  private String b;
  
  public NickWrapper$TextUnit(int paramInt, @NonNull String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  abstract float a(@NonNull Paint paramPaint);
  
  String a()
  {
    return this.b;
  }
  
  int b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.NickWrapper.TextUnit
 * JD-Core Version:    0.7.0.1
 */