package com.tencent.tmassistant.appinfo;

import com.tencent.tmassistant.appinfo.aidl.GetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmdownloader.f;

public class GetAppInfoManager
{
  private static volatile GetAppInfoManager sInstance;
  
  private GetAppInfoManager()
  {
    f.a();
  }
  
  public static GetAppInfoManager get()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new GetAppInfoManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public int requestAppInfo(AppDetailReqParam paramAppDetailReqParam, GetAppInfoCallback paramGetAppInfoCallback)
  {
    return f.a().a(paramAppDetailReqParam, paramGetAppInfoCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.GetAppInfoManager
 * JD-Core Version:    0.7.0.1
 */