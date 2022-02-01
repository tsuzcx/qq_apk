package com.tencent.mobileqq.kandian.base.report.api.impl;

import com.tencent.mobileqq.kandian.base.report.AppConfigInfoList;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyDoingSomething;
import com.tencent.mobileqq.kandian.base.report.api.IReadInJoyDoingSomething;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Node;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/report/api/impl/ReadInJoyDoingSomethingImpl;", "Lcom/tencent/mobileqq/kandian/base/report/api/IReadInJoyDoingSomething;", "()V", "clear", "", "getConfig", "Lcom/tencent/mobileqq/kandian/base/report/AppConfigInfoList;", "app", "Lmqq/app/AppRuntime;", "parseConfigToSP", "node", "Lorg/w3c/dom/Node;", "reportManyAppsData", "updateConfig", "appConfigInfoList", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyDoingSomethingImpl
  implements IReadInJoyDoingSomething
{
  public void clear() {}
  
  @Nullable
  public AppConfigInfoList getConfig(@Nullable AppRuntime paramAppRuntime)
  {
    return ReadInJoyDoingSomething.getConfig(paramAppRuntime);
  }
  
  public void parseConfigToSP(@Nullable Node paramNode)
  {
    ReadInJoyDoingSomething.parseConfigToSP(paramNode);
  }
  
  public void reportManyAppsData() {}
  
  public void updateConfig(@Nullable AppRuntime paramAppRuntime, @Nullable AppConfigInfoList paramAppConfigInfoList)
  {
    ReadInJoyDoingSomething.updateConfig(paramAppRuntime, paramAppConfigInfoList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.api.impl.ReadInJoyDoingSomethingImpl
 * JD-Core Version:    0.7.0.1
 */