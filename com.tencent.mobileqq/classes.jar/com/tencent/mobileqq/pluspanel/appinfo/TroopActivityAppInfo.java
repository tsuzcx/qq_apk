package com.tencent.mobileqq.pluspanel.appinfo;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopActivityAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130842641;
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
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramPlusPanelViewModel = new Bundle();
    paramPlusPanelViewModel.putString("troop_uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramPlusPanelViewModel.putBoolean("hide_operation_bar", true);
    paramPlusPanelViewModel.putBoolean("hide_more_button", true);
    paramPlusPanelViewModel.putBoolean("isScreenOrientationPortrait", true);
    TroopUtils.a(paramBaseChatPie.a, paramBaseChatPie.a(), paramPlusPanelViewModel);
    AIOPanelUtiles.a(paramBaseChatPie.a, "0X8005CB8", paramSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopActivityAppInfo
 * JD-Core Version:    0.7.0.1
 */