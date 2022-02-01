package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJFastWebVideoPlayerManager
  extends INetInfoHandler, QRouteApi
{
  public abstract void onCreate();
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void setVideoPauseType(ReportConstants.VideoEndType paramVideoEndType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJFastWebVideoPlayerManager
 * JD-Core Version:    0.7.0.1
 */