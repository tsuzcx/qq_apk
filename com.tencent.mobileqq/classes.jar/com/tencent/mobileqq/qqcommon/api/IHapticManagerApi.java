package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHapticManagerApi
  extends QRouteApi
{
  public abstract void addEffects();
  
  public abstract void pauseEffect(int paramInt);
  
  public abstract int playEffect(String paramString, int paramInt);
  
  public abstract void resumeEffect(int paramInt);
  
  public abstract void stopEffect(int paramInt);
  
  public abstract void update(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.IHapticManagerApi
 * JD-Core Version:    0.7.0.1
 */