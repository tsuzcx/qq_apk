package com.tencent.qzonehub.api.utils.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

public class QzoneZipCacheHelperImpl
  implements IQzoneZipCacheHelper
{
  public boolean checkAndDownLoadFileIfNeeded(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack)
  {
    return QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(paramAppInterface, paramString1, paramString2, paramString3, paramInt, paramQzoneZipCacheHelperCallBack);
  }
  
  public String getBasePath(String paramString1, String paramString2)
  {
    return QzoneZipCacheHelper.getBasePath(paramString1, paramString2);
  }
  
  public String[] getFileList(String paramString)
  {
    return QzoneZipCacheHelper.getFileList(paramString);
  }
  
  public String[] getFolderFileNameList(String paramString1, String paramString2)
  {
    return QzoneZipCacheHelper.getFolderFileNameList(paramString1, paramString2);
  }
  
  public String[] getFolderFileNameList(String paramString1, String paramString2, String paramString3)
  {
    return QzoneZipCacheHelper.getFolderFileNameList(paramString1, paramString2, paramString3);
  }
  
  public void unzipFile(String paramString1, String paramString2)
  {
    QzoneZipCacheHelper.unzipFile(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.impl.QzoneZipCacheHelperImpl
 * JD-Core Version:    0.7.0.1
 */