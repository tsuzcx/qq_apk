package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePluginManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePluginManager.PluginInfo;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class NativeFeatureJsPlugin
  extends BaseJsPlugin
{
  public static final String API_INVOKE_NATIVE_PLUGIN = "invokeNativePlugin";
  private static final String TAG = "NativeFeatureJsPlugin";
  Set<String> eventMap = new HashSet();
  Map<String, NativePlugin> plugins;
  
  public NativeFeatureJsPlugin()
  {
    this.eventMap.add("invokeNativePlugin");
    initializeNativePlugins();
  }
  
  private NativePlugin initPlugin(NativePluginManager.PluginInfo paramPluginInfo)
  {
    try
    {
      Class localClass = Class.forName(paramPluginInfo.getHandlerClass());
      if (!NativePlugin.class.isAssignableFrom(localClass))
      {
        QLog.e("NativeFeatureJsPlugin", 2, String.format("class [%s] should implements com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin", new Object[] { paramPluginInfo.getHandlerClass() }));
        return null;
      }
      QLog.i("NativeFeatureJsPlugin", 2, String.format("class [%s] initialized", new Object[] { paramPluginInfo.getHandlerClass() }));
      paramPluginInfo = (NativePlugin)NativePlugin.class.cast(localClass.newInstance());
      return paramPluginInfo;
    }
    catch (Throwable paramPluginInfo)
    {
      QLog.e("NativeFeatureJsPlugin", 2, "initPlugin err", paramPluginInfo);
    }
    return null;
  }
  
  private void initializeNativePlugins()
  {
    Object localObject = NativePluginManager.getPluginInfo();
    this.plugins = new ConcurrentHashMap(((Set)localObject).size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      NativePluginManager.PluginInfo localPluginInfo = (NativePluginManager.PluginInfo)((Iterator)localObject).next();
      this.plugins.put(localPluginInfo.getApi_name(), initPlugin(localPluginInfo));
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    try
    {
      if (paramString1.equals("invokeNativePlugin"))
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        Object localObject = localJSONObject.optString("api_name", null);
        localObject = (NativePlugin)this.plugins.get(localObject);
        if (localObject != null) {
          ((NativePlugin)localObject).onInvoke(localJSONObject, new NativeFeatureJsPlugin.JSContextImpl(paramJsRuntime, paramString1, paramInt));
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("NativeFeatureJsPlugin", 1, "handleNativeRequest err", localThrowable);
      }
    }
    return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.plugins != null) && (this.plugins.size() > 0))
    {
      Iterator localIterator = this.plugins.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          NativePlugin localNativePlugin = (NativePlugin)((Map.Entry)localIterator.next()).getValue();
          if (localNativePlugin != null) {
            try
            {
              localNativePlugin.onDestroy();
            }
            catch (Throwable localThrowable)
            {
              QLog.e("NativeFeatureJsPlugin", 2, "destroy err", localThrowable);
            }
          }
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NativeFeatureJsPlugin
 * JD-Core Version:    0.7.0.1
 */