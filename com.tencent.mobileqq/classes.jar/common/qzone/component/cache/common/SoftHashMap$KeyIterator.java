package common.qzone.component.cache.common;

class SoftHashMap$KeyIterator
  extends SoftHashMap<K, V>.HashIterator<K>
{
  SoftHashMap$KeyIterator(SoftHashMap paramSoftHashMap)
  {
    super(paramSoftHashMap);
  }
  
  public K next()
  {
    return a().getKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.KeyIterator
 * JD-Core Version:    0.7.0.1
 */