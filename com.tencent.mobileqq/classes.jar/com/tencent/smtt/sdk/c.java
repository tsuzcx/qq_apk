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
  private Context i;
  private long j = 60000L;
  private long k = 86400000L;
  private boolean l = false;
  private DexLoader m;
  
  private c(Context paramContext)
  {
    this.i = paramContext;
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (h == null) {
        h = new c(paramContext);
      }
      paramContext = h;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt, List<com.tencent.smtt.sdk.a.b> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    g localg = g.a();
    Object localObject = localg.a(this.i, "emergence_ids");
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
      int n = ((com.tencent.smtt.sdk.a.b)localObject).b();
      int i1 = ((com.tencent.smtt.sdk.a.b)localObject).a();
      if ((!localHashSet.contains(Integer.valueOf(i1))) && (!((com.tencent.smtt.sdk.a.b)localObject).e()))
      {
        localLinkedHashMap.put(Integer.valueOf(n), ((com.tencent.smtt.sdk.a.b)localObject).c());
        localObject = g.a(new String[] { String.valueOf(i1), String.valueOf(((com.tencent.smtt.sdk.a.b)localObject).d()) });
        localg.a(this.i, "emergence_ids", (String)localObject);
      }
    }
    e.a().a(paramInt, localLinkedHashMap);
    a(Integer.valueOf(paramInt), localLinkedHashMap);
  }
  
  private void e()
  {
    com.tencent.smtt.sdk.a.c localc = new com.tencent.smtt.sdk.a.c();
    localc.a(com.tencent.smtt.utils.b.a(this.i));
    localc.b(com.tencent.smtt.utils.b.c(this.i));
    localc.a(Integer.valueOf(com.tencent.smtt.utils.b.b(this.i)));
    localc.c(com.tencent.smtt.utils.b.a());
    Iterator localIterator = g.a().a(this.i, "emergence_ids").iterator();
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
            int n = Integer.parseInt(localObject[0]);
            long l1 = Long.parseLong(localObject[1]);
            if (System.currentTimeMillis() < l1) {
              localArrayList.add(Integer.valueOf(n));
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
    new com.tencent.smtt.sdk.a.e(this.i, m.a(this.i).g(), localc.a()).a(new c.1(this));
  }
  
  public void a()
  {
    if (!this.l)
    {
      this.l = true;
      g localg = g.a();
      if (!localg.b()) {
        localg.a(this.i);
      }
    }
    else
    {
      try
      {
        long l1 = g.a().b(this.i, "emergence_timestamp");
        long l2 = g.a().b(this.i, "emergence_req_interval");
        long l3 = System.currentTimeMillis();
        if (l3 - l1 > Math.min(Math.max(this.j, l2), this.k))
        {
          g.a().a(this.i, "emergence_timestamp", l3);
          e();
        }
        for (;;)
        {
          return;
          a(c, new ArrayList());
        }
        a(f, new ArrayList());
      }
      catch (Exception localException)
      {
        a(g, new ArrayList());
        return;
      }
      finally
      {
        g.a().c();
      }
    }
  }
  
  public void a(DexLoader paramDexLoader)
  {
    this.m = paramDexLoader;
  }
  
  public void a(Integer paramInteger, Map<Integer, String> paramMap)
  {
    if (this.m != null)
    {
      TbsLog.e(a, "Dispatch emergency commands on tbs shell");
      this.m.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "dispatchEmergencyCommand", new Class[] { Integer.class, Map.class }, new Object[] { paramInteger, paramMap });
    }
    for (;;)
    {
      TbsLog.e(a, "Dispatch emergency commands on tbs extension");
      QbSdk.a(this.i, paramInteger, paramMap);
      return;
      TbsLog.e(a, "Dex loader is null, cancel commands dispatching of tbs shell");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.c
 * JD-Core Version:    0.7.0.1
 */