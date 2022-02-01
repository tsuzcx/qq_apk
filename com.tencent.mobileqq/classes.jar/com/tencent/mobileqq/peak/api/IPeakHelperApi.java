package com.tencent.mobileqq.peak.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPeakHelperApi
  extends QRouteApi
{
  public abstract String TIMESTAMP();
  
  public abstract String TIMESTAMP_LAST_ACTIVITY();
  
  public abstract void cancelPeakAlive(Context paramContext);
  
  public abstract Class getPublicFragmentActivityForPeakClass();
  
  public abstract boolean isPeakAlive(Context paramContext);
  
  public abstract void preloadPeakProcess(Context paramContext);
  
  public abstract void startWithPublicFragmentActivityForPeak(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2);
  
  public abstract void startWithPublicFragmentActivityForPeakForResult(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.peak.api.IPeakHelperApi
 * JD-Core Version:    0.7.0.1
 */