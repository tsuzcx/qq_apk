package com.tencent.mobileqq.upgrade;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class NewUpgradeDialog$YYBDownloadListener
  implements DownloadListener
{
  private long jdField_a_of_type_Long = 0L;
  private long b = 0L;
  
  protected NewUpgradeDialog$YYBDownloadListener(NewUpgradeDialog paramNewUpgradeDialog) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    long l;
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      l = System.currentTimeMillis();
      if (l - this.b >= 1000L) {}
    }
    else
    {
      return;
    }
    this.b = l;
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.a(), 3, 400));
    AppCircleReportManager.a().a(22, STUtils.a(10010, NewUpgradeDialog.a(), 3, 400));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("NewUpgradeDialog", "onDownloadCancel");
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      LogUtility.c("NewUpgradeDialog", "onDownloadError state = " + paramInt2);
      if ((paramDownloadInfo.f == 100) || (paramDownloadInfo.a() == 4)) {
        onDownloadFinish(paramDownloadInfo);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.4(this, paramDownloadInfo));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("NewUpgradeDialog", "onDownloadFinish");
    long l;
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 1000L) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Long = l;
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.a(), 3, 700));
    AppCircleReportManager.a().a(20, STUtils.a(10010, NewUpgradeDialog.a(), 3, 700));
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.2(this, paramDownloadInfo));
    if (NewUpgradeDialog.b(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog))
    {
      NewUpgradeDialog.b(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog);
      LogUtility.c("NewUpgradeDialog", HardCodeUtil.a(2131707559));
      return;
    }
    LogUtility.c("NewUpgradeDialog", HardCodeUtil.a(2131707567));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      LogUtility.c("NewUpgradeDialog", "onDownloadPause");
      LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.a(), 3, 600));
      AppCircleReportManager.a().a(19, STUtils.a(10010, NewUpgradeDialog.a(), 3, 600));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.1(this, paramDownloadInfo));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    LogUtility.c("NewUpgradeDialog", "onDownloadUpdate");
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo.c.equals("1101070898"))
        {
          LogUtility.c("NewUpgradeDialog", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.3(this, localDownloadInfo));
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898"))) {
      LogUtility.c("NewUpgradeDialog", "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      NewUpgradeDialog.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog, new YYBDownloadListener(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.5(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener
 * JD-Core Version:    0.7.0.1
 */