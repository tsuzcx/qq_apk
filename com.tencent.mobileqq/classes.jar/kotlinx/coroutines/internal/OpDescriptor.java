package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/OpDescriptor;", "", "()V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "isEarlierThan", "", "that", "perform", "affected", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class OpDescriptor
{
  @Nullable
  public abstract AtomicOp<?> getAtomicOp();
  
  public final boolean isEarlierThan(@NotNull OpDescriptor paramOpDescriptor)
  {
    AtomicOp localAtomicOp = getAtomicOp();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAtomicOp != null)
    {
      paramOpDescriptor = paramOpDescriptor.getAtomicOp();
      bool1 = bool2;
      if (paramOpDescriptor != null)
      {
        bool1 = bool2;
        if (localAtomicOp.getOpSequence() < paramOpDescriptor.getOpSequence()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  public abstract Object perform(@Nullable Object paramObject);
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DebugStringsKt.getClassSimpleName(this));
    localStringBuilder.append('@');
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.OpDescriptor
 * JD-Core Version:    0.7.0.1
 */