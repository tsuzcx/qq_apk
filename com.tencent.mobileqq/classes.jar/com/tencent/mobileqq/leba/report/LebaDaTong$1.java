package com.tencent.mobileqq.leba.report;

import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;

class LebaDaTong$1
  implements IGuardInterface
{
  LebaDaTong$1(LebaDaTong paramLebaDaTong) {}
  
  public void onApplicationBackground() {}
  
  public void onApplicationForeground()
  {
    this.a.b = LebaDaTong.b();
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.report.LebaDaTong.1
 * JD-Core Version:    0.7.0.1
 */