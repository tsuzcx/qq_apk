package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;

class TroopSettingActivity$53
  extends TroopCommonlyUsedObserver
{
  TroopSettingActivity$53(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if ((paramInt2 != 0) && (TextUtils.equals(this.a.a.troopUin, paramString1)))
    {
      if ((!this.a.isFinishing()) && (this.a.isResume()))
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = this.a.getResources().getString(2131694666);
        }
        QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
      }
      TroopSettingActivity.w(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.53
 * JD-Core Version:    0.7.0.1
 */