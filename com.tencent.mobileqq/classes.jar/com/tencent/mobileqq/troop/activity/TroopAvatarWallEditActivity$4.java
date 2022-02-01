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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_");
    ((StringBuilder)localObject).append(this.this$0.a);
    localObject = (Setting)localEntityManager.find(Setting.class, ((StringBuilder)localObject).toString());
    localEntityManager.close();
    this.this$0.runOnUiThread(new TroopAvatarWallEditActivity.4.1(this, (Setting)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.4
 * JD-Core Version:    0.7.0.1
 */