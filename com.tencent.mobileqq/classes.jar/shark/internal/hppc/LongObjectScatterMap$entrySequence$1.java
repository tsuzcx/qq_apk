package shark.internal.hppc;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/internal/hppc/LongObjectPair;", "T", "invoke"}, k=3, mv={1, 4, 1})
final class LongObjectScatterMap$entrySequence$1
  extends Lambda
  implements Function0<LongObjectPair<? extends T>>
{
  LongObjectScatterMap$entrySequence$1(LongObjectScatterMap paramLongObjectScatterMap, Ref.IntRef paramIntRef, int paramInt)
  {
    super(0);
  }
  
  @Nullable
  public final LongObjectPair<T> invoke()
  {
    Object localObject;
    if (this.$slot.element < this.$max)
    {
      localObject = this.$slot;
      for (((Ref.IntRef)localObject).element += 1; this.$slot.element < this.$max; ((Ref.IntRef)localObject).element += 1)
      {
        long l = LongObjectScatterMap.a(this.this$0)[this.$slot.element];
        if (l != 0L)
        {
          localObject = LongObjectScatterMap.b(this.this$0)[this.$slot.element];
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          return TuplesKt.a(l, localObject);
        }
        localObject = this.$slot;
      }
    }
    if ((this.$slot.element == this.$max) && (LongObjectScatterMap.c(this.this$0)))
    {
      localObject = this.$slot;
      ((Ref.IntRef)localObject).element += 1;
      localObject = LongObjectScatterMap.b(this.this$0)[this.$max];
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return TuplesKt.a(0L, localObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.hppc.LongObjectScatterMap.entrySequence.1
 * JD-Core Version:    0.7.0.1
 */