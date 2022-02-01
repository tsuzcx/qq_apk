package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/coroutines/experimental/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 1, 16})
final class CoroutineContext$plus$1
  extends Lambda
  implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>
{
  public static final 1 INSTANCE = new 1();
  
  CoroutineContext$plus$1()
  {
    super(2);
  }
  
  @NotNull
  public final CoroutineContext invoke(@NotNull CoroutineContext paramCoroutineContext, @NotNull CoroutineContext.Element paramElement)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "acc");
    Intrinsics.checkParameterIsNotNull(paramElement, "element");
    CoroutineContext localCoroutineContext = paramCoroutineContext.minusKey(paramElement.getKey());
    if (localCoroutineContext == EmptyCoroutineContext.INSTANCE) {
      return (CoroutineContext)paramElement;
    }
    paramCoroutineContext = (ContinuationInterceptor)localCoroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key);
    if (paramCoroutineContext == null) {
      paramCoroutineContext = new CombinedContext(localCoroutineContext, paramElement);
    }
    for (;;)
    {
      return (CoroutineContext)paramCoroutineContext;
      localCoroutineContext = localCoroutineContext.minusKey((CoroutineContext.Key)ContinuationInterceptor.Key);
      if (localCoroutineContext == EmptyCoroutineContext.INSTANCE) {
        paramCoroutineContext = new CombinedContext((CoroutineContext)paramElement, (CoroutineContext.Element)paramCoroutineContext);
      } else {
        paramCoroutineContext = new CombinedContext((CoroutineContext)new CombinedContext(localCoroutineContext, paramElement), (CoroutineContext.Element)paramCoroutineContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.CoroutineContext.plus.1
 * JD-Core Version:    0.7.0.1
 */