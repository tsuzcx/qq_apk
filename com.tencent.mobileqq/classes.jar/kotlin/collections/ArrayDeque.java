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
    if (paramInt == 0) {}
    for (Object[] arrayOfObject = ArrayDequeKt.access$getEmptyElementData$p();; arrayOfObject = new Object[paramInt])
    {
      this.elementData = arrayOfObject;
      return;
      if (paramInt <= 0) {
        break;
      }
    }
    throw ((Throwable)new IllegalArgumentException("Illegal Capacity: " + paramInt));
  }
  
  public ArrayDeque(@NotNull Collection<? extends E> paramCollection)
  {
    paramCollection = paramCollection.toArray(new Object[0]);
    if (paramCollection == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    this.elementData = paramCollection;
    this.size = this.elementData.length;
    if (this.elementData.length == 0) {
      i = 1;
    }
    if (i != 0) {
      this.elementData = ArrayDequeKt.access$getEmptyElementData$p();
    }
  }
  
  private final void copyCollectionElements(int paramInt, Collection<? extends E> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    int i = this.elementData.length;
    if ((paramInt >= i) || (!localIterator.hasNext()))
    {
      paramInt = 0;
      i = this.head;
    }
    for (;;)
    {
      if ((paramInt >= i) || (!localIterator.hasNext()))
      {
        this.size = (size() + paramCollection.size());
        return;
        this.elementData[paramInt] = localIterator.next();
        paramInt += 1;
        break;
      }
      this.elementData[paramInt] = localIterator.next();
      paramInt += 1;
    }
  }
  
  private final void copyElements(int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    ArraysKt.copyInto(this.elementData, arrayOfObject, 0, this.head, this.elementData.length);
    ArraysKt.copyInto(this.elementData, arrayOfObject, this.elementData.length - this.head, 0, this.head);
    this.head = 0;
    this.elementData = arrayOfObject;
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
    if (paramInt < 0) {
      throw ((Throwable)new IllegalStateException("Deque is too big."));
    }
    if (paramInt <= this.elementData.length) {
      return;
    }
    if (this.elementData == ArrayDequeKt.access$getEmptyElementData$p())
    {
      this.elementData = new Object[RangesKt.coerceAtLeast(paramInt, 10)];
      return;
    }
    copyElements(newCapacity$kotlin_stdlib(this.elementData.length, paramInt));
  }
  
  private final boolean filterInPlace(Function1<? super E, Boolean> paramFunction1)
  {
    int k = 0;
    if (!isEmpty()) {
      if (access$getElementData$p(this).length != 0) {
        break label30;
      }
    }
    boolean bool2;
    label30:
    for (int i = 1; i != 0; i = 0)
    {
      bool2 = false;
      return bool2;
    }
    int m = access$positiveMod(this, size() + access$getHead$p(this));
    i = access$getHead$p(this);
    int j;
    boolean bool1;
    Object localObject;
    if (access$getHead$p(this) < m)
    {
      j = access$getHead$p(this);
      bool1 = false;
      if (j < m)
      {
        localObject = access$getElementData$p(this)[j];
        if (((Boolean)paramFunction1.invoke(localObject)).booleanValue())
        {
          access$getElementData$p(this)[i] = localObject;
          i += 1;
        }
        for (;;)
        {
          j += 1;
          break;
          bool1 = true;
        }
      }
      ArraysKt.fill(access$getElementData$p(this), null, i, m);
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      access$setSize$p(this, access$negativeMod(this, i - access$getHead$p(this)));
      return bool1;
      j = access$getHead$p(this);
      int n = access$getElementData$p(this).length;
      bool1 = false;
      if (j < n)
      {
        localObject = access$getElementData$p(this)[j];
        access$getElementData$p(this)[j] = null;
        if (((Boolean)paramFunction1.invoke(localObject)).booleanValue())
        {
          access$getElementData$p(this)[i] = localObject;
          i += 1;
        }
        for (;;)
        {
          j += 1;
          break;
          bool1 = true;
        }
      }
      i = access$positiveMod(this, i);
      j = k;
      if (j < m)
      {
        localObject = access$getElementData$p(this)[j];
        access$getElementData$p(this)[j] = null;
        if (((Boolean)paramFunction1.invoke(localObject)).booleanValue())
        {
          access$getElementData$p(this)[i] = localObject;
          i = access$incremented(this, i);
        }
        for (;;)
        {
          j += 1;
          break;
          bool1 = true;
        }
      }
    }
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
    int i = paramInt;
    if (paramInt >= this.elementData.length) {
      i = paramInt - this.elementData.length;
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
    if (paramInt < size() + 1 >> 1)
    {
      paramInt = decremented(i);
      i = decremented(this.head);
      if (paramInt >= this.head)
      {
        this.elementData[i] = this.elementData[this.head];
        ArraysKt.copyInto(this.elementData, this.elementData, this.head, this.head + 1, paramInt + 1);
      }
      for (;;)
      {
        this.elementData[paramInt] = paramE;
        this.head = i;
        this.size = (size() + 1);
        return;
        ArraysKt.copyInto(this.elementData, this.elementData, this.head - 1, this.head, this.elementData.length);
        this.elementData[(this.elementData.length - 1)] = this.elementData[0];
        ArraysKt.copyInto(this.elementData, this.elementData, 0, 1, paramInt + 1);
      }
    }
    paramInt = access$positiveMod(this, size() + access$getHead$p(this));
    if (i < paramInt) {
      ArraysKt.copyInto(this.elementData, this.elementData, i + 1, i, paramInt);
    }
    for (;;)
    {
      this.elementData[i] = paramE;
      break;
      ArraysKt.copyInto(this.elementData, this.elementData, 1, 0, paramInt);
      this.elementData[0] = this.elementData[(this.elementData.length - 1)];
      ArraysKt.copyInto(this.elementData, this.elementData, i + 1, i, this.elementData.length - 1);
    }
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
    int k = access$positiveMod(this, size() + access$getHead$p(this));
    int i = access$positiveMod(this, access$getHead$p(this) + paramInt);
    int j = paramCollection.size();
    if (paramInt < size() + 1 >> 1)
    {
      paramInt = this.head - j;
      if (i >= this.head) {
        if (paramInt >= 0) {
          ArraysKt.copyInto(this.elementData, this.elementData, paramInt, this.head, i);
        }
      }
      for (;;)
      {
        this.head = paramInt;
        copyCollectionElements(negativeMod(i - j), paramCollection);
        return true;
        paramInt += this.elementData.length;
        k = this.head;
        int m = this.elementData.length - paramInt;
        if (m >= i - k)
        {
          ArraysKt.copyInto(this.elementData, this.elementData, paramInt, this.head, i);
        }
        else
        {
          ArraysKt.copyInto(this.elementData, this.elementData, paramInt, this.head, this.head + m);
          ArraysKt.copyInto(this.elementData, this.elementData, 0, m + this.head, i);
          continue;
          ArraysKt.copyInto(this.elementData, this.elementData, paramInt, this.head, this.elementData.length);
          if (j >= i)
          {
            ArraysKt.copyInto(this.elementData, this.elementData, this.elementData.length - j, 0, i);
          }
          else
          {
            ArraysKt.copyInto(this.elementData, this.elementData, this.elementData.length - j, 0, j);
            ArraysKt.copyInto(this.elementData, this.elementData, 0, j, i);
          }
        }
      }
    }
    paramInt = i + j;
    if (i < k) {
      if (k + j <= this.elementData.length) {
        ArraysKt.copyInto(this.elementData, this.elementData, paramInt, i, k);
      }
    }
    for (;;)
    {
      copyCollectionElements(i, paramCollection);
      break;
      if (paramInt >= this.elementData.length)
      {
        ArraysKt.copyInto(this.elementData, this.elementData, paramInt - this.elementData.length, i, k);
      }
      else
      {
        j = j + k - this.elementData.length;
        ArraysKt.copyInto(this.elementData, this.elementData, 0, k - j, k);
        ArraysKt.copyInto(this.elementData, this.elementData, paramInt, i, k - j);
        continue;
        ArraysKt.copyInto(this.elementData, this.elementData, j, 0, k);
        if (paramInt >= this.elementData.length)
        {
          ArraysKt.copyInto(this.elementData, this.elementData, paramInt - this.elementData.length, i, this.elementData.length);
        }
        else
        {
          ArraysKt.copyInto(this.elementData, this.elementData, 0, this.elementData.length - j, this.elementData.length);
          ArraysKt.copyInto(this.elementData, this.elementData, paramInt, i, this.elementData.length - j);
        }
      }
    }
  }
  
  public boolean addAll(@NotNull Collection<? extends E> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    if (paramCollection.isEmpty()) {
      return false;
    }
    ensureCapacity(size() + paramCollection.size());
    copyCollectionElements(access$positiveMod(this, size() + access$getHead$p(this)), paramCollection);
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
    this.elementData[access$positiveMod(this, size() + access$getHead$p(this))] = paramE;
    this.size = (size() + 1);
  }
  
  public void clear()
  {
    int j = access$positiveMod(this, size() + access$getHead$p(this));
    if (this.head < j) {
      ArraysKt.fill(this.elementData, null, this.head, j);
    }
    label94:
    for (;;)
    {
      this.head = 0;
      this.size = 0;
      return;
      if (!isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label94;
        }
        ArraysKt.fill(this.elementData, null, this.head, this.elementData.length);
        ArraysKt.fill(this.elementData, null, 0, j);
        break;
      }
    }
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) != -1;
  }
  
  public final E first()
  {
    if (isEmpty()) {
      throw ((Throwable)new NoSuchElementException("ArrayDeque is empty."));
    }
    int i = this.head;
    return access$getElementData$p(this)[i];
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
    int j = access$positiveMod(this, size() + access$getHead$p(this));
    int i;
    if (this.head < j)
    {
      i = this.head;
      while (i < j)
      {
        if (Intrinsics.areEqual(paramObject, this.elementData[i])) {
          return i - this.head;
        }
        i += 1;
      }
    }
    if (this.head >= j)
    {
      i = this.head;
      int k = this.elementData.length;
      while (i < k)
      {
        if (Intrinsics.areEqual(paramObject, this.elementData[i])) {
          return i - this.head;
        }
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        if (Intrinsics.areEqual(paramObject, this.elementData[i])) {
          return i + this.elementData.length - this.head;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public final void internalStructure$kotlin_stdlib(@NotNull Function2<? super Integer, ? super Object[], Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "structure");
    int i = access$positiveMod(this, size() + access$getHead$p(this));
    if (isEmpty())
    {
      paramFunction2.invoke(Integer.valueOf(this.head), new Object[0]);
      return;
    }
    Object[] arrayOfObject = new Object[size()];
    if (this.head < i)
    {
      ArraysKt.copyInto$default(this.elementData, arrayOfObject, 0, this.head, i, 2, null);
      paramFunction2.invoke(Integer.valueOf(this.head), arrayOfObject);
      return;
    }
    ArraysKt.copyInto$default(this.elementData, arrayOfObject, 0, this.head, 0, 10, null);
    ArraysKt.copyInto(this.elementData, arrayOfObject, this.elementData.length - this.head, 0, i);
    paramFunction2.invoke(Integer.valueOf(this.head - this.elementData.length), arrayOfObject);
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public final E last()
  {
    if (isEmpty()) {
      throw ((Throwable)new NoSuchElementException("ArrayDeque is empty."));
    }
    int i = access$positiveMod(this, CollectionsKt.getLastIndex(this) + access$getHead$p(this));
    return access$getElementData$p(this)[i];
  }
  
  public int lastIndexOf(Object paramObject)
  {
    int i = access$positiveMod(this, size() + access$getHead$p(this));
    int j;
    if (this.head < i)
    {
      i -= 1;
      j = this.head;
      if (i >= j) {
        for (;;)
        {
          if (Intrinsics.areEqual(paramObject, this.elementData[i])) {
            return i - this.head;
          }
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
    }
    else if (this.head > i)
    {
      i -= 1;
      while (i >= 0)
      {
        if (Intrinsics.areEqual(paramObject, this.elementData[i])) {
          return i + this.elementData.length - this.head;
        }
        i -= 1;
      }
      i = ArraysKt.getLastIndex(this.elementData);
      j = this.head;
      if (i >= j) {
        for (;;)
        {
          if (Intrinsics.areEqual(paramObject, this.elementData[i])) {
            return i - this.head;
          }
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
    }
    return -1;
  }
  
  @Nullable
  public final E lastOrNull()
  {
    if (isEmpty()) {
      return null;
    }
    int i = access$positiveMod(this, CollectionsKt.getLastIndex(this) + access$getHead$p(this));
    return access$getElementData$p(this)[i];
  }
  
  public final int newCapacity$kotlin_stdlib(int paramInt1, int paramInt2)
  {
    int i = 2147483639;
    int j = (paramInt1 >> 1) + paramInt1;
    paramInt1 = j;
    if (j - paramInt2 < 0) {
      paramInt1 = paramInt2;
    }
    if (paramInt1 - 2147483639 > 0)
    {
      paramInt1 = i;
      if (paramInt2 > 2147483639) {
        paramInt1 = 2147483647;
      }
      return paramInt1;
    }
    return paramInt1;
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
    if (!isEmpty()) {
      if (access$getElementData$p(this).length != 0) {
        break label33;
      }
    }
    boolean bool2;
    label33:
    for (int i = 1; i != 0; i = 0)
    {
      bool2 = false;
      return bool2;
    }
    int m = access$positiveMod(this, size() + access$getHead$p(this));
    i = access$getHead$p(this);
    int j;
    boolean bool1;
    Object localObject;
    int k;
    label103:
    Object[] arrayOfObject;
    if (access$getHead$p(this) < m)
    {
      j = access$getHead$p(this);
      bool1 = false;
      if (j < m)
      {
        localObject = access$getElementData$p(this)[j];
        if (!paramCollection.contains(localObject))
        {
          k = 1;
          if (k == 0) {
            break label141;
          }
          arrayOfObject = access$getElementData$p(this);
          k = i + 1;
          arrayOfObject[i] = localObject;
          i = k;
        }
        for (;;)
        {
          j += 1;
          break;
          k = 0;
          break label103;
          label141:
          bool1 = true;
        }
      }
      ArraysKt.fill(access$getElementData$p(this), null, i, m);
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      access$setSize$p(this, access$negativeMod(this, i - access$getHead$p(this)));
      return bool1;
      j = access$getHead$p(this);
      int n = access$getElementData$p(this).length;
      bool1 = false;
      if (j < n)
      {
        localObject = access$getElementData$p(this)[j];
        access$getElementData$p(this)[j] = null;
        if (!paramCollection.contains(localObject))
        {
          k = 1;
          label234:
          if (k == 0) {
            break label272;
          }
          arrayOfObject = access$getElementData$p(this);
          k = i + 1;
          arrayOfObject[i] = localObject;
          i = k;
        }
        for (;;)
        {
          j += 1;
          break;
          k = 0;
          break label234;
          label272:
          bool1 = true;
        }
      }
      i = access$positiveMod(this, i);
      j = 0;
      if (j < m)
      {
        localObject = access$getElementData$p(this)[j];
        access$getElementData$p(this)[j] = null;
        if (!paramCollection.contains(localObject))
        {
          k = 1;
          label321:
          if (k == 0) {
            break label353;
          }
          access$getElementData$p(this)[i] = localObject;
          i = access$incremented(this, i);
        }
        for (;;)
        {
          j += 1;
          break;
          k = 0;
          break label321;
          label353:
          bool1 = true;
        }
      }
    }
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
    if (paramInt < size() >> 1)
    {
      if (i >= this.head) {
        ArraysKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, i);
      }
      for (;;)
      {
        this.elementData[this.head] = null;
        this.head = incremented(this.head);
        this.size = (size() - 1);
        return localObject;
        ArraysKt.copyInto(this.elementData, this.elementData, 1, 0, i);
        this.elementData[0] = this.elementData[(this.elementData.length - 1)];
        ArraysKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, this.elementData.length - 1);
      }
    }
    paramInt = access$positiveMod(this, CollectionsKt.getLastIndex(this) + access$getHead$p(this));
    if (i <= paramInt) {
      ArraysKt.copyInto(this.elementData, this.elementData, i, i + 1, paramInt + 1);
    }
    for (;;)
    {
      this.elementData[paramInt] = null;
      break;
      ArraysKt.copyInto(this.elementData, this.elementData, i, i + 1, this.elementData.length);
      this.elementData[(this.elementData.length - 1)] = this.elementData[0];
      ArraysKt.copyInto(this.elementData, this.elementData, 0, 1, paramInt + 1);
    }
  }
  
  public final E removeFirst()
  {
    if (isEmpty()) {
      throw ((Throwable)new NoSuchElementException("ArrayDeque is empty."));
    }
    int i = this.head;
    Object localObject = access$getElementData$p(this)[i];
    this.elementData[this.head] = null;
    this.head = incremented(this.head);
    this.size = (size() - 1);
    return localObject;
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
    if (isEmpty()) {
      throw ((Throwable)new NoSuchElementException("ArrayDeque is empty."));
    }
    int i = access$positiveMod(this, CollectionsKt.getLastIndex(this) + access$getHead$p(this));
    Object localObject = access$getElementData$p(this)[i];
    this.elementData[i] = null;
    this.size = (size() - 1);
    return localObject;
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
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    if (!isEmpty()) {
      if (access$getElementData$p(this).length != 0) {
        break label36;
      }
    }
    boolean bool2;
    label36:
    for (int i = 1; i != 0; i = 0)
    {
      bool2 = false;
      return bool2;
    }
    int n = access$positiveMod(this, size() + access$getHead$p(this));
    i = access$getHead$p(this);
    int j;
    boolean bool1;
    Object localObject;
    Object[] arrayOfObject;
    if (access$getHead$p(this) < n)
    {
      j = access$getHead$p(this);
      bool1 = false;
      if (j < n)
      {
        localObject = access$getElementData$p(this)[j];
        if (paramCollection.contains(localObject))
        {
          arrayOfObject = access$getElementData$p(this);
          k = i + 1;
          arrayOfObject[i] = localObject;
          i = k;
        }
        for (;;)
        {
          j += 1;
          break;
          bool1 = true;
        }
      }
      ArraysKt.fill(access$getElementData$p(this), null, i, n);
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      access$setSize$p(this, access$negativeMod(this, i - access$getHead$p(this)));
      return bool1;
      j = access$getHead$p(this);
      int i1 = access$getElementData$p(this).length;
      bool1 = false;
      if (j < i1)
      {
        localObject = access$getElementData$p(this)[j];
        access$getElementData$p(this)[j] = null;
        if (paramCollection.contains(localObject))
        {
          arrayOfObject = access$getElementData$p(this);
          int m = i + 1;
          arrayOfObject[i] = localObject;
          i = m;
        }
        for (;;)
        {
          j += 1;
          break;
          bool1 = true;
        }
      }
      i = access$positiveMod(this, i);
      j = k;
      if (j < n)
      {
        localObject = access$getElementData$p(this)[j];
        access$getElementData$p(this)[j] = null;
        if (paramCollection.contains(localObject))
        {
          access$getElementData$p(this)[i] = localObject;
          i = access$incremented(this, i);
        }
        for (;;)
        {
          j += 1;
          break;
          bool1 = true;
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.ArrayDeque
 * JD-Core Version:    0.7.0.1
 */