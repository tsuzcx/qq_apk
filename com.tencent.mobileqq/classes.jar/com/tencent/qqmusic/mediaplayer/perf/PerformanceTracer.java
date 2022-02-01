package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PerformanceTracer
{
  private IDataSource dataSource;
  private long lastTimeStampNanoSecond = 0L;
  private long playStartTimestampNanoSec = 0L;
  private final Map<String, PerformanceTracer.SpeedCheck> speedMap = new LinkedHashMap();
  private long totalPcmInByte;
  private long totalTimeCostInNanoSec = 0L;
  
  private PerformanceTracer.SpeedCheck getSpeedCheck(String paramString)
  {
    PerformanceTracer.SpeedCheck localSpeedCheck = (PerformanceTracer.SpeedCheck)this.speedMap.get(paramString);
    if (localSpeedCheck != null) {
      return localSpeedCheck;
    }
    localSpeedCheck = new PerformanceTracer.SpeedCheck(paramString, null);
    this.speedMap.put(paramString, localSpeedCheck);
    return localSpeedCheck;
  }
  
  public void accept(PerformanceTracer.Visitor paramVisitor)
  {
    ArrayList localArrayList = new ArrayList(this.speedMap.values());
    Object localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      PerformanceTracer.SpeedCheck.access$100((PerformanceTracer.SpeedCheck)((Iterator)localObject).next());
    }
    localObject = this.dataSource;
    double d = this.totalTimeCostInNanoSec;
    Double.isNaN(d);
    paramVisitor.visitSpeedCheck(localArrayList, new PerformanceTracer.OverallInfo((IDataSource)localObject, Math.round(d / 1000000.0D), this.totalPcmInByte));
  }
  
  public void end(String paramString, int paramInt)
  {
    long l1 = System.nanoTime();
    long l2 = this.lastTimeStampNanoSecond;
    PerformanceTracer.SpeedCheck.access$000(getSpeedCheck(paramString), paramInt, l1 - l2);
  }
  
  public void init(IDataSource paramIDataSource)
  {
    this.dataSource = paramIDataSource;
    this.lastTimeStampNanoSecond = 0L;
    paramIDataSource = this.speedMap.values().iterator();
    while (paramIDataSource.hasNext()) {
      ((PerformanceTracer.SpeedCheck)paramIDataSource.next()).reset();
    }
  }
  
  public void playEnd() {}
  
  public void playStart()
  {
    this.totalPcmInByte = 0L;
  }
  
  public void roundEnd(int paramInt)
  {
    this.totalPcmInByte += paramInt;
    this.totalTimeCostInNanoSec += System.nanoTime() - this.playStartTimestampNanoSec;
  }
  
  public void roundStart()
  {
    this.playStartTimestampNanoSec = System.nanoTime();
  }
  
  public void start(String paramString)
  {
    getSpeedCheck(paramString);
    this.lastTimeStampNanoSecond = System.nanoTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer
 * JD-Core Version:    0.7.0.1
 */