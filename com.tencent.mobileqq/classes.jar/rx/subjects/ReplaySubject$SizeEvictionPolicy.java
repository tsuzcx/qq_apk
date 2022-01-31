package rx.subjects;

final class ReplaySubject$SizeEvictionPolicy
  implements ReplaySubject.EvictionPolicy
{
  final int maxSize;
  
  public ReplaySubject$SizeEvictionPolicy(int paramInt)
  {
    this.maxSize = paramInt;
  }
  
  public void evict(ReplaySubject.NodeList<Object> paramNodeList)
  {
    while (paramNodeList.size() > this.maxSize) {
      paramNodeList.removeFirst();
    }
  }
  
  public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
  {
    while (paramNodeList.size() > this.maxSize + 1) {
      paramNodeList.removeFirst();
    }
  }
  
  public boolean test(Object paramObject, long paramLong)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.subjects.ReplaySubject.SizeEvictionPolicy
 * JD-Core Version:    0.7.0.1
 */