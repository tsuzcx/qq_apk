package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopSettingActivity$3
  extends TroopRobotObserver
{
  TroopSettingActivity$3(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (this.a.i.troopUin != null))
    {
      if (!paramString1.equals(this.a.i.troopUin)) {
        return;
      }
      TroopSettingActivity.a(this.a, true);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    if (this.a.i.troopUin != null)
    {
      if (!((String)localObject).equals(this.a.i.troopUin)) {
        return;
      }
      TroopSettingActivity.a(this.a, true);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<TroopRobotInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RobotMemberFormItem onGetAddedRobots suc:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" retCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" troopuin:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" infos:");
      String str;
      if (paramArrayList == null) {
        str = "null";
      } else {
        str = paramArrayList.toString();
      }
      localStringBuilder.append(str);
      QLog.d("Q.chatopttroop", 2, localStringBuilder.toString());
    }
    this.a.runOnUiThread(new TroopSettingActivity.3.1(this, paramArrayList));
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    if (this.a.i.troopUin != null)
    {
      if (!((String)localObject).equals(this.a.i.troopUin)) {
        return;
      }
      TroopSettingActivity.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */