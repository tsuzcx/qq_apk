package com.tencent.open.temp.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IWebViewOpenSdkApi
  extends QRouteApi
{
  public abstract void cancelDownload(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract Object createDownloadListener(Activity paramActivity, AppRuntime paramAppRuntime, Object paramObject, Intent paramIntent);
  
  public abstract void downloadByDownloadApi(Activity paramActivity, Bundle paramBundle);
  
  public abstract void downloadByUniformDownload(Bundle paramBundle, Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void downloadUrlByUniformDownload(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, Activity paramActivity, String paramString5);
  
  public abstract Object getDownloadInfo(String paramString);
  
  public abstract boolean hasMyAppTask(String paramString);
  
  public abstract void reportDownloadInfo(Context paramContext, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.temp.api.IWebViewOpenSdkApi
 * JD-Core Version:    0.7.0.1
 */