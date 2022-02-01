package com.tencent.mobileqq.webview.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IWebProcessPreload
  extends QRouteApi
{
  public abstract long getBusinessClickTimeMills(String paramString1, String paramString2);
  
  public abstract boolean isPreloadWebProcess();
  
  public abstract boolean isWebProcessExist();
  
  public abstract void preParseDns(@NonNull List<String> paramList, @NonNull String paramString);
  
  public abstract void preloadWebProcess(int paramInt);
  
  public abstract void releaseLightWebProcess();
  
  public abstract void setBusinessClickTimeMills(String paramString1, String paramString2);
  
  public abstract void setPreloadWebProcess(boolean paramBoolean);
  
  public abstract void stopWebCoreService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.IWebProcessPreload
 * JD-Core Version:    0.7.0.1
 */