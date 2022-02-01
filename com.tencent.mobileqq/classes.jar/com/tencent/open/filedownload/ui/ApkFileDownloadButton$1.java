package com.tencent.open.filedownload.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.filedownload.TaskInfo;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class ApkFileDownloadButton$1
  implements DownloadListener
{
  ApkFileDownloadButton$1(ApkFileDownloadButton paramApkFileDownloadButton) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("[installSucceed] packageName=");
    paramString1.append(paramString2);
    paramString1.append(",mApkInfo=");
    paramString1.append(this.a.c);
    LogUtility.b("ApkFileDownloadButton_", paramString1.toString());
    if ((this.a.c != null) && (TextUtils.equals(paramString2, this.a.c.f))) {
      ThreadManager.excute(new ApkFileDownloadButton.1.8(this, paramString2), 16, null, true);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Object localObject = this.a;
    if (((ApkFileDownloadButton)localObject).a(paramDownloadInfo, ((ApkFileDownloadButton)localObject).c))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadCancel info.progress=");
      ((StringBuilder)localObject).append(paramDownloadInfo.t);
      LogUtility.b("ApkFileDownloadButton_", ((StringBuilder)localObject).toString());
      this.a.c.k = 1;
      this.a.c.j = paramDownloadInfo.t;
      if (this.a.c.h == 0L) {
        this.a.c.h = paramDownloadInfo.E;
      }
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.5(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    paramString = this.a;
    if (paramString.a(paramDownloadInfo, paramString.c))
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadError errorCode=");
      paramString.append(paramInt1);
      LogUtility.b("ApkFileDownloadButton_", paramString.toString());
      if ((paramInt1 == 6) && (ApkFileDownloadButton.a(this.a) > 0))
      {
        ApkFileDownloadButton.a(this.a, paramDownloadInfo);
        paramDownloadInfo = this.a;
        ApkFileDownloadButton.a(paramDownloadInfo, ApkFileDownloadButton.a(paramDownloadInfo) - 1);
        return;
      }
      this.a.c.k = 30;
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.7(this));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    Object localObject = this.a;
    if (((ApkFileDownloadButton)localObject).a(paramDownloadInfo, ((ApkFileDownloadButton)localObject).c))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFinish info.progress=");
      ((StringBuilder)localObject).append(paramDownloadInfo.t);
      LogUtility.b("ApkFileDownloadButton_", ((StringBuilder)localObject).toString());
      this.a.c.k = 4;
      this.a.c.j = paramDownloadInfo.t;
      if (this.a.c.h == 0L) {
        this.a.c.h = paramDownloadInfo.E;
      }
      ThreadManager.excute(new ApkFileDownloadButton.1.3(this), 16, null, true);
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.4(this));
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Object localObject = this.a;
    if (((ApkFileDownloadButton)localObject).a(paramDownloadInfo, ((ApkFileDownloadButton)localObject).c))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadPause info.progress=");
      ((StringBuilder)localObject).append(paramDownloadInfo.t);
      LogUtility.b("ApkFileDownloadButton_", ((StringBuilder)localObject).toString());
      this.a.c.k = 3;
      this.a.c.j = paramDownloadInfo.t;
      if (this.a.c.h == 0L) {
        this.a.c.h = paramDownloadInfo.E;
      }
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.1(this));
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
      ApkFileDownloadButton localApkFileDownloadButton = this.a;
      if (localApkFileDownloadButton.a(paramList, localApkFileDownloadButton.c))
      {
        ApkFileDownloadButton.a(this.a, 1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDownloadUpdate info.progress=");
        ((StringBuilder)localObject).append(paramList.t);
        LogUtility.b("ApkFileDownloadButton_", ((StringBuilder)localObject).toString());
        this.a.c.k = 2;
        this.a.c.j = paramList.t;
        if (this.a.c.h == 0L) {
          this.a.c.h = paramList.E;
        }
        ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.6(this));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Object localObject = this.a;
    if (((ApkFileDownloadButton)localObject).a(paramDownloadInfo, ((ApkFileDownloadButton)localObject).c))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadWait info.progress=");
      ((StringBuilder)localObject).append(paramDownloadInfo.t);
      LogUtility.b("ApkFileDownloadButton_", ((StringBuilder)localObject).toString());
      this.a.c.k = 20;
      if (this.a.c.h == 0L) {
        this.a.c.h = paramDownloadInfo.E;
      }
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.2(this));
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.ApkFileDownloadButton.1
 * JD-Core Version:    0.7.0.1
 */