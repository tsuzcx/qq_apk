package com.tencent.mobileqq.nearby.now.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INowVideoReporter
  extends QRouteApi
{
  public static final String TAG = "dc02676";
  
  public abstract INowVideoReporter LvInd1();
  
  public abstract INowVideoReporter count(int paramInt);
  
  public abstract INowVideoReporter d1(String paramString);
  
  public abstract INowVideoReporter d2(String paramString);
  
  public abstract INowVideoReporter d3(String paramString);
  
  public abstract INowVideoReporter d4(String paramString);
  
  public abstract INowVideoReporter feed_type(String paramString);
  
  public abstract INowVideoReporter feedid(String paramString);
  
  public abstract INowVideoReporter genderInd1();
  
  public abstract String getAnchorUin();
  
  public abstract String getFeedId();
  
  public abstract String getFeedType();
  
  public abstract String getFrom();
  
  public abstract long getPlayTimeBegin();
  
  public abstract int getRePlayCount();
  
  public abstract INowVideoReporter networktype(String paramString);
  
  public abstract INowVideoReporter opIn(int paramInt);
  
  public abstract INowVideoReporter opName(String paramString);
  
  public abstract INowVideoReporter opResult(int paramInt);
  
  public abstract INowVideoReporter opType(String paramString);
  
  public abstract void report(AppInterface paramAppInterface);
  
  public abstract void reportByVideo(AppInterface paramAppInterface);
  
  public abstract void setAnchorUin(String paramString);
  
  public abstract void setFeedId(String paramString);
  
  public abstract void setFeedType(String paramString);
  
  public abstract void setFrom(String paramString);
  
  public abstract void setPlayTimeBegin(long paramLong);
  
  public abstract void setRePlayCount(int paramInt);
  
  public abstract INowVideoReporter source(String paramString);
  
  public abstract INowVideoReporter timelong(String paramString);
  
  public abstract INowVideoReporter toUin(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
 * JD-Core Version:    0.7.0.1
 */