package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class JoinTroopUtil$2
  extends BroadcastReceiver
{
  JoinTroopUtil$2(JoinTroopUtil paramJoinTroopUtil) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction())) {}
    switch (paramIntent.getIntExtra("ret_action", 1000))
    {
    default: 
      JoinTroopUtil.a(this.a, JoinTroopUtil.a(this.a).troopUin, 2);
      return;
    case 1000: 
      JoinTroopUtil.a(this.a, JoinTroopUtil.a(this.a).troopUin, 2);
      return;
    case 1001: 
      JoinTroopUtil.a(this.a, JoinTroopUtil.a(this.a).troopUin, 2);
      return;
    case 1002: 
      JoinTroopUtil.a(this.a, JoinTroopUtil.a(this.a).troopUin, 2);
      return;
    case 1003: 
      JoinTroopUtil.a(this.a, JoinTroopUtil.a(this.a).troopUin, 1);
      return;
    }
    JoinTroopUtil.a(this.a, JoinTroopUtil.a(this.a).troopUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.JoinTroopUtil.2
 * JD-Core Version:    0.7.0.1
 */