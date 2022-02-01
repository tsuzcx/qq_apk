package com.tencent.qqmini.sdk.plugins.engine;

import android.content.Context;
import com.tencent.qqmini.sdk.action.RepeatRequestEvent;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JsPluginEngine
  extends BaseJsPluginEngine
{
  public static final String TAG = "JsPluginEngine[Dispatcher]";
  private final Map<Class, IJsPlugin> mActivatedPlugins = new ConcurrentHashMap();
  private final Map<String, Class> mEventPluginMap = new HashMap();
  private Map<String, WeakReference<Method>> mMethodCache = new ConcurrentHashMap();
  private final Map<String, Class> mSecondaryEventPluginMap = new HashMap();
  
  public JsPluginEngine(Context paramContext)
  {
    super(paramContext);
  }
  
  private static String buildMessage(String paramString, RequestEvent paramRequestEvent)
  {
    return paramString + "eventName=" + paramRequestEvent.event + ", " + "jsonParams=" + paramRequestEvent.jsonParams + ", " + "callbackId=" + paramRequestEvent.callbackId + "jsService=" + paramRequestEvent.jsService;
  }
  
  /* Error */
  private IJsPlugin createJsPlugin(Class paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 92	com/tencent/qqmini/sdk/plugins/engine/JsPluginEngine:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 8
    //   11: ldc 94
    //   13: invokestatic 100	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_2
    //   21: areturn
    //   22: aload_0
    //   23: getfield 34	com/tencent/qqmini/sdk/plugins/engine/JsPluginEngine:mActivatedPlugins	Ljava/util/Map;
    //   26: aload_1
    //   27: invokeinterface 106 2 0
    //   32: checkcast 108	com/tencent/qqmini/sdk/launcher/core/plugins/IJsPlugin
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: ifnonnull -21 -> 18
    //   42: aload_3
    //   43: astore_2
    //   44: aload_1
    //   45: invokevirtual 114	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   48: astore 4
    //   50: aload_3
    //   51: astore_2
    //   52: aload 4
    //   54: instanceof 108
    //   57: ifeq +73 -> 130
    //   60: aload_3
    //   61: astore_2
    //   62: aload 4
    //   64: checkcast 108	com/tencent/qqmini/sdk/launcher/core/plugins/IJsPlugin
    //   67: astore_3
    //   68: aload_3
    //   69: astore_2
    //   70: aload_3
    //   71: aload_0
    //   72: getfield 92	com/tencent/qqmini/sdk/plugins/engine/JsPluginEngine:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   75: invokeinterface 118 2 0
    //   80: aload_3
    //   81: astore_2
    //   82: aload_0
    //   83: getfield 34	com/tencent/qqmini/sdk/plugins/engine/JsPluginEngine:mActivatedPlugins	Ljava/util/Map;
    //   86: aload_1
    //   87: aload_3
    //   88: invokeinterface 122 3 0
    //   93: pop
    //   94: aload_3
    //   95: astore_2
    //   96: goto -78 -> 18
    //   99: astore_1
    //   100: ldc 8
    //   102: new 41	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   109: ldc 125
    //   111: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_2
    //   115: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aload_1
    //   122: invokestatic 129	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aconst_null
    //   126: astore_2
    //   127: goto -109 -> 18
    //   130: aload_3
    //   131: astore_2
    //   132: ldc 8
    //   134: new 41	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   141: ldc 131
    //   143: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_3
    //   147: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 133	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aconst_null
    //   157: astore_2
    //   158: goto -140 -> 18
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	JsPluginEngine
    //   0	166	1	paramClass	Class
    //   17	141	2	localObject1	Object
    //   35	112	3	localIJsPlugin	IJsPlugin
    //   48	15	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	50	99	java/lang/Exception
    //   52	60	99	java/lang/Exception
    //   62	68	99	java/lang/Exception
    //   70	80	99	java/lang/Exception
    //   82	94	99	java/lang/Exception
    //   132	156	99	java/lang/Exception
    //   2	16	161	finally
    //   22	36	161	finally
    //   44	50	161	finally
    //   52	60	161	finally
    //   62	68	161	finally
    //   70	80	161	finally
    //   82	94	161	finally
    //   100	125	161	finally
    //   132	156	161	finally
  }
  
  private String dispatchRequestEventToPlugin(RequestEvent paramRequestEvent, IJsPlugin paramIJsPlugin)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    try
    {
      str = paramIJsPlugin.getClass().getCanonicalName() + "." + paramRequestEvent.event;
      localObject4 = (WeakReference)this.mMethodCache.get(str);
      if (localObject4 == null) {
        break label392;
      }
      localObject4 = (Method)((WeakReference)localObject4).get();
      localObject1 = localObject4;
    }
    catch (IllegalAccessException paramIJsPlugin)
    {
      String str;
      QMLog.w("JsPluginEngine[Dispatcher]", "dispatchEvent " + paramRequestEvent.event + " failed, method = " + localObject1 + ", access exception " + paramIJsPlugin.getMessage(), paramIJsPlugin);
      paramRequestEvent.fail();
      return "";
    }
    catch (InvocationTargetException paramIJsPlugin)
    {
      for (;;)
      {
        localObject1 = localObject2;
        QMLog.w("JsPluginEngine[Dispatcher]", "dispatchEvent " + paramRequestEvent.event + " failed, method = " + localObject1 + ", invoke exception " + paramIJsPlugin.getMessage(), paramIJsPlugin);
      }
    }
    catch (RuntimeException paramIJsPlugin)
    {
      do
      {
        do
        {
          for (;;)
          {
            Object localObject4;
            localObject1 = localObject3;
            QMLog.w("JsPluginEngine[Dispatcher]", "dispatchEvent " + paramRequestEvent.event + " failed, method = " + localObject1 + ", runtime exception " + paramIJsPlugin.getMessage(), paramIJsPlugin);
            continue;
            localObject1 = null;
          }
        } while (localObject2 != null);
        paramIJsPlugin = localObject5;
      } while (paramIJsPlugin != null);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = localObject1;
      localObject4 = localObject1;
      try
      {
        localObject2 = JsPluginList.getMethod(paramIJsPlugin.getClass(), paramRequestEvent.event);
        localObject3 = localObject2;
        localObject4 = localObject2;
        localObject1 = localObject2;
        ((Method)localObject2).setAccessible(true);
        localObject3 = localObject2;
        localObject4 = localObject2;
        localObject1 = localObject2;
        this.mMethodCache.put(str, new WeakReference(localObject2));
      }
      catch (RuntimeException paramIJsPlugin)
      {
        for (;;)
        {
          localObject1 = localObject3;
        }
      }
      catch (InvocationTargetException paramIJsPlugin)
      {
        for (;;)
        {
          localObject1 = localObject4;
        }
      }
      catch (IllegalAccessException paramIJsPlugin)
      {
        break label205;
      }
      localObject3 = localObject2;
      localObject4 = localObject2;
      localObject1 = localObject2;
      paramIJsPlugin = ((Method)localObject2).invoke(paramIJsPlugin, new Object[] { paramRequestEvent });
      break label405;
      localObject3 = localObject2;
      localObject4 = localObject2;
      localObject1 = localObject2;
      paramIJsPlugin = paramIJsPlugin.toString();
      return paramIJsPlugin;
    }
    label205:
    return "";
  }
  
  String dispatchRequestEvent(RequestEvent paramRequestEvent)
  {
    IJsPlugin localIJsPlugin = getEventHandler(paramRequestEvent.event);
    if (localIJsPlugin == null)
    {
      QMLog.w("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest failed, event not support! ", paramRequestEvent));
      return "";
    }
    if (localIJsPlugin.onInterceptJsEvent(paramRequestEvent))
    {
      QMLog.i("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest aborted, event is intercepted. ", paramRequestEvent));
      return "";
    }
    reportApiInvoke(this.mMiniAppContext.getMiniAppInfo(), paramRequestEvent.event);
    return dispatchRequestEventToPlugin(paramRequestEvent, localIJsPlugin);
  }
  
  public String dispatchSecondaryRequestEvent(RepeatRequestEvent paramRepeatRequestEvent)
  {
    IJsPlugin localIJsPlugin = getSecondaryEventHandler(paramRepeatRequestEvent.event);
    if (localIJsPlugin == null)
    {
      QMLog.w("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest failed, secondary event not support! ", paramRepeatRequestEvent));
      return "";
    }
    if (localIJsPlugin.onInterceptJsEvent(paramRepeatRequestEvent))
    {
      QMLog.i("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest aborted, secondary event is intercepted. ", paramRepeatRequestEvent));
      return "";
    }
    return dispatchRequestEventToPlugin(paramRepeatRequestEvent, localIJsPlugin);
  }
  
  protected final IJsPlugin getEventHandler(String paramString)
  {
    Class localClass = (Class)this.mEventPluginMap.get(paramString);
    if (localClass == null) {
      paramString = null;
    }
    IJsPlugin localIJsPlugin;
    do
    {
      return paramString;
      localIJsPlugin = (IJsPlugin)this.mActivatedPlugins.get(localClass);
      paramString = localIJsPlugin;
    } while (localIJsPlugin != null);
    return createJsPlugin(localClass);
  }
  
  protected final IJsPlugin getSecondaryEventHandler(String paramString)
  {
    Class localClass = (Class)this.mSecondaryEventPluginMap.get(paramString);
    if (localClass == null) {
      paramString = null;
    }
    IJsPlugin localIJsPlugin;
    do
    {
      return paramString;
      localIJsPlugin = (IJsPlugin)this.mActivatedPlugins.get(localClass);
      paramString = localIJsPlugin;
    } while (localIJsPlugin != null);
    return createJsPlugin(localClass);
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.mEventPluginMap.putAll(JsPluginList.getEventPluginMap(paramIMiniAppContext.isMiniGame()));
    this.mSecondaryEventPluginMap.putAll(JsPluginList.getSecondaryEventPluginMap(paramIMiniAppContext.isMiniGame()));
    Iterator localIterator = JsPluginList.getPreloadPlugins(paramIMiniAppContext.isMiniGame()).iterator();
    while (localIterator.hasNext()) {
      createJsPlugin((Class)localIterator.next());
    }
    if ((this.mActivatedPlugins != null) && (this.mActivatedPlugins.size() > 0))
    {
      localIterator = this.mActivatedPlugins.values().iterator();
      while (localIterator.hasNext()) {
        ((IJsPlugin)localIterator.next()).onCreate(paramIMiniAppContext);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mActivatedPlugins.values().iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onDestroy();
    }
    this.mActivatedPlugins.clear();
    this.mMethodCache.clear();
    this.mEventPluginMap.clear();
    this.mSecondaryEventPluginMap.clear();
    JsPluginList.clear();
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.mActivatedPlugins.values().iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.mActivatedPlugins.values().iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onResume();
    }
  }
  
  public void reportApiInvoke(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    ThreadManager.executeOnComputationThreadPool(new JsPluginEngine.1(this, paramString, paramMiniAppInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine
 * JD-Core Version:    0.7.0.1
 */