package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerCoroutine;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/FlowProduceCoroutine;", "T", "Lkotlinx/coroutines/channels/ProducerCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;)V", "childCancelled", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class FlowProduceCoroutine<T>
  extends ProducerCoroutine<T>
{
  public FlowProduceCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull Channel<T> paramChannel)
  {
    super(paramCoroutineContext, paramChannel);
  }
  
  public boolean childCancelled(@NotNull Throwable paramThrowable)
  {
    if ((paramThrowable instanceof ChildCancelledException)) {
      return true;
    }
    return cancelImpl$kotlinx_coroutines_core(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.FlowProduceCoroutine
 * JD-Core Version:    0.7.0.1
 */