package com.tencent.qqmini.sdk.report;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.statistics.AverageStatistics;
import com.tencent.qqmini.sdk.statistics.MaxStatistics;

class MiniGamePerformanceStatics$1
  implements Runnable
{
  MiniGamePerformanceStatics$1(MiniGamePerformanceStatics paramMiniGamePerformanceStatics) {}
  
  public void run()
  {
    float f = MiniGamePerformanceStatics.access$000(this.this$0);
    MiniGamePerformanceStatics.access$100(this.this$0).addSample(f);
    MiniGamePerformanceStatics.access$200(this.this$0).addSample(f);
    ThreadManager.getSubThreadHandler().postDelayed(this, 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics.1
 * JD-Core Version:    0.7.0.1
 */