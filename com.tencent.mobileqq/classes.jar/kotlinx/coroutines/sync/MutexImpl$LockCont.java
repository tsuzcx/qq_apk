package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class MutexImpl$LockCont
  extends MutexImpl.LockWaiter
{
  @JvmField
  @NotNull
  public final CancellableContinuation<Unit> cont;
  
  public MutexImpl$LockCont(@Nullable Object paramObject, @NotNull CancellableContinuation<? super Unit> paramCancellableContinuation)
  {
    super(paramObject);
    this.cont = paramCancellableContinuation;
  }
  
  public void completeResumeLockWaiter(@NotNull Object paramObject)
  {
    this.cont.completeResume(paramObject);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LockCont[");
    localStringBuilder.append(this.owner);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.cont);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Object tryResumeLockWaiter()
  {
    return CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Unit.INSTANCE, null, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexImpl.LockCont
 * JD-Core Version:    0.7.0.1
 */