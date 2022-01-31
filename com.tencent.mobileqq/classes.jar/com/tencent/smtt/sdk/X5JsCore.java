package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public class X5JsCore
{
  private static final String TAG = "X5JsCore";
  private static X5JsCore.Availability sCanUseX5JsCore = X5JsCore.Availability.UNINITIALIZED;
  private static X5JsCore.Availability sCanUseX5JsCoreNewApi = X5JsCore.Availability.UNINITIALIZED;
  private static X5JsCore.Availability sX5JsCoreCanUseBuffer = X5JsCore.Availability.UNINITIALIZED;
  private Object mBridge = null;
  private final Context mContext;
  private WebView mWebView = null;
  
  @Deprecated
  public X5JsCore(Context paramContext)
  {
    this.mContext = paramContext;
    if (canUseX5JsCore(paramContext))
    {
      Object localObject = invokeWebCoreProxyMethod("createX5JavaBridge", new Class[] { Context.class }, new Object[] { paramContext });
      if (localObject != null)
      {
        this.mBridge = localObject;
        return;
      }
    }
    Log.e("X5JsCore", "X5JsCore create X5JavaBridge failure, use fallback!");
    this.mWebView = new WebView(paramContext);
    this.mWebView.getSettings().setJavaScriptEnabled(true);
  }
  
  public static boolean canUseX5JsCore(Context paramContext)
  {
    if (sCanUseX5JsCore != X5JsCore.Availability.UNINITIALIZED) {
      return sCanUseX5JsCore == X5JsCore.Availability.AVAILABLE;
    }
    sCanUseX5JsCore = X5JsCore.Availability.UNAVAILABLE;
    paramContext = invokeWebCoreProxyMethod("canUseX5JsCore", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)) && (((Boolean)paramContext).booleanValue()))
    {
      paramContext = JsValue.factory();
      invokeWebCoreProxyMethod("setJsValueFactory", new Class[] { Object.class }, new Object[] { paramContext });
      sCanUseX5JsCore = X5JsCore.Availability.AVAILABLE;
      return true;
    }
    return false;
  }
  
  public static boolean canUseX5JsCoreNewAPI(Context paramContext)
  {
    if (sCanUseX5JsCoreNewApi != X5JsCore.Availability.UNINITIALIZED) {
      return sCanUseX5JsCoreNewApi == X5JsCore.Availability.AVAILABLE;
    }
    sCanUseX5JsCoreNewApi = X5JsCore.Availability.UNAVAILABLE;
    paramContext = invokeWebCoreProxyMethod("canUseX5JsCoreNewAPI", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)) && (((Boolean)paramContext).booleanValue()))
    {
      sCanUseX5JsCoreNewApi = X5JsCore.Availability.AVAILABLE;
      return true;
    }
    return false;
  }
  
  public static boolean canX5JsCoreUseNativeBuffer(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (sX5JsCoreCanUseBuffer != X5JsCore.Availability.UNINITIALIZED) {
      if (sX5JsCoreCanUseBuffer == X5JsCore.Availability.AVAILABLE) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return bool1;
              bool1 = false;
            }
            sX5JsCoreCanUseBuffer = X5JsCore.Availability.UNAVAILABLE;
            bool1 = bool2;
          } while (!canUseX5JsCore(paramContext));
          paramContext = invokeWebCoreProxyMethod("canX5JsCoreUseBuffer", new Class[] { Context.class }, new Object[] { paramContext });
          bool1 = bool2;
        } while (paramContext == null);
        bool1 = bool2;
      } while (!(paramContext instanceof Boolean));
      bool1 = bool2;
    } while (!((Boolean)paramContext).booleanValue());
    sX5JsCoreCanUseBuffer = X5JsCore.Availability.AVAILABLE;
    return true;
  }
  
  protected static IX5JsVirtualMachine createVirtualMachine(Context paramContext, Looper paramLooper)
  {
    if (canUseX5JsCore(paramContext))
    {
      paramContext = invokeWebCoreProxyMethod("createX5JsVirtualMachine", new Class[] { Context.class, Looper.class }, new Object[] { paramContext, paramLooper });
      if (paramContext != null) {
        return (IX5JsVirtualMachine)paramContext;
      }
    }
    Log.e("X5JsCore", "X5JsCore#createVirtualMachine failure!");
    return null;
  }
  
  protected static Object currentContextData()
  {
    return invokeWebCoreProxyMethod("currentContextData", new Class[0], new Object[0]);
  }
  
  private static Object invokeWebCoreProxyMethod(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
      if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
        return localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", paramString, paramArrayOfClass, paramVarArgs);
      }
      Log.e("X5JsCore", "X5Jscore#" + paramString + " - x5CoreEngine is null or is not x5core.");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  @Deprecated
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (this.mBridge != null)
    {
      localObject = this.mBridge;
      invokeWebCoreProxyMethod("addJavascriptInterface", new Class[] { Object.class, String.class, Object.class }, new Object[] { paramObject, paramString, localObject });
    }
    while (this.mWebView == null)
    {
      Object localObject;
      return;
    }
    this.mWebView.addJavascriptInterface(paramObject, paramString);
    this.mWebView.loadUrl("about:blank");
  }
  
  @Deprecated
  public void destroy()
  {
    if (this.mBridge != null)
    {
      localObject = this.mBridge;
      invokeWebCoreProxyMethod("destroyX5JsCore", new Class[] { Object.class }, new Object[] { localObject });
      this.mBridge = null;
    }
    while (this.mWebView == null)
    {
      Object localObject;
      return;
    }
    this.mWebView.clearHistory();
    this.mWebView.clearCache(true);
    this.mWebView.loadUrl("about:blank");
    this.mWebView.freeMemory();
    this.mWebView.pauseTimers();
    this.mWebView.destroy();
    this.mWebView = null;
  }
  
  @Deprecated
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.mBridge != null)
    {
      localObject = this.mBridge;
      invokeWebCoreProxyMethod("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class, Object.class }, new Object[] { paramString, paramValueCallback, localObject });
    }
    while (this.mWebView == null)
    {
      Object localObject;
      return;
    }
    this.mWebView.evaluateJavascript(paramString, paramValueCallback);
  }
  
  @Deprecated
  public ByteBuffer getNativeBuffer(int paramInt)
  {
    if ((this.mBridge != null) && (canX5JsCoreUseNativeBuffer(this.mContext)))
    {
      Object localObject1 = Integer.TYPE;
      Object localObject2 = this.mBridge;
      localObject1 = invokeWebCoreProxyMethod("getNativeBuffer", new Class[] { Object.class, localObject1 }, new Object[] { localObject2, Integer.valueOf(paramInt) });
      if ((localObject1 != null) && ((localObject1 instanceof ByteBuffer))) {
        return (ByteBuffer)localObject1;
      }
    }
    return null;
  }
  
  @Deprecated
  public int getNativeBufferId()
  {
    if ((this.mBridge != null) && (canX5JsCoreUseNativeBuffer(this.mContext)))
    {
      Object localObject = this.mBridge;
      localObject = invokeWebCoreProxyMethod("getNativeBufferId", new Class[] { Object.class }, new Object[] { localObject });
      if ((localObject != null) && ((localObject instanceof Integer))) {
        return ((Integer)localObject).intValue();
      }
    }
    return -1;
  }
  
  @Deprecated
  public void pause()
  {
    if (this.mBridge != null)
    {
      Object localObject = this.mBridge;
      invokeWebCoreProxyMethod("pause", new Class[] { Object.class }, new Object[] { localObject });
    }
  }
  
  @Deprecated
  public void pauseTimers()
  {
    if (this.mBridge != null)
    {
      Object localObject = this.mBridge;
      invokeWebCoreProxyMethod("pauseTimers", new Class[] { Object.class }, new Object[] { localObject });
    }
  }
  
  @Deprecated
  public void removeJavascriptInterface(String paramString)
  {
    if (this.mBridge != null)
    {
      localObject = this.mBridge;
      invokeWebCoreProxyMethod("removeJavascriptInterface", new Class[] { String.class, Object.class }, new Object[] { paramString, localObject });
    }
    while (this.mWebView == null)
    {
      Object localObject;
      return;
    }
    this.mWebView.removeJavascriptInterface(paramString);
  }
  
  @Deprecated
  public void resume()
  {
    if (this.mBridge != null)
    {
      Object localObject = this.mBridge;
      invokeWebCoreProxyMethod("resume", new Class[] { Object.class }, new Object[] { localObject });
    }
  }
  
  @Deprecated
  public void resumeTimers()
  {
    if (this.mBridge != null)
    {
      Object localObject = this.mBridge;
      invokeWebCoreProxyMethod("resumeTimers", new Class[] { Object.class }, new Object[] { localObject });
    }
  }
  
  @Deprecated
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((this.mBridge != null) && (canX5JsCoreUseNativeBuffer(this.mContext)))
    {
      Class localClass = Integer.TYPE;
      Object localObject = this.mBridge;
      invokeWebCoreProxyMethod("setNativeBuffer", new Class[] { Object.class, localClass, ByteBuffer.class }, new Object[] { localObject, Integer.valueOf(paramInt), paramByteBuffer });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.X5JsCore
 * JD-Core Version:    0.7.0.1
 */