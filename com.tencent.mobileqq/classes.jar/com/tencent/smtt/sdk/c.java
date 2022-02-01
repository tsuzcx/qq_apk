package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c
{
  private static c e;
  private static boolean g = false;
  private String a = "EmergenceMsgPublisher";
  private String b = "tbs_emergence";
  private String c = "emergence_executed_ids";
  private String d = "emergence_ids";
  private final Map<Integer, c.a> f = new LinkedHashMap();
  
  public static c a()
  {
    if (e == null) {
      e = new c();
    }
    return e;
  }
  
  private void a(Context paramContext, c.b paramb, c.a parama)
  {
    if (parama != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Executed command: ");
      ((StringBuilder)localObject).append(paramb.b);
      ((StringBuilder)localObject).append(", extra: ");
      ((StringBuilder)localObject).append(paramb.c);
      a(((StringBuilder)localObject).toString());
      parama.a(paramb.c);
      paramContext = paramContext.getSharedPreferences(this.b, 4);
      localObject = paramContext.getString(this.c, "");
      parama = new HashSet();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        if ((localObject != null) && (localObject.length > 0)) {
          try
          {
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              parama.add(Integer.valueOf(Integer.parseInt(localObject[i])));
              i += 1;
            }
            parama.add(Integer.valueOf(paramb.a));
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      }
      paramb = new StringBuilder();
      parama = parama.iterator();
      while (parama.hasNext())
      {
        paramb.append((Integer)parama.next());
        paramb.append(",");
      }
      paramContext = paramContext.edit();
      paramContext.putString(this.c, paramb.toString());
      paramContext.commit();
    }
  }
  
  private void a(String paramString) {}
  
  public Map<Integer, c.b> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.b;
    int k = 0;
    localObject1 = paramContext.getSharedPreferences((String)localObject1, 0);
    if (paramContext == null) {}
    for (paramContext = "Unexpected null context!";; paramContext = "Empty local emergence ids!")
    {
      a(paramContext);
      return localHashMap;
      paramContext = ((SharedPreferences)localObject1).getString(this.d, "");
      if (!TextUtils.isEmpty(paramContext)) {
        break;
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Local emergence ids: ");
    ((StringBuilder)localObject2).append(paramContext);
    a(((StringBuilder)localObject2).toString());
    paramContext = paramContext.split(";");
    int j;
    int i;
    if (paramContext != null)
    {
      j = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      String[] arrayOfString;
      if (i < j)
      {
        localObject2 = paramContext[i];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          arrayOfString = ((String)localObject2).split(",");
          if ((arrayOfString != null) && (arrayOfString.length == 4)) {
            localObject2 = new c.b();
          }
        }
      }
      try
      {
        ((c.b)localObject2).a = Integer.parseInt(arrayOfString[0]);
        ((c.b)localObject2).b = Integer.parseInt(arrayOfString[1]);
        ((c.b)localObject2).c = String.valueOf(arrayOfString[2]);
        ((c.b)localObject2).d = Long.parseLong(arrayOfString[3]);
        label220:
        if (System.currentTimeMillis() < ((c.b)localObject2).d) {
          localHashMap.put(Integer.valueOf(((c.b)localObject2).a), localObject2);
        }
        i += 1;
        continue;
        paramContext = ((SharedPreferences)localObject1).getString(this.c, "");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Executed ids: ");
        ((StringBuilder)localObject1).append(paramContext);
        a(((StringBuilder)localObject1).toString());
        paramContext = paramContext.split(",");
        if (paramContext != null)
        {
          localObject1 = new ArrayList();
          int n = paramContext.length;
          i = 0;
          for (;;)
          {
            j = k;
            if (i >= n) {
              break;
            }
            localObject2 = paramContext[i];
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              j = -1;
              try
              {
                int m = Integer.parseInt((String)localObject2);
                j = m;
              }
              catch (Throwable localThrowable1)
              {
                localThrowable1.printStackTrace();
              }
              if (j > 0) {
                ((List)localObject1).add(Integer.valueOf(j));
              }
            }
            i += 1;
          }
          while (j < ((List)localObject1).size())
          {
            localHashMap.remove(((List)localObject1).get(j));
            j += 1;
          }
        }
        return localHashMap;
      }
      catch (Throwable localThrowable2)
      {
        break label220;
      }
    }
  }
  
  public void a(Context paramContext, Integer paramInteger, c.a parama)
  {
    Map localMap = a(paramContext);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      c.b localb = (c.b)localMap.get((Integer)localIterator.next());
      if (localb == null)
      {
        a("Unexpected null command!");
      }
      else if (localb.b == paramInteger.intValue())
      {
        a(paramContext, localb, parama);
        return;
      }
    }
    if (!g)
    {
      this.f.put(paramInteger, parama);
      paramContext = new StringBuilder();
      paramContext.append("Emergence config did not arrived yet, code[");
      paramContext.append(paramInteger);
      paramContext.append("] has been suspended");
      a(paramContext.toString());
    }
  }
  
  public void b(Context paramContext)
  {
    Map localMap = a(paramContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("On notify emergence, validate commands: ");
    ((StringBuilder)localObject).append(localMap);
    a(((StringBuilder)localObject).toString());
    g = true;
    localObject = this.f.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger1 = (Integer)((Iterator)localObject).next();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger2 = (Integer)localIterator.next();
        if (((c.b)localMap.get(localInteger2)).b == localInteger1.intValue()) {
          a(paramContext, (c.b)localMap.get(localInteger2), (c.a)this.f.get(localInteger1));
        }
      }
    }
    if (!this.f.isEmpty())
    {
      paramContext = new StringBuilder();
      paramContext.append("Emergency code[");
      paramContext.append(this.f.keySet());
      paramContext.append("] did not happen, clear suspended queries");
      a(paramContext.toString());
      this.f.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.c
 * JD-Core Version:    0.7.0.1
 */