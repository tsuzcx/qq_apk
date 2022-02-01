package com.tencent.rmonitor.fd.dump.data;

import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import shark.HeapGraph;
import shark.Hprof;

public class FdHeapData
  implements Closeable
{
  private final Hprof a;
  private final HeapGraph b;
  private final Map<String, Set<Long>> c = new HashMap();
  private final Map<String, Map<Long, String>> d = new HashMap();
  
  public FdHeapData(Hprof paramHprof, HeapGraph paramHeapGraph)
  {
    this.a = paramHprof;
    this.b = paramHeapGraph;
  }
  
  public Set<Long> a(String paramString)
  {
    return (Set)this.c.get(paramString);
  }
  
  public HeapGraph a()
  {
    return this.b;
  }
  
  public void a(String paramString, Map<Long, String> paramMap)
  {
    this.d.put(paramString, paramMap);
  }
  
  public void a(String paramString, Set<Long> paramSet)
  {
    this.c.put(paramString, paramSet);
  }
  
  public Map<Long, String> b(String paramString)
  {
    return (Map)this.d.get(paramString);
  }
  
  public Set<Long> b()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      localHashSet.addAll((Set)localIterator.next());
    }
    return localHashSet;
  }
  
  public void close()
  {
    Hprof localHprof = this.a;
    if (localHprof != null) {
      localHprof.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.dump.data.FdHeapData
 * JD-Core Version:    0.7.0.1
 */