package com.tencent.qqlive.module.videoreport.staging;

import com.tencent.qqlive.module.videoreport.Log;

class CustomEventStagingManager$1
  implements Runnable
{
  CustomEventStagingManager$1(CustomEventStagingManager paramCustomEventStagingManager) {}
  
  public void run()
  {
    if (CustomEventStagingManager.access$100(this.this$0)) {
      Log.i("StagingManager", "supplementReportsEvent");
    }
    CustomEventStagingManager.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.staging.CustomEventStagingManager.1
 * JD-Core Version:    0.7.0.1
 */