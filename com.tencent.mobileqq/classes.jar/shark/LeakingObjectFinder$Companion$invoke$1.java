package shark;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/LeakingObjectFinder$Companion$invoke$1", "Lshark/LeakingObjectFinder;", "findLeakingObjectIds", "", "", "graph", "Lshark/HeapGraph;", "shark"}, k=1, mv={1, 4, 1})
public final class LeakingObjectFinder$Companion$invoke$1
  implements LeakingObjectFinder
{
  @NotNull
  public Set<Long> a(@NotNull HeapGraph paramHeapGraph)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "graph");
    return (Set)this.a.invoke(paramHeapGraph);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakingObjectFinder.Companion.invoke.1
 * JD-Core Version:    0.7.0.1
 */