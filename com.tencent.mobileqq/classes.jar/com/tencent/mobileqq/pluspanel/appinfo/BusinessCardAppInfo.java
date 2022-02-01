package com.tencent.mobileqq.pluspanel.appinfo;

import ahpt;
import ahvi;
import android.content.Intent;
import android.os.Bundle;
import aupt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class BusinessCardAppInfo
  extends PlusPanelAppInfo
{
  public BusinessCardAppInfo() {}
  
  public BusinessCardAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839185;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 212;
    }
    return 1104788679;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 519;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130212;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131693453);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramahvi = new Bundle();
    paramahvi.putInt("forward_type", 23);
    paramahvi.putInt("curent_aio_uin_type", paramSessionInfo.curType);
    paramahvi.putString("curent_aio_uinname", paramSessionInfo.curFriendNick);
    paramahvi.putString("curent_aio_uin", paramSessionInfo.curFriendUin);
    paramahvi.putString("curent_aio_troop_uin", paramSessionInfo.troopUin);
    paramahvi.putBoolean("only_single_selection", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramahvi);
    aupt.a(paramBaseChatPie.getActivity(), localIntent, 21);
    ahpt.a(paramBaseChatPie.app, "0X80056B3", paramSessionInfo.curType);
    ahpt.a(paramBaseChatPie.app, "0X8007010", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.BusinessCardAppInfo
 * JD-Core Version:    0.7.0.1
 */