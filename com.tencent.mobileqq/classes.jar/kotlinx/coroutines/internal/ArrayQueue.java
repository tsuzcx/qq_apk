package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class ArrayQueue<T>
{
  private Object[] elements = new Object[16];
  private int head;
  private int tail;
  
  private final void ensureCapacity()
  {
    Object[] arrayOfObject2 = this.elements;
    int i = arrayOfObject2.length;
    Object[] arrayOfObject1 = new Object[i << 1];
    ArraysKt.copyInto$default(arrayOfObject2, arrayOfObject1, 0, this.head, 0, 10, null);
    arrayOfObject2 = this.elements;
    int j = arrayOfObject2.length;
    int k = this.head;
    ArraysKt.copyInto$default(arrayOfObject2, arrayOfObject1, j - k, 0, k, 4, null);
    this.elements = arrayOfObject1;
    this.head = 0;
    this.tail = i;
  }
  
  public final void addLast(@NotNull T paramT)
  {
    Object[] arrayOfObject = this.elements;
    int i = this.tail;
    arrayOfObject[i] = paramT;
    this.tail = (arrayOfObject.length - 1 & i + 1);
    if (this.tail == this.head) {
      ensureCapacity();
    }
  }
  
  public final void clear()
  {
    this.head = 0;
    this.tail = 0;
    this.elements = new Object[this.elements.length];
  }
  
  public final boolean isEmpty()
  {
    return this.head == this.tail;
  }
  
  @Nullable
  public final T removeFirstOrNull()
  {
    int i = this.head;
    if (i == this.tail) {
      return null;
    }
    Object[] arrayOfObject = this.elements;
    Object localObject = arrayOfObject[i];
    arrayOfObject[i] = null;
    this.head = (i + 1 & arrayOfObject.length - 1);
    if (localObject != null) {
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type T");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ArrayQueue
 * JD-Core Version:    0.7.0.1
 */