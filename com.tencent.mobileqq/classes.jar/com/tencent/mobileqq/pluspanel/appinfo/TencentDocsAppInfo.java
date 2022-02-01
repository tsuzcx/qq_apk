package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
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
    return 2130839303;
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
    return BaseApplicationImpl.getContext().getString(2131896500);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    paramPlusPanelViewModel.a("chat_tool_tencentdoc", localQQAppInterface.getCurrentAccountUin());
    paramPlusPanelViewModel.b(paramBaseChatPie);
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).gotoAIOTencentDocListWebH5(localQQAppInterface, paramBaseChatPie.aX(), paramSessionInfo.b, paramSessionInfo.a, paramSessionInfo.e);
    if (paramSessionInfo.a == 0)
    {
      AIOPanelUtiles.a(localQQAppInterface, "0X80093F4", paramSessionInfo.a);
      return;
    }
    if (paramSessionInfo.a == 3000)
    {
      AIOPanelUtiles.a(localQQAppInterface, "0X80093F6", paramSessionInfo.a);
      return;
    }
    if (paramSessionInfo.a == 1) {
      AIOPanelUtiles.a(localQQAppInterface, "0X80093F8", paramSessionInfo.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TencentDocsAppInfo
 * JD-Core Version:    0.7.0.1
 */