package shark;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/FilteringLeakingObjectFinder;", "Lshark/LeakingObjectFinder;", "filters", "", "Lshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "(Ljava/util/List;)V", "findLeakingObjectIds", "", "", "graph", "Lshark/HeapGraph;", "LeakingObjectFilter", "shark"}, k=1, mv={1, 4, 1})
public final class FilteringLeakingObjectFinder
  implements LeakingObjectFinder
{
  private final List<FilteringLeakingObjectFinder.LeakingObjectFilter> a;
  
  public FilteringLeakingObjectFinder(@NotNull List<? extends FilteringLeakingObjectFinder.LeakingObjectFilter> paramList)
  {
    this.a = paramList;
  }
  
  @NotNull
  public Set<Long> a(@NotNull HeapGraph paramHeapGraph)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "graph");
    return SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(paramHeapGraph.e(), (Function1)new FilteringLeakingObjectFinder.findLeakingObjectIds.1(this)), (Function1)FilteringLeakingObjectFinder.findLeakingObjectIds.2.INSTANCE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.FilteringLeakingObjectFinder
 * JD-Core Version:    0.7.0.1
 */