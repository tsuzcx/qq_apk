package com.tencent.mobileqq.pluspanel.appinfo;

import ahpt;
import ahvi;
import becr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class TencentDocsAppInfo
  extends PlusPanelAppInfo
{
  public TencentDocsAppInfo() {}
  
  public TencentDocsAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839223;
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
    return BaseApplicationImpl.getContext().getString(2131698212);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramahvi.a("chat_tool_tencentdoc", localQQAppInterface.getCurrentAccountUin());
    paramahvi.b(paramBaseChatPie);
    becr.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramSessionInfo.curFriendNick);
    if (paramSessionInfo.curType == 0) {
      ahpt.a(localQQAppInterface, "0X80093F4", paramSessionInfo.curType);
    }
    do
    {
      return;
      if (paramSessionInfo.curType == 3000)
      {
        ahpt.a(localQQAppInterface, "0X80093F6", paramSessionInfo.curType);
        return;
      }
    } while (paramSessionInfo.curType != 1);
    ahpt.a(localQQAppInterface, "0X80093F8", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TencentDocsAppInfo
 * JD-Core Version:    0.7.0.1
 */