package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.sdk.statics.TraceStatistics;
import com.tencent.mobileqq.triton.sdk.statics.TraceStatistics.Record;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MiniGameBeaconReport$reportJankTraceRecords$1
  implements Runnable
{
  MiniGameBeaconReport$reportJankTraceRecords$1(TraceStatistics paramTraceStatistics, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public final void run()
  {
    Object localObject = this.$statistics.records;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "statistics.records");
    localObject = ((Iterable)CollectionsKt.take((Iterable)CollectionsKt.sortedWith((Iterable)localObject, (Comparator)new MiniGameBeaconReport.reportJankTraceRecords.1..special..inlined.sortedByDescending.1()), 20)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TraceStatistics.Record localRecord = (TraceStatistics.Record)((Iterator)localObject).next();
      MiniGameBeaconReport.report("jank_trace", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("trace_name", localRecord.name), TuplesKt.to("trace_time", String.valueOf(localRecord.timeUs)), TuplesKt.to("is_sdk", String.valueOf(this.$isSdk)), TuplesKt.to("appid", this.$appid), TuplesKt.to("isFirstFrame", String.valueOf(this.$isFirstFrame)) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport.reportJankTraceRecords.1
 * JD-Core Version:    0.7.0.1
 */