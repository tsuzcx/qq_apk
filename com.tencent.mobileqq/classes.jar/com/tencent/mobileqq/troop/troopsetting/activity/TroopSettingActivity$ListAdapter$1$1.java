package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;

class TroopSettingActivity$ListAdapter$1$1
  implements Runnable
{
  TroopSettingActivity$ListAdapter$1$1(TroopSettingActivity.ListAdapter.1 param1, String paramString) {}
  
  public void run()
  {
    if (this.b.d.a.l) {
      return;
    }
    if (!TextUtils.equals(this.b.a.c, this.b.b)) {
      return;
    }
    SpannableString localSpannableString = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.a, 12);
    this.b.c.setText(localSpannableString);
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(TroopSettingActivity.a(this.b.d.a), this.b.c, localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.ListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */