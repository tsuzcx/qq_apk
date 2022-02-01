package rx.subjects;

final class ReplaySubject$PairEvictionPolicy
  implements ReplaySubject.EvictionPolicy
{
  final ReplaySubject.EvictionPolicy first;
  final ReplaySubject.EvictionPolicy second;
  
  public ReplaySubject$PairEvictionPolicy(ReplaySubject.EvictionPolicy paramEvictionPolicy1, ReplaySubject.EvictionPolicy paramEvictionPolicy2)
  {
    this.first = paramEvictionPolicy1;
    this.second = paramEvictionPolicy2;
  }
  
  public void evict(ReplaySubject.NodeList<Object> paramNodeList)
  {
    this.first.evict(paramNodeList);
    this.second.evict(paramNodeList);
  }
  
  public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
  {
    this.first.evictFinal(paramNodeList);
    this.second.evictFinal(paramNodeList);
  }
  
  public boolean test(Object paramObject, long paramLong)
  {
    return (this.first.test(paramObject, paramLong)) || (this.second.test(paramObject, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.subjects.ReplaySubject.PairEvictionPolicy
 * JD-Core Version:    0.7.0.1
 */