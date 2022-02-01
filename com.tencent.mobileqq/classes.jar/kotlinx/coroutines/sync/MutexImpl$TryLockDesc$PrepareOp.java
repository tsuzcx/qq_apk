package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.OpDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class MutexImpl$TryLockDesc$PrepareOp
  extends OpDescriptor
{
  @NotNull
  private final AtomicOp<?> atomicOp;
  
  public MutexImpl$TryLockDesc$PrepareOp(AtomicOp<?> paramAtomicOp)
  {
    Object localObject;
    this.atomicOp = localObject;
  }
  
  @NotNull
  public AtomicOp<?> getAtomicOp()
  {
    return this.atomicOp;
  }
  
  @Nullable
  public Object perform(@Nullable Object paramObject)
  {
    Object localObject;
    if (getAtomicOp().isDecided()) {
      localObject = MutexKt.access$getEMPTY_UNLOCKED$p();
    } else {
      localObject = getAtomicOp();
    }
    if (paramObject != null)
    {
      paramObject = (MutexImpl)paramObject;
      MutexImpl._state$FU.compareAndSet(paramObject, this, localObject);
      return null;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexImpl.TryLockDesc.PrepareOp
 * JD-Core Version:    0.7.0.1
 */