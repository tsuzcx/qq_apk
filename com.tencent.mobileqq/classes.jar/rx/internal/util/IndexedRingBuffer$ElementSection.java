package rx.internal.util;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

class IndexedRingBuffer$ElementSection<E>
{
  final AtomicReferenceArray<E> array = new AtomicReferenceArray(IndexedRingBuffer.SIZE);
  final AtomicReference<ElementSection<E>> next = new AtomicReference();
  
  ElementSection<E> getNext()
  {
    Object localObject;
    if (this.next.get() != null) {
      localObject = (ElementSection)this.next.get();
    }
    ElementSection localElementSection;
    do
    {
      return localObject;
      localElementSection = new ElementSection();
      localObject = localElementSection;
    } while (this.next.compareAndSet(null, localElementSection));
    return (ElementSection)this.next.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.util.IndexedRingBuffer.ElementSection
 * JD-Core Version:    0.7.0.1
 */