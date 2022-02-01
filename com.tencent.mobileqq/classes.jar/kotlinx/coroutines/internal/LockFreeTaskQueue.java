package kotlinx.coroutines.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class LockFreeTaskQueue<E>
{
  private static final AtomicReferenceFieldUpdater _cur$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
  private volatile Object _cur;
  
  public LockFreeTaskQueue(boolean paramBoolean)
  {
    this._cur = new LockFreeTaskQueueCore(8, paramBoolean);
  }
  
  public final boolean addLast(@NotNull E paramE)
  {
    for (;;)
    {
      LockFreeTaskQueueCore localLockFreeTaskQueueCore = (LockFreeTaskQueueCore)this._cur;
      int i = localLockFreeTaskQueueCore.addLast(paramE);
      if (i == 0) {
        break;
      }
      if (i != 1)
      {
        if (i == 2) {
          return false;
        }
      }
      else {
        _cur$FU.compareAndSet(this, localLockFreeTaskQueueCore, localLockFreeTaskQueueCore.next());
      }
    }
    return true;
  }
  
  public final void close()
  {
    for (;;)
    {
      LockFreeTaskQueueCore localLockFreeTaskQueueCore = (LockFreeTaskQueueCore)this._cur;
      if (localLockFreeTaskQueueCore.close()) {
        return;
      }
      _cur$FU.compareAndSet(this, localLockFreeTaskQueueCore, localLockFreeTaskQueueCore.next());
    }
  }
  
  public final int getSize()
  {
    return ((LockFreeTaskQueueCore)this._cur).getSize();
  }
  
  public final boolean isClosed()
  {
    return ((LockFreeTaskQueueCore)this._cur).isClosed();
  }
  
  public final boolean isEmpty()
  {
    return ((LockFreeTaskQueueCore)this._cur).isEmpty();
  }
  
  @NotNull
  public final <R> List<R> map(@NotNull Function1<? super E, ? extends R> paramFunction1)
  {
    return ((LockFreeTaskQueueCore)this._cur).map(paramFunction1);
  }
  
  @Nullable
  public final E removeFirstOrNull()
  {
    for (;;)
    {
      LockFreeTaskQueueCore localLockFreeTaskQueueCore = (LockFreeTaskQueueCore)this._cur;
      Object localObject = localLockFreeTaskQueueCore.removeFirstOrNull();
      if (localObject != LockFreeTaskQueueCore.REMOVE_FROZEN) {
        return localObject;
      }
      _cur$FU.compareAndSet(this, localLockFreeTaskQueueCore, localLockFreeTaskQueueCore.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeTaskQueue
 * JD-Core Version:    0.7.0.1
 */