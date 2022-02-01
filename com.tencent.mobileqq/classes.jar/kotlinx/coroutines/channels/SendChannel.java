package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/SendChannel;", "E", "", "isClosedForSend", "", "isClosedForSend$annotations", "()V", "()Z", "isFull", "isFull$annotations", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "cause", "", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface SendChannel<E>
{
  public abstract boolean close(@Nullable Throwable paramThrowable);
  
  @NotNull
  public abstract SelectClause2<E, SendChannel<E>> getOnSend();
  
  @ExperimentalCoroutinesApi
  public abstract void invokeOnClose(@NotNull Function1<? super Throwable, Unit> paramFunction1);
  
  public abstract boolean isClosedForSend();
  
  public abstract boolean isFull();
  
  public abstract boolean offer(E paramE);
  
  @Nullable
  public abstract Object send(E paramE, @NotNull Continuation<? super Unit> paramContinuation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.SendChannel
 * JD-Core Version:    0.7.0.1
 */