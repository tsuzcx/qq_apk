package com.tencent.mobileqq.kandian.base.report.api;

import com.tencent.mobileqq.kandian.base.report.AppConfigInfoList;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Node;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/report/api/IReadInJoyDoingSomething;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clear", "", "getConfig", "Lcom/tencent/mobileqq/kandian/base/report/AppConfigInfoList;", "app", "Lmqq/app/AppRuntime;", "parseConfigToSP", "node", "Lorg/w3c/dom/Node;", "reportManyAppsData", "updateConfig", "appConfigInfoList", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyDoingSomething
  extends QRouteApi
{
  public static final IReadInJoyDoingSomething.Companion Companion = IReadInJoyDoingSomething.Companion.$$INSTANCE;
  @NotNull
  public static final String REPORT_TAG_NAME = "actKandianReportManyApps";
  @NotNull
  public static final String TAG = "ReadInJoyDoingSomething";
  
  public abstract void clear();
  
  @Nullable
  public abstract AppConfigInfoList getConfig(@Nullable AppRuntime paramAppRuntime);
  
  public abstract void parseConfigToSP(@Nullable Node paramNode);
  
  public abstract void reportManyAppsData();
  
  public abstract void updateConfig(@Nullable AppRuntime paramAppRuntime, @Nullable AppConfigInfoList paramAppConfigInfoList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.api.IReadInJoyDoingSomething
 * JD-Core Version:    0.7.0.1
 */