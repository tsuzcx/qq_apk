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
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      long l = System.currentTimeMillis();
      if (l - this.b < 1000L) {
        return;
      }
      this.b = l;
      LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.a(), 3, 400));
      AppCircleReportManager.a().a(22, STUtils.a(10010, NewUpgradeDialog.a(), 3, 400));
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("NewUpgradeDialog", "onDownloadCancel");
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadError state = ");
      paramString.append(paramInt2);
      LogUtility.c("NewUpgradeDialog", paramString.toString());
      if ((paramDownloadInfo.f != 100) && (paramDownloadInfo.a() != 4))
      {
        ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.4(this, paramDownloadInfo));
        return;
      }
      onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("NewUpgradeDialog", "onDownloadFinish");
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long < 1000L) {
        return;
      }
      this.jdField_a_of_type_Long = l;
      LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.a(), 3, 700));
      AppCircleReportManager.a().a(20, STUtils.a(10010, NewUpgradeDialog.a(), 3, 700));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.2(this, paramDownloadInfo));
      if (NewUpgradeDialog.b(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog))
      {
        NewUpgradeDialog.b(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog);
        LogUtility.c("NewUpgradeDialog", HardCodeUtil.a(2131707584));
        return;
      }
      LogUtility.c("NewUpgradeDialog", HardCodeUtil.a(2131707592));
    }
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDownloadUpdate STATE = ");
          localStringBuilder.append(localDownloadInfo.a());
          LogUtility.c("NewUpgradeDialog", localStringBuilder.toString());
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
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog;
      NewUpgradeDialog.a(paramString1, new YYBDownloadListener(paramString1));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.5(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener
 * JD-Core Version:    0.7.0.1
 */