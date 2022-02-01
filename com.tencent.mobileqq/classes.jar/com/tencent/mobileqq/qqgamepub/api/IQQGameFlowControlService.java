package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.qqgamepub.data.QQGameFlowControlConfig;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQGameFlowControlService
  extends QRouteApi
{
  public abstract void checkResFlowControl(String paramString, WadlTrpcListener paramWadlTrpcListener);
  
  public abstract void checkResFlowControl(String paramString1, String paramString2, WadlTrpcListener paramWadlTrpcListener);
  
  public abstract QQGameFlowControlConfig getFlowControlConfig(String paramString);
  
  public abstract void saveFlowControlConfig(String paramString, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService
 * JD-Core Version:    0.7.0.1
 */