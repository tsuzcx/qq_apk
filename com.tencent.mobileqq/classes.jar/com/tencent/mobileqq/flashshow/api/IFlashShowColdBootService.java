package com.tencent.mobileqq.flashshow.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFlashShowColdBootService
  extends QRouteApi
{
  public abstract void activate();
  
  public abstract String doGetAttachInfo();
  
  public abstract byte[] doGetPreloadRspData();
  
  public abstract void doPreload();
  
  public abstract void inactivate();
  
  public abstract void init();
  
  public abstract boolean isAvailable();
  
  public abstract void release();
  
  public abstract void unlock();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.IFlashShowColdBootService
 * JD-Core Version:    0.7.0.1
 */