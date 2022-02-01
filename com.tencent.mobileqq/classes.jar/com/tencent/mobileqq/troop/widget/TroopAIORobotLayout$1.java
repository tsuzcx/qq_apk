package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

class TroopAIORobotLayout$1
  implements ITroopRobotService.Callback
{
  TroopAIORobotLayout$1(TroopAIORobotLayout paramTroopAIORobotLayout, int paramInt, String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.GetListDataCallback paramGetListDataCallback) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    boolean bool = false;
    if (paramInt == 0)
    {
      ITroopRobotService localITroopRobotService = RobotPanelLayoutBase.getTroopRobotService();
      if (localITroopRobotService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
        }
        return;
      }
      paramInt = paramRspBody.version.get();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initData->reqPanelList oldVer:");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" newVer:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("TroopAIORobotLayout", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.a != paramInt) && (paramRspBody.robot_uin.get() == Long.parseLong(this.b)))
      {
        localObject = this.f;
        String str1 = this.c;
        ((TroopAIORobotLayout)localObject).f = str1;
        String str2 = this.b;
        ((TroopAIORobotLayout)localObject).a = str2;
        ((TroopAIORobotLayout)localObject).b = this.d;
        localITroopRobotService.saveRobotPanelData(str1, str2, paramRspBody);
        paramRspBody = this.f.a(paramRspBody);
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          this.f.a(false);
          this.f.a(paramRspBody, true);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TroopAIORobotLayout", 2, "listDatas is null in new version");
        }
      }
      else if (this.f.getItemCount() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopAIORobotLayout", 2, "item count == 0");
        }
        localObject = localITroopRobotService.readRobotPanelData(this.c, this.b);
        if (localObject != null)
        {
          try
          {
            paramRspBody.mergeFrom((byte[])localObject);
            paramRspBody = this.f.a(paramRspBody);
            if ((paramRspBody != null) && (paramRspBody.size() > 0))
            {
              this.f.a(false);
              this.f.a(paramRspBody, true);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("TroopAIORobotLayout", 2, "listDatas is null");
            }
            this.f.f = this.c;
            this.f.a = this.b;
            this.f.b = this.d;
          }
          catch (InvalidProtocolBufferMicroException paramRspBody)
          {
            if (!QLog.isColorLevel()) {
              break label421;
            }
          }
          QLog.d("TroopAIORobotLayout", 2, paramRspBody.getMessage());
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TroopAIORobotLayout", 2, "data is null");
        }
      }
      else
      {
        this.f.d();
      }
      label421:
      if (this.f.getItemCount() > 0)
      {
        paramRspBody = this.f;
        TroopAIORobotLayout.a(paramRspBody, paramRspBody.f, this.f.a, this.f.b, localITroopRobotService, true);
      }
      paramRspBody = this.e;
      if (this.f.getItemCount() > 0) {
        bool = true;
      }
      paramRspBody.a(bool, this.f.a);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("initData->reqPanelList: errorCode = ");
      paramRspBody.append(paramInt);
      QLog.d("TroopAIORobotLayout", 2, paramRspBody.toString());
    }
    this.e.a(false, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotLayout.1
 * JD-Core Version:    0.7.0.1
 */