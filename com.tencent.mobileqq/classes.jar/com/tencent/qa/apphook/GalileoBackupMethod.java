package com.tencent.qa.apphook;

import com.tencent.qa.apphook.util.GalileoHookHelper;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GalileoBackupMethod
{
  private long backAddr;
  private Object callback;
  private Class<?> clazz;
  private Method invoker;
  private Member newMethod;
  private Member originMethod;
  private Class<?>[] parameterClasses;
  
  private static String getParametersString(Class<?>... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    int j = 1;
    int k = paramVarArgs.length;
    int i = 0;
    if (i < k)
    {
      Class<?> localClass = paramVarArgs[i];
      if (j != 0)
      {
        j = 0;
        label34:
        if (localClass == null) {
          break label68;
        }
        localStringBuilder.append(localClass.getCanonicalName());
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(",");
        break label34;
        label68:
        localStringBuilder.append("null");
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public long getBackAddr()
  {
    return this.backAddr;
  }
  
  public Object getCallback()
  {
    return this.callback;
  }
  
  public Class<?> getClazz()
  {
    return this.clazz;
  }
  
  public Method getInvoker()
  {
    return this.invoker;
  }
  
  public String getMethodExact()
  {
    StringBuilder localStringBuilder = new StringBuilder(getClazz().getName());
    localStringBuilder.append('#');
    localStringBuilder.append(getOriginMethod().getName());
    localStringBuilder.append(getParametersString(getParameterClasses()));
    localStringBuilder.append("#exact");
    return localStringBuilder.toString();
  }
  
  public Member getNewMethod()
  {
    return this.newMethod;
  }
  
  public Member getOriginMethod()
  {
    return this.originMethod;
  }
  
  public Class<?>[] getParameterClasses()
  {
    return this.parameterClasses;
  }
  
  public void setBackAddr(long paramLong)
  {
    this.backAddr = paramLong;
  }
  
  public void setCallback(Object paramObject)
  {
    this.callback = paramObject;
  }
  
  public void setClazz(Class<?> paramClass)
  {
    this.clazz = paramClass;
  }
  
  public void setInvoker(Method paramMethod)
  {
    this.invoker = paramMethod;
  }
  
  public void setNewMethod(Member paramMember)
  {
    this.newMethod = paramMember;
  }
  
  public void setOriginMethod(Member paramMember)
  {
    boolean bool = Modifier.isPublic(paramMember.getModifiers());
    GalileoHookLog.d("Method " + paramMember.getName() + " isPublicMethod is " + bool);
    if ((bool) && ((paramMember instanceof Method)))
    {
      GalileoHookHelper.ensureResolved(paramMember);
      GalileoHookNative.makePrivate((Method)paramMember);
    }
    this.originMethod = paramMember;
  }
  
  public void setParameterClasses(Class<?>[] paramArrayOfClass)
  {
    this.parameterClasses = paramArrayOfClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.GalileoBackupMethod
 * JD-Core Version:    0.7.0.1
 */