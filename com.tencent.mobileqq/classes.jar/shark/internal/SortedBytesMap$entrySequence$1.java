package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import shark.internal.hppc.LongObjectPair;
import shark.internal.hppc.TuplesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/ByteSubArray;", "keyIndex", "", "invoke"}, k=3, mv={1, 4, 1})
final class SortedBytesMap$entrySequence$1
  extends Lambda
  implements Function1<Integer, LongObjectPair<? extends ByteSubArray>>
{
  SortedBytesMap$entrySequence$1(SortedBytesMap paramSortedBytesMap)
  {
    super(1);
  }
  
  @NotNull
  public final LongObjectPair<ByteSubArray> invoke(int paramInt)
  {
    int i = SortedBytesMap.a(this.this$0);
    int j = SortedBytesMap.b(this.this$0);
    return TuplesKt.a(this.this$0.b(paramInt), new ByteSubArray(SortedBytesMap.c(this.this$0), i * paramInt + j, SortedBytesMap.d(this.this$0), SortedBytesMap.e(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.SortedBytesMap.entrySequence.1
 * JD-Core Version:    0.7.0.1
 */