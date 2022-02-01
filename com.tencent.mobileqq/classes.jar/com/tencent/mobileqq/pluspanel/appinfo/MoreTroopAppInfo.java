package com.tencent.mobileqq.pluspanel.appinfo;

import agwt;
import ayfu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class MoreTroopAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130842465;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1104864064;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131689488);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    TroopUtils.startTroopAppActivity(paramBaseChatPie.app, paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin, "0");
    agwt.a(paramBaseChatPie.app, "0X8005CB6", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.MoreTroopAppInfo
 * JD-Core Version:    0.7.0.1
 */