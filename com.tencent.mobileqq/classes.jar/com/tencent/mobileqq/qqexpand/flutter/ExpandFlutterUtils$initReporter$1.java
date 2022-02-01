package com.tencent.mobileqq.qqexpand.flutter;

import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin.QFlutterReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.LongRef;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$initReporter$1", "Lcom/qflutter/qflutter_beacon_reporter/QflutterBeaconReporterPlugin$QFlutterReporter;", "doReport", "", "appkey", "", "channelId", "eventName", "isSucceed", "", "elapse", "", "size", "params", "", "reportImmediately", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Boolean;)V", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils$initReporter$1
  implements QflutterBeaconReporterPlugin.QFlutterReporter
{
  public void doReport(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Boolean paramBoolean1, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Map<String, String> paramMap, @Nullable Boolean paramBoolean2)
  {
    paramString2 = new Ref.BooleanRef();
    paramString2.element = false;
    if (paramBoolean1 != null)
    {
      paramBoolean1.booleanValue();
      paramString2.element = paramBoolean1.booleanValue();
    }
    paramBoolean1 = new Ref.LongRef();
    paramBoolean1.element = 0L;
    if (paramInteger1 != null)
    {
      ((Number)paramInteger1).intValue();
      paramBoolean1.element = paramInteger1.intValue();
    }
    paramInteger1 = new Ref.LongRef();
    paramInteger1.element = 0L;
    if (paramInteger2 != null)
    {
      ((Number)paramInteger2).intValue();
      paramInteger1.element = paramInteger2.intValue();
    }
    paramInteger2 = new Ref.BooleanRef();
    paramInteger2.element = false;
    if (paramBoolean2 != null)
    {
      paramBoolean2.booleanValue();
      paramInteger2.element = paramBoolean2.booleanValue();
    }
    ThreadManager.getSubThreadHandler().post((Runnable)new ExpandFlutterUtils.initReporter.1.doReport.5(this, paramString1, paramString3, paramString2, paramBoolean1, paramInteger1, paramMap, paramInteger2));
    if (QLog.isColorLevel()) {}
    try
    {
      paramBoolean2 = new StringBuilder();
      paramBoolean2.append("[doReport] appkey=");
      paramBoolean2.append(paramString1);
      paramBoolean2.append(" eventName=");
      paramBoolean2.append(paramString3);
      paramBoolean2.append(" isSucc=");
      paramBoolean2.append(paramString2.element);
      paramBoolean2.append(' ');
      paramBoolean2.append("longElapse=");
      paramBoolean2.append(paramBoolean1.element);
      paramBoolean2.append(" longSize=");
      paramBoolean2.append(paramInteger1.element);
      paramBoolean2.append(" params=");
      paramBoolean2.append(paramMap);
      paramBoolean2.append(" immediat=");
      paramBoolean2.append(paramInteger2.element);
      QLog.d("ExpandFlutterUtils", 2, paramBoolean2.toString());
      return;
    }
    catch (Exception paramString1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterUtils.initReporter.1
 * JD-Core Version:    0.7.0.1
 */