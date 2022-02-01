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
    int j = 1;
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt <= this.buffer.length) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.capacity = this.buffer.length;
        this.size = paramInt;
        return;
      }
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("ring buffer filled size: ");
      paramArrayOfObject.append(paramInt);
      paramArrayOfObject.append(" cannot be larger than the buffer size: ");
      paramArrayOfObject.append(this.buffer.length);
      throw ((Throwable)new IllegalArgumentException(paramArrayOfObject.toString().toString()));
    }
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("ring buffer filled size should not be negative but it is ");
    paramArrayOfObject.append(paramInt);
    throw ((Throwable)new IllegalArgumentException(paramArrayOfObject.toString().toString()));
  }
  
  private final int forward(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2) % access$getCapacity$p(this);
  }
  
  public final void add(T paramT)
  {
    if (!isFull())
    {
      this.buffer[((this.startIndex + size()) % access$getCapacity$p(this))] = paramT;
      this.size = (size() + 1);
      return;
    }
    throw ((Throwable)new IllegalStateException("ring buffer is full"));
  }
  
  @NotNull
  public final RingBuffer<T> expanded(int paramInt)
  {
    int i = this.capacity;
    paramInt = RangesKt.coerceAtMost(i + (i >> 1) + 1, paramInt);
    Object[] arrayOfObject;
    if (this.startIndex == 0)
    {
      arrayOfObject = Arrays.copyOf(this.buffer, paramInt);
      Intrinsics.checkExpressionValueIsNotNull(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
    }
    else
    {
      arrayOfObject = toArray(new Object[paramInt]);
    }
    return new RingBuffer(arrayOfObject, size());
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
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt <= size()) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt > 0)
        {
          i = this.startIndex;
          j = (i + paramInt) % access$getCapacity$p(this);
          if (i > j)
          {
            ArraysKt.fill(this.buffer, null, i, this.capacity);
            ArraysKt.fill(this.buffer, null, 0, j);
          }
          else
          {
            ArraysKt.fill(this.buffer, null, i, j);
          }
          this.startIndex = j;
          this.size = (size() - paramInt);
        }
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("n shouldn't be greater than the buffer size: n = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", size = ");
      localStringBuilder.append(size());
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n shouldn't be negative but it is ");
    localStringBuilder.append(paramInt);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  @NotNull
  public Object[] toArray()
  {
    return toArray(new Object[size()]);
  }
  
  @NotNull
  public <T> T[] toArray(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "array");
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < size())
    {
      localObject = Arrays.copyOf(paramArrayOfT, size());
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.copyOf(this, newSize)");
    }
    int i1 = size();
    int j = this.startIndex;
    int n = 0;
    int i = 0;
    int k;
    int m;
    for (;;)
    {
      k = i;
      m = n;
      if (i >= i1) {
        break;
      }
      k = i;
      m = n;
      if (j >= this.capacity) {
        break;
      }
      localObject[i] = this.buffer[j];
      i += 1;
      j += 1;
    }
    while (k < i1)
    {
      localObject[k] = this.buffer[m];
      k += 1;
      m += 1;
    }
    if (localObject.length > size()) {
      localObject[size()] = null;
    }
    if (localObject != null) {
      return localObject;
    }
    paramArrayOfT = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramArrayOfT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.RingBuffer
 * JD-Core Version:    0.7.0.1
 */