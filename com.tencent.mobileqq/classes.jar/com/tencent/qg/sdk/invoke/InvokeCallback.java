package com.tencent.qg.sdk.invoke;

import android.util.Log;
import com.tencent.qg.sdk.QGJNIBridge;
import com.tencent.qg.sdk.log.GLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InvokeCallback
{
  public static final int RETCODE_FAIL = 1;
  public static final int RETCODE_NO_METHOD = 3;
  public static final int RETCODE_NO_MODULE = 2;
  public static final int RETCODE_PARAM_ERROR = 4;
  public static final int RETCODE_SUCCESS = 0;
  public static String TAG = QGJNIBridge.TAG + ".InvokeCallback";
  private String callbackId;
  private QGJNIBridge mJniBridge;
  
  public InvokeCallback(QGJNIBridge paramQGJNIBridge, String paramString)
  {
    this.callbackId = paramString;
    this.mJniBridge = paramQGJNIBridge;
  }
  
  private boolean exec_(int paramInt, String paramString, Object paramObject)
  {
    boolean bool = false;
    if (this.mJniBridge != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramInt);
      localJSONObject.put("msg", paramString);
      if (paramObject != null) {
        localJSONObject.put("data", paramObject);
      }
      this.mJniBridge.nativeInvokeCallback(this.callbackId, localJSONObject.toString().getBytes(), System.currentTimeMillis());
      GLog.i(TAG, "[exec]callbackID:" + this.callbackId + ", ret:" + localJSONObject.toString());
      bool = true;
      return bool;
    }
    catch (JSONException paramString)
    {
      Log.e(TAG, paramString.getMessage());
    }
    return false;
  }
  
  private String getMsg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknow retcode";
    case 0: 
      return "success";
    case 1: 
      return "fail";
    case 2: 
      return "no module to handle it!";
    }
    return "no method to handle it!";
  }
  
  public boolean exec(int paramInt)
  {
    return exec_(paramInt, getMsg(paramInt), null);
  }
  
  public boolean exec(int paramInt, String paramString)
  {
    return exec_(paramInt, paramString, null);
  }
  
  public boolean exec(int paramInt, String paramString, JSONArray paramJSONArray)
  {
    return exec_(paramInt, paramString, paramJSONArray);
  }
  
  public boolean exec(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    return exec_(paramInt, paramString, paramJSONObject);
  }
  
  public boolean exec(int paramInt, JSONArray paramJSONArray)
  {
    return exec_(paramInt, getMsg(paramInt), paramJSONArray);
  }
  
  public boolean exec(int paramInt, JSONObject paramJSONObject)
  {
    return exec_(paramInt, getMsg(paramInt), paramJSONObject);
  }
  
  public boolean execSuccess(JSONArray paramJSONArray)
  {
    return exec_(0, getMsg(0), paramJSONArray);
  }
  
  public boolean execSuccess(JSONObject paramJSONObject)
  {
    return exec_(0, getMsg(0), paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.invoke.InvokeCallback
 * JD-Core Version:    0.7.0.1
 */