package shark;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/sequences/Sequence;", "Lshark/HeapField;", "heapClass", "Lshark/HeapObject$HeapClass;", "invoke"}, k=3, mv={1, 4, 1})
final class HeapObject$HeapInstance$readFields$1
  extends Lambda
  implements Function1<HeapObject.HeapClass, Sequence<? extends HeapField>>
{
  HeapObject$HeapInstance$readFields$1(HeapObject.HeapInstance paramHeapInstance, Lazy paramLazy, KProperty paramKProperty)
  {
    super(1);
  }
  
  @NotNull
  public final Sequence<HeapField> invoke(@NotNull HeapObject.HeapClass paramHeapClass)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapClass, "heapClass");
    return SequencesKt.map(CollectionsKt.asSequence((Iterable)paramHeapClass.s()), (Function1)new HeapObject.HeapInstance.readFields.1.1(this, paramHeapClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapInstance.readFields.1
 * JD-Core Version:    0.7.0.1
 */