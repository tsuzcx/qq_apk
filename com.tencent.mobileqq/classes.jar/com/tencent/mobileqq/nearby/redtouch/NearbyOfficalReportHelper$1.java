package com.tencent.mobileqq.nearby.redtouch;

import android.util.Log;
import axdz;
import axzx;
import ayab;
import bcst;
import com.tencent.mobileqq.app.QQAppInterface;
import njg;

public class NearbyOfficalReportHelper$1
  implements Runnable
{
  public NearbyOfficalReportHelper$1(axzx paramaxzx, QQAppInterface paramQQAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = ((njg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).a();
    String str3;
    String str1;
    String str2;
    if (((ayab)localObject).b > 0)
    {
      str3 = String.valueOf(axdz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
      if (((ayab)localObject).d <= 0) {
        break label167;
      }
      str1 = "1";
      if (((ayab)localObject).c <= 0) {
        break label173;
      }
      str2 = "1";
      label64:
      if (((ayab)localObject).a <= 1) {
        break label179;
      }
    }
    label167:
    label173:
    label179:
    for (localObject = "1";; localObject = "0")
    {
      bcst.b(null, "dc00899", "grp_lbs", "", this.jdField_a_of_type_JavaLangString, this.b, 0, 0, str3, str1, str2, "");
      Log.i(" NearbyRecommend", "reportLebaRedDotEvent op_name = " + this.b + " d1 = " + str3 + " d2 = " + str1 + " d3 = " + str2 + " d4 = " + (String)localObject);
      return;
      str1 = "0";
      break;
      str2 = "0";
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper.1
 * JD-Core Version:    0.7.0.1
 */