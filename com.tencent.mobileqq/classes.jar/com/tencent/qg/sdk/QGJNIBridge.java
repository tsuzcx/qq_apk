package com.tencent.qg.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qg.sdk.invoke.BaseJsModule;
import com.tencent.qg.sdk.invoke.InvokeCallback;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qg.sdk.log.GLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class QGJNIBridge
{
  public static String TAG = "QGJNIBridge";
  private String lastEventName = "";
  private Context mContext;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  ModuleEngine mModuleEngine;
  private Set<String> mRegistEventNames = Collections.synchronizedSet(new HashSet());
  
  public QGJNIBridge(Context paramContext, ModuleEngine paramModuleEngine)
  {
    this.mContext = paramContext;
    this.mModuleEngine = paramModuleEngine;
  }
  
  private boolean checkHasRegisterEvent(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      GLog.e(TAG, "dispatchJSEvent but eventname is empty");
      return false;
    }
    if (!hasRegistered(paramString))
    {
      if (!this.lastEventName.equals(paramString))
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("not regist event:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", so ingore this dispatch");
        GLog.i(str, localStringBuilder.toString());
      }
      this.lastEventName = paramString;
      return false;
    }
    return true;
  }
  
  public void clearRegisteredEvents()
  {
    this.mRegistEventNames.clear();
    GLog.i(TAG, "clearRegisteredEvents:");
  }
  
  public void destroy()
  {
    HandlerThread localHandlerThread = this.mHandlerThread;
    if (localHandlerThread != null)
    {
      localHandlerThread.quit();
      this.mHandlerThread = null;
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString)
  {
    if (checkHasRegisterEvent(paramString))
    {
      double d = System.currentTimeMillis();
      nativeDispatchJSEvent(paramString, "".getBytes(), d);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("nativeDispatchJSEvent, event:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",data: empty");
      GLog.i(str, localStringBuilder.toString());
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString1, String paramString2)
  {
    if (checkHasRegisterEvent(paramString1))
    {
      double d = System.currentTimeMillis();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("value", paramString2);
      }
      catch (JSONException paramString2)
      {
        paramString2.printStackTrace();
      }
      nativeDispatchJSEvent(paramString1, localJSONObject.toString().getBytes(), d);
      paramString2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("nativeDispatchJSEvent, event:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", data:");
      localStringBuilder.append(localJSONObject.toString());
      GLog.i(paramString2, localStringBuilder.toString());
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString, @NonNull JSONObject paramJSONObject)
  {
    if (checkHasRegisterEvent(paramString))
    {
      double d = System.currentTimeMillis();
      nativeDispatchJSEvent(paramString, paramJSONObject.toString().getBytes(), d);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("nativeDispatchJSEvent, event:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", data:");
      localStringBuilder.append(paramJSONObject.toString());
      GLog.i(str, localStringBuilder.toString());
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString, @NonNull float[] paramArrayOfFloat)
  {
    if (checkHasRegisterEvent(paramString))
    {
      nativeDispatchJSEventWithFloatArray(paramString, paramArrayOfFloat, System.currentTimeMillis());
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("nativeDispatchJSEvent, event:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", data:");
      localStringBuilder.append(Arrays.toString(paramArrayOfFloat));
      GLog.i(str, localStringBuilder.toString());
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString, @NonNull int[] paramArrayOfInt)
  {
    if (checkHasRegisterEvent(paramString))
    {
      nativeDispatchJSEventWithIntArray(paramString, paramArrayOfInt, System.currentTimeMillis());
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("nativeDispatchJSEvent, event:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", data:");
      localStringBuilder.append(Arrays.toString(paramArrayOfInt));
      GLog.i(str, localStringBuilder.toString());
    }
  }
  
  public boolean handleJsRequest(String paramString)
  {
    Object localObject1 = TAG;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("handleJsRequest, dataString:");
    ((StringBuilder)localObject3).append(paramString);
    GLog.d((String)localObject1, ((StringBuilder)localObject3).toString());
    try
    {
      localObject5 = new JSONObject(paramString);
      localObject4 = ((JSONObject)localObject5).optString("module");
      localObject3 = ((JSONObject)localObject5).optString("method");
      localObject1 = ((JSONObject)localObject5).optString("params");
      localObject5 = ((JSONObject)localObject5).optString("callbackId");
      localObject4 = this.mModuleEngine.getJsModule((String)localObject4);
      localObject5 = new InvokeCallback(this, (String)localObject5);
      if (localObject4 != null)
      {
        if (this.mHandlerThread == null)
        {
          this.mHandlerThread = new HandlerThread("QGHandleJSRequest");
          this.mHandlerThread.start();
          this.mHandler = new Handler(this.mHandlerThread.getLooper());
        }
        if (localObject1 == null) {
          break label256;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject5;
      label166:
      localObject3 = TAG;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("handleJsRequest, JSONException. json = ");
      ((StringBuilder)localObject4).append(paramString);
      GLog.e((String)localObject3, ((StringBuilder)localObject4).toString(), localJSONException);
      return false;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
    }
    catch (Exception localException)
    {
      break label166;
    }
    ((InvokeCallback)localObject5).exec(4, "params type error (ps. need json)");
    for (;;)
    {
      this.mHandler.post(new QGJNIBridge.1(this, (BaseJsModule)localObject4, (String)localObject3, (JSONObject)localObject1, (InvokeCallback)localObject5));
      return true;
      ((InvokeCallback)localObject5).exec(2);
      return false;
      label256:
      Object localObject2 = null;
    }
  }
  
  public boolean hasRegistered(String paramString)
  {
    return this.mRegistEventNames.contains(paramString);
  }
  
  public native void nativeAttach();
  
  public native void nativeDispatchJSEvent(String paramString, byte[] paramArrayOfByte, double paramDouble);
  
  public native void nativeDispatchJSEventWithFloatArray(String paramString, FloatBuffer paramFloatBuffer, double paramDouble);
  
  public void nativeDispatchJSEventWithFloatArray(String paramString, float[] paramArrayOfFloat, double paramDouble)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length == 0) {
        return;
      }
      Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).put(paramArrayOfFloat);
      ((FloatBuffer)localObject).flip();
      nativeDispatchJSEventWithFloatArray(paramString, (FloatBuffer)localObject, paramDouble);
    }
  }
  
  public native void nativeDispatchJSEventWithIntArray(String paramString, IntBuffer paramIntBuffer, double paramDouble);
  
  public void nativeDispatchJSEventWithIntArray(String paramString, int[] paramArrayOfInt, double paramDouble)
  {
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length == 0) {
        return;
      }
      Object localObject = ByteBuffer.allocateDirect(paramArrayOfInt.length * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asIntBuffer();
      ((IntBuffer)localObject).put(paramArrayOfInt);
      ((IntBuffer)localObject).flip();
      nativeDispatchJSEventWithIntArray(paramString, (IntBuffer)localObject, paramDouble);
    }
  }
  
  public native void nativeInvokeCallback(String paramString, byte[] paramArrayOfByte, double paramDouble);
  
  public void onRegistered(String paramString)
  {
    this.mRegistEventNames.add(paramString);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRegistered:");
    localStringBuilder.append(paramString);
    GLog.i(str, localStringBuilder.toString());
  }
  
  public void onUnRegistered(String paramString)
  {
    this.mRegistEventNames.remove(paramString);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUnRegistered:");
    localStringBuilder.append(paramString);
    GLog.i(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJNIBridge
 * JD-Core Version:    0.7.0.1
 */