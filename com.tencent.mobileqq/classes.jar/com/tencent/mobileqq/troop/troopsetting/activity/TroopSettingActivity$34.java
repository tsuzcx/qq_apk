package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopSettingActivity$34
  extends TroopShowExternalObserver
{
  TroopSettingActivity$34(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      paramString = this.a;
      QQToast.makeText(paramString, paramString.getString(2131893960), 0).show(this.a.getTitleBarHeight());
      TroopSettingActivity.t(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.34
 * JD-Core Version:    0.7.0.1
 */