package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class TroopAvatarWallPreviewActivity$2
  implements Runnable
{
  TroopAvatarWallPreviewActivity$2(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_");
    ((StringBuilder)localObject).append(this.this$0.mTroopUin);
    localObject = (Setting)localEntityManager.find(Setting.class, ((StringBuilder)localObject).toString());
    localEntityManager.close();
    this.this$0.runOnUiThread(new TroopAvatarWallPreviewActivity.2.1(this, (Setting)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */