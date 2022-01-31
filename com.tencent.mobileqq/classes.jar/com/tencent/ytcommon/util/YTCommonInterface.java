package com.tencent.ytcommon.util;

import android.content.Context;
import com.tencent.ytcommon.auth.Auth;

public class YTCommonInterface
{
  public static int getAuthResult()
  {
    return Auth.getAuthResult();
  }
  
  public static long getEndTime()
  {
    return Auth.getEndTime();
  }
  
  public static String getFailedReason(int paramInt)
  {
    return Auth.getFailedReason(paramInt);
  }
  
  public static String getLicensePath()
  {
    return Auth.getLicensePath();
  }
  
  public static int getVersion()
  {
    return Auth.getVersion();
  }
  
  public static int initAuth(Context paramContext, String paramString, int paramInt)
  {
    return Auth.init(paramContext, paramString, paramInt);
  }
  
  public static int initAuth(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return Auth.init(paramContext, paramString1, paramString2, 0, paramString3);
  }
  
  public static void setLicensePath(String paramString)
  {
    Auth.setLicensePath(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ytcommon.util.YTCommonInterface
 * JD-Core Version:    0.7.0.1
 */