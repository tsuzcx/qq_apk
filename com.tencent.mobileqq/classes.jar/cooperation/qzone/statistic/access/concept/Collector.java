package cooperation.qzone.statistic.access.concept;

import cooperation.qzone.statistic.access.WnsKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collector
  implements Runnable
{
  public static final String TAG = "Statistic.Collector";
  protected Assembler assembler = Assembler.Array;
  protected Condition condition = Condition.Always;
  protected Deliverer deliverer = Deliverer.Console;
  protected volatile boolean flush = false;
  protected volatile boolean isWorking = true;
  protected List<Statistic> lastStatistics = new ArrayList();
  protected volatile long latestWorkTime = 0L;
  protected volatile boolean needForceDeliver = false;
  protected Sampler sampler = Sampler.All;
  protected long sleepTimespan = 3000L;
  protected StatisticFolder statisticFolder = new StatisticFolder();
  protected Thread thread;
  
  public void collect(Statistic paramStatistic)
  {
    this.statisticFolder.put(paramStatistic);
  }
  
  public void doWork()
  {
    haveArest();
    if ((this.condition.meet(this)) || (this.flush))
    {
      int j = 0;
      this.flush = false;
      List localList = this.statisticFolder.pollAll();
      if ((localList != null) && (localList.size() > 0))
      {
        boolean bool2 = this.needForceDeliver;
        boolean bool1 = true;
        if (bool2) {}
        while (getSampler() == null)
        {
          i = 1;
          break;
        }
        int i = getSampler().getFrequency();
        Object localObject1 = localList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Statistic)((Iterator)localObject1).next()).setValue(WnsKeys.Frequency, Integer.valueOf(i));
        }
        localObject1 = localList.toArray();
        if (this.lastStatistics.size() > 0) {
          localList.addAll(this.lastStatistics);
        }
        this.lastStatistics.clear();
        int k = localObject1.length;
        i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          this.lastStatistics.add((Statistic)localObject2);
          i += 1;
        }
        localObject1 = getAssembler().assemble(localList);
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          if ((!this.needForceDeliver) && (getSampler() != null)) {
            bool1 = getSampler().sample();
          }
          this.needForceDeliver = false;
          i = j;
          if (bool1) {
            i = getDeliverer().deliver((String)localObject1, localList.size());
          }
          if (i == 0) {
            this.lastStatistics.clear();
          }
          recordLatestWorkTime();
        }
      }
    }
  }
  
  public void flush()
  {
    this.flush = true;
    Thread localThread = this.thread;
    if ((localThread != null) && (localThread.isAlive())) {
      this.thread.interrupt();
    }
  }
  
  public void forceDeliver()
  {
    try
    {
      this.needForceDeliver = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Assembler getAssembler()
  {
    return this.assembler;
  }
  
  public Condition getCondition()
  {
    return this.condition;
  }
  
  public Deliverer getDeliverer()
  {
    return this.deliverer;
  }
  
  public long getLatestWorkTime()
  {
    return this.latestWorkTime;
  }
  
  public Sampler getSampler()
  {
    return this.sampler;
  }
  
  public long getSleepTimespan()
  {
    return this.sleepTimespan;
  }
  
  public StatisticFolder getStatistics()
  {
    return this.statisticFolder;
  }
  
  public void haveArest()
  {
    long l = this.sleepTimespan;
    if (l > 0L) {}
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public boolean isStopped()
  {
    return this.isWorking ^ true;
  }
  
  public void onStop()
  {
    doWork();
  }
  
  public void recordLatestWorkTime()
  {
    this.latestWorkTime = System.currentTimeMillis();
  }
  
  public void run()
  {
    while (this.isWorking) {
      doWork();
    }
    onStop();
  }
  
  public void setAssembler(Assembler paramAssembler)
  {
    this.assembler = paramAssembler;
  }
  
  public void setCondition(Condition paramCondition)
  {
    this.condition = paramCondition;
  }
  
  public void setDeliverer(Deliverer paramDeliverer)
  {
    this.deliverer = paramDeliverer;
  }
  
  public void setSampler(Sampler paramSampler)
  {
    this.sampler = paramSampler;
  }
  
  public void setSleepTimespan(long paramLong)
  {
    this.sleepTimespan = paramLong;
  }
  
  public void setStatistics(StatisticFolder paramStatisticFolder)
  {
    this.statisticFolder = paramStatisticFolder;
  }
  
  public void startWork()
  {
    Thread localThread = this.thread;
    if ((localThread != null) && (localThread.isAlive()))
    {
      this.isWorking = false;
      this.thread.interrupt();
    }
    this.thread = new Thread(this, "com.qzone.statistic.access.concept");
    this.isWorking = true;
    this.thread.setName("Statistic.Collector");
    if (!this.thread.isAlive()) {
      this.thread.start();
    }
    this.latestWorkTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Collector
 * JD-Core Version:    0.7.0.1
 */