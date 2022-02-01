package com.tencent.mobileqq.teamwork.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITempGetProfileDetailProcessorProxy
  extends QRouteApi
{
  public abstract void getTencentDocSwitch(AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITempGetProfileDetailProcessorProxy
 * JD-Core Version:    0.7.0.1
 */