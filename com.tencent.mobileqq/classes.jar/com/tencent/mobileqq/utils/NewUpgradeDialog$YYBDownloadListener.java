package com.tencent.mobileqq.utils;

import ajpc;
import ajpd;
import ajpe;
import ajpf;
import ajpg;
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
  private long a;
  private long b;
  
  protected NewUpgradeDialog$YYBDownloadListener(NewUpgradeDialog paramNewUpgradeDialog) {}
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898"))) {
      LogUtility.c("NewUpgradeDialog", "onDownloadWait");
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("NewUpgradeDialog", "onDownloadError state = " + paramInt2);
      if ((paramDownloadInfo.g == 100) || (paramDownloadInfo.a() == 4)) {
        c(paramDownloadInfo);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ajpf(this, paramDownloadInfo));
  }
  
  public void a(String paramString1, String paramString2)
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
  
  public void a(List paramList)
  {
    LogUtility.c("NewUpgradeDialog", "onDownloadUpdate");
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo.b.equals("1101070898"))
        {
          LogUtility.c("NewUpgradeDialog", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          ThreadManager.getUIHandler().post(new ajpe(this, localDownloadInfo));
        }
      }
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("NewUpgradeDialog", "onDownloadPause");
      LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.a(), 3, 600));
      AppCircleReportManager.a().a(19, STUtils.a(10010, NewUpgradeDialog.a(), 3, 600));
      ThreadManager.getUIHandler().post(new ajpc(this, paramDownloadInfo));
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      NewUpgradeDialog.a(this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog, new YYBDownloadListener(this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog));
      ThreadManager.getUIHandler().post(new ajpg(this));
    }
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("NewUpgradeDialog", "onDownloadFinish");
    long l;
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
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
    ThreadManager.getUIHandler().post(new ajpd(this, paramDownloadInfo));
    if (NewUpgradeDialog.b(this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog))
    {
      NewUpgradeDialog.b(this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog);
      LogUtility.c("NewUpgradeDialog", "下载完成，进行安装");
      return;
    }
    LogUtility.c("NewUpgradeDialog", "预下载完成，不进行安装");
  }
  
  public void c(String paramString1, String paramString2) {}
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("NewUpgradeDialog", "onDownloadCancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NewUpgradeDialog.YYBDownloadListener
 * JD-Core Version:    0.7.0.1
 */