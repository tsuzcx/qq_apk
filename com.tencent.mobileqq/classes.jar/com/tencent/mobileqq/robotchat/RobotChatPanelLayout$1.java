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
      if (RobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotChatPanelLayout", 2, "mTroopRobotServive = null");
        }
        return;
      }
      if (paramRspBody.robot_uin.get() != this.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          paramRspBody = new StringBuilder();
          paramRspBody.append("data not match :");
          paramRspBody.append(this.jdField_a_of_type_Long);
          QLog.e("RobotChatPanelLayout", 2, paramRspBody.toString());
        }
        return;
      }
      paramInt = paramRspBody.version.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initData->reqPanelList oldVer:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" newVer:");
        localStringBuilder.append(paramInt);
        QLog.d("RobotChatPanelLayout", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_Int != paramInt)
      {
        RobotChatPanelLayout.b(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout).saveRobotPanelData("1", this.jdField_a_of_type_JavaLangString, paramRspBody);
        paramRspBody = RobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, paramRspBody);
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(false);
          this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(paramRspBody, true);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(true);
          if (QLog.isColorLevel()) {
            QLog.d("RobotChatPanelLayout", 2, "listDatas is null in new version");
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.b() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RobotChatPanelLayout", 2, "item count == 0");
        }
        RobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.c();
      }
      paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$GetListDataCallback;
      if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.b() > 0) {
        bool1 = true;
      }
      paramRspBody.a(bool1, this.jdField_a_of_type_JavaLangString);
      return;
    }
    RobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, this.jdField_a_of_type_JavaLangString);
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.b() > 0) {
      bool1 = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$GetListDataCallback.a(bool1, this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout.1
 * JD-Core Version:    0.7.0.1
 */