package com.tencent.ttpic.util;

import android.graphics.Color;
import android.text.TextUtils;

public class StrokeUtil
{
  public static float[] parseColor(String paramString)
  {
    float[] arrayOfFloat = new float[4];
    if (!TextUtils.isEmpty(paramString))
    {
      int i;
      try
      {
        i = Color.parseColor(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        i = 0;
      }
      arrayOfFloat[0] = (Color.red(i) / 255.0F);
      arrayOfFloat[1] = (Color.green(i) / 255.0F);
      arrayOfFloat[2] = (Color.blue(i) / 255.0F);
      arrayOfFloat[3] = (Color.alpha(i) / 255.0F);
    }
    return arrayOfFloat;
  }
  
  public static float[] parseRGBAColor(String paramString)
  {
    float[] arrayOfFloat = new float[4];
    if (!TextUtils.isEmpty(paramString))
    {
      int i;
      try
      {
        i = Color.parseColor(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        i = 0;
      }
      int j = i >>> 8;
      arrayOfFloat[0] = (Color.red(j) / 255.0F);
      arrayOfFloat[1] = (Color.green(j) / 255.0F);
      arrayOfFloat[2] = (Color.blue(j) / 255.0F);
      arrayOfFloat[3] = ((i & 0xFF) / 255.0F);
    }
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.StrokeUtil
 * JD-Core Version:    0.7.0.1
 */