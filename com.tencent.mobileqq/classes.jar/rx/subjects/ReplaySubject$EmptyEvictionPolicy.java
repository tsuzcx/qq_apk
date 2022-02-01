package rx.subjects;

final class ReplaySubject$EmptyEvictionPolicy
  implements ReplaySubject.EvictionPolicy
{
  public void evict(ReplaySubject.NodeList<Object> paramNodeList) {}
  
  public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList) {}
  
  public boolean test(Object paramObject, long paramLong)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.subjects.ReplaySubject.EmptyEvictionPolicy
 * JD-Core Version:    0.7.0.1
 */