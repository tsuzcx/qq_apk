package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class LockFreeTaskQueueCore<E>
{
  public static final int ADD_CLOSED = 2;
  public static final int ADD_FROZEN = 1;
  public static final int ADD_SUCCESS = 0;
  public static final int CAPACITY_BITS = 30;
  public static final long CLOSED_MASK = 2305843009213693952L;
  public static final int CLOSED_SHIFT = 61;
  public static final LockFreeTaskQueueCore.Companion Companion = new LockFreeTaskQueueCore.Companion(null);
  public static final long FROZEN_MASK = 1152921504606846976L;
  public static final int FROZEN_SHIFT = 60;
  public static final long HEAD_MASK = 1073741823L;
  public static final int HEAD_SHIFT = 0;
  public static final int INITIAL_CAPACITY = 8;
  public static final int MAX_CAPACITY_MASK = 1073741823;
  public static final int MIN_ADD_SPIN_CAPACITY = 1024;
  @JvmField
  @NotNull
  public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
  public static final long TAIL_MASK = 1152921503533105152L;
  public static final int TAIL_SHIFT = 30;
  private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
  private static final AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
  private volatile Object _next;
  private volatile long _state;
  private AtomicReferenceArray array;
  private final int capacity;
  private final int mask;
  private final boolean singleConsumer;
  
  public LockFreeTaskQueueCore(int paramInt, boolean paramBoolean)
  {
    this.capacity = paramInt;
    this.singleConsumer = paramBoolean;
    paramInt = this.capacity;
    this.mask = (paramInt - 1);
    this._next = null;
    this._state = 0L;
    this.array = new AtomicReferenceArray(paramInt);
    paramInt = this.mask;
    int i = 0;
    if (paramInt <= 1073741823) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      paramInt = i;
      if ((this.capacity & this.mask) == 0) {
        paramInt = 1;
      }
      if (paramInt != 0) {
        return;
      }
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  private final LockFreeTaskQueueCore<E> allocateNextCopy(long paramLong)
  {
    LockFreeTaskQueueCore localLockFreeTaskQueueCore = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
    Object localObject = Companion;
    int i = (int)((0x3FFFFFFF & paramLong) >> 0);
    int j = (int)((0xC0000000 & paramLong) >> 30);
    for (;;)
    {
      int k = this.mask;
      if ((i & k) == (j & k)) {
        break;
      }
      localObject = this.array.get(k & i);
      if (localObject == null) {
        localObject = new LockFreeTaskQueueCore.Placeholder(i);
      }
      localLockFreeTaskQueueCore.array.set(localLockFreeTaskQueueCore.mask & i, localObject);
      i += 1;
    }
    localLockFreeTaskQueueCore._state = Companion.wo(paramLong, 1152921504606846976L);
    return localLockFreeTaskQueueCore;
  }
  
  private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long paramLong)
  {
    for (;;)
    {
      LockFreeTaskQueueCore localLockFreeTaskQueueCore = (LockFreeTaskQueueCore)this._next;
      if (localLockFreeTaskQueueCore != null) {
        return localLockFreeTaskQueueCore;
      }
      _next$FU.compareAndSet(this, null, allocateNextCopy(paramLong));
    }
  }
  
  private final LockFreeTaskQueueCore<E> fillPlaceholder(int paramInt, E paramE)
  {
    Object localObject = this.array.get(this.mask & paramInt);
    if (((localObject instanceof LockFreeTaskQueueCore.Placeholder)) && (((LockFreeTaskQueueCore.Placeholder)localObject).index == paramInt))
    {
      this.array.set(paramInt & this.mask, paramE);
      return this;
    }
    return null;
  }
  
  private final long markFrozen()
  {
    long l1;
    long l2;
    do
    {
      l1 = this._state;
      if ((l1 & 0x0) != 0L) {
        return l1;
      }
      l2 = l1 | 0x0;
    } while (!_state$FU.compareAndSet(this, l1, l2));
    return l2;
  }
  
  private final LockFreeTaskQueueCore<E> removeSlowPath(int paramInt1, int paramInt2)
  {
    long l;
    int j;
    do
    {
      l = this._state;
      LockFreeTaskQueueCore.Companion localCompanion = Companion;
      int i = 0;
      j = (int)((0x3FFFFFFF & l) >> 0);
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        if (j == paramInt1) {
          i = 1;
        }
        if (i == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      if ((0x0 & l) != 0L) {
        return next();
      }
    } while (!_state$FU.compareAndSet(this, l, Companion.updateHead(l, paramInt2)));
    this.array.set(this.mask & j, null);
    return null;
  }
  
  public final int addLast(@NotNull E paramE)
  {
    long l;
    int j;
    int k;
    do
    {
      int i;
      do
      {
        l = this._state;
        if ((0x0 & l) != 0L) {
          return Companion.addFailReason(l);
        }
        localObject = Companion;
        i = (int)((0x3FFFFFFF & l) >> 0);
        j = (int)((0xC0000000 & l) >> 30);
        k = this.mask;
        if ((j + 2 & k) == (i & k)) {
          return 1;
        }
        if ((this.singleConsumer) || (this.array.get(j & k) == null)) {
          break;
        }
        k = this.capacity;
      } while ((k >= 1024) && ((j - i & 0x3FFFFFFF) <= k >> 1));
      return 1;
    } while (!_state$FU.compareAndSet(this, l, Companion.updateTail(l, j + 1 & 0x3FFFFFFF)));
    this.array.set(j & k, paramE);
    Object localObject = (LockFreeTaskQueueCore)this;
    do
    {
      if ((((LockFreeTaskQueueCore)localObject)._state & 0x0) == 0L) {
        return 0;
      }
      localObject = ((LockFreeTaskQueueCore)localObject).next().fillPlaceholder(j, paramE);
    } while (localObject != null);
    return 0;
  }
  
  public final boolean close()
  {
    long l;
    do
    {
      l = this._state;
      if ((l & 0x0) != 0L) {
        return true;
      }
      if ((0x0 & l) != 0L) {
        return false;
      }
    } while (!_state$FU.compareAndSet(this, l, l | 0x0));
    return true;
  }
  
  public final int getSize()
  {
    LockFreeTaskQueueCore.Companion localCompanion = Companion;
    long l = this._state;
    int i = (int)((0x3FFFFFFF & l) >> 0);
    return 0x3FFFFFFF & (int)((l & 0xC0000000) >> 30) - i;
  }
  
  public final boolean isClosed()
  {
    return (this._state & 0x0) != 0L;
  }
  
  public final boolean isEmpty()
  {
    LockFreeTaskQueueCore.Companion localCompanion = Companion;
    long l = this._state;
    boolean bool = false;
    if ((int)((0x3FFFFFFF & l) >> 0) == (int)((l & 0xC0000000) >> 30)) {
      bool = true;
    }
    return bool;
  }
  
  @NotNull
  public final <R> List<R> map(@NotNull Function1<? super E, ? extends R> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList(this.capacity);
    Object localObject = Companion;
    long l = this._state;
    int i = (int)((0x3FFFFFFF & l) >> 0);
    int j = (int)((l & 0xC0000000) >> 30);
    for (;;)
    {
      int k = this.mask;
      if ((i & k) == (j & k)) {
        break;
      }
      localObject = this.array.get(k & i);
      if ((localObject != null) && (!(localObject instanceof LockFreeTaskQueueCore.Placeholder))) {
        localArrayList.add(paramFunction1.invoke(localObject));
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public final LockFreeTaskQueueCore<E> next()
  {
    return allocateOrGetNextCopy(markFrozen());
  }
  
  @Nullable
  public final Object removeFirstOrNull()
  {
    int i;
    int j;
    Object localObject2;
    do
    {
      long l;
      do
      {
        l = this._state;
        if ((0x0 & l) != 0L) {
          return REMOVE_FROZEN;
        }
        localObject1 = Companion;
        i = (int)((0x3FFFFFFF & l) >> 0);
        j = (int)((0xC0000000 & l) >> 30);
        int k = this.mask;
        if ((j & k) == (i & k)) {
          return null;
        }
        localObject2 = this.array.get(k & i);
        if (localObject2 != null) {
          break;
        }
      } while (!this.singleConsumer);
      return null;
      if ((localObject2 instanceof LockFreeTaskQueueCore.Placeholder)) {
        return null;
      }
      j = i + 1 & 0x3FFFFFFF;
      if (_state$FU.compareAndSet(this, l, Companion.updateHead(l, j)))
      {
        this.array.set(this.mask & i, null);
        return localObject2;
      }
    } while (!this.singleConsumer);
    Object localObject1 = (LockFreeTaskQueueCore)this;
    do
    {
      localObject1 = ((LockFreeTaskQueueCore)localObject1).removeSlowPath(i, j);
    } while (localObject1 != null);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeTaskQueueCore
 * JD-Core Version:    0.7.0.1
 */