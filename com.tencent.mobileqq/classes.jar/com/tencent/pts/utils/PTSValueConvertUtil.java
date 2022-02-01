package com.tencent.pts.utils;

import android.text.TextUtils;

public final class PTSValueConvertUtil
{
  private static float RPX_TO_DP_RATE = PTSDeviceUtil.getScreenWidthDp() / 750.0F;
  private static final String TAG = "PTSValueConvertUtil";
  
  @Deprecated
  public static float dp2px(float paramFloat)
  {
    return PTSDeviceUtil.dp2px(paramFloat);
  }
  
  public static boolean getBoolean(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof Boolean)) {
      bool = ((Boolean)paramObject).booleanValue();
    }
    while (paramObject == null) {
      return bool;
    }
    if ((!(paramObject instanceof String)) || ((!TextUtils.isEmpty((String)paramObject)) && (!TextUtils.equals("0", (String)paramObject)))) {}
    for (bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int getColor(Object paramObject)
  {
    try
    {
      l = Long.valueOf((String)paramObject).longValue();
      l = l << 24 & 0xFF000000 | l >> 8 & 0xFFFFFF;
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
  
  @Deprecated
  public static float px2dp(float paramFloat)
  {
    return PTSDeviceUtil.px2dp(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.utils.PTSValueConvertUtil
 * JD-Core Version:    0.7.0.1
 */