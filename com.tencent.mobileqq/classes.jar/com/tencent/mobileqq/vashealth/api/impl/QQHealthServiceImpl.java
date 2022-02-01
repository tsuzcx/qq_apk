package com.tencent.mobileqq.vashealth.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.vashealth.VSHealthReportUtil;
import com.tencent.mobileqq.vashealth.VSHealthUtil;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthServiceImpl;", "Lcom/tencent/mobileqq/vashealth/api/IQQHealthService;", "()V", "appRuntime", "Lmqq/app/AppRuntime;", "onCreate", "", "onDestroy", "redirectAIOToMainPage", "", "context", "Landroid/content/Context;", "publicAccountName", "", "src", "", "reportToBeaconIfNeed", "eventName", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class QQHealthServiceImpl
  implements IQQHealthService
{
  private AppRuntime appRuntime;
  
  public void onCreate(@Nullable AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public boolean redirectAIOToMainPage(@Nullable Context paramContext, @Nullable String paramString, int paramInt)
  {
    AppRuntime localAppRuntime2 = this.appRuntime;
    AppRuntime localAppRuntime1 = localAppRuntime2;
    if (!(localAppRuntime2 instanceof BaseQQAppInterface)) {
      localAppRuntime1 = null;
    }
    return VSHealthUtil.a(paramContext, (BaseQQAppInterface)localAppRuntime1, paramString, paramInt);
  }
  
  public void reportToBeaconIfNeed(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap)
  {
    AppRuntime localAppRuntime = this.appRuntime;
    if (localAppRuntime != null)
    {
      VSHealthReportUtil.a((AppInterface)localAppRuntime, paramString, paramHashMap);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.QQHealthServiceImpl
 * JD-Core Version:    0.7.0.1
 */