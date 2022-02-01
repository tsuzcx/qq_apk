package com.tencent.vas.update.util;

import android.text.TextUtils;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;

public class CommonUtil
{
  public static final String STSTEM_TAG = "VasUpdate_";
  public static int TEST_TYPE;
  public static int sCookieId;
  
  public static int generateCookieId()
  {
    int i = sCookieId + 1;
    sCookieId = i;
    return i;
  }
  
  public static String sComposeItemId(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static long sParseBidId(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString.split("_")[0]);
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sParseBidId error itemId = ");
      localStringBuilder.append(paramString);
      localIVasLog.a("VasUpdate_", localStringBuilder.toString(), localThrowable);
    }
    return 0L;
  }
  
  public static String sParseScid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      String str = paramString.substring(paramString.indexOf("_") + 1);
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sParseScid error itemId = ");
      localStringBuilder.append(paramString);
      localIVasLog.a("VasUpdate_", localStringBuilder.toString(), localThrowable);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.util.CommonUtil
 * JD-Core Version:    0.7.0.1
 */