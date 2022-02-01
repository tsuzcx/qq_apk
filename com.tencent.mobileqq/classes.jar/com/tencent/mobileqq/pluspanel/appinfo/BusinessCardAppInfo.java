package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.BaseApplication;

public class BusinessCardAppInfo
  extends PlusPanelAppInfo
{
  BusinessCardAppInfo() {}
  
  public BusinessCardAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839263;
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
    return BaseApplicationImpl.getContext().getString(2131891125);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramPlusPanelViewModel = new Bundle();
    paramPlusPanelViewModel.putInt("forward_type", 23);
    paramPlusPanelViewModel.putInt("curent_aio_uin_type", paramSessionInfo.a);
    paramPlusPanelViewModel.putString("curent_aio_uinname", paramSessionInfo.e);
    paramPlusPanelViewModel.putString("curent_aio_uin", paramSessionInfo.b);
    paramPlusPanelViewModel.putString("curent_aio_troop_uin", paramSessionInfo.c);
    paramPlusPanelViewModel.putBoolean("only_single_selection", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramPlusPanelViewModel);
    ForwardBaseOption.a(paramBaseChatPie.aX(), localIntent, 21);
    AIOPanelUtiles.a(paramBaseChatPie.d, "0X80056B3", paramSessionInfo.a);
    AIOPanelUtiles.a(paramBaseChatPie.d, "0X8007010", paramSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.BusinessCardAppInfo
 * JD-Core Version:    0.7.0.1
 */