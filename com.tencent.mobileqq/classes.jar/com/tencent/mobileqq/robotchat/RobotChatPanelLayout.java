package com.tencent.mobileqq.robotchat;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.RobotUtils;
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
  
  private String a(String paramString1, String paramString2, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, ITroopRobotService paramITroopRobotService)
  {
    boolean bool = paramRobotPanelItemData.jdField_b_of_type_Boolean;
    paramITroopRobotService = "";
    int i;
    if (bool)
    {
      paramRobotPanelItemData.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService.closeTalking();
      i = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.indexOf("content=");
      paramString2 = paramITroopRobotService;
      if (i > 0) {
        paramString2 = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.substring(i + 8);
      }
      paramITroopRobotService = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString;
    }
    else
    {
      String str = paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString;
      paramRobotPanelItemData.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService.openTalking(paramString1, paramString2);
      i = paramRobotPanelItemData.a.c.indexOf("content=");
      paramString2 = paramITroopRobotService;
      paramITroopRobotService = str;
      if (i > 0)
      {
        paramString2 = paramRobotPanelItemData.a.c.substring(i + 8);
        paramITroopRobotService = str;
      }
    }
    b("1", paramString1, paramString2, paramRobotPanelItemData);
    return paramITroopRobotService;
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService == null) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService.readRobotPanelData("1", paramString);
    if (paramString != null)
    {
      try
      {
        cmd0x934.RspBody localRspBody = new cmd0x934.RspBody();
        localRspBody.mergeFrom(paramString);
        paramString = a(localRspBody);
        if ((paramString != null) && (paramString.size() > 0))
        {
          a(false);
          a(paramString, true);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("RobotChatPanelLayout", 2, "listDatas is null");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("RobotChatPanelLayout", 2, paramString.getMessage());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("RobotChatPanelLayout", 2, "data is null");
    }
  }
  
  public String a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "mTroopRobotServive = null");
      }
      return null;
    }
    paramRobotPanelItemData = a(this.jdField_a_of_type_JavaLangString, this.b, paramRobotPanelItemData, this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("talking: ");
      localStringBuilder.append(paramRobotPanelItemData);
      QLog.d("RobotChatPanelLayout", 2, localStringBuilder.toString());
    }
    return paramRobotPanelItemData;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "mTroopRobotServive = null");
      }
      return;
    }
    a(getContext(), paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send to robot: ");
      localStringBuilder.append(paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
      QLog.d("RobotChatPanelLayout", 2, localStringBuilder.toString());
    }
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() instanceof QQAppInterface)) {
      RobotUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(), "0X800A48C", this.jdField_a_of_type_JavaLangString, paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, AIOShortcutBarContext paramAIOShortcutBarContext, RobotPanelLayoutBase.GetListDataCallback paramGetListDataCallback)
  {
    super.a(paramString1, paramString2, paramAIOShortcutBarContext, paramGetListDataCallback);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "mTroopRobotServive = null");
      }
      return;
    }
    try
    {
      l = Long.parseLong(paramString1);
    }
    catch (Exception paramString2)
    {
      long l;
      label50:
      int i;
      break label50;
    }
    l = 0L;
    if (l == 0L) {
      return;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals(paramString1))) {
      a(false);
    }
    paramString2 = getContext();
    paramAIOShortcutBarContext = new StringBuilder();
    paramAIOShortcutBarContext.append("1_");
    paramAIOShortcutBarContext.append(paramString1);
    i = SharedPreUtils.ak(paramString2, paramAIOShortcutBarContext.toString());
    this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService.reqPanelList(l, i, new RobotChatPanelLayout.1(this, l, i, paramString1, paramGetListDataCallback));
  }
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "mTroopRobotServive = null");
      }
      return;
    }
    Object localObject = null;
    int i = paramRobotPanelItemData.a.c.indexOf("content=");
    if (i > 0) {
      localObject = paramRobotPanelItemData.a.c.substring(i + 8);
    }
    a(getContext(), paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext);
    a("1", this.jdField_a_of_type_JavaLangString, (String)localObject, paramRobotPanelItemData);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send to server: ");
      ((StringBuilder)localObject).append(paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
      QLog.d("RobotChatPanelLayout", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */