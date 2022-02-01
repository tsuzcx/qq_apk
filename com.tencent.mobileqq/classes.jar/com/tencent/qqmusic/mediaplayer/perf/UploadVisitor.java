package com.tencent.qqmusic.mediaplayer.perf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class UploadVisitor
  implements Collectable, PerformanceTracer.Visitor
{
  private HashMap<String, Long> prefInfos = new HashMap();
  
  public void accept(ErrorUploadCollector paramErrorUploadCollector) {}
  
  public void accept(PlayerInfoCollector paramPlayerInfoCollector)
  {
    if (!this.prefInfos.entrySet().isEmpty())
    {
      Iterator localIterator = this.prefInfos.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramPlayerInfoCollector.putLong((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
      }
    }
  }
  
  public void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> paramList, PerformanceTracer.OverallInfo paramOverallInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramOverallInfo = (PerformanceTracer.SpeedCheck)paramList.next();
      HashMap localHashMap = this.prefInfos;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramOverallInfo.getName());
      localStringBuilder.append(".ms");
      localHashMap.put(localStringBuilder.toString(), Long.valueOf(paramOverallInfo.getTotalTimeMs()));
      localHashMap = this.prefInfos;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramOverallInfo.getName());
      localStringBuilder.append(".bytes");
      localHashMap.put(localStringBuilder.toString(), Long.valueOf(paramOverallInfo.getTotalBufferLength()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.UploadVisitor
 * JD-Core Version:    0.7.0.1
 */