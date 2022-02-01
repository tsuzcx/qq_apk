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
    String str = BaseInfo.urlMeta.getAthenaFileUploadUrl() + '?' + paramString1;
    try
    {
      paramString1 = StringsKt.split$default((CharSequence)paramString2, new String[] { ";" }, false, 0, 6, null);
      Logger.INSTANCE.i(new String[] { "QAPM_base_AthenaUploadProxy", "[athena_report] file url: " + str + " jsonObj: " + paramJSONObject + '}' });
      paramString2 = new URL(str);
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
    paramString = BaseInfo.urlMeta.getAthenaJsonUploadUrl() + '?' + paramString;
    Logger.INSTANCE.i(new String[] { "QAPM_base_AthenaUploadProxy", "[athena_report] json url: " + paramString + " jsonObj: " + paramJSONObject });
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
    Object localObject2;
    Object localObject1;
    if (!(paramBaseJsonObject instanceof ResultObject))
    {
      paramBaseJsonObject = null;
      localObject2 = (ResultObject)paramBaseJsonObject;
      if (localObject2 == null) {
        break label201;
      }
      localObject1 = ((ResultObject)localObject2).getParams();
      paramBaseJsonObject = new StringBuffer(1024);
    }
    for (;;)
    {
      try
      {
        localObject1 = ((JSONObject)localObject1).optString("fileObj");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "filePath");
        if (((CharSequence)localObject1).length() != 0) {
          break label203;
        }
        i = 1;
        if (i != 0)
        {
          paramBaseJsonObject.append("format=2").append("&user_id=").append(BaseInfo.userMeta.uin);
          localObject1 = ((ResultObject)localObject2).getParams();
          paramBaseJsonObject = paramBaseJsonObject.toString();
          Intrinsics.checkExpressionValueIsNotNull(paramBaseJsonObject, "buffer.toString()");
          reportJson((JSONObject)localObject1, paramBaseJsonObject, paramReportResultCallback);
        }
        else
        {
          paramBaseJsonObject.append("format=1").append("&user_id=").append(BaseInfo.userMeta.uin);
          localObject2 = ((ResultObject)localObject2).getParams();
          paramBaseJsonObject = paramBaseJsonObject.toString();
          Intrinsics.checkExpressionValueIsNotNull(paramBaseJsonObject, "buffer.toString()");
          reportFile((JSONObject)localObject2, paramBaseJsonObject, (String)localObject1, paramReportResultCallback);
        }
      }
      catch (Exception paramBaseJsonObject)
      {
        Logger.INSTANCE.exception("QAPM_base_AthenaUploadProxy", (Throwable)paramBaseJsonObject);
        return false;
      }
      break;
      return true;
      label201:
      return false;
      label203:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.proxy.AthenaUploadProxy
 * JD-Core Version:    0.7.0.1
 */