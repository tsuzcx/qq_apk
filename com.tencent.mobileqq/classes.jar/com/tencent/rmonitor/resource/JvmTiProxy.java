package com.tencent.rmonitor.resource;

import com.tencent.rmonitor.common.logger.Logger;

public class JvmTiProxy
  implements IJvmTi
{
  private static JvmTiProxy a;
  private IJvmTi b;
  
  public static JvmTiProxy a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a = new JvmTiProxy();
          a.a(b());
        }
      }
      finally {}
    }
    return a;
  }
  
  private static IJvmTi b()
  {
    try
    {
      IJvmTi localIJvmTi = (IJvmTi)Class.forName("com.tencent.rmonitor.jvmti.JvmTiImpl").newInstance();
      return localIJvmTi;
    }
    catch (InstantiationException localInstantiationException)
    {
      Logger.b.e(new String[] { "JvmTiProxy", "createImpl", localInstantiationException.getMessage() });
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Logger.b.e(new String[] { "JvmTiProxy", "createImpl", localIllegalAccessException.getMessage() });
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Logger.b.e(new String[] { "JvmTiProxy", "createImpl", localClassNotFoundException.getMessage() });
    }
    return null;
  }
  
  public void a(IJvmTi paramIJvmTi)
  {
    this.b = paramIJvmTi;
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setImpl, impl: ");
    localStringBuilder.append(paramIJvmTi);
    localLogger.i(new String[] { "JvmTiProxy", localStringBuilder.toString() });
  }
  
  public boolean canUseJvmTi()
  {
    IJvmTi localIJvmTi = this.b;
    return (localIJvmTi != null) && (localIJvmTi.canUseJvmTi());
  }
  
  public long[] getGcInfo()
  {
    long[] arrayOfLong = new long[0];
    Object localObject = this.b;
    if (localObject != null) {
      arrayOfLong = ((IJvmTi)localObject).getGcInfo();
    }
    localObject = arrayOfLong;
    if (arrayOfLong == null) {
      localObject = new long[0];
    }
    return localObject;
  }
  
  public void init()
  {
    IJvmTi localIJvmTi = this.b;
    if (localIJvmTi != null) {
      localIJvmTi.init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.JvmTiProxy
 * JD-Core Version:    0.7.0.1
 */