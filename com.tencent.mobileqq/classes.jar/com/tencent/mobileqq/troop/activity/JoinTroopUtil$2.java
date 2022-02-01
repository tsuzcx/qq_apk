package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class JoinTroopUtil$2
  extends BroadcastReceiver
{
  JoinTroopUtil$2(JoinTroopUtil paramJoinTroopUtil) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction()))
    {
      switch (paramIntent.getIntExtra("ret_action", 1000))
      {
      default: 
        paramContext = this.a;
        JoinTroopUtil.a(paramContext, JoinTroopUtil.a(paramContext).troopUin, 2);
        return;
      case 1004: 
        paramContext = this.a;
        JoinTroopUtil.a(paramContext, JoinTroopUtil.a(paramContext).troopUin, 3);
        return;
      case 1003: 
        paramContext = this.a;
        JoinTroopUtil.a(paramContext, JoinTroopUtil.a(paramContext).troopUin, 1);
        return;
      case 1002: 
        paramContext = this.a;
        JoinTroopUtil.a(paramContext, JoinTroopUtil.a(paramContext).troopUin, 2);
        return;
      case 1001: 
        paramContext = this.a;
        JoinTroopUtil.a(paramContext, JoinTroopUtil.a(paramContext).troopUin, 2);
        return;
      }
      paramContext = this.a;
      JoinTroopUtil.a(paramContext, JoinTroopUtil.a(paramContext).troopUin, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.JoinTroopUtil.2
 * JD-Core Version:    0.7.0.1
 */