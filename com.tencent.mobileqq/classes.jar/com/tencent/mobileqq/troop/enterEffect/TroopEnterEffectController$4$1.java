package com.tencent.mobileqq.troop.enterEffect;

import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.qphone.base.util.QLog;

class TroopEnterEffectController$4$1
  implements Runnable
{
  TroopEnterEffectController$4$1(TroopEnterEffectController.4 param4, int paramInt, TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download Res isAIO = ");
    localStringBuilder.append(this.c.a.i);
    QLog.d("TroopEnterEffect.Controller", 2, localStringBuilder.toString());
    if (this.c.a.i)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("download Res callback success id = ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" showAnimation");
        QLog.d("TroopEnterEffect.Controller", 2, localStringBuilder.toString());
      }
      this.c.a.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.4.1
 * JD-Core Version:    0.7.0.1
 */