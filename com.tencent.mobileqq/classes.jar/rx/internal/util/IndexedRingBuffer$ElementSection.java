package rx.internal.util;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

class IndexedRingBuffer$ElementSection<E>
{
  final AtomicReferenceArray<E> array = new AtomicReferenceArray(IndexedRingBuffer.SIZE);
  final AtomicReference<ElementSection<E>> next = new AtomicReference();
  
  ElementSection<E> getNext()
  {
    if (this.next.get() != null) {
      return (ElementSection)this.next.get();
    }
    ElementSection localElementSection = new ElementSection();
    if (this.next.compareAndSet(null, localElementSection)) {
      return localElementSection;
    }
    return (ElementSection)this.next.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.IndexedRingBuffer.ElementSection
 * JD-Core Version:    0.7.0.1
 */