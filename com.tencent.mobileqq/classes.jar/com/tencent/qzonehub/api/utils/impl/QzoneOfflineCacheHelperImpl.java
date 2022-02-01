package com.tencent.qzonehub.api.utils.impl;

import com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;

public class QzoneOfflineCacheHelperImpl
  implements IQzoneOfflineCacheHelper
{
  public long getSmallGameLastCacheTime(long paramLong)
  {
    return QzoneOfflineCacheHelper.getSmallGameLastCacheTime(paramLong);
  }
  
  public void updataSmallGameLastCacheFinishTime(long paramLong1, long paramLong2)
  {
    QzoneOfflineCacheHelper.updataSmallGameLastCacheFinishTime(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.impl.QzoneOfflineCacheHelperImpl
 * JD-Core Version:    0.7.0.1
 */