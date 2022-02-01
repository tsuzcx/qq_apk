package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "owner", "", "(Ljava/lang/Object;)V", "completeResumeLockWaiter", "", "token", "dispose", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
abstract class MutexImpl$LockWaiter
  extends LockFreeLinkedListNode
  implements DisposableHandle
{
  @JvmField
  @Nullable
  public final Object owner;
  
  public MutexImpl$LockWaiter(@Nullable Object paramObject)
  {
    this.owner = paramObject;
  }
  
  public abstract void completeResumeLockWaiter(@NotNull Object paramObject);
  
  public final void dispose()
  {
    remove();
  }
  
  @Nullable
  public abstract Object tryResumeLockWaiter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexImpl.LockWaiter
 * JD-Core Version:    0.7.0.1
 */