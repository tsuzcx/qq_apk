package com.tencent.mobileqq.kandian.base.report;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DistinctEventReporter
{
  HashMap<String, HashSet<Object>> mRecords = new HashMap();
  DistinctEventReporter.IReporter mReporter;
  
  public DistinctEventReporter(DistinctEventReporter.IReporter paramIReporter)
  {
    this.mReporter = paramIReporter;
  }
  
  private void record(String paramString, Object paramObject)
  {
    HashSet localHashSet2 = (HashSet)this.mRecords.get(paramString);
    if ((localHashSet2 != null) && (localHashSet2.contains(paramObject))) {
      return;
    }
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null) {
      localHashSet1 = new HashSet();
    }
    localHashSet1.add(paramObject);
    this.mRecords.put(paramString, localHashSet1);
  }
  
  public void clear(String paramString)
  {
    this.mRecords.remove(paramString);
  }
  
  public void clearAll()
  {
    this.mRecords.clear();
  }
  
  public void reportDelay()
  {
    if ((this.mReporter != null) && (!this.mRecords.isEmpty()))
    {
      Iterator localIterator1 = this.mRecords.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        Iterator localIterator2 = ((HashSet)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
        {
          Object localObject = localIterator2.next();
          this.mReporter.reportIt((String)localEntry.getKey(), localObject);
        }
      }
    }
  }
  
  public void trigger(String paramString, Object paramObject)
  {
    trigger(paramString, paramObject, true);
  }
  
  public void trigger(String paramString, Object paramObject, boolean paramBoolean)
  {
    record(paramString, paramObject);
    if (paramBoolean) {
      return;
    }
    DistinctEventReporter.IReporter localIReporter = this.mReporter;
    if (localIReporter != null) {
      localIReporter.reportIt(paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.DistinctEventReporter
 * JD-Core Version:    0.7.0.1
 */