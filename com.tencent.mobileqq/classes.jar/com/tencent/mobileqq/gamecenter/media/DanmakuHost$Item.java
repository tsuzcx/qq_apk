package com.tencent.mobileqq.gamecenter.media;

import android.graphics.Color;
import android.text.TextUtils;

public class DanmakuHost$Item
{
  public final double a;
  public int a;
  public final long a;
  public final String a;
  public double b;
  public int b;
  
  public DanmakuHost$Item(String paramString, double paramDouble)
  {
    this(paramString, paramDouble, 0.0D, -1, 0);
  }
  
  public DanmakuHost$Item(String paramString, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_a_of_type_Long = ((1000.0D * paramDouble1));
    this.jdField_b_of_type_Double = paramDouble2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public DanmakuHost$Item(String paramString1, double paramDouble1, double paramDouble2, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_a_of_type_Long = ((1000.0D * paramDouble1));
    this.jdField_b_of_type_Double = paramDouble2;
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      this.jdField_a_of_type_Int = Color.parseColor(paramString2);
      label57:
      if (!TextUtils.isEmpty(paramString3)) {}
      try
      {
        this.jdField_b_of_type_Int = Color.parseColor(paramString3);
        return;
      }
      catch (Exception paramString1) {}
    }
    catch (Exception paramString1)
    {
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuHost.Item
 * JD-Core Version:    0.7.0.1
 */