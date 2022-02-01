package shark.internal.hppc;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/internal/hppc/LongLongPair;", "invoke"}, k=3, mv={1, 4, 1})
final class LongLongScatterMap$entrySequence$1
  extends Lambda
  implements Function0<LongLongPair>
{
  LongLongScatterMap$entrySequence$1(LongLongScatterMap paramLongLongScatterMap, Ref.IntRef paramIntRef, int paramInt)
  {
    super(0);
  }
  
  @Nullable
  public final LongLongPair invoke()
  {
    Ref.IntRef localIntRef;
    if (this.$slot.element < this.$max)
    {
      localIntRef = this.$slot;
      for (localIntRef.element += 1; this.$slot.element < this.$max; localIntRef.element += 1)
      {
        long l = LongLongScatterMap.a(this.this$0)[this.$slot.element];
        if (l != 0L) {
          return TuplesKt.a(l, LongLongScatterMap.b(this.this$0)[this.$slot.element]);
        }
        localIntRef = this.$slot;
      }
    }
    if ((this.$slot.element == this.$max) && (LongLongScatterMap.c(this.this$0)))
    {
      localIntRef = this.$slot;
      localIntRef.element += 1;
      return TuplesKt.a(0L, LongLongScatterMap.b(this.this$0)[this.$max]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.hppc.LongLongScatterMap.entrySequence.1
 * JD-Core Version:    0.7.0.1
 */