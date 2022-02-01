package com.tencent.mobileqq.troop.managerfactory.api.impl;

import com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public final class ManagerFactoryServiceImpl
  implements IManagerFactoryService
{
  private static final String TAG = "ManagerFactoryImpl";
  private AppRuntime mAppRuntime;
  private ConcurrentHashMap<Class, Object> managerLocks = new ConcurrentHashMap();
  private ConcurrentHashMap<Class, Manager> managers = new ConcurrentHashMap();
  
  /* Error */
  private <T extends Manager> T createManager(Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/mobileqq/troop/managerfactory/api/impl/ManagerFactoryServiceImpl:managerLocks	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: aload_1
    //   5: invokevirtual 43	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: ifnonnull +47 -> 55
    //   11: aload_0
    //   12: getfield 28	com/tencent/mobileqq/troop/managerfactory/api/impl/ManagerFactoryServiceImpl:managerLocks	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: astore_2
    //   16: aload_2
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 28	com/tencent/mobileqq/troop/managerfactory/api/impl/ManagerFactoryServiceImpl:managerLocks	Ljava/util/concurrent/ConcurrentHashMap;
    //   22: aload_1
    //   23: invokevirtual 43	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: ifnonnull +19 -> 45
    //   29: aload_0
    //   30: getfield 28	com/tencent/mobileqq/troop/managerfactory/api/impl/ManagerFactoryServiceImpl:managerLocks	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: aload_1
    //   34: new 4	java/lang/Object
    //   37: dup
    //   38: invokespecial 21	java/lang/Object:<init>	()V
    //   41: invokevirtual 47	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_2
    //   46: monitorexit
    //   47: goto +8 -> 55
    //   50: astore_1
    //   51: aload_2
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: aload_0
    //   56: getfield 28	com/tencent/mobileqq/troop/managerfactory/api/impl/ManagerFactoryServiceImpl:managerLocks	Ljava/util/concurrent/ConcurrentHashMap;
    //   59: aload_1
    //   60: invokevirtual 43	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: astore 4
    //   65: aload 4
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield 26	com/tencent/mobileqq/troop/managerfactory/api/impl/ManagerFactoryServiceImpl:managers	Ljava/util/concurrent/ConcurrentHashMap;
    //   72: aload_1
    //   73: invokevirtual 43	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: checkcast 49	mqq/manager/Manager
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull +8 -> 89
    //   84: aload 4
    //   86: monitorexit
    //   87: aload_3
    //   88: areturn
    //   89: aload_1
    //   90: iconst_1
    //   91: anewarray 51	java/lang/Class
    //   94: dup
    //   95: iconst_0
    //   96: ldc 53
    //   98: aastore
    //   99: invokevirtual 57	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   102: astore_2
    //   103: aload_2
    //   104: iconst_1
    //   105: invokevirtual 63	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   108: aload_2
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_0
    //   116: getfield 65	com/tencent/mobileqq/troop/managerfactory/api/impl/ManagerFactoryServiceImpl:mAppRuntime	Lmqq/app/AppRuntime;
    //   119: aastore
    //   120: invokevirtual 69	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 49	mqq/manager/Manager
    //   126: astore_2
    //   127: aload_2
    //   128: astore_3
    //   129: aload_2
    //   130: ifnull +142 -> 272
    //   133: aload_0
    //   134: getfield 26	com/tencent/mobileqq/troop/managerfactory/api/impl/ManagerFactoryServiceImpl:managers	Ljava/util/concurrent/ConcurrentHashMap;
    //   137: aload_1
    //   138: aload_2
    //   139: invokevirtual 47	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_2
    //   144: astore_3
    //   145: goto +127 -> 272
    //   148: astore_1
    //   149: goto +18 -> 167
    //   152: astore_1
    //   153: goto +41 -> 194
    //   156: astore_1
    //   157: goto +64 -> 221
    //   160: astore_1
    //   161: goto +87 -> 248
    //   164: astore_1
    //   165: aload_3
    //   166: astore_2
    //   167: ldc 10
    //   169: iconst_1
    //   170: iconst_2
    //   171: anewarray 4	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: ldc 71
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload_1
    //   182: invokevirtual 75	java/lang/reflect/InvocationTargetException:toString	()Ljava/lang/String;
    //   185: aastore
    //   186: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   189: aload_2
    //   190: astore_3
    //   191: goto +81 -> 272
    //   194: ldc 10
    //   196: iconst_1
    //   197: iconst_2
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: ldc 83
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_1
    //   209: invokevirtual 84	java/lang/NoSuchMethodException:toString	()Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   216: aload_2
    //   217: astore_3
    //   218: goto +54 -> 272
    //   221: ldc 10
    //   223: iconst_1
    //   224: iconst_2
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: ldc 86
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: aload_1
    //   236: invokevirtual 87	java/lang/InstantiationException:toString	()Ljava/lang/String;
    //   239: aastore
    //   240: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   243: aload_2
    //   244: astore_3
    //   245: goto +27 -> 272
    //   248: ldc 10
    //   250: iconst_1
    //   251: iconst_2
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: ldc 89
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: aload_1
    //   263: invokevirtual 90	java/lang/IllegalAccessException:toString	()Ljava/lang/String;
    //   266: aastore
    //   267: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   270: aload_2
    //   271: astore_3
    //   272: aload 4
    //   274: monitorexit
    //   275: aload_3
    //   276: areturn
    //   277: astore_1
    //   278: aload 4
    //   280: monitorexit
    //   281: aload_1
    //   282: athrow
    //   283: astore_1
    //   284: aload_3
    //   285: astore_2
    //   286: goto -92 -> 194
    //   289: astore_1
    //   290: aload_3
    //   291: astore_2
    //   292: goto -71 -> 221
    //   295: astore_1
    //   296: aload_3
    //   297: astore_2
    //   298: goto -50 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	ManagerFactoryServiceImpl
    //   0	301	1	paramClass	Class<T>
    //   79	218	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	45	50	finally
    //   45	47	50	finally
    //   51	53	50	finally
    //   133	143	148	java/lang/reflect/InvocationTargetException
    //   133	143	152	java/lang/NoSuchMethodException
    //   133	143	156	java/lang/InstantiationException
    //   133	143	160	java/lang/IllegalAccessException
    //   89	127	164	java/lang/reflect/InvocationTargetException
    //   68	80	277	finally
    //   84	87	277	finally
    //   89	127	277	finally
    //   133	143	277	finally
    //   167	189	277	finally
    //   194	216	277	finally
    //   221	243	277	finally
    //   248	270	277	finally
    //   272	275	277	finally
    //   278	281	277	finally
    //   89	127	283	java/lang/NoSuchMethodException
    //   89	127	289	java/lang/InstantiationException
    //   89	127	295	java/lang/IllegalAccessException
  }
  
  public <T extends Manager> T getManager(Class<T> paramClass)
  {
    Object localObject = (Manager)this.managers.get(paramClass);
    if (localObject != null) {
      return localObject;
    }
    localObject = createManager(paramClass);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("build Manager service fatal api:");
    ((StringBuilder)localObject).append(paramClass.getSimpleName());
    QLog.e("ManagerFactoryImpl", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("build Manager fatal api:");
    ((StringBuilder)localObject).append(paramClass.getSimpleName());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.managers.values().iterator();
    while (localIterator.hasNext()) {
      ((Manager)localIterator.next()).onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.managerfactory.api.impl.ManagerFactoryServiceImpl
 * JD-Core Version:    0.7.0.1
 */