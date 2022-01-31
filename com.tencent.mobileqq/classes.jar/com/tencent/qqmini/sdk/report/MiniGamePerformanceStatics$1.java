package com.tencent.qqmini.sdk.report;

import android.os.Handler;
import bgxp;
import bhhj;
import bhhk;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

public class MiniGamePerformanceStatics$1
  implements Runnable
{
  public MiniGamePerformanceStatics$1(bgxp parambgxp) {}
  
  public void run()
  {
    float f = bgxp.a(this.this$0);
    bgxp.a(this.this$0).a(f);
    bgxp.a(this.this$0).a(f);
    ThreadManager.a().postDelayed(this, 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics.1
 * JD-Core Version:    0.7.0.1
 */