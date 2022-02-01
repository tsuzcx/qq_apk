package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import shark.internal.IndexedObject.IndexedInstance;
import shark.internal.hppc.LongObjectPair;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/HeapObject$HeapInstance;", "it", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/IndexedObject$IndexedInstance;", "invoke"}, k=3, mv={1, 4, 1})
final class HprofHeapGraph$instances$1
  extends Lambda
  implements Function1<LongObjectPair<? extends IndexedObject.IndexedInstance>, HeapObject.HeapInstance>
{
  HprofHeapGraph$instances$1(HprofHeapGraph paramHprofHeapGraph, Ref.IntRef paramIntRef)
  {
    super(1);
  }
  
  @NotNull
  public final HeapObject.HeapInstance invoke(@NotNull LongObjectPair<IndexedObject.IndexedInstance> paramLongObjectPair)
  {
    Intrinsics.checkParameterIsNotNull(paramLongObjectPair, "it");
    long l = paramLongObjectPair.a();
    paramLongObjectPair = (IndexedObject.IndexedInstance)paramLongObjectPair.b();
    HprofHeapGraph localHprofHeapGraph = this.this$0;
    Ref.IntRef localIntRef = this.$objectIndex;
    int i = localIntRef.element;
    localIntRef.element = (i + 1);
    return new HeapObject.HeapInstance(localHprofHeapGraph, paramLongObjectPair, l, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofHeapGraph.instances.1
 * JD-Core Version:    0.7.0.1
 */