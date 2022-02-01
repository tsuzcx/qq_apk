package com.tencent.mobileqq.pluspanel.appinfo;

import afcm;
import agwt;
import ayfu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FavoriteAppInfo
  extends PlusPanelAppInfo
{
  public FavoriteAppInfo() {}
  
  public FavoriteAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130844081;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 208;
    }
    return 1104639410;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 509;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130208;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131697909);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramayfu.a("chat_tool_qfav", localQQAppInterface.getCurrentAccountUin());
    paramayfu.b(paramBaseChatPie);
    afcm.b(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo);
    paramBaseChatPie.getActivity().setCanLock(false);
    agwt.a(localQQAppInterface, "0X8005CB1", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.FavoriteAppInfo
 * JD-Core Version:    0.7.0.1
 */