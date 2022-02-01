package org.xwalk.core;

import java.util.ArrayList;

public abstract class XWalkExtension
{
  private Object bridge;
  private ReflectMethod broadcastMessageStringMethod = new ReflectMethod(null, "broadcastMessage", new Class[0]);
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod onBinaryMessageintbyteArrayMethod = new ReflectMethod(null, "onBinaryMessage", new Class[0]);
  private ReflectMethod onInstanceCreatedintMethod = new ReflectMethod(null, "onInstanceCreated", new Class[0]);
  private ReflectMethod onInstanceDestroyedintMethod = new ReflectMethod(null, "onInstanceDestroyed", new Class[0]);
  private ReflectMethod postBinaryMessageintbyteArrayMethod = new ReflectMethod(null, "postBinaryMessage", new Class[0]);
  private ReflectMethod postMessageintStringMethod = new ReflectMethod(null, "postMessage", new Class[0]);
  private ReflectMethod postWrapperMethod;
  
  public XWalkExtension(String paramString1, String paramString2)
  {
    this.constructorTypes.add(String.class);
    this.constructorTypes.add(String.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramString1);
    this.constructorParams.add(paramString2);
    reflectionInit();
  }
  
  public XWalkExtension(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    this.constructorTypes.add(String.class);
    this.constructorTypes.add(String.class);
    this.constructorTypes.add([Ljava.lang.String.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramString1);
    this.constructorParams.add(paramString2);
    this.constructorParams.add(paramArrayOfString);
    reflectionInit();
  }
  
  public void broadcastMessage(String paramString)
  {
    try
    {
      this.broadcastMessageStringMethod.invoke(new Object[] { paramString });
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
  
  public void onBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      this.onBinaryMessageintbyteArrayMethod.invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfByte });
      return;
    }
    catch (UnsupportedOperationException paramArrayOfByte)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramArrayOfByte);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onInstanceCreated(int paramInt)
  {
    try
    {
      this.onInstanceCreatedintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void onInstanceDestroyed(int paramInt)
  {
    try
    {
      this.onInstanceDestroyedintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public abstract void onMessage(int paramInt, String paramString);
  
  public abstract String onSyncMessage(int paramInt, String paramString);
  
  public void postBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      this.postBinaryMessageintbyteArrayMethod.invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfByte });
      return;
    }
    catch (UnsupportedOperationException paramArrayOfByte)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramArrayOfByte);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void postMessage(int paramInt, String paramString)
  {
    try
    {
      this.postMessageintStringMethod.invoke(new Object[] { Integer.valueOf(paramInt), paramString });
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
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtensionBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((ReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.postMessageintStringMethod.init(this.bridge, null, "postMessageSuper", new Class[] { Integer.TYPE, String.class });
      this.postBinaryMessageintbyteArrayMethod.init(this.bridge, null, "postBinaryMessageSuper", new Class[] { Integer.TYPE, [B.class });
      this.broadcastMessageStringMethod.init(this.bridge, null, "broadcastMessageSuper", new Class[] { String.class });
      this.onInstanceCreatedintMethod.init(this.bridge, null, "onInstanceCreatedSuper", new Class[] { Integer.TYPE });
      this.onInstanceDestroyedintMethod.init(this.bridge, null, "onInstanceDestroyedSuper", new Class[] { Integer.TYPE });
      this.onBinaryMessageintbyteArrayMethod.init(this.bridge, null, "onBinaryMessageSuper", new Class[] { Integer.TYPE, [B.class });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkExtension
 * JD-Core Version:    0.7.0.1
 */