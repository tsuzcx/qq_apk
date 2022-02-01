package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;

class FileJsPlugin$18
  implements Runnable
{
  FileJsPlugin$18(FileJsPlugin paramFileJsPlugin, String paramString, boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    MiniGamePerformanceStatics.getInstance().recordFileApiTimeCost(this.val$event, this.val$isSuccess, this.val$waitingTime, this.val$workingTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.18
 * JD-Core Version:    0.7.0.1
 */