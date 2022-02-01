package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.List;

class NearbyProfileDisplayTribePanel$31
  implements DownloadListener
{
  NearbyProfileDisplayTribePanel$31(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString1 = this.a;
    paramString1.U = 4;
    paramString1.aA.sendEmptyMessage(4);
    if (NearbyProfileDisplayTribePanel.j(this.a) != null) {
      ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "install_done", 0, 0, NearbyProfileDisplayTribePanel.j(this.a).uin, "", "yes", "android");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    this.a.U = 2;
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    this.a.aA.sendEmptyMessage(5);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    paramDownloadInfo = this.a;
    paramDownloadInfo.U = 3;
    paramDownloadInfo.aA.sendEmptyMessage(3);
    if (this.a.S != null) {
      this.a.S.a(5);
    }
    if (NearbyProfileDisplayTribePanel.j(this.a) != null) {
      ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_done", 0, 0, NearbyProfileDisplayTribePanel.j(this.a).uin, "", "yes", "android");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    this.a.U = 2;
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.a.U = 1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (DownloadInfo)paramList.get(0);
      Message localMessage = this.a.aA.obtainMessage();
      localMessage.what = 2;
      localMessage.arg1 = paramList.t;
      localMessage.sendToTarget();
      if ((paramList.t == 0) && (NearbyProfileDisplayTribePanel.j(this.a) != null)) {
        ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_begin", 0, 0, NearbyProfileDisplayTribePanel.j(this.a).uin, "", "yes", "android");
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    this.a.U = 2;
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.31
 * JD-Core Version:    0.7.0.1
 */