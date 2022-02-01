package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/ObjectInspectors$Companion$createLeakingObjectFilters$2$1", "Lshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "isLeakingObject", "", "heapObject", "Lshark/HeapObject;", "shark"}, k=1, mv={1, 4, 1})
public final class ObjectInspectors$Companion$createLeakingObjectFilters$2$1
  implements FilteringLeakingObjectFinder.LeakingObjectFilter
{
  ObjectInspectors$Companion$createLeakingObjectFilters$2$1(Function1 paramFunction1) {}
  
  public boolean a(@NotNull HeapObject paramHeapObject)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapObject, "heapObject");
    return ((Boolean)this.a.invoke(paramHeapObject)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspectors.Companion.createLeakingObjectFilters.2.1
 * JD-Core Version:    0.7.0.1
 */