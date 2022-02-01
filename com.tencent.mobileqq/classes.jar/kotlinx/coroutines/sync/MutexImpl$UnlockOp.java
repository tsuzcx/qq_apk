package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.OpDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class MutexImpl$UnlockOp
  extends OpDescriptor
{
  @JvmField
  @NotNull
  public final MutexImpl.LockedQueue queue;
  
  public MutexImpl$UnlockOp(@NotNull MutexImpl.LockedQueue paramLockedQueue)
  {
    this.queue = paramLockedQueue;
  }
  
  @Nullable
  public AtomicOp<?> getAtomicOp()
  {
    return null;
  }
  
  @Nullable
  public Object perform(@Nullable Object paramObject)
  {
    Object localObject;
    if (this.queue.isEmpty()) {
      localObject = MutexKt.access$getEMPTY_UNLOCKED$p();
    } else {
      localObject = this.queue;
    }
    if (paramObject != null)
    {
      paramObject = (MutexImpl)paramObject;
      MutexImpl._state$FU.compareAndSet(paramObject, this, localObject);
      if (paramObject._state == this.queue) {
        return MutexKt.access$getUNLOCK_FAIL$p();
      }
      return null;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexImpl.UnlockOp
 * JD-Core Version:    0.7.0.1
 */