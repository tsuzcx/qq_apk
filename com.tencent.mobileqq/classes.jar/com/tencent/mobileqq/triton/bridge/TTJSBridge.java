package com.tencent.mobileqq.triton.bridge;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.JNICaller.TTJSBridge;
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
  public static final String TAG = "<API>";
  private BridgeLoger mBridgeLoger;
  private TTEngine mTritonEngine;
  private Map<Integer, ITTJSRuntime> runtimeMap = new HashMap();
  
  public TTJSBridge(TTEngine paramTTEngine)
  {
    if (paramTTEngine == null) {
      throw new IllegalArgumentException("can't constructor TTJSBridge with null TritonEngine");
    }
    this.mTritonEngine = paramTTEngine;
    this.mBridgeLoger = new BridgeLoger(paramTTEngine);
  }
  
  private IJSEngine getJsEngine(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.mTritonEngine.getInnerJsEngine() != null) && (this.mTritonEngine.getInnerJsEngine().canHandleEvent(paramString))) {
      localObject1 = this.mTritonEngine.getInnerJsEngine();
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.mTritonEngine.getJsEngine() == null);
      localObject1 = localObject2;
    } while (!this.mTritonEngine.getJsEngine().canHandleEvent(paramString));
    return this.mTritonEngine.getJsEngine();
  }
  
  public void evaluateCallbackJs(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramInt2 = this.mBridgeLoger.printEndLog(paramInt1, paramInt2, paramString2);
    if (this.mTritonEngine.isGLThread())
    {
      JNICaller.TTJSBridge.nativeEvaluateCallbackJs(this, this.mTritonEngine.getNativeTTAppHandle(), paramInt1, paramString1, paramInt2, paramString2);
      return;
    }
    this.mTritonEngine.postRunnable(new TTJSBridge.1(this, paramInt1, paramString1, paramInt2, paramString2));
  }
  
  public void evaluateJs(int paramInt, String paramString)
  {
    this.mBridgeLoger.printEndLog(paramInt, paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.mTritonEngine.isGLThread())
    {
      JNICaller.TTJSBridge.nativeEvaluateJs(this, this.mTritonEngine.getNativeTTAppHandle(), paramInt, paramString);
      return;
    }
    this.mTritonEngine.postRunnable(new TTJSBridge.3(this, paramInt, paramString));
  }
  
  public void evaluateSubscribeJs(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.mBridgeLoger.printEndLog(paramInt, paramString2, paramString3);
    if (this.mTritonEngine.isGLThread())
    {
      JNICaller.TTJSBridge.nativeEvaluateSubscribeJs(this, this.mTritonEngine.getNativeTTAppHandle(), paramInt, paramString1, paramString2, paramString3);
      return;
    }
    this.mTritonEngine.postRunnable(new TTJSBridge.2(this, paramInt, paramString1, paramString2, paramString3));
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    if (this.runtimeMap.get(Integer.valueOf(paramInt)) != null) {
      return (ITTJSRuntime)this.runtimeMap.get(Integer.valueOf(paramInt));
    }
    TTJSRuntime localTTJSRuntime = new TTJSRuntime(this, paramInt);
    this.runtimeMap.put(Integer.valueOf(paramInt), localTTJSRuntime);
    return localTTJSRuntime;
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return JNICaller.TTJSBridge.nativeGetNativeBuffer(this, this.mTritonEngine.getNativeTTAppHandle(), paramInt);
  }
  
  public native boolean nativeEvaluateCallbackJs(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2);
  
  public native void nativeEvaluateJs(long paramLong, int paramInt, String paramString);
  
  public native boolean nativeEvaluateSubscribeJs(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3);
  
  public native byte[] nativeGetNativeBuffer(long paramLong, int paramInt);
  
  public native int nativeNewNativeBuffer(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public int newNativeBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return JNICaller.TTJSBridge.nativeNewNativeBuffer(this, this.mTritonEngine.getNativeTTAppHandle(), paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String onScriptCall(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    String str = "{}";
    paramInt1 = this.mBridgeLoger.changeCallbackId(paramInt1);
    IJSEngine localIJSEngine = getJsEngine(paramString1);
    if (localIJSEngine != null) {
      str = localIJSEngine.onScriptCall(paramString1, paramString2, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.mBridgeLoger.printStartLog(paramInt2, paramString1, paramString2, paramInt1, str);
      return str;
      TTLog.e("<API>", "!!! API [" + paramString1 + "] 未实现  - (invoke) !!!");
    }
  }
  
  public String onScriptPublish(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      paramString3 = new JSONArray(paramString3);
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        IJSEngine localIJSEngine = getJsEngine(paramString1);
        if (localIJSEngine != null)
        {
          paramInt = 0;
          while (paramInt < paramString3.length())
          {
            localIJSEngine.onScriptCall(paramString1, paramString2, -1, paramString3.optInt(paramInt));
            paramInt += 1;
          }
        }
        TTLog.e("<API>", "!!! API [" + paramString1 + "] 未实现 - (publish) !!!");
        paramString2 = new JSONObject();
        paramString2.put("state", "fail");
        return ApiUtil.wrapCallbackFail(paramString1, paramString2, "接口未实现").toString();
      }
      paramString2 = new JSONObject();
      paramString2.put("state", "success");
      paramString2 = ApiUtil.wrapCallbackOk(paramString1, paramString2).toString();
      return paramString2;
    }
    catch (Throwable paramString2)
    {
      TTLog.e("<API>", "!!! publish event [" + paramString1 + "] exception !!!", paramString2);
      try
      {
        paramString2 = new JSONObject();
        paramString2.put("state", "fail");
        paramString2 = ApiUtil.wrapCallbackFail(paramString1, paramString2).toString();
        return paramString2;
      }
      catch (Throwable paramString2)
      {
        TTLog.e("<API>", "!!! publish event [" + paramString1 + "] exception on callbackFail !!!", paramString2);
      }
    }
    return "{}";
  }
  
  public void runOnJsThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.mTritonEngine.postRunnable(paramRunnable);
  }
  
  public void runOnJsThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    this.mTritonEngine.postRunnableDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.TTJSBridge
 * JD-Core Version:    0.7.0.1
 */