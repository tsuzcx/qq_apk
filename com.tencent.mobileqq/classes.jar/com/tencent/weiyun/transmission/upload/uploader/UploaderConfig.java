package com.tencent.weiyun.transmission.upload.uploader;

import android.content.Context;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.AppInfo;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.uploader.IConfig;
import java.io.File;

public class UploaderConfig
  implements IConfig
{
  public static final String APP_NAME_WITH_PLATFORM = "Android-Weiyun-Lite";
  
  public String getCachePath()
  {
    File localFile2 = WeiyunTransmissionGlobal.getInstance().getContext().getExternalCacheDir();
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = WeiyunTransmissionGlobal.getInstance().getContext().getCacheDir();
    }
    return localFile1.getAbsolutePath();
  }
  
  public long getCurrentUin()
  {
    return WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUin();
  }
  
  public int getIsp()
  {
    return WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentIsp();
  }
  
  public String getQUA()
  {
    return WeiyunTransmissionGlobal.getInstance().getAppInfo().qua;
  }
  
  public String getRefer()
  {
    return null;
  }
  
  public int getReportPercent()
  {
    return 0;
  }
  
  public String getTerminal()
  {
    return "Android-Weiyun-Lite";
  }
  
  public String getUserAgent()
  {
    return null;
  }
  
  public String getVersion()
  {
    WeiyunTransmissionGlobal.AppInfo localAppInfo = WeiyunTransmissionGlobal.getInstance().getAppInfo();
    return localAppInfo.versionName + '.' + localAppInfo.versionCode;
  }
  
  public boolean isRdm()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.uploader.UploaderConfig
 * JD-Core Version:    0.7.0.1
 */