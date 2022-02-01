package common.qzone.component.cache.common;

class SoftHashMap$ValueIterator
  extends SoftHashMap<K, V>.HashIterator<V>
{
  SoftHashMap$ValueIterator(SoftHashMap paramSoftHashMap)
  {
    super(paramSoftHashMap);
  }
  
  public V next()
  {
    return SoftHashMap.Entry.b(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.ValueIterator
 * JD-Core Version:    0.7.0.1
 */