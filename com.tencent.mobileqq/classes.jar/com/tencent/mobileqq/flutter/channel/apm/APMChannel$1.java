package com.tencent.mobileqq.flutter.channel.apm;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.mobileqq.flutter.report.QFlutterReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;

class APMChannel$1
  extends APMChannelHandler
{
  APMChannel$1(APMChannel paramAPMChannel) {}
  
  protected void a(String paramString, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("recordPageView: %s", new Object[] { paramString }));
    }
    QFlutterReporter.c(paramString);
    paramResult.success(null);
  }
  
  protected void a(String paramString, Integer paramInteger, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("reportPageLoadTime: pathPath: %s, loadTime: %s", new Object[] { paramString, paramInteger }));
    }
    QFlutterReporter.a(paramString, paramInteger.intValue());
    paramResult.success(null);
  }
  
  protected void a(String paramString, Integer paramInteger, Double paramDouble, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("recordFPS: pathPath: %s, fps: %s, dropRate: %s", new Object[] { paramString, paramInteger, paramDouble }));
    }
    QFlutterReporter.a(paramString, paramInteger.intValue(), paramDouble.doubleValue());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("qflutter_qqgame"))) {
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportToAttaForFps(paramString, paramInteger.intValue());
    }
    paramResult.success(null);
  }
  
  protected void a(String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4, @NonNull HashMap<String, String> paramHashMap, MethodChannel.Result paramResult)
  {
    QLog.e("flutter.APMChannel", 1, String.format("reportException, msg: %s, stack: %s", new Object[] { paramString3, paramString4 }));
    paramHashMap.put("qflutterVersion", QFlutterReporter.b());
    CrashReport.postException(paramInteger.intValue(), paramString2, paramString3, paramString4, paramHashMap);
    QFlutterReporter.b(paramString1);
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("qflutter_qqgame"))) {
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportToAttaForException(paramString1, paramString2, paramString3, paramString4);
    }
    paramResult.success(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.apm.APMChannel.1
 * JD-Core Version:    0.7.0.1
 */