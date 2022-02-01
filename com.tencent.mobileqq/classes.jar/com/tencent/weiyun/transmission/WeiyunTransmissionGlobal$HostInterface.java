package com.tencent.weiyun.transmission;

import android.content.SharedPreferences;
import android.net.NetworkInfo;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadType;

public abstract interface WeiyunTransmissionGlobal$HostInterface
{
  public abstract void fetchUploadServerInfo(UploadFile paramUploadFile, UploadType paramUploadType, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback);
  
  public abstract int getCurrentIsp();
  
  public abstract String getCurrentUid();
  
  public abstract long getCurrentUin();
  
  public abstract NetworkInfo getRecentNetworkInfo();
  
  public abstract SharedPreferences getSharedPreferences(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface
 * JD-Core Version:    0.7.0.1
 */