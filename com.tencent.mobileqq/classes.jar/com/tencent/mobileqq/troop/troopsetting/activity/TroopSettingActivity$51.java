package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopSettingActivity$51
  implements Runnable
{
  TroopSettingActivity$51(TroopSettingActivity paramTroopSettingActivity, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      ArrayList localArrayList = this.a.getExtras().getStringArrayList("param_admins");
      this.this$0.a(TroopSettingActivity.a(this.this$0), this.this$0.t, localArrayList);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.chatopttroop", 2, localException, new Object[0]);
      }
    }
    this.this$0.aD.post(new TroopSettingActivity.51.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.51
 * JD-Core Version:    0.7.0.1
 */