package shark;

import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakingObjectFinder;", "", "findLeakingObjectIds", "", "", "graph", "Lshark/HeapGraph;", "Companion", "shark"}, k=1, mv={1, 4, 1})
public abstract interface LeakingObjectFinder
{
  @NotNull
  public static final LeakingObjectFinder.Companion b = LeakingObjectFinder.Companion.a;
  
  @NotNull
  public abstract Set<Long> a(@NotNull HeapGraph paramHeapGraph);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakingObjectFinder
 * JD-Core Version:    0.7.0.1
 */