package com.tencent.qqmini.sdk.core.plugins.engine;

import android.content.Context;
import bglv;
import bgmm;
import bgok;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
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
  private final Map<String, IJsPlugin> mActivatedPlugins = new ConcurrentHashMap();
  private final Map<String, String> mEventPluginMap = new HashMap();
  private Map<String, WeakReference<Method>> mMethodCache = new ConcurrentHashMap();
  private final Map<String, String> mSecondaryEventPluginMap = new HashMap();
  
  public JsPluginEngine(Context paramContext)
  {
    super(paramContext);
  }
  
  private static String buildMessage(String paramString, bgok parambgok)
  {
    return paramString + "eventName=" + parambgok.jdField_a_of_type_JavaLangString + ", " + "jsonParams=" + parambgok.jdField_b_of_type_JavaLangString + ", " + "callbackId=" + parambgok.jdField_b_of_type_Int + "jsService=" + parambgok.jdField_a_of_type_Bglu;
  }
  
  /* Error */
  private IJsPlugin createJsPlugin(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginEngine:mMiniAppContext	Lbglv;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 8
    //   11: ldc 92
    //   13: invokestatic 98	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_3
    //   21: areturn
    //   22: aload_0
    //   23: getfield 34	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginEngine:mActivatedPlugins	Ljava/util/Map;
    //   26: aload_1
    //   27: invokeinterface 104 2 0
    //   32: checkcast 106	com/tencent/qqmini/sdk/core/plugins/IJsPlugin
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: ifnonnull -24 -> 18
    //   45: aload_1
    //   46: invokestatic 111	bgpn:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_3
    //   51: instanceof 106
    //   54: istore_2
    //   55: iload_2
    //   56: ifeq +59 -> 115
    //   59: aload_3
    //   60: checkcast 106	com/tencent/qqmini/sdk/core/plugins/IJsPlugin
    //   63: astore_3
    //   64: aload_3
    //   65: invokestatic 117	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginList:getServiceInjectors	(Lcom/tencent/qqmini/sdk/core/plugins/IJsPlugin;)Ljava/util/Map;
    //   68: astore 4
    //   70: invokestatic 123	com/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine:g	()Lcom/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine;
    //   73: aload_3
    //   74: aload 4
    //   76: invokevirtual 127	com/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine:injectPluginProxyServices	(Lcom/tencent/qqmini/sdk/core/plugins/IJsPlugin;Ljava/util/Map;)V
    //   79: aload_3
    //   80: aload_0
    //   81: getfield 90	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginEngine:mMiniAppContext	Lbglv;
    //   84: invokeinterface 131 2 0
    //   89: aload_0
    //   90: getfield 34	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginEngine:mActivatedPlugins	Ljava/util/Map;
    //   93: aload_1
    //   94: aload_3
    //   95: invokeinterface 135 3 0
    //   100: pop
    //   101: goto -83 -> 18
    //   104: astore_1
    //   105: ldc 8
    //   107: aload_1
    //   108: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: aload_1
    //   112: invokestatic 142	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: aconst_null
    //   116: astore_3
    //   117: goto -99 -> 18
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	JsPluginEngine
    //   0	125	1	paramString	String
    //   54	2	2	bool	boolean
    //   17	100	3	localObject1	Object
    //   35	40	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	101	104	java/lang/Exception
    //   2	16	120	finally
    //   22	37	120	finally
    //   45	55	120	finally
    //   59	101	120	finally
    //   105	115	120	finally
  }
  
  private String dispatchRequestEventToPlugin(bgok parambgok, IJsPlugin paramIJsPlugin)
  {
    str1 = JsPluginList.getMethodName(paramIJsPlugin, parambgok.jdField_a_of_type_JavaLangString);
    try
    {
      str2 = paramIJsPlugin.getClass().getName() + "." + str1;
      localObject1 = (WeakReference)this.mMethodCache.get(str2);
      if (localObject1 == null) {
        break label361;
      }
      localObject1 = (Method)((WeakReference)localObject1).get();
    }
    catch (NoSuchMethodException paramIJsPlugin)
    {
      String str2;
      Object localObject2;
      QMLog.w("JsPluginEngine[Dispatcher]", "dispatchEvent " + parambgok.jdField_a_of_type_JavaLangString + " failed, can NOT find declared method " + str1, paramIJsPlugin);
      parambgok.b();
      return "";
    }
    catch (IllegalAccessException paramIJsPlugin)
    {
      for (;;)
      {
        QMLog.w("JsPluginEngine[Dispatcher]", "dispatchEvent " + parambgok.jdField_a_of_type_JavaLangString + " failed, " + str1 + " access exception " + paramIJsPlugin.getMessage(), paramIJsPlugin);
      }
    }
    catch (InvocationTargetException paramIJsPlugin)
    {
      for (;;)
      {
        QMLog.w("JsPluginEngine[Dispatcher]", "dispatchEvent " + parambgok.jdField_a_of_type_JavaLangString + " failed, " + str1 + " invoke exception " + paramIJsPlugin.getMessage(), paramIJsPlugin);
      }
    }
    catch (RuntimeException paramIJsPlugin)
    {
      for (;;)
      {
        QMLog.w("JsPluginEngine[Dispatcher]", "dispatchEvent " + parambgok.jdField_a_of_type_JavaLangString + " failed, " + str1 + " runtime exception " + paramIJsPlugin.getMessage(), paramIJsPlugin);
        continue;
        Object localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = paramIJsPlugin.getClass().getDeclaredMethod(str1, new Class[] { bgok.class });
      ((Method)localObject2).setAccessible(true);
      this.mMethodCache.put(str2, new WeakReference(localObject2));
    }
    paramIJsPlugin = ((Method)localObject2).invoke(paramIJsPlugin, new Object[] { parambgok });
    if (paramIJsPlugin == null) {
      return "";
    }
    paramIJsPlugin = paramIJsPlugin.toString();
    return paramIJsPlugin;
  }
  
  String dispatchRequestEvent(bgok parambgok)
  {
    IJsPlugin localIJsPlugin = getEventHandler(parambgok.jdField_a_of_type_JavaLangString);
    if (localIJsPlugin == null)
    {
      QMLog.w("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest failed, event not support! ", parambgok));
      return "";
    }
    if (localIJsPlugin.onInterceptJsEvent(parambgok))
    {
      QMLog.i("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest aborted, event is intercepted. ", parambgok));
      return "";
    }
    reportApiInvoke(this.mMiniAppContext.a(), parambgok.jdField_a_of_type_JavaLangString);
    return dispatchRequestEventToPlugin(parambgok, localIJsPlugin);
  }
  
  public String dispatchSecondaryRequestEvent(bgmm parambgmm)
  {
    IJsPlugin localIJsPlugin = getSecondaryEventHandler(parambgmm.jdField_a_of_type_JavaLangString);
    if (localIJsPlugin == null)
    {
      QMLog.w("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest failed, secondary event not support! ", parambgmm));
      return "";
    }
    if (localIJsPlugin.onInterceptJsEvent(parambgmm))
    {
      QMLog.i("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest aborted, secondary event is intercepted. ", parambgmm));
      return "";
    }
    return dispatchRequestEventToPlugin(parambgmm, localIJsPlugin);
  }
  
  protected final IJsPlugin getEventHandler(String paramString)
  {
    String str = (String)this.mEventPluginMap.get(paramString);
    if (str == null) {
      paramString = null;
    }
    IJsPlugin localIJsPlugin;
    do
    {
      return paramString;
      localIJsPlugin = (IJsPlugin)this.mActivatedPlugins.get(str);
      paramString = localIJsPlugin;
    } while (localIJsPlugin != null);
    return createJsPlugin(str);
  }
  
  protected final IJsPlugin getSecondaryEventHandler(String paramString)
  {
    String str = (String)this.mSecondaryEventPluginMap.get(paramString);
    if (str == null) {
      paramString = null;
    }
    IJsPlugin localIJsPlugin;
    do
    {
      return paramString;
      localIJsPlugin = (IJsPlugin)this.mActivatedPlugins.get(str);
      paramString = localIJsPlugin;
    } while (localIJsPlugin != null);
    return createJsPlugin(str);
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    this.mEventPluginMap.putAll(JsPluginList.getEventPluginMap(parambglv.b()));
    this.mSecondaryEventPluginMap.putAll(JsPluginList.getSecondaryEventPluginMap(parambglv.b()));
    parambglv = JsPluginList.getPreloadPlugins(parambglv.b()).iterator();
    while (parambglv.hasNext()) {
      createJsPlugin((String)parambglv.next());
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
    ThreadManager.a(new JsPluginEngine.1(this, paramString, paramMiniAppInfo), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine
 * JD-Core Version:    0.7.0.1
 */