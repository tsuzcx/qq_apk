package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class TroopSettingActivity$35
  extends TroopOnlineMemberObserver
{
  TroopSettingActivity$35(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((paramBoolean2) && (TroopSettingActivity.a(this.a) != null)) {
        ((ITroopOnlineMemberService)TroopSettingActivity.a(this.a).getRuntimeService(ITroopOnlineMemberService.class, "")).removeDetailOnlineData(this.a.i.troopUin);
      }
    }
    else {
      QQToast.makeText(BaseApplication.getContext(), 2131893879, 0).show(this.a.getTitleBarHeight());
    }
    TroopSettingActivity.u(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.35
 * JD-Core Version:    0.7.0.1
 */