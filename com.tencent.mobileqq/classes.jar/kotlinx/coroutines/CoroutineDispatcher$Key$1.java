package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/CoroutineDispatcher;", "it", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 1, 16})
final class CoroutineDispatcher$Key$1
  extends Lambda
  implements Function1<CoroutineContext.Element, CoroutineDispatcher>
{
  public static final 1 INSTANCE = new 1();
  
  CoroutineDispatcher$Key$1()
  {
    super(1);
  }
  
  @Nullable
  public final CoroutineDispatcher invoke(@NotNull CoroutineContext.Element paramElement)
  {
    CoroutineContext.Element localElement = paramElement;
    if (!(paramElement instanceof CoroutineDispatcher)) {
      localElement = null;
    }
    return (CoroutineDispatcher)localElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineDispatcher.Key.1
 * JD-Core Version:    0.7.0.1
 */