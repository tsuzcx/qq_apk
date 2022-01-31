package rx.internal.util;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

class IndexedRingBuffer$IndexSection
{
  private final AtomicReference<IndexSection> _next = new AtomicReference();
  private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);
  
  public int getAndSet(int paramInt1, int paramInt2)
  {
    return this.unsafeArray.getAndSet(paramInt1, paramInt2);
  }
  
  IndexSection getNext()
  {
    Object localObject;
    if (this._next.get() != null) {
      localObject = (IndexSection)this._next.get();
    }
    IndexSection localIndexSection;
    do
    {
      return localObject;
      localIndexSection = new IndexSection();
      localObject = localIndexSection;
    } while (this._next.compareAndSet(null, localIndexSection));
    return (IndexSection)this._next.get();
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    this.unsafeArray.set(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.util.IndexedRingBuffer.IndexSection
 * JD-Core Version:    0.7.0.1
 */