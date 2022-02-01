package com.tencent.mobileqq.nearby.redtouch;

import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class NearbyOfficalReportHelper
{
  public static NearbyOfficalReportHelper a = new NearbyOfficalReportHelper();
  
  public static NearbyOfficalReportHelper a()
  {
    return a;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new NearbyOfficalReportHelper.1(this, paramQQAppInterface, paramString1, paramString2), 16, null, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    Object localObject = new NearbyRedDotCustomInfo();
    ((NearbyRedDotCustomInfo)localObject).a(paramRedDotInfo);
    if (((NearbyRedDotCustomInfo)localObject).c)
    {
      paramQQAppInterface = String.valueOf(((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
      paramRedDotInfo = String.valueOf(((NearbyRedDotCustomInfo)localObject).e);
      localObject = String.valueOf(((NearbyRedDotCustomInfo)localObject).d);
      ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "official_push_received", 0, 0, paramQQAppInterface, paramRedDotInfo, (String)localObject, "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportLebaRedDotReceive op_name = official_push_receivedd1 = ");
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append(" d2 = ");
      localStringBuilder.append(paramRedDotInfo);
      localStringBuilder.append(" d3 = ");
      localStringBuilder.append((String)localObject);
      Log.i(" NearbyRecommend", localStringBuilder.toString());
    }
  }
  
  public void a(INearbyAppInterface paramINearbyAppInterface, String paramString1, String paramString2)
  {
    Object localObject = paramINearbyAppInterface.getNearbyProcManager().e();
    int i = ((NearbyRedNum)localObject).a;
    String str2 = "1";
    if (i > 1) {
      paramINearbyAppInterface = "1";
    } else {
      paramINearbyAppInterface = "0";
    }
    String str1;
    if (((NearbyRedNum)localObject).d > 0) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    if (((NearbyRedNum)localObject).c <= 0) {
      str2 = "0";
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", paramString1, paramString2, 0, 0, str1, str2, "", paramINearbyAppInterface);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportNearByRedDotEvent op_type = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" op_name = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" d1 = ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(" d2 = ");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(" d4 = ");
    ((StringBuilder)localObject).append(paramINearbyAppInterface);
    Log.i(" NearbyRecommend", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper
 * JD-Core Version:    0.7.0.1
 */