package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import shark.internal.hppc.LongObjectPair;
import shark.internal.hppc.TuplesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/IndexedObject$IndexedClass;", "it", "Lshark/internal/ByteSubArray;", "invoke"}, k=3, mv={1, 4, 1})
final class HprofInMemoryIndex$indexedClassSequence$1
  extends Lambda
  implements Function1<LongObjectPair<? extends ByteSubArray>, LongObjectPair<? extends IndexedObject.IndexedClass>>
{
  HprofInMemoryIndex$indexedClassSequence$1(HprofInMemoryIndex paramHprofInMemoryIndex)
  {
    super(1);
  }
  
  @NotNull
  public final LongObjectPair<IndexedObject.IndexedClass> invoke(@NotNull LongObjectPair<ByteSubArray> paramLongObjectPair)
  {
    Intrinsics.checkParameterIsNotNull(paramLongObjectPair, "it");
    long l = paramLongObjectPair.a();
    paramLongObjectPair = (ByteSubArray)paramLongObjectPair.b();
    return TuplesKt.a(l, HprofInMemoryIndex.a(this.this$0, paramLongObjectPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.HprofInMemoryIndex.indexedClassSequence.1
 * JD-Core Version:    0.7.0.1
 */