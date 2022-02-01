package com.tencent.mobileqq.vas.api;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback.Stub;
import eipc.EIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class RemoteProxy
{
  private static HashMap<String, Class> a = new HashMap();
  private static HashMap<String, Object> b = new HashMap();
  private static HashMap<String, Method> c = new HashMap();
  private static HashMap<String, Object> d = new HashMap();
  
  public static EIPCResult a(QIPCModule paramQIPCModule, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool) {
      QLog.d("RemoteProxy", 2, new Object[] { "action:", paramString, "  callbackId:", Integer.valueOf(paramInt) });
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.contains("$")) {
        return null;
      }
      localObject2 = paramString.split("\\$");
      localObject1 = localObject2[0];
      i = 1;
      while (i < localObject2.length - 1)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("$");
        ((StringBuilder)localObject3).append(localObject2[i]);
        localObject1 = ((StringBuilder)localObject3).toString();
        i += 1;
      }
      str1 = localObject2[(localObject2.length - 1)];
      try
      {
        if (a.containsKey(localObject1))
        {
          localObject2 = (Class)a.get(localObject1);
        }
        else
        {
          localObject2 = Class.forName((String)localObject1);
          a.put(localObject1, localObject2);
        }
        if (d.containsKey(localObject1))
        {
          localObject1 = d.get(localObject1);
        }
        else
        {
          localObject3 = ((Class)localObject2).newInstance();
          d.put(localObject1, localObject3);
          localObject1 = localObject3;
        }
      }
      catch (Exception paramQIPCModule)
      {
        ArrayList localArrayList;
        Class[] arrayOfClass;
        d.clear();
        c.clear();
        paramQIPCModule.printStackTrace();
        QLog.d("RemoteProxy", 1, "onCall exception", paramQIPCModule);
      }
      paramBundle.setClassLoader(((Class)localObject2).getClassLoader());
      localArrayList = paramBundle.getStringArrayList("__parameterTypes__");
      i = localArrayList.size();
      arrayOfClass = new Class[i];
      localObject3 = new Object[i];
    }
    for (int i = j;; i = j + 1) {
      if (i < localArrayList.size())
      {
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("__arg+");
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append("__");
        localObject4 = ((StringBuilder)localObject4).toString();
        String str2 = (String)localArrayList.get(i);
        arrayOfClass[i] = a(str2);
        localObject3[i] = b(paramBundle, str2, (String)localObject4);
        j = i;
        if (str2.equals(EIPCModule.class.getName()))
        {
          localObject3[i] = paramQIPCModule;
          j = i + 1;
          localObject3[j] = Integer.valueOf(paramInt);
          arrayOfClass[j] = a((String)localArrayList.get(j));
        }
      }
      else
      {
        if (c.get(paramString) != null)
        {
          paramQIPCModule = (Method)c.get(paramString);
        }
        else
        {
          paramQIPCModule = ((Class)localObject2).getMethod(str1, arrayOfClass);
          c.put(paramString, paramQIPCModule);
        }
        paramString = paramQIPCModule.invoke(localObject1, (Object[])localObject3);
        localObject1 = new EIPCResult();
        ((EIPCResult)localObject1).data = paramBundle;
        b(paramBundle, paramQIPCModule.getReturnType().getName(), "result", paramString);
        b(paramBundle, String.class.getName(), "resultType", paramQIPCModule.getReturnType().getName());
        paramBundle.putString("resultType", paramQIPCModule.getReturnType().getName());
        return localObject1;
        return null;
        if (localObject1 != null) {
          break;
        }
        return null;
      }
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
  
  @Nullable
  private static Object a(Bundle paramBundle, String paramString1, String paramString2, Class<?>[] paramArrayOfClass)
  {
    try
    {
      Class localClass = Class.forName(paramString1);
      paramString1 = paramArrayOfClass;
      if (localClass.getInterfaces().length > 0) {
        paramString1 = localClass.getInterfaces();
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = paramArrayOfClass;
    }
    if (paramString1 != null)
    {
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfClass = paramString1[i].getName();
        if (paramArrayOfClass.equals("android.os.Parcelable")) {
          return paramBundle.getParcelable(paramString2);
        }
        if (paramArrayOfClass.equals("java.io.Serializable")) {
          return paramBundle.getSerializable(paramString2);
        }
        if (paramArrayOfClass.equals("java.util.Collection")) {
          return a(paramBundle, paramString2);
        }
        if (paramArrayOfClass.equals("java.util.HashMap")) {
          return paramBundle.getSerializable(paramString2);
        }
        i += 1;
      }
    }
    return null;
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
    if ((paramObject instanceof List))
    {
      List localList = (List)paramObject;
      if (localList.size() > 0)
      {
        if ((localList.get(0) instanceof String))
        {
          paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
          return;
        }
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
        if ((paramObject instanceof Serializable)) {
          paramBundle.putSerializable(paramString, (Serializable)paramObject);
        }
      }
    }
  }
  
  private static EIPCResult b(String paramString, Bundle paramBundle)
  {
    return QIPCClientHelper.getInstance().callServer("VasIPCModule", paramString, paramBundle);
  }
  
  private static Object b(Bundle paramBundle, String paramString1, String paramString2)
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
    if ("float".equals(paramString1)) {
      return Float.valueOf(paramBundle.getFloat(paramString2));
    }
    if ("boolean".equals(paramString1)) {
      return Boolean.valueOf(paramBundle.getBoolean(paramString2));
    }
    if ((!"java.util.List".equals(paramString1)) && (!"java.util.ArrayList".equals(paramString1)))
    {
      if ("java.util.HashMap".equals(paramString1)) {
        return paramBundle.getSerializable(paramString2);
      }
      if (("eipc.EIPCCallback".equals(paramString1)) && (Build.VERSION.SDK_INT >= 18)) {
        return EIPCCallback.Stub.asInterface(paramBundle.getBinder(paramString2));
      }
      return a(paramBundle, paramString1, paramString2, null);
    }
    return a(paramBundle, paramString2);
  }
  
  private static void b(Bundle paramBundle, String paramString1, String paramString2, Object paramObject)
  {
    if ("int".equals(paramString1))
    {
      paramBundle.putInt(paramString2, ((Integer)paramObject).intValue());
      return;
    }
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
    if ("eipc.EIPCCallback".equals(paramString1))
    {
      if (Build.VERSION.SDK_INT >= 18) {
        paramBundle.putBinder(paramString2, (IBinder)paramObject);
      }
    }
    else
    {
      if ((paramObject instanceof Parcelable))
      {
        paramBundle.putParcelable(paramString2, (Parcelable)paramObject);
        return;
      }
      if ((paramObject instanceof Serializable)) {
        paramBundle.putSerializable(paramString2, (Serializable)paramObject);
      }
    }
  }
  
  private static void b(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("VasIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.RemoteProxy
 * JD-Core Version:    0.7.0.1
 */