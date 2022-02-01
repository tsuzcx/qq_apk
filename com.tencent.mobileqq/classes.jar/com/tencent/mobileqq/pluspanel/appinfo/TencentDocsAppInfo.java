package com.tencent.mobileqq.pluspanel.appinfo;

import agwt;
import ayfu;
import bcvs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
    return 2130839202;
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
    return BaseApplicationImpl.getContext().getString(2131697929);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramayfu.a("chat_tool_tencentdoc", localQQAppInterface.getCurrentAccountUin());
    paramayfu.b(paramBaseChatPie);
    bcvs.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramSessionInfo.curFriendNick);
    if (paramSessionInfo.curType == 0) {
      agwt.a(localQQAppInterface, "0X80093F4", paramSessionInfo.curType);
    }
    do
    {
      return;
      if (paramSessionInfo.curType == 3000)
      {
        agwt.a(localQQAppInterface, "0X80093F6", paramSessionInfo.curType);
        return;
      }
    } while (paramSessionInfo.curType != 1);
    agwt.a(localQQAppInterface, "0X80093F8", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TencentDocsAppInfo
 * JD-Core Version:    0.7.0.1
 */