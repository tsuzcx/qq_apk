package com.tencent.mobileqq.uniformdownload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.uniformdownload.util.IGetFileInfoCallBack;

@QAPI(process={"all"})
public abstract interface IUniformDownloadUtil
  extends QRouteApi
{
  public abstract String getApkName(String paramString);
  
  public abstract void getFileInfoOfUrlAsync(String paramString, IGetFileInfoCallBack paramIGetFileInfoCallBack);
  
  public abstract void installAPK(String paramString);
  
  public abstract int openApk(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil
 * JD-Core Version:    0.7.0.1
 */