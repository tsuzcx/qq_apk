package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ShootAppInfo
  extends PlusPanelAppInfo
{
  ShootAppInfo() {}
  
  public ShootAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839266;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 218;
    }
    return 1200000003;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 513;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130218;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131690897);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((SimpleUIUtil.a()) || ((paramBaseChatPie instanceof RobotChatPie)) || (StudyModeManager.a()))
    {
      paramBaseChatPie.a(Integer.valueOf(6));
      if (QLog.isColorLevel()) {
        QLog.d("ShootAppInfo", 2, "pluspanel onclick called with plus from simple!");
      }
      if (SimpleUIUtil.a()) {
        ReportController.b(null, "dc00898", "", "", "0X800A114", "0X800A114", 0, 0, "", "", "", "");
      }
      if ((paramBaseChatPie instanceof RobotChatPie)) {
        ReportController.b(null, "dc00898", "", "", "0X800A488", "0X800A488", 0, 0, "", "", "", "");
      }
      return;
    }
    int i = 0;
    if (paramSessionInfo.jdField_a_of_type_Int == 9501) {}
    for (;;)
    {
      try
      {
        paramPlusPanelViewModel = SmartDeviceProxyMgr.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString));
        if (paramPlusPanelViewModel != null) {
          i = paramPlusPanelViewModel.productId;
        }
        paramPlusPanelViewModel = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        PlusPanelUtils.a(paramPlusPanelViewModel, paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramBaseChatPie.a(), paramSessionInfo, i, 0);
        ReportController.b(paramPlusPanelViewModel, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
        if (!AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ReportController.b(paramPlusPanelViewModel, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
      catch (Exception paramPlusPanelViewModel)
      {
        QLog.d("ShootAppInfo", 1, paramPlusPanelViewModel, new Object[0]);
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShootAppInfo
 * JD-Core Version:    0.7.0.1
 */