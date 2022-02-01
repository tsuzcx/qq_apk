package cooperation.qzone.statistic.access.concept;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class StatisticFolder
{
  protected volatile ConcurrentLinkedQueue<Statistic> statistics = new ConcurrentLinkedQueue();
  
  public Statistic poll()
  {
    return (Statistic)this.statistics.poll();
  }
  
  public List<Statistic> poll(int paramInt)
  {
    Object localObject;
    if (paramInt < 1)
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = Math.min(paramInt, size());
    paramInt = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i) {
        break;
      }
      localObject = poll();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramInt += 1;
    }
  }
  
  public List<Statistic> pollAll()
  {
    return poll(size());
  }
  
  public void put(Statistic paramStatistic)
  {
    this.statistics.add(paramStatistic);
  }
  
  public int size()
  {
    return this.statistics.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.StatisticFolder
 * JD-Core Version:    0.7.0.1
 */