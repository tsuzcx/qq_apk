package okhttp3.internal.platform;

import java.lang.reflect.Method;

final class AndroidPlatform$CloseGuard
{
  private final Method getMethod;
  private final Method openMethod;
  private final Method warnIfOpenMethod;
  
  AndroidPlatform$CloseGuard(Method paramMethod1, Method paramMethod2, Method paramMethod3)
  {
    this.getMethod = paramMethod1;
    this.openMethod = paramMethod2;
    this.warnIfOpenMethod = paramMethod3;
  }
  
  static CloseGuard get()
  {
    Object localObject1 = null;
    try
    {
      Object localObject3 = Class.forName("dalvik.system.CloseGuard");
      localMethod2 = ((Class)localObject3).getMethod("get", new Class[0]);
      localMethod1 = ((Class)localObject3).getMethod("open", new Class[] { String.class });
      localObject3 = ((Class)localObject3).getMethod("warnIfOpen", new Class[0]);
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Method localMethod1;
        Object localObject2 = null;
        Method localMethod2 = null;
      }
    }
    return new CloseGuard(localMethod2, localMethod1, localObject1);
  }
  
  Object createAndOpen(String paramString)
  {
    if (this.getMethod != null) {
      try
      {
        Object localObject = this.getMethod.invoke(null, new Object[0]);
        this.openMethod.invoke(localObject, new Object[] { paramString });
        return localObject;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  boolean warnIfOpen(Object paramObject)
  {
    boolean bool = false;
    if (paramObject != null) {}
    try
    {
      this.warnIfOpenMethod.invoke(paramObject, new Object[0]);
      bool = true;
      return bool;
    }
    catch (Exception paramObject) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.platform.AndroidPlatform.CloseGuard
 * JD-Core Version:    0.7.0.1
 */