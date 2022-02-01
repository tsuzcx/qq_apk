package com.tencent.rmonitor.base.reporter.upload;

import android.os.Handler;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UrlMeta;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.reporter.IReporter;
import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.StringUtil;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/upload/QAPMUploadProxy;", "Lcom/tencent/rmonitor/base/reporter/IReporter;", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "reportFile", "", "reportData", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "query", "", "filePath", "callback", "Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "reportJson", "reportNow", "", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class QAPMUploadProxy
  implements IReporter
{
  public static final QAPMUploadProxy.Companion a = new QAPMUploadProxy.Companion(null);
  private final Handler b;
  
  public QAPMUploadProxy(@NotNull Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  private final void a(ReportData paramReportData, String paramString, IReporter.ReportCallback paramReportCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.getJsonUploadUrl());
    localStringBuilder.append('?');
    localStringBuilder.append(paramString);
    paramReportData = new JsonUploadRunnable(new URL(localStringBuilder.toString()), this.b, paramReportData, paramReportCallback);
    this.b.post((Runnable)paramReportData);
  }
  
  private final void a(ReportData paramReportData, String paramString1, String paramString2, IReporter.ReportCallback paramReportCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.getFileUploadUrl());
    localStringBuilder.append('?');
    localStringBuilder.append(paramString1);
    paramReportData = new FileUploadRunnable(new URL(localStringBuilder.toString()), this.b, paramReportData, paramReportCallback, paramString2);
    this.b.post((Runnable)paramReportData);
  }
  
  public boolean a(@NotNull ReportData paramReportData, @Nullable IReporter.ReportCallback paramReportCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramReportData, "reportData");
    Object localObject1 = paramReportData.getParams();
    for (;;)
    {
      try
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(BaseInfo.userMeta.uuid);
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        ((JSONObject)localObject1).put("client_identify", StringUtil.b(((StringBuilder)localObject2).toString()));
        localObject2 = new StringBuffer(1024);
        Iterator localIterator = BaseInfo.pubJson.keys();
        Intrinsics.checkExpressionValueIsNotNull(localIterator, "BaseInfo.pubJson.keys()");
        localIterator = SequencesKt.filter(SequencesKt.asSequence(localIterator), (Function1)QAPMUploadProxy.reportNow.1.INSTANCE).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((StringBuffer)localObject2).append("&");
          ((StringBuffer)localObject2).append(str);
          ((StringBuffer)localObject2).append("=");
          ((StringBuffer)localObject2).append(URLEncoder.encode(BaseInfo.pubJson.getString(str), "UTF-8"));
          continue;
        }
        ((StringBuffer)localObject2).append("&a=1");
        localObject2 = ((StringBuffer)localObject2).substring(1, ((StringBuffer)localObject2).length());
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "buffer.substring(1, buffer.length)");
        localObject1 = ((JSONObject)localObject1).optString("fileObj");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "filePath");
        if (((CharSequence)localObject1).length() == 0)
        {
          i = 1;
          if (i != 0) {
            a(paramReportData, (String)localObject2, paramReportCallback);
          } else {
            a(paramReportData, (String)localObject2, (String)localObject1, paramReportCallback);
          }
          return true;
        }
      }
      catch (Exception paramReportData)
      {
        Logger.b.a("RMonitor_base_QAPMUploadProxy", (Throwable)paramReportData);
        return false;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.upload.QAPMUploadProxy
 * JD-Core Version:    0.7.0.1
 */