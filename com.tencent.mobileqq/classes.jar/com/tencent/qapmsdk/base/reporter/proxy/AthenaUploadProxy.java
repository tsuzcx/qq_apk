package com.tencent.qapmsdk.base.reporter.proxy;

import android.os.Handler;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UrlMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.base.reporter.uploaddata.runnable.AthenaFileUploadRunnable;
import com.tencent.qapmsdk.base.reporter.uploaddata.runnable.AthenaJsonUploadRunnable;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.reporter.BaseJsonObject;
import com.tencent.qapmsdk.common.reporter.IReporter;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadManager.Companion;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/proxy/AthenaUploadProxy;", "Lcom/tencent/qapmsdk/common/reporter/IReporter;", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "report", "", "baseJson", "Lcom/tencent/qapmsdk/common/reporter/BaseJsonObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "reportFile", "", "jsonObject", "Lorg/json/JSONObject;", "query", "", "filePath", "reportJson", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AthenaUploadProxy
  implements IReporter
{
  public static final AthenaUploadProxy.Companion Companion = new AthenaUploadProxy.Companion(null);
  private static final String TAG = "QAPM_base_AthenaUploadProxy";
  @NotNull
  private final Handler handler = new Handler(ThreadManager.Companion.getReporterThreadLooper());
  
  private final void reportFile(JSONObject paramJSONObject, String paramString1, String paramString2, IReporter.ReportResultCallback paramReportResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseInfo.urlMeta.getAthenaFileUploadUrl());
    ((StringBuilder)localObject).append('?');
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      paramString1 = StringsKt.split$default((CharSequence)paramString2, new String[] { ";" }, false, 0, 6, null);
      paramString2 = Logger.INSTANCE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[athena_report] file url: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" jsonObj: ");
      localStringBuilder.append(paramJSONObject);
      localStringBuilder.append('}');
      paramString2.i(new String[] { "QAPM_base_AthenaUploadProxy", localStringBuilder.toString() });
      paramString2 = new URL((String)localObject);
      paramJSONObject = paramJSONObject.getJSONObject("meta");
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "jsonObject.getJSONObject(\"meta\")");
      paramJSONObject = new AthenaFileUploadRunnable(paramString2, paramJSONObject, paramString1, paramReportResultCallback);
      this.handler.post((Runnable)paramJSONObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Logger.INSTANCE.exception("QAPM_base_AthenaUploadProxy", (Throwable)paramJSONObject);
    }
  }
  
  private final void reportJson(JSONObject paramJSONObject, String paramString, IReporter.ReportResultCallback paramReportResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseInfo.urlMeta.getAthenaJsonUploadUrl());
    ((StringBuilder)localObject).append('?');
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = Logger.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[athena_report] json url: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" jsonObj: ");
    localStringBuilder.append(paramJSONObject);
    ((Logger)localObject).i(new String[] { "QAPM_base_AthenaUploadProxy", localStringBuilder.toString() });
    paramJSONObject = new AthenaJsonUploadRunnable(new URL(paramString), paramJSONObject, paramReportResultCallback);
    this.handler.post((Runnable)paramJSONObject);
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
    Object localObject2 = (ResultObject)localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((ResultObject)localObject2).getParams();
      paramBaseJsonObject = new StringBuffer(1024);
      try
      {
        localObject1 = ((JSONObject)localObject1).optString("fileObj");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "filePath");
        int i = ((CharSequence)localObject1).length();
        if (i == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          paramBaseJsonObject.append("format=2");
          paramBaseJsonObject.append("&user_id=");
          paramBaseJsonObject.append(BaseInfo.userMeta.uin);
          localObject1 = ((ResultObject)localObject2).getParams();
          paramBaseJsonObject = paramBaseJsonObject.toString();
          Intrinsics.checkExpressionValueIsNotNull(paramBaseJsonObject, "buffer.toString()");
          reportJson((JSONObject)localObject1, paramBaseJsonObject, paramReportResultCallback);
        }
        else
        {
          paramBaseJsonObject.append("format=1");
          paramBaseJsonObject.append("&user_id=");
          paramBaseJsonObject.append(BaseInfo.userMeta.uin);
          localObject2 = ((ResultObject)localObject2).getParams();
          paramBaseJsonObject = paramBaseJsonObject.toString();
          Intrinsics.checkExpressionValueIsNotNull(paramBaseJsonObject, "buffer.toString()");
          reportFile((JSONObject)localObject2, paramBaseJsonObject, (String)localObject1, paramReportResultCallback);
        }
        return true;
      }
      catch (Exception paramBaseJsonObject)
      {
        Logger.INSTANCE.exception("QAPM_base_AthenaUploadProxy", (Throwable)paramBaseJsonObject);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.proxy.AthenaUploadProxy
 * JD-Core Version:    0.7.0.1
 */