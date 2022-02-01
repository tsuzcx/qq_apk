package com.tencent.mobileqq.profilecard.bussiness.qzone;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

class ProfileQZoneComponent$5
  implements Runnable
{
  ProfileQZoneComponent$5(ProfileQZoneComponent paramProfileQZoneComponent, ProfileCardInfo paramProfileCardInfo) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.val$cardInfo.allInOne.uin))
      {
        Object localObject = this.val$cardInfo.allInOne.uin;
        if (this.val$cardInfo.allInOne.uin.startsWith("+")) {
          localObject = this.val$cardInfo.allInOne.uin.substring(1);
        }
        localObject = new LpReportInfo_pf00064(699, 3, Long.valueOf((String)localObject).longValue());
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
        return;
      }
    }
    catch (Exception localException)
    {
      QZLog.e("QzoneReport", "makeOrRefreshQZone", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.5
 * JD-Core Version:    0.7.0.1
 */