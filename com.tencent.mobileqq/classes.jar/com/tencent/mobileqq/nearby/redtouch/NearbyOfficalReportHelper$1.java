package com.tencent.mobileqq.nearby.redtouch;

import android.util.Log;
import axqc;
import ayme;
import aymi;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import ntq;

public class NearbyOfficalReportHelper$1
  implements Runnable
{
  public NearbyOfficalReportHelper$1(ayme paramayme, QQAppInterface paramQQAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = ((ntq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a();
    String str3;
    String str1;
    String str2;
    if (((aymi)localObject).b > 0)
    {
      str3 = String.valueOf(axqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
      if (((aymi)localObject).d <= 0) {
        break label168;
      }
      str1 = "1";
      if (((aymi)localObject).c <= 0) {
        break label174;
      }
      str2 = "1";
      label65:
      if (((aymi)localObject).a <= 1) {
        break label180;
      }
    }
    label168:
    label174:
    label180:
    for (localObject = "1";; localObject = "0")
    {
      bdla.b(null, "dc00899", "grp_lbs", "", this.jdField_a_of_type_JavaLangString, this.b, 0, 0, str3, str1, str2, "");
      Log.i(" NearbyRecommend", "reportLebaRedDotEvent op_name = " + this.b + " d1 = " + str3 + " d2 = " + str1 + " d3 = " + str2 + " d4 = " + (String)localObject);
      return;
      str1 = "0";
      break;
      str2 = "0";
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper.1
 * JD-Core Version:    0.7.0.1
 */