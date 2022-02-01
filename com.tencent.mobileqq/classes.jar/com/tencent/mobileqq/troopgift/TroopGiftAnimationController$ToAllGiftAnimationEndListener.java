package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.qphone.base.util.QLog;

class TroopGiftAnimationController$ToAllGiftAnimationEndListener
  implements FrameSprite.OnFrameEndListener
{
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  
  TroopGiftAnimationController$ToAllGiftAnimationEndListener(TroopGiftAnimationController paramTroopGiftAnimationController) {}
  
  public void a()
  {
    this.d = NetConnInfoCenter.getServerTimeMillis();
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            this.e.a(3000L);
          }
        }
        else
        {
          long l = this.d - this.c;
          if (l >= 2000L) {
            this.e.a(0L);
          } else {
            this.e.a(2000L - l);
          }
        }
      }
      else {
        this.e.a(3000L);
      }
    }
    else {
      this.e.a(0L);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("animation frame end. requestState:");
      localStringBuilder.append(this.a);
      QLog.i(".troop.send_giftTroopGiftAnimationController", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.ToAllGiftAnimationEndListener
 * JD-Core Version:    0.7.0.1
 */