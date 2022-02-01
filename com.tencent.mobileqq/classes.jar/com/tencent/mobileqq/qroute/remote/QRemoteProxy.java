package com.tencent.mobileqq.qroute.remote;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ILogger;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class QRemoteProxy
{
  private static final HashMap<String, Class<?>> CACHE_CLASS_MAP;
  private static final HashMap<String, Method> CACHE_METHOD_MAP = new HashMap(512);
  private static final ConcurrentHashMap<String, Object> CACHE_PROXY_CLASS_MAP;
  private static final Object LOCK_OBJECT = new Object();
  private static final String TAG = "QRemoteProxy";
  private static IQRemoteProxy mIQRemoteProxy;
  
  static
  {
    CACHE_CLASS_MAP = new HashMap(512);
    CACHE_PROXY_CLASS_MAP = new ConcurrentHashMap(512);
  }
  
  public static QRemoteResult callInMainProcess(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (QRoute.logger.isColorLevel())
    {
      localObject1 = QRoute.logger;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("action:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("  callbackId:");
      ((StringBuilder)localObject2).append(paramInt);
      ((ILogger)localObject1).debug("QRemoteProxy", ((StringBuilder)localObject2).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("$")))
    {
      localObject1 = paramString.split("\\$");
      if (localObject1.length != 3)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("wrong action, action = ");
        ((StringBuilder)localObject1).append(paramString);
        return new QRemoteResult(-101, paramBundle, new IllegalStateException(((StringBuilder)localObject1).toString()));
      }
      Object localObject3 = localObject1[1];
      localObject2 = localObject1[2];
      try
      {
        if (CACHE_CLASS_MAP.containsKey(localObject3))
        {
          localObject1 = (Class)CACHE_CLASS_MAP.get(localObject3);
        }
        else
        {
          localObject1 = Class.forName((String)localObject3);
          CACHE_CLASS_MAP.put(localObject3, localObject1);
        }
        localObject3 = QRoute.api((Class)localObject1);
        if (localObject3 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("qRouteApi is null, action = ");
          ((StringBuilder)localObject1).append(paramString);
          return new QRemoteResult(-101, paramBundle, new IllegalStateException(((StringBuilder)localObject1).toString()));
        }
        paramBundle.setClassLoader(((Class)localObject1).getClassLoader());
        ArrayList localArrayList = paramBundle.getStringArrayList("__parameterTypes__");
        paramInt = localArrayList.size();
        Class[] arrayOfClass = new Class[paramInt];
        Object[] arrayOfObject = new Object[paramInt];
        paramInt = 0;
        while (paramInt < localArrayList.size())
        {
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("__arg+");
          ((StringBuilder)localObject4).append(paramInt);
          ((StringBuilder)localObject4).append("__");
          localObject4 = ((StringBuilder)localObject4).toString();
          String str = (String)localArrayList.get(paramInt);
          arrayOfClass[paramInt] = RemoteProxyUtil.getClassFromName(str);
          arrayOfObject[paramInt] = RemoteProxyUtil.getBundleParameter(paramBundle, str, (String)localObject4);
          paramInt += 1;
        }
        if (CACHE_METHOD_MAP.get(paramString) != null)
        {
          paramString = (Method)CACHE_METHOD_MAP.get(paramString);
        }
        else
        {
          localObject1 = ((Class)localObject1).getDeclaredMethod((String)localObject2, arrayOfClass);
          CACHE_METHOD_MAP.put(paramString, localObject1);
          paramString = (String)localObject1;
        }
        localObject1 = paramString.invoke(localObject3, arrayOfObject);
        localObject2 = new QRemoteResult(0, paramBundle);
        RemoteProxyUtil.setBundleParameter(paramBundle, paramString.getReturnType().getName(), "result", localObject1);
        paramBundle.putString("resultType", paramString.getReturnType().getName());
        return localObject2;
      }
      catch (Exception paramString)
      {
        CACHE_METHOD_MAP.clear();
        paramString.printStackTrace();
        paramBundle = new QRemoteResult(-101, paramBundle, paramString);
        QRoute.logger.warning("QRemoteProxy", "onCall exception", paramString);
        return paramBundle;
      }
    }
    return new QRemoteResult(-101, paramBundle, new IllegalStateException("wrong acton"));
  }
  
  static void callServerAsync(String paramString, Bundle paramBundle, @NonNull IQRemoteResultCallback paramIQRemoteResultCallback)
  {
    Object localObject = mIQRemoteProxy;
    if (localObject == null)
    {
      paramBundle = QRoute.logger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callServerAsync before init, action=");
      ((StringBuilder)localObject).append(paramString);
      paramBundle.warning("QRemoteProxy", ((StringBuilder)localObject).toString());
      paramBundle = new StringBuilder();
      paramBundle.append("callServerAsync before init, action=");
      paramBundle.append(paramString);
      paramIQRemoteResultCallback.onCallback(new QRemoteResult(-101, new IllegalStateException(paramBundle.toString())));
      return;
    }
    ((IQRemoteProxy)localObject).callServerAsync(paramString, paramBundle, paramIQRemoteResultCallback);
  }
  
  @Nullable
  static QRemoteResult callServerSync(String paramString, Bundle paramBundle)
  {
    Object localObject = mIQRemoteProxy;
    if (localObject == null)
    {
      paramBundle = QRoute.logger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callServerSync before init, action=");
      ((StringBuilder)localObject).append(paramString);
      paramBundle.warning("QRemoteProxy", ((StringBuilder)localObject).toString());
      return null;
    }
    return ((IQRemoteProxy)localObject).callServerSync(paramString, paramBundle);
  }
  
  public static void clear()
  {
    CACHE_CLASS_MAP.clear();
    CACHE_PROXY_CLASS_MAP.clear();
  }
  
  public static Object getProxy(Class<? extends QRouteApi> paramClass1, Class<? extends QRouteApi> paramClass2)
  {
    String str = paramClass1.getName();
    if (CACHE_PROXY_CLASS_MAP.containsKey(str)) {
      return CACHE_PROXY_CLASS_MAP.get(str);
    }
    synchronized (LOCK_OBJECT)
    {
      if (!CACHE_PROXY_CLASS_MAP.containsKey(str))
      {
        paramClass1 = Proxy.newProxyInstance(paramClass2.getClassLoader(), paramClass2.getInterfaces(), new QRouteRemoteHandler(paramClass1));
        CACHE_PROXY_CLASS_MAP.put(str, paramClass1);
        return paramClass1;
      }
      return CACHE_PROXY_CLASS_MAP.get(str);
    }
  }
  
  public static void init(IQRemoteProxy paramIQRemoteProxy)
  {
    mIQRemoteProxy = paramIQRemoteProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.remote.QRemoteProxy
 * JD-Core Version:    0.7.0.1
 */