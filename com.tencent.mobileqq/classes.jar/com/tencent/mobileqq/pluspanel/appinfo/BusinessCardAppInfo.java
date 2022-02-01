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
    return 2130839107;
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
    return BaseApplicationImpl.getContext().getString(2131693561);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramPlusPanelViewModel = new Bundle();
    paramPlusPanelViewModel.putInt("forward_type", 23);
    paramPlusPanelViewModel.putInt("curent_aio_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    paramPlusPanelViewModel.putString("curent_aio_uinname", paramSessionInfo.d);
    paramPlusPanelViewModel.putString("curent_aio_uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramPlusPanelViewModel.putString("curent_aio_troop_uin", paramSessionInfo.b);
    paramPlusPanelViewModel.putBoolean("only_single_selection", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramPlusPanelViewModel);
    ForwardBaseOption.a(paramBaseChatPie.a(), localIntent, 21);
    AIOPanelUtiles.a(paramBaseChatPie.a, "0X80056B3", paramSessionInfo.jdField_a_of_type_Int);
    AIOPanelUtiles.a(paramBaseChatPie.a, "0X8007010", paramSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.BusinessCardAppInfo
 * JD-Core Version:    0.7.0.1
 */