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
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
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
    if (isGuildLiveChannel()) {
      return 2130840913;
    }
    if (isGuild()) {
      return 2130840751;
    }
    return 2130839276;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 218;
    }
    return 1200000003;
  }
  
  public String getDTElementId()
  {
    if (isGuild()) {
      return "em_sgrp_aio_plus_shoot";
    }
    return "";
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
    return BaseApplicationImpl.getContext().getString(2131887761);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((!SimpleUIUtil.e()) && (!(paramBaseChatPie instanceof RobotChatPie)) && (!StudyModeManager.h()) && (!((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeBaseChatPieIsGuildChatPie(paramBaseChatPie)))
    {
      int j = paramSessionInfo.a;
      int i = 0;
      if (j == 9501) {
        try
        {
          paramPlusPanelViewModel = SmartDeviceProxyMgr.a(paramBaseChatPie.d, Long.parseLong(paramSessionInfo.b));
          if (paramPlusPanelViewModel != null) {
            i = paramPlusPanelViewModel.productId;
          }
        }
        catch (Exception paramPlusPanelViewModel)
        {
          QLog.d("ShootAppInfo", 1, paramPlusPanelViewModel, new Object[0]);
        }
      } else {
        i = 0;
      }
      paramPlusPanelViewModel = paramBaseChatPie.d;
      PlusPanelUtils.a(paramPlusPanelViewModel, paramBaseChatPie.f, paramBaseChatPie.aX(), paramSessionInfo, i, 0);
      ReportController.b(paramPlusPanelViewModel, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
      if (AnonymousChatHelper.a().a(paramSessionInfo.b)) {
        ReportController.b(paramPlusPanelViewModel, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, paramSessionInfo.b, "", "", "");
      }
    }
    else
    {
      paramBaseChatPie.a(6);
      if (QLog.isColorLevel()) {
        QLog.d("ShootAppInfo", 2, "pluspanel onclick called with plus from simple!");
      }
      if (SimpleUIUtil.e()) {
        ReportController.b(null, "dc00898", "", "", "0X800A114", "0X800A114", 0, 0, "", "", "", "");
      }
      if ((paramBaseChatPie instanceof RobotChatPie)) {
        ReportController.b(null, "dc00898", "", "", "0X800A488", "0X800A488", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShootAppInfo
 * JD-Core Version:    0.7.0.1
 */