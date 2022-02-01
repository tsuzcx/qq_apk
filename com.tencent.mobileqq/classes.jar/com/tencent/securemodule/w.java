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
          int i;
          if ((localf.b != 9) && ((localf.d & 0x200) != 512))
          {
            if (localf.c == 1) {
              i = 2;
            } else if (localf.b == 10) {
              i = 3;
            } else {
              i = 5;
            }
          }
          else {
            i = 4;
          }
          localAppInfo.safeType = i;
          localAppInfo.safeLevel = localf.c;
          localAppInfo.isOfficial = localf.e;
          localArrayList.add(localAppInfo);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("find VIRUS ! ");
          localStringBuilder.append(localf.a);
          localStringBuilder.append(" type = ");
          localStringBuilder.append(localf.b);
          localStringBuilder.append(" name = ");
          localStringBuilder.append(localAppInfo.softName);
          localStringBuilder.append(" safeLevel = ");
          localStringBuilder.append(localf.c);
          localStringBuilder.append(" category = ");
          localStringBuilder.append(localf.d);
          ax.a("CloudScan", localStringBuilder.toString());
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("find VIRUS ! ");
          localStringBuilder.append(localf.a);
          localStringBuilder.append(" type = ");
          localStringBuilder.append(localf.b);
          localStringBuilder.append(" name = ");
          localStringBuilder.append(localAppInfo.softName);
          localStringBuilder.append(" safeLevel = ");
          localStringBuilder.append(localf.c);
          localStringBuilder.append(" category = ");
          localStringBuilder.append(localf.d);
          ax.a("CloudScan", localStringBuilder.toString());
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("collectDetailFeatureList app key =");
      ((StringBuilder)localObject1).append(localf.a);
      ((StringBuilder)localObject1).append(" type = ");
      ((StringBuilder)localObject1).append(localf.b);
      ((StringBuilder)localObject1).append(" safeLevel = ");
      ((StringBuilder)localObject1).append(localf.c);
      ((StringBuilder)localObject1).append(" category = ");
      ((StringBuilder)localObject1).append(localf.d);
      ((StringBuilder)localObject1).append(" official = ");
      ((StringBuilder)localObject1).append(localf.e);
      ax.b("CloudScan", ((StringBuilder)localObject1).toString());
      if (localf.b == 6)
      {
        localObject1 = (AppInfo)this.b.get(Long.valueOf(localf.a));
        if (localObject1 != null)
        {
          Object localObject2 = new g();
          ((g)localObject2).a = az.a(((AppInfo)localObject1).getPkgName());
          ((g)localObject2).b = az.a(((AppInfo)localObject1).getCertMd5());
          ((g)localObject2).c = ((int)((AppInfo)localObject1).getFileSize());
          int i = ((AppInfo)localObject1).getAppType();
          boolean bool = true;
          if (i != 1) {
            bool = false;
          }
          ((g)localObject2).g = bool;
          ((g)localObject2).f = az.a(((AppInfo)localObject1).getSoftName());
          ((g)localObject2).d = az.a(((AppInfo)localObject1).getVersionName());
          ((g)localObject2).e = ((AppInfo)localObject1).getVersionCode();
          ((g)localObject2).h = as.a(((AppInfo)localObject1).apkPath);
          localArrayList.add(localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("detailFeatureList add app key =");
          ((StringBuilder)localObject2).append(localf.a);
          ((StringBuilder)localObject2).append(" type = ");
          ((StringBuilder)localObject2).append(localf.b);
          ((StringBuilder)localObject2).append(" pkg =");
          ((StringBuilder)localObject2).append(((AppInfo)localObject1).getPkgName());
          ax.b("CloudScan", ((StringBuilder)localObject2).toString());
        }
      }
    }
    return localArrayList;
  }
  
  public void a(y paramy)
  {
    if (paramy != null) {}
    try
    {
      paramy.a();
      long l1 = System.currentTimeMillis();
      this.b = a(as.a(this.a, true));
      Object localObject2 = new ArrayList();
      Object localObject1 = this.b.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        AppInfo localAppInfo = (AppInfo)((Map.Entry)localObject3).getValue();
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localAppInfo != null)
        {
          bool1 = bool2;
          if (localAppInfo.getAppType() == 1) {
            bool1 = true;
          }
        }
        ((ArrayList)localObject2).add(new d(((Long)((Map.Entry)localObject3).getKey()).longValue(), bool1));
      }
      Object localObject3 = new ArrayList();
      localObject1 = new ArrayList();
      int i = ah.a(this.a).a((ArrayList)localObject2, (ArrayList)localObject3);
      if (i == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("tinyCloudCheck finish,CloudResult size:");
        ((StringBuilder)localObject1).append(((ArrayList)localObject3).size());
        ax.b("CloudScan", ((StringBuilder)localObject1).toString());
        localObject1 = a((ArrayList)localObject3);
        localObject3 = d((ArrayList)localObject3);
        localObject2 = new ArrayList();
        i = ah.a(this.a).b((ArrayList)localObject3, (ArrayList)localObject2);
        if (i == 0)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("cloudCheck result: size ");
          ((StringBuilder)localObject3).append(((ArrayList)localObject2).size());
          ((StringBuilder)localObject3).append("\n");
          ((StringBuilder)localObject3).append(((ArrayList)localObject2).toString());
          ax.b("CloudScanEngine", ((StringBuilder)localObject3).toString());
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("cloud scan error ");
          ((StringBuilder)localObject2).append(i);
        }
      }
      else
      {
        for (localObject2 = ((StringBuilder)localObject2).toString();; localObject2 = ((StringBuilder)localObject2).toString())
        {
          ax.a("CloudScanEngine", localObject2);
          break;
          if (paramy != null) {
            paramy.a(i);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("cloud scan error ");
          ((StringBuilder)localObject2).append(i);
        }
      }
      long l2 = System.currentTimeMillis();
      l1 = 5000L - (l2 - l1);
      if (l1 > 0L) {
        try
        {
          Thread.sleep(l1);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (paramy != null) {
        paramy.a((ArrayList)localObject1);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.w
 * JD-Core Version:    0.7.0.1
 */