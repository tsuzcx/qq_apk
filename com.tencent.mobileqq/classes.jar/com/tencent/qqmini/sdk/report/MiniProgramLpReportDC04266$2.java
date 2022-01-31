package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.text.TextUtils;
import bgxr;
import bgxz;
import bgya;
import bgyd;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.List;

public final class MiniProgramLpReportDC04266$2
  implements Runnable
{
  public MiniProgramLpReportDC04266$2(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    String str = bgxz.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    Object localObject = bgxz.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null, String.valueOf(this.jdField_a_of_type_Int), bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo), String.valueOf(this.jdField_a_of_type_Long), null, String.valueOf(this.jdField_b_of_type_Long), str, this.c, this.d, this.e, this.f, this.g);
    if (!QUAUtil.isQQApp()) {
      ((List)localObject).addAll(bgxz.a());
    }
    APP_REPORT_TRANSFER.SingleDcData localSingleDcData = bgxz.a(bgxr.a(), (List)localObject, null);
    bgya.a().a(localSingleDcData);
    if (bgyd.a(bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo), this.jdField_a_of_type_JavaLangString, this.f))
    {
      localObject = bgxz.a(bgxr.b(), (List)localObject, null);
      bgya.a().a((APP_REPORT_TRANSFER.SingleDcData)localObject);
      if (QMLog.isDebugEnabled()) {
        QMLog.d("MiniProgramLpReportDC04266", "MiniReportManager  [5332] reportCostTimeEvent: costTime event = [" + this.jdField_a_of_type_JavaLangString + "], costTime result = [" + this.jdField_a_of_type_Int + "], appType = [" + bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo) + "], timeCost = [" + this.jdField_a_of_type_Long + "],  attachInfo = [" + this.jdField_b_of_type_JavaLangString + "]  launchId:" + str + "  retCode:" + this.jdField_a_of_type_Int + "  reserves1:" + this.c + "  reserves2:" + this.d + "  reserves3:" + this.e + "  reserves4:" + this.f);
      }
    }
    if (QMLog.isDebugEnabled())
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QMLog.e("MiniProgramLpReportDC04266", "eventName not found!");
        throw new AssertionError("MiniProgramLpReportDC04266 eventName not found!");
      }
      QMLog.d("MiniProgramLpReportDC04266", "MiniReportManager  reportCostTimeEvent: costTime event = [" + this.jdField_a_of_type_JavaLangString + "], costTime result = [" + this.jdField_a_of_type_Int + "], appType = [" + bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo) + "], timeCost = [" + this.jdField_a_of_type_Long + "],  attachInfo = [" + this.jdField_b_of_type_JavaLangString + "]  launchId:" + str + "  retCode:" + this.jdField_a_of_type_Int + "  reserves1:" + this.c + "  reserves2:" + this.d + "  reserves3:" + this.e + "  reserves4:" + this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.2
 * JD-Core Version:    0.7.0.1
 */