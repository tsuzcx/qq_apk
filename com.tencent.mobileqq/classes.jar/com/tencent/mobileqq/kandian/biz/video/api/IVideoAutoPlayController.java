package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVideoAutoPlayController
  extends QRouteApi
{
  public abstract boolean canAutoPlayVideo();
  
  public abstract void initVideoPlaySetting(String paramString);
  
  public abstract boolean isNeedNetWorkAlert();
  
  public abstract boolean isNeedNetWorkAlertForIPC();
  
  public abstract boolean isRefreshingList();
  
  public abstract boolean isWifi();
  
  public abstract void setChannelFrom(long paramLong);
  
  public abstract void setChannelId(int paramInt);
  
  public abstract void setIsRefreshingList(boolean paramBoolean);
  
  public abstract void updateNetworkChange(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
 * JD-Core Version:    0.7.0.1
 */