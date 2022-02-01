package com.tencent.mobileqq.nearby.redtouch;

import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
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
    if (((NearbyRedDotCustomInfo)localObject).jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = String.valueOf(NearbySPUtil.a(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
      paramRedDotInfo = String.valueOf(((NearbyRedDotCustomInfo)localObject).c);
      localObject = String.valueOf(((NearbyRedDotCustomInfo)localObject).jdField_b_of_type_Int);
      ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "official_push_received", 0, 0, paramQQAppInterface, paramRedDotInfo, (String)localObject, "");
      Log.i(" NearbyRecommend", "reportLebaRedDotReceive op_name = official_push_receivedd1 = " + paramQQAppInterface + " d2 = " + paramRedDotInfo + " d3 = " + (String)localObject);
    }
  }
  
  public void a(NearbyAppInterface paramNearbyAppInterface, String paramString1, String paramString2)
  {
    Object localObject = paramNearbyAppInterface.a().a();
    String str;
    if (((NearbyRedNum)localObject).a > 1)
    {
      paramNearbyAppInterface = "1";
      if (((NearbyRedNum)localObject).d <= 0) {
        break label136;
      }
      str = "1";
      label33:
      if (((NearbyRedNum)localObject).c <= 0) {
        break label143;
      }
    }
    label136:
    label143:
    for (localObject = "1";; localObject = "0")
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", paramString1, paramString2, 0, 0, str, (String)localObject, "", paramNearbyAppInterface);
      Log.i(" NearbyRecommend", "reportNearByRedDotEvent op_type = " + paramString1 + " op_name = " + paramString2 + " d1 = " + str + " d2 = " + (String)localObject + " d4 = " + paramNearbyAppInterface);
      return;
      paramNearbyAppInterface = "0";
      break;
      str = "0";
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper
 * JD-Core Version:    0.7.0.1
 */