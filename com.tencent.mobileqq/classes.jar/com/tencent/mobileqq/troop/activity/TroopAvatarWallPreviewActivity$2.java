package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

public class TroopAvatarWallPreviewActivity$2
  implements Runnable
{
  TroopAvatarWallPreviewActivity$2(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    awgf localawgf = this.this$0.app.getEntityManagerFactory().createEntityManager();
    Setting localSetting = (Setting)localawgf.a(Setting.class, "troop_" + this.this$0.a);
    localawgf.a();
    this.this$0.runOnUiThread(new TroopAvatarWallPreviewActivity.2.1(this, localSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */