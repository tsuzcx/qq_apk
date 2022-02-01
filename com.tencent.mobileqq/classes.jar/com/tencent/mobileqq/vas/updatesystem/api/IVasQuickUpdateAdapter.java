package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.vas.update.callback.IHttpDownloader;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IVasQuickUpdateAdapter
  extends QRouteApi
{
  public abstract void downloadItem(AppRuntime paramAppRuntime, long paramLong, String paramString1, String paramString2, CallBacker paramCallBacker);
  
  public abstract String getFileMd5(String paramString);
  
  public abstract IHttpDownloader getHttpDownloader();
  
  public abstract String getUpdateReportAppid();
  
  public abstract boolean isPobingCardExit(int paramInt, String paramString);
  
  public abstract boolean isPobingUpdateEnable();
  
  public abstract void onMusicThemeCleanCache();
  
  public abstract void onThemeComplete(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract void onThemeProgress(String paramString, long paramLong1, long paramLong2);
  
  public abstract boolean patch(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */