package com.tencent.mobileqq.triton.bridge;

import android.os.Trace;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.LogConfig;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.utils.ApiUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@JNIModule
public class TTJSBridge
  implements ITNativeBufferPool
{
  private Map<Integer, ITTJSRuntime> a = new HashMap();
  private TTEngine b;
  private a c;
  
  public TTJSBridge(TTEngine paramTTEngine)
  {
    if (paramTTEngine != null)
    {
      this.b = paramTTEngine;
      this.c = new a();
      return;
    }
    throw new IllegalArgumentException("can't constructor TTJSBridge with null TritonEngine");
  }
  
  private IJSEngine a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.b.g() != null) && (this.b.g().canHandleEvent(paramString))) {
      localObject1 = this.b.g();
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.b.getJsEngine() == null);
      localObject1 = localObject2;
    } while (!this.b.getJsEngine().canHandleEvent(paramString));
    return this.b.getJsEngine();
  }
  
  public ITTJSRuntime a(int paramInt)
  {
    if (this.a.get(Integer.valueOf(paramInt)) != null) {
      return (ITTJSRuntime)this.a.get(Integer.valueOf(paramInt));
    }
    c localc = new c(this, paramInt);
    this.a.put(Integer.valueOf(paramInt), localc);
    return localc;
  }
  
  public String a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    String str = "{}";
    paramInt1 = this.c.a(paramInt1);
    IJSEngine localIJSEngine = a(paramString1);
    if (localIJSEngine != null)
    {
      Trace.beginSection("java:" + paramString1);
      str = localIJSEngine.onScriptCall(paramString1, paramString2, paramInt1, paramInt2);
      Trace.endSection();
    }
    for (;;)
    {
      this.c.a(paramInt2, paramString1, paramString2, paramInt1, str);
      return str;
      TTLog.b("<API>", "!!! API [" + paramString1 + "] 未实现  - (invoke) !!!");
    }
  }
  
  public String a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      paramString3 = new JSONArray(paramString3);
      if (paramString3.length() > 0)
      {
        IJSEngine localIJSEngine = a(paramString1);
        if (localIJSEngine != null)
        {
          paramInt = 0;
          while (paramInt < paramString3.length())
          {
            localIJSEngine.onScriptCall(paramString1, paramString2, -1, paramString3.optInt(paramInt));
            paramInt += 1;
          }
        }
        TTLog.b("<API>", "!!! API [" + paramString1 + "] 未实现 - (publish) !!!");
        paramString2 = new JSONObject();
        paramString2.put("state", "fail");
        return ApiUtil.wrapCallbackFail(paramString1, paramString2, "接口未实现").toString();
      }
      paramString2 = new JSONObject();
      paramString2.put("state", "success");
      paramString2 = ApiUtil.wrapCallbackOk(paramString1, paramString2).toString();
      return paramString2;
    }
    finally
    {
      TTLog.b("<API>", "!!! publish event [" + paramString1 + "] exception !!!", paramString2);
      try
      {
        paramString2 = new JSONObject();
        paramString2.put("state", "fail");
        paramString2 = ApiUtil.wrapCallbackFail(paramString1, paramString2).toString();
        return paramString2;
      }
      finally
      {
        TTLog.b("<API>", "!!! publish event [" + paramString1 + "] exception on callbackFail !!!", paramString2);
      }
    }
    return "{}";
  }
  
  public void a()
  {
    a locala = this.c;
    if (locala != null) {
      locala.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.b.o())
    {
      com.tencent.mobileqq.triton.jni.c.a(this, this.b.k(), paramInt, paramString);
      return;
    }
    this.b.a(new TTJSBridge.c(this, paramInt, paramString));
  }
  
  public void a(LogConfig paramLogConfig)
  {
    a locala = this.c;
    if (locala != null) {
      locala.a(paramLogConfig);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.b.a(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    this.b.a(paramRunnable, paramLong);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramInt2 = this.c.a(paramInt2, paramString2);
    this.b.a(new TTJSBridge.a(this, paramInt1, paramString1, paramInt2, paramString2));
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.c.a(paramString2, paramString3);
    this.b.a(new TTJSBridge.b(this, paramInt, paramString1, paramString2, paramString3));
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return com.tencent.mobileqq.triton.jni.c.a(this, this.b.k(), paramInt);
  }
  
  public native boolean nativeEvaluateCallbackJs(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2);
  
  public native void nativeEvaluateJs(long paramLong, int paramInt, String paramString);
  
  public native boolean nativeEvaluateSubscribeJs(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3);
  
  public native byte[] nativeGetNativeBuffer(long paramLong, int paramInt);
  
  public native int nativeNewNativeBuffer(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public int newNativeBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return com.tencent.mobileqq.triton.jni.c.a(this, this.b.k(), paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.TTJSBridge
 * JD-Core Version:    0.7.0.1
 */