package com.tencent.open.downloadnew;

import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.NewApkInfo;
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
    if ((paramString1.startsWith("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
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
    if (!MyAppApi.a(this.a, paramDownloadInfo)) {
      return;
    }
    LogUtility.c("MyAppApi", "onDownloadCancel");
    if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.f, paramDownloadInfo.a());
    }
    DownloadManager.a().b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
    this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (!MyAppApi.a(this.a, paramDownloadInfo)) {
      return;
    }
    LogUtility.c("MyAppApi", "onDownloadError");
    if ((paramDownloadInfo.f != 100) && (paramDownloadInfo.e != 4))
    {
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.f, paramDownloadInfo.a());
      }
      return;
    }
    onDownloadFinish(paramDownloadInfo);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (!MyAppApi.a(this.a, paramDownloadInfo)) {
      return;
    }
    if (MyAppApi.a(this.a))
    {
      localObject = UpgradeController.a().a();
      if ((localObject != null) && (((UpgradeDetailWrapper)localObject).a != null))
      {
        SPSettings.a(true);
        SPSettings.a(((UpgradeDetailWrapper)localObject).a.jdField_a_of_type_Int);
        NewUpgradeDialog.b();
        LogUtility.c("NewUpgradeDialog", "pre download success state saved!");
      }
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X8008F7E", "0X8008F7E", 0, 0, "", "", "", "");
    }
    LogUtility.c("MyAppApi", "onDownloadFinish");
    if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(100, 4);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mInstallParam: ");
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams);
    LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
    if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams != null)
    {
      if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean)
      {
        ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.YYBDownloadListener.1(this, paramDownloadInfo), 500L);
        localObject = this.a;
        ((MyAppApi)localObject).jdField_a_of_type_Boolean = true;
        ((MyAppApi)localObject).jdField_b_of_type_Boolean = false;
      }
      else if ((AppUtil.a() == 1) && (ControlPolicyUtil.c()))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.YYBDownloadListener.2(this, paramDownloadInfo), 500L);
        localObject = this.a;
        ((MyAppApi)localObject).jdField_a_of_type_Boolean = true;
        ((MyAppApi)localObject).jdField_b_of_type_Boolean = false;
      }
      long l2 = 0L;
      int i = this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int;
      long l1 = l2;
      if (i != -1) {
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              localObject = this.a;
              l1 = ((MyAppApi)localObject).a(((MyAppApi)localObject).jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
            }
            else
            {
              localObject = this.a;
              l1 = ((MyAppApi)localObject).b(((MyAppApi)localObject).jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle);
            }
          }
          else
          {
            localObject = this.a;
            ((MyAppApi)localObject).e = true;
            if (((MyAppApi)localObject).jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
            {
              l1 = this.a.a().addDownloadTaskFromAuthorize(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
            }
            else
            {
              LogUtility.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
              l1 = l2;
            }
          }
        }
        else
        {
          localObject = this.a;
          l1 = ((MyAppApi)localObject).b(((MyAppApi)localObject).jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        }
      }
      localObject = this.a;
      ((MyAppApi)localObject).jdField_a_of_type_Long = l1;
      ((MyAppApi)localObject).jdField_b_of_type_Long = System.currentTimeMillis();
    }
    DownloadManager.a().b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
    this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
    if (("ANDROID.QQ.YYBXZGAMECENTER".equals(paramDownloadInfo.h)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(paramDownloadInfo.h))) {
      GameCenterUtils.a(null, "765", "205011", paramDownloadInfo.c, "76501", "1", "156");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (!MyAppApi.a(this.a, paramDownloadInfo)) {
      return;
    }
    LogUtility.c("MyAppApi", "onDownloadPause");
    if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.f, paramDownloadInfo.a());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (DownloadInfo)((Iterator)localObject).next();
      if (MyAppApi.a(this.a, paramList))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDownloadUpdate STATE = ");
        ((StringBuilder)localObject).append(paramList.a());
        LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
        if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
          this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramList.f, paramList.a());
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (!MyAppApi.a(this.a, paramDownloadInfo)) {
      return;
    }
    LogUtility.c("MyAppApi", "onDownloadWait");
    if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.f, paramDownloadInfo.a());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener
 * JD-Core Version:    0.7.0.1
 */