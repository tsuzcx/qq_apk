package com.tencent.mobileqq.pluspanel.appinfo;

import aftr;
import ahpt;
import ahvi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
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
    return 2130844144;
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
    return BaseApplicationImpl.getContext().getString(2131698192);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramahvi.a("chat_tool_qfav", localQQAppInterface.getCurrentAccountUin());
    paramahvi.b(paramBaseChatPie);
    aftr.b(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo);
    paramBaseChatPie.getActivity().setCanLock(false);
    ahpt.a(localQQAppInterface, "0X8005CB1", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.FavoriteAppInfo
 * JD-Core Version:    0.7.0.1
 */