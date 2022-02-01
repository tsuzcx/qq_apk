package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class MutexImpl$LockedQueue
  extends LockFreeLinkedListHead
{
  @JvmField
  @NotNull
  public Object owner;
  
  public MutexImpl$LockedQueue(@NotNull Object paramObject)
  {
    this.owner = paramObject;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LockedQueue[");
    localStringBuilder.append(this.owner);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexImpl.LockedQueue
 * JD-Core Version:    0.7.0.1
 */