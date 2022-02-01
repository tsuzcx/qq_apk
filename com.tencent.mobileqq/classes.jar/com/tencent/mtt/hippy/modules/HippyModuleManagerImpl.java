package com.tencent.mtt.hippy.modules;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyNativeModule.Thread;
import com.tencent.mtt.hippy.bridge.c;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyHandlerThread;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo.HippyNativeMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HippyModuleManagerImpl
  implements Handler.Callback, HippyModuleManager
{
  private static final int MSG_CODE_CALL_NATIVES = 1;
  private static final int MSG_CODE_DESTROY_MODULE = 2;
  private boolean isDestroyed = false;
  private HippyModuleANRMonitor mANRMonitor;
  private volatile Handler mBridgeThreadHandler;
  private HippyEngineContext mContext;
  private volatile Handler mDomThreadHandler;
  private HashMap<Class<? extends HippyJavaScriptModule>, HippyJavaScriptModule> mJsModules;
  private HashMap<String, HippyNativeModuleInfo> mNativeModuleInfo;
  private volatile Handler mUIThreadHandler;
  
  public HippyModuleManagerImpl(HippyEngineContext paramHippyEngineContext, List<HippyAPIProvider> paramList)
  {
    this.mContext = paramHippyEngineContext;
    this.mANRMonitor = new HippyModuleANRMonitor(this.mContext);
    this.mNativeModuleInfo = new HashMap();
    this.mJsModules = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (HippyAPIProvider)paramList.next();
      Object localObject2 = ((HippyAPIProvider)localObject1).getNativeModules(paramHippyEngineContext);
      Object localObject3;
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        localObject3 = ((Map)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Class)((Iterator)localObject3).next();
          localObject4 = new HippyNativeModuleInfo((Class)localObject4, (Provider)((Map)localObject2).get(localObject4));
          if (this.mNativeModuleInfo.containsKey(((HippyNativeModuleInfo)localObject4).getName())) {
            throw new RuntimeException("There is already a native module named : " + ((HippyNativeModuleInfo)localObject4).getName());
          }
          this.mNativeModuleInfo.put(((HippyNativeModuleInfo)localObject4).getName(), localObject4);
        }
      }
      localObject1 = ((HippyAPIProvider)localObject1).getJavaScriptModules();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Class)((Iterator)localObject1).next();
          localObject3 = getJavaScriptModuleName((Class)localObject2);
          if (this.mJsModules.containsKey(localObject3)) {
            throw new RuntimeException("There is already a javascript module named : " + (String)localObject3);
          }
          this.mJsModules.put(localObject2, null);
        }
      }
    }
  }
  
  private Handler getBridgeThreadHandler()
  {
    if (this.mBridgeThreadHandler == null) {}
    try
    {
      if (this.mBridgeThreadHandler == null) {
        this.mBridgeThreadHandler = new Handler(this.mContext.getThreadExecutor().getJsBridgeThread().getLooper(), this);
      }
      return this.mBridgeThreadHandler;
    }
    finally {}
  }
  
  private Handler getDomThreadHandler()
  {
    if (this.mDomThreadHandler == null) {}
    try
    {
      if (this.mDomThreadHandler == null) {
        this.mDomThreadHandler = new Handler(this.mContext.getThreadExecutor().getDomThread().getLooper(), this);
      }
      return this.mDomThreadHandler;
    }
    finally {}
  }
  
  private String getJavaScriptModuleName(Class paramClass)
  {
    String str = paramClass.getSimpleName();
    int i = str.lastIndexOf('$');
    paramClass = str;
    if (i != -1) {
      paramClass = str.substring(i + 1);
    }
    return paramClass;
  }
  
  private Handler getUIThreadHandler()
  {
    if (this.mUIThreadHandler == null) {}
    try
    {
      if (this.mUIThreadHandler == null) {
        this.mUIThreadHandler = new Handler(Looper.getMainLooper(), this);
      }
      return this.mUIThreadHandler;
    }
    finally {}
  }
  
  public void callNatives(c paramc)
  {
    if (this.isDestroyed) {
      return;
    }
    Object localObject = (HippyNativeModuleInfo)this.mNativeModuleInfo.get(paramc.a);
    if (localObject == null)
    {
      new PromiseImpl(this.mContext, paramc.a, paramc.b, paramc.c).doCallback(1, "module can not be found");
      return;
    }
    if (((HippyNativeModuleInfo)localObject).getThread() == HippyNativeModule.Thread.DOM)
    {
      localObject = getDomThreadHandler();
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, paramc));
      return;
    }
    if (((HippyNativeModuleInfo)localObject).getThread() == HippyNativeModule.Thread.MAIN)
    {
      localObject = getUIThreadHandler();
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, paramc));
      return;
    }
    localObject = getBridgeThreadHandler();
    ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, paramc));
  }
  
  public void destroy()
  {
    if (this.mBridgeThreadHandler != null) {
      this.mBridgeThreadHandler.removeMessages(1);
    }
    if (this.mDomThreadHandler != null) {
      this.mDomThreadHandler.removeMessages(1);
    }
    if (this.mUIThreadHandler != null) {
      this.mUIThreadHandler.removeMessages(1);
    }
    if (this.mANRMonitor != null) {
      this.mANRMonitor.checkMonitor();
    }
    this.isDestroyed = true;
    Iterator localIterator = this.mNativeModuleInfo.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (HippyNativeModuleInfo)((Map.Entry)localObject).getValue();
        if (localObject != null) {
          if (((HippyNativeModuleInfo)localObject).getThread() == HippyNativeModule.Thread.DOM)
          {
            if (this.mDomThreadHandler != null)
            {
              localObject = this.mDomThreadHandler.obtainMessage(2, localObject);
              this.mDomThreadHandler.sendMessage((Message)localObject);
            }
          }
          else if (((HippyNativeModuleInfo)localObject).getThread() == HippyNativeModule.Thread.MAIN)
          {
            if (this.mUIThreadHandler != null)
            {
              localObject = this.mUIThreadHandler.obtainMessage(2, localObject);
              this.mUIThreadHandler.sendMessage((Message)localObject);
            }
          }
          else if (this.mBridgeThreadHandler != null)
          {
            localObject = this.mBridgeThreadHandler.obtainMessage(2, localObject);
            this.mBridgeThreadHandler.sendMessage((Message)localObject);
          }
        }
      }
    }
    this.mNativeModuleInfo.clear();
  }
  
  void doCallNatives(String paramString1, String paramString2, String paramString3, HippyArray paramHippyArray)
  {
    paramString3 = new PromiseImpl(this.mContext, paramString1, paramString2, paramString3);
    try
    {
      paramString1 = (HippyNativeModuleInfo)this.mNativeModuleInfo.get(paramString1);
      if (paramString1 == null)
      {
        paramString3.doCallback(1, "module can not be found");
        return;
      }
      paramString1.initialize();
      paramString2 = paramString1.findMethod(paramString2);
      if (paramString2 == null)
      {
        paramString3.doCallback(1, "module function can not be found");
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString3.doCallback(1, paramString1.getMessage());
      return;
    }
    paramString2.invoke(this.mContext, paramString1.getInstance(), paramHippyArray, paramString3);
  }
  
  /* Error */
  public <T extends HippyJavaScriptModule> T getJavaScriptModule(Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mJsModules	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 205	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 298	com/tencent/mtt/hippy/modules/javascriptmodules/HippyJavaScriptModule
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +9 -> 24
    //   18: aload_2
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_1
    //   25: invokevirtual 302	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnonnull +8 -> 38
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -15 -> 20
    //   38: new 304	com/tencent/mtt/hippy/modules/javascriptmodules/HippyJavaScriptModuleInvocationHandler
    //   41: dup
    //   42: aload_0
    //   43: getfield 37	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mContext	Lcom/tencent/mtt/hippy/HippyEngineContext;
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 137	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:getJavaScriptModuleName	(Ljava/lang/Class;)Ljava/lang/String;
    //   51: invokespecial 307	com/tencent/mtt/hippy/modules/javascriptmodules/HippyJavaScriptModuleInvocationHandler:<init>	(Lcom/tencent/mtt/hippy/HippyEngineContext;Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_2
    //   56: iconst_1
    //   57: anewarray 88	java/lang/Class
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aload_3
    //   65: invokestatic 313	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   68: checkcast 298	com/tencent/mtt/hippy/modules/javascriptmodules/HippyJavaScriptModule
    //   71: astore_2
    //   72: aload_0
    //   73: getfield 51	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mJsModules	Ljava/util/HashMap;
    //   76: aload_1
    //   77: invokevirtual 316	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: aload_0
    //   82: getfield 51	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mJsModules	Ljava/util/HashMap;
    //   85: aload_1
    //   86: aload_2
    //   87: invokevirtual 128	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload_2
    //   92: astore_1
    //   93: goto -73 -> 20
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	HippyModuleManagerImpl
    //   0	101	1	paramClass	Class<T>
    //   13	79	2	localObject	Object
    //   54	11	3	localHippyJavaScriptModuleInvocationHandler	com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModuleInvocationHandler
    // Exception table:
    //   from	to	target	type
    //   2	14	96	finally
    //   24	29	96	finally
    //   38	91	96	finally
  }
  
  /* Error */
  public <T extends com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase> T getNativeModule(Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc_w 321
    //   6: invokevirtual 325	java/lang/Class:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   9: checkcast 321	com/tencent/mtt/hippy/annotation/HippyNativeModule
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +35 -> 49
    //   17: aload_1
    //   18: invokeinterface 328 1 0
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 49	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mNativeModuleInfo	Ljava/util/HashMap;
    //   28: aload_1
    //   29: invokevirtual 205	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 90	com/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleInfo
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +12 -> 49
    //   40: aload_1
    //   41: invokevirtual 288	com/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleInfo:getInstance	()Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -6 -> 45
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	HippyModuleManagerImpl
    //   0	59	1	paramClass	Class<T>
    // Exception table:
    //   from	to	target	type
    //   2	13	54	finally
    //   17	36	54	finally
    //   40	45	54	finally
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 335	android/os/Message:what	I
    //   4: tableswitch	default:+24 -> 28, 1:+26->30, 2:+186->190
    //   29: ireturn
    //   30: aconst_null
    //   31: astore 5
    //   33: iconst_m1
    //   34: istore 4
    //   36: aload_1
    //   37: getfield 339	android/os/Message:obj	Ljava/lang/Object;
    //   40: checkcast 200	com/tencent/mtt/hippy/bridge/c
    //   43: astore_1
    //   44: iload 4
    //   46: istore_2
    //   47: iload 4
    //   49: istore_3
    //   50: aload_1
    //   51: getfield 343	com/tencent/mtt/hippy/bridge/c:d	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   54: astore 5
    //   56: iload 4
    //   58: istore_2
    //   59: iload 4
    //   61: istore_3
    //   62: aload_0
    //   63: getfield 44	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mANRMonitor	Lcom/tencent/mtt/hippy/modules/HippyModuleANRMonitor;
    //   66: aload_1
    //   67: getfield 204	com/tencent/mtt/hippy/bridge/c:a	Ljava/lang/String;
    //   70: aload_1
    //   71: getfield 210	com/tencent/mtt/hippy/bridge/c:b	Ljava/lang/String;
    //   74: invokevirtual 347	com/tencent/mtt/hippy/modules/HippyModuleANRMonitor:startMonitor	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: istore 4
    //   79: iload 4
    //   81: istore_2
    //   82: iload 4
    //   84: istore_3
    //   85: aload_0
    //   86: aload_1
    //   87: getfield 204	com/tencent/mtt/hippy/bridge/c:a	Ljava/lang/String;
    //   90: aload_1
    //   91: getfield 210	com/tencent/mtt/hippy/bridge/c:b	Ljava/lang/String;
    //   94: aload_1
    //   95: getfield 213	com/tencent/mtt/hippy/bridge/c:c	Ljava/lang/String;
    //   98: aload 5
    //   100: invokevirtual 349	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:doCallNatives	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mtt/hippy/common/HippyArray;)V
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 351	com/tencent/mtt/hippy/bridge/c:a	()V
    //   111: iload 4
    //   113: iflt +12 -> 125
    //   116: aload_0
    //   117: getfield 44	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mANRMonitor	Lcom/tencent/mtt/hippy/modules/HippyModuleANRMonitor;
    //   120: iload 4
    //   122: invokevirtual 354	com/tencent/mtt/hippy/modules/HippyModuleANRMonitor:endMonitor	(I)V
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_1
    //   128: iconst_m1
    //   129: istore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 351	com/tencent/mtt/hippy/bridge/c:a	()V
    //   140: iload_2
    //   141: iflt -16 -> 125
    //   144: aload_0
    //   145: getfield 44	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mANRMonitor	Lcom/tencent/mtt/hippy/modules/HippyModuleANRMonitor;
    //   148: iload_2
    //   149: invokevirtual 354	com/tencent/mtt/hippy/modules/HippyModuleANRMonitor:endMonitor	(I)V
    //   152: goto -27 -> 125
    //   155: astore 6
    //   157: aload 5
    //   159: astore_1
    //   160: iload 4
    //   162: istore_2
    //   163: aload 6
    //   165: astore 5
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 351	com/tencent/mtt/hippy/bridge/c:a	()V
    //   175: iload_2
    //   176: iflt +11 -> 187
    //   179: aload_0
    //   180: getfield 44	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mANRMonitor	Lcom/tencent/mtt/hippy/modules/HippyModuleANRMonitor;
    //   183: iload_2
    //   184: invokevirtual 354	com/tencent/mtt/hippy/modules/HippyModuleANRMonitor:endMonitor	(I)V
    //   187: aload 5
    //   189: athrow
    //   190: aload_1
    //   191: getfield 339	android/os/Message:obj	Ljava/lang/Object;
    //   194: checkcast 90	com/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleInfo
    //   197: invokevirtual 356	com/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleInfo:destroy	()V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_1
    //   203: goto -3 -> 200
    //   206: astore 5
    //   208: goto -41 -> 167
    //   211: astore 5
    //   213: iload_3
    //   214: istore_2
    //   215: goto -83 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	HippyModuleManagerImpl
    //   0	218	1	paramMessage	Message
    //   46	169	2	i	int
    //   49	165	3	j	int
    //   34	127	4	k	int
    //   31	157	5	localObject1	Object
    //   206	1	5	localObject2	Object
    //   211	1	5	localThrowable	Throwable
    //   155	9	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	127	java/lang/Throwable
    //   36	44	155	finally
    //   190	200	202	java/lang/Throwable
    //   50	56	206	finally
    //   62	79	206	finally
    //   85	103	206	finally
    //   50	56	211	java/lang/Throwable
    //   62	79	211	java/lang/Throwable
    //   85	103	211	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.HippyModuleManagerImpl
 * JD-Core Version:    0.7.0.1
 */