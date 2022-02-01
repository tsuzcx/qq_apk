package common.qzone.component.cache.common;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class SoftHashMap$HashIterator<T>
  implements Iterator<T>
{
  int b;
  SoftHashMap.Entry<K, V> c = null;
  SoftHashMap.Entry<K, V> d = null;
  int e = SoftHashMap.a(this.h);
  Object f = null;
  Object g = null;
  
  SoftHashMap$HashIterator(SoftHashMap paramSoftHashMap)
  {
    int i;
    if (paramSoftHashMap.size() != 0) {
      i = SoftHashMap.b(paramSoftHashMap).length;
    } else {
      i = 0;
    }
    this.b = i;
  }
  
  protected SoftHashMap.Entry<K, V> b()
  {
    if (SoftHashMap.a(this.h) == this.e)
    {
      if ((this.f == null) && (!hasNext())) {
        throw new NoSuchElementException();
      }
      SoftHashMap.Entry localEntry = this.c;
      this.d = localEntry;
      this.c = SoftHashMap.Entry.c(localEntry);
      this.g = this.f;
      this.f = null;
      return this.d;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean hasNext()
  {
    SoftHashMap.Entry[] arrayOfEntry = SoftHashMap.b(this.h);
    while (this.f == null)
    {
      SoftHashMap.Entry localEntry = this.c;
      int i = this.b;
      while ((localEntry == null) && (i > 0))
      {
        i -= 1;
        localEntry = arrayOfEntry[i];
      }
      this.c = localEntry;
      this.b = i;
      if (localEntry == null)
      {
        this.g = null;
        return false;
      }
      this.f = localEntry.get();
      if (this.f == null) {
        this.c = SoftHashMap.Entry.c(this.c);
      }
    }
    return true;
  }
  
  public void remove()
  {
    if (this.d != null)
    {
      if (SoftHashMap.a(this.h) == this.e)
      {
        this.h.remove(this.g);
        this.e = SoftHashMap.a(this.h);
        this.d = null;
        this.g = null;
        return;
      }
      throw new ConcurrentModificationException();
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.HashIterator
 * JD-Core Version:    0.7.0.1
 */