package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class MutexImpl
  implements SelectClause2<Object, Mutex>, Mutex
{
  static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
  volatile Object _state;
  
  public MutexImpl(boolean paramBoolean)
  {
    Empty localEmpty;
    if (paramBoolean) {
      localEmpty = MutexKt.access$getEMPTY_LOCKED$p();
    } else {
      localEmpty = MutexKt.access$getEMPTY_UNLOCKED$p();
    }
    this._state = localEmpty;
  }
  
  @NotNull
  public SelectClause2<Object, Mutex> getOnLock()
  {
    return (SelectClause2)this;
  }
  
  public boolean holdsLock(@NotNull Object paramObject)
  {
    Object localObject = this._state;
    if ((localObject instanceof Empty))
    {
      if (((Empty)localObject).locked != paramObject) {}
    }
    else {
      while (((localObject instanceof MutexImpl.LockedQueue)) && (((MutexImpl.LockedQueue)localObject).owner == paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isLocked()
  {
    for (;;)
    {
      localObject = this._state;
      if ((localObject instanceof Empty)) {
        return ((Empty)localObject).locked != MutexKt.access$getUNLOCKED$p();
      }
      if ((localObject instanceof MutexImpl.LockedQueue)) {
        return true;
      }
      if (!(localObject instanceof OpDescriptor)) {
        break;
      }
      ((OpDescriptor)localObject).perform(this);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Illegal state ");
    localStringBuilder.append(localObject);
    Object localObject = (Throwable)new IllegalStateException(localStringBuilder.toString().toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core()
  {
    Object localObject = this._state;
    return ((localObject instanceof MutexImpl.LockedQueue)) && (((MutexImpl.LockedQueue)localObject).isEmpty());
  }
  
  @Nullable
  public Object lock(@Nullable Object paramObject, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (tryLock(paramObject)) {
      return Unit.INSTANCE;
    }
    paramObject = lockSuspend(paramObject, paramContinuation);
    if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramObject;
    }
    return Unit.INSTANCE;
  }
  
  public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> paramSelectInstance, @Nullable Object paramObject, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    Object localObject1;
    for (;;)
    {
      if (paramSelectInstance.isSelected()) {
        return;
      }
      localObject1 = this._state;
      Object localObject2;
      if ((localObject1 instanceof Empty))
      {
        localObject2 = (Empty)localObject1;
        if (((Empty)localObject2).locked != MutexKt.access$getUNLOCKED$p())
        {
          _state$FU.compareAndSet(this, localObject1, new MutexImpl.LockedQueue(((Empty)localObject2).locked));
        }
        else
        {
          localObject1 = paramSelectInstance.performAtomicTrySelect((AtomicDesc)new MutexImpl.TryLockDesc(this, paramObject));
          if (localObject1 == null)
          {
            UndispatchedKt.startCoroutineUnintercepted(paramFunction2, this, paramSelectInstance.getCompletion());
            return;
          }
          if (localObject1 == SelectKt.getALREADY_SELECTED()) {
            return;
          }
          if ((localObject1 != MutexKt.access$getLOCK_FAIL$p()) && (localObject1 != AtomicKt.RETRY_ATOMIC))
          {
            paramSelectInstance = new StringBuilder();
            paramSelectInstance.append("performAtomicTrySelect(TryLockDesc) returned ");
            paramSelectInstance.append(localObject1);
            throw ((Throwable)new IllegalStateException(paramSelectInstance.toString().toString()));
          }
        }
      }
      else if ((localObject1 instanceof MutexImpl.LockedQueue))
      {
        Object localObject3 = (MutexImpl.LockedQueue)localObject1;
        localObject2 = ((MutexImpl.LockedQueue)localObject3).owner;
        int j = 0;
        int i;
        if (localObject2 != paramObject) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          localObject2 = new MutexImpl.LockSelect(paramObject, (Mutex)this, paramSelectInstance, paramFunction2);
          localObject3 = (LockFreeLinkedListNode)localObject3;
          LockFreeLinkedListNode localLockFreeLinkedListNode = (LockFreeLinkedListNode)localObject2;
          localObject1 = (LockFreeLinkedListNode.CondAddOp)new MutexImpl.registerSelectClause2..inlined.addLastIf.1(localLockFreeLinkedListNode, localLockFreeLinkedListNode, this, localObject1);
          for (;;)
          {
            int k = ((LockFreeLinkedListNode)localObject3).getPrevNode().tryCondAddNext(localLockFreeLinkedListNode, (LockFreeLinkedListNode)localObject3, (LockFreeLinkedListNode.CondAddOp)localObject1);
            if (k == 1) {
              break;
            }
            i = j;
            if (k == 2) {
              break label308;
            }
          }
          i = 1;
          label308:
          if (i != 0) {
            paramSelectInstance.disposeOnSelect((DisposableHandle)localObject2);
          }
        }
        else
        {
          paramSelectInstance = new StringBuilder();
          paramSelectInstance.append("Already locked by ");
          paramSelectInstance.append(paramObject);
          throw ((Throwable)new IllegalStateException(paramSelectInstance.toString().toString()));
        }
      }
      else
      {
        if (!(localObject1 instanceof OpDescriptor)) {
          break;
        }
        ((OpDescriptor)localObject1).perform(this);
      }
    }
    paramSelectInstance = new StringBuilder();
    paramSelectInstance.append("Illegal state ");
    paramSelectInstance.append(localObject1);
    paramSelectInstance = (Throwable)new IllegalStateException(paramSelectInstance.toString().toString());
    for (;;)
    {
      throw paramSelectInstance;
    }
  }
  
  @NotNull
  public String toString()
  {
    for (;;)
    {
      localObject = this._state;
      if ((localObject instanceof Empty))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Mutex[");
        localStringBuilder.append(((Empty)localObject).locked);
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      if (!(localObject instanceof OpDescriptor)) {
        break;
      }
      ((OpDescriptor)localObject).perform(this);
    }
    if ((localObject instanceof MutexImpl.LockedQueue))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Mutex[");
      localStringBuilder.append(((MutexImpl.LockedQueue)localObject).owner);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Illegal state ");
    localStringBuilder.append(localObject);
    Object localObject = (Throwable)new IllegalStateException(localStringBuilder.toString().toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public boolean tryLock(@Nullable Object paramObject)
  {
    Object localObject2;
    for (;;)
    {
      localObject2 = this._state;
      boolean bool = localObject2 instanceof Empty;
      int i = 1;
      Object localObject1;
      if (bool)
      {
        if (((Empty)localObject2).locked != MutexKt.access$getUNLOCKED$p()) {
          return false;
        }
        if (paramObject == null) {
          localObject1 = MutexKt.access$getEMPTY_LOCKED$p();
        } else {
          localObject1 = new Empty(paramObject);
        }
        if (_state$FU.compareAndSet(this, localObject2, localObject1)) {
          return true;
        }
      }
      else
      {
        if ((localObject2 instanceof MutexImpl.LockedQueue))
        {
          if (((MutexImpl.LockedQueue)localObject2).owner == paramObject) {
            i = 0;
          }
          if (i != 0) {
            return false;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Already locked by ");
          ((StringBuilder)localObject1).append(paramObject);
          throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString().toString()));
        }
        if (!(localObject2 instanceof OpDescriptor)) {
          break;
        }
        ((OpDescriptor)localObject2).perform(this);
      }
    }
    paramObject = new StringBuilder();
    paramObject.append("Illegal state ");
    paramObject.append(localObject2);
    paramObject = (Throwable)new IllegalStateException(paramObject.toString().toString());
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public void unlock(@Nullable Object paramObject)
  {
    Object localObject2;
    Object localObject1;
    label115:
    Object localObject3;
    do
    {
      do
      {
        int k;
        int i;
        for (;;)
        {
          localObject2 = this._state;
          boolean bool = localObject2 instanceof Empty;
          int j = 1;
          k = 1;
          i = 1;
          if (bool)
          {
            if (paramObject == null)
            {
              if (((Empty)localObject2).locked == MutexKt.access$getUNLOCKED$p()) {
                i = 0;
              }
              if (i == 0) {
                throw ((Throwable)new IllegalStateException("Mutex is not locked".toString()));
              }
            }
            else
            {
              localObject1 = (Empty)localObject2;
              if (((Empty)localObject1).locked == paramObject) {
                i = j;
              } else {
                i = 0;
              }
              if (i == 0) {
                break label115;
              }
            }
            if (_state$FU.compareAndSet(this, localObject2, MutexKt.access$getEMPTY_UNLOCKED$p()))
            {
              return;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Mutex is locked by ");
              ((StringBuilder)localObject2).append(((Empty)localObject1).locked);
              ((StringBuilder)localObject2).append(" but expected ");
              ((StringBuilder)localObject2).append(paramObject);
              throw ((Throwable)new IllegalStateException(((StringBuilder)localObject2).toString().toString()));
            }
          }
          else
          {
            if (!(localObject2 instanceof OpDescriptor)) {
              break;
            }
            ((OpDescriptor)localObject2).perform(this);
          }
        }
        if (!(localObject2 instanceof MutexImpl.LockedQueue)) {
          break label411;
        }
        if (paramObject != null)
        {
          localObject1 = (MutexImpl.LockedQueue)localObject2;
          if (((MutexImpl.LockedQueue)localObject1).owner == paramObject) {
            i = k;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Mutex is locked by ");
            ((StringBuilder)localObject2).append(((MutexImpl.LockedQueue)localObject1).owner);
            ((StringBuilder)localObject2).append(" but expected ");
            ((StringBuilder)localObject2).append(paramObject);
            throw ((Throwable)new IllegalStateException(((StringBuilder)localObject2).toString().toString()));
          }
        }
        localObject1 = (MutexImpl.LockedQueue)localObject2;
        localObject3 = ((MutexImpl.LockedQueue)localObject1).removeFirstOrNull();
        if (localObject3 != null) {
          break;
        }
        localObject1 = new MutexImpl.UnlockOp((MutexImpl.LockedQueue)localObject1);
      } while ((!_state$FU.compareAndSet(this, localObject2, localObject1)) || (((MutexImpl.UnlockOp)localObject1).perform(this) != null));
      return;
      localObject2 = (MutexImpl.LockWaiter)localObject3;
      localObject3 = ((MutexImpl.LockWaiter)localObject2).tryResumeLockWaiter();
    } while (localObject3 == null);
    paramObject = ((MutexImpl.LockWaiter)localObject2).owner;
    if (paramObject == null) {
      paramObject = MutexKt.access$getLOCKED$p();
    }
    ((MutexImpl.LockedQueue)localObject1).owner = paramObject;
    ((MutexImpl.LockWaiter)localObject2).completeResumeLockWaiter(localObject3);
    return;
    label411:
    paramObject = new StringBuilder();
    paramObject.append("Illegal state ");
    paramObject.append(localObject2);
    paramObject = (Throwable)new IllegalStateException(paramObject.toString().toString());
    for (;;)
    {
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexImpl
 * JD-Core Version:    0.7.0.1
 */