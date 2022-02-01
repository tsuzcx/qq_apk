package rx.subjects;

abstract interface ReplaySubject$EvictionPolicy
{
  public abstract void evict(ReplaySubject.NodeList<Object> paramNodeList);
  
  public abstract void evictFinal(ReplaySubject.NodeList<Object> paramNodeList);
  
  public abstract boolean test(Object paramObject, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subjects.ReplaySubject.EvictionPolicy
 * JD-Core Version:    0.7.0.1
 */