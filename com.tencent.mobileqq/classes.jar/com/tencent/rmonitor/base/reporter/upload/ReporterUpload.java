package com.tencent.rmonitor.base.reporter.upload;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.rmonitor.base.authorization.Authorization;
import com.tencent.rmonitor.base.authorization.AuthorizationProxy;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.base.reporter.statistics.ErrorStatistics;
import com.tencent.rmonitor.base.upload.QAPMUpload;
import com.tencent.rmonitor.common.logger.Logger;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/upload/ReporterUpload;", "Lcom/tencent/rmonitor/base/upload/QAPMUpload;", "url", "Ljava/net/URL;", "handler", "Landroid/os/Handler;", "reportData", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "callback", "Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "(Ljava/net/URL;Landroid/os/Handler;Lcom/tencent/rmonitor/base/reporter/data/ReportData;Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;)V", "getCallback", "()Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "getHandler", "()Landroid/os/Handler;", "getReportData", "()Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "retry", "", "getRetry", "()I", "setRetry", "(I)V", "addLost", "", "plugin", "code", "resp", "", "category", "checkAuthorization", "", "dealResp", "responseCode", "delayInMs", "", "onSuccess", "Lkotlin/Function0;", "(Ljava/lang/String;IJLkotlin/jvm/functions/Function0;)Lkotlin/Unit;", "doAuthorization", "getRunnable", "Ljava/lang/Runnable;", "isSucceeded", "reSend", "delay", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract class ReporterUpload
  extends QAPMUpload
{
  public static final ReporterUpload.Companion b = new ReporterUpload.Companion(null);
  private int a;
  @NotNull
  private final Handler e;
  @NotNull
  private final ReportData f;
  @Nullable
  private final IReporter.ReportCallback g;
  
  public ReporterUpload(@NotNull URL paramURL, @NotNull Handler paramHandler, @NotNull ReportData paramReportData, @Nullable IReporter.ReportCallback paramReportCallback)
  {
    super(paramURL);
    this.e = paramHandler;
    this.f = paramReportData;
    this.g = paramReportCallback;
  }
  
  private final void f()
  {
    AuthorizationProxy.a.a().a(BaseInfo.userMeta.appKey, false);
  }
  
  @NotNull
  public abstract Runnable a();
  
  @Nullable
  public final Unit a(@NotNull String paramString, int paramInt, long paramLong, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resp");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "onSuccess");
    if (a(paramString))
    {
      paramString = this.g;
      if (paramString != null) {
        paramString.t_(this.f.getDbId());
      }
      return (Unit)paramFunction0.invoke();
    }
    if (this.a > 0)
    {
      a(paramLong);
      return Unit.INSTANCE;
    }
    a(this.f.getPlugin(), paramInt, paramString, this.f.getEventName());
    paramFunction0 = this.g;
    if (paramFunction0 != null)
    {
      paramFunction0.a(paramInt, paramString, this.f.getDbId());
      return Unit.INSTANCE;
    }
    return null;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "resp");
    Intrinsics.checkParameterIsNotNull(paramString2, "category");
    try
    {
      if (Intrinsics.areEqual(paramString2, "Error")) {
        return;
      }
      localObject = "0";
      if (paramInt2 == 200) {
        localObject = String.valueOf(new JSONObject(paramString1).getInt("status"));
      }
      ErrorStatistics.a.a(paramInt1, String.valueOf(paramInt2), (String)localObject, paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString2 = Logger.b;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(": add lost data may be error");
      paramString2.e(new String[] { "RMonitor_base_ReporterUpload", ((StringBuilder)localObject).toString() });
    }
  }
  
  public final void a(long paramLong)
  {
    int i = this.a;
    if (i > 0)
    {
      this.a = (i - 1);
      this.e.postDelayed(a(), paramLong);
    }
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resp");
    boolean bool = false;
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return true;
      }
      int i = new JSONObject(paramString).getInt("status");
      if ((i != 1000) && (i != 1495))
      {
        if (i == 1408)
        {
          f();
          return false;
        }
      }
      else {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString)
    {
      Logger localLogger = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": response parameter json error");
      localLogger.e(new String[] { "RMonitor_base_ReporterUpload", localStringBuilder.toString() });
    }
    return false;
  }
  
  public final boolean b()
  {
    return (ConfigProxy.INSTANCE.getConfig().b("NEED_AUTHORIZATION")) && (TextUtils.isEmpty((CharSequence)BaseInfo.token)) && (!AuthorizationProxy.a.a().a(BaseInfo.userMeta.appKey, true));
  }
  
  @NotNull
  public final ReportData c()
  {
    return this.f;
  }
  
  @Nullable
  public final IReporter.ReportCallback d()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.upload.ReporterUpload
 * JD-Core Version:    0.7.0.1
 */