package com.tencent.vas.update.util;

import android.text.TextUtils;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;

public class CommonUtil
{
  public static final String STSTEM_TAG = "VasUpdate_";
  public static int TEST_TYPE = 0;
  public static int sCookieId = 0;
  
  public static int generateCookieId()
  {
    int i = sCookieId + 1;
    sCookieId = i;
    return i;
  }
  
  public static String sComposeItemId(long paramLong, String paramString)
  {
    return paramLong + "_" + paramString;
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
      VasUpdateWrapper.getLog().e("VasUpdate_", "sParseBidId error itemId = " + paramString, localThrowable);
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
      VasUpdateWrapper.getLog().e("VasUpdate_", "sParseScid error itemId = " + paramString, localThrowable);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.util.CommonUtil
 * JD-Core Version:    0.7.0.1
 */