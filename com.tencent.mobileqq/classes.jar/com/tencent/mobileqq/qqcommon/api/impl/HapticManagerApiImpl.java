package com.tencent.mobileqq.qqcommon.api.impl;

import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.qqcommon.api.IHapticManagerApi;

public class HapticManagerApiImpl
  implements IHapticManagerApi
{
  public void addEffects()
  {
    HapticManager.a().a();
  }
  
  public void pauseEffect(int paramInt)
  {
    HapticManager.a().a(paramInt);
  }
  
  public int playEffect(String paramString, int paramInt)
  {
    return HapticManager.a().a(paramString, paramInt);
  }
  
  public void resumeEffect(int paramInt)
  {
    HapticManager.a().b(paramInt);
  }
  
  public void stopEffect(int paramInt)
  {
    HapticManager.a().c(paramInt);
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    HapticManager.a().a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.impl.HapticManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */