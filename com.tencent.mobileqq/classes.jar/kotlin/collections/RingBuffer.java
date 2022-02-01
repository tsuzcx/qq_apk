package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class RingBuffer<T>
  extends AbstractList<T>
  implements RandomAccess
{
  private final Object[] buffer;
  private final int capacity;
  private int size;
  private int startIndex;
  
  public RingBuffer(int paramInt)
  {
    this(new Object[paramInt], 0);
  }
  
  public RingBuffer(@NotNull Object[] paramArrayOfObject, int paramInt)
  {
    this.buffer = paramArrayOfObject;
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + paramInt).toString()));
    }
    if (paramInt <= this.buffer.length) {}
    for (i = j; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("ring buffer filled size: " + paramInt + " cannot be larger than the buffer size: " + this.buffer.length).toString()));
    }
    this.capacity = this.buffer.length;
    this.size = paramInt;
  }
  
  private final int forward(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2) % access$getCapacity$p(this);
  }
  
  public final void add(T paramT)
  {
    if (isFull()) {
      throw ((Throwable)new IllegalStateException("ring buffer is full"));
    }
    this.buffer[((this.startIndex + size()) % access$getCapacity$p(this))] = paramT;
    this.size = (size() + 1);
  }
  
  @NotNull
  public final RingBuffer<T> expanded(int paramInt)
  {
    paramInt = RangesKt.coerceAtMost(this.capacity + (this.capacity >> 1) + 1, paramInt);
    Object[] arrayOfObject;
    if (this.startIndex == 0)
    {
      arrayOfObject = Arrays.copyOf(this.buffer, paramInt);
      Intrinsics.checkExpressionValueIsNotNull(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
    }
    for (;;)
    {
      return new RingBuffer(arrayOfObject, size());
      arrayOfObject = toArray(new Object[paramInt]);
    }
  }
  
  public T get(int paramInt)
  {
    AbstractList.Companion.checkElementIndex$kotlin_stdlib(paramInt, size());
    return this.buffer[((this.startIndex + paramInt) % access$getCapacity$p(this))];
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public final boolean isFull()
  {
    return size() == this.capacity;
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    return (Iterator)new RingBuffer.iterator.1(this);
  }
  
  public final void removeFirst(int paramInt)
  {
    int j = 1;
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("n shouldn't be negative but it is " + paramInt).toString()));
    }
    if (paramInt <= size()) {}
    for (i = j; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + paramInt + ", size = " + size()).toString()));
    }
    if (paramInt > 0)
    {
      i = this.startIndex;
      j = (i + paramInt) % access$getCapacity$p(this);
      if (i <= j) {
        break label176;
      }
      ArraysKt.fill(this.buffer, null, i, this.capacity);
      ArraysKt.fill(this.buffer, null, 0, j);
    }
    for (;;)
    {
      this.startIndex = j;
      this.size = (size() - paramInt);
      return;
      label176:
      ArraysKt.fill(this.buffer, null, i, j);
    }
  }
  
  @NotNull
  public Object[] toArray()
  {
    return toArray(new Object[size()]);
  }
  
  @NotNull
  public <T> T[] toArray(@NotNull T[] paramArrayOfT)
  {
    int n = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "array");
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < size())
    {
      localObject = Arrays.copyOf(paramArrayOfT, size());
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.copyOf(this, newSize)");
    }
    int i1 = size();
    int j = this.startIndex;
    int i = 0;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (i >= i1) {
        break;
      }
      k = n;
      m = i;
      if (j >= this.capacity) {
        break;
      }
      localObject[i] = this.buffer[j];
      j += 1;
      i += 1;
    }
    while (m < i1)
    {
      localObject[m] = this.buffer[k];
      m += 1;
      k += 1;
    }
    if (localObject.length > size()) {
      localObject[size()] = null;
    }
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.RingBuffer
 * JD-Core Version:    0.7.0.1
 */