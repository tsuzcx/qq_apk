package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class AbstractChannel$ReceiveElement<E>
  extends Receive<E>
{
  @JvmField
  @NotNull
  public final CancellableContinuation<Object> cont;
  @JvmField
  public final int receiveMode;
  
  public AbstractChannel$ReceiveElement(@NotNull CancellableContinuation<Object> paramCancellableContinuation, int paramInt)
  {
    this.cont = paramCancellableContinuation;
    this.receiveMode = paramInt;
  }
  
  public void completeResumeReceive(E paramE)
  {
    this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
  }
  
  public void resumeReceiveClosed(@NotNull Closed<?> paramClosed)
  {
    if ((this.receiveMode == 1) && (paramClosed.closeCause == null))
    {
      paramClosed = (Continuation)this.cont;
      localObject1 = Result.Companion;
      paramClosed.resumeWith(Result.constructor-impl(null));
      return;
    }
    if (this.receiveMode == 2)
    {
      localObject1 = (Continuation)this.cont;
      localObject2 = ValueOrClosed.Companion;
      paramClosed = ValueOrClosed.box-impl(ValueOrClosed.constructor-impl(new ValueOrClosed.Closed(paramClosed.closeCause)));
      localObject2 = Result.Companion;
      ((Continuation)localObject1).resumeWith(Result.constructor-impl(paramClosed));
      return;
    }
    Object localObject1 = (Continuation)this.cont;
    paramClosed = paramClosed.getReceiveException();
    Object localObject2 = Result.Companion;
    ((Continuation)localObject1).resumeWith(Result.constructor-impl(ResultKt.createFailure(paramClosed)));
  }
  
  @Nullable
  public final Object resumeValue(E paramE)
  {
    if (this.receiveMode != 2) {
      return paramE;
    }
    ValueOrClosed.Companion localCompanion = ValueOrClosed.Companion;
    return ValueOrClosed.box-impl(ValueOrClosed.constructor-impl(paramE));
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReceiveElement@");
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    localStringBuilder.append("[receiveMode=");
    localStringBuilder.append(this.receiveMode);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Symbol tryResumeReceive(E paramE, @Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    CancellableContinuation localCancellableContinuation = this.cont;
    Object localObject = resumeValue(paramE);
    if (paramPrepareOp != null) {
      paramE = paramPrepareOp.desc;
    } else {
      paramE = null;
    }
    paramE = localCancellableContinuation.tryResume(localObject, paramE);
    if (paramE != null)
    {
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        int i;
        if (paramE == CancellableContinuationImplKt.RESUME_TOKEN) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      if (paramPrepareOp != null) {
        paramPrepareOp.finishPrepare();
      }
      return CancellableContinuationImplKt.RESUME_TOKEN;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractChannel.ReceiveElement
 * JD-Core Version:    0.7.0.1
 */