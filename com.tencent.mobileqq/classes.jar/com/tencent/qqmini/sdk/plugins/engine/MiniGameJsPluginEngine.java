package com.tencent.qqmini.sdk.plugins.engine;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MiniGameJsPluginEngine
  extends JsPluginEngine
{
  private static final Object a = new Object();
  private final Map<String, MethodItem> b = new ConcurrentHashMap();
  
  public MiniGameJsPluginEngine(Context paramContext)
  {
    super(paramContext);
  }
  
  @Nullable
  private MethodItem a(RequestEvent paramRequestEvent, IJsPlugin paramIJsPlugin)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramIJsPlugin.getClass().getCanonicalName());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramRequestEvent.event);
    String str = ((StringBuilder)localObject).toString();
    MethodItem localMethodItem = (MethodItem)this.b.get(str);
    localObject = localMethodItem;
    if (localMethodItem == null)
    {
      paramRequestEvent = JsPluginList.getMethodItem(paramIJsPlugin.getClass(), paramRequestEvent.event);
      localObject = paramRequestEvent;
      if (paramRequestEvent != null)
      {
        paramRequestEvent.a.setAccessible(true);
        this.b.put(str, paramRequestEvent);
        localObject = paramRequestEvent;
      }
    }
    return localObject;
  }
  
  private Object a(Method paramMethod, IJsPlugin paramIJsPlugin, RequestEvent paramRequestEvent)
  {
    try
    {
      paramIJsPlugin = paramMethod.invoke(paramIJsPlugin, new Object[] { paramRequestEvent });
      return paramIJsPlugin;
    }
    catch (InvocationTargetException paramIJsPlugin)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchEvent ");
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" failed, method = ");
      localStringBuilder.append(paramMethod);
      localStringBuilder.append(", invoke exception ");
      localStringBuilder.append(paramIJsPlugin.getMessage());
      QMLog.w("JsPluginEngine[Dispatcher]", localStringBuilder.toString(), paramIJsPlugin);
    }
    catch (IllegalAccessException paramIJsPlugin)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchEvent ");
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" failed, method = ");
      localStringBuilder.append(paramMethod);
      localStringBuilder.append(", access exception ");
      localStringBuilder.append(paramIJsPlugin.getMessage());
      QMLog.w("JsPluginEngine[Dispatcher]", localStringBuilder.toString(), paramIJsPlugin);
    }
    return a;
  }
  
  protected String dispatchRequestEventToPlugin(RequestEvent paramRequestEvent, IJsPlugin paramIJsPlugin)
  {
    MethodItem localMethodItem = a(paramRequestEvent, paramIJsPlugin);
    if (localMethodItem == null)
    {
      paramRequestEvent.fail();
      return "";
    }
    Method localMethod = localMethodItem.a;
    if (!localMethodItem.b)
    {
      ThreadManager.executeOnComputationThreadPool(new MiniGameJsPluginEngine.1(this, paramRequestEvent, localMethod, paramIJsPlugin));
      return "";
    }
    paramIJsPlugin = a(localMethodItem.a, paramIJsPlugin, paramRequestEvent);
    if (paramIJsPlugin == a)
    {
      paramRequestEvent.fail();
      return "";
    }
    if (paramIJsPlugin == null) {
      return "";
    }
    return paramIJsPlugin.toString();
  }
  
  void fillEventPluginMap(Map<String, Class> paramMap1, Map<String, Class> paramMap2)
  {
    paramMap1.putAll(JsPluginList.getEventPluginMap(true));
    paramMap2.putAll(JsPluginList.getSecondaryEventPluginMap(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */