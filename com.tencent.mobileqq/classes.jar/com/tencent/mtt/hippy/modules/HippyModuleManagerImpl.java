package com.tencent.mtt.hippy.modules;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.annotation.HippyNativeModule.Thread;
import com.tencent.mtt.hippy.bridge.c;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyHandlerThread;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModuleInvocationHandler;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo.HippyNativeMethod;
import java.lang.reflect.Proxy;
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
          String[] arrayOfString = ((HippyNativeModuleInfo)localObject4).getNames();
          if ((arrayOfString != null) && (arrayOfString.length > 0))
          {
            int i = 0;
            while (i < arrayOfString.length)
            {
              String str = arrayOfString[i];
              if (!this.mNativeModuleInfo.containsKey(str)) {
                this.mNativeModuleInfo.put(str, localObject4);
              }
              i += 1;
            }
          }
          if (!this.mNativeModuleInfo.containsKey(((HippyNativeModuleInfo)localObject4).getName())) {
            this.mNativeModuleInfo.put(((HippyNativeModuleInfo)localObject4).getName(), localObject4);
          }
        }
      }
      localObject1 = ((HippyAPIProvider)localObject1).getJavaScriptModules();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Class)((Iterator)localObject2).next();
          localObject1 = getJavaScriptModuleName((Class)localObject3);
          if (this.mJsModules.containsKey(localObject1)) {
            break label348;
          }
          this.mJsModules.put(localObject3, null);
        }
        continue;
        label348:
        paramHippyEngineContext = new StringBuilder();
        paramHippyEngineContext.append("There is already a javascript module named : ");
        paramHippyEngineContext.append((String)localObject1);
        throw new RuntimeException(paramHippyEngineContext.toString());
      }
    }
  }
  
  private Handler getBridgeThreadHandler()
  {
    if (this.mBridgeThreadHandler == null) {
      try
      {
        if (this.mBridgeThreadHandler == null) {
          this.mBridgeThreadHandler = new Handler(this.mContext.getThreadExecutor().getJsBridgeThread().getLooper(), this);
        }
      }
      finally {}
    }
    return this.mBridgeThreadHandler;
  }
  
  private Handler getDomThreadHandler()
  {
    if (this.mDomThreadHandler == null) {
      try
      {
        if (this.mDomThreadHandler == null) {
          this.mDomThreadHandler = new Handler(this.mContext.getThreadExecutor().getDomThread().getLooper(), this);
        }
      }
      finally {}
    }
    return this.mDomThreadHandler;
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
    if (this.mUIThreadHandler == null) {
      try
      {
        if (this.mUIThreadHandler == null) {
          this.mUIThreadHandler = new Handler(Looper.getMainLooper(), this);
        }
      }
      finally {}
    }
    return this.mUIThreadHandler;
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
    if (((HippyNativeModuleInfo)localObject).getThread() == HippyNativeModule.Thread.DOM) {
      localObject = getDomThreadHandler();
    }
    for (;;)
    {
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, paramc));
      return;
      if (((HippyNativeModuleInfo)localObject).getThread() == HippyNativeModule.Thread.MAIN) {
        localObject = getUIThreadHandler();
      } else {
        localObject = getBridgeThreadHandler();
      }
    }
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
    Object localObject = this.mANRMonitor;
    if (localObject != null) {
      ((HippyModuleANRMonitor)localObject).checkMonitor();
    }
    this.isDestroyed = true;
    Iterator localIterator = this.mNativeModuleInfo.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (HippyNativeModuleInfo)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((HippyNativeModuleInfo)localObject).shouldDestroy()))
        {
          ((HippyNativeModuleInfo)localObject).onDestroy();
          Handler localHandler;
          if (((HippyNativeModuleInfo)localObject).getThread() == HippyNativeModule.Thread.DOM)
          {
            if (this.mDomThreadHandler != null)
            {
              localObject = this.mDomThreadHandler.obtainMessage(2, localObject);
              localHandler = this.mDomThreadHandler;
            }
          }
          else {
            for (;;)
            {
              localHandler.sendMessage((Message)localObject);
              break;
              if (((HippyNativeModuleInfo)localObject).getThread() == HippyNativeModule.Thread.MAIN)
              {
                if (this.mUIThreadHandler == null) {
                  break;
                }
                localObject = this.mUIThreadHandler.obtainMessage(2, localObject);
                localHandler = this.mUIThreadHandler;
                continue;
              }
              if (this.mBridgeThreadHandler == null) {
                break;
              }
              localObject = this.mBridgeThreadHandler.obtainMessage(2, localObject);
              localHandler = this.mBridgeThreadHandler;
            }
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
      paramString2.invoke(this.mContext, paramString1.getInstance(), paramHippyArray, paramString3);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString3.doCallback(1, paramString1.getMessage());
    }
  }
  
  public <T extends HippyJavaScriptModule> T getJavaScriptModule(Class<T> paramClass)
  {
    try
    {
      Object localObject = (HippyJavaScriptModule)this.mJsModules.get(paramClass);
      if (localObject != null) {
        return localObject;
      }
      localObject = paramClass.getClassLoader();
      if (localObject == null) {
        return null;
      }
      HippyJavaScriptModuleInvocationHandler localHippyJavaScriptModuleInvocationHandler = new HippyJavaScriptModuleInvocationHandler(this.mContext, getJavaScriptModuleName(paramClass));
      localObject = (HippyJavaScriptModule)Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { paramClass }, localHippyJavaScriptModuleInvocationHandler);
      this.mJsModules.remove(paramClass);
      this.mJsModules.put(paramClass, localObject);
      return localObject;
    }
    finally {}
  }
  
  public <T extends HippyNativeModuleBase> T getNativeModule(Class<T> paramClass)
  {
    try
    {
      paramClass = (HippyNativeModule)paramClass.getAnnotation(HippyNativeModule.class);
      if (paramClass != null)
      {
        paramClass = paramClass.name();
        paramClass = (HippyNativeModuleInfo)this.mNativeModuleInfo.get(paramClass);
        if (paramClass != null)
        {
          paramClass = paramClass.getInstance();
          return paramClass;
        }
      }
      return null;
    }
    finally {}
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 343	android/os/Message:what	I
    //   4: istore_2
    //   5: iload_2
    //   6: iconst_1
    //   7: if_icmpeq +64 -> 71
    //   10: iload_2
    //   11: iconst_2
    //   12: if_icmpeq +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_1
    //   18: getfield 347	android/os/Message:obj	Ljava/lang/Object;
    //   21: checkcast 90	com/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleInfo
    //   24: invokevirtual 349	com/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleInfo:destroy	()V
    //   27: iconst_1
    //   28: ireturn
    //   29: astore_1
    //   30: new 126	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   37: astore 5
    //   39: aload 5
    //   41: ldc_w 351
    //   44: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 5
    //   50: aload_1
    //   51: invokevirtual 302	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   54: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc_w 353
    //   61: aload 5
    //   63: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 359	com/tencent/mtt/hippy/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: iconst_1
    //   70: ireturn
    //   71: iconst_m1
    //   72: istore_3
    //   73: aload_1
    //   74: getfield 347	android/os/Message:obj	Ljava/lang/Object;
    //   77: checkcast 202	com/tencent/mtt/hippy/bridge/c
    //   80: astore 5
    //   82: iload_3
    //   83: istore_2
    //   84: aload 5
    //   86: astore_1
    //   87: iload_3
    //   88: istore 4
    //   90: aload 5
    //   92: getfield 362	com/tencent/mtt/hippy/bridge/c:d	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   95: astore 6
    //   97: iload_3
    //   98: istore_2
    //   99: aload 5
    //   101: astore_1
    //   102: iload_3
    //   103: istore 4
    //   105: aload_0
    //   106: getfield 44	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mANRMonitor	Lcom/tencent/mtt/hippy/modules/HippyModuleANRMonitor;
    //   109: aload 5
    //   111: getfield 206	com/tencent/mtt/hippy/bridge/c:a	Ljava/lang/String;
    //   114: aload 5
    //   116: getfield 212	com/tencent/mtt/hippy/bridge/c:b	Ljava/lang/String;
    //   119: invokevirtual 366	com/tencent/mtt/hippy/modules/HippyModuleANRMonitor:startMonitor	(Ljava/lang/String;Ljava/lang/String;)I
    //   122: istore_3
    //   123: iload_3
    //   124: istore_2
    //   125: aload 5
    //   127: astore_1
    //   128: iload_3
    //   129: istore 4
    //   131: aload_0
    //   132: aload 5
    //   134: getfield 206	com/tencent/mtt/hippy/bridge/c:a	Ljava/lang/String;
    //   137: aload 5
    //   139: getfield 212	com/tencent/mtt/hippy/bridge/c:b	Ljava/lang/String;
    //   142: aload 5
    //   144: getfield 215	com/tencent/mtt/hippy/bridge/c:c	Ljava/lang/String;
    //   147: aload 6
    //   149: invokevirtual 368	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:doCallNatives	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mtt/hippy/common/HippyArray;)V
    //   152: aload 5
    //   154: ifnull +8 -> 162
    //   157: aload 5
    //   159: invokevirtual 370	com/tencent/mtt/hippy/bridge/c:a	()V
    //   162: iload_3
    //   163: iflt +115 -> 278
    //   166: goto +104 -> 270
    //   169: astore 5
    //   171: goto +109 -> 280
    //   174: astore 6
    //   176: iload 4
    //   178: istore_3
    //   179: goto +17 -> 196
    //   182: astore 5
    //   184: aconst_null
    //   185: astore_1
    //   186: iload_3
    //   187: istore_2
    //   188: goto +92 -> 280
    //   191: astore 6
    //   193: aconst_null
    //   194: astore 5
    //   196: iload_3
    //   197: istore_2
    //   198: aload 5
    //   200: astore_1
    //   201: new 126	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   208: astore 7
    //   210: iload_3
    //   211: istore_2
    //   212: aload 5
    //   214: astore_1
    //   215: aload 7
    //   217: ldc_w 351
    //   220: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: iload_3
    //   225: istore_2
    //   226: aload 5
    //   228: astore_1
    //   229: aload 7
    //   231: aload 6
    //   233: invokevirtual 302	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: iload_3
    //   241: istore_2
    //   242: aload 5
    //   244: astore_1
    //   245: ldc_w 353
    //   248: aload 7
    //   250: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 359	com/tencent/mtt/hippy/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload 5
    //   258: ifnull +8 -> 266
    //   261: aload 5
    //   263: invokevirtual 370	com/tencent/mtt/hippy/bridge/c:a	()V
    //   266: iload_3
    //   267: iflt +11 -> 278
    //   270: aload_0
    //   271: getfield 44	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mANRMonitor	Lcom/tencent/mtt/hippy/modules/HippyModuleANRMonitor;
    //   274: iload_3
    //   275: invokevirtual 373	com/tencent/mtt/hippy/modules/HippyModuleANRMonitor:endMonitor	(I)V
    //   278: iconst_1
    //   279: ireturn
    //   280: aload_1
    //   281: ifnull +7 -> 288
    //   284: aload_1
    //   285: invokevirtual 370	com/tencent/mtt/hippy/bridge/c:a	()V
    //   288: iload_2
    //   289: iflt +11 -> 300
    //   292: aload_0
    //   293: getfield 44	com/tencent/mtt/hippy/modules/HippyModuleManagerImpl:mANRMonitor	Lcom/tencent/mtt/hippy/modules/HippyModuleANRMonitor;
    //   296: iload_2
    //   297: invokevirtual 373	com/tencent/mtt/hippy/modules/HippyModuleANRMonitor:endMonitor	(I)V
    //   300: aload 5
    //   302: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	HippyModuleManagerImpl
    //   0	303	1	paramMessage	Message
    //   4	293	2	i	int
    //   72	203	3	j	int
    //   88	89	4	k	int
    //   37	121	5	localObject1	Object
    //   169	1	5	localObject2	Object
    //   182	1	5	localObject3	Object
    //   194	107	5	localObject4	Object
    //   95	53	6	localHippyArray	HippyArray
    //   174	1	6	localThrowable1	Throwable
    //   191	41	6	localThrowable2	Throwable
    //   208	41	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	27	29	java/lang/Throwable
    //   90	97	169	finally
    //   105	123	169	finally
    //   131	152	169	finally
    //   201	210	169	finally
    //   215	224	169	finally
    //   229	240	169	finally
    //   245	256	169	finally
    //   90	97	174	java/lang/Throwable
    //   105	123	174	java/lang/Throwable
    //   131	152	174	java/lang/Throwable
    //   73	82	182	finally
    //   73	82	191	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.HippyModuleManagerImpl
 * JD-Core Version:    0.7.0.1
 */