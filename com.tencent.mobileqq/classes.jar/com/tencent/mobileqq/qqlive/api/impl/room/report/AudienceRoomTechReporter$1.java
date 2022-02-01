package com.tencent.mobileqq.qqlive.api.impl.room.report;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class AudienceRoomTechReporter$1
  implements Runnable
{
  AudienceRoomTechReporter$1(AudienceRoomTechReporter paramAudienceRoomTechReporter) {}
  
  public void run()
  {
    if (AudienceRoomTechReporter.access$000(this.this$0).get())
    {
      AudienceRoomTechReporter.access$100(this.this$0, 0, "");
      ThreadManager.getSubThreadHandler().postDelayed(AudienceRoomTechReporter.access$200(this.this$0), 10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.report.AudienceRoomTechReporter.1
 * JD-Core Version:    0.7.0.1
 */