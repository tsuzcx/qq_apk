package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "E", "R", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "pollResult", "", "channel", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/AbstractSendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "dispose", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class AbstractSendChannel$SendSelect<E, R>
  extends Send
  implements DisposableHandle
{
  @JvmField
  @NotNull
  public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> block;
  @JvmField
  @NotNull
  public final AbstractSendChannel<E> channel;
  @Nullable
  private final Object pollResult;
  @JvmField
  @NotNull
  public final SelectInstance<R> select;
  
  public AbstractSendChannel$SendSelect(@Nullable Object paramObject, @NotNull AbstractSendChannel<E> paramAbstractSendChannel, @NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    this.pollResult = paramObject;
    this.channel = paramAbstractSendChannel;
    this.select = paramSelectInstance;
    this.block = paramFunction2;
  }
  
  public void completeResumeSend()
  {
    ContinuationKt.startCoroutine(this.block, this.channel, this.select.getCompletion());
  }
  
  public void dispose()
  {
    remove();
  }
  
  @Nullable
  public Object getPollResult()
  {
    return this.pollResult;
  }
  
  public void resumeSendClosed(@NotNull Closed<?> paramClosed)
  {
    if (this.select.trySelect()) {
      this.select.resumeSelectWithException(paramClosed.getSendException());
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendSelect@");
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    localStringBuilder.append('(');
    localStringBuilder.append(getPollResult());
    localStringBuilder.append(")[");
    localStringBuilder.append(this.channel);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.select);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Symbol tryResumeSend(@Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    return (Symbol)this.select.trySelectOther(paramPrepareOp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractSendChannel.SendSelect
 * JD-Core Version:    0.7.0.1
 */