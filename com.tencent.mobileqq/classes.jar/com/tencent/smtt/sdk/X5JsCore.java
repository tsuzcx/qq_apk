package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public class X5JsCore
{
  private static X5JsCore.a a = X5JsCore.a.a;
  private static X5JsCore.a b = X5JsCore.a.a;
  private static X5JsCore.a c = X5JsCore.a.a;
  private final Context d;
  private Object e = null;
  private WebView f = null;
  
  @Deprecated
  public X5JsCore(Context paramContext)
  {
    this.d = paramContext;
    if (canUseX5JsCore(paramContext))
    {
      Object localObject = a("createX5JavaBridge", new Class[] { Context.class }, new Object[] { paramContext });
      if (localObject != null)
      {
        this.e = localObject;
        return;
      }
    }
    Log.e("X5JsCore", "X5JsCore create X5JavaBridge failure, use fallback!");
    this.f = new WebView(paramContext);
    this.f.getSettings().setJavaScriptEnabled(true);
  }
  
  protected static IX5JsVirtualMachine a(Context paramContext, Looper paramLooper)
  {
    if (canUseX5JsCore(paramContext))
    {
      paramContext = a("createX5JsVirtualMachine", new Class[] { Context.class, Looper.class }, new Object[] { paramContext, paramLooper });
      if (paramContext != null) {
        return (IX5JsVirtualMachine)paramContext;
      }
    }
    Log.e("X5JsCore", "X5JsCore#createVirtualMachine failure!");
    return null;
  }
  
  protected static Object a()
  {
    return a("currentContextData", new Class[0], new Object[0]);
  }
  
  private static Object a(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      x localx = x.a();
      if ((localx != null) && (localx.b())) {
        return localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", paramString, paramArrayOfClass, paramVarArgs);
      }
      paramArrayOfClass = new StringBuilder();
      paramArrayOfClass.append("X5Jscore#");
      paramArrayOfClass.append(paramString);
      paramArrayOfClass.append(" - x5CoreEngine is null or is not x5core.");
      Log.e("X5JsCore", paramArrayOfClass.toString());
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean canUseX5JsCore(Context paramContext)
  {
    X5JsCore.a locala1 = a;
    X5JsCore.a locala2 = X5JsCore.a.a;
    boolean bool = false;
    if (locala1 != locala2)
    {
      if (a == X5JsCore.a.c) {
        bool = true;
      }
      return bool;
    }
    a = X5JsCore.a.b;
    paramContext = a("canUseX5JsCore", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)) && (((Boolean)paramContext).booleanValue()))
    {
      paramContext = JsValue.a();
      a("setJsValueFactory", new Class[] { Object.class }, new Object[] { paramContext });
      a = X5JsCore.a.c;
      return true;
    }
    return false;
  }
  
  public static boolean canUseX5JsCoreNewAPI(Context paramContext)
  {
    X5JsCore.a locala1 = c;
    X5JsCore.a locala2 = X5JsCore.a.a;
    boolean bool = false;
    if (locala1 != locala2)
    {
      if (c == X5JsCore.a.c) {
        bool = true;
      }
      return bool;
    }
    c = X5JsCore.a.b;
    paramContext = a("canUseX5JsCoreNewAPI", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)) && (((Boolean)paramContext).booleanValue()))
    {
      c = X5JsCore.a.c;
      return true;
    }
    return false;
  }
  
  public static boolean canX5JsCoreUseNativeBuffer(Context paramContext)
  {
    if (b != X5JsCore.a.a) {
      return b == X5JsCore.a.c;
    }
    b = X5JsCore.a.b;
    if (!canUseX5JsCore(paramContext)) {
      return false;
    }
    paramContext = a("canX5JsCoreUseBuffer", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)) && (((Boolean)paramContext).booleanValue()))
    {
      b = X5JsCore.a.c;
      return true;
    }
    return false;
  }
  
  @Deprecated
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      a("addJavascriptInterface", new Class[] { Object.class, String.class, Object.class }, new Object[] { paramObject, paramString, localObject });
      return;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((WebView)localObject).addJavascriptInterface(paramObject, paramString);
      this.f.loadUrl("about:blank");
    }
  }
  
  @Deprecated
  public void destroy()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      a("destroyX5JsCore", new Class[] { Object.class }, new Object[] { localObject });
      this.e = null;
      return;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((WebView)localObject).clearHistory();
      this.f.clearCache(true);
      this.f.loadUrl("about:blank");
      this.f.freeMemory();
      this.f.pauseTimers();
      this.f.destroy();
      this.f = null;
    }
  }
  
  @Deprecated
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      a("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class, Object.class }, new Object[] { paramString, paramValueCallback, localObject });
      return;
    }
    localObject = this.f;
    if (localObject != null) {
      ((WebView)localObject).evaluateJavascript(paramString, paramValueCallback);
    }
  }
  
  @Deprecated
  public ByteBuffer getNativeBuffer(int paramInt)
  {
    if ((this.e != null) && (canX5JsCoreUseNativeBuffer(this.d)))
    {
      Object localObject1 = Integer.TYPE;
      Object localObject2 = this.e;
      localObject1 = a("getNativeBuffer", new Class[] { Object.class, localObject1 }, new Object[] { localObject2, Integer.valueOf(paramInt) });
      if ((localObject1 != null) && ((localObject1 instanceof ByteBuffer))) {
        return (ByteBuffer)localObject1;
      }
    }
    return null;
  }
  
  @Deprecated
  public int getNativeBufferId()
  {
    if ((this.e != null) && (canX5JsCoreUseNativeBuffer(this.d)))
    {
      Object localObject = this.e;
      localObject = a("getNativeBufferId", new Class[] { Object.class }, new Object[] { localObject });
      if ((localObject != null) && ((localObject instanceof Integer))) {
        return ((Integer)localObject).intValue();
      }
    }
    return -1;
  }
  
  @Deprecated
  public void pause()
  {
    Object localObject = this.e;
    if (localObject != null) {
      a("pause", new Class[] { Object.class }, new Object[] { localObject });
    }
  }
  
  @Deprecated
  public void pauseTimers()
  {
    Object localObject = this.e;
    if (localObject != null) {
      a("pauseTimers", new Class[] { Object.class }, new Object[] { localObject });
    }
  }
  
  @Deprecated
  public void removeJavascriptInterface(String paramString)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      a("removeJavascriptInterface", new Class[] { String.class, Object.class }, new Object[] { paramString, localObject });
      return;
    }
    localObject = this.f;
    if (localObject != null) {
      ((WebView)localObject).removeJavascriptInterface(paramString);
    }
  }
  
  @Deprecated
  public void resume()
  {
    Object localObject = this.e;
    if (localObject != null) {
      a("resume", new Class[] { Object.class }, new Object[] { localObject });
    }
  }
  
  @Deprecated
  public void resumeTimers()
  {
    Object localObject = this.e;
    if (localObject != null) {
      a("resumeTimers", new Class[] { Object.class }, new Object[] { localObject });
    }
  }
  
  @Deprecated
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((this.e != null) && (canX5JsCoreUseNativeBuffer(this.d)))
    {
      Class localClass = Integer.TYPE;
      Object localObject = this.e;
      a("setNativeBuffer", new Class[] { Object.class, localClass, ByteBuffer.class }, new Object[] { localObject, Integer.valueOf(paramInt), paramByteBuffer });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.X5JsCore
 * JD-Core Version:    0.7.0.1
 */