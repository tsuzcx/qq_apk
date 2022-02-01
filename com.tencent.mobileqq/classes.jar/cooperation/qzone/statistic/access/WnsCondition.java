package cooperation.qzone.statistic.access;

import cooperation.qzone.statistic.access.concept.Collector;
import cooperation.qzone.statistic.access.concept.Condition;
import cooperation.qzone.statistic.access.concept.StatisticFolder;

public class WnsCondition
  extends Condition
{
  protected boolean enableWorkOnExit = true;
  protected int maxsize = 50;
  protected long timespan = 30000L;
  
  public WnsCondition(long paramLong, int paramInt, boolean paramBoolean)
  {
    setTimespan(paramLong);
    setMaxsize(paramInt);
    setWorkOnExitEnabled(paramBoolean);
  }
  
  public int getMaxsize()
  {
    return this.maxsize;
  }
  
  public long getTimespan()
  {
    return this.timespan;
  }
  
  public boolean isWorkOnExitEnabled()
  {
    return this.enableWorkOnExit;
  }
  
  public boolean meet(Collector paramCollector)
  {
    int i;
    int j;
    label30:
    int k;
    if (paramCollector.getStatistics().size() > 0)
    {
      i = 1;
      if (System.currentTimeMillis() - paramCollector.getLatestWorkTime() <= this.timespan) {
        break label89;
      }
      j = 1;
      if (paramCollector.getStatistics().size() < this.maxsize) {
        break label94;
      }
      k = 1;
      label47:
      if ((!this.enableWorkOnExit) || (!paramCollector.isStopped())) {
        break label100;
      }
    }
    label89:
    label94:
    label100:
    for (int m = 1;; m = 0)
    {
      if ((i == 0) || ((j == 0) && (k == 0) && (m == 0))) {
        break label106;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label30;
      k = 0;
      break label47;
    }
    label106:
    return false;
  }
  
  public void setMaxsize(int paramInt)
  {
    this.maxsize = paramInt;
  }
  
  public void setTimespan(long paramLong)
  {
    this.timespan = paramLong;
  }
  
  public void setWorkOnExitEnabled(boolean paramBoolean)
  {
    this.enableWorkOnExit = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.access.WnsCondition
 * JD-Core Version:    0.7.0.1
 */