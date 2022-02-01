package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.core.utils.ReflectionUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JsPluginList
{
  private static final String APP_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.AppJsPluginScope";
  private static final boolean DEBUG = false;
  private static final String EVENTS_HANDLES = "EVENT_HANDLERS";
  private static final String EXT_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope";
  private static final String GAME_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.GameJsPluginScope";
  private static final String GENERATED_PACKAGE = "com.tencent.qqmini.sdk.core.generated.";
  private static final String MAP_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.MapJsPluginScope";
  private static final String PRELOAD_PLUGINS = "PRELOAD_PLUGINS";
  private static final String SDK_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.SdkJsPluginScope";
  private static final String SECONDARY_EVENT_HANDLERS = "SECONDARY_EVENT_HANDLERS";
  private static final String TAG = "JsPluginList";
  private static Map<Class, String> sPluginScope = new HashMap();
  
  public static void clear()
  {
    sPluginScope.clear();
  }
  
  private static void fillEventPluginMap(String paramString, Map<String, Class> paramMap)
  {
    Iterator localIterator = getEventHandlersByScope(paramString).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (Class)((Map.Entry)localObject).getValue();
      if (paramMap.containsKey(str))
      {
        QMLog.w("JsPluginList", "register JsPlugin, conflict event:" + str);
      }
      else
      {
        paramMap.put(str, localObject);
        sPluginScope.put(localObject, paramString);
      }
    }
  }
  
  private static void fillPreloadPlugins(String paramString, List<Class> paramList)
  {
    paramString = getPreloadPluginsByScope(paramString).iterator();
    while (paramString.hasNext()) {
      paramList.add((Class)paramString.next());
    }
  }
  
  private static void fillSecondaryEventPluginMap(String paramString, Map<String, Class> paramMap)
  {
    Iterator localIterator = getSecondaryEventHandlersByScope(paramString).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (Class)((Map.Entry)localObject).getValue();
      if (paramMap.containsKey(str))
      {
        QMLog.w("JsPluginList", "register Secondary JsPlugin, conflict event:" + str);
      }
      else
      {
        paramMap.put(str, localObject);
        sPluginScope.put(localObject, paramString);
      }
    }
  }
  
  private static Map<String, Class> getEventHandlersByScope(String paramString)
  {
    paramString = ReflectionUtil.getStaticField(paramString, "EVENT_HANDLERS");
    if ((paramString instanceof Map)) {
      return (Map)paramString;
    }
    return new HashMap();
  }
  
  public static Map<String, Class> getEventPluginMap(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    fillEventPluginMap("com.tencent.qqmini.sdk.core.generated.SdkJsPluginScope", localHashMap);
    if (paramBoolean) {}
    for (String str = "com.tencent.qqmini.sdk.core.generated.GameJsPluginScope";; str = "com.tencent.qqmini.sdk.core.generated.AppJsPluginScope")
    {
      fillEventPluginMap(str, localHashMap);
      fillEventPluginMap("com.tencent.qqmini.sdk.core.generated.MapJsPluginScope", localHashMap);
      fillEventPluginMap("com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope", localHashMap);
      QMLog.i("JsPluginList", "Registered events size: " + localHashMap.keySet().size());
      return localHashMap;
    }
  }
  
  public static Method getMethod(Class paramClass, String paramString)
  {
    if ((paramClass == null) || (paramString == null)) {
      return null;
    }
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int k = arrayOfMethod.length;
    int i = 0;
    if (i < k)
    {
      Method localMethod = arrayOfMethod[i];
      if (!localMethod.isAnnotationPresent(JsEvent.class)) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = ((JsEvent)localMethod.getAnnotation(JsEvent.class)).value();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          if (arrayOfString[j].equals(paramString)) {
            return localMethod;
          }
          j += 1;
        }
      }
    }
    QMLog.w("JsPluginList", "Failed to getMethod in JsPlugin " + paramClass + " for event " + paramString);
    return null;
  }
  
  public static List<Class> getPreloadPlugins(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    fillPreloadPlugins("com.tencent.qqmini.sdk.core.generated.SdkJsPluginScope", localArrayList);
    if (paramBoolean) {}
    for (String str = "com.tencent.qqmini.sdk.core.generated.GameJsPluginScope";; str = "com.tencent.qqmini.sdk.core.generated.AppJsPluginScope")
    {
      fillPreloadPlugins(str, localArrayList);
      fillPreloadPlugins("com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope", localArrayList);
      return localArrayList;
    }
  }
  
  private static List<Class> getPreloadPluginsByScope(String paramString)
  {
    paramString = ReflectionUtil.getStaticField(paramString, "PRELOAD_PLUGINS");
    if ((paramString instanceof List)) {
      return (List)paramString;
    }
    return new ArrayList();
  }
  
  private static Map<String, Class> getSecondaryEventHandlersByScope(String paramString)
  {
    paramString = ReflectionUtil.getStaticField(paramString, "SECONDARY_EVENT_HANDLERS");
    if ((paramString instanceof Map)) {
      return (Map)paramString;
    }
    return new HashMap();
  }
  
  public static Map<String, Class> getSecondaryEventPluginMap(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    fillSecondaryEventPluginMap("com.tencent.qqmini.sdk.core.generated.SdkJsPluginScope", localHashMap);
    if (paramBoolean) {}
    for (String str = "com.tencent.qqmini.sdk.core.generated.GameJsPluginScope";; str = "com.tencent.qqmini.sdk.core.generated.AppJsPluginScope")
    {
      fillSecondaryEventPluginMap(str, localHashMap);
      fillSecondaryEventPluginMap("com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope", localHashMap);
      QMLog.i("JsPluginList", "Registered secondary events size: " + localHashMap.keySet().size());
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.JsPluginList
 * JD-Core Version:    0.7.0.1
 */