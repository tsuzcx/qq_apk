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
    for (;;)
    {
      Object localObject;
      Class localClass;
      try
      {
        paramString = ((Map)Class.forName(paramString).getDeclaredField("sServicesMap").get(null)).entrySet().iterator();
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (Map.Entry)paramString.next();
        localClass = (Class)((Map.Entry)localObject).getKey();
        localObject = (IServiceEntry)((Map.Entry)localObject).getValue();
        IServiceEntry localIServiceEntry = (IServiceEntry)this.mServiceEntryMap.get(localClass);
        if (localIServiceEntry == null)
        {
          this.mServiceEntryMap.put(localClass, localObject);
          continue;
        }
        if (localIServiceEntry.getPriority() > ((IServiceEntry)localObject).getPriority()) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        RLog.w("RAServiceManager", new Object[] { "init entryMap error :" + paramString });
        return;
      }
      this.mServiceEntryMap.put(localClass, localObject);
    }
    RLog.d("RAServiceManager", new Object[] { "init success :" + this.mServiceEntryMap });
  }
  
  private void putToCache(String paramString, ServiceWrapper paramServiceWrapper)
  {
    if ((paramServiceWrapper.scope == RAFTConstants.Scope.SINGLETON) || (paramServiceWrapper.scope == RAFTConstants.Scope.LAZY_SINGLETON)) {
      this.mSingletonMap.put(paramString, paramServiceWrapper.service);
    }
    while (paramServiceWrapper.scope != RAFTConstants.Scope.WEAK_SINGLETON) {
      return;
    }
    this.mWeakSingletonMap.put(paramString, new WeakReference(paramServiceWrapper.service));
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
      RLog.w("RAServiceManager", new Object[] { "getService error :cannot found entry >> " + paramClass.getName() });
      return null;
    }
    String str = localIServiceEntry.getKey();
    paramClass = getFromCache(str);
    if (paramClass != null) {
      return paramClass;
    }
    if (paramIServiceProvider != null) {}
    for (paramClass = paramIServiceProvider.provide();; paramClass = localIServiceEntry.createService())
    {
      putToCache(str, paramClass);
      return paramClass.service;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftframework.service.RAServiceManager
 * JD-Core Version:    0.7.0.1
 */