package com.tencent.mobileqq.troop.activity;

import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

class TroopAvatarWallEditActivity$4
  implements Runnable
{
  TroopAvatarWallEditActivity$4(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public void run()
  {
    aukp localaukp = this.this$0.app.getEntityManagerFactory().createEntityManager();
    Setting localSetting = (Setting)localaukp.a(Setting.class, "troop_" + this.this$0.a);
    localaukp.a();
    this.this$0.runOnUiThread(new TroopAvatarWallEditActivity.4.1(this, localSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.4
 * JD-Core Version:    0.7.0.1
 */