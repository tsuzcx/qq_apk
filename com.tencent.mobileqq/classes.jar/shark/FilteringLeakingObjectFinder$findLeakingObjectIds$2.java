package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lshark/HeapObject;", "invoke"}, k=3, mv={1, 4, 1})
final class FilteringLeakingObjectFinder$findLeakingObjectIds$2
  extends Lambda
  implements Function1<HeapObject, Long>
{
  public static final 2 INSTANCE = new 2();
  
  FilteringLeakingObjectFinder$findLeakingObjectIds$2()
  {
    super(1);
  }
  
  public final long invoke(@NotNull HeapObject paramHeapObject)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapObject, "it");
    return paramHeapObject.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.FilteringLeakingObjectFinder.findLeakingObjectIds.2
 * JD-Core Version:    0.7.0.1
 */