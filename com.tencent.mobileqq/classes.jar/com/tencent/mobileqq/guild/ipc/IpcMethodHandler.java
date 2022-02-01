package com.tencent.mobileqq.guild.ipc;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod.IpcMethod;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IpcMethodHandler
{
  private final Map<String, AbsIpcMethod> a = new HashMap();
  private final Map<String, Class<? extends AbsIpcMethod>> b = new HashMap();
  
  public IpcMethodHandler(@NonNull Map<String, Class<? extends AbsIpcMethod>> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      paramMap = (String)((Map.Entry)localObject).getKey();
      localObject = (Class)((Map.Entry)localObject).getValue();
      if (!a((Class)localObject))
      {
        this.b.put(paramMap, localObject);
      }
      else
      {
        try
        {
          this.a.put(paramMap, ((Class)localObject).newInstance());
        }
        catch (InstantiationException paramMap) {}catch (IllegalAccessException paramMap) {}
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((Class)localObject).getCanonicalName());
        localStringBuilder.append(" newInstance() error!");
        QLog.e("IpcMethodHandler", 1, localStringBuilder.toString(), paramMap);
      }
    }
  }
  
  @SafeVarargs
  public IpcMethodHandler(Class<? extends AbsIpcMethod>... paramVarArgs)
  {
    this(a(paramVarArgs));
  }
  
  private static Map<String, Class<? extends AbsIpcMethod>> a(Class<? extends AbsIpcMethod>[] paramArrayOfClass)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class<? extends AbsIpcMethod> localClass = paramArrayOfClass[i];
      localHashMap.put(localClass.getCanonicalName(), localClass);
      i += 1;
    }
    return localHashMap;
  }
  
  private boolean a(Class<? extends AbsIpcMethod> paramClass)
  {
    paramClass = (AbsIpcMethod.IpcMethod)paramClass.getAnnotation(AbsIpcMethod.IpcMethod.class);
    return (paramClass == null) || (paramClass.a());
  }
  
  private AbsIpcMethod b(String paramString)
  {
    Class localClass = (Class)this.b.get(paramString);
    if (localClass != null)
    {
      try
      {
        AbsIpcMethod localAbsIpcMethod = (AbsIpcMethod)localClass.newInstance();
        return localAbsIpcMethod;
      }
      catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("findIpcMethod: ");
      localStringBuilder.append(localClass.getCanonicalName());
      localStringBuilder.append(" newInstance() error!");
      QLog.e("IpcMethodHandler", 1, localStringBuilder.toString(), localIllegalAccessException);
    }
    return (AbsIpcMethod)this.a.get(paramString);
  }
  
  public EIPCResult a(QIPCModule paramQIPCModule, String paramString, Bundle paramBundle, int paramInt)
  {
    AbsIpcMethod localAbsIpcMethod = b(paramString);
    if (localAbsIpcMethod != null) {
      return localAbsIpcMethod.a(paramQIPCModule, paramString, paramBundle, paramInt);
    }
    paramQIPCModule = new StringBuilder();
    paramQIPCModule.append("can't not find method: ");
    paramQIPCModule.append(paramString);
    paramQIPCModule.append(" !");
    throw new IllegalArgumentException(paramQIPCModule.toString());
  }
  
  public boolean a(String paramString)
  {
    return (this.b.containsKey(paramString)) || (this.a.containsKey(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.IpcMethodHandler
 * JD-Core Version:    0.7.0.1
 */