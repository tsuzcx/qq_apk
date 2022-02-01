package com.tencent.mobileqq.troop.troopcard.ui;

import android.os.Handler;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.util.Utils;

class TroopInfoActivity$19
  extends AvatarObserver
{
  TroopInfoActivity$19(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (Utils.a(paramString, this.a.f.troopUin))) {
      this.a.J.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.19
 * JD-Core Version:    0.7.0.1
 */