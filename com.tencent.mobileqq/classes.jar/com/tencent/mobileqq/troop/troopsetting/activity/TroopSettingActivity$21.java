package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$21
  implements Runnable
{
  TroopSettingActivity$21(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateGridTroopMemberFace,isFinishing() = ");
      localStringBuilder.append(this.this$0.isFinishing());
      QLog.d("Q.chatopttroop", 2, localStringBuilder.toString());
    }
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.21
 * JD-Core Version:    0.7.0.1
 */