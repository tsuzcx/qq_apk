package com.tencent.mobileqq.qqui.tempapi;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQUITempApi
  extends QRouteApi
{
  public abstract boolean isNewVersionDataline();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqui.tempapi.IQQUITempApi
 * JD-Core Version:    0.7.0.1
 */