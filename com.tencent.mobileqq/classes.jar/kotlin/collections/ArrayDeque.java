package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "oldCapacity", "newCapacity$kotlin_stdlib", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalStdlibApi
@SinceKotlin(version="1.3")
public final class ArrayDeque<E>
  extends AbstractMutableList<E>
{
  private Object[] elementData;
  private int head;
  private int size;
  
  public ArrayDeque()
  {
    this.elementData = ArrayDequeKt.access$getEmptyElementData$p();
  }
  
  public ArrayDeque(int paramInt)
  {
    if (paramInt == 0)
    {
      localObject = ArrayDequeKt.access$getEmptyElementData$p();
    }
    else
    {
      if (paramInt <= 0) {
        break label30;
      }
      localObject = new Object[paramInt];
    }
    this.elementData = ((Object[])localObject);
    return;
    label30:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Illegal Capacity: ");
    ((StringBuilder)localObject).append(paramInt);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
  }
  
  public ArrayDeque(@NotNull Collection<? extends E> paramCollection)
  {
    int i = 0;
    paramCollection = paramCollection.toArray(new Object[0]);
    if (paramCollection != null)
    {
      this.elementData = paramCollection;
      paramCollection = this.elementData;
      this.size = paramCollection.length;
      if (paramCollection.length == 0) {
        i = 1;
      }
      if (i != 0) {
        this.elementData = ArrayDequeKt.access$getEmptyElementData$p();
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  private final void copyCollectionElements(int paramInt, Collection<? extends E> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    int i = this.elementData.length;
    while ((paramInt < i) && (localIterator.hasNext()))
    {
      this.elementData[paramInt] = localIterator.next();
      paramInt += 1;
    }
    paramInt = 0;
    i = this.head;
    while ((paramInt < i) && (localIterator.hasNext()))
    {
      this.elementData[paramInt] = localIterator.next();
      paramInt += 1;
    }
    this.size = (size() + paramCollection.size());
  }
  
  private final void copyElements(int paramInt)
  {
    Object[] arrayOfObject1 = new Object[paramInt];
    Object[] arrayOfObject2 = this.elementData;
    ArraysKt.copyInto(arrayOfObject2, arrayOfObject1, 0, this.head, arrayOfObject2.length);
    arrayOfObject2 = this.elementData;
    paramInt = arrayOfObject2.length;
    int i = this.head;
    ArraysKt.copyInto(arrayOfObject2, arrayOfObject1, paramInt - i, 0, i);
    this.head = 0;
    this.elementData = arrayOfObject1;
  }
  
  private final int decremented(int paramInt)
  {
    if (paramInt == 0) {
      return ArraysKt.getLastIndex(this.elementData);
    }
    return paramInt - 1;
  }
  
  private final void ensureCapacity(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object[] arrayOfObject = this.elementData;
      if (paramInt <= arrayOfObject.length) {
        return;
      }
      if (arrayOfObject == ArrayDequeKt.access$getEmptyElementData$p())
      {
        this.elementData = new Object[RangesKt.coerceAtLeast(paramInt, 10)];
        return;
      }
      copyElements(newCapacity$kotlin_stdlib(this.elementData.length, paramInt));
      return;
    }
    throw ((Throwable)new IllegalStateException("Deque is too big."));
  }
  
  private final boolean filterInPlace(Function1<? super E, Boolean> paramFunction1)
  {
    boolean bool3 = isEmpty();
    int k = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool3)
    {
      if (access$getElementData$p(this).length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
      int i = size();
      int m = access$positiveMod(this, access$getHead$p(this) + i);
      i = access$getHead$p(this);
      int j;
      Object localObject;
      if (access$getHead$p(this) < m)
      {
        j = access$getHead$p(this);
        while (j < m)
        {
          localObject = access$getElementData$p(this)[j];
          if (((Boolean)paramFunction1.invoke(localObject)).booleanValue())
          {
            access$getElementData$p(this)[i] = localObject;
            i += 1;
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
        ArraysKt.fill(access$getElementData$p(this), null, i, m);
      }
      else
      {
        j = access$getHead$p(this);
        int n = access$getElementData$p(this).length;
        bool1 = false;
        while (j < n)
        {
          localObject = access$getElementData$p(this)[j];
          access$getElementData$p(this)[j] = null;
          if (((Boolean)paramFunction1.invoke(localObject)).booleanValue())
          {
            access$getElementData$p(this)[i] = localObject;
            i += 1;
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
        i = access$positiveMod(this, i);
        j = k;
        while (j < m)
        {
          localObject = access$getElementData$p(this)[j];
          access$getElementData$p(this)[j] = null;
          if (((Boolean)paramFunction1.invoke(localObject)).booleanValue())
          {
            access$getElementData$p(this)[i] = localObject;
            i = access$incremented(this, i);
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        access$setSize$p(this, access$negativeMod(this, i - access$getHead$p(this)));
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  private final int incremented(int paramInt)
  {
    if (paramInt == ArraysKt.getLastIndex(this.elementData)) {
      return 0;
    }
    return paramInt + 1;
  }
  
  @InlineOnly
  private final E internalGet(int paramInt)
  {
    return access$getElementData$p(this)[paramInt];
  }
  
  @InlineOnly
  private final int internalIndex(int paramInt)
  {
    return access$positiveMod(this, access$getHead$p(this) + paramInt);
  }
  
  private final int negativeMod(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + this.elementData.length;
    }
    return i;
  }
  
  private final int positiveMod(int paramInt)
  {
    Object[] arrayOfObject = this.elementData;
    int i = paramInt;
    if (paramInt >= arrayOfObject.length) {
      i = paramInt - arrayOfObject.length;
    }
    return i;
  }
  
  public void add(int paramInt, E paramE)
  {
    AbstractList.Companion.checkPositionIndex$kotlin_stdlib(paramInt, size());
    if (paramInt == size())
    {
      addLast(paramE);
      return;
    }
    if (paramInt == 0)
    {
      addFirst(paramE);
      return;
    }
    ensureCapacity(size() + 1);
    int i = access$positiveMod(this, access$getHead$p(this) + paramInt);
    Object[] arrayOfObject;
    if (paramInt < size() + 1 >> 1)
    {
      paramInt = decremented(i);
      i = decremented(this.head);
      int j = this.head;
      if (paramInt >= j)
      {
        arrayOfObject = this.elementData;
        arrayOfObject[i] = arrayOfObject[j];
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, j, j + 1, paramInt + 1);
      }
      else
      {
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, j - 1, j, arrayOfObject.length);
        arrayOfObject = this.elementData;
        arrayOfObject[(arrayOfObject.length - 1)] = arrayOfObject[0];
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, 0, 1, paramInt + 1);
      }
      this.elementData[paramInt] = paramE;
      this.head = i;
    }
    else
    {
      paramInt = size();
      paramInt = access$positiveMod(this, access$getHead$p(this) + paramInt);
      if (i < paramInt)
      {
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, i + 1, i, paramInt);
      }
      else
      {
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, 1, 0, paramInt);
        arrayOfObject = this.elementData;
        arrayOfObject[0] = arrayOfObject[(arrayOfObject.length - 1)];
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, i + 1, i, arrayOfObject.length - 1);
      }
      this.elementData[i] = paramE;
    }
    this.size = (size() + 1);
  }
  
  public boolean add(E paramE)
  {
    addLast(paramE);
    return true;
  }
  
  public boolean addAll(int paramInt, @NotNull Collection<? extends E> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    AbstractList.Companion.checkPositionIndex$kotlin_stdlib(paramInt, size());
    if (paramCollection.isEmpty()) {
      return false;
    }
    if (paramInt == size()) {
      return addAll(paramCollection);
    }
    ensureCapacity(size() + paramCollection.size());
    int i = size();
    int k = access$positiveMod(this, access$getHead$p(this) + i);
    i = access$positiveMod(this, access$getHead$p(this) + paramInt);
    int j = paramCollection.size();
    Object[] arrayOfObject;
    if (paramInt < size() + 1 >> 1)
    {
      k = this.head;
      paramInt = k - j;
      if (i >= k)
      {
        if (paramInt >= 0)
        {
          arrayOfObject = this.elementData;
          ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt, k, i);
        }
        else
        {
          arrayOfObject = this.elementData;
          paramInt += arrayOfObject.length;
          int m = arrayOfObject.length - paramInt;
          if (m >= i - k)
          {
            ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt, k, i);
          }
          else
          {
            ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt, k, k + m);
            arrayOfObject = this.elementData;
            ArraysKt.copyInto(arrayOfObject, arrayOfObject, 0, this.head + m, i);
          }
        }
      }
      else
      {
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt, k, arrayOfObject.length);
        if (j >= i)
        {
          arrayOfObject = this.elementData;
          ArraysKt.copyInto(arrayOfObject, arrayOfObject, arrayOfObject.length - j, 0, i);
        }
        else
        {
          arrayOfObject = this.elementData;
          ArraysKt.copyInto(arrayOfObject, arrayOfObject, arrayOfObject.length - j, 0, j);
          arrayOfObject = this.elementData;
          ArraysKt.copyInto(arrayOfObject, arrayOfObject, 0, j, i);
        }
      }
      this.head = paramInt;
      copyCollectionElements(negativeMod(i - j), paramCollection);
      return true;
    }
    paramInt = i + j;
    if (i < k)
    {
      j += k;
      arrayOfObject = this.elementData;
      if (j <= arrayOfObject.length)
      {
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt, i, k);
      }
      else if (paramInt >= arrayOfObject.length)
      {
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt - arrayOfObject.length, i, k);
      }
      else
      {
        j = k - (j - arrayOfObject.length);
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, 0, j, k);
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt, i, j);
      }
    }
    else
    {
      arrayOfObject = this.elementData;
      ArraysKt.copyInto(arrayOfObject, arrayOfObject, j, 0, k);
      arrayOfObject = this.elementData;
      if (paramInt >= arrayOfObject.length)
      {
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt - arrayOfObject.length, i, arrayOfObject.length);
      }
      else
      {
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, 0, arrayOfObject.length - j, arrayOfObject.length);
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt, i, arrayOfObject.length - j);
      }
    }
    copyCollectionElements(i, paramCollection);
    return true;
  }
  
  public boolean addAll(@NotNull Collection<? extends E> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    if (paramCollection.isEmpty()) {
      return false;
    }
    ensureCapacity(size() + paramCollection.size());
    int i = size();
    copyCollectionElements(access$positiveMod(this, access$getHead$p(this) + i), paramCollection);
    return true;
  }
  
  public final void addFirst(E paramE)
  {
    ensureCapacity(size() + 1);
    this.head = decremented(this.head);
    this.elementData[this.head] = paramE;
    this.size = (size() + 1);
  }
  
  public final void addLast(E paramE)
  {
    ensureCapacity(size() + 1);
    Object[] arrayOfObject = this.elementData;
    int i = size();
    arrayOfObject[access$positiveMod(this, access$getHead$p(this) + i)] = paramE;
    this.size = (size() + 1);
  }
  
  public void clear()
  {
    int i = size();
    i = access$positiveMod(this, access$getHead$p(this) + i);
    int j = this.head;
    if (j < i)
    {
      ArraysKt.fill(this.elementData, null, j, i);
    }
    else if ((isEmpty() ^ true))
    {
      Object[] arrayOfObject = this.elementData;
      ArraysKt.fill(arrayOfObject, null, this.head, arrayOfObject.length);
      ArraysKt.fill(this.elementData, null, 0, i);
    }
    this.head = 0;
    this.size = 0;
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) != -1;
  }
  
  public final E first()
  {
    if (!isEmpty())
    {
      int i = this.head;
      return access$getElementData$p(this)[i];
    }
    throw ((Throwable)new NoSuchElementException("ArrayDeque is empty."));
  }
  
  @Nullable
  public final E firstOrNull()
  {
    if (isEmpty()) {
      return null;
    }
    int i = this.head;
    return access$getElementData$p(this)[i];
  }
  
  public E get(int paramInt)
  {
    AbstractList.Companion.checkElementIndex$kotlin_stdlib(paramInt, size());
    paramInt = access$positiveMod(this, access$getHead$p(this) + paramInt);
    return access$getElementData$p(this)[paramInt];
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int indexOf(Object paramObject)
  {
    int i = size();
    int j = access$positiveMod(this, access$getHead$p(this) + i);
    i = this.head;
    if (i < j) {
      while (i < j)
      {
        if (Intrinsics.areEqual(paramObject, this.elementData[i]))
        {
          j = this.head;
          return i - j;
        }
        i += 1;
      }
    }
    if (i >= j)
    {
      int k = this.elementData.length;
      for (;;)
      {
        if (i >= k) {
          break label106;
        }
        if (Intrinsics.areEqual(paramObject, this.elementData[i]))
        {
          j = this.head;
          break;
        }
        i += 1;
      }
      label106:
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label149;
        }
        if (Intrinsics.areEqual(paramObject, this.elementData[i]))
        {
          i += this.elementData.length;
          j = this.head;
          break;
        }
        i += 1;
      }
    }
    label149:
    return -1;
  }
  
  public final void internalStructure$kotlin_stdlib(@NotNull Function2<? super Integer, ? super Object[], Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "structure");
    int i = size();
    i = access$positiveMod(this, access$getHead$p(this) + i);
    if (isEmpty())
    {
      paramFunction2.invoke(Integer.valueOf(this.head), new Object[0]);
      return;
    }
    Object[] arrayOfObject1 = new Object[size()];
    int j = this.head;
    if (j < i)
    {
      ArraysKt.copyInto$default(this.elementData, arrayOfObject1, 0, j, i, 2, null);
      paramFunction2.invoke(Integer.valueOf(this.head), arrayOfObject1);
      return;
    }
    ArraysKt.copyInto$default(this.elementData, arrayOfObject1, 0, j, 0, 10, null);
    Object[] arrayOfObject2 = this.elementData;
    ArraysKt.copyInto(arrayOfObject2, arrayOfObject1, arrayOfObject2.length - this.head, 0, i);
    paramFunction2.invoke(Integer.valueOf(this.head - this.elementData.length), arrayOfObject1);
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public final E last()
  {
    if (!isEmpty())
    {
      int i = CollectionsKt.getLastIndex(this);
      i = access$positiveMod(this, access$getHead$p(this) + i);
      return access$getElementData$p(this)[i];
    }
    throw ((Throwable)new NoSuchElementException("ArrayDeque is empty."));
  }
  
  public int lastIndexOf(Object paramObject)
  {
    int i = size();
    i = access$positiveMod(this, access$getHead$p(this) + i);
    int j = this.head;
    if (j < i)
    {
      i -= 1;
      if (i >= j) {
        for (;;)
        {
          if (Intrinsics.areEqual(paramObject, this.elementData[i]))
          {
            j = this.head;
            return i - j;
          }
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
    }
    else if (j > i)
    {
      i -= 1;
      for (;;)
      {
        if (i < 0) {
          break label118;
        }
        if (Intrinsics.areEqual(paramObject, this.elementData[i]))
        {
          i += this.elementData.length;
          j = this.head;
          break;
        }
        i -= 1;
      }
      label118:
      i = ArraysKt.getLastIndex(this.elementData);
      j = this.head;
      if (i >= j) {
        for (;;)
        {
          if (Intrinsics.areEqual(paramObject, this.elementData[i]))
          {
            j = this.head;
            break;
          }
          if (i == j) {
            break label169;
          }
          i -= 1;
        }
      }
    }
    label169:
    return -1;
  }
  
  @Nullable
  public final E lastOrNull()
  {
    if (isEmpty()) {
      return null;
    }
    int i = CollectionsKt.getLastIndex(this);
    i = access$positiveMod(this, access$getHead$p(this) + i);
    return access$getElementData$p(this)[i];
  }
  
  public final int newCapacity$kotlin_stdlib(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + (paramInt1 >> 1);
    paramInt1 = i;
    if (i - paramInt2 < 0) {
      paramInt1 = paramInt2;
    }
    i = paramInt1;
    if (paramInt1 - 2147483639 > 0)
    {
      if (paramInt2 > 2147483639) {
        return 2147483647;
      }
      i = 2147483639;
    }
    return i;
  }
  
  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i == -1) {
      return false;
    }
    remove(i);
    return true;
  }
  
  public boolean removeAll(@NotNull Collection<? extends Object> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    boolean bool3 = isEmpty();
    int k = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool3)
    {
      if (access$getElementData$p(this).length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
      int i = size();
      int m = access$positiveMod(this, access$getHead$p(this) + i);
      i = access$getHead$p(this);
      int j;
      Object localObject;
      if (access$getHead$p(this) < m)
      {
        j = access$getHead$p(this);
        while (j < m)
        {
          localObject = access$getElementData$p(this)[j];
          if ((paramCollection.contains(localObject) ^ true))
          {
            access$getElementData$p(this)[i] = localObject;
            i += 1;
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
        ArraysKt.fill(access$getElementData$p(this), null, i, m);
      }
      else
      {
        j = access$getHead$p(this);
        int n = access$getElementData$p(this).length;
        bool1 = false;
        while (j < n)
        {
          localObject = access$getElementData$p(this)[j];
          access$getElementData$p(this)[j] = null;
          if ((paramCollection.contains(localObject) ^ true))
          {
            access$getElementData$p(this)[i] = localObject;
            i += 1;
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
        i = access$positiveMod(this, i);
        j = k;
        while (j < m)
        {
          localObject = access$getElementData$p(this)[j];
          access$getElementData$p(this)[j] = null;
          if ((paramCollection.contains(localObject) ^ true))
          {
            access$getElementData$p(this)[i] = localObject;
            i = access$incremented(this, i);
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        access$setSize$p(this, access$negativeMod(this, i - access$getHead$p(this)));
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public E removeAt(int paramInt)
  {
    AbstractList.Companion.checkElementIndex$kotlin_stdlib(paramInt, size());
    if (paramInt == CollectionsKt.getLastIndex(this)) {
      return removeLast();
    }
    if (paramInt == 0) {
      return removeFirst();
    }
    int i = access$positiveMod(this, access$getHead$p(this) + paramInt);
    Object localObject = access$getElementData$p(this)[i];
    Object[] arrayOfObject;
    if (paramInt < size() >> 1)
    {
      paramInt = this.head;
      if (i >= paramInt)
      {
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt + 1, paramInt, i);
      }
      else
      {
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, 1, 0, i);
        arrayOfObject = this.elementData;
        arrayOfObject[0] = arrayOfObject[(arrayOfObject.length - 1)];
        paramInt = this.head;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, paramInt + 1, paramInt, arrayOfObject.length - 1);
      }
      arrayOfObject = this.elementData;
      paramInt = this.head;
      arrayOfObject[paramInt] = null;
      this.head = incremented(paramInt);
    }
    else
    {
      paramInt = CollectionsKt.getLastIndex(this);
      paramInt = access$positiveMod(this, access$getHead$p(this) + paramInt);
      if (i <= paramInt)
      {
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, i, i + 1, paramInt + 1);
      }
      else
      {
        arrayOfObject = this.elementData;
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, i, i + 1, arrayOfObject.length);
        arrayOfObject = this.elementData;
        arrayOfObject[(arrayOfObject.length - 1)] = arrayOfObject[0];
        ArraysKt.copyInto(arrayOfObject, arrayOfObject, 0, 1, paramInt + 1);
      }
      this.elementData[paramInt] = null;
    }
    this.size = (size() - 1);
    return localObject;
  }
  
  public final E removeFirst()
  {
    if (!isEmpty())
    {
      int i = this.head;
      Object localObject = access$getElementData$p(this)[i];
      Object[] arrayOfObject = this.elementData;
      i = this.head;
      arrayOfObject[i] = null;
      this.head = incremented(i);
      this.size = (size() - 1);
      return localObject;
    }
    throw ((Throwable)new NoSuchElementException("ArrayDeque is empty."));
  }
  
  @Nullable
  public final E removeFirstOrNull()
  {
    if (isEmpty()) {
      return null;
    }
    return removeFirst();
  }
  
  public final E removeLast()
  {
    if (!isEmpty())
    {
      int i = CollectionsKt.getLastIndex(this);
      i = access$positiveMod(this, access$getHead$p(this) + i);
      Object localObject = access$getElementData$p(this)[i];
      this.elementData[i] = null;
      this.size = (size() - 1);
      return localObject;
    }
    throw ((Throwable)new NoSuchElementException("ArrayDeque is empty."));
  }
  
  @Nullable
  public final E removeLastOrNull()
  {
    if (isEmpty()) {
      return null;
    }
    return removeLast();
  }
  
  public boolean retainAll(@NotNull Collection<? extends Object> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    boolean bool3 = isEmpty();
    int k = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool3)
    {
      if (access$getElementData$p(this).length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
      int i = size();
      int m = access$positiveMod(this, access$getHead$p(this) + i);
      i = access$getHead$p(this);
      int j;
      Object localObject;
      if (access$getHead$p(this) < m)
      {
        j = access$getHead$p(this);
        while (j < m)
        {
          localObject = access$getElementData$p(this)[j];
          if (paramCollection.contains(localObject))
          {
            access$getElementData$p(this)[i] = localObject;
            i += 1;
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
        ArraysKt.fill(access$getElementData$p(this), null, i, m);
      }
      else
      {
        j = access$getHead$p(this);
        int n = access$getElementData$p(this).length;
        bool1 = false;
        while (j < n)
        {
          localObject = access$getElementData$p(this)[j];
          access$getElementData$p(this)[j] = null;
          if (paramCollection.contains(localObject))
          {
            access$getElementData$p(this)[i] = localObject;
            i += 1;
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
        i = access$positiveMod(this, i);
        j = k;
        while (j < m)
        {
          localObject = access$getElementData$p(this)[j];
          access$getElementData$p(this)[j] = null;
          if (paramCollection.contains(localObject))
          {
            access$getElementData$p(this)[i] = localObject;
            i = access$incremented(this, i);
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        access$setSize$p(this, access$negativeMod(this, i - access$getHead$p(this)));
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public E set(int paramInt, E paramE)
  {
    AbstractList.Companion.checkElementIndex$kotlin_stdlib(paramInt, size());
    paramInt = access$positiveMod(this, access$getHead$p(this) + paramInt);
    Object localObject = access$getElementData$p(this)[paramInt];
    this.elementData[paramInt] = paramE;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.ArrayDeque
 * JD-Core Version:    0.7.0.1
 */