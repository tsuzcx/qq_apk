package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/AtomicDesc;", "", "()V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "setAtomicOp", "(Lkotlinx/coroutines/internal/AtomicOp;)V", "complete", "", "op", "failure", "prepare", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class AtomicDesc
{
  @NotNull
  public AtomicOp<?> atomicOp;
  
  public abstract void complete(@NotNull AtomicOp<?> paramAtomicOp, @Nullable Object paramObject);
  
  @NotNull
  public final AtomicOp<?> getAtomicOp()
  {
    AtomicOp localAtomicOp = this.atomicOp;
    if (localAtomicOp == null) {
      Intrinsics.throwUninitializedPropertyAccessException("atomicOp");
    }
    return localAtomicOp;
  }
  
  @Nullable
  public abstract Object prepare(@NotNull AtomicOp<?> paramAtomicOp);
  
  public final void setAtomicOp(@NotNull AtomicOp<?> paramAtomicOp)
  {
    this.atomicOp = paramAtomicOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.AtomicDesc
 * JD-Core Version:    0.7.0.1
 */