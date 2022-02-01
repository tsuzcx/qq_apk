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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", "R", "E", "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V", "Lkotlin/jvm/functions/Function2;", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "dispose", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class AbstractChannel$ReceiveSelect<R, E>
  extends Receive<E>
  implements DisposableHandle
{
  @JvmField
  @NotNull
  public final Function2<Object, Continuation<? super R>, Object> block;
  @JvmField
  @NotNull
  public final AbstractChannel<E> channel;
  @JvmField
  public final int receiveMode;
  @JvmField
  @NotNull
  public final SelectInstance<R> select;
  
  public AbstractChannel$ReceiveSelect(@NotNull AbstractChannel<E> paramAbstractChannel, @NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> paramFunction2, int paramInt)
  {
    this.channel = paramAbstractChannel;
    this.select = paramSelectInstance;
    this.block = paramFunction2;
    this.receiveMode = paramInt;
  }
  
  public void completeResumeReceive(E paramE)
  {
    Function2 localFunction2 = this.block;
    Object localObject = paramE;
    if (this.receiveMode == 2)
    {
      localObject = ValueOrClosed.Companion;
      localObject = ValueOrClosed.box-impl(ValueOrClosed.constructor-impl(paramE));
    }
    ContinuationKt.startCoroutine(localFunction2, localObject, this.select.getCompletion());
  }
  
  public void dispose()
  {
    if (remove()) {
      this.channel.onReceiveDequeued();
    }
  }
  
  public void resumeReceiveClosed(@NotNull Closed<?> paramClosed)
  {
    if (!this.select.trySelect()) {
      return;
    }
    int i = this.receiveMode;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        Function2 localFunction2 = this.block;
        ValueOrClosed.Companion localCompanion = ValueOrClosed.Companion;
        ContinuationKt.startCoroutine(localFunction2, ValueOrClosed.box-impl(ValueOrClosed.constructor-impl(new ValueOrClosed.Closed(paramClosed.closeCause))), this.select.getCompletion());
        return;
      }
      if (paramClosed.closeCause == null)
      {
        ContinuationKt.startCoroutine(this.block, null, this.select.getCompletion());
        return;
      }
      this.select.resumeSelectWithException(paramClosed.getReceiveException());
      return;
    }
    this.select.resumeSelectWithException(paramClosed.getReceiveException());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReceiveSelect@");
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    localStringBuilder.append('[');
    localStringBuilder.append(this.select);
    localStringBuilder.append(",receiveMode=");
    localStringBuilder.append(this.receiveMode);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Symbol tryResumeReceive(E paramE, @Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    return (Symbol)this.select.trySelectOther(paramPrepareOp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractChannel.ReceiveSelect
 * JD-Core Version:    0.7.0.1
 */