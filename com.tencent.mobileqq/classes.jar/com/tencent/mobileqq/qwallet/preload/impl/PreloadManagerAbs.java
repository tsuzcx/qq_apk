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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
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
    } while (!paramString.equalsIgnoreCase("5G"));
    return 6;
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
    int j = NetworkUtil.a(this.mApp.getApplication());
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label57;
      }
      if (transType2Int(paramString[i]) == j) {
        break;
      }
      i += 1;
    }
    label57:
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadManagerAbs
 * JD-Core Version:    0.7.0.1
 */