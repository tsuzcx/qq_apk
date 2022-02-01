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
    if ((paramObject instanceof Boolean)) {
      return ((Boolean)paramObject).booleanValue();
    }
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    boolean bool1;
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramObject))
      {
        bool1 = bool2;
        if (TextUtils.equals("0", paramObject)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static int getColor(Object paramObject)
  {
    try
    {
      l = Long.valueOf((String)paramObject).longValue();
      l = l << 24 & 0xFF000000 | l >> 8 & 0xFFFFFF;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColor, value = ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", e = ");
      localStringBuilder.append(localException);
      PTSLog.e("PTSValueConvertUtil", localStringBuilder.toString());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColor, value = ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", e = ");
      localStringBuilder.append(localNumberFormatException);
      PTSLog.e("PTSValueConvertUtil", localStringBuilder.toString());
    }
    long l = 0L;
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFloat, value = ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(", e = ");
        localStringBuilder.append(localException);
        PTSLog.e("PTSValueConvertUtil", localStringBuilder.toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getInt, value = ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(", e = ");
        localStringBuilder.append(localException);
        PTSLog.e("PTSValueConvertUtil", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.utils.PTSValueConvertUtil
 * JD-Core Version:    0.7.0.1
 */