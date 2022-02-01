package com.tencent.mobileqq.intervideo.lite_now_biz.report;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigManager;
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.nearby.report.impl.ODReportTaskImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class DataReport
{
  private static String a(Bundle paramBundle, String paramString)
  {
    return NowBizConfigManager.a(paramBundle, paramString);
  }
  
  public static void a(Bundle paramBundle, String paramString, long paramLong1, long paramLong2)
  {
    String str = NowBizConfigManager.b(paramBundle);
    paramBundle = a(paramBundle, "fromid");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportStartAudioMediaService:");
      localStringBuilder.append(String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { "now_lite", str, paramBundle, Long.valueOf(paramLong2) }));
      QLog.i("NowDataReport", 1, localStringBuilder.toString());
    }
    new ODReportTaskImpl().setModule("QQ_now_room").setAction("audio_start").setUin(paramString).setUserId(paramString).setAnchor(paramLong1).setAnchorId(paramLong1).setOperName("now_lite").setRes2(str).setSource(paramBundle).setReferId(paramBundle).addKeyValue("roomid", paramLong2).setInstallSrc("406").report();
  }
  
  public static void a(Bundle paramBundle, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    paramBundle = a(paramBundle, "fromid");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportEnterRoom:");
      localStringBuilder.append(String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { "now_lite", paramString2, paramBundle, Long.valueOf(paramLong2) }));
      QLog.i("NowDataReport", 1, localStringBuilder.toString());
    }
    new ODReportTaskImpl().setModule("QQ_now_room").setAction("in").setUin(paramString1).setUserId(paramString1).setAnchor(paramLong1).setAnchorId(paramLong1).setOperName("now_lite").setRes2(paramString2).setSource(paramBundle).setReferId(paramBundle).addKeyValue("roomid", paramLong2).setInstallSrc("406").report();
  }
  
  public static void a(Bundle paramBundle, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    paramBundle = a(paramBundle, "fromid");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportExitRoom:");
      localStringBuilder.append(String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { "now_lite", paramString2, paramBundle, Long.valueOf(paramLong2) }));
      QLog.i("NowDataReport", 1, localStringBuilder.toString());
    }
    new ODReportTaskImpl().setModule("QQ_now_room").setAction("quit").setUin(paramString1).setUserId(paramString1).setAnchor(paramLong1).setAnchorId(paramLong1).setOperName("now_lite").setRes2(paramString2).setSource(paramBundle).setReferId(paramBundle).addKeyValue("roomid", paramLong2).addKeyValue("timelong", paramLong3).setInstallSrc("406").report();
  }
  
  public static void a(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = a(paramBundle, "fromid");
    String str2 = a(paramBundle, "roomid");
    String str3 = NowBizConfigManager.b(paramBundle);
    String str4 = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
    boolean bool = QLog.isColorLevel();
    String str1 = "now_lite";
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportNowClick:");
      if (paramBoolean) {
        paramBundle = "now_lite";
      } else {
        paramBundle = "now_jiehe";
      }
      localStringBuilder.append(String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { paramBundle, str3, localObject, str2 }));
      QLog.i("NowDataReport", 1, localStringBuilder.toString());
    }
    localObject = new ODReportTaskImpl().setModule("QQ_now_room").setAction("click").setUin(str4).setUserId(str4).setSource((String)localObject).setReferId((String)localObject);
    if (paramBoolean) {
      paramBundle = str1;
    } else {
      paramBundle = "now_jiehe";
    }
    ((IODReportTask)localObject).setOperName(paramBundle).setRes2(str3).addKeyValue("roomid", str2).setInstallSrc("406").report();
  }
  
  public static void b(Bundle paramBundle, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    paramBundle = a(paramBundle, "fromid");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportPageFinished:");
      localStringBuilder.append(String.format("version[%s] roomType[%s] fromId[%s] roomId[%s]", new Object[] { "now_lite", paramString2, paramBundle, Long.valueOf(paramLong2) }));
      QLog.i("NowDataReport", 1, localStringBuilder.toString());
    }
    new ODReportTaskImpl().setModule("QQ_now_room").setAction("load_finish").setUin(paramString1).setUserId(paramString1).setAnchor(paramLong1).setAnchorId(paramLong1).setOperName("now_lite").setRes2(paramString2).setSource(paramBundle).setReferId(paramBundle).addKeyValue("roomid", paramLong2).setInstallSrc("406").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.report.DataReport
 * JD-Core Version:    0.7.0.1
 */