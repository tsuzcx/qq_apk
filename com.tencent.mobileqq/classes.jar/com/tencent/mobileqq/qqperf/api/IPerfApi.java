package com.tencent.mobileqq.qqperf.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPerfApi
  extends QRouteApi
{
  public abstract String getDeviceId();
  
  public abstract int getFTSSyncHandlerFtsSyncThreadid();
  
  public abstract long getFTSSyncHandlerThreadTime();
  
  public abstract String getGuardConfigID();
  
  public abstract String getTopActivityName();
  
  public abstract void onActivityDestroyed(Activity paramActivity);
  
  public abstract boolean onQAPMLeakListenerFilter(Object paramObject);
  
  public abstract void startDumpingMemory(String paramString1, String paramString2, long paramLong);
  
  public abstract void startDumpingMemoryLeak(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqperf.api.IPerfApi
 * JD-Core Version:    0.7.0.1
 */