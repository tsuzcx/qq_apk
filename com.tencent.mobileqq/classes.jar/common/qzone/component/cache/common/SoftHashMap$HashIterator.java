package common.qzone.component.cache.common;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class SoftHashMap$HashIterator<T>
  implements Iterator<T>
{
  int jdField_a_of_type_Int;
  SoftHashMap.Entry<K, V> jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry = null;
  Object jdField_a_of_type_JavaLangObject = null;
  int jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
  SoftHashMap.Entry<K, V> jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry = null;
  Object jdField_b_of_type_JavaLangObject = null;
  
  SoftHashMap$HashIterator(SoftHashMap paramSoftHashMap)
  {
    if (paramSoftHashMap.size() != 0) {}
    for (int i = SoftHashMap.a(paramSoftHashMap).length;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  protected SoftHashMap.Entry<K, V> a()
  {
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    if ((this.jdField_a_of_type_JavaLangObject == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry = this.jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry;
    this.jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry = SoftHashMap.Entry.a(this.jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry);
    this.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = null;
    return this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry;
  }
  
  public boolean hasNext()
  {
    SoftHashMap.Entry[] arrayOfEntry = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    while (this.jdField_a_of_type_JavaLangObject == null)
    {
      SoftHashMap.Entry localEntry = this.jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry;
      int i = this.jdField_a_of_type_Int;
      while ((localEntry == null) && (i > 0))
      {
        i -= 1;
        localEntry = arrayOfEntry[i];
      }
      this.jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry = localEntry;
      this.jdField_a_of_type_Int = i;
      if (localEntry == null)
      {
        this.jdField_b_of_type_JavaLangObject = null;
        return false;
      }
      this.jdField_a_of_type_JavaLangObject = localEntry.get();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry = SoftHashMap.Entry.a(this.jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry);
      }
    }
    return true;
  }
  
  public void remove()
  {
    if (this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry == null) {
      throw new IllegalStateException();
    }
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap.remove(this.jdField_b_of_type_JavaLangObject);
    this.jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry = null;
    this.jdField_b_of_type_JavaLangObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.HashIterator
 * JD-Core Version:    0.7.0.1
 */