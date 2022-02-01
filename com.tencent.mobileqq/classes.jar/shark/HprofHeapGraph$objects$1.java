package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import shark.internal.IndexedObject;
import shark.internal.hppc.LongObjectPair;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/HeapObject;", "it", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/IndexedObject;", "invoke"}, k=3, mv={1, 4, 1})
final class HprofHeapGraph$objects$1
  extends Lambda
  implements Function1<LongObjectPair<? extends IndexedObject>, HeapObject>
{
  HprofHeapGraph$objects$1(HprofHeapGraph paramHprofHeapGraph, Ref.IntRef paramIntRef)
  {
    super(1);
  }
  
  @NotNull
  public final HeapObject invoke(@NotNull LongObjectPair<? extends IndexedObject> paramLongObjectPair)
  {
    Intrinsics.checkParameterIsNotNull(paramLongObjectPair, "it");
    HprofHeapGraph localHprofHeapGraph = this.this$0;
    Ref.IntRef localIntRef = this.$objectIndex;
    int i = localIntRef.element;
    localIntRef.element = (i + 1);
    return HprofHeapGraph.a(localHprofHeapGraph, i, (IndexedObject)paramLongObjectPair.b(), paramLongObjectPair.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofHeapGraph.objects.1
 * JD-Core Version:    0.7.0.1
 */