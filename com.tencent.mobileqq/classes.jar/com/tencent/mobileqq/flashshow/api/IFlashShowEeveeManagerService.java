package com.tencent.mobileqq.flashshow.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.concurrent.atomic.AtomicInteger;

@QAPI(process={"all"})
public abstract interface IFlashShowEeveeManagerService
  extends QRouteApi
{
  public abstract AtomicInteger getAtomicInteger();
  
  public abstract void onSend(int paramInt, String paramString1, String paramString2);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.IFlashShowEeveeManagerService
 * JD-Core Version:    0.7.0.1
 */