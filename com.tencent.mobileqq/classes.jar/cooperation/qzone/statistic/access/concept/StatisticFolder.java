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
    if (paramInt < 1) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = Math.min(paramInt, size());
    paramInt = 0;
    while (paramInt < i)
    {
      Statistic localStatistic = poll();
      if (localStatistic != null) {
        localArrayList.add(localStatistic);
      }
      paramInt += 1;
    }
    return localArrayList;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.StatisticFolder
 * JD-Core Version:    0.7.0.1
 */