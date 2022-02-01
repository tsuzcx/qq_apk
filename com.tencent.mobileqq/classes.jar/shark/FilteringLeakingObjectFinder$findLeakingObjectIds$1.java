package shark;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "heapObject", "Lshark/HeapObject;", "invoke"}, k=3, mv={1, 4, 1})
final class FilteringLeakingObjectFinder$findLeakingObjectIds$1
  extends Lambda
  implements Function1<HeapObject, Boolean>
{
  FilteringLeakingObjectFinder$findLeakingObjectIds$1(FilteringLeakingObjectFinder paramFilteringLeakingObjectFinder)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull HeapObject paramHeapObject)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapObject, "heapObject");
    Object localObject = (Iterable)FilteringLeakingObjectFinder.a(this.this$0);
    boolean bool1 = localObject instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!((FilteringLeakingObjectFinder.LeakingObjectFilter)((Iterator)localObject).next()).a(paramHeapObject));
    bool1 = true;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.FilteringLeakingObjectFinder.findLeakingObjectIds.1
 * JD-Core Version:    0.7.0.1
 */