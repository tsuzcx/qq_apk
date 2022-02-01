package com.tencent.mobileqq.qqlive.api.pendant;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.pendant.PendantInfoCallBack;
import com.tencent.mobileqq.qqlive.listener.pendant.PendantPushListener;
import com.tencent.mobileqq.qqlive.listener.pendant.PendantWebDataPushListener;

public abstract interface IQQLiveModulePendant
  extends IQQLiveModule
{
  public abstract void addFetchPendantInfoListener(PendantInfoCallBack paramPendantInfoCallBack);
  
  public abstract void addPendantPushListener(PendantPushListener paramPendantPushListener);
  
  public abstract void addPendantWebPushListener(PendantWebDataPushListener paramPendantWebDataPushListener);
  
  public abstract void removeFetchPendantInfoListener(PendantInfoCallBack paramPendantInfoCallBack);
  
  public abstract void removePendantPushListener(PendantPushListener paramPendantPushListener);
  
  public abstract void removePendantWebPushListener(PendantWebDataPushListener paramPendantWebDataPushListener);
  
  public abstract void startFetchPendantInfo(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.pendant.IQQLiveModulePendant
 * JD-Core Version:    0.7.0.1
 */