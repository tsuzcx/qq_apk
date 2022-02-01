package com.tencent.mobileqq.stt;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ISttManagerApi
  extends QRouteApi
{
  public abstract int getConfigVersion(AppRuntime paramAppRuntime);
  
  public abstract boolean getSttAbility(AppRuntime paramAppRuntime);
  
  public abstract void initAutoToTextSwitch(AppRuntime paramAppRuntime);
  
  public abstract boolean isSttSession(int paramInt);
  
  public abstract void resetSttAbility();
  
  public abstract void saveConfigVersion(AppRuntime paramAppRuntime, int paramInt);
  
  public abstract void saveSttAbilityV2Config(int paramInt, AppRuntime paramAppRuntime);
  
  public abstract boolean setSttAbility(AppRuntime paramAppRuntime, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stt.ISttManagerApi
 * JD-Core Version:    0.7.0.1
 */