package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lshark/HeapObject$HeapInstance;", "invoke"}, k=3, mv={1, 4, 1})
final class HeapObject$HeapClass$instances$1
  extends Lambda
  implements Function1<HeapObject.HeapInstance, Boolean>
{
  HeapObject$HeapClass$instances$1(HeapObject.HeapClass paramHeapClass)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull HeapObject.HeapInstance paramHeapInstance)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapInstance, "it");
    return paramHeapInstance.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapClass.instances.1
 * JD-Core Version:    0.7.0.1
 */