package com.tencent.raft.codegenmeta.config;

import com.tencent.raft.codegenmeta.utils.Constants.ConfigFrom;
import com.tencent.raft.codegenmeta.utils.RLog;
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
    Object localObject = null;
    Iterator localIterator1 = paramRaftConfigService.methods.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Map)localIterator1.next()).entrySet().iterator();
      paramRaftConfigService = (RaftConfigService)localObject;
      localObject = paramRaftConfigService;
      if (localIterator2.hasNext())
      {
        localObject = (Map.Entry)localIterator2.next();
        if (!((String)((Map.Entry)localObject).getKey()).equals(paramString)) {
          break label101;
        }
        paramRaftConfigService = (Map)((Map.Entry)localObject).getValue();
      }
    }
    label101:
    for (;;)
    {
      break;
      return localObject;
    }
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
  
  /* Error */
  public RaftConfigService getConfigService(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 157	com/tencent/raft/codegenmeta/utils/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +12 -> 18
    //   9: aload_0
    //   10: getfield 28	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mConfigServices	Ljava/util/Map;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: getfield 28	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mConfigServices	Ljava/util/Map;
    //   28: aload_1
    //   29: invokeinterface 95 2 0
    //   34: checkcast 42	com/tencent/raft/codegenmeta/config/RaftConfigService
    //   37: astore_1
    //   38: goto -18 -> 20
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	RaftConfigsMeta
    //   0	46	1	paramString	String
    //   13	2	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	14	41	finally
    //   24	38	41	finally
  }
  
  /* Error */
  public Object getDeclareBasic(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mDeclareBasics	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 35	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mDeclareBasics	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 95 2 0
    //   27: astore_1
    //   28: goto -15 -> 13
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	RaftConfigsMeta
    //   0	36	1	paramString	String
    //   6	2	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   17	28	31	finally
  }
  
  /* Error */
  public Object getDeclareCloud(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mDeclareCloud	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 37	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mDeclareCloud	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 95 2 0
    //   27: astore_1
    //   28: goto -15 -> 13
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	RaftConfigsMeta
    //   0	36	1	paramString	String
    //   6	2	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   17	28	31	finally
  }
  
  /* Error */
  public RaftConfigService getDeclareService(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 157	com/tencent/raft/codegenmeta/utils/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +12 -> 18
    //   9: aload_0
    //   10: getfield 33	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mDeclaresServices	Ljava/util/LinkedHashMap;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: getfield 33	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mDeclaresServices	Ljava/util/LinkedHashMap;
    //   28: aload_1
    //   29: invokevirtual 162	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 42	com/tencent/raft/codegenmeta/config/RaftConfigService
    //   35: astore_1
    //   36: goto -16 -> 20
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	RaftConfigsMeta
    //   0	44	1	paramString	String
    //   13	2	2	localLinkedHashMap	LinkedHashMap
    // Exception table:
    //   from	to	target	type
    //   2	14	39	finally
    //   24	36	39	finally
  }
  
  public void init(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      initDeclares(paramMap);
      initConfigServices(paramMap);
      RLog.d("RaftConfigsMeta", new Object[] { "init success! services:" + this.mConfigServices.size() });
    }
  }
  
  public void mergeArgFromAnnotation(RaftConfigService paramRaftConfigService1, RaftConfigService paramRaftConfigService2)
  {
    if ((paramRaftConfigService1 == null) || (paramRaftConfigService2 == null)) {}
    do
    {
      return;
      if (paramRaftConfigService1.scope != null) {
        paramRaftConfigService2.scope = paramRaftConfigService1.scope;
      }
      replaceArgValueWithAnnotation(paramRaftConfigService2.constructorArgs, paramRaftConfigService1.constructorArgs);
      replaceArgValueWithAnnotation(paramRaftConfigService2.factoryMethodArgs, paramRaftConfigService1.constructorArgs);
      replaceArgValueWithAnnotation(paramRaftConfigService2.properties, paramRaftConfigService1.constructorArgs);
    } while ((paramRaftConfigService2.methods == null) || (paramRaftConfigService1.methods == null));
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
  
  /* Error */
  public void updateServiceByAnnotation(RaftConfigService paramRaftConfigService)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mConfigServices	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 28	com/tencent/raft/codegenmeta/config/RaftConfigsMeta:mConfigServices	Ljava/util/Map;
    //   18: aload_1
    //   19: invokevirtual 105	com/tencent/raft/codegenmeta/config/RaftConfigService:getServiceKey	()Ljava/lang/String;
    //   22: aload_1
    //   23: invokeinterface 122 3 0
    //   28: pop
    //   29: goto -18 -> 11
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	RaftConfigsMeta
    //   0	37	1	paramRaftConfigService	RaftConfigService
    //   6	2	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   14	29	32	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.config.RaftConfigsMeta
 * JD-Core Version:    0.7.0.1
 */