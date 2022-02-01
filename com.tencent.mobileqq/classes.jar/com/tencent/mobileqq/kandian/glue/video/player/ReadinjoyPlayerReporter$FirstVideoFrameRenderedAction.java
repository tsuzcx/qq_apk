package com.tencent.mobileqq.kandian.glue.video.player;

import android.os.SystemClock;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;

public class ReadinjoyPlayerReporter$FirstVideoFrameRenderedAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$FirstVideoFrameRenderedAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.a.a.m > 0L) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      this.a.a.au = (SystemClock.uptimeMillis() - this.a.a.m);
    } else {
      this.a.a.au = 0L;
    }
    this.a.a.av = (SystemClock.uptimeMillis() - this.a.a.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.FirstVideoFrameRenderedAction
 * JD-Core Version:    0.7.0.1
 */