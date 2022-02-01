package org.xwalk.core;

import java.util.ArrayList;

public class XWalkNavigationItem
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
  private ReflectMethod getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
  private ReflectMethod getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
  private ReflectMethod postWrapperMethod;
  
  public XWalkNavigationItem(Object paramObject)
  {
    this.bridge = paramObject;
    reflectionInit();
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getOriginalUrl()
  {
    try
    {
      String str = (String)this.getOriginalUrlMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getTitle()
  {
    try
    {
      String str = (String)this.getTitleMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getUrl()
  {
    try
    {
      String str = (String)this.getUrlMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
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
    this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
    this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
    this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkNavigationItem
 * JD-Core Version:    0.7.0.1
 */