package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class FileAppInfo
  extends PlusPanelAppInfo
{
  FileAppInfo() {}
  
  public FileAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    Object localObject = (SmartDeviceProxyMgr)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    long l;
    try
    {
      l = Long.parseLong(paramSessionInfo.b);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l = 0L;
    }
    if (paramSessionInfo.a == 1)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
      PlusPanelUtils.a(localQQAppInterface, paramBaseChatPie.aX(), paramSessionInfo);
    }
    else if ((paramSessionInfo.a == 9501) && (localObject != null) && (((SmartDeviceProxyMgr)localObject).c(l)))
    {
      PlusPanelUtils.c(localQQAppInterface, paramBaseChatPie.aX(), paramSessionInfo);
    }
    else
    {
      AIOPanelUtiles.a(localQQAppInterface, "0X800407C", paramSessionInfo.a);
      localObject = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject).b = "send_file";
      ((FileManagerReporter.FileAssistantReportData)localObject).c = 1;
      FileManagerReporter.a(localQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
      PlusPanelUtils.a(localQQAppInterface, paramBaseChatPie.aX(), paramSessionInfo);
    }
    paramBaseChatPie.aX().setCanLock(false);
  }
  
  public int defaultDrawableID()
  {
    if (isGuildLiveChannel()) {
      return 2130840914;
    }
    if (isGuild()) {
      return 2130840808;
    }
    return 2130839302;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 206;
    }
    return 1104864066;
  }
  
  public String getDTElementId()
  {
    if (isGuild()) {
      return "em_sgrp_aio_plus_file";
    }
    return "";
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 507;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130206;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131887765);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (!CheckPermission.isHasStoragePermission(paramBaseChatPie.aX()))
    {
      CheckPermission.requestSDCardPermission(paramBaseChatPie.aX(), new FileAppInfo.1(this, paramBaseChatPie, paramSessionInfo));
      return;
    }
    a(paramBaseChatPie, paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.FileAppInfo
 * JD-Core Version:    0.7.0.1
 */