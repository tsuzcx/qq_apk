package com.tencent.mobileqq.vas.ipc;

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
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
      return;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
    }
  }
  
  Object callMainIPC(String paramString, Bundle paramBundle)
  {
    paramString = RemoteProxy.access$100(this.cls.getName() + "$" + paramString, paramBundle);
    if ((paramString != null) && (paramString.data != null))
    {
      paramBundle = paramString.data.getString("resultType");
      if (!paramBundle.endsWith("void")) {}
    }
    else
    {
      return null;
    }
    return RemoteProxy.access$200(paramString.data, paramBundle, "result");
  }
  
  void callMainIPCAsync(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    RemoteProxy.access$300(this.cls.getName() + "$" + paramString, paramBundle, paramEIPCResultCallback);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new Bundle();
    paramObject.setClassLoader(getClass().getClassLoader());
    setMethodAndParameter(paramMethod, paramArrayOfObject, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("RemoteProxy", 2, "invoke getReturnType:" + paramMethod.getReturnType());
    }
    if ((paramMethod.getReturnType().getName().equals("void")) && ((paramArrayOfObject[(paramArrayOfObject.length - 1)] instanceof EIPCResultCallback)))
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
      String str1 = "__arg+" + i + "__";
      String str2 = paramMethod[i].getName();
      localArrayList.add(str2);
      RemoteProxy.access$000(paramBundle, str2, str1, paramArrayOfObject[i]);
      i += 1;
    }
    paramBundle.putStringArrayList("__parameterTypes__", localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.RemoteProxy.QIPCHandler
 * JD-Core Version:    0.7.0.1
 */