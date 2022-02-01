package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/HeapObject$HeapClass;", "it", "invoke"}, k=3, mv={1, 4, 1})
final class HeapObject$HeapClass$classHierarchy$1
  extends Lambda
  implements Function1<HeapObject.HeapClass, HeapObject.HeapClass>
{
  public static final 1 INSTANCE = new 1();
  
  HeapObject$HeapClass$classHierarchy$1()
  {
    super(1);
  }
  
  @Nullable
  public final HeapObject.HeapClass invoke(@NotNull HeapObject.HeapClass paramHeapClass)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapClass, "it");
    return paramHeapClass.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapClass.classHierarchy.1
 * JD-Core Version:    0.7.0.1
 */