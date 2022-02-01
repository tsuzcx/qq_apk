package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="TKDDataReportModule")
public class TKDDataReportModule
  extends HippyNativeModuleBase
{
  private static final String TEST_LOG_REPORT_TAG = "TEST_LOG_REPORT_TAG";
  
  public TKDDataReportModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="dataReport")
  public void dataReport(HippyMap paramHippyMap)
  {
    paramHippyMap = (HippyMap)paramHippyMap.get("qq");
    PublicAccountReportUtils.a(null, "", paramHippyMap.getString("subAction"), paramHippyMap.getString("actionName"), 0, 0, paramHippyMap.getString("r2"), paramHippyMap.getString("r3"), paramHippyMap.getString("r4"), paramHippyMap.getString("r5"), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDDataReportModule
 * JD-Core Version:    0.7.0.1
 */