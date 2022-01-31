package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.qphone.base.util.QLog;
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
  
  public static boolean hasNativeBuffer(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    return paramJSONObject.has("__nativeBuffers__");
  }
  
  public static void packNativeBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString, JSONObject paramJSONObject, ITNativeBufferPool paramITNativeBufferPool)
  {
    if ((paramJSONObject == null) || (paramString == null)) {
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        localJSONObject = new JSONObject();
        localJSONObject.put("key", paramString);
        if (paramInt3 == TYPE_BUFFER_BASE64)
        {
          localJSONObject.put("base64", Base64.encodeToString(paramArrayOfByte, paramInt1, paramInt2, 2));
          localJSONArray.put(localJSONObject);
          paramJSONObject.put("__nativeBuffers__", localJSONArray);
          return;
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        QLog.e("[minigame] ", 1, "packNativeBuffer err :", paramArrayOfByte);
        return;
      }
      if (paramInt3 == TYPE_BUFFER_NATIVE) {
        if (paramITNativeBufferPool != null) {
          localJSONObject.put("id", paramITNativeBufferPool.newNativeBuffer(paramArrayOfByte, paramInt1, paramInt2));
        } else {
          QLog.e("[minigame] ", 1, "packNativeBuffer for native on null bufferPool");
        }
      }
    }
  }
  
  public static void packNativeBuffer(byte[] paramArrayOfByte, int paramInt, String paramString, JSONObject paramJSONObject, ITNativeBufferPool paramITNativeBufferPool)
  {
    packNativeBuffer(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt, paramString, paramJSONObject, paramITNativeBufferPool);
  }
  
  public static NativeBuffer unpackNativeBuffer(JSONObject paramJSONObject, String paramString, ITNativeBufferPool paramITNativeBufferPool)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject != null)
    {
      if (paramString != null) {
        break label22;
      }
      localObject1 = localObject2;
    }
    label22:
    int i;
    do
    {
      do
      {
        String str2;
        String str1;
        do
        {
          do
          {
            do
            {
              do
              {
                return localObject1;
                paramJSONObject = paramJSONObject.optJSONArray("__nativeBuffers__");
                localObject1 = localObject2;
              } while (paramJSONObject == null);
              localObject1 = localObject2;
            } while (paramJSONObject.length() == 0);
            paramJSONObject = paramJSONObject.optJSONObject(0);
            localObject1 = localObject2;
          } while (paramJSONObject == null);
          str2 = paramJSONObject.optString("key");
          str1 = paramJSONObject.optString("base64");
          i = paramJSONObject.optInt("id", -1);
          localObject1 = localObject2;
        } while (!paramString.equals(str2));
        paramJSONObject = new NativeBuffer();
        if (!TextUtils.isEmpty(str1))
        {
          paramJSONObject.buf = Base64.decode(str1, 2);
          paramJSONObject.type = TYPE_BUFFER_BASE64;
          return paramJSONObject;
        }
        localObject1 = paramJSONObject;
      } while (i == -1);
      localObject1 = paramJSONObject;
    } while (paramITNativeBufferPool == null);
    paramJSONObject.buf = paramITNativeBufferPool.getNativeBuffer(i);
    paramJSONObject.type = TYPE_BUFFER_NATIVE;
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.NativeBuffer
 * JD-Core Version:    0.7.0.1
 */