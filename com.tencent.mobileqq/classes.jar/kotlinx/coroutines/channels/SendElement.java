package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/SendElement;", "Lkotlinx/coroutines/channels/Send;", "pollResult", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class SendElement
  extends Send
{
  @JvmField
  @NotNull
  public final CancellableContinuation<Unit> cont;
  @Nullable
  private final Object pollResult;
  
  public SendElement(@Nullable Object paramObject, @NotNull CancellableContinuation<? super Unit> paramCancellableContinuation)
  {
    this.pollResult = paramObject;
    this.cont = paramCancellableContinuation;
  }
  
  public void completeResumeSend()
  {
    this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
  }
  
  @Nullable
  public Object getPollResult()
  {
    return this.pollResult;
  }
  
  public void resumeSendClosed(@NotNull Closed<?> paramClosed)
  {
    Continuation localContinuation = (Continuation)this.cont;
    paramClosed = paramClosed.getSendException();
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramClosed)));
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendElement@");
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    localStringBuilder.append('(');
    localStringBuilder.append(getPollResult());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Symbol tryResumeSend(@Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    CancellableContinuation localCancellableContinuation = this.cont;
    Unit localUnit = Unit.INSTANCE;
    if (paramPrepareOp != null) {
      localObject = paramPrepareOp.desc;
    } else {
      localObject = null;
    }
    Object localObject = localCancellableContinuation.tryResume(localUnit, localObject);
    if (localObject != null)
    {
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        int i;
        if (localObject == CancellableContinuationImplKt.RESUME_TOKEN) {
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
 * Qualified Name:     kotlinx.coroutines.channels.SendElement
 * JD-Core Version:    0.7.0.1
 */