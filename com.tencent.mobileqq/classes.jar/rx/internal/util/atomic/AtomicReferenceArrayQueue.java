package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

abstract class AtomicReferenceArrayQueue<E>
  extends AbstractQueue<E>
{
  protected final AtomicReferenceArray<E> buffer;
  protected final int mask;
  
  public AtomicReferenceArrayQueue(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    this.mask = (paramInt - 1);
    this.buffer = new AtomicReferenceArray(paramInt);
  }
  
  protected final int calcElementOffset(long paramLong)
  {
    int i = (int)paramLong;
    return this.mask & i;
  }
  
  protected final int calcElementOffset(long paramLong, int paramInt)
  {
    return (int)paramLong & paramInt;
  }
  
  public void clear()
  {
    while ((poll() != null) || (!isEmpty())) {}
  }
  
  public Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  protected final E lpElement(int paramInt)
  {
    return this.buffer.get(paramInt);
  }
  
  protected final E lpElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt)
  {
    return paramAtomicReferenceArray.get(paramInt);
  }
  
  protected final E lvElement(int paramInt)
  {
    return lvElement(this.buffer, paramInt);
  }
  
  protected final E lvElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt)
  {
    return paramAtomicReferenceArray.get(paramInt);
  }
  
  protected final void soElement(int paramInt, E paramE)
  {
    this.buffer.lazySet(paramInt, paramE);
  }
  
  protected final void soElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt, E paramE)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramE);
  }
  
  protected final void spElement(int paramInt, E paramE)
  {
    this.buffer.lazySet(paramInt, paramE);
  }
  
  protected final void spElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt, E paramE)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramE);
  }
  
  protected final void svElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt, E paramE)
  {
    paramAtomicReferenceArray.set(paramInt, paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.atomic.AtomicReferenceArrayQueue
 * JD-Core Version:    0.7.0.1
 */