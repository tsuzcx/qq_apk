package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<no name provided>", "Lkotlinx/coroutines/ThreadContextElement;", "found", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 1, 16})
final class ThreadContextKt$findOne$1
  extends Lambda
  implements Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>>
{
  public static final 1 INSTANCE = new 1();
  
  ThreadContextKt$findOne$1()
  {
    super(2);
  }
  
  @Nullable
  public final ThreadContextElement<?> invoke(@Nullable ThreadContextElement<?> paramThreadContextElement, @NotNull CoroutineContext.Element paramElement)
  {
    if (paramThreadContextElement != null) {
      return paramThreadContextElement;
    }
    paramThreadContextElement = paramElement;
    if (!(paramElement instanceof ThreadContextElement)) {
      paramThreadContextElement = null;
    }
    return (ThreadContextElement)paramThreadContextElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ThreadContextKt.findOne.1
 * JD-Core Version:    0.7.0.1
 */