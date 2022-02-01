package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeBuffer
{
  private static final String JSON_TAG = "__nativeBuffers__";
  private static String TAG = "NativeBuffer";
  public static int TYPE_BUFFER_BASE64 = 2;
  public static int TYPE_BUFFER_NATIVE = 1;
  public byte[] buf;
  public int type;
  
  public static byte[] getBytesFromNativeBuffers(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      paramJSONArray = paramJSONArray.optJSONObject(0);
      if (paramJSONArray != null)
      {
        paramJSONArray = paramJSONArray.optString("base64");
        if (!TextUtils.isEmpty(paramJSONArray)) {
          return Base64.decode(paramJSONArray, 0);
        }
      }
    }
    return null;
  }
  
  public static boolean hasNativeBuffer(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    return paramJSONObject.has("__nativeBuffers__");
  }
  
  public static void packNativeBuffer(IJsService paramIJsService, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramString == null) {
        return;
      }
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("key", paramString);
        if (paramInt3 == TYPE_BUFFER_BASE64) {
          localJSONObject.put("base64", Base64.encodeToString(paramArrayOfByte, paramInt1, paramInt2, 2));
        } else if ((paramInt3 == TYPE_BUFFER_NATIVE) && (paramIJsService != null)) {
          localJSONObject.put("id", paramIJsService.createNativeBuffer(paramArrayOfByte, paramInt1, paramInt2));
        }
        localJSONArray.put(localJSONObject);
        paramJSONObject.put("__nativeBuffers__", localJSONArray);
        return;
      }
      catch (JSONException paramIJsService)
      {
        QMLog.e("[minigame]", "packNativeBuffer err :", paramIJsService);
      }
    }
  }
  
  public static void packNativeBuffer(IJsService paramIJsService, byte[] paramArrayOfByte, int paramInt, String paramString, JSONObject paramJSONObject)
  {
    packNativeBuffer(paramIJsService, paramArrayOfByte, 0, paramArrayOfByte.length, paramInt, paramString, paramJSONObject);
  }
  
  public static NativeBuffer unpackNativeBuffer(IJsService paramIJsService, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      if (paramString == null) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONArray("__nativeBuffers__");
      if (paramJSONObject != null)
      {
        if (paramJSONObject.length() == 0) {
          return null;
        }
        JSONObject localJSONObject = paramJSONObject.optJSONObject(0);
        if (localJSONObject == null) {
          return null;
        }
        String str = localJSONObject.optString("key");
        paramJSONObject = localJSONObject.optString("base64");
        int i = localJSONObject.optInt("id", -1);
        if (paramString.equals(str))
        {
          paramString = new NativeBuffer();
          if (!TextUtils.isEmpty(paramJSONObject))
          {
            paramString.buf = Base64.decode(paramJSONObject, 2);
            paramString.type = TYPE_BUFFER_BASE64;
            return paramString;
          }
          if ((i != -1) && (paramIJsService != null))
          {
            paramString.buf = paramIJsService.getNativeBuffer(i);
            paramString.type = TYPE_BUFFER_NATIVE;
          }
          return paramString;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.NativeBuffer
 * JD-Core Version:    0.7.0.1
 */