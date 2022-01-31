package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

public class TroopAvatarWallPreviewActivity$3
  implements Runnable
{
  TroopAvatarWallPreviewActivity$3(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    aukp localaukp = this.this$0.app.getEntityManagerFactory().createEntityManager();
    Setting localSetting = (Setting)localaukp.a(Setting.class, "troop_" + this.this$0.a);
    localaukp.a();
    this.this$0.runOnUiThread(new TroopAvatarWallPreviewActivity.3.1(this, localSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */