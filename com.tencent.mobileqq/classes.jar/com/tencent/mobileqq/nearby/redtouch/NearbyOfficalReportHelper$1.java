package com.tencent.mobileqq.nearby.redtouch;

import android.util.Log;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyOfficalReportHelper$1
  implements Runnable
{
  NearbyOfficalReportHelper$1(NearbyOfficalReportHelper paramNearbyOfficalReportHelper, QQAppInterface paramQQAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = ((TroopRedTouchManager)this.a.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).n();
    if (((NearbyRedNum)localObject).b > 0)
    {
      String str3 = String.valueOf(((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
      String str1;
      if (((NearbyRedNum)localObject).d > 0) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      String str2;
      if (((NearbyRedNum)localObject).c > 0) {
        str2 = "1";
      } else {
        str2 = "0";
      }
      if (((NearbyRedNum)localObject).a > 1) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", this.b, this.c, 0, 0, str3, str1, str2, "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportLebaRedDotEvent op_name = ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" d1 = ");
      localStringBuilder.append(str3);
      localStringBuilder.append(" d2 = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" d3 = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" d4 = ");
      localStringBuilder.append((String)localObject);
      Log.i(" NearbyRecommend", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper.1
 * JD-Core Version:    0.7.0.1
 */