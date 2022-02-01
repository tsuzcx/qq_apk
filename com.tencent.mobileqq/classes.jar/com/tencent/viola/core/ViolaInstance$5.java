package com.tencent.viola.core;

import com.tencent.viola.commons.IReportDelegate;
import java.util.HashMap;

class ViolaInstance$5
  implements Runnable
{
  ViolaInstance$5(ViolaInstance paramViolaInstance) {}
  
  public void run()
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(ViolaEnvironment.JS_ERROR_AFTER_RENDER, Integer.toString(this.this$0.mJsErrorCountRunning));
    HashMap localHashMap2 = ViolaInstance.access$500(this.this$0);
    localHashMap1.putAll(localHashMap2);
    IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
    if (localIReportDelegate != null) {
      localIReportDelegate.reportRunningData(localHashMap1, ViolaInstance.access$600(this.this$0));
    }
    ViolaReportManager.getInstance().postDataToBeacon("actKanDianViolaJsError", localHashMap1);
    if ((!ViolaInstance.access$700(this.this$0)) && (!ViolaInstance.access$800(this.this$0).isEmpty()))
    {
      ViolaInstance.access$702(this.this$0, true);
      ViolaInstance.access$800(this.this$0).putAll(localHashMap2);
      ViolaReportManager.getInstance().postDataToBeacon("actKanDianViolaData", ViolaInstance.access$800(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.ViolaInstance.5
 * JD-Core Version:    0.7.0.1
 */