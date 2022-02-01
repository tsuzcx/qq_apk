package com.tencent.qzonehub.api.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQZoneHttpDownloadUtil
  extends QRouteApi
{
  public abstract boolean download(AppRuntime paramAppRuntime, String paramString, File paramFile);
  
  public abstract String getFilterUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.IQZoneHttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */