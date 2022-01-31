package com.tencent.mobileqq.troop.activity;

import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

class TroopAvatarWallEditActivity$4
  implements Runnable
{
  TroopAvatarWallEditActivity$4(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public void run()
  {
    awbw localawbw = this.this$0.app.getEntityManagerFactory().createEntityManager();
    Setting localSetting = (Setting)localawbw.a(Setting.class, "troop_" + this.this$0.a);
    localawbw.a();
    this.this$0.runOnUiThread(new TroopAvatarWallEditActivity.4.1(this, localSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.4
 * JD-Core Version:    0.7.0.1
 */