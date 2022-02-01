package com.tencent.qzonehub.api.utils.impl;

import com.tencent.qzonehub.api.utils.IQZoneHttpDownloadUtil;
import cooperation.qzone.util.QZoneHttpDownloadUtil;
import java.io.File;
import mqq.app.AppRuntime;

public class QZoneHttpDownloadUtilImpl
  implements IQZoneHttpDownloadUtil
{
  public boolean download(AppRuntime paramAppRuntime, String paramString, File paramFile)
  {
    return QZoneHttpDownloadUtil.download(paramAppRuntime, paramString, paramFile);
  }
  
  public String getFilterUrl(String paramString)
  {
    return QZoneHttpDownloadUtil.getFilterUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.impl.QZoneHttpDownloadUtilImpl
 * JD-Core Version:    0.7.0.1
 */