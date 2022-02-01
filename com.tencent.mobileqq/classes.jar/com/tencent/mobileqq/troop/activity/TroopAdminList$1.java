package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class TroopAdminList$1
  extends AvatarObserver
{
  TroopAdminList$1(TroopAdminList paramTroopAdminList) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.1
 * JD-Core Version:    0.7.0.1
 */