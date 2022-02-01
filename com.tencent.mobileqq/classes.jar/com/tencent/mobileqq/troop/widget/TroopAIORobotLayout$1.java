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
      ITroopRobotService localITroopRobotService = RobotPanelLayoutBase.a();
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" newVer:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("TroopAIORobotLayout", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.jdField_a_of_type_Int != paramInt) && (paramRspBody.robot_uin.get() == Long.parseLong(this.jdField_a_of_type_JavaLangString)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout;
        String str1 = this.b;
        ((TroopAIORobotLayout)localObject).c = str1;
        String str2 = this.jdField_a_of_type_JavaLangString;
        ((TroopAIORobotLayout)localObject).jdField_a_of_type_JavaLangString = str2;
        ((TroopAIORobotLayout)localObject).b = this.c;
        localITroopRobotService.saveRobotPanelData(str1, str2, paramRspBody);
        paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody);
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(false);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody, true);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TroopAIORobotLayout", 2, "listDatas is null in new version");
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopAIORobotLayout", 2, "item count == 0");
        }
        localObject = localITroopRobotService.readRobotPanelData(this.b, this.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          try
          {
            paramRspBody.mergeFrom((byte[])localObject);
            paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody);
            if ((paramRspBody != null) && (paramRspBody.size() > 0))
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(false);
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody, true);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("TroopAIORobotLayout", 2, "listDatas is null");
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c = this.b;
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b = this.c;
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
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c();
      }
      label421:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b() > 0)
      {
        paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout;
        TroopAIORobotLayout.a(paramRspBody, paramRspBody.c, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b, localITroopRobotService, true);
      }
      paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$GetListDataCallback;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b() > 0) {
        bool = true;
      }
      paramRspBody.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("initData->reqPanelList: errorCode = ");
      paramRspBody.append(paramInt);
      QLog.d("TroopAIORobotLayout", 2, paramRspBody.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$GetListDataCallback.a(false, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotLayout.1
 * JD-Core Version:    0.7.0.1
 */