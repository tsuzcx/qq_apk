package com.tencent.pts.utils;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public final class PTSValueConvertUtil
{
  private static float RPX_TO_DP_RATE = PTSDeviceUtil.getScreenWidthDp() / 750.0F;
  private static final String TAG = "PTSValueConvertUtil";
  
  public static float dp2px(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, Resources.getSystem().getDisplayMetrics()) + 0.5F;
  }
  
  public static boolean getBoolean(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof Boolean)) {
      bool = ((Boolean)paramObject).booleanValue();
    }
    do
    {
      return bool;
      bool = false;
    } while (!(paramObject instanceof String));
    return TextUtils.equals("true", (String)paramObject);
  }
  
  public static int getColor(Object paramObject)
  {
    try
    {
      l = Long.valueOf((String)paramObject).longValue();
      l = (l & 0xFF) << 24 | l >> 8;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        PTSLog.e("PTSValueConvertUtil", "getColor, value = " + paramObject + ", e = " + localNumberFormatException);
        l = 0L;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        PTSLog.e("PTSValueConvertUtil", "getColor, value = " + paramObject + ", e = " + localException);
        long l = 0L;
      }
    }
    PTSLog.i("PTSValueConvertUtil", "getColor, value = " + paramObject + ", res = " + l);
    return (int)l;
  }
  
  public static float getFloat(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).floatValue();
    }
    if ((paramObject instanceof String)) {
      try
      {
        float f = Float.valueOf((String)paramObject).floatValue();
        return f;
      }
      catch (Exception localException)
      {
        PTSLog.e("PTSValueConvertUtil", "getFloat, value = " + paramObject + ", e = " + localException);
      }
    }
    return 0.0F;
  }
  
  public static int getInt(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).intValue();
    }
    if ((paramObject instanceof String)) {
      try
      {
        int i = Integer.valueOf((String)paramObject).intValue();
        return i;
      }
      catch (Exception localException)
      {
        PTSLog.e("PTSValueConvertUtil", "getInt, value = " + paramObject + ", e = " + localException);
      }
    }
    return 0;
  }
  
  public static float getPxValue(String paramString)
  {
    float f1 = 0.0F;
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return 0.0F;
      i = paramString.length();
      if (paramString.endsWith("rpx")) {
        try
        {
          float f2 = dp2px(Float.valueOf(paramString.substring(0, i - 3).trim()).floatValue() * RPX_TO_DP_RATE);
          f1 = f2;
          PTSLog.i("PTSValueConvertUtil", "rpx_to_dp_rate = " + RPX_TO_DP_RATE);
          return f2;
        }
        catch (NumberFormatException paramString)
        {
          PTSLog.e("PTSValueConvertUtil", "getPxValue(), e = ", paramString);
          return f1;
        }
      }
    } while (!paramString.endsWith("px"));
    try
    {
      f1 = dp2px(Float.valueOf(paramString.substring(0, i - 2).trim()).floatValue());
      return f1;
    }
    catch (NumberFormatException paramString)
    {
      PTSLog.e("PTSValueConvertUtil", "getPxValue(), e = ", paramString);
    }
    return 0.0F;
  }
  
  public static String getString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if (paramObject != null) {
      return paramObject.toString();
    }
    return "";
  }
  
  public static float px2dp(float paramFloat)
  {
    return paramFloat / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0F) + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.utils.PTSValueConvertUtil
 * JD-Core Version:    0.7.0.1
 */