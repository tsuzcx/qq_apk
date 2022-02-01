package com.tencent.raft.codegenmeta.config;

import com.tencent.raft.codegenmeta.utils.Constants.ConfigFrom;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.raft.codegenmeta.utils.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RaftConfigsMeta
{
  private static final String TAG = "RaftConfigsMeta";
  private final Map<String, RaftConfigService> mConfigServices = new HashMap(64);
  private Map<String, Object> mDeclareBasics = new HashMap(32);
  private Map<String, Object> mDeclareCloud = new HashMap(32);
  private final LinkedHashMap<String, RaftConfigService> mDeclaresServices = new LinkedHashMap(32);
  
  private Map<String, Object> findMethodArgMap(RaftConfigService paramRaftConfigService, String paramString)
  {
    Iterator localIterator1 = paramRaftConfigService.methods.iterator();
    Object localObject = null;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Map)localIterator1.next()).entrySet().iterator();
      paramRaftConfigService = (RaftConfigService)localObject;
      for (;;)
      {
        localObject = paramRaftConfigService;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator2.next();
        if (((String)((Map.Entry)localObject).getKey()).equals(paramString)) {
          paramRaftConfigService = (Map)((Map.Entry)localObject).getValue();
        }
      }
    }
    return localObject;
  }
  
  private void initConfigServices(Map<String, Object> paramMap)
  {
    paramMap = (Map)paramMap.get("configs");
    if (paramMap != null)
    {
      paramMap = (List)paramMap.get("services");
      if (paramMap != null)
      {
        paramMap = paramMap.iterator();
        while (paramMap.hasNext())
        {
          Object localObject = (Map)paramMap.next();
          RaftConfigService localRaftConfigService = new RaftConfigService();
          localRaftConfigService.parse((Map)localObject);
          localObject = (RaftConfigService)this.mConfigServices.get(localRaftConfigService.getServiceKey());
          if ((localObject != null) && (((RaftConfigService)localObject).from == Constants.ConfigFrom.ANNOTATION)) {
            mergeArgFromAnnotation((RaftConfigService)localObject, localRaftConfigService);
          }
          this.mConfigServices.put(localRaftConfigService.getServiceKey(), localRaftConfigService);
        }
      }
    }
  }
  
  private void initDeclares(Map<String, Object> paramMap)
  {
    Map localMap2 = (Map)paramMap.get("declares");
    if (localMap2 != null)
    {
      paramMap = (Map)localMap2.get("basics");
      Map localMap1 = (Map)localMap2.get("cloud");
      localMap2 = (Map)localMap2.get("services");
      if (localMap2 != null)
      {
        Iterator localIterator = localMap2.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = localMap2.get(str);
          RaftConfigService localRaftConfigService = new RaftConfigService();
          localRaftConfigService.parse((Map)localObject);
          this.mDeclaresServices.put(str, localRaftConfigService);
        }
      }
      if (paramMap != null) {
        this.mDeclareBasics = paramMap;
      }
      if (localMap1 != null) {
        this.mDeclareCloud = localMap1;
      }
    }
  }
  
  private void replaceArgValueWithAnnotation(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if ((paramMap1 != null) && (paramMap2 != null))
    {
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        Object localObject = paramMap2.get(localEntry.getKey());
        if (localObject != null) {
          localEntry.setValue(localObject);
        }
      }
    }
  }
  
  public Map<String, Object> getAllDeclareConstant()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(this.mDeclareBasics);
      localHashMap.putAll(this.mDeclareCloud);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Map<String, RaftConfigService> getAllDeclareService()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = this.mDeclaresServices;
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public RaftConfigService getConfigService(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.mConfigServices != null))
      {
        paramString = (RaftConfigService)this.mConfigServices.get(paramString);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public Object getDeclareBasic(String paramString)
  {
    try
    {
      Map localMap = this.mDeclareBasics;
      if (localMap == null) {
        return null;
      }
      paramString = this.mDeclareBasics.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public Object getDeclareCloud(String paramString)
  {
    try
    {
      Map localMap = this.mDeclareCloud;
      if (localMap == null) {
        return null;
      }
      paramString = this.mDeclareCloud.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public RaftConfigService getDeclareService(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.mDeclaresServices != null))
      {
        paramString = (RaftConfigService)this.mDeclaresServices.get(paramString);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public void init(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      initDeclares(paramMap);
      initConfigServices(paramMap);
      paramMap = new StringBuilder();
      paramMap.append("init success! services:");
      paramMap.append(this.mConfigServices.size());
      RLog.d("RaftConfigsMeta", new Object[] { paramMap.toString() });
    }
  }
  
  public void mergeArgFromAnnotation(RaftConfigService paramRaftConfigService1, RaftConfigService paramRaftConfigService2)
  {
    if (paramRaftConfigService1 != null)
    {
      if (paramRaftConfigService2 == null) {
        return;
      }
      if (paramRaftConfigService1.scope != null) {
        paramRaftConfigService2.scope = paramRaftConfigService1.scope;
      }
      replaceArgValueWithAnnotation(paramRaftConfigService2.constructorArgs, paramRaftConfigService1.constructorArgs);
      replaceArgValueWithAnnotation(paramRaftConfigService2.factoryMethodArgs, paramRaftConfigService1.constructorArgs);
      replaceArgValueWithAnnotation(paramRaftConfigService2.properties, paramRaftConfigService1.constructorArgs);
      if ((paramRaftConfigService2.methods != null) && (paramRaftConfigService1.methods != null))
      {
        paramRaftConfigService2 = paramRaftConfigService2.methods.iterator();
        while (paramRaftConfigService2.hasNext())
        {
          Iterator localIterator = ((Map)paramRaftConfigService2.next()).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            String str = (String)localEntry.getKey();
            replaceArgValueWithAnnotation((Map)localEntry.getValue(), findMethodArgMap(paramRaftConfigService1, str));
          }
        }
      }
    }
  }
  
  public void updateServiceByAnnotation(RaftConfigService paramRaftConfigService)
  {
    try
    {
      Map localMap = this.mConfigServices;
      if (localMap == null) {
        return;
      }
      this.mConfigServices.put(paramRaftConfigService.getServiceKey(), paramRaftConfigService);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.config.RaftConfigsMeta
 * JD-Core Version:    0.7.0.1
 */