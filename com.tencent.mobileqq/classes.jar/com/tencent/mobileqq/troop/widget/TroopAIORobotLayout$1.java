package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

class TroopAIORobotLayout$1
  implements TroopRobotManager.Callback
{
  TroopAIORobotLayout$1(TroopAIORobotLayout paramTroopAIORobotLayout, int paramInt, String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.GetListDataCallback paramGetListDataCallback) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    boolean bool = true;
    if (paramInt == 0)
    {
      TroopRobotManager localTroopRobotManager = RobotPanelLayoutBase.a();
      if (localTroopRobotManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
        }
        return;
      }
      paramInt = paramRspBody.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("TroopAIORobotLayout", 2, "initData->reqPanelList oldVer:" + this.jdField_a_of_type_Int + " newVer:" + paramInt);
      }
      if ((this.jdField_a_of_type_Int != paramInt) && (paramRspBody.robot_uin.get() == Long.parseLong(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c = this.b;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b = this.c;
        localTroopRobotManager.a(this.b, this.jdField_a_of_type_JavaLangString, paramRspBody);
        paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody);
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(false);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody, true);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b() > 0) {
            TroopAIORobotLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b, localTroopRobotManager, true);
          }
          paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$GetListDataCallback;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b() <= 0) {
            break label468;
          }
        }
      }
      for (;;)
      {
        paramRspBody.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopAIORobotLayout", 2, "listDatas is null in new version");
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAIORobotLayout", 2, "item count == 0");
          }
          byte[] arrayOfByte = localTroopRobotManager.a(this.b, this.jdField_a_of_type_JavaLangString);
          if (arrayOfByte != null) {
            for (;;)
            {
              try
              {
                paramRspBody.mergeFrom(arrayOfByte);
                paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody);
                if ((paramRspBody == null) || (paramRspBody.size() <= 0)) {
                  break label424;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(false);
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody, true);
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c = this.b;
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b = this.c;
              }
              catch (InvalidProtocolBufferMicroException paramRspBody) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("TroopAIORobotLayout", 2, paramRspBody.getMessage());
              break;
              label424:
              if (QLog.isColorLevel()) {
                QLog.d("TroopAIORobotLayout", 2, "listDatas is null");
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopAIORobotLayout", 2, "data is null");
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c();
        break;
        label468:
        bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAIORobotLayout", 2, "initData->reqPanelList: errorCode = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$GetListDataCallback.a(false, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotLayout.1
 * JD-Core Version:    0.7.0.1
 */