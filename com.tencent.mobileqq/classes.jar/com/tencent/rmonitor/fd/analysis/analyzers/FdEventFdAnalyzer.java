package com.tencent.rmonitor.fd.analysis.analyzers;

import com.tencent.rmonitor.fd.dump.data.FdThreadData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FdEventFdAnalyzer
  extends BaseFdAnalyzer<List<FdThreadData>>
{
  public String a()
  {
    return "threads";
  }
  
  protected Map<String, Integer> a(List<FdThreadData> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FdThreadData localFdThreadData = (FdThreadData)paramList.next();
      a(localHashMap, String.format("/%s/%s", new Object[] { localFdThreadData.a(), localFdThreadData.b() }));
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.analyzers.FdEventFdAnalyzer
 * JD-Core Version:    0.7.0.1
 */