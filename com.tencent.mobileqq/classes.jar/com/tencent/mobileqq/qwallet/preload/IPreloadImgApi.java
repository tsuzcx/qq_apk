package com.tencent.mobileqq.qwallet.preload;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;

@QAPI(process={"all"})
public abstract interface IPreloadImgApi
  extends QRouteApi
{
  public static final String IMG_SUFFIX = ".png";
  public static final String ZIP_SUFFIX = ".zip";
  
  public abstract void download(AppInterface paramAppInterface, String paramString, IPreloadImgApi.OnSingleDownloadCallback paramOnSingleDownloadCallback);
  
  public abstract void downloadWithSuffix(AppInterface paramAppInterface, String paramString1, String paramString2, IPreloadImgApi.OnSingleDownloadCallback paramOnSingleDownloadCallback);
  
  public abstract Bitmap getBitmap(AppInterface paramAppInterface, String paramString);
  
  public abstract Drawable getDrawableByTheme(AppInterface paramAppInterface, String paramString);
  
  public abstract String getZipFolderPath(AppInterface paramAppInterface, String paramString);
  
  public abstract void onDestory();
  
  public abstract void startDownload(AppInterface paramAppInterface, Set<String> paramSet);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.IPreloadImgApi
 * JD-Core Version:    0.7.0.1
 */