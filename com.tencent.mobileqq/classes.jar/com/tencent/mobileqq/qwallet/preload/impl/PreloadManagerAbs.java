package com.tencent.mobileqq.qwallet.preload.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.AppRuntime;

public abstract class PreloadManagerAbs
  implements IPreloadServiceAbs
{
  public AppRuntime mApp;
  
  private int transType2Int(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (paramString.equalsIgnoreCase("WiFi")) {
      return 1;
    }
    if (paramString.equalsIgnoreCase("4G")) {
      return 4;
    }
    if (paramString.equalsIgnoreCase("3G")) {
      return 3;
    }
    if (paramString.equalsIgnoreCase("2G")) {
      return 2;
    }
    if (paramString.equalsIgnoreCase("5G")) {
      return 6;
    }
    return 0;
  }
  
  public void getResPath(String paramString, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString;
    getResPath(localDownloadParam, paramOnGetPathListener);
  }
  
  public String getVideoResPathByID(String paramString)
  {
    return null;
  }
  
  public boolean isNetValidToDownload(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = NetworkUtil.getSystemNetwork(this.mApp.getApplication());
    int k = paramString.length;
    int i = 0;
    while (i < k)
    {
      if (transType2Int(paramString[i]) == j) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadManagerAbs
 * JD-Core Version:    0.7.0.1
 */