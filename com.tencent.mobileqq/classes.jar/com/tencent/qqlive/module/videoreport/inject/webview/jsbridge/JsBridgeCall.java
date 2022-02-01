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
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      Class[] arrayOfClass;
      Object[] arrayOfObject;
      int i;
      try
      {
        paramString1 = new JSONObject(paramString1);
        localObject = paramString1.getString("method");
        JSONArray localJSONArray1 = paramString1.getJSONArray("types");
        JSONArray localJSONArray2 = paramString1.getJSONArray("args");
        int j = localJSONArray1.length();
        arrayOfClass = new Class[j];
        arrayOfObject = new Object[j];
        i = 0;
        if (i < j)
        {
          String str = localJSONArray1.optString(i);
          boolean bool = "string".equals(str);
          paramString2 = null;
          paramString1 = null;
          if (bool)
          {
            arrayOfClass[i] = String.class;
            if (localJSONArray2.isNull(i))
            {
              paramString1 = paramString2;
              break label417;
            }
            paramString1 = localJSONArray2.getString(i);
            break label417;
          }
          if ("number".equals(str))
          {
            arrayOfClass[i] = Integer.TYPE;
            arrayOfObject[i] = Integer.valueOf(localJSONArray2.getInt(i));
            break label431;
          }
          if ("boolean".equals(str))
          {
            arrayOfClass[i] = Boolean.TYPE;
            arrayOfObject[i] = Boolean.valueOf(localJSONArray2.getBoolean(i));
            break label431;
          }
          if (!"object".equals(str)) {
            break label431;
          }
          if (!localJSONArray2.isNull(i)) {
            paramString1 = localJSONArray2.getString(i);
          }
          arrayOfObject[i] = paramString1;
          if (arrayOfObject[i] == null) {
            break label425;
          }
          arrayOfObject[i] = new JSONObject((String)arrayOfObject[i]);
          break label425;
        }
        paramObject = getResponse(200, paramObject.getClass().getMethod((String)localObject, arrayOfClass).invoke(paramObject, arrayOfObject));
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
      return getResponse(500, "call data empty");
      label417:
      arrayOfObject[i] = paramString1;
      break label431;
      label425:
      arrayOfClass[i] = JSONObject.class;
      label431:
      i += 1;
    }
  }
  
  public static String getResponse(int paramInt, Object paramObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", Integer.valueOf(paramInt));
    localHashMap.put("result", paramObject);
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeCall
 * JD-Core Version:    0.7.0.1
 */