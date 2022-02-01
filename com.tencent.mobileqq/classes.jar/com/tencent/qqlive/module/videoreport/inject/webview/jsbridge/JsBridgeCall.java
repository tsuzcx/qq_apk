package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class JsBridgeCall
{
  public static final int STATE_CODE_INTERNAL_ERROR = 500;
  private static final int STATE_CODE_OK = 200;
  private static final String TAG = "DT_JsBridge";
  
  static String call(Object paramObject, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("JsBridgeCheck jscall, jsonStr:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(paramString2);
    Log.w("DT_JsBridge", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        localObject = new JSONObject(paramString1);
        paramString1 = ((JSONObject)localObject).getString("method");
        paramString2 = ((JSONObject)localObject).getJSONArray("types");
        localObject = ((JSONObject)localObject).getJSONArray("args");
        int j = paramString2.length();
        Class[] arrayOfClass = new Class[j];
        Object[] arrayOfObject = new Object[j];
        int i = 0;
        while (i < j)
        {
          parseArgsAndValue((JSONArray)localObject, arrayOfClass, arrayOfObject, paramString2.optString(i), i);
          i += 1;
        }
        paramObject = getResponse(200, paramObject.getClass().getMethod(paramString1, arrayOfClass).invoke(paramObject, arrayOfObject));
        return paramObject;
      }
      catch (Exception paramObject)
      {
        if (paramObject.getCause() != null)
        {
          paramString1 = new StringBuilder();
          paramString1.append("method execute error:");
          paramString1.append(paramObject.getCause().getMessage());
          paramObject = paramString1.toString();
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append("method execute error:");
          paramString1.append(paramObject.getMessage());
          paramObject = paramString1.toString();
        }
        return getResponse(500, paramObject);
      }
    }
    return getResponse(500, "call data empty");
  }
  
  public static String getResponse(int paramInt, Object paramObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", Integer.valueOf(paramInt));
    localHashMap.put("result", paramObject);
    return new JSONObject(localHashMap).toString();
  }
  
  private static void parseArgsAndValue(JSONArray paramJSONArray, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject, String paramString, int paramInt)
  {
    boolean bool = "string".equals(paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    if (bool)
    {
      paramArrayOfClass[paramInt] = String.class;
      if (paramJSONArray.isNull(paramInt)) {
        paramJSONArray = localObject1;
      } else {
        paramJSONArray = paramJSONArray.getString(paramInt);
      }
      paramArrayOfObject[paramInt] = paramJSONArray;
      return;
    }
    if ("number".equals(paramString))
    {
      paramArrayOfClass[paramInt] = Integer.TYPE;
      paramArrayOfObject[paramInt] = Integer.valueOf(paramJSONArray.getInt(paramInt));
      return;
    }
    if ("boolean".equals(paramString))
    {
      paramArrayOfClass[paramInt] = Boolean.TYPE;
      paramArrayOfObject[paramInt] = Boolean.valueOf(paramJSONArray.getBoolean(paramInt));
      return;
    }
    if ("object".equals(paramString))
    {
      if (paramJSONArray.isNull(paramInt)) {
        paramJSONArray = localObject2;
      } else {
        paramJSONArray = paramJSONArray.getString(paramInt);
      }
      paramArrayOfObject[paramInt] = paramJSONArray;
      if (paramArrayOfObject[paramInt] != null) {
        paramArrayOfObject[paramInt] = new JSONObject((String)paramArrayOfObject[paramInt]);
      }
      paramArrayOfClass[paramInt] = JSONObject.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeCall
 * JD-Core Version:    0.7.0.1
 */