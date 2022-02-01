package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ReceiveOrClosed;", "E", "", "offerResult", "getOfferResult", "()Ljava/lang/Object;", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface ReceiveOrClosed<E>
{
  public abstract void completeResumeReceive(E paramE);
  
  @NotNull
  public abstract Object getOfferResult();
  
  @Nullable
  public abstract Symbol tryResumeReceive(E paramE, @Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ReceiveOrClosed
 * JD-Core Version:    0.7.0.1
 */