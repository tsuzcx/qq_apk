package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class MoreTroopAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130842539;
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
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    TroopUtils.a(paramBaseChatPie.a, paramBaseChatPie.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, "0");
    AIOPanelUtiles.a(paramBaseChatPie.a, "0X8005CB6", paramSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.MoreTroopAppInfo
 * JD-Core Version:    0.7.0.1
 */