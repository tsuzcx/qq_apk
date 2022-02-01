package com.tencent.qqperf.monitor.fd;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FdTrie
{
  static final List<String> a = new FdTrie.1(10);
  private HashMap<FdNode, String> b = new HashMap(100);
  private FdNode c = new FdNode();
  private HashMap<FdNode, String> d = new HashMap(a.size());
  
  static String a(String paramString)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((paramString != null) && (paramString.contains(str))) {
        return str;
      }
    }
    return null;
  }
  
  private void a(FdNode paramFdNode, String paramString)
  {
    if (paramFdNode == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.d.put(paramFdNode, localObject);
    }
    int j = 1;
    localObject = paramFdNode.a.values().iterator();
    FdNode localFdNode;
    do
    {
      i = j;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localFdNode = (FdNode)((Iterator)localObject).next();
    } while ((localFdNode == null) || (localFdNode.a()));
    int i = 0;
    if ((i != 0) && (!paramFdNode.a.isEmpty()))
    {
      this.b.put(paramFdNode, paramString);
      return;
    }
    localObject = paramFdNode.a.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localFdNode = (FdNode)((Iterator)localObject).next();
      if (localFdNode != null)
      {
        if (paramString != null)
        {
          paramFdNode = new StringBuilder();
          paramFdNode.append(paramString);
          paramFdNode.append("/");
          paramFdNode.append(localFdNode.b);
          paramFdNode = paramFdNode.toString();
        }
        else
        {
          paramFdNode = localFdNode.b;
        }
        a(localFdNode, paramFdNode);
      }
    }
  }
  
  private void b(FdNode paramFdNode, String paramString)
  {
    Iterator localIterator = c(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramFdNode.a(str);
      if (paramString != null)
      {
        paramString.c += 1;
        paramFdNode = paramString;
      }
      else
      {
        paramString = new FdNode(str);
        paramString.c = 1;
        paramFdNode.a.put(paramString.b, paramString);
        paramFdNode = paramString;
      }
    }
  }
  
  private static List<String> c(String paramString)
  {
    paramString = paramString.split("/");
    ArrayList localArrayList = new ArrayList(paramString.length);
    localArrayList.addAll(Arrays.asList(paramString));
    return localArrayList;
  }
  
  public HashMap<FdNode, String> a()
  {
    return this.b;
  }
  
  public void b()
  {
    a(this.c, null);
  }
  
  public void b(@NonNull String paramString)
  {
    b(this.c, paramString);
  }
  
  public HashMap<FdNode, String> c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.fd.FdTrie
 * JD-Core Version:    0.7.0.1
 */