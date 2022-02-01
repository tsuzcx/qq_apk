package com.tencent.mobileqq.kandian.glue.video.player;

import android.os.SystemClock;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;

public class ReadinjoyPlayerReporter$BufferingEndAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$BufferingEndAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    paramObject = this.a.a;
    paramObject.f += SystemClock.uptimeMillis() - this.a.a.e;
    paramObject = this.a.a;
    paramObject.d += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.BufferingEndAction
 * JD-Core Version:    0.7.0.1
 */