package org.xwalk.core;

import java.util.ArrayList;

public class XWalkJavascriptResultHandler
  implements XWalkJavascriptResult
{
  private Object bridge;
  private ReflectMethod cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
  private ReflectMethod confirmMethod = new ReflectMethod(null, "confirm", new Class[0]);
  private ReflectMethod confirmWithResultStringMethod = new ReflectMethod(null, "confirmWithResult", new Class[0]);
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  
  public XWalkJavascriptResultHandler(Object paramObject)
  {
    this.bridge = paramObject;
    reflectionInit();
  }
  
  public void cancel()
  {
    try
    {
      this.cancelMethod.invoke(new Object[0]);
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
  
  public void confirm()
  {
    try
    {
      this.confirmMethod.invoke(new Object[0]);
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
  
  public void confirmWithResult(String paramString)
  {
    try
    {
      this.confirmWithResultStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
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
    this.confirmMethod.init(this.bridge, null, "confirmSuper", new Class[0]);
    this.confirmWithResultStringMethod.init(this.bridge, null, "confirmWithResultSuper", new Class[] { String.class });
    this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkJavascriptResultHandler
 * JD-Core Version:    0.7.0.1
 */