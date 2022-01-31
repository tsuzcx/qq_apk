package com.tencent.plato.sdk.utils;

import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;

public class Dimension
{
  public static final String TAG = "Dimension";
  private static float dp = 0.0F;
  private static float sp = 0.0F;
  public float percent = (0.0F / 0.0F);
  public float px = (0.0F / 0.0F);
  
  public static double Double(String paramString)
  {
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (Exception paramString) {}
    return 0.0D;
  }
  
  public static float Float(String paramString)
  {
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (Exception paramString) {}
    return 0.0F;
  }
  
  public static int Int(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static Rect calFontStringRect(String paramString, int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setTextSize((int)DeviceInfo.dpToPixel(paramInt));
    Rect localRect = new Rect();
    localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect;
  }
  
  public static float devicePx2RemPx(float paramFloat)
  {
    return paramFloat / DeviceInfo.perRemPx;
  }
  
  public static float devicePx2RemPx(int paramInt)
  {
    return devicePx2RemPx(paramInt * 1.0F);
  }
  
  public static Dimension parse(String paramString)
  {
    paramString = paramString.trim();
    Dimension localDimension = new Dimension();
    if (paramString.endsWith("%")) {
      localDimension.percent = Float(paramString.substring(0, paramString.length() - "%".length()));
    }
    for (;;)
    {
      if (!Float.isNaN(localDimension.px)) {
        localDimension.px = ((int)(localDimension.px + 0.5F));
      }
      return localDimension;
      float f;
      if (paramString.endsWith("vw"))
      {
        f = Float(paramString.substring(0, paramString.length() - "vw".length()));
        localDimension.px = (DeviceInfo.width * f / 100.0F);
      }
      else if (paramString.endsWith("vh"))
      {
        f = Float.parseFloat(paramString.substring(0, paramString.length() - "vh".length()));
        localDimension.px = (DeviceInfo.height * f / 100.0F);
      }
      else if (paramString.endsWith("px"))
      {
        f = Float(paramString.substring(0, paramString.length() - "px".length()));
        localDimension.px = (DeviceInfo.perRemPx * f);
      }
      else if (paramString.endsWith("rem"))
      {
        f = Float(paramString.substring(0, paramString.length() - "rem".length()));
        localDimension.px = (DeviceInfo.perRemPx * f);
      }
      else if ((paramString.endsWith(")")) && (paramString.startsWith("calc(")))
      {
        localDimension.px = CalcParser.calc(paramString.substring("calc(".length(), paramString.length() - ")".length()));
      }
      else
      {
        localDimension.px = Float(paramString);
      }
    }
  }
  
  public static int px2dp(float paramFloat)
  {
    if (dp == 0.0F) {
      dp = TypedValue.applyDimension(1, 1.0F, DeviceInfo.metrics);
    }
    return (int)(paramFloat / dp);
  }
  
  public static int px2sp(float paramFloat)
  {
    if (sp == 0.0F) {
      sp = TypedValue.applyDimension(2, 1.0F, DeviceInfo.metrics);
    }
    return Math.round(paramFloat / sp);
  }
  
  public static int sp2px(int paramInt)
  {
    if (sp == 0.0F) {
      sp = TypedValue.applyDimension(2, 1.0F, DeviceInfo.metrics);
    }
    return (int)(paramInt * sp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.Dimension
 * JD-Core Version:    0.7.0.1
 */