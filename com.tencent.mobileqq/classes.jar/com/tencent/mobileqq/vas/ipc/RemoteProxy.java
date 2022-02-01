package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;

public class RemoteProxy
{
  public static final String KEY_RESULT = "result";
  public static final String KEY_RESULT_TYPE = "resultType";
  public static final String SPLIT_CHAR = "$";
  private static final String TAG = "RemoteProxy";
  private static HashMap<String, Class> sCacheClass = new HashMap();
  private static HashMap<String, Method> sCacheMethod = new HashMap();
  
  private static void callServerAsync(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("VasLiveIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
  
  private static EIPCResult callServerSync(String paramString, Bundle paramBundle)
  {
    return QIPCClientHelper.getInstance().callServer("VasLiveIPCModule", paramString, paramBundle);
  }
  
  private static Object getBundleParameter(Bundle paramBundle, String paramString1, String paramString2)
  {
    if ("int".equals(paramString1)) {
      return Integer.valueOf(paramBundle.getInt(paramString2));
    }
    if ("java.lang.String".equals(paramString1)) {
      return paramBundle.getString(paramString2);
    }
    if ("java.lang.Boolean".equals(paramString1)) {
      return Boolean.valueOf(paramBundle.getBoolean(paramString2));
    }
    if ("long".equals(paramString1)) {
      return Long.valueOf(paramBundle.getLong(paramString2));
    }
    if ("short".equals(paramString1)) {
      return Short.valueOf(paramBundle.getShort(paramString2));
    }
    if ("boolean".equals(paramString1)) {
      return Boolean.valueOf(paramBundle.getBoolean(paramString2));
    }
    if ("java.util.ArrayList".equals(paramString1)) {
      return paramBundle.getStringArrayList(paramString2);
    }
    if ("java.io.Serializable".equals(paramString1)) {
      return paramBundle.getSerializable(paramString2);
    }
    if ("java.util.HashMap".equals(paramString1)) {
      return paramBundle.getSerializable(paramString2);
    }
    return null;
  }
  
  private static Class getClassFromName(String paramString)
  {
    if ("int".equals(paramString)) {
      return Integer.TYPE;
    }
    if ("java.lang.String".equals(paramString)) {
      return String.class;
    }
    if ("java.lang.Boolean".equals(paramString)) {
      return Boolean.class;
    }
    if ("long".equals(paramString)) {
      return Long.TYPE;
    }
    if ("short".equals(paramString)) {
      return Short.TYPE;
    }
    if ("boolean".equals(paramString)) {
      return Boolean.TYPE;
    }
    if ("java.util.ArrayList".equals(paramString)) {
      return ArrayList.class;
    }
    if ("java.io.Serializable".equals(paramString)) {
      return Serializable.class;
    }
    if ("java.util.HashMap".equals(paramString)) {
      return HashMap.class;
    }
    return Class.forName(paramString);
  }
  
  public static Object getProxy(Class paramClass)
  {
    return Proxy.newProxyInstance(paramClass.getClassLoader(), paramClass.getInterfaces(), new RemoteProxy.QIPCHandler(paramClass));
  }
  
  public static EIPCResult onCall(QIPCModule paramQIPCModule, String paramString, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("RemoteProxy", 2, "action:" + paramString + "  callbackId:" + paramInt);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("$"))) {
      return null;
    }
    paramString = paramString.split("\\$");
    Object localObject2 = paramString[0];
    Object localObject1 = paramString[1];
    for (;;)
    {
      int j;
      try
      {
        Class[] arrayOfClass;
        Object[] arrayOfObject;
        if (sCacheClass.containsKey(localObject2))
        {
          paramString = (Class)sCacheClass.get(localObject2);
          localObject2 = paramString.newInstance();
          ArrayList localArrayList = paramBundle.getStringArrayList("__parameterTypes__");
          j = localArrayList.size();
          arrayOfClass = new Class[j];
          arrayOfObject = new Object[j];
          if (i < localArrayList.size())
          {
            String str1 = "__arg+" + i + "__";
            String str2 = (String)localArrayList.get(i);
            arrayOfClass[i] = getClassFromName(str2);
            arrayOfObject[i] = getBundleParameter(paramBundle, str2, str1);
            j = i;
            if (!str2.equals(EIPCModule.class.getName())) {
              break label385;
            }
            arrayOfObject[i] = paramQIPCModule;
            j = i + 1;
            arrayOfObject[j] = Integer.valueOf(paramInt);
            arrayOfClass[j] = getClassFromName((String)localArrayList.get(j));
            break label385;
          }
        }
        else
        {
          paramString = Class.forName(localObject2);
          sCacheClass.put(localObject2, paramString);
          continue;
        }
        paramQIPCModule = paramString.getMethod((String)localObject1, arrayOfClass);
        paramString = paramQIPCModule.invoke(localObject2, arrayOfObject);
        localObject1 = new EIPCResult();
        ((EIPCResult)localObject1).data = paramBundle;
        setBundleParameter(paramBundle, paramQIPCModule.getReturnType().getName(), "result", paramString);
        setBundleParameter(paramBundle, String.class.getName(), "resultType", paramQIPCModule.getReturnType().getName());
        paramBundle.putString("resultType", paramQIPCModule.getReturnType().getName());
        return localObject1;
      }
      catch (Exception paramQIPCModule)
      {
        paramQIPCModule.printStackTrace();
        QLog.d("RemoteProxy", 1, "onCall exception", paramQIPCModule);
        return null;
      }
      label385:
      i = j + 1;
    }
  }
  
  private static void setBundleParameter(Bundle paramBundle, String paramString1, String paramString2, Object paramObject)
  {
    if ("int".equals(paramString1)) {
      paramBundle.putInt(paramString2, ((Integer)paramObject).intValue());
    }
    do
    {
      return;
      if ("java.lang.String".equals(paramString1))
      {
        paramBundle.putString(paramString2, (String)paramObject);
        return;
      }
      if ("java.lang.Boolean".equals(paramString1))
      {
        paramBundle.putBoolean(paramString2, ((Boolean)paramObject).booleanValue());
        return;
      }
      if ("long".equals(paramString1))
      {
        paramBundle.putLong(paramString2, ((Long)paramObject).longValue());
        return;
      }
      if ("short".equals(paramString1))
      {
        paramBundle.putShort(paramString2, ((Short)paramObject).shortValue());
        return;
      }
      if ("boolean".equals(paramString1))
      {
        paramBundle.putBoolean(paramString2, ((Boolean)paramObject).booleanValue());
        return;
      }
      if ("java.util.ArrayList".equals(paramString1))
      {
        paramBundle.putStringArrayList(paramString2, (ArrayList)paramObject);
        return;
      }
      if ("java.io.Serializable".equals(paramString1))
      {
        paramBundle.putSerializable(paramString2, (Serializable)paramObject);
        return;
      }
    } while (!"java.util.HashMap".equals(paramString1));
    paramBundle.putSerializable(paramString2, (Serializable)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.RemoteProxy
 * JD-Core Version:    0.7.0.1
 */