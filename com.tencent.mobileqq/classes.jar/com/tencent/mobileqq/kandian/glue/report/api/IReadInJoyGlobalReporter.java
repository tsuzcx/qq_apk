package com.tencent.mobileqq.kandian.glue.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/IReadInJoyGlobalReporter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "needReport", "", "report", "", "rsetEnterTime", "app", "Lmqq/app/AppRuntime;", "time", "", "setAPPStatus", "status", "", "stopReport", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyGlobalReporter
  extends QRouteApi
{
  public static final int APP_BACKGROUND = 1;
  public static final int APP_FORGROUND = 2;
  public static final IReadInJoyGlobalReporter.Companion Companion = IReadInJoyGlobalReporter.Companion.a;
  
  public abstract boolean needReport();
  
  public abstract void report();
  
  public abstract void rsetEnterTime(@Nullable AppRuntime paramAppRuntime, long paramLong);
  
  public abstract void setAPPStatus(int paramInt);
  
  public abstract void stopReport();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyGlobalReporter
 * JD-Core Version:    0.7.0.1
 */