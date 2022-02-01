package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.statistic.TraceStatistics.Record;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 1, 16})
public final class MiniGameBeaconReport$reportJankTraceRecords$1$$special$$inlined$sortedByDescending$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    return ComparisonsKt.compareValues((Comparable)Long.valueOf(((TraceStatistics.Record)paramT2).getTimeUs()), (Comparable)Long.valueOf(((TraceStatistics.Record)paramT1).getTimeUs()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport.reportJankTraceRecords.1..special..inlined.sortedByDescending.1
 * JD-Core Version:    0.7.0.1
 */