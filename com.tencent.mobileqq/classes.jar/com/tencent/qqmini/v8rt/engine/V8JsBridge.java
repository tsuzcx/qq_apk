package com.tencent.qqmini.v8rt.engine;

import android.text.TextUtils;
import com.tencent.qqmini.v8rt.anno.CallByNative;
import java.util.Iterator;

public class V8JsBridge
  implements INativeBuffer
{
  public static final String TAG = "API-Java";
  
  private static IJsEngine getJsEngine(String paramString)
  {
    Iterator localIterator = JsEngineProvider.getInstance().iterator();
    Object localObject1 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (IJsEngine)localIterator.next();
      if (((IJsEngine)localObject2).canHandleEvent(paramString)) {
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" handled by ");
      ((StringBuilder)localObject2).append(localObject1);
      Logger.i("API-Java", ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public static void jniEvalJs(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    nativeEvaluateJs(paramInt1, paramInt2, paramString);
  }
  
  public static Object jniEvalJsWithReturn(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return nativeEvaluateJsWithReturn(paramInt1, paramInt2, paramString);
  }
  
  public static long jniEvalJsWithReturnPtr(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    return nativeEvaluateJsWithReturnPtr(paramInt1, paramInt2, paramString);
  }
  
  public static Object jniPtrJsonString(long paramLong, int paramInt)
  {
    if (paramLong == 0L) {
      return null;
    }
    return nativePtrJsonString(paramLong, paramInt);
  }
  
  public static int[] jsStringToJavaIntArray(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return new int[0];
    }
    paramString = paramString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
    int[] arrayOfInt = new int[paramString.length];
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        label63:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label63;
      }
    }
  }
  
  public static native boolean nativeEvaluateCallbackJs(int paramInt1, String paramString1, int paramInt2, String paramString2);
  
  public static native void nativeEvaluateJs(int paramInt1, int paramInt2, String paramString);
  
  public static native Object nativeEvaluateJsWithReturn(int paramInt1, int paramInt2, String paramString);
  
  public static native long nativeEvaluateJsWithReturnPtr(int paramInt1, int paramInt2, String paramString);
  
  public static native boolean nativeEvaluateSubscribeJs(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public static native byte[] nativeGetNativeBuffer(int paramInt);
  
  public static native int nativeNewNativeBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native Object nativePtrJsonString(long paramLong, int paramInt);
  
  @CallByNative
  public static String onScriptCall(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onScriptCall event:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", params:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", callbackId:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",contextType:");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.i("API-Java", ((StringBuilder)localObject).toString());
    localObject = Engine.getInstance().getJsRuntime(paramInt2);
    if (localObject == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("onScriptCall contextType is invalid ");
      paramString1.append(paramInt2);
      paramString1.append(", is runtime released?");
      Logger.e("API-Java", paramString1.toString());
      return "{}";
    }
    IServiceEventHandler localIServiceEventHandler = ServiceEventHandlerProvider.getInstance().getServiceEventHandler((V8JsRuntime)localObject);
    localObject = null;
    if (localIServiceEventHandler != null) {
      localObject = localIServiceEventHandler.onServiceNativeRequest(paramString1, paramString2, paramInt1);
    }
    if (localObject != null)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(" handled by ");
      paramString2.append(localIServiceEventHandler);
      Logger.i("API-Java", paramString2.toString());
      return localObject;
    }
    localObject = getJsEngine(paramString1);
    if (localObject != null) {
      return ((IJsEngine)localObject).onScriptCall(paramString1, paramString2, paramInt1, paramInt2);
    }
    paramString2 = new StringBuilder();
    paramString2.append("!!! API [");
    paramString2.append(paramString1);
    paramString2.append("] 未实现  - (invoke) !!!");
    Logger.e("API-Java", paramString2.toString());
    return "{}";
  }
  
  @CallByNative
  public static String onScriptPublish(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onScriptPublish event:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", params:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", contextIds:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(",contextType:");
    ((StringBuilder)localObject).append(paramInt);
    Logger.i("API-Java", ((StringBuilder)localObject).toString());
    localObject = paramString3;
    if ("[]".equals(paramString3)) {
      localObject = "[1]";
    }
    paramString3 = Engine.getInstance().getJsRuntime(paramInt);
    if (paramString3 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("onScriptPublish contextType is invalid ");
      paramString1.append(paramInt);
      paramString1.append(", is runtime released?");
      Logger.e("API-Java", paramString1.toString());
      return "{}";
    }
    paramString3 = ServiceEventHandlerProvider.getInstance().getServiceEventHandler(paramString3);
    if (paramString3 != null)
    {
      paramString3.onServiceEvent(paramString1, paramString2, jsStringToJavaIntArray((String)localObject));
      return "{}";
    }
    paramString2 = new StringBuilder();
    paramString2.append("!!! API [");
    paramString2.append(paramString1);
    paramString2.append("] 未实现 - (publish) !!!");
    Logger.e("API-Java", paramString2.toString());
    return "{}";
  }
  
  @CallByNative
  public static int onWorkerCreate(String paramString, int paramInt)
  {
    Object localObject = Engine.getInstance().getJsRuntime(paramInt);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("onScriptCall contextType is invalid ");
      paramString.append(paramInt);
      paramString.append(", is runtime released?");
      Logger.e("API-Java", paramString.toString());
      return -1;
    }
    localObject = WorkerHandlerProvider.getInstance().getWorkerHandler((V8JsRuntime)localObject);
    paramInt = 0;
    if (localObject != null) {
      paramInt = ((IWorkerEventHandler)localObject).create(paramString);
    }
    return paramInt;
  }
  
  @CallByNative
  public static void onWorkerPostMsgToAppService(String paramString, int paramInt)
  {
    Object localObject = Engine.getInstance().getJsRuntime(paramInt);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("onScriptCall contextType is invalid ");
      paramString.append(paramInt);
      paramString.append(", is runtime released?");
      Logger.e("API-Java", paramString.toString());
      return;
    }
    localObject = WorkerHandlerProvider.getInstance().getWorkerHandler((V8JsRuntime)localObject);
    if (localObject != null) {
      ((IWorkerEventHandler)localObject).postMsgToAppService(paramString);
    }
  }
  
  @CallByNative
  public static void onWorkerPostMsgToWorker(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = Engine.getInstance().getJsRuntime(paramInt2);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("onScriptCall contextType is invalid ");
      paramString.append(paramInt2);
      paramString.append(", is runtime released?");
      Logger.e("API-Java", paramString.toString());
      return;
    }
    localObject = WorkerHandlerProvider.getInstance().getWorkerHandler((V8JsRuntime)localObject);
    if (localObject != null) {
      ((IWorkerEventHandler)localObject).postMsgToWorker(paramInt1, paramString);
    }
  }
  
  @CallByNative
  public static String onWorkerTerminate(int paramInt1, int paramInt2)
  {
    Object localObject = Engine.getInstance().getJsRuntime(paramInt2);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScriptCall contextType is invalid ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", is runtime released?");
      Logger.e("API-Java", ((StringBuilder)localObject).toString());
      return "{}";
    }
    localObject = WorkerHandlerProvider.getInstance().getWorkerHandler((V8JsRuntime)localObject);
    if (localObject != null) {
      ((IWorkerEventHandler)localObject).terminate(paramInt1);
    }
    return "";
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return nativeGetNativeBuffer(paramInt);
  }
  
  public int newNativeBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return nativeNewNativeBuffer(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.V8JsBridge
 * JD-Core Version:    0.7.0.1
 */