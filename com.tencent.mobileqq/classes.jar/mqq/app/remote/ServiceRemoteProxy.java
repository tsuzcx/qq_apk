package mqq.app.remote;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.remote.RemoteProxyUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

public class ServiceRemoteProxy
{
  private static final HashMap<String, Class<?>> CACHE_CLASS_MAP;
  private static final HashMap<String, Method> CACHE_METHOD_MAP = new HashMap(512);
  private static final ConcurrentHashMap<String, Object> CACHE_PROXY_CLASS_MAP;
  private static final Object LOCK_OBJECT = new Object();
  private static final String TAG = "ServiceRemoteProxy";
  
  static
  {
    CACHE_CLASS_MAP = new HashMap(512);
    CACHE_PROXY_CLASS_MAP = new ConcurrentHashMap(512);
  }
  
  public static EIPCResult callInMainProcess(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteProxy", 1, "action:" + paramString + "  callbackId:" + paramInt);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("$"))) {
      return EIPCResult.createExceptionResult(new IllegalStateException("wrong acton"));
    }
    Object localObject1 = paramString.split("\\$");
    if (localObject1.length != 3) {
      return EIPCResult.createExceptionResult(new IllegalStateException("wrong action, action = " + paramString));
    }
    Object localObject2 = localObject1[1];
    EIPCResult localEIPCResult = localObject1[2];
    for (;;)
    {
      Class[] arrayOfClass;
      try
      {
        if (CACHE_CLASS_MAP.containsKey(localObject2))
        {
          localObject1 = (Class)CACHE_CLASS_MAP.get(localObject2);
          localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService((Class)localObject1, "");
          if (localObject2 == null) {
            return EIPCResult.createExceptionResult(new IllegalStateException("IRuntimeService is null, action = " + paramString));
          }
        }
        else
        {
          localObject1 = Class.forName((String)localObject2);
          CACHE_CLASS_MAP.put(localObject2, localObject1);
          continue;
        }
        paramBundle.setClassLoader(((Class)localObject1).getClassLoader());
        ArrayList localArrayList = paramBundle.getStringArrayList("__parameterTypes__");
        paramInt = localArrayList.size();
        arrayOfClass = new Class[paramInt];
        Object[] arrayOfObject = new Object[paramInt];
        paramInt = 0;
        if (paramInt < localArrayList.size())
        {
          String str1 = "__arg+" + paramInt + "__";
          String str2 = (String)localArrayList.get(paramInt);
          arrayOfClass[paramInt] = RemoteProxyUtil.getClassFromName(str2);
          arrayOfObject[paramInt] = RemoteProxyUtil.getBundleParameter(paramBundle, str2, str1);
          paramInt += 1;
          continue;
        }
        if (CACHE_METHOD_MAP.get(paramString) != null)
        {
          paramString = (Method)CACHE_METHOD_MAP.get(paramString);
          localObject1 = paramString.invoke(localObject2, arrayOfObject);
          localEIPCResult = EIPCResult.createSuccessResult(paramBundle);
          RemoteProxyUtil.setBundleParameter(paramBundle, paramString.getReturnType().getName(), "result", localObject1);
          paramBundle.putString("resultType", paramString.getReturnType().getName());
          return localEIPCResult;
        }
      }
      catch (Exception paramString)
      {
        CACHE_METHOD_MAP.clear();
        paramString.printStackTrace();
        QLog.d("ServiceRemoteProxy", 1, "onCall exception", paramString);
        return EIPCResult.createExceptionResult(paramString);
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod(localEIPCResult, arrayOfClass);
      CACHE_METHOD_MAP.put(paramString, localObject1);
      paramString = (String)localObject1;
    }
  }
  
  public static void clear()
  {
    CACHE_CLASS_MAP.clear();
    CACHE_PROXY_CLASS_MAP.clear();
  }
  
  public static Object getProxy(Class<? extends IRuntimeService> paramClass1, Class<? extends IRuntimeService> paramClass2)
  {
    String str = paramClass1.getName();
    if (CACHE_PROXY_CLASS_MAP.containsKey(str)) {
      return CACHE_PROXY_CLASS_MAP.get(str);
    }
    synchronized (LOCK_OBJECT)
    {
      if (!CACHE_PROXY_CLASS_MAP.containsKey(str))
      {
        paramClass1 = Proxy.newProxyInstance(paramClass2.getClassLoader(), paramClass2.getInterfaces(), new ServiceRemoteHandler(paramClass1));
        CACHE_PROXY_CLASS_MAP.put(str, paramClass1);
        return paramClass1;
      }
    }
    return CACHE_PROXY_CLASS_MAP.get(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.remote.ServiceRemoteProxy
 * JD-Core Version:    0.7.0.1
 */