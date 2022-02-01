package com.tencent.mobileqq.dt;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/dt/QQDtReporter;", "Lcom/tencent/qqlive/module/videoreport/dtreport/api/IDTReport;", "()V", "dtEvent", "", "obj", "", "eventKey", "", "params", "", "isImmediatelyUpload", "appkey", "isQQPrivateReport", "shouldEventImmediatelyUpload", "shouldImmediatelyUpload", "appKey", "shouldPrintLog", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQDtReporter
  implements IDTReport
{
  public static final QQDtReporter.Companion a;
  private static volatile QQDtReporter a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqDtQQDtReporter$Companion = new QQDtReporter.Companion(null);
  }
  
  private final boolean a(String paramString)
  {
    return Intrinsics.areEqual(paramString, "00000QG6YX3X0LZH");
  }
  
  @Nullable
  public static final QQDtReporter b()
  {
    return jdField_a_of_type_ComTencentMobileqqDtQQDtReporter$Companion.a();
  }
  
  private final boolean b(String paramString)
  {
    return (Intrinsics.areEqual("qqout", paramString)) || (Intrinsics.areEqual("qqin", paramString)) || (Intrinsics.areEqual(paramString, "dt_pgin")) || (Intrinsics.areEqual(paramString, "dt_clck"));
  }
  
  private final boolean c(String paramString)
  {
    return (d(paramString)) || (Intrinsics.areEqual(paramString, "dt_appin")) || (Intrinsics.areEqual(paramString, "dt_appout")) || (Intrinsics.areEqual(paramString, "dt_act")) || (Intrinsics.areEqual(paramString, "dt_vst")) || (Intrinsics.areEqual(paramString, "dt_pgin")) || (Intrinsics.areEqual(paramString, "dt_pgout")) || (Intrinsics.areEqual(paramString, "dt_clck")) || (QLog.isColorLevel());
  }
  
  private final boolean d(String paramString)
  {
    return (Intrinsics.areEqual(paramString, "qqin")) || (Intrinsics.areEqual(paramString, "qqout"));
  }
  
  public boolean dtEvent(@Nullable Object paramObject, @Nullable String paramString, @Nullable Map<String, String> paramMap, boolean paramBoolean)
  {
    int i = 0;
    if (paramString == null) {
      return false;
    }
    if (b(paramString)) {
      paramBoolean = true;
    }
    for (;;)
    {
      if (c(paramString)) {
        QLog.d("QQDtReporter", 1, new Object[] { "848QQDT _report event: " + paramString, ",isImmediatelyUpload:", Boolean.valueOf(paramBoolean), ",params:", paramMap });
      }
      QQDtReportHelper.a(paramString, paramMap);
      if (paramMap != null) {}
      for (String str = (String)paramMap.get("dt_appkey");; str = null)
      {
        CharSequence localCharSequence = (CharSequence)str;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
          i = 1;
        }
        if (i == 0) {
          break;
        }
        UserAction.onDTUserAction((Context)BaseApplication.context, paramString, true, -1L, -1L, paramMap, paramBoolean, paramBoolean);
        return true;
      }
      dtEvent(paramObject, paramString, paramMap, paramBoolean, str);
      return true;
    }
  }
  
  public boolean dtEvent(@Nullable Object paramObject, @Nullable String paramString1, @Nullable Map<String, String> paramMap, boolean paramBoolean, @Nullable String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    if (paramString2 == null)
    {
      dtEvent(paramObject, paramString1, paramMap, paramBoolean);
      return false;
    }
    if ((a(paramString2)) || (b(paramString1))) {
      paramBoolean = true;
    }
    for (;;)
    {
      if (c(paramString1)) {
        QLog.d("QQDtReporter", 1, new Object[] { "848QQDT _report eventkey: " + paramString1, " , appkey:" + paramString2, " , isImmediatelyUpload:", Boolean.valueOf(paramBoolean), " , isImmediatelyUpload:", Boolean.valueOf(paramBoolean), " , params:", paramMap });
      }
      QQDtReportHelper.a(paramString1, paramMap);
      UserAction.onDTUserActionToTunnel((Context)BaseApplication.context, paramString2, paramString1, paramMap, paramBoolean, paramBoolean);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dt.QQDtReporter
 * JD-Core Version:    0.7.0.1
 */