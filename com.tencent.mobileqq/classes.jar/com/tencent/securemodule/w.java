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
      localHashMap.put(Long.valueOf(az.a(localAppInfo)), localAppInfo);
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
            ax.a("CloudScan", "find VIRUS ! " + localf.a + " type = " + localf.b + " name = " + localAppInfo.softName + " safeLevel = " + localf.c + " category = " + localf.d);
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
      f localf = (f)paramArrayList.next();
      if (localf.b == 3)
      {
        AppInfo localAppInfo = (AppInfo)this.b.get(Long.valueOf(localf.a));
        if (localAppInfo != null)
        {
          localArrayList.add(localAppInfo);
          ax.a("CloudScan", "find VIRUS ! " + localf.a + " type = " + localf.b + " name = " + localAppInfo.softName + " safeLevel = " + localf.c + " category = " + localf.d);
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
      f localf = (f)paramArrayList.next();
      ax.b("CloudScan", "collectDetailFeatureList app key =" + localf.a + " type = " + localf.b + " safeLevel = " + localf.c + " category = " + localf.d + " official = " + localf.e);
      if (localf.b == 6)
      {
        AppInfo localAppInfo = (AppInfo)this.b.get(Long.valueOf(localf.a));
        if (localAppInfo != null)
        {
          g localg = new g();
          localg.a = az.a(localAppInfo.getPkgName());
          localg.b = az.a(localAppInfo.getCertMd5());
          localg.c = ((int)localAppInfo.getFileSize());
          if (localAppInfo.getAppType() == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localg.g = bool;
            localg.f = az.a(localAppInfo.getSoftName());
            localg.d = az.a(localAppInfo.getVersionName());
            localg.e = localAppInfo.getVersionCode();
            localg.h = as.a(localAppInfo.apkPath);
            localArrayList.add(localg);
            ax.b("CloudScan", "detailFeatureList add app key =" + localf.a + " type = " + localf.b + " pkg =" + localAppInfo.getPkgName());
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
      ArrayList localArrayList;
      Object localObject2;
      try
      {
        paramy.a();
        l1 = System.currentTimeMillis();
        this.b = a(as.a(this.a, true));
        localArrayList = new ArrayList();
        localObject1 = this.b.entrySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          AppInfo localAppInfo = (AppInfo)((Map.Entry)localObject2).getValue();
          if ((localAppInfo == null) || (localAppInfo.getAppType() != 1)) {
            break label410;
          }
          bool = true;
          localArrayList.add(new d(((Long)((Map.Entry)localObject2).getKey()).longValue(), bool));
          continue;
        }
        localObject2 = new ArrayList();
      }
      finally {}
      Object localObject1 = new ArrayList();
      int i = ah.a(this.a).a(localArrayList, (ArrayList)localObject2);
      if (i == 0)
      {
        ax.b("CloudScan", "tinyCloudCheck finish,CloudResult size:" + ((ArrayList)localObject2).size());
        localObject1 = a((ArrayList)localObject2);
        localArrayList = d((ArrayList)localObject2);
        localObject2 = new ArrayList();
        i = ah.a(this.a).b(localArrayList, (ArrayList)localObject2);
        if (i == 0) {
          ax.b("CloudScanEngine", "cloudCheck result: size " + ((ArrayList)localObject2).size() + "\n" + ((ArrayList)localObject2).toString());
        }
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
          ax.a("CloudScanEngine", "cloud scan error " + i);
          continue;
          if (paramy != null) {
            paramy.a(i);
          }
          ax.a("CloudScanEngine", "cloud scan error " + i);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      label410:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.w
 * JD-Core Version:    0.7.0.1
 */