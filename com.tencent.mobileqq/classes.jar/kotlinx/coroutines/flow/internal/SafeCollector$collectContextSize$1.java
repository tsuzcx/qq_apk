package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "count", "<anonymous parameter 1>", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 1, 16})
final class SafeCollector$collectContextSize$1
  extends Lambda
  implements Function2<Integer, CoroutineContext.Element, Integer>
{
  public static final 1 INSTANCE = new 1();
  
  SafeCollector$collectContextSize$1()
  {
    super(2);
  }
  
  public final int invoke(int paramInt, @NotNull CoroutineContext.Element paramElement)
  {
    return paramInt + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.SafeCollector.collectContextSize.1
 * JD-Core Version:    0.7.0.1
 */