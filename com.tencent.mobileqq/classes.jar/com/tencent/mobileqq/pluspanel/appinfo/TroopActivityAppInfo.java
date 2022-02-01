package com.tencent.mobileqq.pluspanel.appinfo;

import ahpt;
import ahvi;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopActivityAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130842496;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1101678813;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131689489);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramahvi = new Bundle();
    paramahvi.putString("troop_uin", paramSessionInfo.curFriendUin);
    paramahvi.putBoolean("hide_operation_bar", true);
    paramahvi.putBoolean("hide_more_button", true);
    paramahvi.putBoolean("isScreenOrientationPortrait", true);
    TroopUtils.startTroopAppActivityActivity(paramBaseChatPie.app, paramBaseChatPie.getActivity(), paramahvi);
    ahpt.a(paramBaseChatPie.app, "0X8005CB8", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopActivityAppInfo
 * JD-Core Version:    0.7.0.1
 */