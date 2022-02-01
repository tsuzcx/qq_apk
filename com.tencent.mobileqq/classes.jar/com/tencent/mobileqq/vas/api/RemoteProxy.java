package com.tencent.mobileqq.vas.api;

import android.os.Bundle;
import android.os.Parcelable;
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
import java.util.List;

public class RemoteProxy
{
  private static HashMap<String, Class> a = new HashMap();
  private static HashMap<String, Object> b = new HashMap();
  private static HashMap<String, Method> c = new HashMap();
  private static HashMap<String, Object> d = new HashMap();
  
  public static EIPCResult a(QIPCModule paramQIPCModule, String paramString, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("RemoteProxy", 2, new Object[] { "action:", paramString, "  callbackId:", Integer.valueOf(paramInt) });
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("$"))) {
      return null;
    }
    Object localObject1 = paramString.split("\\$");
    Object localObject3 = localObject1[0];
    String str1 = localObject1[1];
    Object localObject2;
    try
    {
      if (a.containsKey(localObject3)) {
        localObject1 = (Class)a.get(localObject3);
      }
      while (d.containsKey(localObject3))
      {
        localObject2 = d.get(localObject3);
        break label480;
        localObject1 = Class.forName((String)localObject3);
        a.put(localObject3, localObject1);
      }
      localObject2 = ((Class)localObject1).newInstance();
      d.put(localObject3, localObject2);
    }
    catch (Exception paramQIPCModule)
    {
      ArrayList localArrayList;
      d.clear();
      c.clear();
      paramQIPCModule.printStackTrace();
      QLog.d("RemoteProxy", 1, "onCall exception", paramQIPCModule);
      return null;
    }
    paramBundle.setClassLoader(((Class)localObject1).getClassLoader());
    localArrayList = paramBundle.getStringArrayList("__parameterTypes__");
    int j = localArrayList.size();
    Class[] arrayOfClass = new Class[j];
    localObject3 = new Object[j];
    for (;;)
    {
      if (i < localArrayList.size())
      {
        String str2 = "__arg+" + i + "__";
        String str3 = (String)localArrayList.get(i);
        arrayOfClass[i] = a(str3);
        localObject3[i] = b(paramBundle, str3, str2);
        j = i;
        if (str3.equals(EIPCModule.class.getName()))
        {
          localObject3[i] = paramQIPCModule;
          j = i + 1;
          localObject3[j] = Integer.valueOf(paramInt);
          arrayOfClass[j] = a((String)localArrayList.get(j));
        }
      }
      else
      {
        if (c.get(paramString) != null) {
          paramQIPCModule = (Method)c.get(paramString);
        }
        for (;;)
        {
          paramString = paramQIPCModule.invoke(localObject2, (Object[])localObject3);
          localObject1 = new EIPCResult();
          ((EIPCResult)localObject1).data = paramBundle;
          b(paramBundle, paramQIPCModule.getReturnType().getName(), "result", paramString);
          b(paramBundle, String.class.getName(), "resultType", paramQIPCModule.getReturnType().getName());
          paramBundle.putString("resultType", paramQIPCModule.getReturnType().getName());
          return localObject1;
          paramQIPCModule = ((Class)localObject1).getMethod(str1, arrayOfClass);
          c.put(paramString, paramQIPCModule);
        }
        label480:
        if (localObject2 != null) {
          break;
        }
        return null;
      }
      i = j + 1;
    }
  }
  
  private static Class a(String paramString)
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
    if ("float".equals(paramString)) {
      return Float.TYPE;
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
    if ("android.os.Parcelable".equals(paramString)) {
      return Parcelable.class;
    }
    return Class.forName(paramString);
  }
  
  private static Object a(Bundle paramBundle, String paramString)
  {
    Object localObject2 = paramBundle.getParcelableArrayList(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramBundle.getStringArrayList(paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramBundle.getIntegerArrayList(paramString);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramBundle.getSerializable(paramString);
    }
    return localObject1;
  }
  
  public static Object a(Class paramClass)
  {
    String str = paramClass.getName();
    if (b.containsKey(str)) {
      return b.get(str);
    }
    paramClass = Proxy.newProxyInstance(paramClass.getClassLoader(), paramClass.getInterfaces(), new RemoteProxy.QIPCHandler(paramClass));
    b.put(str, paramClass);
    return paramClass;
  }
  
  private static void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    List localList;
    if ((paramObject instanceof List))
    {
      localList = (List)paramObject;
      if (localList.size() > 0)
      {
        if (!(localList.get(0) instanceof String)) {
          break label44;
        }
        paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
      }
    }
    label44:
    do
    {
      return;
      if ((localList.get(0) instanceof Integer))
      {
        paramBundle.putIntegerArrayList(paramString, (ArrayList)paramObject);
        return;
      }
      if ((localList.get(0) instanceof Parcelable))
      {
        paramBundle.putParcelableArrayList(paramString, (ArrayList)paramObject);
        return;
      }
    } while (!(paramObject instanceof Serializable));
    paramBundle.putSerializable(paramString, (Serializable)paramObject);
  }
  
  private static EIPCResult b(String paramString, Bundle paramBundle)
  {
    return QIPCClientHelper.getInstance().callServer("VasIPCModule", paramString, paramBundle);
  }
  
  private static Object b(Bundle paramBundle, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1;
    if ("int".equals(paramString1)) {
      localObject1 = Integer.valueOf(paramBundle.getInt(paramString2));
    }
    for (;;)
    {
      return localObject1;
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
      if ("float".equals(paramString1)) {
        return Float.valueOf(paramBundle.getFloat(paramString2));
      }
      if ("boolean".equals(paramString1)) {
        return Boolean.valueOf(paramBundle.getBoolean(paramString2));
      }
      if (("java.util.List".equals(paramString1)) || ("java.util.ArrayList".equals(paramString1))) {
        return a(paramBundle, paramString2);
      }
      if ("java.util.HashMap".equals(paramString1)) {
        return paramBundle.getSerializable(paramString2);
      }
      try
      {
        paramString1 = Class.forName(paramString1);
        if (paramString1.getInterfaces().length > 0)
        {
          paramString1 = paramString1.getInterfaces();
          localObject1 = localObject2;
          if (paramString1 == null) {
            continue;
          }
          int j = paramString1.length;
          i = 0;
          localObject1 = localObject2;
          if (i >= j) {
            continue;
          }
          localObject1 = paramString1[i].getName();
          if (((String)localObject1).equals("android.os.Parcelable")) {
            return paramBundle.getParcelable(paramString2);
          }
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          int i;
          paramString1.printStackTrace();
          paramString1 = null;
          continue;
          if (((String)localObject1).equals("java.io.Serializable")) {
            return paramBundle.getSerializable(paramString2);
          }
          if (((String)localObject1).equals("java.util.Collection")) {
            return a(paramBundle, paramString2);
          }
          if (((String)localObject1).equals("java.util.HashMap")) {
            return paramBundle.getSerializable(paramString2);
          }
          i += 1;
          continue;
          paramString1 = null;
        }
      }
    }
  }
  
  private static void b(Bundle paramBundle, String paramString1, String paramString2, Object paramObject)
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
      if ("float".equals(paramString1))
      {
        paramBundle.putFloat(paramString2, ((Float)paramObject).floatValue());
        return;
      }
      if ("boolean".equals(paramString1))
      {
        paramBundle.putBoolean(paramString2, ((Boolean)paramObject).booleanValue());
        return;
      }
      if ("java.util.List".equals(paramString1))
      {
        a(paramBundle, paramString2, paramObject);
        return;
      }
      if ((paramObject instanceof Parcelable))
      {
        paramBundle.putParcelable(paramString2, (Parcelable)paramObject);
        return;
      }
    } while (!(paramObject instanceof Serializable));
    paramBundle.putSerializable(paramString2, (Serializable)paramObject);
  }
  
  private static void b(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("VasIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.RemoteProxy
 * JD-Core Version:    0.7.0.1
 */