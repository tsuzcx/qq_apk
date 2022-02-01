package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$5
  implements Runnable
{
  TroopSettingActivity$5(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.chatopttroop", 2, "-->preForward--fetch openid timeout");
    }
    TroopSettingActivity localTroopSettingActivity = this.this$0;
    localTroopSettingActivity.n = true;
    localTroopSettingActivity.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */