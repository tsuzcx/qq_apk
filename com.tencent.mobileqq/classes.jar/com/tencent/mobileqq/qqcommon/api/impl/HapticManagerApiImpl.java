package com.tencent.mobileqq.qqcommon.api.impl;

import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.qqcommon.api.IHapticManagerApi;

public class HapticManagerApiImpl
  implements IHapticManagerApi
{
  public void addEffects()
  {
    HapticManager.b().c();
  }
  
  public void pauseEffect(int paramInt)
  {
    HapticManager.b().b(paramInt);
  }
  
  public int playEffect(String paramString, int paramInt)
  {
    return HapticManager.b().a(paramString, paramInt);
  }
  
  public void resumeEffect(int paramInt)
  {
    HapticManager.b().c(paramInt);
  }
  
  public void stopEffect(int paramInt)
  {
    HapticManager.b().d(paramInt);
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    HapticManager.b().a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.impl.HapticManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */