package com.tencent.securemodule;

import android.content.Context;
import com.tencent.securemodule.impl.AppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class w
{
  private Context a;
  private Map<Long, AppInfo> b;
  
  public w(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap();
  }
  
  private ArrayList<AppInfo> a(ArrayList<f> paramArrayList)
  {
    if (at.a(this.a, 30003, 6) == 6) {
      return c(paramArrayList);
    }
    return b(paramArrayList);
  }
  
  private HashMap<Long, AppInfo> a(List<AppInfo> paramList)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      AppInfo localAppInfo = (AppInfo)paramList.get(i);
      localHashMap.put(Long.valueOf(ax.a(localAppInfo)), localAppInfo);
      i += 1;
    }
    return localHashMap;
  }
  
  private ArrayList<AppInfo> b(ArrayList<f> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      f localf = (f)paramArrayList.next();
      if ((localf.b != 1) && (localf.b != 6) && (localf.b != 0))
      {
        AppInfo localAppInfo = (AppInfo)this.b.get(Long.valueOf(localf.a));
        if (localAppInfo != null)
        {
          if ((localf.b == 9) || ((localf.d & 0x200) == 512)) {
            localAppInfo.safeType = 4;
          }
          for (;;)
          {
            localAppInfo.safeLevel = localf.c;
            localAppInfo.isOfficial = localf.e;
            localArrayList.add(localAppInfo);
            break;
            if (localf.c == 1) {
              localAppInfo.safeType = 2;
            } else if (localf.b == 10) {
              localAppInfo.safeType = 3;
            } else {
              localAppInfo.safeType = 5;
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private ArrayList<AppInfo> c(ArrayList<f> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (f)paramArrayList.next();
      if (((f)localObject).b == 3)
      {
        localObject = (AppInfo)this.b.get(Long.valueOf(((f)localObject).a));
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private ArrayList<g> d(ArrayList<f> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (f)paramArrayList.next();
      if (((f)localObject).b == 6)
      {
        localObject = (AppInfo)this.b.get(Long.valueOf(((f)localObject).a));
        if (localObject != null)
        {
          g localg = new g();
          localg.a = ax.a(((AppInfo)localObject).getPkgName());
          localg.b = ax.a(((AppInfo)localObject).getCertMd5());
          localg.c = ((int)((AppInfo)localObject).getFileSize());
          if (((AppInfo)localObject).getAppType() == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localg.g = bool;
            localg.f = ax.a(((AppInfo)localObject).getSoftName());
            localg.d = ax.a(((AppInfo)localObject).getVersionName());
            localg.e = ((AppInfo)localObject).getVersionCode();
            localg.h = as.a(((AppInfo)localObject).apkPath);
            localArrayList.add(localg);
            break;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(y paramy)
  {
    if (paramy != null) {}
    for (;;)
    {
      long l1;
      Object localObject1;
      Object localObject3;
      try
      {
        paramy.a();
        l1 = System.currentTimeMillis();
        this.b = a(as.a(this.a, true));
        localObject1 = new ArrayList();
        localObject2 = this.b.entrySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          AppInfo localAppInfo = (AppInfo)((Map.Entry)localObject3).getValue();
          if ((localAppInfo == null) || (localAppInfo.getAppType() != 1)) {
            break label288;
          }
          bool = true;
          ((ArrayList)localObject1).add(new d(((Long)((Map.Entry)localObject3).getKey()).longValue(), bool));
          continue;
        }
        localObject3 = new ArrayList();
      }
      finally {}
      Object localObject2 = new ArrayList();
      int i = ah.a(this.a).a((ArrayList)localObject1, (ArrayList)localObject3);
      if (i == 0)
      {
        localObject1 = a((ArrayList)localObject3);
        localObject2 = d((ArrayList)localObject3);
        localObject3 = new ArrayList();
        if (ah.a(this.a).b((ArrayList)localObject2, (ArrayList)localObject3) != 0) {}
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        l1 = 5000L - (l2 - l1);
        if (l1 > 0L) {}
        try
        {
          Thread.sleep(l1);
          if (paramy != null) {
            paramy.a((ArrayList)localObject1);
          }
          return;
          localObject1 = localObject2;
          if (paramy != null)
          {
            paramy.a(i);
            localObject1 = localObject2;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      label288:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.securemodule.w
 * JD-Core Version:    0.7.0.1
 */