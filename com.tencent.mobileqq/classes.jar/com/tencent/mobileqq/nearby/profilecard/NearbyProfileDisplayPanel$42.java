package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.List;

class NearbyProfileDisplayPanel$42
  implements DownloadListener
{
  NearbyProfileDisplayPanel$42(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString1 = this.a;
    paramString1.z = 4;
    paramString1.ap.sendEmptyMessage(4);
    if (this.a.f != null) {
      ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "install_done", 0, 0, String.valueOf(this.a.f.tinyId), "", "yes", "android");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    this.a.z = 2;
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    this.a.ap.sendEmptyMessage(5);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    paramDownloadInfo = this.a;
    paramDownloadInfo.z = 3;
    paramDownloadInfo.ap.sendEmptyMessage(3);
    if (this.a.x != null) {
      this.a.x.a(5);
    }
    if (this.a.f != null) {
      ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_done", 0, 0, String.valueOf(this.a.f.tinyId), "", "yes", "android");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    this.a.z = 2;
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.a.z = 1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (DownloadInfo)paramList.get(0);
      Message localMessage = this.a.ap.obtainMessage();
      localMessage.what = 2;
      localMessage.arg1 = paramList.t;
      localMessage.sendToTarget();
      if ((paramList.t == 0) && (this.a.f != null)) {
        ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_begin", 0, 0, String.valueOf(this.a.f.tinyId), "", "yes", "android");
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    this.a.z = 2;
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.42
 * JD-Core Version:    0.7.0.1
 */