package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.qphone.base.util.QLog;

class TroopGiftAnimationController$ToAllGiftAnimationEndListener
  implements FrameSprite.OnFrameEndListener
{
  public int a;
  public long a;
  public long b = 0L;
  public long c = 0L;
  
  TroopGiftAnimationController$ToAllGiftAnimationEndListener(TroopGiftAnimationController paramTroopGiftAnimationController)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a()
  {
    this.c = NetConnInfoCenter.getServerTimeMillis();
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(3000L);
          }
        }
        else
        {
          long l = this.c - this.b;
          if (l >= 2000L) {
            this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(0L);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(2000L - l);
          }
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(3000L);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(0L);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("animation frame end. requestState:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i(".troop.send_giftTroopGiftAnimationController", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.ToAllGiftAnimationEndListener
 * JD-Core Version:    0.7.0.1
 */