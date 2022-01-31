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
      if (!this.lastEventName.equals(paramString)) {
        GLog.i(TAG, "not regist event:" + paramString + ", so ingore this dispatch");
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
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString)
  {
    if (checkHasRegisterEvent(paramString))
    {
      double d = System.currentTimeMillis();
      nativeDispatchJSEvent(paramString, "".getBytes(), d);
      GLog.i(TAG, "nativeDispatchJSEvent, event:" + paramString + ",data: empty");
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString1, String paramString2)
  {
    double d;
    JSONObject localJSONObject;
    if (checkHasRegisterEvent(paramString1))
    {
      d = System.currentTimeMillis();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("value", paramString2);
      nativeDispatchJSEvent(paramString1, localJSONObject.toString().getBytes(), d);
      GLog.i(TAG, "nativeDispatchJSEvent, event:" + paramString1 + ", data:" + localJSONObject.toString());
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString, @NonNull JSONObject paramJSONObject)
  {
    if (checkHasRegisterEvent(paramString))
    {
      double d = System.currentTimeMillis();
      nativeDispatchJSEvent(paramString, paramJSONObject.toString().getBytes(), d);
      GLog.i(TAG, "nativeDispatchJSEvent, event:" + paramString + ", data:" + paramJSONObject.toString());
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString, @NonNull float[] paramArrayOfFloat)
  {
    if (checkHasRegisterEvent(paramString))
    {
      nativeDispatchJSEventWithFloatArray(paramString, paramArrayOfFloat, System.currentTimeMillis());
      GLog.i(TAG, "nativeDispatchJSEvent, event:" + paramString + ", data:" + Arrays.toString(paramArrayOfFloat));
    }
  }
  
  public void dispatchJSEvent(@NonNull String paramString, @NonNull int[] paramArrayOfInt)
  {
    if (checkHasRegisterEvent(paramString))
    {
      nativeDispatchJSEventWithIntArray(paramString, paramArrayOfInt, System.currentTimeMillis());
      GLog.i(TAG, "nativeDispatchJSEvent, event:" + paramString + ", data:" + Arrays.toString(paramArrayOfInt));
    }
  }
  
  public boolean handleJsRequest(String paramString)
  {
    GLog.d(TAG, "handleJsRequest, dataString:" + paramString);
    for (;;)
    {
      try
      {
        Object localObject4 = new JSONObject(paramString);
        Object localObject3 = ((JSONObject)localObject4).optString("module");
        String str = ((JSONObject)localObject4).optString("method");
        Object localObject1 = ((JSONObject)localObject4).optString("params");
        localObject4 = ((JSONObject)localObject4).optString("callbackId");
        localObject3 = this.mModuleEngine.getJsModule((String)localObject3);
        localObject4 = new InvokeCallback(this, (String)localObject4);
        if (localObject3 != null)
        {
          if (this.mHandlerThread == null)
          {
            this.mHandlerThread = new HandlerThread("QGHandleJSRequest");
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
          }
          if (localObject1 != null) {
            try
            {
              localObject1 = new JSONObject((String)localObject1);
              this.mHandler.post(new QGJNIBridge.1(this, (BaseJsModule)localObject3, str, (JSONObject)localObject1, (InvokeCallback)localObject4));
              return true;
            }
            catch (Exception localException)
            {
              ((InvokeCallback)localObject4).exec(4, "params type error (ps. need json)");
            }
          }
        }
        else
        {
          ((InvokeCallback)localObject4).exec(2);
          return false;
        }
      }
      catch (JSONException localJSONException)
      {
        GLog.e(TAG, "handleJsRequest, JSONException. json = " + paramString, localJSONException);
        return false;
      }
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
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0)) {
      return;
    }
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).flip();
    nativeDispatchJSEventWithFloatArray(paramString, (FloatBuffer)localObject, paramDouble);
  }
  
  public native void nativeDispatchJSEventWithIntArray(String paramString, IntBuffer paramIntBuffer, double paramDouble);
  
  public void nativeDispatchJSEventWithIntArray(String paramString, int[] paramArrayOfInt, double paramDouble)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return;
    }
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfInt.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asIntBuffer();
    ((IntBuffer)localObject).put(paramArrayOfInt);
    ((IntBuffer)localObject).flip();
    nativeDispatchJSEventWithIntArray(paramString, (IntBuffer)localObject, paramDouble);
  }
  
  public native void nativeInvokeCallback(String paramString, byte[] paramArrayOfByte, double paramDouble);
  
  public void onRegistered(String paramString)
  {
    this.mRegistEventNames.add(paramString);
    GLog.i(TAG, "onRegistered:" + paramString);
  }
  
  public void onUnRegistered(String paramString)
  {
    this.mRegistEventNames.remove(paramString);
    GLog.i(TAG, "onUnRegistered:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJNIBridge
 * JD-Core Version:    0.7.0.1
 */