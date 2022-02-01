package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", "", "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "completeResumeSend", "resumeSendClosed", "closed", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class Closed<E>
  extends Send
  implements ReceiveOrClosed<E>
{
  @JvmField
  @Nullable
  public final Throwable closeCause;
  
  public Closed(@Nullable Throwable paramThrowable)
  {
    this.closeCause = paramThrowable;
  }
  
  public void completeResumeReceive(E paramE) {}
  
  public void completeResumeSend() {}
  
  @NotNull
  public Closed<E> getOfferResult()
  {
    return this;
  }
  
  @NotNull
  public Closed<E> getPollResult()
  {
    return this;
  }
  
  @NotNull
  public final Throwable getReceiveException()
  {
    Throwable localThrowable = this.closeCause;
    if (localThrowable != null) {
      return localThrowable;
    }
    return (Throwable)new ClosedReceiveChannelException("Channel was closed");
  }
  
  @NotNull
  public final Throwable getSendException()
  {
    Throwable localThrowable = this.closeCause;
    if (localThrowable != null) {
      return localThrowable;
    }
    return (Throwable)new ClosedSendChannelException("Channel was closed");
  }
  
  public void resumeSendClosed(@NotNull Closed<?> paramClosed)
  {
    if (DebugKt.getASSERTIONS_ENABLED()) {
      throw ((Throwable)new AssertionError());
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Closed@");
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    localStringBuilder.append('[');
    localStringBuilder.append(this.closeCause);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Symbol tryResumeReceive(E paramE, @Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    paramE = CancellableContinuationImplKt.RESUME_TOKEN;
    if (paramPrepareOp != null) {
      paramPrepareOp.finishPrepare();
    }
    return paramE;
  }
  
  @Nullable
  public Symbol tryResumeSend(@Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    Symbol localSymbol = CancellableContinuationImplKt.RESUME_TOKEN;
    if (paramPrepareOp != null) {
      paramPrepareOp.finishPrepare();
    }
    return localSymbol;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.Closed
 * JD-Core Version:    0.7.0.1
 */