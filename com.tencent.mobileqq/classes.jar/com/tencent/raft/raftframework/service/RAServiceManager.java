package com.tencent.raft.raftframework.service;

import com.tencent.raft.raftframework.IServiceProvider;
import com.tencent.raft.raftframework.constant.RAFTConstants.Scope;
import com.tencent.raft.raftframework.log.RLog;
import com.tencent.raft.raftframework.service.api.IServiceEntry;
import com.tencent.raft.raftframework.service.api.ServiceWrapper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RAServiceManager
  implements IRAServiceManager
{
  public static final String TAG = "RAServiceManager";
  private HashMap<Class<?>, IServiceEntry> mServiceEntryMap = new HashMap();
  private HashMap<String, Object> mSingletonMap = new HashMap();
  private HashMap<String, WeakReference<Object>> mWeakSingletonMap = new HashMap();
  
  public RAServiceManager(String paramString)
  {
    init(paramString);
  }
  
  private Object getFromCache(String paramString)
  {
    if (this.mSingletonMap.containsKey(paramString)) {
      return this.mSingletonMap.get(paramString);
    }
    if (this.mWeakSingletonMap.containsKey(paramString))
    {
      paramString = (WeakReference)this.mWeakSingletonMap.get(paramString);
      if ((paramString != null) && (paramString.get() != null)) {
        return paramString.get();
      }
    }
    return null;
  }
  
  private void init(String paramString)
  {
    RLog.d("RAServiceManager", new Object[] { "init ..." });
    try
    {
      paramString = ((Map)Class.forName(paramString).getDeclaredField("sServicesMap").get(null)).entrySet().iterator();
      while (paramString.hasNext())
      {
        Object localObject2 = (Map.Entry)paramString.next();
        localObject1 = (Class)((Map.Entry)localObject2).getKey();
        localObject2 = (IServiceEntry)((Map.Entry)localObject2).getValue();
        IServiceEntry localIServiceEntry = (IServiceEntry)this.mServiceEntryMap.get(localObject1);
        if (localIServiceEntry == null) {
          this.mServiceEntryMap.put(localObject1, localObject2);
        } else if (localIServiceEntry.getPriority() <= ((IServiceEntry)localObject2).getPriority()) {
          this.mServiceEntryMap.put(localObject1, localObject2);
        }
      }
      paramString = new StringBuilder();
      paramString.append("init success :");
      paramString.append(this.mServiceEntryMap);
      RLog.d("RAServiceManager", new Object[] { paramString.toString() });
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("init entryMap error :");
      ((StringBuilder)localObject1).append(paramString);
      RLog.w("RAServiceManager", new Object[] { ((StringBuilder)localObject1).toString() });
    }
  }
  
  private void putToCache(String paramString, ServiceWrapper paramServiceWrapper)
  {
    if ((paramServiceWrapper.scope != RAFTConstants.Scope.SINGLETON) && (paramServiceWrapper.scope != RAFTConstants.Scope.LAZY_SINGLETON))
    {
      if (paramServiceWrapper.scope == RAFTConstants.Scope.WEAK_SINGLETON) {
        this.mWeakSingletonMap.put(paramString, new WeakReference(paramServiceWrapper.service));
      }
    }
    else {
      this.mSingletonMap.put(paramString, paramServiceWrapper.service);
    }
  }
  
  public void destroy()
  {
    this.mServiceEntryMap.clear();
    this.mSingletonMap.clear();
    this.mWeakSingletonMap.clear();
  }
  
  public <T> T getService(Class<T> paramClass, IServiceProvider paramIServiceProvider)
  {
    IServiceEntry localIServiceEntry = (IServiceEntry)this.mServiceEntryMap.get(paramClass);
    if (localIServiceEntry == null)
    {
      paramIServiceProvider = new StringBuilder();
      paramIServiceProvider.append("getService error :cannot found entry >> ");
      paramIServiceProvider.append(paramClass.getName());
      RLog.w("RAServiceManager", new Object[] { paramIServiceProvider.toString() });
      return null;
    }
    String str = localIServiceEntry.getKey();
    paramClass = getFromCache(str);
    if (paramClass != null) {
      return paramClass;
    }
    if (paramIServiceProvider != null) {
      paramClass = paramIServiceProvider.provide();
    } else {
      paramClass = localIServiceEntry.createService();
    }
    putToCache(str, paramClass);
    return paramClass.service;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.raft.raftframework.service.RAServiceManager
 * JD-Core Version:    0.7.0.1
 */