package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Map;

class TroopSettingActivity$40
  extends RoamSettingObserver
{
  TroopSettingActivity$40(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      if (paramMap != null)
      {
        if (this.a.t == null) {
          return;
        }
        if (!paramBoolean)
        {
          if (paramMap.get(this.a.t.troopuin) != null) {
            QQToast.makeText(TroopSettingActivity.a(this.a).getApp(), 1, this.a.getString(2131917580), 0).show(this.a.getTitleBarHeight());
          }
        }
        else
        {
          paramString = (Integer)paramMap.get(this.a.t.troopuin);
          if (paramString != null) {
            this.a.t.troopmask = paramString.intValue();
          }
        }
        this.a.aD.sendEmptyMessage(17);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.40
 * JD-Core Version:    0.7.0.1
 */