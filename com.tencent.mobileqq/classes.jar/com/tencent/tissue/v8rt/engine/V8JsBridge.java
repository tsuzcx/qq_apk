package com.tencent.tissue.v8rt.engine;

import android.text.TextUtils;
import com.tencent.tissue.v8rt.anno.CallByNative;
import java.util.Iterator;

public class V8JsBridge
  implements INativeBuffer
{
  public static final String TAG = "API-Java";
  
  private static IJsEngine getJsEngine(String paramString)
  {
    Object localObject = null;
    Iterator localIterator = JsEngineProvider.getInstance().iterator();
    if (localIterator.hasNext())
    {
      IJsEngine localIJsEngine = (IJsEngine)localIterator.next();
      if (!localIJsEngine.canHandleEvent(paramString)) {
        break label78;
      }
      localObject = localIJsEngine;
    }
    label78:
    for (;;)
    {
      break;
      if (localObject != null) {
        Logger.i("API-Java", paramString + " handled by " + localObject);
      }
      return localObject;
    }
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
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
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
        label61:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label61;
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
    Logger.i("API-Java", "onScriptCall event:" + paramString1 + ", params:" + paramString2 + ", callbackId:" + paramInt1 + ",contextType:" + paramInt2);
    Object localObject = Engine.getInstance().getJsRuntime(paramInt2);
    if (localObject == null)
    {
      Logger.e("API-Java", "onScriptCall contextType is invalid " + paramInt2 + ", is runtime released?");
      return "{}";
    }
    IServiceEventHandler localIServiceEventHandler = ServiceEventHandlerProvider.getInstance().getServiceEventHandler((V8JsRuntime)localObject);
    localObject = null;
    if (localIServiceEventHandler != null) {
      localObject = localIServiceEventHandler.onServiceNativeRequest(paramString1, paramString2, paramInt1);
    }
    if (localObject != null)
    {
      Logger.i("API-Java", paramString1 + " handled by " + localIServiceEventHandler);
      return localObject;
    }
    localObject = getJsEngine(paramString1);
    if (localObject != null) {
      return ((IJsEngine)localObject).onScriptCall(paramString1, paramString2, paramInt1, paramInt2);
    }
    Logger.e("API-Java", "!!! API [" + paramString1 + "] 未实现  - (invoke) !!!");
    return "{}";
  }
  
  @CallByNative
  public static String onScriptPublish(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Logger.i("API-Java", "onScriptPublish event:" + paramString1 + ", params:" + paramString2 + ", contextIds:" + paramString3 + ",contextType:" + paramInt);
    String str = paramString3;
    if ("[]".equals(paramString3)) {
      str = "[1]";
    }
    paramString3 = Engine.getInstance().getJsRuntime(paramInt);
    if (paramString3 == null)
    {
      Logger.e("API-Java", "onScriptPublish contextType is invalid " + paramInt + ", is runtime released?");
      return "{}";
    }
    paramString3 = ServiceEventHandlerProvider.getInstance().getServiceEventHandler(paramString3);
    if (paramString3 != null) {
      paramString3.onServiceEvent(paramString1, paramString2, jsStringToJavaIntArray(str));
    }
    for (;;)
    {
      return "{}";
      Logger.e("API-Java", "!!! API [" + paramString1 + "] 未实现 - (publish) !!!");
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.V8JsBridge
 * JD-Core Version:    0.7.0.1
 */