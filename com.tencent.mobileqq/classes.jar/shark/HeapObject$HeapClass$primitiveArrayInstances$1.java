package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lshark/HeapObject$HeapPrimitiveArray;", "invoke"}, k=3, mv={1, 4, 1})
final class HeapObject$HeapClass$primitiveArrayInstances$1
  extends Lambda
  implements Function1<HeapObject.HeapPrimitiveArray, Boolean>
{
  HeapObject$HeapClass$primitiveArrayInstances$1(PrimitiveType paramPrimitiveType)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull HeapObject.HeapPrimitiveArray paramHeapPrimitiveArray)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapPrimitiveArray, "it");
    return paramHeapPrimitiveArray.i() == this.$primitiveType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapClass.primitiveArrayInstances.1
 * JD-Core Version:    0.7.0.1
 */