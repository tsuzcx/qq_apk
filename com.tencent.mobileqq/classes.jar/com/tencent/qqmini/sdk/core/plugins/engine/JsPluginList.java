package com.tencent.qqmini.sdk.core.plugins.engine;

import bgpn;
import com.tencent.qqmini.sdk.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
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
  private static final String EXT_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope";
  private static final String GAME_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.GameJsPluginScope";
  private static final String GENERATED_PACKAGE = "com.tencent.qqmini.sdk.core.generated.";
  private static final String MAP_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.MapJsPluginScope";
  private static final String PLUGIN_EVENTS = "PLUGIN_EVENTS";
  private static final String PRELOAD_PLUGINS = "PRELOAD_PLUGINS";
  private static final String SDK_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.SdkJsPluginScope";
  private static final String SECONDARY_PLUGIN_EVENTS = "SECONDARY_PLUGIN_EVENTS";
  private static final String TAG = "JsPluginList";
  private static Map<String, String> sPluginScope = new HashMap();
  
  public static void clear()
  {
    sPluginScope.clear();
  }
  
  private static void fillEventPluginMap(String paramString, Map<String, String> paramMap)
  {
    Iterator localIterator = getPluginEventsByScope(paramString).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str1 = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map)((Map.Entry)localObject).getValue()).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if (paramMap.containsKey(str2)) {
          QMLog.w("JsPluginList", "register JsPlugin, conflict event:" + str2);
        } else {
          paramMap.put(str2, str1);
        }
      }
      sPluginScope.put(str1, paramString);
    }
  }
  
  private static void fillPreloadPlugins(String paramString, List<String> paramList)
  {
    paramString = getPreloadPluginsByScope(paramString).iterator();
    while (paramString.hasNext()) {
      paramList.add((String)paramString.next());
    }
  }
  
  private static void fillSecondaryEventPluginMap(String paramString, Map<String, String> paramMap)
  {
    Iterator localIterator = getSecondaryPluginEventsByScope(paramString).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str1 = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map)((Map.Entry)localObject).getValue()).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if (paramMap.containsKey(str2)) {
          QMLog.w("JsPluginList", "register Secondary JsPlugin, conflict event:" + str2);
        } else {
          paramMap.put(str2, str1);
        }
      }
      sPluginScope.put(str1, paramString);
    }
  }
  
  public static Map<String, String> getEventPluginMap(boolean paramBoolean)
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
  
  public static String getMethodName(IJsPlugin paramIJsPlugin, String paramString)
  {
    if ((paramIJsPlugin == null) || (paramString == null)) {
      return null;
    }
    String str = "EVENT_HANDLERS_" + paramIJsPlugin.getClass().getSimpleName();
    paramIJsPlugin = bgpn.a((String)sPluginScope.get(paramIJsPlugin.getClass().getName()), str);
    if ((paramIJsPlugin instanceof Map))
    {
      paramIJsPlugin = ((Map)paramIJsPlugin).get(paramString);
      if ((paramIJsPlugin instanceof String)) {
        return (String)paramIJsPlugin;
      }
    }
    return null;
  }
  
  private static Map<String, Map> getPluginEventsByScope(String paramString)
  {
    paramString = bgpn.a(paramString, "PLUGIN_EVENTS");
    if ((paramString instanceof Map)) {
      return (Map)paramString;
    }
    return new HashMap();
  }
  
  public static List<String> getPreloadPlugins(boolean paramBoolean)
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
  
  private static List<String> getPreloadPluginsByScope(String paramString)
  {
    paramString = bgpn.a(paramString, "PRELOAD_PLUGINS");
    if ((paramString instanceof List)) {
      return (List)paramString;
    }
    return new ArrayList();
  }
  
  public static Map<String, String> getSecondaryEventPluginMap(boolean paramBoolean)
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
  
  private static Map<String, Map> getSecondaryPluginEventsByScope(String paramString)
  {
    paramString = bgpn.a(paramString, "SECONDARY_PLUGIN_EVENTS");
    if ((paramString instanceof Map)) {
      return (Map)paramString;
    }
    return new HashMap();
  }
  
  public static Map<String, String> getServiceInjectors(IJsPlugin paramIJsPlugin)
  {
    String str = "SERVICE_INJECTORS_" + paramIJsPlugin.getClass().getSimpleName();
    paramIJsPlugin = bgpn.a((String)sPluginScope.get(paramIJsPlugin.getClass().getName()), str);
    if ((paramIJsPlugin instanceof Map)) {
      return (Map)paramIJsPlugin;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.JsPluginList
 * JD-Core Version:    0.7.0.1
 */