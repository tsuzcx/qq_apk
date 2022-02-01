package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/Mutex;", "", "isLocked", "", "()Z", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "holdsLock", "owner", "lock", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "unlock", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface Mutex
{
  @NotNull
  public abstract SelectClause2<Object, Mutex> getOnLock();
  
  public abstract boolean holdsLock(@NotNull Object paramObject);
  
  public abstract boolean isLocked();
  
  @Nullable
  public abstract Object lock(@Nullable Object paramObject, @NotNull Continuation<? super Unit> paramContinuation);
  
  public abstract boolean tryLock(@Nullable Object paramObject);
  
  public abstract void unlock(@Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.Mutex
 * JD-Core Version:    0.7.0.1
 */