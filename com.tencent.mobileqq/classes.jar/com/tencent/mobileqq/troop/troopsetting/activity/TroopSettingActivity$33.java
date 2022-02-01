package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;

class TroopSettingActivity$33
  extends TroopAppObserver
{
  TroopSettingActivity$33(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(oidb_0xe83.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      String str = String.valueOf(paramRspBody.group_id.get());
      if ((this.a.a != null) && (!TextUtils.equals(this.a.a.troopUin, str)))
      {
        if (QLog.isColorLevel())
        {
          paramRspBody = new StringBuilder();
          paramRspBody.append("onGetNewTroopAppList troopUin not match. rsp uin=");
          paramRspBody.append(str);
          paramRspBody.append(", current uin=");
          paramRspBody.append(this.a.a.troopUin);
          QLog.e("Q.chatopttroop", 2, paramRspBody.toString());
        }
        return;
      }
      if (paramInt == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("raymondguo", 2, "game feed service type 1 refresh");
        }
        this.a.a(paramRspBody);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("onGetNewTroopAppList group_id lost. current uin=");
      paramRspBody.append(this.a.a.troopUin);
      QLog.e("Q.chatopttroop", 2, paramRspBody.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.33
 * JD-Core Version:    0.7.0.1
 */