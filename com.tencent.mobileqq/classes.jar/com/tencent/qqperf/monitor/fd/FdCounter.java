package com.tencent.qqperf.monitor.fd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class FdCounter
{
  private TreeMap<FdNode, String> a;
  private Map<String, Integer> b;
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nBusiness\n");
    Iterator localIterator = this.a.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (i < 20)
      {
        int k = i + 1;
        localStringBuilder.append("fd: ");
        localStringBuilder.append((String)((Map.Entry)localObject).getValue());
        localStringBuilder.append(" ");
        localStringBuilder.append("(");
        localStringBuilder.append("count: ");
        localStringBuilder.append(((FdNode)((Map.Entry)localObject).getKey()).c);
        localStringBuilder.append(")");
        localStringBuilder.append("\n");
        localObject = new ArrayList(((FdNode)((Map.Entry)localObject).getKey()).a.values());
        Collections.sort((List)localObject);
        localObject = ((List)localObject).iterator();
        int j = 0;
        for (;;)
        {
          i = k;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          FdNode localFdNode = (FdNode)((Iterator)localObject).next();
          if (j >= 5)
          {
            localStringBuilder.append("\t\t");
            localStringBuilder.append("…");
            localStringBuilder.append("\n");
            i = k;
            break;
          }
          j += 1;
          localStringBuilder.append("\t\t");
          localStringBuilder.append(localFdNode.b);
          localStringBuilder.append("(");
          localStringBuilder.append("count: ");
          localStringBuilder.append(localFdNode.c);
          localStringBuilder.append(")");
          localStringBuilder.append("\n");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nSystem\n");
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("fd: ");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(" ");
      localStringBuilder.append("(");
      localStringBuilder.append("count: ");
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append(")");
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private void b(FdTrie paramFdTrie)
  {
    paramFdTrie.b();
    d(paramFdTrie);
    c(paramFdTrie);
  }
  
  private void c(FdTrie paramFdTrie)
  {
    Object localObject = paramFdTrie.a();
    paramFdTrie = new HashMap(20);
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      String str = (String)localEntry.getValue();
      if (FdTrie.a(str) == null) {
        paramFdTrie.put(localEntry.getKey(), str);
      }
    }
    this.a = new TreeMap(paramFdTrie);
  }
  
  private void d(FdTrie paramFdTrie)
  {
    this.b = new HashMap(10);
    paramFdTrie = paramFdTrie.c().entrySet().iterator();
    while (paramFdTrie.hasNext())
    {
      Object localObject = (Map.Entry)paramFdTrie.next();
      FdNode localFdNode = (FdNode)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (!this.b.containsKey(localObject))
      {
        this.b.put(localObject, Integer.valueOf(localFdNode.c));
      }
      else
      {
        Integer localInteger = (Integer)this.b.get(localObject);
        this.b.put(localObject, Integer.valueOf(localInteger.intValue() + localFdNode.c));
      }
    }
  }
  
  public String a(FdTrie paramFdTrie)
  {
    b(paramFdTrie);
    paramFdTrie = new StringBuilder();
    paramFdTrie.append(a());
    paramFdTrie.append(b());
    return paramFdTrie.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.fd.FdCounter
 * JD-Core Version:    0.7.0.1
 */