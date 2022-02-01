package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class RemoteProxy$QIPCHandler
  implements InvocationHandler
{
  private Class cls;
  public Object object;
  
  public RemoteProxy$QIPCHandler(Class paramClass)
  {
    this.cls = paramClass;
    try
    {
      this.object = paramClass.newInstance();
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
  
  Object callMainIPC(String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cls.getName());
    localStringBuilder.append("$");
    localStringBuilder.append(paramString);
    paramString = RemoteProxy.access$100(localStringBuilder.toString(), paramBundle);
    if ((paramString != null) && (paramString.data != null))
    {
      paramBundle = paramString.data.getString("resultType");
      if (paramBundle.endsWith("void")) {
        return null;
      }
      return RemoteProxy.access$200(paramString.data, paramBundle, "result");
    }
    return null;
  }
  
  void callMainIPCAsync(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cls.getName());
    localStringBuilder.append("$");
    localStringBuilder.append(paramString);
    RemoteProxy.access$300(localStringBuilder.toString(), paramBundle, paramEIPCResultCallback);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new Bundle();
    paramObject.setClassLoader(getClass().getClassLoader());
    setMethodAndParameter(paramMethod, paramArrayOfObject, paramObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invoke getReturnType:");
      localStringBuilder.append(paramMethod.getReturnType());
      QLog.d("RemoteProxy", 2, localStringBuilder.toString());
    }
    if ((paramMethod.getReturnType().getName().equals("void")) && (paramArrayOfObject != null) && ((paramArrayOfObject[(paramArrayOfObject.length - 1)] instanceof EIPCResultCallback)))
    {
      callMainIPCAsync(paramMethod.getName(), paramObject, (EIPCResultCallback)paramArrayOfObject[(paramArrayOfObject.length - 1)]);
      return null;
    }
    return callMainIPC(paramMethod.getName(), paramObject);
  }
  
  void setMethodAndParameter(Method paramMethod, Object[] paramArrayOfObject, Bundle paramBundle)
  {
    paramMethod = paramMethod.getParameterTypes();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMethod.length)
    {
      Object localObject = AIOUtils.a();
      ((StringBuilder)localObject).append("__arg+");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("__");
      localObject = ((StringBuilder)localObject).toString();
      String str = paramMethod[i].getName();
      localArrayList.add(str);
      RemoteProxy.access$000(paramBundle, str, (String)localObject, paramArrayOfObject[i]);
      i += 1;
    }
    paramBundle.putStringArrayList("__parameterTypes__", localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.RemoteProxy.QIPCHandler
 * JD-Core Version:    0.7.0.1
 */