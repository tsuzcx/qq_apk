package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicOp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "mutex", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "prepare", "PrepareOp", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class MutexImpl$TryLockDesc
  extends AtomicDesc
{
  @JvmField
  @NotNull
  public final MutexImpl mutex;
  @JvmField
  @Nullable
  public final Object owner;
  
  public MutexImpl$TryLockDesc(@NotNull MutexImpl paramMutexImpl, @Nullable Object paramObject)
  {
    this.mutex = paramMutexImpl;
    this.owner = paramObject;
  }
  
  public void complete(@NotNull AtomicOp<?> paramAtomicOp, @Nullable Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = MutexKt.access$getEMPTY_UNLOCKED$p();
    }
    else
    {
      paramObject = this.owner;
      if (paramObject == null) {
        paramObject = MutexKt.access$getEMPTY_LOCKED$p();
      } else {
        paramObject = new Empty(paramObject);
      }
    }
    MutexImpl localMutexImpl = this.mutex;
    MutexImpl._state$FU.compareAndSet(localMutexImpl, paramAtomicOp, paramObject);
  }
  
  @Nullable
  public Object prepare(@NotNull AtomicOp<?> paramAtomicOp)
  {
    paramAtomicOp = new MutexImpl.TryLockDesc.PrepareOp(this, paramAtomicOp);
    MutexImpl localMutexImpl = this.mutex;
    if (!MutexImpl._state$FU.compareAndSet(localMutexImpl, MutexKt.access$getEMPTY_UNLOCKED$p(), paramAtomicOp)) {
      return MutexKt.access$getLOCK_FAIL$p();
    }
    return paramAtomicOp.perform(this.mutex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexImpl.TryLockDesc
 * JD-Core Version:    0.7.0.1
 */