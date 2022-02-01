package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.a.g;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c
{
  private static String a = "EmergencyManager";
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static int e = 3;
  private static int f = 4;
  private static int g = 5;
  private static c h;
  private long i = 60000L;
  private long j = 86400000L;
  private boolean k = false;
  
  public static c a()
  {
    try
    {
      if (h == null) {
        h = new c();
      }
      c localc = h;
      return localc;
    }
    finally {}
  }
  
  private void a(Context paramContext, int paramInt, List<com.tencent.smtt.sdk.a.b> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    g localg = g.a();
    Object localObject = localg.a(paramContext, "emergence_ids");
    HashSet localHashSet = new HashSet();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String[] arrayOfString = g.a((String)((Iterator)localObject).next());
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          localHashSet.add(Integer.valueOf(Integer.parseInt(arrayOfString[0])));
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.smtt.sdk.a.b)paramList.next();
      int m = ((com.tencent.smtt.sdk.a.b)localObject).b();
      int n = ((com.tencent.smtt.sdk.a.b)localObject).a();
      if ((!localHashSet.contains(Integer.valueOf(n))) && (!((com.tencent.smtt.sdk.a.b)localObject).e()))
      {
        localLinkedHashMap.put(Integer.valueOf(m), ((com.tencent.smtt.sdk.a.b)localObject).c());
        localg.a(paramContext, "emergence_ids", g.a(new String[] { String.valueOf(n), String.valueOf(((com.tencent.smtt.sdk.a.b)localObject).d()) }));
      }
    }
    e.a().a(paramInt, localLinkedHashMap);
    a(paramContext, Integer.valueOf(paramInt), localLinkedHashMap);
  }
  
  private void b(Context paramContext)
  {
    com.tencent.smtt.sdk.a.c localc = new com.tencent.smtt.sdk.a.c();
    localc.a(com.tencent.smtt.utils.b.a(paramContext));
    localc.b(com.tencent.smtt.utils.b.c(paramContext));
    localc.a(Integer.valueOf(com.tencent.smtt.utils.b.b(paramContext)));
    localc.c(com.tencent.smtt.utils.b.a());
    Iterator localIterator = g.a().a(paramContext, "emergence_ids").iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext()) {
      try
      {
        Object localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = g.a((String)localObject);
          if ((localObject != null) && (localObject.length == 2))
          {
            int m = Integer.parseInt(localObject[0]);
            long l = Long.parseLong(localObject[1]);
            if (System.currentTimeMillis() < l) {
              localArrayList.add(Integer.valueOf(m));
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    localc.a(localArrayList);
    new com.tencent.smtt.sdk.a.e(paramContext, m.a(paramContext).g(), localc.a()).a(new c.1(this, paramContext));
  }
  
  public void a(Context paramContext)
  {
    if (!this.k)
    {
      this.k = true;
      g localg = g.a();
      if (!localg.b()) {
        localg.a(paramContext);
      }
    }
    else
    {
      try
      {
        long l1 = g.a().b(paramContext, "emergence_timestamp");
        long l2 = g.a().b(paramContext, "emergence_req_interval");
        long l3 = System.currentTimeMillis();
        if (l3 - l1 > Math.min(Math.max(this.i, l2), this.j))
        {
          g.a().a(paramContext, "emergence_timestamp", l3);
          b(paramContext);
        }
        for (;;)
        {
          return;
          a(paramContext, c, new ArrayList());
        }
        a(paramContext, f, new ArrayList());
      }
      catch (Exception localException)
      {
        a(paramContext, g, new ArrayList());
        return;
      }
      finally
      {
        g.a().c();
      }
    }
  }
  
  public void a(Context paramContext, Integer paramInteger, Map<Integer, String> paramMap)
  {
    TbsLog.e(a, "Dispatch emergency commands on tbs extension");
    QbSdk.a(paramContext, paramInteger, paramMap);
    paramContext = f.a(true);
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = paramContext.a();
    } while (paramContext == null);
    paramContext = paramContext.b();
    if (paramContext != null)
    {
      TbsLog.e(a, "Dispatch emergency commands on tbs shell");
      paramContext.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "dispatchEmergencyCommand", new Class[] { Integer.class, Map.class }, new Object[] { paramInteger, paramMap });
      return;
    }
    TbsLog.e(a, "Dex loader is null, cancel commands dispatching of tbs shell");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.c
 * JD-Core Version:    0.7.0.1
 */