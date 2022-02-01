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
      if (QRoute.mConfig.isForceCheck()) {
        if (!TextUtils.isEmpty(str))
        {
          localObject = str;
        }
        else
        {
          localObject = new StringBuilder(50);
          ((StringBuilder)localObject).append("QRouteApi: ");
          ((StringBuilder)localObject).append(paramClass.getSimpleName());
          ((StringBuilder)localObject).append(" 接口声明的QRoute不能为空，必须声明为对应的模块id ");
          ((StringBuilder)localObject).append("  \n");
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
    if ((paramClass != null) && (paramString != null) && (paramString.length() != 0)) {
      try
      {
        localObject = getInstance(paramClass, paramString, paramBoolean);
        if (localObject != null) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getInstance null! @");
        ((StringBuilder)localObject).append(paramString);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      catch (Exception paramString)
      {
        APICycleInitCheckUtil.removeOnException();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("build API fatal:");
        ((StringBuilder)localObject).append(paramClass.getSimpleName());
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString.toString());
        paramClass = ((StringBuilder)localObject).toString();
        QRoute.logger.warning("SingletonPool", paramClass, paramString);
        throw new IllegalStateException(paramClass, paramString);
      }
    }
    throw new IllegalStateException("args null! ");
  }
  
  @Nullable
  private static Object getInstance(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    Object localObject1 = SINGLETON_POOL.get(paramClass);
    if (localObject1 == null) {
      synchronized (SINGLETON_POOL)
      {
        Object localObject2 = SINGLETON_POOL.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 == null) {
          if (APICycleInitCheckUtil.checkAndSet(paramString))
          {
            localObject1 = loadImplClass(paramClass, paramString, paramBoolean).newInstance();
            if (localObject1 != null) {
              SINGLETON_POOL.put(paramClass, localObject1);
            }
            APICycleInitCheckUtil.checkAndRemove(paramString);
          }
          else
          {
            APICycleInitCheckUtil.removeOnException();
            paramClass = new StringBuilder();
            paramClass.append("find cycle init from:");
            paramClass.append(paramString);
            paramClass = paramClass.toString();
            QRoute.logger.warning("SingletonPool", paramClass);
            throw new IllegalStateException(paramClass);
          }
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  private static Class loadClassFromPlugin(Class paramClass, String paramString)
  {
    IQRoutePlugin localIQRoutePlugin = fetchPluginFromApiClass(paramClass);
    if (localIQRoutePlugin != null)
    {
      if (localIQRoutePlugin.exist())
      {
        if (localIQRoutePlugin.isInstalled()) {
          try
          {
            paramClass = localIQRoutePlugin.loadPluginClass(paramString);
            if (paramClass != null) {
              return paramClass;
            }
            paramClass = new StringBuilder(50);
            paramClass.append("QRouteApi: ");
            paramClass.append(paramString);
            paramClass.append(" ClassNotFound in plugin=");
            paramClass.append(localIQRoutePlugin);
            paramClass.append(" \n");
            throw new QRoutePluginException(paramClass.toString());
          }
          catch (Exception paramClass)
          {
            throw new QRoutePluginException(paramClass);
          }
        }
        paramString = new StringBuilder(50);
        paramString.append("QRouteApi: ");
        paramString.append(paramClass.getSimpleName());
        paramString.append(" plugin not installed ");
        paramString.append(localIQRoutePlugin);
        paramString.append(" you may call QRoute.plugin(plugin).install() first before you call QRoute.apiFromPlugin) \n");
        throw new QRoutePluginException(paramString.toString());
      }
      paramString = QRoute.logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" plugin no exist: ");
      localStringBuilder.append(localIQRoutePlugin.pluginId());
      paramString.warning("QRoute", localStringBuilder.toString());
      paramString = new StringBuilder(50);
      paramString.append("QRouteApi: ");
      paramString.append(paramClass.getSimpleName());
      paramString.append(" plugin no exist: ");
      paramString.append(localIQRoutePlugin.pluginId());
      paramString.append(" you may create plugin \n");
      throw new QRoutePluginException(paramString.toString());
    }
    paramString = new StringBuilder(50);
    paramString.append("QRouteApi: ");
    paramString.append(paramClass.getSimpleName());
    paramString.append(" your api class need @QPlugin(name='{pluginId}') ");
    paramString.append(localIQRoutePlugin.pluginId());
    throw new QRoutePluginException(paramString.toString());
  }
  
  static Class loadImplClass(Class paramClass, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return loadClassFromPlugin(paramClass, paramString);
    }
    return Class.forName(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.SingletonPool
 * JD-Core Version:    0.7.0.1
 */