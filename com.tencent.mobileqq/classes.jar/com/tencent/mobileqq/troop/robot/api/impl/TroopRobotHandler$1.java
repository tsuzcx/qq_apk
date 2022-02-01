package com.tencent.mobileqq.troop.robot.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopRobotHandler$1
  extends TroopObserver
{
  TroopRobotHandler$1(TroopRobotHandler paramTroopRobotHandler, String paramString) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(this.a)) && (paramString2.equals("SUBCMD_GET_TROOP_ROBOT_PRIVILEGE")))
    {
      boolean bool;
      if ((paramBoolean) && (paramGroupInfo != null) && (paramGroupInfo.uint32_app_privilege_flag.has()))
      {
        int i = paramGroupInfo.uint32_app_privilege_flag.get();
        if ((0x10000000 & i) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramGroupInfo = (ITroopInfoService)TroopRobotHandler.a(this.b).getRuntimeService(ITroopInfoService.class, "");
        paramString2 = paramGroupInfo.findTroopInfo(this.a);
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = new TroopInfo();
          paramString1.troopuin = this.a;
        }
        long l = i;
        paramString1.dwAppPrivilegeFlag = l;
        paramString1.troopPrivilegeFlag = l;
        paramGroupInfo.saveTroopInfo(paramString1);
      }
      else
      {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleGetTroopRobotPrivilege hasRobot:");
        paramString1.append(bool);
        paramString1.append(", troopuin: ");
        paramString1.append(this.a);
        QLog.i("TroopRobotHandler", 2, paramString1.toString());
      }
      this.b.notifyUI(TroopRobotObserver.b, paramBoolean, new Object[] { this.a, Boolean.valueOf(bool) });
      TroopRobotHandler.b(this.b).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.impl.TroopRobotHandler.1
 * JD-Core Version:    0.7.0.1
 */