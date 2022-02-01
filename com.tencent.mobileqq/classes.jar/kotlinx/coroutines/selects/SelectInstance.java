package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/SelectInstance;", "R", "", "completion", "Lkotlin/coroutines/Continuation;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "isSelected", "", "()Z", "disposeOnSelect", "", "handle", "Lkotlinx/coroutines/DisposableHandle;", "performAtomicTrySelect", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "resumeSelectWithException", "exception", "", "trySelect", "trySelectOther", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public abstract interface SelectInstance<R>
{
  public abstract void disposeOnSelect(@NotNull DisposableHandle paramDisposableHandle);
  
  @NotNull
  public abstract Continuation<R> getCompletion();
  
  public abstract boolean isSelected();
  
  @Nullable
  public abstract Object performAtomicTrySelect(@NotNull AtomicDesc paramAtomicDesc);
  
  public abstract void resumeSelectWithException(@NotNull Throwable paramThrowable);
  
  public abstract boolean trySelect();
  
  @Nullable
  public abstract Object trySelectOther(@Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectInstance
 * JD-Core Version:    0.7.0.1
 */