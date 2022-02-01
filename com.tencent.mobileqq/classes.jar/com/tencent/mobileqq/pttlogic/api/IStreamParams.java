package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IStreamParams
  extends QRouteApi
{
  public abstract boolean doesSupportStreamPtt(AppRuntime paramAppRuntime);
  
  public abstract int getSliceSize(AppRuntime paramAppRuntime, int paramInt1, int paramInt2);
  
  public abstract void initSliceCfg(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void initSupportCfg(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void release();
  
  public abstract void saveStreamCfg(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void saveStreamSliceCfg(AppRuntime paramAppRuntime, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.IStreamParams
 * JD-Core Version:    0.7.0.1
 */