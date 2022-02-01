package com.tencent.mobileqq.kandian.base.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/report/api/IFeManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isForceReport", "", "updateForceReport", "", "app", "Lmqq/app/AppRuntime;", "force", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFeManager
  extends QRouteApi
{
  public static final IFeManager.Companion Companion = IFeManager.Companion.$$INSTANCE;
  @NotNull
  public static final String EVENT_G_INFO = "event_simple_g_info";
  @NotNull
  public static final String EVENT_P_INFO = "event_simple_p_info";
  
  public abstract boolean isForceReport();
  
  public abstract void updateForceReport(@Nullable AppRuntime paramAppRuntime, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.api.IFeManager
 * JD-Core Version:    0.7.0.1
 */