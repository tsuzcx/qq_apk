package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Z"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$minus$1$iterator$1
  extends Lambda
  implements Function1<T, Boolean>
{
  SequencesKt___SequencesKt$minus$1$iterator$1(SequencesKt___SequencesKt.minus.1 param1, Ref.BooleanRef paramBooleanRef)
  {
    super(1);
  }
  
  public final boolean invoke(T paramT)
  {
    boolean bool3 = this.$removed.element;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (Intrinsics.areEqual(paramT, this.this$0.$element))
      {
        this.$removed.element = true;
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.minus.1.iterator.1
 * JD-Core Version:    0.7.0.1
 */