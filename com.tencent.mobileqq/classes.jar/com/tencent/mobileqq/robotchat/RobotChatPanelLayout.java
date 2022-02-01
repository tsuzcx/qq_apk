package com.tencent.mobileqq.robotchat;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.GetListDataCallback;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelItemData;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelItemInfoData;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class RobotChatPanelLayout
  extends RobotPanelLayoutBase
{
  public RobotChatPanelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RobotChatPanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RobotChatPanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(String paramString1, String paramString2, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, TroopRobotManager paramTroopRobotManager)
  {
    String str = "";
    int i;
    if (paramRobotPanelItemData.jdField_b_of_type_Boolean)
    {
      paramRobotPanelItemData.jdField_b_of_type_Boolean = false;
      paramTroopRobotManager.a();
      i = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.indexOf("content=");
      paramString2 = str;
      if (i > 0) {
        paramString2 = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.substring(i + 8);
      }
      str = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString;
      paramTroopRobotManager = paramString2;
      paramString2 = str;
    }
    for (;;)
    {
      b("1", paramString1, paramTroopRobotManager, paramRobotPanelItemData);
      return paramString2;
      str = paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString;
      paramRobotPanelItemData.jdField_b_of_type_Boolean = true;
      paramTroopRobotManager.a(paramString1, paramString2);
      i = paramRobotPanelItemData.a.c.indexOf("content=");
      if (i > 0)
      {
        paramTroopRobotManager = paramRobotPanelItemData.a.c.substring(i + 8);
        paramString2 = str;
      }
      else
      {
        paramTroopRobotManager = "";
        paramString2 = str;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager == null) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager.a("1", paramString);
          if (paramString == null) {
            break label99;
          }
          try
          {
            cmd0x934.RspBody localRspBody = new cmd0x934.RspBody();
            localRspBody.mergeFrom(paramString);
            paramString = a(localRspBody);
            if ((paramString == null) || (paramString.size() <= 0)) {
              break;
            }
            a(false);
            a(paramString, true);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramString) {}
        } while (!QLog.isColorLevel());
        QLog.d("RobotChatPanelLayout", 2, paramString.getMessage());
        return;
      } while (!QLog.isColorLevel());
      QLog.d("RobotChatPanelLayout", 2, "listDatas is null");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "data is null");
  }
  
  public String a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      paramRobotPanelItemData = null;
    }
    String str;
    do
    {
      return paramRobotPanelItemData;
      str = a(this.jdField_a_of_type_JavaLangString, this.b, paramRobotPanelItemData, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager);
      paramRobotPanelItemData = str;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "talking: " + str);
    return str;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    do
    {
      return;
      a(getContext(), paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "send to robot: " + paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString)
  {
    RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "0X800A48C", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, RobotChatPie paramRobotChatPie, RobotPanelLayoutBase.GetListDataCallback paramGetListDataCallback)
  {
    super.a(paramString1, paramString2, paramRobotChatPie, paramGetListDataCallback);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(paramString1);
        if (l == 0L) {
          continue;
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals(paramString1))) {
          a(false);
        }
        int i = SharedPreUtils.ap(getContext(), "1_" + paramString1);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager.a(l, i, new RobotChatPanelLayout.1(this, l, i, paramString1, paramGetListDataCallback));
        return;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
    }
  }
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    int i = paramRobotPanelItemData.a.c.indexOf("content=");
    if (i > 0) {}
    for (String str = paramRobotPanelItemData.a.c.substring(i + 8);; str = null)
    {
      a(getContext(), paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      a("1", this.jdField_a_of_type_JavaLangString, str, paramRobotPanelItemData);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "send to server: " + paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */