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
    if ((paramContext != null) && (paramString != null)) {
      return Auth.init(paramContext, paramString, paramInt);
    }
    return -1;
  }
  
  public static int initAuth(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramContext != null) && (paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      return Auth.init(paramContext, paramString1, paramString2, 0, paramString3);
    }
    return -1;
  }
  
  public static int initAuthForQQ(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    return Auth.initAuthForQQ(paramContext);
  }
  
  public static void setLicensePath(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Auth.setLicensePath(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.ytcommon.util.YTCommonInterface
 * JD-Core Version:    0.7.0.1
 */