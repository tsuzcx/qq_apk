package com.tencent.open.downloadnew;

import alql;
import alqn;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import com.tencent.mobileqq.utils.SPSettings;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MyAppApi$YYBDownloadListener
  implements DownloadListener
{
  protected MyAppApi$YYBDownloadListener(MyAppApi paramMyAppApi) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
      }
      DownloadManager.a().b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("MyAppApi", "onDownloadCancel");
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.g, paramDownloadInfo.a());
      }
      DownloadManager.a().b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("MyAppApi", "onDownloadError");
      if ((paramDownloadInfo.g != 100) && (paramDownloadInfo.f != 4)) {
        break label46;
      }
      onDownloadFinish(paramDownloadInfo);
    }
    label46:
    while ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog == null) || (!this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) || (!this.a.c)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.g, paramDownloadInfo.a());
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    label213:
    long l2;
    long l1;
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      if (!MyAppApi.a(this.a)) {
        break label342;
      }
      UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
      if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.a != null))
      {
        SPSettings.a(true);
        SPSettings.a(localUpgradeDetailWrapper.a.jdField_a_of_type_Int);
        NewUpgradeDialog.b();
        LogUtility.c("NewUpgradeDialog", "pre download success state saved!");
      }
      LogUtility.c("MyAppApi", "onDownloadFinish");
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(100, 4);
      }
      LogUtility.c("MyAppApi", "mInstallParam: " + this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams);
      if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams != null)
      {
        if (!this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean) {
          break label369;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new alql(this, paramDownloadInfo), 500L);
        this.a.jdField_a_of_type_Boolean = true;
        this.a.jdField_b_of_type_Boolean = false;
        l2 = 0L;
        l1 = l2;
        switch (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l1 = this.a.a(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Long = l1;
      this.a.jdField_b_of_type_Long = System.currentTimeMillis();
      DownloadManager.a().b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
      return;
      label342:
      ReportController.b(null, "dc00898", "", "", "0X8008F7E", "0X8008F7E", 0, 0, "", "", "", "");
      break;
      label369:
      if ((AppUtil.a() != 1) || (!ControlPolicyUtil.c())) {
        break label213;
      }
      ThreadManager.getSubThreadHandler().postDelayed(new alqn(this, paramDownloadInfo), 500L);
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_b_of_type_Boolean = false;
      break label213;
      this.a.e = true;
      if (this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
      {
        l1 = this.a.a().addDownloadTaskFromAuthorize(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      }
      else
      {
        LogUtility.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
        l1 = l2;
        continue;
        l1 = this.a.b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        continue;
        l1 = this.a.b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("MyAppApi", "onDownloadPause");
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.g, paramDownloadInfo.a());
      }
    }
  }
  
  public void onDownloadUpdate(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo.b.equals("1101070898"))
        {
          LogUtility.c("MyAppApi", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
            this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(localDownloadInfo.g, localDownloadInfo.a());
          }
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("MyAppApi", "onDownloadWait");
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.g, paramDownloadInfo.a());
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener
 * JD-Core Version:    0.7.0.1
 */