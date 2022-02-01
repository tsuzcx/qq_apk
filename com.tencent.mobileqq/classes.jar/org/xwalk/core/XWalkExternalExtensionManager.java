package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

public abstract class XWalkExternalExtensionManager
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getViewActivityMethod = new ReflectMethod(null, "getViewActivity", new Class[0]);
  private ReflectMethod getViewContextMethod = new ReflectMethod(null, "getViewContext", new Class[0]);
  private ReflectMethod loadExtensionStringMethod = new ReflectMethod(null, "loadExtension", new Class[0]);
  private ReflectMethod onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
  private ReflectMethod onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
  private ReflectMethod onPauseMethod = new ReflectMethod(null, "onPause", new Class[0]);
  private ReflectMethod onResumeMethod = new ReflectMethod(null, "onResume", new Class[0]);
  private ReflectMethod onStartMethod = new ReflectMethod(null, "onStart", new Class[0]);
  private ReflectMethod onStopMethod = new ReflectMethod(null, "onStop", new Class[0]);
  private ReflectMethod postWrapperMethod;
  
  public XWalkExternalExtensionManager(XWalkView paramXWalkView)
  {
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  @Deprecated
  public Activity getViewActivity()
  {
    try
    {
      Activity localActivity = (Activity)this.getViewActivityMethod.invoke(new Object[0]);
      return localActivity;
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
  
  public Context getViewContext()
  {
    try
    {
      Context localContext = (Context)this.getViewContextMethod.invoke(new Object[0]);
      return localContext;
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
  
  public void loadExtension(String paramString)
  {
    try
    {
      this.loadExtensionStringMethod.invoke(new Object[] { paramString });
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
  
  @Deprecated
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      this.onActivityResultintintIntentMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramIntent);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.onDestroyMethod.invoke(new Object[0]);
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
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public void onPause()
  {
    try
    {
      this.onPauseMethod.invoke(new Object[0]);
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
  
  public void onResume()
  {
    try
    {
      this.onResumeMethod.invoke(new Object[0]);
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
  
  public void onStart()
  {
    try
    {
      this.onStartMethod.invoke(new Object[0]);
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
  
  public void onStop()
  {
    try
    {
      this.onStopMethod.invoke(new Object[0]);
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
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExternalExtensionManagerBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((ReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.getViewActivityMethod.init(this.bridge, null, "getViewActivitySuper", new Class[0]);
      this.getViewContextMethod.init(this.bridge, null, "getViewContextSuper", new Class[0]);
      this.loadExtensionStringMethod.init(this.bridge, null, "loadExtensionSuper", new Class[] { String.class });
      this.onStartMethod.init(this.bridge, null, "onStartSuper", new Class[0]);
      this.onResumeMethod.init(this.bridge, null, "onResumeSuper", new Class[0]);
      this.onPauseMethod.init(this.bridge, null, "onPauseSuper", new Class[0]);
      this.onStopMethod.init(this.bridge, null, "onStopSuper", new Class[0]);
      this.onDestroyMethod.init(this.bridge, null, "onDestroySuper", new Class[0]);
      this.onActivityResultintintIntentMethod.init(this.bridge, null, "onActivityResultSuper", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkExternalExtensionManager
 * JD-Core Version:    0.7.0.1
 */