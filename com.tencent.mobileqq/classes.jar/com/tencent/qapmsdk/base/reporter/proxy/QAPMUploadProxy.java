package com.tencent.qapmsdk.base.reporter.proxy;

import android.os.Handler;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UrlMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.base.reporter.uploaddata.runnable.FileUploadRunnable;
import com.tencent.qapmsdk.base.reporter.uploaddata.runnable.JsonUploadRunnable;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.reporter.BaseJsonObject;
import com.tencent.qapmsdk.common.reporter.IReporter;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadManager.Companion;
import com.tencent.qapmsdk.common.util.StringUtil;
import com.tencent.qapmsdk.common.util.StringUtil.Companion;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/proxy/QAPMUploadProxy;", "Lcom/tencent/qapmsdk/common/reporter/IReporter;", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "report", "", "baseJson", "Lcom/tencent/qapmsdk/common/reporter/BaseJsonObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "reportFile", "", "resultObject", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "query", "", "filePath", "reportJson", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class QAPMUploadProxy
  implements IReporter
{
  public static final QAPMUploadProxy.Companion Companion = new QAPMUploadProxy.Companion(null);
  private static final String TAG = "QAPM_base_QAPMUploadProxy";
  @NotNull
  private final Handler handler = new Handler(ThreadManager.Companion.getReporterThreadLooper());
  
  private final void reportFile(ResultObject paramResultObject, String paramString1, String paramString2, IReporter.ReportResultCallback paramReportResultCallback)
  {
    paramString1 = BaseInfo.urlMeta.getFileUploadUrl() + '?' + paramString1;
    Logger.INSTANCE.i(new String[] { "QAPM_base_QAPMUploadProxy", "[qapm_report] file url: " + paramString1 + " jsonObj: " + paramResultObject.getParams() });
    paramResultObject = new FileUploadRunnable(new URL(paramString1), paramResultObject, paramReportResultCallback, this.handler, paramString2);
    this.handler.post((Runnable)paramResultObject);
  }
  
  private final void reportJson(ResultObject paramResultObject, String paramString, IReporter.ReportResultCallback paramReportResultCallback)
  {
    paramString = BaseInfo.urlMeta.getJsonUploadUrl() + '?' + paramString;
    Logger.INSTANCE.i(new String[] { "QAPM_base_QAPMUploadProxy", "[qapm_report] json url: " + paramString + " jsonObj: " + paramResultObject.getParams() });
    paramResultObject = new JsonUploadRunnable(new URL(paramString), paramResultObject, paramReportResultCallback, this.handler);
    this.handler.post((Runnable)paramResultObject);
  }
  
  @NotNull
  public final Handler getHandler()
  {
    return this.handler;
  }
  
  public boolean report(@NotNull BaseJsonObject paramBaseJsonObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseJsonObject, "baseJson");
    ResultObject localResultObject;
    Object localObject;
    if (!(paramBaseJsonObject instanceof ResultObject))
    {
      paramBaseJsonObject = null;
      localResultObject = (ResultObject)paramBaseJsonObject;
      if (localResultObject == null) {
        break label316;
      }
      localObject = localResultObject.getParams();
      paramBaseJsonObject = new StringBuffer(1024);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("client_identify", StringUtil.Companion.getMD5(BaseInfo.userMeta.uuid + System.currentTimeMillis()));
        Iterator localIterator = BaseInfo.pubJson.keys();
        Intrinsics.checkExpressionValueIsNotNull(localIterator, "BaseInfo.pubJson.keys()");
        localIterator = SequencesKt.filter(SequencesKt.asSequence(localIterator), (Function1)QAPMUploadProxy.report.1.INSTANCE).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramBaseJsonObject.append("&").append(str).append("=").append(URLEncoder.encode(BaseInfo.pubJson.getString(str), "UTF-8"));
          continue;
        }
        paramBaseJsonObject.append("&a=1");
        if (((CharSequence)paramBaseJsonObject).length() != 0) {
          break label320;
        }
        i = 1;
        if (i != 0)
        {
          paramBaseJsonObject = paramBaseJsonObject.toString();
          localObject = ((JSONObject)localObject).optString("fileObj");
          Intrinsics.checkExpressionValueIsNotNull(localObject, "filePath");
          if (((CharSequence)localObject).length() != 0) {
            break label325;
          }
          i = 1;
          if (i != 0)
          {
            Intrinsics.checkExpressionValueIsNotNull(paramBaseJsonObject, "urlQuery");
            reportJson(localResultObject, paramBaseJsonObject, paramReportResultCallback);
            break label318;
          }
        }
        else
        {
          paramBaseJsonObject = paramBaseJsonObject.substring(1, paramBaseJsonObject.length());
          continue;
        }
        Intrinsics.checkExpressionValueIsNotNull(paramBaseJsonObject, "urlQuery");
        reportFile(localResultObject, paramBaseJsonObject, (String)localObject, paramReportResultCallback);
      }
      catch (Exception paramBaseJsonObject)
      {
        Logger.INSTANCE.exception("QAPM_base_QAPMUploadProxy", (Throwable)paramBaseJsonObject);
        return false;
      }
      break;
      label316:
      return false;
      label318:
      return true;
      label320:
      int i = 0;
      continue;
      label325:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.proxy.QAPMUploadProxy
 * JD-Core Version:    0.7.0.1
 */