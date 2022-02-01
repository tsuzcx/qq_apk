package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.qphone.base.util.BaseApplication;

public class MiniAppInfo
  extends PlusPanelAppInfo
{
  MiniAppInfo() {}
  
  public MiniAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839280;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 209;
    }
    return 0;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 520;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130209;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698476);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    AioPanelMiniAppManager.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramBaseChatPie);
    paramPlusPanelViewModel.b(paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.MiniAppInfo
 * JD-Core Version:    0.7.0.1
 */