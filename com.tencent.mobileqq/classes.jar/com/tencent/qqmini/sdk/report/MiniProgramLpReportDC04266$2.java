package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import besl;
import beyn;
import beyo;
import beyr;
import bfgt;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;

public final class MiniProgramLpReportDC04266$2
  implements Runnable
{
  public MiniProgramLpReportDC04266$2(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    String str = beyn.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    Object localObject = beyn.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null, String.valueOf(this.jdField_a_of_type_Int), beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo), String.valueOf(this.jdField_a_of_type_Long), null, String.valueOf(this.jdField_b_of_type_Long), str, this.c, this.d, this.e, this.f, this.g);
    if (!bfgt.a()) {
      ((List)localObject).addAll(beyn.a());
    }
    if (bfgt.a()) {}
    for (int i = 3;; i = 13)
    {
      localObject = beyn.a(i, (List)localObject, null);
      if (besl.b()) {
        besl.a("MiniProgramLpReportDC04266", "MiniReportManager  reportCostTimeEvent: costTime event = [" + this.jdField_a_of_type_JavaLangString + "], costTime result = [" + this.jdField_a_of_type_Int + "], appType = [" + beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo) + "], timeCost = [" + this.jdField_a_of_type_Long + "],  attachInfo = [" + this.jdField_b_of_type_JavaLangString + "]  launchId:" + str + "  retCode:" + this.jdField_a_of_type_Int + "  reserves1:" + this.c + "  reserves2:" + this.d + "  reserves3:" + this.e + "  reserves4:" + this.f);
      }
      beyo.a().a((APP_REPORT_TRANSFER.SingleDcData)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.2
 * JD-Core Version:    0.7.0.1
 */