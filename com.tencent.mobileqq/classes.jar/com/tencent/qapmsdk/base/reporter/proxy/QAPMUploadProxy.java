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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseInfo.urlMeta.getFileUploadUrl());
    ((StringBuilder)localObject).append('?');
    ((StringBuilder)localObject).append(paramString1);
    paramString1 = ((StringBuilder)localObject).toString();
    localObject = Logger.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[qapm_report] file url: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" jsonObj: ");
    localStringBuilder.append(paramResultObject.getParams());
    ((Logger)localObject).i(new String[] { "QAPM_base_QAPMUploadProxy", localStringBuilder.toString() });
    paramResultObject = new FileUploadRunnable(new URL(paramString1), paramResultObject, paramReportResultCallback, this.handler, paramString2);
    this.handler.post((Runnable)paramResultObject);
  }
  
  private final void reportJson(ResultObject paramResultObject, String paramString, IReporter.ReportResultCallback paramReportResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseInfo.urlMeta.getJsonUploadUrl());
    ((StringBuilder)localObject).append('?');
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = Logger.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[qapm_report] json url: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" jsonObj: ");
    localStringBuilder.append(paramResultObject.getParams());
    ((Logger)localObject).i(new String[] { "QAPM_base_QAPMUploadProxy", localStringBuilder.toString() });
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
    Object localObject1 = paramBaseJsonObject;
    if (!(paramBaseJsonObject instanceof ResultObject)) {
      localObject1 = null;
    }
    localObject1 = (ResultObject)localObject1;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((ResultObject)localObject1).getParams();
      paramBaseJsonObject = new StringBuffer(1024);
    }
    for (;;)
    {
      try
      {
        Object localObject3 = StringUtil.Companion;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(BaseInfo.userMeta.uuid);
        ((StringBuilder)localObject4).append(System.currentTimeMillis());
        ((JSONObject)localObject2).put("client_identify", ((StringUtil.Companion)localObject3).getMD5(((StringBuilder)localObject4).toString()));
        localObject3 = BaseInfo.pubJson.keys();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "BaseInfo.pubJson.keys()");
        localObject3 = SequencesKt.filter(SequencesKt.asSequence((Iterator)localObject3), (Function1)QAPMUploadProxy.report.1.INSTANCE).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          paramBaseJsonObject.append("&");
          paramBaseJsonObject.append((String)localObject4);
          paramBaseJsonObject.append("=");
          paramBaseJsonObject.append(URLEncoder.encode(BaseInfo.pubJson.getString((String)localObject4), "UTF-8"));
          continue;
        }
        paramBaseJsonObject.append("&a=1");
        if (((CharSequence)paramBaseJsonObject).length() != 0) {
          break label347;
        }
        i = 1;
        if (i != 0) {
          paramBaseJsonObject = paramBaseJsonObject.toString();
        } else {
          paramBaseJsonObject = paramBaseJsonObject.substring(1, paramBaseJsonObject.length());
        }
        localObject2 = ((JSONObject)localObject2).optString("fileObj");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "filePath");
        i = ((CharSequence)localObject2).length();
        if (i == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          Intrinsics.checkExpressionValueIsNotNull(paramBaseJsonObject, "urlQuery");
          reportJson((ResultObject)localObject1, paramBaseJsonObject, paramReportResultCallback);
        }
        else
        {
          Intrinsics.checkExpressionValueIsNotNull(paramBaseJsonObject, "urlQuery");
          reportFile((ResultObject)localObject1, paramBaseJsonObject, (String)localObject2, paramReportResultCallback);
        }
        return true;
      }
      catch (Exception paramBaseJsonObject)
      {
        Logger.INSTANCE.exception("QAPM_base_QAPMUploadProxy", (Throwable)paramBaseJsonObject);
      }
      return false;
      label347:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.proxy.QAPMUploadProxy
 * JD-Core Version:    0.7.0.1
 */