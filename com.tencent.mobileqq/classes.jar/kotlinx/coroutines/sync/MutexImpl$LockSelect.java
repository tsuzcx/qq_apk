package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "owner", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/sync/Mutex;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "completeResumeLockWaiter", "", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class MutexImpl$LockSelect<R>
  extends MutexImpl.LockWaiter
{
  @JvmField
  @NotNull
  public final Function2<Mutex, Continuation<? super R>, Object> block;
  @JvmField
  @NotNull
  public final Mutex mutex;
  @JvmField
  @NotNull
  public final SelectInstance<R> select;
  
  public MutexImpl$LockSelect(@Nullable Object paramObject, @NotNull Mutex paramMutex, @NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    super(paramObject);
    this.mutex = paramMutex;
    this.select = paramSelectInstance;
    this.block = paramFunction2;
  }
  
  public void completeResumeLockWaiter(@NotNull Object paramObject)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (paramObject == MutexKt.access$getSELECT_SUCCESS$p()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    ContinuationKt.startCoroutine(this.block, this.mutex, this.select.getCompletion());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LockSelect[");
    localStringBuilder.append(this.owner);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mutex);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.select);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Object tryResumeLockWaiter()
  {
    if (this.select.trySelect()) {
      return MutexKt.access$getSELECT_SUCCESS$p();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexImpl.LockSelect
 * JD-Core Version:    0.7.0.1
 */