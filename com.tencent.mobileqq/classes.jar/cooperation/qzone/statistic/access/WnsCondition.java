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
    int i = paramCollector.getStatistics().size();
    boolean bool2 = true;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (System.currentTimeMillis() - paramCollector.getLatestWorkTime() > this.timespan) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (paramCollector.getStatistics().size() >= this.maxsize) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if ((this.enableWorkOnExit) && (paramCollector.isStopped())) {
      m = 1;
    } else {
      m = 0;
    }
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0) {
        break label122;
      }
      bool1 = bool2;
      if (k != 0) {
        break label122;
      }
      if (m != 0) {
        return true;
      }
    }
    boolean bool1 = false;
    label122:
    return bool1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.WnsCondition
 * JD-Core Version:    0.7.0.1
 */