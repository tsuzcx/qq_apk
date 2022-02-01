package com.tencent.qqmini.sdk.core.proxy.engine;

import java.util.HashMap;
import java.util.Map;

public class ProxyServiceEngine
{
  private static final String TAG = "ProxyServiceEngine";
  private static final ProxyServiceEngine sInstance = new ProxyServiceEngine();
  private Map<Class, Object> mActivatedServices = new HashMap();
  private Map<Class, Class> mProxyServicesMap = ProxyServiceList.get();
  
  public static ProxyServiceEngine g()
  {
    return sInstance;
  }
  
  /* Error */
  public Object getProxyService(Class paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	com/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine:mProxyServicesMap	Ljava/util/Map;
    //   4: aload_1
    //   5: invokeinterface 48 2 0
    //   10: checkcast 50	java/lang/Class
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +29 -> 44
    //   18: ldc 8
    //   20: new 52	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   27: ldc 55
    //   29: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aconst_null
    //   43: areturn
    //   44: aload_0
    //   45: getfield 37	com/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine:mActivatedServices	Ljava/util/Map;
    //   48: aload_3
    //   49: invokeinterface 48 2 0
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull +5 -> 61
    //   59: aload_2
    //   60: areturn
    //   61: aload_0
    //   62: monitorenter
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: ifnonnull +84 -> 150
    //   69: aload_2
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 76	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   75: astore_2
    //   76: aload_2
    //   77: astore_1
    //   78: ldc 8
    //   80: new 52	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   87: ldc 78
    //   89: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_3
    //   93: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 81	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_2
    //   103: astore_1
    //   104: aload_0
    //   105: getfield 37	com/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine:mActivatedServices	Ljava/util/Map;
    //   108: aload_3
    //   109: aload_2
    //   110: invokeinterface 85 3 0
    //   115: pop
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_2
    //   119: areturn
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    //   125: astore_2
    //   126: ldc 8
    //   128: new 52	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   135: ldc 87
    //   137: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_3
    //   141: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 90	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_1
    //   151: astore_2
    //   152: goto -36 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	ProxyServiceEngine
    //   0	155	1	paramClass	Class
    //   54	65	2	localObject	Object
    //   125	1	2	localException	java.lang.Exception
    //   151	1	2	localClass1	Class
    //   13	128	3	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   71	76	120	finally
    //   78	102	120	finally
    //   104	116	120	finally
    //   116	118	120	finally
    //   121	123	120	finally
    //   126	150	120	finally
    //   71	76	125	java/lang/Exception
    //   78	102	125	java/lang/Exception
    //   104	116	125	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.engine.ProxyServiceEngine
 * JD-Core Version:    0.7.0.1
 */