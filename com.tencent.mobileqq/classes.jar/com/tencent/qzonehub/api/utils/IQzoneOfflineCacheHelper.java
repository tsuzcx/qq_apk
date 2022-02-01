package com.tencent.qzonehub.api.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneOfflineCacheHelper
  extends QRouteApi
{
  public abstract long getSmallGameLastCacheTime(long paramLong);
  
  public abstract void updataSmallGameLastCacheFinishTime(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper
 * JD-Core Version:    0.7.0.1
 */