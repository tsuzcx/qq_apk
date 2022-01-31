package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import bela;
import betc;
import beyw;
import beze;
import bezf;
import bezi;
import bfhk;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;

public final class MiniProgramLpReportDC04266$1
  implements Runnable
{
  public MiniProgramLpReportDC04266$1(int paramInt1, MiniAppInfo paramMiniAppInfo, int paramInt2, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10) {}
  
  public void run()
  {
    beze.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      beze.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) {
        bezf.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, beze.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
      }
    }
    if ((this.jdField_a_of_type_Int == 611) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null))
    {
      localObject = bezf.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
      String str = beze.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      if ((localObject != null) && (((String)localObject).equals(str))) {
        bezf.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
      }
    }
    Object localObject = beze.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    if (betc.b()) {
      betc.a("MiniProgramLpReportDC04266", "MiniReportManager  reportEventType() called with: eventType = [" + this.jdField_a_of_type_Int + "]" + bezi.a(this.jdField_a_of_type_Int) + "  retCode:" + this.jdField_b_of_type_Int + "  attachInfo: " + this.jdField_a_of_type_JavaLangString + "  timestamp: " + this.jdField_a_of_type_Long + "  launchId: " + (String)localObject + " timecost: " + this.jdField_b_of_type_Long);
    }
    localObject = beze.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bela.a(this.jdField_b_of_type_JavaLangString), bezi.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.c, String.valueOf(this.jdField_b_of_type_Int), this.d, String.valueOf(this.jdField_b_of_type_Long), this.e, String.valueOf(this.jdField_a_of_type_Long), (String)localObject, this.f, this.g, this.h, this.i, this.j);
    if (!bfhk.a()) {
      ((List)localObject).addAll(beze.a());
    }
    if (bfhk.a()) {}
    for (int k = 3;; k = 13)
    {
      localObject = beze.a(k, (List)localObject, null);
      bezf.a().a((APP_REPORT_TRANSFER.SingleDcData)localObject);
      if (beyw.a(this.jdField_a_of_type_Int)) {
        bezf.a().b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.1
 * JD-Core Version:    0.7.0.1
 */