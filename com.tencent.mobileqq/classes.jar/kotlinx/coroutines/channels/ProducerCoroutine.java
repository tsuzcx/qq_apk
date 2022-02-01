package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ProducerCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;)V", "isActive", "", "()Z", "onCancelled", "", "cause", "", "handled", "onCompleted", "value", "(Lkotlin/Unit;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class ProducerCoroutine<E>
  extends ChannelCoroutine<E>
  implements ProducerScope<E>
{
  public ProducerCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull Channel<E> paramChannel)
  {
    super(paramCoroutineContext, paramChannel, true);
  }
  
  public boolean isActive()
  {
    return super.isActive();
  }
  
  protected void onCancelled(@NotNull Throwable paramThrowable, boolean paramBoolean)
  {
    if ((!get_channel().close(paramThrowable)) && (!paramBoolean)) {
      CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), paramThrowable);
    }
  }
  
  protected void onCompleted(@NotNull Unit paramUnit)
  {
    SendChannel.DefaultImpls.close$default(get_channel(), null, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ProducerCoroutine
 * JD-Core Version:    0.7.0.1
 */