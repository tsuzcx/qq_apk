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
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
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
    if (isGuildLiveChannel()) {
      return 2130840918;
    }
    if (isGuild()) {
      return 2130840972;
    }
    return 2130839298;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 217;
    }
    return 1104864054;
  }
  
  public String getDTElementId()
  {
    if (isGuild()) {
      return "em_sgrp_aio_plus_pic";
    }
    return "";
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
    return BaseApplicationImpl.getContext().getString(2131917346);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int i;
    if (paramSessionInfo.a == 9501) {
      try
      {
        paramPlusPanelViewModel = SmartDeviceProxyMgr.a(paramBaseChatPie.d, Long.parseLong(paramSessionInfo.b));
        if (paramPlusPanelViewModel != null) {
          i = paramPlusPanelViewModel.productId;
        }
      }
      catch (Exception paramPlusPanelViewModel)
      {
        QLog.d("PicAppInfo", 1, paramPlusPanelViewModel, new Object[0]);
      }
    } else {
      i = 0;
    }
    if ((!SimpleUIUtil.e()) && (!(paramBaseChatPie instanceof RobotChatPie)) && (!StudyModeManager.h()))
    {
      QQAppInterface localQQAppInterface = paramBaseChatPie.d;
      int j = paramSessionInfo.a;
      Object localObject = null;
      if (j == 9501)
      {
        paramPlusPanelViewModel = new Intent();
        paramPlusPanelViewModel.putExtra("isdevicesupportmultiupload", DeviceMsgChatPie.br ^ true);
        PlusPanelUtils.a(localQQAppInterface, paramBaseChatPie.aX(), paramSessionInfo, null, paramPlusPanelViewModel);
        SmartDeviceReport.a(localQQAppInterface, Long.parseLong(paramSessionInfo.b), "Usr_AIO_SendMsg", 3, 0, i);
      }
      else
      {
        paramPlusPanelViewModel = localObject;
        if (paramSessionInfo.a == 1)
        {
          paramPlusPanelViewModel = localObject;
          if (((HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramSessionInfo.b))
          {
            paramPlusPanelViewModel = new Intent();
            paramPlusPanelViewModel.putExtra("filter_photolist_troopalbum_toolbar", true);
          }
        }
        PlusPanelUtils.a(paramBaseChatPie.aX(), paramSessionInfo, localQQAppInterface, paramPlusPanelViewModel);
      }
      paramPlusPanelViewModel = (ITroopPhotoHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER);
      if ((!TextUtils.isEmpty(paramSessionInfo.b)) && (paramSessionInfo.a == 1)) {
        paramPlusPanelViewModel.a(paramSessionInfo.b, true);
      }
      paramBaseChatPie.aX().setCanLock(false);
      AIOPanelUtiles.a(localQQAppInterface, "0X8004079", paramSessionInfo.a);
      if (paramSessionInfo.a == 9501) {
        SmartDeviceReport.a(localQQAppInterface, Long.parseLong(paramSessionInfo.b), "Usr_AIO_SendMsg", 3, 0, i);
      }
      if (AnonymousChatHelper.a().a(paramSessionInfo.b)) {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, paramSessionInfo.b, "", "", "");
      }
    }
    else
    {
      paramBaseChatPie.a(4);
      if (QLog.isColorLevel()) {
        QLog.d("PicAppInfo", 2, "report() called with plus from simple!");
      }
      if (SimpleUIUtil.e()) {
        ReportController.b(null, "dc00898", "", "", "0X800A113", "0X800A113", 0, 0, "", "", "", "");
      }
      if ((paramBaseChatPie instanceof RobotChatPie)) {
        ReportController.b(null, "dc00898", "", "", "0X800A489", "0X800A489", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.PicAppInfo
 * JD-Core Version:    0.7.0.1
 */