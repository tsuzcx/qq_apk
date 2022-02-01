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
      if ((this.a.k != null) && (this.a.k.isShowing())) {
        this.a.k.dismiss();
      }
      DownloadManager.b().b(this.a.s);
      this.a.s = null;
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (!MyAppApi.a(this.a, paramDownloadInfo)) {
      return;
    }
    LogUtility.c("MyAppApi", "onDownloadCancel");
    if ((this.a.k != null) && (this.a.k.isShowing()) && (this.a.l)) {
      this.a.k.a(paramDownloadInfo.t, paramDownloadInfo.a());
    }
    DownloadManager.b().b(this.a.s);
    this.a.s = null;
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (!MyAppApi.a(this.a, paramDownloadInfo)) {
      return;
    }
    LogUtility.c("MyAppApi", "onDownloadError");
    if ((paramDownloadInfo.t != 100) && (paramDownloadInfo.s != 4))
    {
      if ((this.a.k != null) && (this.a.k.isShowing()) && (this.a.l)) {
        this.a.k.a(paramDownloadInfo.t, paramDownloadInfo.a());
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
      localObject = UpgradeController.a().d();
      if ((localObject != null) && (((UpgradeDetailWrapper)localObject).e != null))
      {
        SPSettings.a(true);
        SPSettings.a(((UpgradeDetailWrapper)localObject).e.d);
        NewUpgradeDialog.b();
        LogUtility.c("NewUpgradeDialog", "pre download success state saved!");
      }
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X8008F7E", "0X8008F7E", 0, 0, "", "", "", "");
    }
    LogUtility.c("MyAppApi", "onDownloadFinish");
    if ((this.a.k != null) && (this.a.k.isShowing()) && (this.a.l)) {
      this.a.k.a(100, 4);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mInstallParam: ");
    ((StringBuilder)localObject).append(this.a.j);
    LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
    if (this.a.j != null)
    {
      if (this.a.j.c)
      {
        ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.YYBDownloadListener.1(this, paramDownloadInfo), 500L);
        localObject = this.a;
        ((MyAppApi)localObject).d = true;
        ((MyAppApi)localObject).e = false;
      }
      else if ((AppUtil.a() == 1) && (ControlPolicyUtil.d()))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.YYBDownloadListener.2(this, paramDownloadInfo), 500L);
        localObject = this.a;
        ((MyAppApi)localObject).d = true;
        ((MyAppApi)localObject).e = false;
      }
      long l2 = 0L;
      int i = this.a.j.e;
      long l1 = l2;
      if (i != -1) {
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              localObject = this.a;
              l1 = ((MyAppApi)localObject).a(((MyAppApi)localObject).j.a, this.a.j.b, this.a.j.c);
            }
            else
            {
              localObject = this.a;
              l1 = ((MyAppApi)localObject).b(((MyAppApi)localObject).j.a);
            }
          }
          else
          {
            localObject = this.a;
            ((MyAppApi)localObject).p = true;
            if (((MyAppApi)localObject).q != null)
            {
              l1 = this.a.d().addDownloadTaskFromAuthorize(this.a.q, "2");
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
          l1 = ((MyAppApi)localObject).b(((MyAppApi)localObject).j.a, this.a.j.b, this.a.j.c);
        }
      }
      localObject = this.a;
      ((MyAppApi)localObject).f = l1;
      ((MyAppApi)localObject).g = System.currentTimeMillis();
    }
    DownloadManager.b().b(this.a.s);
    this.a.s = null;
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
    if ((this.a.k != null) && (this.a.k.isShowing()) && (this.a.l)) {
      this.a.k.a(paramDownloadInfo.t, paramDownloadInfo.a());
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
        if ((this.a.k != null) && (this.a.k.isShowing()) && (this.a.l)) {
          this.a.k.a(paramList.t, paramList.a());
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
    if ((this.a.k != null) && (this.a.k.isShowing()) && (this.a.l)) {
      this.a.k.a(paramDownloadInfo.t, paramDownloadInfo.a());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener
 * JD-Core Version:    0.7.0.1
 */