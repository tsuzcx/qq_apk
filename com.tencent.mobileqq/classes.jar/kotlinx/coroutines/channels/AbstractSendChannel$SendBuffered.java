package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class AbstractSendChannel$SendBuffered<E>
  extends Send
{
  @JvmField
  public final E element;
  
  public AbstractSendChannel$SendBuffered(E paramE)
  {
    this.element = paramE;
  }
  
  public void completeResumeSend() {}
  
  @Nullable
  public Object getPollResult()
  {
    return this.element;
  }
  
  public void resumeSendClosed(@NotNull Closed<?> paramClosed) {}
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendBuffered@");
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    localStringBuilder.append('(');
    localStringBuilder.append(this.element);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
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
 * Qualified Name:     kotlinx.coroutines.channels.AbstractSendChannel.SendBuffered
 * JD-Core Version:    0.7.0.1
 */