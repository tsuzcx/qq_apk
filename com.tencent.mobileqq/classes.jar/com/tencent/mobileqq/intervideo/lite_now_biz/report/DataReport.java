package com.tencent.mobileqq.intervideo.lite_now_biz.report;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigManager;
import com.tencent.mobileqq.nearby.report.ODReportTask;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class DataReport
{
  private static String a(Bundle paramBundle, String paramString)
  {
    return NowBizConfigManager.a(paramBundle, paramString);
  }
  
  public static void a(Bundle paramBundle, String paramString)
  {
    String str1 = NowBizConfigManager.b(paramBundle);
    String str2 = a(paramBundle, "fromid");
    paramBundle = a(paramBundle, "roomid");
    if (QLog.isColorLevel()) {
      QLog.i("NowDataReport", 1, "reportStartAudioMediaService:" + String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { "now_lite", str1, str2, paramBundle }));
    }
    new ODReportTask().b("QQ_now_room").c("audio_start").a(paramString).i("now_lite").j(str1).d(str2).a("roomId", paramBundle).a();
  }
  
  public static void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    String str = a(paramBundle, "fromid");
    paramBundle = a(paramBundle, "roomid");
    if (QLog.isColorLevel()) {
      QLog.i("NowDataReport", 1, "reportEnterRoom:" + String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { "now_lite", paramString2, str, paramBundle }));
    }
    new ODReportTask().b("QQ_now_room").c("in").a(paramString1).i("now_lite").j(paramString2).d(str).a("roomId", paramBundle).a();
  }
  
  public static void a(Bundle paramBundle, String paramString1, String paramString2, long paramLong)
  {
    String str = a(paramBundle, "fromid");
    paramBundle = a(paramBundle, "roomid");
    if (QLog.isColorLevel()) {
      QLog.i("NowDataReport", 1, "reportExitRoom:" + String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { "now_lite", paramString2, str, paramBundle }));
    }
    new ODReportTask().b("QQ_now_room").c("quit").a(paramString1).i("now_lite").j(paramString2).d(str).a("roomId", paramBundle).a("timelong", paramLong).a();
  }
  
  public static void a(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = a(paramBundle, "fromid");
    String str1 = a(paramBundle, "roomid");
    String str2 = NowBizConfigManager.b(paramBundle);
    String str3 = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("reportNowClick:");
      if (paramBoolean)
      {
        paramBundle = "now_lite";
        QLog.i("NowDataReport", 1, String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { paramBundle, str2, localObject, str1 }));
      }
    }
    else
    {
      localObject = new ODReportTask().b("QQ_now_room").c("click").a(str3).d((String)localObject);
      if (!paramBoolean) {
        break label160;
      }
    }
    label160:
    for (paramBundle = "now_lite";; paramBundle = "now_jiehe")
    {
      ((ODReportTask)localObject).i(paramBundle).j(str2).a("roomId", str1).a();
      return;
      paramBundle = "now_jiehe";
      break;
    }
  }
  
  public static void b(Bundle paramBundle, String paramString1, String paramString2)
  {
    String str = a(paramBundle, "fromid");
    paramBundle = a(paramBundle, "roomid");
    if (QLog.isColorLevel()) {
      QLog.i("NowDataReport", 1, "reportPageFinished:" + String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { "now_lite", paramString2, str, paramBundle }));
    }
    new ODReportTask().b("QQ_now_room").c("load_finish").a(paramString1).i("now_lite").j(paramString2).d(str).a("roomId", paramBundle).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.report.DataReport
 * JD-Core Version:    0.7.0.1
 */