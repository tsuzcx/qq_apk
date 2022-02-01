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
    Object localObject2 = null;
    try
    {
      localObject1 = Class.forName("dalvik.system.CloseGuard");
      Method localMethod = ((Class)localObject1).getMethod("get", new Class[0]);
      localObject3 = ((Class)localObject1).getMethod("open", new Class[] { String.class });
      localObject1 = ((Class)localObject1).getMethod("warnIfOpen", new Class[0]);
      localObject2 = localMethod;
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject3;
      label51:
      break label51;
    }
    localObject1 = null;
    localObject3 = localObject1;
    return new CloseGuard(localObject2, (Method)localObject3, (Method)localObject1);
  }
  
  Object createAndOpen(String paramString)
  {
    Object localObject = this.getMethod;
    if (localObject != null) {}
    try
    {
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      this.openMethod.invoke(localObject, new Object[] { paramString });
      return localObject;
    }
    catch (Exception paramString) {}
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.platform.AndroidPlatform.CloseGuard
 * JD-Core Version:    0.7.0.1
 */