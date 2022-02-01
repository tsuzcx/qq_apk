package com.tencent.mobileqq.filemanager.activity;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class UniformDownloadActivity$10
  implements DownloadListener
{
  UniformDownloadActivity$10(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ("1101070898".equals(paramString1))
    {
      paramString1 = UniformDownloadActivity.a(this.a);
      UniformDownloadActivity.a(this.a, paramString1);
      paramString1 = UniformDownloadActivity.a(this.a, paramString1);
      if (QLog.isColorLevel())
      {
        paramString2 = UniformDownloadActivity.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tmastUrl=");
        localStringBuilder.append(paramString1);
        QLog.d(paramString2, 2, localStringBuilder.toString());
      }
      UniformDownloadActivity.a(this.a, paramString1);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = UniformDownloadActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadCancel ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString = UniformDownloadActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadError ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = UniformDownloadActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", "0X8008F88", "0X8008F88", 1, 0, "", "", "", "");
    this.a.runOnUiThread(new UniformDownloadActivity.10.4(this));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = UniformDownloadActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadPause ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898"))) {
      this.a.runOnUiThread(new UniformDownloadActivity.10.3(this));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (QLog.isColorLevel())
      {
        String str = UniformDownloadActivity.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDownloadUpdate ");
        localStringBuilder.append(localDownloadInfo.e);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.c.equals("1101070898"))) {
        this.a.runOnUiThread(new UniformDownloadActivity.10.2(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    this.a.runOnUiThread(new UniformDownloadActivity.10.1(this));
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10
 * JD-Core Version:    0.7.0.1
 */