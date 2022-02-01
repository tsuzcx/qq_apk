package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQfileTimeUtils
  extends QRouteApi
{
  public abstract String formatNewRefreshTime(long paramLong);
  
  public abstract String getHistoryGroupByTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQfileTimeUtils
 * JD-Core Version:    0.7.0.1
 */