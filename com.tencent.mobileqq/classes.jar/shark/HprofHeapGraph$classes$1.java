package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import shark.internal.IndexedObject.IndexedClass;
import shark.internal.hppc.LongObjectPair;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/HeapObject$HeapClass;", "it", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/IndexedObject$IndexedClass;", "invoke"}, k=3, mv={1, 4, 1})
final class HprofHeapGraph$classes$1
  extends Lambda
  implements Function1<LongObjectPair<? extends IndexedObject.IndexedClass>, HeapObject.HeapClass>
{
  HprofHeapGraph$classes$1(HprofHeapGraph paramHprofHeapGraph, Ref.IntRef paramIntRef)
  {
    super(1);
  }
  
  @NotNull
  public final HeapObject.HeapClass invoke(@NotNull LongObjectPair<IndexedObject.IndexedClass> paramLongObjectPair)
  {
    Intrinsics.checkParameterIsNotNull(paramLongObjectPair, "it");
    long l = paramLongObjectPair.a();
    paramLongObjectPair = (IndexedObject.IndexedClass)paramLongObjectPair.b();
    HprofHeapGraph localHprofHeapGraph = this.this$0;
    Ref.IntRef localIntRef = this.$objectIndex;
    int i = localIntRef.element;
    localIntRef.element = (i + 1);
    return new HeapObject.HeapClass(localHprofHeapGraph, paramLongObjectPair, l, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofHeapGraph.classes.1
 * JD-Core Version:    0.7.0.1
 */