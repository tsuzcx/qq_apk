package com.tencent.mobileqq.vas.adv.api.impl;

import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;

class SimpleGuardInterface
  implements IGuardInterface
{
  public void onApplicationBackground() {}
  
  public void onApplicationForeground() {}
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.api.impl.SimpleGuardInterface
 * JD-Core Version:    0.7.0.1
 */