package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopSettingActivity$7
  implements Runnable
{
  TroopSettingActivity$7(TroopSettingActivity paramTroopSettingActivity, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void run()
  {
    ((IBizTroopMemberInfoService)TroopSettingActivity.a(this.this$0).getRuntimeService(IBizTroopMemberInfoService.class, "")).saveHomeworkTroopMemberIdentity(this.this$0.i.troopUin, this.a, this.b, this.c, this.d, this.e);
    this.this$0.i.troopColorNick = this.b;
    this.this$0.i.troopCard = this.b;
    this.this$0.aD.sendEmptyMessage(6);
    if (this.this$0.N != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive HW_TROOP_IDENTITY_CHANGED_EVENT,memberListForCard.size = ");
        ((StringBuilder)localObject).append(this.this$0.N.size());
        QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.this$0;
      ((TroopSettingActivity)localObject).a(((TroopSettingActivity)localObject).N);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */