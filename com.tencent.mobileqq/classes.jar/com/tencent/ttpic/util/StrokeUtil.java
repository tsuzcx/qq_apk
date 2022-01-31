package com.tencent.ttpic.util;

import android.graphics.Color;
import android.text.TextUtils;

public class StrokeUtil
{
  public static float[] parseColor(String paramString)
  {
    float[] arrayOfFloat = new float[4];
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Color.parseColor(paramString);
      arrayOfFloat[0] = (Color.red(i) / 255.0F);
      arrayOfFloat[1] = (Color.green(i) / 255.0F);
      arrayOfFloat[2] = (Color.blue(i) / 255.0F);
      arrayOfFloat[3] = (Color.alpha(i) / 255.0F);
      return arrayOfFloat;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public static float[] parseRGBAColor(String paramString)
  {
    float[] arrayOfFloat = new float[4];
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Color.parseColor(paramString);
      int j = i >>> 8;
      arrayOfFloat[0] = (Color.red(j) / 255.0F);
      arrayOfFloat[1] = (Color.green(j) / 255.0F);
      arrayOfFloat[2] = (Color.blue(j) / 255.0F);
      arrayOfFloat[3] = ((i & 0xFF) / 255.0F);
      return arrayOfFloat;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.StrokeUtil
 * JD-Core Version:    0.7.0.1
 */