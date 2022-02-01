package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.OpDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class SelectBuilderImpl$PairSelectOp
  extends OpDescriptor
{
  @JvmField
  @NotNull
  public final LockFreeLinkedListNode.PrepareOp otherOp;
  
  public SelectBuilderImpl$PairSelectOp(@NotNull LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    this.otherOp = paramPrepareOp;
  }
  
  @Nullable
  public AtomicOp<?> getAtomicOp()
  {
    return this.otherOp.getAtomicOp();
  }
  
  @Nullable
  public Object perform(@Nullable Object paramObject)
  {
    if (paramObject != null)
    {
      SelectBuilderImpl localSelectBuilderImpl = (SelectBuilderImpl)paramObject;
      this.otherOp.finishPrepare();
      Object localObject = this.otherOp.getAtomicOp().decide(null);
      if (localObject == null) {
        paramObject = this.otherOp.desc;
      } else {
        paramObject = localSelectBuilderImpl;
      }
      SelectBuilderImpl._state$FU.compareAndSet(localSelectBuilderImpl, this, paramObject);
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectBuilderImpl.PairSelectOp
 * JD-Core Version:    0.7.0.1
 */