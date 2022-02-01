package org.xwalk.core;

import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Map;

public class WebViewExtension
{
  public static final String EXTENSION_ADD_FILTER_RESOURCES = "AddFilterResources";
  private static final String TAG = "XWalkLib.WebViewExtension";
  private static WebViewExtensionInterface mWebViewExtensionInterface;
  private static WebViewExtensionListener mWebViewExtensionListener;
  private static WebViewExtension sInstance;
  private ReflectMethod SetExtensionMethod = new ReflectMethod(null, "SetExtension", new Class[0]);
  private Object bridge;
  private ArrayList<Object> constructorParams = new ArrayList();
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  
  public WebViewExtension()
  {
    reflectionInit();
  }
  
  public static void SetExtension(WebViewExtensionListener paramWebViewExtensionListener)
  {
    Log.i("XWalkLib.WebViewExtension", "SetExtension WebViewExtensionInterface");
    mWebViewExtensionListener = paramWebViewExtensionListener;
    try
    {
      updateExtension(true);
      return;
    }
    catch (Exception paramWebViewExtensionListener)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SetExtension refelction not ready, updateExtension when available:");
      localStringBuilder.append(paramWebViewExtensionListener.getMessage());
      Log.i("XWalkLib.WebViewExtension", localStringBuilder.toString());
    }
  }
  
  public static boolean addFilterResources(Resources paramResources, Map<Long, Integer> paramMap)
  {
    return invokeExtensionMethod("AddFilterResources", new Object[] { paramResources, paramMap });
  }
  
  private static WebViewExtension getInstance()
  {
    if (sInstance == null) {
      sInstance = new WebViewExtension();
    }
    return sInstance;
  }
  
  public static boolean invokeExtensionMethod(String paramString, Object... paramVarArgs)
  {
    WebViewExtensionListener localWebViewExtensionListener = mWebViewExtensionListener;
    if (localWebViewExtensionListener != null)
    {
      localWebViewExtensionListener.onMiscCallBack(paramString, paramVarArgs);
      return true;
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("InvokeExtensionMethod interface is null,method:");
    paramVarArgs.append(paramString);
    Log.e("XWalkLib.WebViewExtension", paramVarArgs.toString());
    return false;
  }
  
  public static void updateExtension(boolean paramBoolean)
  {
    if ((mWebViewExtensionListener != null) && ((paramBoolean == true) || (mWebViewExtensionInterface == null)))
    {
      getInstance();
      Log.i("XWalkLib.WebViewExtension", "updateExtension");
      mWebViewExtensionInterface = new WebViewExtension.1();
      getInstance().SetExtensionMethod.invoke(new Object[] { mWebViewExtensionInterface.getBridge() });
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
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("WebViewExtensionBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((ReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.SetExtensionMethod.init(this.bridge, null, "SetExtensionSuper", new Class[] { this.coreWrapper.getBridgeClass("WebViewExtensionInterfaceBridge") });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.WebViewExtension
 * JD-Core Version:    0.7.0.1
 */