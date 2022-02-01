package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", "E", "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class AbstractChannel$ReceiveHasNext<E>
  extends Receive<E>
{
  @JvmField
  @NotNull
  public final CancellableContinuation<Boolean> cont;
  @JvmField
  @NotNull
  public final AbstractChannel.Itr<E> iterator;
  
  public AbstractChannel$ReceiveHasNext(@NotNull AbstractChannel.Itr<E> paramItr, @NotNull CancellableContinuation<? super Boolean> paramCancellableContinuation)
  {
    this.iterator = paramItr;
    this.cont = paramCancellableContinuation;
  }
  
  public void completeResumeReceive(E paramE)
  {
    this.iterator.setResult(paramE);
    this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
  }
  
  public void resumeReceiveClosed(@NotNull Closed<?> paramClosed)
  {
    Object localObject;
    if (paramClosed.closeCause == null)
    {
      localObject = CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Boolean.valueOf(false), null, 2, null);
    }
    else
    {
      CancellableContinuation localCancellableContinuation = this.cont;
      Throwable localThrowable = paramClosed.getReceiveException();
      Continuation localContinuation = (Continuation)this.cont;
      localObject = localThrowable;
      if (DebugKt.getRECOVER_STACK_TRACES()) {
        if (!(localContinuation instanceof CoroutineStackFrame)) {
          localObject = localThrowable;
        } else {
          localObject = StackTraceRecoveryKt.access$recoverFromStackFrame(localThrowable, (CoroutineStackFrame)localContinuation);
        }
      }
      localObject = localCancellableContinuation.tryResumeWithException((Throwable)localObject);
    }
    if (localObject != null)
    {
      this.iterator.setResult(paramClosed);
      this.cont.completeResume(localObject);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReceiveHasNext@");
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Symbol tryResumeReceive(E paramE, @Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    CancellableContinuation localCancellableContinuation = this.cont;
    int i = 1;
    if (paramPrepareOp != null) {
      paramE = paramPrepareOp.desc;
    } else {
      paramE = null;
    }
    paramE = localCancellableContinuation.tryResume(Boolean.valueOf(true), paramE);
    if (paramE != null)
    {
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        if (paramE != CancellableContinuationImplKt.RESUME_TOKEN) {
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
 * Qualified Name:     kotlinx.coroutines.channels.AbstractChannel.ReceiveHasNext
 * JD-Core Version:    0.7.0.1
 */