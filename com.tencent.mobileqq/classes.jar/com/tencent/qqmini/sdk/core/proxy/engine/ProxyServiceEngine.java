package com.tencent.qqmini.sdk.core.proxy.engine;

import bgpn;
import com.tencent.qqmini.sdk.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProxyServiceEngine
{
  private static final String TAG = "ProxyServiceEngine";
  private static final ProxyServiceEngine sInstance = new ProxyServiceEngine();
  private Map<String, Object> mActivatedServices = new HashMap();
  private Map<String, String> mProxyServicesMap = ProxyServiceList.get();
  
  public static ProxyServiceEngine g()
  {
    return sInstance;
  }
  
  public Object getProxyService(Class paramClass)
  {
    return getProxyService(paramClass.getName());
  }
  
  public Object getProxyService(String paramString)
  {
    String str = (String)this.mProxyServicesMap.get(paramString);
    if (str == null)
    {
      QMLog.w("ProxyServiceEngine", "Can NOT find service class by proxy name: " + paramString);
      return null;
    }
    Object localObject = this.mActivatedServices.get(str);
    if (localObject != null) {
      return localObject;
    }
    paramString = localObject;
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        paramString = bgpn.a(str);
        if (paramString == null)
        {
          QMLog.e("ProxyServiceEngine", "Failed to create the service object of " + str);
          return paramString;
        }
      }
      finally {}
      QMLog.i("ProxyServiceEngine", "Create a new proxy service object of " + str);
      this.mActivatedServices.put(str, paramString);
    }
  }
  
  public void injectPluginProxyServices(IJsPlugin paramIJsPlugin, Map<String, String> paramMap)
  {
    if ((paramIJsPlugin == null) || (paramMap == null) || (paramMap.size() == 0)) {}
    for (;;)
    {
      return;
      QMLog.i("ProxyServiceEngine", "injectPluginService " + paramMap.values() + " to plugin " + paramIJsPlugin);
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        try
        {
          Field localField = paramIJsPlugin.getClass().getDeclaredField((String)localObject);
          localField.setAccessible(true);
          localObject = getProxyService((String)paramMap.get(localObject));
          if (localObject != null) {
            localField.set(paramIJsPlugin, localObject);
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.engine.ProxyServiceEngine
 * JD-Core Version:    0.7.0.1
 */