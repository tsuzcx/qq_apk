package com.tencent.mobileqq.kandian.base.video.player.videourl;

import android.content.Context;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoGetUrlReporter$reportVideoH265GetURL$1
  implements Runnable
{
  VideoGetUrlReporter$reportVideoH265GetURL$1(Context paramContext, String paramString, HashMap paramHashMap) {}
  
  public final void run()
  {
    StatisticCollector.getInstance(this.a).collectPerformance(this.b, "actKandianVideoH265GetURL", true, -1L, 0L, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.VideoGetUrlReporter.reportVideoH265GetURL.1
 * JD-Core Version:    0.7.0.1
 */