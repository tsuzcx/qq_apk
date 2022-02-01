package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExceptionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "handleJobException", "exception", "", "onCancelling", "", "cause", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
class ActorCoroutine<E>
  extends ChannelCoroutine<E>
  implements ActorScope<E>
{
  public ActorCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull Channel<E> paramChannel, boolean paramBoolean)
  {
    super(paramCoroutineContext, paramChannel, paramBoolean);
  }
  
  protected boolean handleJobException(@NotNull Throwable paramThrowable)
  {
    CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), paramThrowable);
    return true;
  }
  
  protected void onCancelling(@Nullable Throwable paramThrowable)
  {
    Channel localChannel = get_channel();
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramThrowable != null)
    {
      if (!(paramThrowable instanceof CancellationException)) {
        localObject1 = localObject2;
      } else {
        localObject1 = paramThrowable;
      }
      localObject1 = (CancellationException)localObject1;
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(DebugStringsKt.getClassSimpleName(this));
        ((StringBuilder)localObject1).append(" was cancelled");
        localObject1 = ExceptionsKt.CancellationException(((StringBuilder)localObject1).toString(), paramThrowable);
      }
    }
    localChannel.cancel((CancellationException)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ActorCoroutine
 * JD-Core Version:    0.7.0.1
 */