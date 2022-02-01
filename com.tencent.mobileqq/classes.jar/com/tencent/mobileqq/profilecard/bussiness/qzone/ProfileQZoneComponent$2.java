package com.tencent.mobileqq.profilecard.bussiness.qzone;

import android.text.TextUtils;
import azrb;
import baca;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

public class ProfileQZoneComponent$2
  implements Runnable
{
  public ProfileQZoneComponent$2(baca parambaca, azrb paramazrb) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a.a.a))
      {
        Object localObject = this.a.a.a;
        if (this.a.a.a.startsWith("+")) {
          localObject = this.a.a.a.substring(1);
        }
        localObject = new LpReportInfo_pf00064(699, 2, Long.valueOf((String)localObject).longValue());
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("QzoneReport", "makeOrRefreshQZone", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.2
 * JD-Core Version:    0.7.0.1
 */