package com.tencent.mobileqq.dt;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.QQBeaconReport;
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
  public static final QQDtReporter.Companion a = new QQDtReporter.Companion(null);
  private static volatile QQDtReporter b;
  
  private final boolean a(String paramString)
  {
    return Intrinsics.areEqual(paramString, "00000QG6YX3X0LZH");
  }
  
  @Nullable
  public static final QQDtReporter b()
  {
    return a.a();
  }
  
  private final boolean b(String paramString)
  {
    return (Intrinsics.areEqual("qqout", paramString)) || (Intrinsics.areEqual("qqin", paramString)) || (Intrinsics.areEqual(paramString, "dt_pgin")) || (Intrinsics.areEqual(paramString, "dt_clck"));
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("848QQDT _report event: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("QQDtReporter", 1, new Object[] { ((StringBuilder)localObject).toString(), ",isImmediatelyUpload:", Boolean.valueOf(paramBoolean), ",params:", paramMap });
    QQDtReportHelper.a(paramString, paramMap);
    if (paramMap != null) {
      localObject = (String)paramMap.get("dt_appkey");
    } else {
      localObject = null;
    }
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    if (i != 0)
    {
      QQBeaconReport.a("0S200MNJT807V3GE", "", paramString, true, paramMap, paramBoolean);
      return true;
    }
    dtEvent(paramObject, paramString, paramMap, paramBoolean, (String)localObject);
    return true;
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
    if ((!a(paramString2)) && (!b(paramString1))) {
      break label49;
    }
    paramBoolean = true;
    label49:
    paramObject = new StringBuilder();
    paramObject.append("848QQDT _report eventkey: ");
    paramObject.append(paramString1);
    paramObject = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" , appkey:");
    localStringBuilder.append(paramString2);
    QLog.d("QQDtReporter", 1, new Object[] { paramObject, localStringBuilder.toString(), " , isImmediatelyUpload:", Boolean.valueOf(paramBoolean), " , isImmediatelyUpload:", Boolean.valueOf(paramBoolean), " , params:", paramMap });
    QQDtReportHelper.a(paramString1, paramMap);
    UserAction.onDTUserActionToTunnel((Context)BaseApplication.context, paramString2, paramString1, paramMap, paramBoolean, paramBoolean);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dt.QQDtReporter
 * JD-Core Version:    0.7.0.1
 */