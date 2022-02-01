package org.xwalk.core;

import java.util.ArrayList;

public class XWalkExtendCanvasClient
{
  private static final String TAG = "XWalkExtendCanvasClient";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod sendAsyncMethodsMethod = new ReflectMethod(null, "sendAsyncMethods", new Class[0]);
  
  public XWalkExtendCanvasClient(XWalkView paramXWalkView)
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
  
  public void onAsycResultCallback(int paramInt1, int paramInt2, String paramString) {}
  
  public void onCanvasTouch(String paramString1, int paramInt, String paramString2) {}
  
  public void onSendJsonMessage(String paramString) {}
  
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
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendCanvasClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((ReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.sendAsyncMethodsMethod.init(this.bridge, null, "sendAsyncMethods", new Class[] { String.class, Integer.TYPE });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
  
  public void sendAsyncMethods(String paramString)
  {
    sendAsyncMethods(paramString, 0);
  }
  
  public void sendAsyncMethods(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendAsyncMethods called! methods:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",reply_id:");
    localStringBuilder.append(paramInt);
    Log.d("XWalkExtendCanvasClient", localStringBuilder.toString());
    try
    {
      this.sendAsyncMethodsMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt) });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendCanvasClient
 * JD-Core Version:    0.7.0.1
 */