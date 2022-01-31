package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import betc;
import beze;
import bezf;
import bezi;
import bfhk;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;

public final class MiniProgramLpReportDC04266$2
  implements Runnable
{
  public MiniProgramLpReportDC04266$2(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    String str = beze.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    Object localObject = beze.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null, String.valueOf(this.jdField_a_of_type_Int), bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo), String.valueOf(this.jdField_a_of_type_Long), null, String.valueOf(this.jdField_b_of_type_Long), str, this.c, this.d, this.e, this.f, this.g);
    if (!bfhk.a()) {
      ((List)localObject).addAll(beze.a());
    }
    if (bfhk.a()) {}
    for (int i = 3;; i = 13)
    {
      localObject = beze.a(i, (List)localObject, null);
      if (betc.b()) {
        betc.a("MiniProgramLpReportDC04266", "MiniReportManager  reportCostTimeEvent: costTime event = [" + this.jdField_a_of_type_JavaLangString + "], costTime result = [" + this.jdField_a_of_type_Int + "], appType = [" + bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo) + "], timeCost = [" + this.jdField_a_of_type_Long + "],  attachInfo = [" + this.jdField_b_of_type_JavaLangString + "]  launchId:" + str + "  retCode:" + this.jdField_a_of_type_Int + "  reserves1:" + this.c + "  reserves2:" + this.d + "  reserves3:" + this.e + "  reserves4:" + this.f);
      }
      bezf.a().a((APP_REPORT_TRANSFER.SingleDcData)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.2
 * JD-Core Version:    0.7.0.1
 */