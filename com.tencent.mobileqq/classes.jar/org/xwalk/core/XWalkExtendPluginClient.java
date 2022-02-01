package org.xwalk.core;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class XWalkExtendPluginClient
{
  public static final String NATIVE_VIEW_TYPE = "native_view";
  private static final String TAG = "XWalkExtendPluginClient";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private HashMap<Integer, XWalkExtendPluginNativeViewClient> mNativeViewClientMap = new HashMap();
  private ReflectMethod postWrapperMethod;
  private ReflectMethod setPluginTextureScaleStringintfloatfloatMethod = new ReflectMethod(null, "setPluginTextureScale", new Class[0]);
  private ReflectMethod takePluginScreenshotStringintMethod = new ReflectMethod(null, "takePluginScreenshot", new Class[0]);
  
  public XWalkExtendPluginClient(XWalkView paramXWalkView)
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
  
  public XWalkExtendPluginNativeViewDelegate onNativeViewReady(int paramInt)
  {
    return null;
  }
  
  public void onPluginDestroy(String paramString, int paramInt)
  {
    if (("native_view".equals(paramString)) && (this.mNativeViewClientMap.containsKey(Integer.valueOf(paramInt))))
    {
      ((XWalkExtendPluginNativeViewClient)this.mNativeViewClientMap.get(Integer.valueOf(paramInt))).dispose();
      this.mNativeViewClientMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void onPluginManagerDestroy()
  {
    Log.i("XWalkExtendPluginClient", "onPluginManagerDestroy");
    Iterator localIterator = this.mNativeViewClientMap.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExtendPluginNativeViewClient)localIterator.next()).dispose();
    }
    this.mNativeViewClientMap.clear();
  }
  
  public void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture) {}
  
  public void onPluginScreenshotTaken(String paramString, int paramInt, @Nullable Bitmap paramBitmap) {}
  
  public void onPluginSizeChanged(String paramString, int paramInt1, int paramInt2, int paramInt3, SurfaceTexture paramSurfaceTexture)
  {
    if ("native_view".equals(paramString))
    {
      if (!this.mNativeViewClientMap.containsKey(Integer.valueOf(paramInt1)))
      {
        paramString = onNativeViewReady(paramInt1);
        if (paramString != null)
        {
          paramSurfaceTexture = new XWalkExtendPluginNativeViewClient(null, paramSurfaceTexture, paramInt2, paramInt3);
          this.mNativeViewClientMap.put(Integer.valueOf(paramInt1), paramSurfaceTexture);
          paramString.setClient(paramSurfaceTexture);
          paramSurfaceTexture.setDelegate(paramString);
        }
        else
        {
          Log.e("XWalkExtendPluginClient", "onPluginSizeChanged onNativeViewReady return null");
          return;
        }
      }
      ((XWalkExtendPluginNativeViewClient)this.mNativeViewClientMap.get(Integer.valueOf(paramInt1))).onSizeChanged(paramInt2, paramInt3);
    }
  }
  
  public void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    if (("native_view".equals(paramString)) && (this.mNativeViewClientMap.containsKey(Integer.valueOf(paramInt)))) {
      ((XWalkExtendPluginNativeViewClient)this.mNativeViewClientMap.get(Integer.valueOf(paramInt))).getRootView().dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public void onPluginTouch(String paramString1, int paramInt, String paramString2) {}
  
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
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendPluginClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((ReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.setPluginTextureScaleStringintfloatfloatMethod.init(this.bridge, null, "setPluginTextureScale", new Class[] { String.class, Integer.TYPE, Float.TYPE, Float.TYPE });
      this.takePluginScreenshotStringintMethod.init(this.bridge, null, "takePluginScreenshot", new Class[] { String.class, Integer.TYPE });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
  
  public void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPluginTextureScale embed_type:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",embed_id:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",xScale:");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(",yScale:");
      localStringBuilder.append(paramFloat2);
      Log.i("XWalkExtendPluginClient", localStringBuilder.toString());
      this.setPluginTextureScaleStringintfloatfloatMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
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
  
  public void takePluginScreenshot(String paramString, int paramInt)
  {
    try
    {
      this.takePluginScreenshotStringintMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt) });
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
 * Qualified Name:     org.xwalk.core.XWalkExtendPluginClient
 * JD-Core Version:    0.7.0.1
 */