package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PicAppInfo
  extends PlusPanelAppInfo
{
  PicAppInfo() {}
  
  public PicAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839287;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 217;
    }
    return 1104864054;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 511;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130217;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131720011);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int i = 0;
    if (paramSessionInfo.jdField_a_of_type_Int == 9501) {}
    for (;;)
    {
      try
      {
        paramPlusPanelViewModel = SmartDeviceProxyMgr.a(paramBaseChatPie.a, Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString));
        if (paramPlusPanelViewModel != null) {
          i = paramPlusPanelViewModel.productId;
        }
        if ((!SimpleUIUtil.a()) && (!(paramBaseChatPie instanceof RobotChatPie)) && (!StudyModeManager.a())) {
          break;
        }
        paramBaseChatPie.a(Integer.valueOf(4));
        if (QLog.isColorLevel()) {
          QLog.d("PicAppInfo", 2, "report() called with plus from simple!");
        }
        if (SimpleUIUtil.a()) {
          ReportController.b(null, "dc00898", "", "", "0X800A113", "0X800A113", 0, 0, "", "", "", "");
        }
        if ((paramBaseChatPie instanceof RobotChatPie)) {
          ReportController.b(null, "dc00898", "", "", "0X800A489", "0X800A489", 0, 0, "", "", "", "");
        }
        return;
      }
      catch (Exception paramPlusPanelViewModel)
      {
        QLog.d("PicAppInfo", 1, paramPlusPanelViewModel, new Object[0]);
      }
      i = 0;
    }
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
    if (paramSessionInfo.jdField_a_of_type_Int == 9501)
    {
      paramPlusPanelViewModel = new Intent();
      if (!DeviceMsgChatPie.R) {}
      for (boolean bool = true;; bool = false)
      {
        paramPlusPanelViewModel.putExtra("isdevicesupportmultiupload", bool);
        PlusPanelUtils.a(localQQAppInterface, paramBaseChatPie.a(), paramSessionInfo, null, paramPlusPanelViewModel);
        SmartDeviceReport.a(localQQAppInterface, Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i);
        paramPlusPanelViewModel = (TroopHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if ((!TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (paramSessionInfo.jdField_a_of_type_Int == 1)) {
          paramPlusPanelViewModel.d(paramSessionInfo.jdField_a_of_type_JavaLangString, true);
        }
        paramBaseChatPie.a().setCanLock(false);
        AIOPanelUtiles.a(localQQAppInterface, "0X8004079", paramSessionInfo.jdField_a_of_type_Int);
        if (paramSessionInfo.jdField_a_of_type_Int == 9501) {
          SmartDeviceReport.a(localQQAppInterface, Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i);
        }
        if (!AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (((HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramPlusPanelViewModel = new Intent();
      paramPlusPanelViewModel.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    for (;;)
    {
      PlusPanelUtils.a(paramBaseChatPie.a(), paramSessionInfo, localQQAppInterface, paramPlusPanelViewModel);
      break;
      paramPlusPanelViewModel = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.PicAppInfo
 * JD-Core Version:    0.7.0.1
 */