package com.tencent.mobileqq.qroute;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.annotation.QPlugin;
import com.tencent.mobileqq.qroute.exception.QRoutePluginException;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.route.ILogger;
import com.tencent.mobileqq.qroute.utils.APICycleInitCheckUtil;
import java.util.concurrent.ConcurrentHashMap;

class SingletonPool
{
  private static final ConcurrentHashMap<Class<?>, Object> SINGLETON_POOL = new ConcurrentHashMap(512);
  private static final String TAG = "SingletonPool";
  
  static IQRoutePlugin fetchPluginFromApiClass(Class paramClass)
  {
    Object localObject = paramClass.getAnnotation(QPlugin.class);
    if ((localObject instanceof QPlugin))
    {
      String str = ((QPlugin)localObject).name();
      localObject = str;
      if (QRoute.mConfig.isForceCheck())
      {
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          localObject = new StringBuilder(50);
          ((StringBuilder)localObject).append("QRouteApi: ").append(paramClass.getSimpleName()).append(" 接口声明的QRoute不能为空，必须声明为对应的模块id ").append("  \n");
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
    }
    else
    {
      localObject = null;
    }
    return QRoute.plugin((String)localObject);
  }
  
  @NonNull
  static <T> T get(Class<T> paramClass, String paramString, boolean paramBoolean)
  {
    if ((paramClass == null) || (paramString == null) || (paramString.length() == 0)) {
      throw new IllegalStateException("args null! ");
    }
    Object localObject;
    try
    {
      localObject = getInstance(paramClass, paramString, paramBoolean);
      if (localObject == null) {
        throw new IllegalStateException("getInstance null! @" + paramString);
      }
    }
    catch (Exception paramString)
    {
      APICycleInitCheckUtil.removeOnException();
      paramClass = "build API fatal:" + paramClass.getSimpleName() + " " + paramString.toString();
      QRoute.logger.warning("SingletonPool", paramClass, paramString);
      throw new IllegalStateException(paramClass, paramString);
    }
    return localObject;
  }
  
  @Nullable
  private static Object getInstance(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    Object localObject2 = SINGLETON_POOL.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      synchronized (SINGLETON_POOL)
      {
        localObject2 = SINGLETON_POOL.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label125;
        }
        if (!APICycleInitCheckUtil.checkAndSet(paramString))
        {
          APICycleInitCheckUtil.removeOnException();
          paramClass = "find cycle init from:" + paramString;
          QRoute.logger.warning("SingletonPool", paramClass);
          throw new IllegalStateException(paramClass);
        }
      }
      localObject1 = loadImplClass(paramClass, paramString, paramBoolean).newInstance();
      if (localObject1 != null) {
        SINGLETON_POOL.put(paramClass, localObject1);
      }
      APICycleInitCheckUtil.checkAndRemove(paramString);
    }
    label125:
    return localObject1;
  }
  
  private static Class loadClassFromPlugin(Class paramClass, String paramString)
  {
    IQRoutePlugin localIQRoutePlugin = fetchPluginFromApiClass(paramClass);
    if (localIQRoutePlugin == null)
    {
      paramString = new StringBuilder(50);
      paramString.append("QRouteApi: ").append(paramClass.getSimpleName()).append(" your api class need @QPlugin(name='{pluginId}') ").append(localIQRoutePlugin.pluginId());
      throw new QRoutePluginException(paramString.toString());
    }
    if (!localIQRoutePlugin.exist())
    {
      QRoute.logger.warning("QRoute", " plugin no exist: " + localIQRoutePlugin.pluginId());
      paramString = new StringBuilder(50);
      paramString.append("QRouteApi: ").append(paramClass.getSimpleName()).append(" plugin no exist: ").append(localIQRoutePlugin.pluginId()).append(" you may create plugin \n");
      throw new QRoutePluginException(paramString.toString());
    }
    if (!localIQRoutePlugin.isInstalled())
    {
      paramString = new StringBuilder(50);
      paramString.append("QRouteApi: ").append(paramClass.getSimpleName()).append(" plugin not installed ").append(localIQRoutePlugin).append(" you may call QRoute.plugin(plugin).install() first before you call QRoute.apiFromPlugin) \n");
      throw new QRoutePluginException(paramString.toString());
    }
    try
    {
      paramClass = localIQRoutePlugin.loadPluginClass(paramString);
      if (paramClass == null)
      {
        paramClass = new StringBuilder(50);
        paramClass.append("QRouteApi: ").append(paramString).append(" ClassNotFound in plugin=").append(localIQRoutePlugin).append(" \n");
        throw new QRoutePluginException(paramClass.toString());
      }
    }
    catch (Exception paramClass)
    {
      throw new QRoutePluginException(paramClass);
    }
    return paramClass;
  }
  
  static Class loadImplClass(Class paramClass, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return loadClassFromPlugin(paramClass, paramString);
    }
    return Class.forName(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.SingletonPool
 * JD-Core Version:    0.7.0.1
 */