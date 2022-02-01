package shark.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import shark.HeapObject;
import shark.HeapObject.HeapClass;
import shark.HeapObject.HeapInstance;
import shark.HeapObject.HeapObjectArray;
import shark.HeapObject.HeapPrimitiveArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "graphObject", "Lshark/HeapObject;", "invoke"}, k=3, mv={1, 4, 1})
final class PathFinder$sortedGcRoots$rootClassName$1
  extends Lambda
  implements Function1<HeapObject, String>
{
  public static final 1 INSTANCE = new 1();
  
  PathFinder$sortedGcRoots$rootClassName$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull HeapObject paramHeapObject)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapObject, "graphObject");
    if ((paramHeapObject instanceof HeapObject.HeapClass)) {
      return ((HeapObject.HeapClass)paramHeapObject).h();
    }
    if ((paramHeapObject instanceof HeapObject.HeapInstance)) {
      return ((HeapObject.HeapInstance)paramHeapObject).j();
    }
    if ((paramHeapObject instanceof HeapObject.HeapObjectArray)) {
      return ((HeapObject.HeapObjectArray)paramHeapObject).h();
    }
    if ((paramHeapObject instanceof HeapObject.HeapPrimitiveArray)) {
      return ((HeapObject.HeapPrimitiveArray)paramHeapObject).j();
    }
    throw new NoWhenBranchMatchedException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.PathFinder.sortedGcRoots.rootClassName.1
 * JD-Core Version:    0.7.0.1
 */