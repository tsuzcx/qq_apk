package com.tencent.qqmini.sdk.plugins.engine;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MiniAppJsPluginEngine
  extends JsPluginEngine
{
  private final Map<String, WeakReference<Method>> a = new ConcurrentHashMap();
  
  public MiniAppJsPluginEngine(Context paramContext)
  {
    super(paramContext);
  }
  
  protected String dispatchRequestEventToPlugin(RequestEvent paramRequestEvent, IJsPlugin paramIJsPlugin)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramIJsPlugin.getClass().getCanonicalName());
      ((StringBuilder)localObject1).append(".");
      ((StringBuilder)localObject1).append(paramRequestEvent.event);
      str = ((StringBuilder)localObject1).toString();
      localObject1 = (WeakReference)this.a.get(str);
      if (localObject1 != null) {
        localObject1 = (Method)((WeakReference)localObject1).get();
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label474;
      }
      localObject3 = localObject1;
      localObject4 = localObject1;
    }
    catch (RuntimeException localRuntimeException1)
    {
      Object localObject1;
      String str;
      paramIJsPlugin = (IJsPlugin)localObject2;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dispatchEvent ");
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" failed, method = ");
      ((StringBuilder)localObject2).append(paramIJsPlugin);
      ((StringBuilder)localObject2).append(", runtime exception ");
      ((StringBuilder)localObject2).append(localRuntimeException1.getMessage());
      QMLog.w("JsPluginEngine[Dispatcher]", ((StringBuilder)localObject2).toString(), localRuntimeException1);
    }
    catch (InvocationTargetException localInvocationTargetException1)
    {
      paramIJsPlugin = localObject3;
      label293:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dispatchEvent ");
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" failed, method = ");
      ((StringBuilder)localObject2).append(paramIJsPlugin);
      ((StringBuilder)localObject2).append(", invoke exception ");
      ((StringBuilder)localObject2).append(localInvocationTargetException1.getMessage());
      QMLog.w("JsPluginEngine[Dispatcher]", ((StringBuilder)localObject2).toString(), localInvocationTargetException1);
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      label215:
      paramIJsPlugin = localObject4;
    }
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
      this.a.put(str, new WeakReference(localObject2));
    }
    catch (RuntimeException localRuntimeException2)
    {
      paramIJsPlugin = localObject3;
      break label215;
    }
    catch (InvocationTargetException localInvocationTargetException2)
    {
      paramIJsPlugin = localObject4;
      break label293;
    }
    catch (IllegalAccessException localIllegalAccessException3)
    {
      for (;;)
      {
        paramIJsPlugin = localInvocationTargetException2;
        localIllegalAccessException2 = localIllegalAccessException3;
      }
    }
    localObject3 = localObject2;
    localObject4 = localObject2;
    localObject1 = localObject2;
    for (paramIJsPlugin = ((Method)localObject2).invoke(paramIJsPlugin, new Object[] { paramRequestEvent }); paramIJsPlugin != null; paramIJsPlugin = localObject5)
    {
      localObject3 = localObject2;
      localObject4 = localObject2;
      localObject1 = localObject2;
      paramIJsPlugin = paramIJsPlugin.toString();
      return paramIJsPlugin;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dispatchEvent ");
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" failed, method = ");
      ((StringBuilder)localObject2).append(paramIJsPlugin);
      ((StringBuilder)localObject2).append(", access exception ");
      ((StringBuilder)localObject2).append(localIllegalAccessException1.getMessage());
      QMLog.w("JsPluginEngine[Dispatcher]", ((StringBuilder)localObject2).toString(), localIllegalAccessException1);
      paramRequestEvent.fail();
      return "";
      IllegalAccessException localIllegalAccessException2;
      label474:
      if (localIllegalAccessException3 != null) {
        break;
      }
    }
    return "";
  }
  
  void fillEventPluginMap(Map<String, Class> paramMap1, Map<String, Class> paramMap2)
  {
    paramMap1.putAll(JsPluginList.getEventPluginMap(false));
    paramMap2.putAll(JsPluginList.getSecondaryEventPluginMap(false));
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    if ((this.mActivatedPlugins != null) && (this.mActivatedPlugins.size() > 0))
    {
      Iterator localIterator = this.mActivatedPlugins.values().iterator();
      while (localIterator.hasNext()) {
        ((IJsPlugin)localIterator.next()).onCreate(paramIMiniAppContext);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.MiniAppJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */