package com.tencent.mobileqq.intervideo.now.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INowUtil
  extends QRouteApi
{
  public static final String Now_PKG_NAME = "com.tencent.now";
  
  public abstract boolean checkNowApkExist(String paramString1, String paramString2);
  
  public abstract boolean copyNowApkToCommonDir(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean delete(String paramString);
  
  public abstract String getCommonNowPath();
  
  public abstract String getCommonNowTempPath();
  
  public abstract boolean isExists(String paramString);
  
  public abstract boolean isH5Test();
  
  public abstract void pauseNowDownloadInQQ(Context paramContext);
  
  public abstract boolean renameTo(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.api.INowUtil
 * JD-Core Version:    0.7.0.1
 */