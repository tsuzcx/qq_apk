package com.tencent.raft.raftframework.declare;

import com.tencent.raft.raftframework.log.RLog;
import com.tencent.raft.raftframework.service.api.IServiceEntry;
import com.tencent.raft.raftframework.service.api.ServiceWrapper;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RADeclareManager
  implements IRADeclareManager
{
  public static final String TAG = "RADeclareManager";
  private Map<String, String> mDeclareConstants = new HashMap();
  private Map<String, Object> mDeclareServiceCache = new HashMap();
  private Map<String, IServiceEntry> mServiceEntryMap = new HashMap();
  
  public RADeclareManager(String paramString)
  {
    init(paramString);
  }
  
  private void init(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      localObject1 = ((Map)paramString.getDeclaredField("sDeclareMap").get(null)).entrySet().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (IServiceEntry)((Map.Entry)localObject3).getValue();
        IServiceEntry localIServiceEntry = (IServiceEntry)this.mServiceEntryMap.get(localObject2);
        if (localIServiceEntry == null) {
          this.mServiceEntryMap.put(localObject2, localObject3);
        } else if (localIServiceEntry.getPriority() < ((IServiceEntry)localObject3).getPriority()) {
          this.mServiceEntryMap.put(localObject2, localObject3);
        }
      }
      paramString = ((Map)paramString.getDeclaredField("sConstantMap").get(null)).entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject2 = (Map.Entry)paramString.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        if (!this.mDeclareConstants.containsKey(localObject1)) {
          this.mDeclareConstants.put(localObject1, localObject2);
        }
      }
      paramString = new StringBuilder();
      paramString.append("init success :");
      paramString.append(this.mServiceEntryMap);
      RLog.d("RADeclareManager", new Object[] { paramString.toString() });
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("init entryMap error :");
      ((StringBuilder)localObject1).append(paramString);
      RLog.w("RADeclareManager", new Object[] { ((StringBuilder)localObject1).toString() });
    }
  }
  
  public void destroy()
  {
    this.mDeclareServiceCache.clear();
    this.mServiceEntryMap.clear();
    this.mDeclareConstants.clear();
  }
  
  public String getDeclareConstant(String paramString)
  {
    return (String)this.mDeclareConstants.get(paramString);
  }
  
  public Object getDeclareService(String paramString)
  {
    if (this.mDeclareServiceCache.containsKey(paramString)) {
      return this.mDeclareServiceCache.get(paramString);
    }
    Object localObject = (IServiceEntry)this.mServiceEntryMap.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot found declare >> ");
      ((StringBuilder)localObject).append(paramString);
      RLog.w("RADeclareManager", new Object[] { ((StringBuilder)localObject).toString() });
      return null;
    }
    localObject = ((IServiceEntry)localObject).createService().service;
    this.mDeclareServiceCache.put(paramString, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.raftframework.declare.RADeclareManager
 * JD-Core Version:    0.7.0.1
 */