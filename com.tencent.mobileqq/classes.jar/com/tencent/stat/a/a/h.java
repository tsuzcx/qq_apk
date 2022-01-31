package com.tencent.stat.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class h
{
  private static h b = null;
  private Map<Integer, g> a = null;
  private d c = null;
  
  private h(Context paramContext)
  {
    this.a.put(Integer.valueOf(1), new f(paramContext));
    this.a.put(Integer.valueOf(2), new b(paramContext));
    this.a.put(Integer.valueOf(4), new e(paramContext));
  }
  
  public static h a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new h(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  d a()
  {
    if ((this.c == null) || (!this.c.a())) {
      this.c = a(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
    }
    return this.c;
  }
  
  d a(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Integer)paramList.next();
        localObject = (g)this.a.get(localObject);
        if (localObject != null)
        {
          localObject = ((g)localObject).e();
          if ((localObject != null) && (((d)localObject).a())) {
            return localObject;
          }
        }
      }
    }
    return new d();
  }
  
  public void a(d paramd)
  {
    this.c = paramd;
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((g)((Map.Entry)localIterator.next()).getValue()).a(paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.a.a.h
 * JD-Core Version:    0.7.0.1
 */