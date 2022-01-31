package com.tencent.mobileqq.vashealth;

import bdtq;
import becq;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class HealthBusinessPlugin$7
  implements Runnable
{
  HealthBusinessPlugin$7(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void run()
  {
    TVK_SDKMgr.installPlugin(this.this$0.mRuntime.a().getApplication(), new bdtq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.7
 * JD-Core Version:    0.7.0.1
 */