package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class TroopAvatarWallEditActivity$4
  implements Runnable
{
  TroopAvatarWallEditActivity$4(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    Setting localSetting = (Setting)localEntityManager.find(Setting.class, "troop_" + this.this$0.a);
    localEntityManager.close();
    this.this$0.runOnUiThread(new TroopAvatarWallEditActivity.4.1(this, localSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.4
 * JD-Core Version:    0.7.0.1
 */