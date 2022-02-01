package org.xwalk.core;

import java.util.ArrayList;
import org.xwalk.core.util.WebAddress;

public class XWalkCookieManager
{
  private static final String TAG = "XWalkCookieManager";
  private ReflectMethod acceptCookieMethod = new ReflectMethod(null, "acceptCookie", new Class[0]);
  private ReflectMethod allowFileSchemeCookiesMethod = new ReflectMethod(null, "allowFileSchemeCookies", new Class[0]);
  private Object bridge;
  private ArrayList<Object> constructorParams = new ArrayList();
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod flushCookieStoreMethod = new ReflectMethod(null, "flushCookieStore", new Class[0]);
  private ReflectMethod getCookieStringMethod = new ReflectMethod(null, "getCookie", new Class[0]);
  private ReflectMethod hasCookiesMethod = new ReflectMethod(null, "hasCookies", new Class[0]);
  private ReflectMethod postWrapperMethod;
  private ReflectMethod removeAllCookieMethod = new ReflectMethod(null, "removeAllCookie", new Class[0]);
  private ReflectMethod removeExpiredCookieMethod = new ReflectMethod(null, "removeExpiredCookie", new Class[0]);
  private ReflectMethod removeSessionCookieMethod = new ReflectMethod(null, "removeSessionCookie", new Class[0]);
  private ReflectMethod setAcceptCookiebooleanMethod = new ReflectMethod(null, "setAcceptCookie", new Class[0]);
  private ReflectMethod setAcceptFileSchemeCookiesbooleanMethod = new ReflectMethod(null, "setAcceptFileSchemeCookies", new Class[0]);
  private ReflectMethod setCookieStringStringMethod = new ReflectMethod(null, "setCookie", new Class[0]);
  
  public XWalkCookieManager()
  {
    reflectionInit();
  }
  
  public boolean acceptCookie()
  {
    try
    {
      boolean bool = ((Boolean)this.acceptCookieMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean allowFileSchemeCookies()
  {
    try
    {
      boolean bool = ((Boolean)this.allowFileSchemeCookiesMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void flushCookieStore()
  {
    try
    {
      this.flushCookieStoreMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getCookie(String paramString)
  {
    try
    {
      try
      {
        String str = new WebAddress(paramString).toString();
        paramString = str;
      }
      catch (UnsupportedOperationException paramString)
      {
        break label49;
      }
    }
    catch (Exception localException)
    {
      label21:
      label49:
      break label21;
    }
    Log.e("XWalkCookieManager", "getCookie transform url to WebAddress failed");
    paramString = (String)this.getCookieStringMethod.invoke(new Object[] { paramString });
    return paramString;
    if (this.coreWrapper != null)
    {
      XWalkCoreWrapper.handleRuntimeError(paramString);
      return null;
    }
    throw new RuntimeException("Crosswalk's APIs are not ready yet");
  }
  
  public boolean hasCookies()
  {
    try
    {
      boolean bool = ((Boolean)this.hasCookiesMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      return;
    }
    int j = this.constructorTypes.size();
    Object localObject1 = new Class[j + 1];
    int i = 0;
    while (i < j)
    {
      Object localObject2 = this.constructorTypes.get(i);
      if ((localObject2 instanceof String))
      {
        localObject1[i] = this.coreWrapper.getBridgeClass((String)localObject2);
        localObject2 = this.constructorParams;
        ((ArrayList)localObject2).set(i, this.coreWrapper.getBridgeObject(((ArrayList)localObject2).get(i)));
      }
      else if ((localObject2 instanceof Class))
      {
        localObject1[i] = ((Class)localObject2);
      }
      i += 1;
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkCookieManagerBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((ReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.setAcceptCookiebooleanMethod.init(this.bridge, null, "setAcceptCookieSuper", new Class[] { Boolean.TYPE });
      this.acceptCookieMethod.init(this.bridge, null, "acceptCookieSuper", new Class[0]);
      this.setCookieStringStringMethod.init(this.bridge, null, "setCookieSuper", new Class[] { String.class, String.class });
      this.getCookieStringMethod.init(this.bridge, null, "getCookieSuper", new Class[] { String.class });
      this.removeSessionCookieMethod.init(this.bridge, null, "removeSessionCookieSuper", new Class[0]);
      this.removeAllCookieMethod.init(this.bridge, null, "removeAllCookieSuper", new Class[0]);
      this.hasCookiesMethod.init(this.bridge, null, "hasCookiesSuper", new Class[0]);
      this.removeExpiredCookieMethod.init(this.bridge, null, "removeExpiredCookieSuper", new Class[0]);
      this.flushCookieStoreMethod.init(this.bridge, null, "flushCookieStoreSuper", new Class[0]);
      this.allowFileSchemeCookiesMethod.init(this.bridge, null, "allowFileSchemeCookiesSuper", new Class[0]);
      this.setAcceptFileSchemeCookiesbooleanMethod.init(this.bridge, null, "setAcceptFileSchemeCookiesSuper", new Class[] { Boolean.TYPE });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
  
  public void removeAllCookie()
  {
    try
    {
      this.removeAllCookieMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void removeExpiredCookie()
  {
    try
    {
      this.removeExpiredCookieMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void removeSessionCookie()
  {
    try
    {
      this.removeSessionCookieMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    try
    {
      this.setAcceptCookiebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setAcceptFileSchemeCookies(boolean paramBoolean)
  {
    try
    {
      this.setAcceptFileSchemeCookiesbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    try
    {
      try
      {
        String str = new WebAddress(paramString1).toString();
        paramString1 = str;
      }
      catch (UnsupportedOperationException paramString1)
      {
        break label49;
      }
    }
    catch (Exception localException)
    {
      label21:
      label49:
      break label21;
    }
    Log.e("XWalkCookieManager", "setCookie transform url to WebAddress failed");
    this.setCookieStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
    return;
    if (this.coreWrapper != null)
    {
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      return;
    }
    throw new RuntimeException("Crosswalk's APIs are not ready yet");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkCookieManager
 * JD-Core Version:    0.7.0.1
 */