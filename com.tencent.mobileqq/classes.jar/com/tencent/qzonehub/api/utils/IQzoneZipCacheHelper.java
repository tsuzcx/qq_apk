package com.tencent.qzonehub.api.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

@QAPI(process={"all"})
public abstract interface IQzoneZipCacheHelper
  extends QRouteApi
{
  public abstract boolean checkAndDownLoadFileIfNeeded(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack);
  
  public abstract String getBasePath(String paramString1, String paramString2);
  
  public abstract String[] getFileList(String paramString);
  
  public abstract String[] getFolderFileNameList(String paramString1, String paramString2);
  
  public abstract String[] getFolderFileNameList(String paramString1, String paramString2, String paramString3);
  
  public abstract void unzipFile(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper
 * JD-Core Version:    0.7.0.1
 */