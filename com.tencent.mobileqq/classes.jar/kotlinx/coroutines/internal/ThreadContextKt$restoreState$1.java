package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 1, 16})
final class ThreadContextKt$restoreState$1
  extends Lambda
  implements Function2<ThreadState, CoroutineContext.Element, ThreadState>
{
  public static final 1 INSTANCE = new 1();
  
  ThreadContextKt$restoreState$1()
  {
    super(2);
  }
  
  @NotNull
  public final ThreadState invoke(@NotNull ThreadState paramThreadState, @NotNull CoroutineContext.Element paramElement)
  {
    if ((paramElement instanceof ThreadContextElement)) {
      ((ThreadContextElement)paramElement).restoreThreadContext(paramThreadState.getContext(), paramThreadState.take());
    }
    return paramThreadState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ThreadContextKt.restoreState.1
 * JD-Core Version:    0.7.0.1
 */