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
    int i = 0;
    if (QRoute.logger.isColorLevel()) {
      QRoute.logger.debug("QRemoteProxy", "action:" + paramString + "  callbackId:" + paramInt);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("$"))) {
      return new QRemoteResult(-101, paramBundle, new IllegalStateException("wrong acton"));
    }
    Object localObject1 = paramString.split("\\$");
    if (localObject1.length != 3) {
      return new QRemoteResult(-101, paramBundle, new IllegalStateException("wrong action, action = " + paramString));
    }
    Object localObject2 = localObject1[1];
    QRemoteResult localQRemoteResult = localObject1[2];
    for (;;)
    {
      try
      {
        if (CACHE_CLASS_MAP.containsKey(localObject2))
        {
          localObject1 = (Class)CACHE_CLASS_MAP.get(localObject2);
          localObject2 = QRoute.api((Class)localObject1);
          if (localObject2 != null) {
            break;
          }
          paramString = new QRemoteResult(-101, paramBundle, new IllegalStateException("qRouteApi is null, action = " + paramString));
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        CACHE_METHOD_MAP.clear();
        paramString.printStackTrace();
        paramBundle = new QRemoteResult(-101, paramBundle, paramString);
        QRoute.logger.warning("QRemoteProxy", "onCall exception", paramString);
        return paramBundle;
      }
      localObject1 = Class.forName((String)localObject2);
      CACHE_CLASS_MAP.put(localObject2, localObject1);
    }
    paramBundle.setClassLoader(((Class)localObject1).getClassLoader());
    ArrayList localArrayList = paramBundle.getStringArrayList("__parameterTypes__");
    paramInt = localArrayList.size();
    Class[] arrayOfClass = new Class[paramInt];
    Object[] arrayOfObject = new Object[paramInt];
    paramInt = i;
    while (paramInt < localArrayList.size())
    {
      String str1 = "__arg+" + paramInt + "__";
      String str2 = (String)localArrayList.get(paramInt);
      arrayOfClass[paramInt] = RemoteProxyUtil.getClassFromName(str2);
      arrayOfObject[paramInt] = RemoteProxyUtil.getBundleParameter(paramBundle, str2, str1);
      paramInt += 1;
    }
    if (CACHE_METHOD_MAP.get(paramString) != null) {}
    for (paramString = (Method)CACHE_METHOD_MAP.get(paramString);; paramString = (String)localObject1)
    {
      localObject1 = paramString.invoke(localObject2, arrayOfObject);
      localQRemoteResult = new QRemoteResult(0, paramBundle);
      RemoteProxyUtil.setBundleParameter(paramBundle, paramString.getReturnType().getName(), "result", localObject1);
      paramBundle.putString("resultType", paramString.getReturnType().getName());
      return localQRemoteResult;
      localObject1 = ((Class)localObject1).getDeclaredMethod(localQRemoteResult, arrayOfClass);
      CACHE_METHOD_MAP.put(paramString, localObject1);
    }
  }
  
  static void callServerAsync(String paramString, Bundle paramBundle, @NonNull IQRemoteResultCallback paramIQRemoteResultCallback)
  {
    if (mIQRemoteProxy == null)
    {
      QRoute.logger.warning("QRemoteProxy", "callServerAsync before init, action=" + paramString);
      paramIQRemoteResultCallback.onCallback(new QRemoteResult(-101, new IllegalStateException("callServerAsync before init, action=" + paramString)));
      return;
    }
    mIQRemoteProxy.callServerAsync(paramString, paramBundle, paramIQRemoteResultCallback);
  }
  
  @Nullable
  static QRemoteResult callServerSync(String paramString, Bundle paramBundle)
  {
    if (mIQRemoteProxy == null)
    {
      QRoute.logger.warning("QRemoteProxy", "callServerSync before init, action=" + paramString);
      return null;
    }
    return mIQRemoteProxy.callServerSync(paramString, paramBundle);
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
    }
    return CACHE_PROXY_CLASS_MAP.get(str);
  }
  
  public static void init(IQRemoteProxy paramIQRemoteProxy)
  {
    mIQRemoteProxy = paramIQRemoteProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.remote.QRemoteProxy
 * JD-Core Version:    0.7.0.1
 */