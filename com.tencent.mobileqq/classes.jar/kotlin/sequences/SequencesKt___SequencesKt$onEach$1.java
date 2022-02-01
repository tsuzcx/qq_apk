package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$onEach$1
  extends Lambda
  implements Function1<T, T>
{
  SequencesKt___SequencesKt$onEach$1(Function1 paramFunction1)
  {
    super(1);
  }
  
  public final T invoke(T paramT)
  {
    this.$action.invoke(paramT);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.onEach.1
 * JD-Core Version:    0.7.0.1
 */