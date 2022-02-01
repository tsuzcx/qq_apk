package com.tencent.mobileqq.vashealth.api.impl;

import android.content.Context;
import android.os.Message;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.vashealth.RunningBannerProcessor;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.StepCounterServlert;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.mobileqq.vashealth.VSHealthUtil;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthApiImpl;", "Lcom/tencent/mobileqq/vashealth/api/IQQHealthApi;", "()V", "SP_LBS_LATITUDE", "", "SP_LBS_LOGITUDE", "SP_LBS_UPDATE_TIME_STAMP", "checkRedPackRequest", "", "appRuntime", "Lmqq/app/AppRuntime;", "getStepCounterServletIntent", "Lmqq/app/NewIntent;", "appContext", "Landroid/content/Context;", "getTracePathDataClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/persistence/Entity;", "getTracePointDataClass", "hideBanner", "isHealthUin", "", "uin", "isNeedRedirectAIOToMainPage", "isNeedReport", "isSupportStepCounter", "setIsOldMode", "isOldMode", "showBanner", "runningState", "", "cookieUrl", "Companion", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class QQHealthApiImpl
  implements IQQHealthApi
{
  @Deprecated
  public static final QQHealthApiImpl.Companion Companion = new QQHealthApiImpl.Companion(null);
  private static final String TAG = "QQHealthApiImpl";
  
  @NotNull
  public String SP_LBS_LATITUDE()
  {
    return "search_lbs_latitude";
  }
  
  @NotNull
  public String SP_LBS_LOGITUDE()
  {
    return "search_lbs_logitude";
  }
  
  @NotNull
  public String SP_LBS_UPDATE_TIME_STAMP()
  {
    return "search_lbs_timestamp";
  }
  
  public void checkRedPackRequest(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    SSOHttpUtils.a(paramAppRuntime);
  }
  
  @Nullable
  public NewIntent getStepCounterServletIntent(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "appContext");
    paramContext = new NewIntent(paramContext, StepCounterServlert.class);
    paramContext.putExtra("msf_cmd_type", "cmd_health_switch");
    return paramContext;
  }
  
  @NotNull
  public Class<? extends Entity> getTracePathDataClass()
  {
    return TracePathData.class;
  }
  
  @NotNull
  public Class<? extends Entity> getTracePointDataClass()
  {
    return TracePointsData.class;
  }
  
  public void hideBanner()
  {
    BannerManager.a().a(RunningBannerProcessor.a, 3000, 1000L);
  }
  
  public boolean isHealthUin(@Nullable String paramString)
  {
    return Intrinsics.areEqual("3026775809", paramString);
  }
  
  public boolean isNeedRedirectAIOToMainPage(@Nullable String paramString)
  {
    return VSHealthUtil.a(paramString);
  }
  
  public boolean isNeedReport(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    return SSOHttpUtils.a(1, paramString);
  }
  
  public boolean isSupportStepCounter(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "appContext");
    return SportManagerImpl.isSupportStepCounter(paramContext);
  }
  
  public void setIsOldMode(boolean paramBoolean)
  {
    SSOHttpUtils.b = paramBoolean;
  }
  
  public void showBanner(long paramLong, @Nullable String paramString)
  {
    try
    {
      Message localMessage = Message.obtain();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("runningState", paramLong);
      localJSONObject.put("cookieUrl", paramString);
      localMessage.obj = localJSONObject;
      BannerManager.a().a(RunningBannerProcessor.a, 2, localMessage);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QQHealthApiImpl", 1, (Throwable)paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.QQHealthApiImpl
 * JD-Core Version:    0.7.0.1
 */