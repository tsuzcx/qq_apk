package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class TencentDocsAppInfo
  extends PlusPanelAppInfo
{
  TencentDocsAppInfo() {}
  
  public TencentDocsAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839292;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 214;
    }
    return 1200000002;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 517;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130214;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698488);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
    paramPlusPanelViewModel.a("chat_tool_tencentdoc", localQQAppInterface.getCurrentAccountUin());
    paramPlusPanelViewModel.b(paramBaseChatPie);
    TeamWorkUtils.a(localQQAppInterface, paramBaseChatPie.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.d);
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {
      AIOPanelUtiles.a(localQQAppInterface, "0X80093F4", paramSessionInfo.jdField_a_of_type_Int);
    }
    do
    {
      return;
      if (paramSessionInfo.jdField_a_of_type_Int == 3000)
      {
        AIOPanelUtiles.a(localQQAppInterface, "0X80093F6", paramSessionInfo.jdField_a_of_type_Int);
        return;
      }
    } while (paramSessionInfo.jdField_a_of_type_Int != 1);
    AIOPanelUtiles.a(localQQAppInterface, "0X80093F8", paramSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TencentDocsAppInfo
 * JD-Core Version:    0.7.0.1
 */