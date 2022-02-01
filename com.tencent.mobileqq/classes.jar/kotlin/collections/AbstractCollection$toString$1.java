package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"}, k=3, mv={1, 1, 16})
final class AbstractCollection$toString$1
  extends Lambda
  implements Function1<E, CharSequence>
{
  AbstractCollection$toString$1(AbstractCollection paramAbstractCollection)
  {
    super(1);
  }
  
  @NotNull
  public final CharSequence invoke(E paramE)
  {
    if (paramE == this.this$0) {
      paramE = "(this Collection)";
    } else {
      paramE = String.valueOf(paramE);
    }
    return (CharSequence)paramE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.AbstractCollection.toString.1
 * JD-Core Version:    0.7.0.1
 */