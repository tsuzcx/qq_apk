package com.tencent.mobileqq.kandian.biz.common.widget;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;

class ReadInJoyListViewGroup$1$1
  implements Runnable
{
  ReadInJoyListViewGroup$1$1(ReadInJoyListViewGroup.1 param1) {}
  
  public void run()
  {
    if (((this.a.this$0.a() == 0) || (DailyModeConfigHandler.c(this.a.this$0.a()))) && (!this.a.a)) {
      ReadinjoySPEventReport.a().a.a(8, this.a.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup.1.1
 * JD-Core Version:    0.7.0.1
 */