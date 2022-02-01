package com.tencent.mobileqq.kandian.glue.report;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import java.util.Map;

class RIJFrameworkReportManager$2
  implements Runnable
{
  RIJFrameworkReportManager$2(RIJFrameworkReportManager paramRIJFrameworkReportManager, boolean paramBoolean1, Map paramMap1, boolean paramBoolean2, Map paramMap2, String paramString, Context paramContext, int paramInt1, int paramInt2, ReadInJoyBaseViewController paramReadInJoyBaseViewController, boolean paramBoolean3, long paramLong) {}
  
  public void run()
  {
    if (!this.a)
    {
      this.this$0.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
      return;
    }
    if (RIJChannelStayTimeMonitor.INSTANCE.isChannelShow(this.g)) {
      this.this$0.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager.2
 * JD-Core Version:    0.7.0.1
 */