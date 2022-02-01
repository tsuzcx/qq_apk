package shark;

import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalyzer$InspectedObject;", "", "heapObject", "Lshark/HeapObject;", "leakingStatus", "Lshark/LeakTraceObject$LeakingStatus;", "leakingStatusReason", "", "labels", "", "(Lshark/HeapObject;Lshark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/util/Set;)V", "getHeapObject", "()Lshark/HeapObject;", "getLabels", "()Ljava/util/Set;", "getLeakingStatus", "()Lshark/LeakTraceObject$LeakingStatus;", "getLeakingStatusReason", "()Ljava/lang/String;", "shark"}, k=1, mv={1, 4, 1})
public final class HeapAnalyzer$InspectedObject
{
  @NotNull
  private final HeapObject a;
  @NotNull
  private final LeakTraceObject.LeakingStatus b;
  @NotNull
  private final String c;
  @NotNull
  private final Set<String> d;
  
  public HeapAnalyzer$InspectedObject(@NotNull HeapObject paramHeapObject, @NotNull LeakTraceObject.LeakingStatus paramLeakingStatus, @NotNull String paramString, @NotNull Set<String> paramSet)
  {
    this.a = paramHeapObject;
    this.b = paramLeakingStatus;
    this.c = paramString;
    this.d = paramSet;
  }
  
  @NotNull
  public final HeapObject a()
  {
    return this.a;
  }
  
  @NotNull
  public final LeakTraceObject.LeakingStatus b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final Set<String> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalyzer.InspectedObject
 * JD-Core Version:    0.7.0.1
 */