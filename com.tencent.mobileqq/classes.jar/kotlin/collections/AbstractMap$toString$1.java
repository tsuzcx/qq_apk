package kotlin.collections;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "K", "V", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class AbstractMap$toString$1
  extends Lambda
  implements Function1<Map.Entry<? extends K, ? extends V>, String>
{
  AbstractMap$toString$1(AbstractMap paramAbstractMap)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "it");
    return AbstractMap.access$toString(this.this$0, paramEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.AbstractMap.toString.1
 * JD-Core Version:    0.7.0.1
 */