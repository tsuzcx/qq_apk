package com.tencent.mobileqq.qrscan.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQRScanAbilityApi
  extends QRouteApi
{
  public abstract Bitmap decodeSharpP(String paramString);
  
  public abstract int getEarlyDownBusId(int paramInt);
  
  public abstract String getFriendDisplayNameJustCache(AppRuntime paramAppRuntime, String paramString);
  
  public abstract int getQmcfGpuSupportType();
  
  public abstract int getQmcfGpuSupportTypeWithoutGPURule();
  
  public abstract String getUin(String paramString);
  
  public abstract boolean isMiniCodeDecodeSwitchOn();
  
  public abstract boolean isMiniCodeDetectSwitchOn();
  
  public abstract boolean isQmcfSupport(int paramInt);
  
  public abstract boolean isQmcfSupportGLElseCL(int paramInt);
  
  public abstract boolean isRingEqualsZero(AppRuntime paramAppRuntime);
  
  public abstract boolean isRingerSilent(AppRuntime paramAppRuntime);
  
  public abstract boolean isRingerVibrate(AppRuntime paramAppRuntime);
  
  public abstract boolean isVideoChatting(AppRuntime paramAppRuntime);
  
  public abstract void launchAR(Activity paramActivity, AppRuntime paramAppRuntime, String paramString, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2);
  
  public abstract void reportQBarSoLoadFail(boolean paramBoolean);
  
  public abstract void setTalkbackSwitch();
  
  public abstract void speak(String paramString);
  
  public abstract void startActivity(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
 * JD-Core Version:    0.7.0.1
 */