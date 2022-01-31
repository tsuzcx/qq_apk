package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.text.TextUtils;
import bgos;
import bhby;
import bhcg;
import bhch;
import bhck;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.List;

public final class MiniProgramLpReportDC04266$1
  implements Runnable
{
  public MiniProgramLpReportDC04266$1(int paramInt1, MiniAppInfo paramMiniAppInfo, int paramInt2, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10) {}
  
  public void run()
  {
    bhcg.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      bhcg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) {
        bhch.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, bhcg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
      }
    }
    if ((this.jdField_a_of_type_Int == 611) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null))
    {
      str1 = bhch.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
      str2 = bhcg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      if ((str1 != null) && (str1.equals(str2))) {
        bhch.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
      }
    }
    String str1 = bhcg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    String str2 = bhck.a(this.jdField_a_of_type_Int);
    if (QMLog.isDebugEnabled())
    {
      if (TextUtils.isEmpty(str2))
      {
        QMLog.e("MiniProgramLpReportDC04266", "eventName not found!");
        throw new AssertionError("MiniProgramLpReportDC04266 eventName not found!");
      }
      QMLog.d("MiniProgramLpReportDC04266", "MiniReportManager  reportEventType() called with: eventType = [" + this.jdField_a_of_type_Int + "]" + str2 + "  retCode:" + this.jdField_b_of_type_Int + "  attachInfo: " + this.jdField_a_of_type_JavaLangString + "  timestamp: " + this.jdField_a_of_type_Long + "  launchId: " + str1 + " timecost: " + this.jdField_b_of_type_Long);
    }
    Object localObject = bhcg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bgos.a(this.jdField_b_of_type_JavaLangString), str2, this.jdField_a_of_type_JavaLangString, this.c, String.valueOf(this.jdField_b_of_type_Int), this.d, String.valueOf(this.jdField_b_of_type_Long), this.e, String.valueOf(this.jdField_a_of_type_Long), str1, this.f, this.g, this.h, this.i, this.j);
    if (!QUAUtil.isQQApp()) {
      ((List)localObject).addAll(bhcg.a());
    }
    APP_REPORT_TRANSFER.SingleDcData localSingleDcData = bhcg.a(bhby.a(), (List)localObject, null);
    bhch.a().a(localSingleDcData);
    if (bhck.a(this.d, str2, this.i))
    {
      localObject = bhcg.a(bhby.b(), (List)localObject, null);
      bhch.a().a((APP_REPORT_TRANSFER.SingleDcData)localObject);
      if (QMLog.isDebugEnabled()) {
        QMLog.d("MiniProgramLpReportDC04266", "MiniReportManager  [5332] reportEventType() called with: eventType = [" + this.jdField_a_of_type_Int + "]" + str2 + "  retCode:" + this.jdField_b_of_type_Int + "  attachInfo: " + this.jdField_a_of_type_JavaLangString + "  timestamp: " + this.jdField_a_of_type_Long + "  launchId: " + str1 + " timecost: " + this.jdField_b_of_type_Long);
      }
    }
    if (bhby.a(this.jdField_a_of_type_Int)) {
      bhch.a().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.1
 * JD-Core Version:    0.7.0.1
 */