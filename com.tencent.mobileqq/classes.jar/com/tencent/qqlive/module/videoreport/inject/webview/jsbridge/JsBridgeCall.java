package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class JsBridgeCall
{
  private static final String TAG = "DT_JsBridge";
  
  static String call(Object paramObject, String paramString1, String paramString2)
  {
    Log.w("DT_JsBridge", "JsBridgeCheck jscall, jsonStr:" + paramString1 + " url:" + paramString2);
    Class[] arrayOfClass;
    Object[] arrayOfObject;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      JSONArray localJSONArray2;
      try
      {
        paramString1 = new JSONObject(paramString1);
        paramString2 = paramString1.getString("method");
        JSONArray localJSONArray1 = paramString1.getJSONArray("types");
        localJSONArray2 = paramString1.getJSONArray("args");
        int j = localJSONArray1.length();
        arrayOfClass = new Class[localJSONArray1.length()];
        arrayOfObject = new Object[j];
        i = 0;
        if (i < j)
        {
          paramString1 = localJSONArray1.optString(i);
          if ("string".equals(paramString1))
          {
            arrayOfClass[i] = String.class;
            if (localJSONArray2.isNull(i))
            {
              paramString1 = null;
              break label379;
            }
            paramString1 = localJSONArray2.getString(i);
            break label379;
          }
          if ("number".equals(paramString1))
          {
            arrayOfClass[i] = Integer.TYPE;
            arrayOfObject[i] = Integer.valueOf(localJSONArray2.getInt(i));
          }
        }
      }
      catch (Exception paramObject)
      {
        if (paramObject.getCause() == null) {}
      }
      for (paramObject = "method execute error:" + paramObject.getCause().getMessage();; paramObject = "method execute error:" + paramObject.getMessage())
      {
        return getResponse(500, paramObject);
        if ("boolean".equals(paramString1))
        {
          arrayOfClass[i] = Boolean.TYPE;
          arrayOfObject[i] = Boolean.valueOf(localJSONArray2.getBoolean(i));
          break;
        }
        if (!"object".equals(paramString1)) {
          break;
        }
        if (localJSONArray2.isNull(i)) {}
        for (paramString1 = null;; paramString1 = localJSONArray2.getString(i))
        {
          arrayOfObject[i] = paramString1;
          if (arrayOfObject[i] == null) {
            break;
          }
          arrayOfObject[i] = new JSONObject((String)arrayOfObject[i]);
          break;
        }
        paramObject = getResponse(200, paramObject.getClass().getMethod(paramString2, arrayOfClass).invoke(paramObject, arrayOfObject));
        return paramObject;
      }
    }
    return getResponse(500, "call data empty");
    label379:
    arrayOfObject[i] = paramString1;
    for (;;)
    {
      i += 1;
      break;
      arrayOfClass[i] = JSONObject.class;
    }
  }
  
  private static String getResponse(int paramInt, Object paramObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", Integer.valueOf(paramInt));
    localHashMap.put("result", paramObject);
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeCall
 * JD-Core Version:    0.7.0.1
 */