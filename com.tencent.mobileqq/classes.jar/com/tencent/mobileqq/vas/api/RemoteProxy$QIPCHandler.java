package com.tencent.mobileqq.vas.api;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class RemoteProxy$QIPCHandler
  implements InvocationHandler
{
  public Object a;
  private Class b;
  
  public RemoteProxy$QIPCHandler(Class paramClass)
  {
    this.b = paramClass;
    try
    {
      this.a = paramClass.newInstance();
      return;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
    }
  }
  
  Object a(String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.getName());
    localStringBuilder.append("$");
    localStringBuilder.append(paramString);
    paramString = RemoteProxy.a(localStringBuilder.toString(), paramBundle);
    if ((paramString != null) && (paramString.data != null))
    {
      paramBundle = paramString.data.getString("resultType");
      if (paramBundle.endsWith("void")) {
        return null;
      }
      return RemoteProxy.a(paramString.data, paramBundle, "result");
    }
    return null;
  }
  
  void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.getName());
    localStringBuilder.append("$");
    localStringBuilder.append(paramString);
    RemoteProxy.a(localStringBuilder.toString(), paramBundle, paramEIPCResultCallback);
  }
  
  void a(Method paramMethod, Object[] paramArrayOfObject, Bundle paramBundle)
  {
    paramMethod = paramMethod.getParameterTypes();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMethod.length)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("__arg+");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("__");
      localObject = ((StringBuilder)localObject).toString();
      String str = paramMethod[i].getName();
      localArrayList.add(str);
      RemoteProxy.a(paramBundle, str, (String)localObject, paramArrayOfObject[i]);
      i += 1;
    }
    paramBundle.putStringArrayList("__parameterTypes__", localArrayList);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new Bundle();
    paramObject.setClassLoader(getClass().getClassLoader());
    a(paramMethod, paramArrayOfObject, paramObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invoke getReturnType:");
      localStringBuilder.append(paramMethod.getReturnType());
      QLog.d("RemoteProxy", 2, localStringBuilder.toString());
    }
    if ((paramMethod.getReturnType().getName().equals("void")) && (paramArrayOfObject != null) && ((paramArrayOfObject[(paramArrayOfObject.length - 1)] instanceof EIPCResultCallback)))
    {
      a(paramMethod.getName(), paramObject, (EIPCResultCallback)paramArrayOfObject[(paramArrayOfObject.length - 1)]);
      return null;
    }
    return a(paramMethod.getName(), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.RemoteProxy.QIPCHandler
 * JD-Core Version:    0.7.0.1
 */