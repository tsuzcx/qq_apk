package com.tencent.mobileqq.pluspanel.appinfo;

import agwt;
import android.content.Intent;
import android.os.Bundle;
import atky;
import ayfu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
    return 2130839165;
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
    return BaseApplicationImpl.getContext().getString(2131693273);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramayfu = new Bundle();
    paramayfu.putInt("forward_type", 23);
    paramayfu.putInt("curent_aio_uin_type", paramSessionInfo.curType);
    paramayfu.putString("curent_aio_uinname", paramSessionInfo.curFriendNick);
    paramayfu.putString("curent_aio_uin", paramSessionInfo.curFriendUin);
    paramayfu.putString("curent_aio_troop_uin", paramSessionInfo.troopUin);
    paramayfu.putBoolean("only_single_selection", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramayfu);
    atky.a(paramBaseChatPie.getActivity(), localIntent, 21);
    agwt.a(paramBaseChatPie.app, "0X80056B3", paramSessionInfo.curType);
    agwt.a(paramBaseChatPie.app, "0X8007010", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.BusinessCardAppInfo
 * JD-Core Version:    0.7.0.1
 */