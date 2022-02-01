package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.mobileqq.qqguildsdk.data.AppChnnPreFetchInfo;
import com.tencent.mobileqq.qqguildsdk.data.AppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class AppChannelMgr
{
  private List<IAppInfo> a = new ArrayList();
  private Map<String, AppChnnPreInfo> b = new ConcurrentHashMap();
  private Map<String, Vector<String>> c = new ConcurrentHashMap();
  
  public AppChnnPreInfo a(String paramString1, String paramString2)
  {
    if ((this.c.containsKey(paramString1)) && (this.b.containsKey(paramString2))) {
      return (AppChnnPreInfo)this.b.get(paramString2);
    }
    return null;
  }
  
  public List<IAppInfo> a()
  {
    return this.a;
  }
  
  public List<IAppChnnPreInfo> a(String paramString)
  {
    if (!this.c.containsKey(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramString = ((Vector)this.c.get(paramString)).iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if (this.b.containsKey(str)) {
        localArrayList.add(this.b.get(str));
      }
    }
    return localArrayList;
  }
  
  public List<IAppChnnPreInfo> a(String paramString, List<String> paramList)
  {
    if (!this.c.containsKey(paramString)) {
      return null;
    }
    paramString = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (this.b.containsKey(str)) {
        paramString.add(this.b.get(str));
      }
    }
    return paramString;
  }
  
  public List<AppChnnPreFetchInfo> a(String paramString, List<String> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      if (!this.b.containsKey(localObject))
      {
        localArrayList.add(new AppChnnPreFetchInfo(paramString, (String)localObject, ""));
      }
      else
      {
        localObject = (AppChnnPreInfo)this.b.get(localObject);
        if ((paramBoolean) || (l > ((AppChnnPreInfo)localObject).h()))
        {
          ((AppChnnPreInfo)localObject).i();
          localArrayList.add(((AppChnnPreInfo)localObject).l());
        }
      }
    }
    return localArrayList;
  }
  
  public void a(String paramString, List<AppChnnPreInfo> paramList, List<String> paramList1, List<String> paramList2)
  {
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      String str = (String)paramList2.next();
      this.b.remove(str);
    }
    if (paramList1.size() == 0)
    {
      this.c.remove(paramString);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramList2 = (AppChnnPreInfo)paramList.next();
      this.b.put(paramList2.b(), paramList2);
    }
    long l = System.currentTimeMillis();
    paramList = new Vector();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (String)paramList1.next();
      if (this.b.containsKey(paramList2))
      {
        paramList.add(paramList2);
        ((AppChnnPreInfo)this.b.get(paramList2)).a(l);
      }
    }
    this.c.put(paramString, paramList);
  }
  
  public void a(List<IAppInfo> paramList)
  {
    this.a = paramList;
  }
  
  public void b(String paramString)
  {
    if (!this.c.containsKey(paramString)) {
      return;
    }
    Iterator localIterator = ((Vector)this.c.get(paramString)).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.b.remove(str);
    }
    this.c.remove(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (!this.c.containsKey(paramString1)) {
      return;
    }
    ((Vector)this.c.get(paramString1)).remove(paramString2);
    this.b.remove(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.AppChannelMgr
 * JD-Core Version:    0.7.0.1
 */