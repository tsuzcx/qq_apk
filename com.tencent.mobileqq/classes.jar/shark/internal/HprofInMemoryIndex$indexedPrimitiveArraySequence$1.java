package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import shark.internal.hppc.LongObjectPair;
import shark.internal.hppc.TuplesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "it", "Lshark/internal/ByteSubArray;", "invoke"}, k=3, mv={1, 4, 1})
final class HprofInMemoryIndex$indexedPrimitiveArraySequence$1
  extends Lambda
  implements Function1<LongObjectPair<? extends ByteSubArray>, LongObjectPair<? extends IndexedObject.IndexedPrimitiveArray>>
{
  HprofInMemoryIndex$indexedPrimitiveArraySequence$1(HprofInMemoryIndex paramHprofInMemoryIndex)
  {
    super(1);
  }
  
  @NotNull
  public final LongObjectPair<IndexedObject.IndexedPrimitiveArray> invoke(@NotNull LongObjectPair<ByteSubArray> paramLongObjectPair)
  {
    Intrinsics.checkParameterIsNotNull(paramLongObjectPair, "it");
    long l = paramLongObjectPair.a();
    paramLongObjectPair = (ByteSubArray)paramLongObjectPair.b();
    return TuplesKt.a(l, new IndexedObject.IndexedPrimitiveArray(paramLongObjectPair.a(HprofInMemoryIndex.a(this.this$0)), shark.PrimitiveType.values()[paramLongObjectPair.a()], paramLongObjectPair.a(HprofInMemoryIndex.d(this.this$0))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.HprofInMemoryIndex.indexedPrimitiveArraySequence.1
 * JD-Core Version:    0.7.0.1
 */