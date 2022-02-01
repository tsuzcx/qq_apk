package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class TroopSettingActivity$39
  extends AvatarObserver
{
  TroopSettingActivity$39(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      long l;
      try
      {
        l = Long.valueOf(paramString).longValue();
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        l = 0L;
      }
      if (l != 0L) {
        this.a.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.39
 * JD-Core Version:    0.7.0.1
 */