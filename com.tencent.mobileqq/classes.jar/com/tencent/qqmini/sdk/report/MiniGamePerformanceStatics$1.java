package com.tencent.qqmini.sdk.report;

import android.os.Handler;
import bhbw;
import bhlq;
import bhlr;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

public class MiniGamePerformanceStatics$1
  implements Runnable
{
  public MiniGamePerformanceStatics$1(bhbw parambhbw) {}
  
  public void run()
  {
    float f = bhbw.a(this.this$0);
    bhbw.a(this.this$0).a(f);
    bhbw.a(this.this$0).a(f);
    ThreadManager.a().postDelayed(this, 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics.1
 * JD-Core Version:    0.7.0.1
 */