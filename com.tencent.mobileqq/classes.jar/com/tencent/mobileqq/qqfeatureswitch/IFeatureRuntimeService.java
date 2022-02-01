package com.tencent.mobileqq.qqfeatureswitch;

import android.content.Context;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IFeatureRuntimeService
  extends IRuntimeService
{
  public abstract FeatureSwitch getFeatureSwitch(String paramString);
  
  public abstract void initSdk(Context paramContext);
  
  public abstract boolean isFeatureSwitchEnable(String paramString);
  
  public abstract boolean isFeatureSwitchEnable(String paramString, boolean paramBoolean);
  
  public abstract void registerFeatureUpdateListener(OnUpdateListener paramOnUpdateListener);
  
  public abstract void unregisterFeatureUpdateListener(OnUpdateListener paramOnUpdateListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
 * JD-Core Version:    0.7.0.1
 */