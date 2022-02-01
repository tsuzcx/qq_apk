package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import org.jetbrains.annotations.Nullable;

public class RemoteProxy
{
  public static final String KEY_RESULT = "result";
  public static final String KEY_RESULT_TYPE = "resultType";
  public static final String SPLIT_CHAR = "$";
  private static final String TAG = "RemoteProxy";
  private static HashMap<String, Class> sCacheClass = new HashMap();
  private static HashMap<String, Object> sCacheClassObject = new HashMap();
  private static HashMap<String, Method> sCacheMethod;
  private static HashMap<String, Object> sProxyCacheClass = new HashMap();
  
  static
  {
    sCacheMethod = new HashMap();
  }
  
  private static void callServerAsync(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("VasLiveIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
  
  private static EIPCResult callServerSync(String paramString, Bundle paramBundle)
  {
    return QIPCClientHelper.getInstance().callServer("VasLiveIPCModule", paramString, paramBundle);
  }
  
  @Nullable
  private static Object getBundleObject(Bundle paramBundle, String paramString1, String paramString2, Class<?>[] paramArrayOfClass)
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
          return getListObject(paramBundle, paramString2);
        }
        if (paramArrayOfClass.equals("java.util.HashMap")) {
          return paramBundle.getSerializable(paramString2);
        }
        i += 1;
      }
    }
    return null;
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
      return getBundleObject(paramBundle, paramString1, paramString2, null);
    }
    return getListObject(paramBundle, paramString2);
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
  
  private static Object getListObject(Bundle paramBundle, String paramString)
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
  
  public static Object getProxy(Class paramClass)
  {
    String str = paramClass.getName();
    if (sProxyCacheClass.containsKey(str)) {
      return sProxyCacheClass.get(str);
    }
    paramClass = Proxy.newProxyInstance(paramClass.getClassLoader(), paramClass.getInterfaces(), new RemoteProxy.QIPCHandler(paramClass));
    sProxyCacheClass.put(str, paramClass);
    return paramClass;
  }
  
  public static EIPCResult onCall(QIPCModule paramQIPCModule, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("RemoteProxy", 2, new Object[] { "action:", paramString, "  callbackId:", Integer.valueOf(paramInt) });
    }
    Object localObject1;
    Object localObject3;
    String str1;
    Object localObject2;
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.contains("$")) {
        return null;
      }
      localObject1 = paramString.split("\\$");
      localObject3 = localObject1[0];
      str1 = localObject1[1];
      try
      {
        if (sCacheClass.containsKey(localObject3))
        {
          localObject1 = (Class)sCacheClass.get(localObject3);
        }
        else
        {
          localObject1 = Class.forName((String)localObject3);
          sCacheClass.put(localObject3, localObject1);
        }
        if (sCacheClassObject.containsKey(localObject3))
        {
          localObject2 = sCacheClassObject.get(localObject3);
        }
        else
        {
          localObject2 = ((Class)localObject1).newInstance();
          sCacheClassObject.put(localObject3, localObject2);
        }
      }
      catch (Exception paramQIPCModule)
      {
        ArrayList localArrayList;
        Class[] arrayOfClass;
        sCacheClassObject.clear();
        sCacheMethod.clear();
        paramQIPCModule.printStackTrace();
        QLog.d("RemoteProxy", 1, "onCall exception", paramQIPCModule);
      }
      paramBundle.setClassLoader(((Class)localObject1).getClassLoader());
      localArrayList = paramBundle.getStringArrayList("__parameterTypes__");
      j = localArrayList.size();
      arrayOfClass = new Class[j];
      localObject3 = new Object[j];
    }
    for (;;)
    {
      if (i < localArrayList.size())
      {
        Object localObject4 = AIOUtils.a();
        ((StringBuilder)localObject4).append("__arg+");
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append("__");
        localObject4 = ((StringBuilder)localObject4).toString();
        String str2 = (String)localArrayList.get(i);
        arrayOfClass[i] = getClassFromName(str2);
        localObject3[i] = getBundleParameter(paramBundle, str2, (String)localObject4);
        j = i;
        if (str2.equals(EIPCModule.class.getName()))
        {
          localObject3[i] = paramQIPCModule;
          j = i + 1;
          localObject3[j] = Integer.valueOf(paramInt);
          arrayOfClass[j] = getClassFromName((String)localArrayList.get(j));
        }
      }
      else
      {
        if (sCacheMethod.get(paramString) != null)
        {
          paramQIPCModule = (Method)sCacheMethod.get(paramString);
        }
        else
        {
          paramQIPCModule = ((Class)localObject1).getMethod(str1, arrayOfClass);
          sCacheMethod.put(paramString, paramQIPCModule);
        }
        paramString = paramQIPCModule.invoke(localObject2, (Object[])localObject3);
        localObject1 = new EIPCResult();
        ((EIPCResult)localObject1).data = paramBundle;
        setBundleParameter(paramBundle, paramQIPCModule.getReturnType().getName(), "result", paramString);
        setBundleParameter(paramBundle, String.class.getName(), "resultType", paramQIPCModule.getReturnType().getName());
        paramBundle.putString("resultType", paramQIPCModule.getReturnType().getName());
        return localObject1;
        return null;
        if (localObject2 != null) {
          break;
        }
        return null;
      }
      i = j + 1;
    }
  }
  
  private static void putArrayList(Bundle paramBundle, String paramString, Object paramObject)
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
  
  private static void setBundleParameter(Bundle paramBundle, String paramString1, String paramString2, Object paramObject)
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
      putArrayList(paramBundle, paramString2, paramObject);
      return;
    }
    if ((paramObject instanceof Parcelable))
    {
      paramBundle.putParcelable(paramString2, (Parcelable)paramObject);
      return;
    }
    if ((paramObject instanceof Serializable)) {
      paramBundle.putSerializable(paramString2, (Serializable)paramObject);
    }
  }
  
  public void clear()
  {
    sCacheClass.clear();
    sProxyCacheClass.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.RemoteProxy
 * JD-Core Version:    0.7.0.1
 */