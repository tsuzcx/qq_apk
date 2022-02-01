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
    localQQAppInterface = paramBaseChatPie.a;
    localObject = (SmartDeviceProxyMgr)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if ((paramSessionInfo.jdField_a_of_type_Int == 9501) && (localObject != null) && (((SmartDeviceProxyMgr)localObject).c(l1)))
        {
          PlusPanelUtils.c(localQQAppInterface, paramBaseChatPie.a(), paramSessionInfo);
        }
        else
        {
          AIOPanelUtiles.a(localQQAppInterface, "0X800407C", paramSessionInfo.jdField_a_of_type_Int);
          localObject = new FileManagerReporter.FileAssistantReportData();
          ((FileManagerReporter.FileAssistantReportData)localObject).b = "send_file";
          ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
          FileManagerReporter.a(localQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
          PlusPanelUtils.a(localQQAppInterface, paramBaseChatPie.a(), paramSessionInfo);
        }
      }
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
      PlusPanelUtils.a(localQQAppInterface, paramBaseChatPie.a(), paramSessionInfo);
      paramBaseChatPie.a().setCanLock(false);
      return;
    }
  }
  
  public int defaultDrawableID()
  {
    return 2130839291;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 206;
    }
    return 1104864066;
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
    return BaseApplicationImpl.getContext().getString(2131690901);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (!CheckPermission.isHasStoragePermission(paramBaseChatPie.a()))
    {
      CheckPermission.requestSDCardPermission(paramBaseChatPie.a(), new FileAppInfo.1(this, paramBaseChatPie, paramSessionInfo));
      return;
    }
    a(paramBaseChatPie, paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.FileAppInfo
 * JD-Core Version:    0.7.0.1
 */