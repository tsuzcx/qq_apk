package com.tencent.youtu.sdkkitframework.common;

import android.content.Context;

public class YTFetchLicenseHelper
{
  private static String TAG = "YTCommon_FetchLicense";
  
  public YTFetchLicenseHelper.FetchLicenseResult fetchLicenseOnline(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new YTFetchLicenseHelper.1FetchThreadRunnable(this, paramString2, paramString3, paramContext.getPackageName(), paramString1);
    paramString1 = new Thread(paramContext);
    try
    {
      paramString1.start();
      paramString1.join();
    }
    catch (InterruptedException paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramContext.result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YTFetchLicenseHelper
 * JD-Core Version:    0.7.0.1
 */