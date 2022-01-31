package com.tencent.qqmini.sdk.core.plugins.engine;

import android.content.Context;
import begz;
import beiw;
import beka;
import besl;
import com.tencent.qqmini.sdk.core.plugins.IJsPlugin;
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
  private final Map<String, IJsPlugin> mActivatedPlugins = new HashMap();
  private final Map<String, String> mEventPluginMap = new HashMap();
  private Map<String, WeakReference<Method>> mMethodCache = new ConcurrentHashMap();
  
  public JsPluginEngine(Context paramContext)
  {
    super(paramContext);
  }
  
  private static String buildMessage(String paramString, beka parambeka)
  {
    return paramString + "eventName=" + parambeka.jdField_a_of_type_JavaLangString + ", " + "jsonParams=" + parambeka.jdField_b_of_type_JavaLangString + ", " + "callbackId=" + parambeka.jdField_b_of_type_Int + "jsService=" + parambeka.jdField_a_of_type_Begy;
  }
  
  /* Error */
  private IJsPlugin createJsPlugin(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 87	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginEngine:mMiniAppContext	Lbegz;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 8
    //   11: ldc 89
    //   13: invokestatic 95	besl:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_3
    //   21: areturn
    //   22: aload_0
    //   23: getfield 28	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginEngine:mActivatedPlugins	Ljava/util/Map;
    //   26: aload_1
    //   27: invokeinterface 101 2 0
    //   32: checkcast 103	com/tencent/qqmini/sdk/core/plugins/IJsPlugin
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: ifnonnull -24 -> 18
    //   45: aload_1
    //   46: invokestatic 108	bekz:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_3
    //   51: instanceof 103
    //   54: istore_2
    //   55: iload_2
    //   56: ifeq +59 -> 115
    //   59: aload_3
    //   60: checkcast 103	com/tencent/qqmini/sdk/core/plugins/IJsPlugin
    //   63: astore_3
    //   64: aload_3
    //   65: invokestatic 114	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginList:getServiceInjectors	(Lcom/tencent/qqmini/sdk/core/plugins/IJsPlugin;)Ljava/util/Map;
    //   68: astore 4
    //   70: invokestatic 120	com/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine:g	()Lcom/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine;
    //   73: aload_3
    //   74: aload 4
    //   76: invokevirtual 124	com/tencent/qqmini/sdk/core/proxy/engine/ProxyServiceEngine:injectPluginProxyServices	(Lcom/tencent/qqmini/sdk/core/plugins/IJsPlugin;Ljava/util/Map;)V
    //   79: aload_3
    //   80: aload_0
    //   81: getfield 87	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginEngine:mMiniAppContext	Lbegz;
    //   84: invokeinterface 128 2 0
    //   89: aload_0
    //   90: getfield 28	com/tencent/qqmini/sdk/core/plugins/engine/JsPluginEngine:mActivatedPlugins	Ljava/util/Map;
    //   93: aload_1
    //   94: aload_3
    //   95: invokeinterface 132 3 0
    //   100: pop
    //   101: goto -83 -> 18
    //   104: astore_1
    //   105: ldc 8
    //   107: aload_1
    //   108: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: aload_1
    //   112: invokestatic 139	besl:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
  
  public String dispatchRequestEvent(beka parambeka)
  {
    IJsPlugin localIJsPlugin = getEventHandler(parambeka.jdField_a_of_type_JavaLangString);
    if (localIJsPlugin == null)
    {
      besl.c("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest failed, event not support!", parambeka));
      return "";
    }
    if (localIJsPlugin.onInterceptJsEvent(parambeka))
    {
      besl.b("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest aborted, event is intercepted", parambeka));
      return "";
    }
    reportApiInvoke(this.mMiniAppContext.a(), parambeka.jdField_a_of_type_JavaLangString);
    str1 = JsPluginList.getMethodName(localIJsPlugin, parambeka.jdField_a_of_type_JavaLangString);
    try
    {
      str2 = localIJsPlugin.getClass().getName() + "." + str1;
      localObject1 = (WeakReference)this.mMethodCache.get(str2);
      if (localObject1 == null) {
        break label431;
      }
      localObject1 = (Method)((WeakReference)localObject1).get();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      String str2;
      Object localObject1;
      Object localObject3;
      besl.c("JsPluginEngine[Dispatcher]", "dispatchEvent " + parambeka.jdField_a_of_type_JavaLangString + " failed, can NOT find declared method " + str1, localNoSuchMethodException);
      parambeka.b();
      return "";
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        besl.c("JsPluginEngine[Dispatcher]", "dispatchEvent " + parambeka.jdField_a_of_type_JavaLangString + " failed, " + str1 + " access exception " + localIllegalAccessException.getMessage(), localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        besl.c("JsPluginEngine[Dispatcher]", "dispatchEvent " + parambeka.jdField_a_of_type_JavaLangString + " failed, " + str1 + " invoke exception " + localInvocationTargetException.getMessage(), localInvocationTargetException);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        besl.c("JsPluginEngine[Dispatcher]", "dispatchEvent " + parambeka.jdField_a_of_type_JavaLangString + " failed, " + str1 + " runtime exception " + localRuntimeException.getMessage(), localRuntimeException);
        continue;
        Object localObject2 = null;
      }
    }
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = localIJsPlugin.getClass().getDeclaredMethod(str1, new Class[] { beka.class });
      ((Method)localObject3).setAccessible(true);
      this.mMethodCache.put(str2, new WeakReference(localObject3));
    }
    localObject1 = ((Method)localObject3).invoke(localIJsPlugin, new Object[] { parambeka });
    if (localObject1 == null) {
      return "";
    }
    localObject1 = localObject1.toString();
    return localObject1;
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
  
  public void onCreate(begz parambegz)
  {
    super.onCreate(parambegz);
    this.mEventPluginMap.putAll(JsPluginList.getEventPluginMap(parambegz.e()));
    parambegz = JsPluginList.getPreloadPlugins(parambegz.e()).iterator();
    while (parambegz.hasNext()) {
      createJsPlugin((String)parambegz.next());
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
    beiw.a(new JsPluginEngine.1(this, paramString, paramMiniAppInfo), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine
 * JD-Core Version:    0.7.0.1
 */