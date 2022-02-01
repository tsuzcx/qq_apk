package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.statistic.TraceStatistics;
import com.tencent.mobileqq.triton.statistic.TraceStatistics.Record;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MiniGameBeaconReport$reportJankTraceRecords$1
  implements Runnable
{
  MiniGameBeaconReport$reportJankTraceRecords$1(TraceStatistics paramTraceStatistics, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public final void run()
  {
    try
    {
      Iterator localIterator = ((Iterable)CollectionsKt.take((Iterable)CollectionsKt.sortedWith((Iterable)this.$statistics.getRecords(), (Comparator)new MiniGameBeaconReport.reportJankTraceRecords.1..special..inlined.sortedByDescending.1()), 20)).iterator();
      while (localIterator.hasNext())
      {
        TraceStatistics.Record localRecord = (TraceStatistics.Record)localIterator.next();
        MiniGameBeaconReport.report("jank_trace", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("trace_name", localRecord.getName()), TuplesKt.to("trace_time", String.valueOf(localRecord.getTimeUs())), TuplesKt.to("is_sdk", String.valueOf(this.$isSdk)), TuplesKt.to("appid", this.$appid), TuplesKt.to("isFirstFrame", String.valueOf(this.$isFirstFrame)) }));
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("Beacon", "reportJankTraceRecords fail", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport.reportJankTraceRecords.1
 * JD-Core Version:    0.7.0.1
 */