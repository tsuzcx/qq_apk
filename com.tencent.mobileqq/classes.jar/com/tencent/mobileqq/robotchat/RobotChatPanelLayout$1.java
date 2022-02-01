package com.tencent.mobileqq.robotchat;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService.Callback;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.GetListDataCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

class RobotChatPanelLayout$1
  implements ITroopRobotService.Callback
{
  RobotChatPanelLayout$1(RobotChatPanelLayout paramRobotChatPanelLayout, long paramLong, int paramInt, String paramString, RobotPanelLayoutBase.GetListDataCallback paramGetListDataCallback) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 0)
    {
      if (RobotChatPanelLayout.a(this.e) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotChatPanelLayout", 2, "mTroopRobotServive = null");
        }
        return;
      }
      if (paramRspBody.robot_uin.get() != this.a)
      {
        if (QLog.isColorLevel())
        {
          paramRspBody = new StringBuilder();
          paramRspBody.append("data not match :");
          paramRspBody.append(this.a);
          QLog.e("RobotChatPanelLayout", 2, paramRspBody.toString());
        }
        return;
      }
      paramInt = paramRspBody.version.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initData->reqPanelList oldVer:");
        localStringBuilder.append(this.b);
        localStringBuilder.append(" newVer:");
        localStringBuilder.append(paramInt);
        QLog.d("RobotChatPanelLayout", 2, localStringBuilder.toString());
      }
      if (this.b != paramInt)
      {
        RobotChatPanelLayout.b(this.e).saveRobotPanelData("1", this.c, paramRspBody);
        paramRspBody = RobotChatPanelLayout.a(this.e, paramRspBody);
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          this.e.a(false);
          this.e.a(paramRspBody, true);
        }
        else
        {
          this.e.a(true);
          if (QLog.isColorLevel()) {
            QLog.d("RobotChatPanelLayout", 2, "listDatas is null in new version");
          }
        }
      }
      else if (this.e.getItemCount() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RobotChatPanelLayout", 2, "item count == 0");
        }
        RobotChatPanelLayout.a(this.e, this.c);
      }
      else
      {
        this.e.d();
      }
      paramRspBody = this.d;
      if (this.e.getItemCount() > 0) {
        bool1 = true;
      }
      paramRspBody.a(bool1, this.c);
      return;
    }
    RobotChatPanelLayout.a(this.e, this.c);
    bool1 = bool2;
    if (this.e.getItemCount() > 0) {
      bool1 = true;
    }
    this.d.a(bool1, this.c);
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("initData->reqPanelList: errorCode = ");
      paramRspBody.append(paramInt);
      paramRspBody.append(" hasdata:");
      paramRspBody.append(bool1);
      QLog.d("RobotChatPanelLayout", 2, paramRspBody.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout.1
 * JD-Core Version:    0.7.0.1
 */