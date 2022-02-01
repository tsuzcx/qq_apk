package kotlinx.coroutines.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public class ThreadSafeHeap<T extends ThreadSafeHeapNode,  extends Comparable<? super T>>
{
  private volatile int _size = 0;
  private T[] a;
  
  private final T[] realloc()
  {
    ThreadSafeHeapNode[] arrayOfThreadSafeHeapNode = this.a;
    if (arrayOfThreadSafeHeapNode == null)
    {
      localObject = new ThreadSafeHeapNode[4];
      this.a = ((ThreadSafeHeapNode[])localObject);
      return localObject;
    }
    Object localObject = arrayOfThreadSafeHeapNode;
    if (getSize() >= arrayOfThreadSafeHeapNode.length)
    {
      localObject = Arrays.copyOf(arrayOfThreadSafeHeapNode, getSize() * 2);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.copyOf(this, newSize)");
      localObject = (ThreadSafeHeapNode[])localObject;
      this.a = ((ThreadSafeHeapNode[])localObject);
    }
    return localObject;
  }
  
  private final void setSize(int paramInt)
  {
    this._size = paramInt;
  }
  
  private final void siftDownFrom(int paramInt)
  {
    for (int i = paramInt;; i = paramInt)
    {
      int j = i * 2 + 1;
      if (j >= getSize()) {
        return;
      }
      Object localObject1 = this.a;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      int k = j + 1;
      paramInt = j;
      if (k < getSize())
      {
        localComparable = localObject1[k];
        if (localComparable == null) {
          Intrinsics.throwNpe();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[j];
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        paramInt = j;
        if (localComparable.compareTo(localObject2) < 0) {
          paramInt = k;
        }
      }
      Comparable localComparable = localObject1[i];
      if (localComparable == null) {
        Intrinsics.throwNpe();
      }
      localComparable = (Comparable)localComparable;
      localObject1 = localObject1[paramInt];
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (localComparable.compareTo(localObject1) <= 0) {
        return;
      }
      swap(i, paramInt);
    }
  }
  
  private final void siftUpFrom(int paramInt)
  {
    for (;;)
    {
      if (paramInt <= 0) {
        return;
      }
      Object localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      int i = (paramInt - 1) / 2;
      Comparable localComparable = localObject[i];
      if (localComparable == null) {
        Intrinsics.throwNpe();
      }
      localComparable = (Comparable)localComparable;
      localObject = localObject[paramInt];
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (localComparable.compareTo(localObject) <= 0) {
        return;
      }
      swap(paramInt, i);
      paramInt = i;
    }
  }
  
  private final void swap(int paramInt1, int paramInt2)
  {
    ThreadSafeHeapNode[] arrayOfThreadSafeHeapNode = this.a;
    if (arrayOfThreadSafeHeapNode == null) {
      Intrinsics.throwNpe();
    }
    ThreadSafeHeapNode localThreadSafeHeapNode1 = arrayOfThreadSafeHeapNode[paramInt2];
    if (localThreadSafeHeapNode1 == null) {
      Intrinsics.throwNpe();
    }
    ThreadSafeHeapNode localThreadSafeHeapNode2 = arrayOfThreadSafeHeapNode[paramInt1];
    if (localThreadSafeHeapNode2 == null) {
      Intrinsics.throwNpe();
    }
    arrayOfThreadSafeHeapNode[paramInt1] = localThreadSafeHeapNode1;
    arrayOfThreadSafeHeapNode[paramInt2] = localThreadSafeHeapNode2;
    localThreadSafeHeapNode1.setIndex(paramInt1);
    localThreadSafeHeapNode2.setIndex(paramInt2);
  }
  
  @PublishedApi
  public final void addImpl(@NotNull T paramT)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      if (paramT.getHeap() == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    paramT.setHeap((ThreadSafeHeap)this);
    ThreadSafeHeapNode[] arrayOfThreadSafeHeapNode = realloc();
    int i = getSize();
    setSize(i + 1);
    arrayOfThreadSafeHeapNode[i] = paramT;
    paramT.setIndex(i);
    siftUpFrom(i);
  }
  
  public final void addLast(@NotNull T paramT)
  {
    try
    {
      addImpl(paramT);
      paramT = Unit.INSTANCE;
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public final boolean addLastIf(@NotNull T paramT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    try
    {
      boolean bool;
      if (((Boolean)paramFunction1.invoke(firstImpl())).booleanValue())
      {
        addImpl(paramT);
        bool = true;
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      InlineMarker.finallyEnd(1);
    }
  }
  
  public final void clear()
  {
    try
    {
      Object localObject1 = this.a;
      if (localObject1 != null) {
        ArraysKt.fill$default((Object[])localObject1, null, 0, 0, 6, null);
      }
      this._size = 0;
      localObject1 = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  @PublishedApi
  @Nullable
  public final T firstImpl()
  {
    ThreadSafeHeapNode[] arrayOfThreadSafeHeapNode = this.a;
    if (arrayOfThreadSafeHeapNode != null) {
      return arrayOfThreadSafeHeapNode[0];
    }
    return null;
  }
  
  public final int getSize()
  {
    return this._size;
  }
  
  public final boolean isEmpty()
  {
    return getSize() == 0;
  }
  
  @Nullable
  public final T peek()
  {
    try
    {
      ThreadSafeHeapNode localThreadSafeHeapNode = firstImpl();
      return localThreadSafeHeapNode;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean remove(@NotNull T paramT)
  {
    for (;;)
    {
      int i;
      try
      {
        ThreadSafeHeap localThreadSafeHeap = paramT.getHeap();
        boolean bool = true;
        i = 0;
        if (localThreadSafeHeap == null)
        {
          bool = false;
        }
        else
        {
          int j = paramT.getIndex();
          if (DebugKt.getASSERTIONS_ENABLED())
          {
            if (j < 0) {
              break label75;
            }
            i = 1;
            break label75;
            throw ((Throwable)new AssertionError());
          }
          removeAtImpl(j);
        }
        return bool;
      }
      finally {}
      label75:
      if (i == 0) {}
    }
  }
  
  @PublishedApi
  @NotNull
  public final T removeAtImpl(int paramInt)
  {
    boolean bool = DebugKt.getASSERTIONS_ENABLED();
    int j = 0;
    int i;
    if (bool)
    {
      if (getSize() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    ThreadSafeHeapNode[] arrayOfThreadSafeHeapNode = this.a;
    if (arrayOfThreadSafeHeapNode == null) {
      Intrinsics.throwNpe();
    }
    setSize(getSize() - 1);
    if (paramInt < getSize())
    {
      swap(paramInt, getSize());
      i = (paramInt - 1) / 2;
      if (paramInt > 0)
      {
        localObject = arrayOfThreadSafeHeapNode[paramInt];
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = (Comparable)localObject;
        ThreadSafeHeapNode localThreadSafeHeapNode = arrayOfThreadSafeHeapNode[i];
        if (localThreadSafeHeapNode == null) {
          Intrinsics.throwNpe();
        }
        if (((Comparable)localObject).compareTo(localThreadSafeHeapNode) < 0)
        {
          swap(paramInt, i);
          siftUpFrom(i);
          break label161;
        }
      }
      siftDownFrom(paramInt);
    }
    label161:
    Object localObject = arrayOfThreadSafeHeapNode[getSize()];
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      paramInt = j;
      if (((ThreadSafeHeapNode)localObject).getHeap() == (ThreadSafeHeap)this) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    ((ThreadSafeHeapNode)localObject).setHeap((ThreadSafeHeap)null);
    ((ThreadSafeHeapNode)localObject).setIndex(-1);
    arrayOfThreadSafeHeapNode[getSize()] = ((ThreadSafeHeapNode)null);
    return localObject;
  }
  
  @Nullable
  public final T removeFirstIf(@NotNull Function1<? super T, Boolean> paramFunction1)
  {
    try
    {
      ThreadSafeHeapNode localThreadSafeHeapNode2 = firstImpl();
      ThreadSafeHeapNode localThreadSafeHeapNode1 = null;
      if (localThreadSafeHeapNode2 != null)
      {
        if (((Boolean)paramFunction1.invoke(localThreadSafeHeapNode2)).booleanValue()) {
          localThreadSafeHeapNode1 = removeAtImpl(0);
        }
        return localThreadSafeHeapNode1;
      }
      InlineMarker.finallyStart(2);
      InlineMarker.finallyEnd(2);
      return null;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      InlineMarker.finallyEnd(1);
    }
  }
  
  @Nullable
  public final T removeFirstOrNull()
  {
    try
    {
      ThreadSafeHeapNode localThreadSafeHeapNode;
      if (getSize() > 0) {
        localThreadSafeHeapNode = removeAtImpl(0);
      } else {
        localThreadSafeHeapNode = null;
      }
      return localThreadSafeHeapNode;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ThreadSafeHeap
 * JD-Core Version:    0.7.0.1
 */