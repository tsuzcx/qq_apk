package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import bdnw;
import bdsq;
import bdsr;
import bdsu;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class MiniProgramLpReportDC04266$2
  implements Runnable
{
  public MiniProgramLpReportDC04266$2(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    String str = bdsq.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    APP_REPORT_TRANSFER.SingleDcData localSingleDcData = bdsq.a(3, bdsq.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null, String.valueOf(this.jdField_a_of_type_Int), bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo), String.valueOf(this.jdField_a_of_type_Long), null, String.valueOf(this.jdField_b_of_type_Long), str, this.c, this.d, this.e, this.f), null);
    if (bdnw.b()) {
      bdnw.a("MiniProgramLpReportDC04266", "MiniReportManager  reportCostTimeEvent: costTime event = [" + this.jdField_a_of_type_JavaLangString + "], costTime result = [" + this.jdField_a_of_type_Int + "], appType = [" + bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo) + "], timeCost = [" + this.jdField_a_of_type_Long + "],  attachInfo = [" + this.jdField_b_of_type_JavaLangString + "]  launchId:" + str + "  retCode:" + this.jdField_a_of_type_Int + "  reserves1:" + this.c + "  reserves2:" + this.d + "  reserves3:" + this.e + "  reserves4:" + this.f);
    }
    bdsr.a().a(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.2
 * JD-Core Version:    0.7.0.1
 */