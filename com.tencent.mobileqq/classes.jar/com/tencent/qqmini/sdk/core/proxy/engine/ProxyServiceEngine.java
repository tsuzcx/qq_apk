package com.tencent.qqmini.sdk.core.proxy.engine;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
    //   15: ifnonnull +35 -> 50
    //   18: new 52	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   25: astore_2
    //   26: aload_2
    //   27: ldc 55
    //   29: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: aload_1
    //   35: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 8
    //   41: aload_2
    //   42: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aconst_null
    //   49: areturn
    //   50: aload_0
    //   51: getfield 37	com/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine:mActivatedServices	Ljava/util/Map;
    //   54: aload_3
    //   55: invokeinterface 48 2 0
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +5 -> 67
    //   65: aload_2
    //   66: areturn
    //   67: aload_0
    //   68: monitorenter
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: ifnonnull +101 -> 173
    //   75: aload_2
    //   76: astore_1
    //   77: aload_3
    //   78: invokevirtual 76	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   81: astore_2
    //   82: aload_2
    //   83: astore_1
    //   84: new 52	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: astore_1
    //   95: aload 4
    //   97: ldc 78
    //   99: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_2
    //   104: astore_1
    //   105: aload 4
    //   107: aload_3
    //   108: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_2
    //   113: astore_1
    //   114: ldc 8
    //   116: aload 4
    //   118: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 81	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_2
    //   125: astore_1
    //   126: aload_0
    //   127: getfield 37	com/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine:mActivatedServices	Ljava/util/Map;
    //   130: aload_3
    //   131: aload_2
    //   132: invokeinterface 85 3 0
    //   137: pop
    //   138: aload_2
    //   139: astore_1
    //   140: goto +33 -> 173
    //   143: new 52	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   150: astore_2
    //   151: aload_2
    //   152: ldc 87
    //   154: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_2
    //   159: aload_3
    //   160: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 8
    //   166: aload_2
    //   167: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 90	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_1
    //   176: areturn
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: astore_2
    //   183: goto -40 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	ProxyServiceEngine
    //   0	186	1	paramClass	Class
    //   25	142	2	localObject	Object
    //   182	1	2	localException	Exception
    //   13	147	3	localClass	Class
    //   91	26	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   77	82	177	finally
    //   84	93	177	finally
    //   95	103	177	finally
    //   105	112	177	finally
    //   114	124	177	finally
    //   126	138	177	finally
    //   143	173	177	finally
    //   173	175	177	finally
    //   178	180	177	finally
    //   77	82	182	java/lang/Exception
    //   84	93	182	java/lang/Exception
    //   95	103	182	java/lang/Exception
    //   105	112	182	java/lang/Exception
    //   114	124	182	java/lang/Exception
    //   126	138	182	java/lang/Exception
  }
  
  public Object newProxyService(Class paramClass)
  {
    Object localObject = (Class)this.mProxyServicesMap.get(paramClass);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Can NOT find service class: ");
      ((StringBuilder)localObject).append(paramClass);
      QMLog.w("ProxyServiceEngine", ((StringBuilder)localObject).toString());
      return null;
    }
    try
    {
      paramClass = new StringBuilder();
      paramClass.append("Create a new proxy cls:");
      paramClass.append(localObject);
      QMLog.i("ProxyServiceEngine", paramClass.toString());
      paramClass = ((Class)localObject).newInstance();
      return paramClass;
    }
    catch (Exception paramClass) {}finally
    {
      break label125;
    }
    paramClass = new StringBuilder();
    paramClass.append("Failed to create cls:");
    paramClass.append(localObject);
    QMLog.e("ProxyServiceEngine", paramClass.toString());
    return null;
    label125:
    throw paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.engine.ProxyServiceEngine
 * JD-Core Version:    0.7.0.1
 */