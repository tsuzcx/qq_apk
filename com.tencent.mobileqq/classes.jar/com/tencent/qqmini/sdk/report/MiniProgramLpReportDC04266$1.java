package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import bdgj;
import bdnw;
import bdsi;
import bdsq;
import bdsr;
import bdsu;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class MiniProgramLpReportDC04266$1
  implements Runnable
{
  public MiniProgramLpReportDC04266$1(int paramInt1, MiniAppInfo paramMiniAppInfo, int paramInt2, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9) {}
  
  public void run()
  {
    bdsq.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      bdsq.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) {
        bdsr.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, bdsq.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
      }
    }
    if ((this.jdField_a_of_type_Int == 611) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null))
    {
      localObject = bdsr.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
      String str = bdsq.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      if ((localObject != null) && (((String)localObject).equals(str))) {
        bdsr.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
      }
    }
    Object localObject = bdsq.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    if (bdnw.b()) {
      bdnw.a("MiniProgramLpReportDC04266", "MiniReportManager  reportEventType() called with: eventType = [" + this.jdField_a_of_type_Int + "]" + bdsu.a(this.jdField_a_of_type_Int) + "  retCode:" + this.jdField_b_of_type_Int + "  attachInfo: " + this.jdField_a_of_type_JavaLangString + "  timestamp: " + this.jdField_a_of_type_Long + "  launchId: " + (String)localObject + " timecost: " + this.jdField_b_of_type_Long);
    }
    localObject = bdsq.a(3, bdsq.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bdgj.a(this.jdField_b_of_type_JavaLangString), bdsu.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.c, String.valueOf(this.jdField_b_of_type_Int), this.d, String.valueOf(this.jdField_b_of_type_Long), this.e, String.valueOf(this.jdField_a_of_type_Long), (String)localObject, this.f, this.g, this.h, this.i), null);
    bdsr.a().a((APP_REPORT_TRANSFER.SingleDcData)localObject);
    if (bdsi.a(this.jdField_a_of_type_Int)) {
      bdsr.a().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.1
 * JD-Core Version:    0.7.0.1
 */