package com.tencent.open.appcommon;

import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.open.appcommon.js.AsyncMethodMap;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Commons
  extends Common
{
  public static String a(WebView paramWebView, HashMap<String, JsBridge.JsHandler> paramHashMap, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    for (;;)
    {
      int i;
      int j;
      try
      {
        localJSONObject.put("r", "-1");
        localJSONObject.put("data", localJSONArray1);
        JSONArray localJSONArray2 = new JSONArray(URLDecoder.decode(paramString, "UTF-8"));
        i = 0;
        if (i < localJSONArray2.length())
        {
          paramWebView = localJSONArray2.optJSONObject(i);
          if (paramWebView == null) {
            break label778;
          }
          Object localObject = paramWebView.optString("ns");
          String str1 = paramWebView.optString("method");
          String str2 = paramWebView.optString("guid");
          paramWebView = paramWebView.optString("args");
          paramString = new StringBuilder();
          paramString.append("nameSpace:");
          paramString.append((String)localObject);
          paramString.append(",methodName=");
          paramString.append(str1);
          paramString.append(",paramsStr=");
          paramString.append(paramWebView);
          LogUtility.c("Common", paramString.toString());
          ArrayList localArrayList = new ArrayList();
          try
          {
            paramWebView = new JSONArray(paramWebView);
            j = 0;
            if (j < paramWebView.length())
            {
              localArrayList.add(paramWebView.getString(j));
              j += 1;
              continue;
            }
            paramWebView = (Class)AsyncMethodMap.b.get(localObject);
            if (!AsyncMethodMap.a.contains(str1)) {
              break label781;
            }
            localArrayList.add(str2);
          }
          catch (Exception paramWebView)
          {
            int k;
            paramString = new StringBuilder();
            paramString.append("callBatch args error : ");
            paramString.append(paramWebView.toString());
            LogUtility.e("Common", paramString.toString());
            break label802;
          }
          paramWebView = paramWebView.getMethods();
          k = paramWebView.length;
          j = 0;
          label268:
          if (j >= k) {
            break label797;
          }
          paramString = paramWebView[j];
          if ((!paramString.getName().equals(str1)) || (paramString.getParameterTypes().length != localArrayList.size())) {
            break label788;
          }
          paramWebView = paramString;
          label312:
          if (paramWebView == null) {
            break label778;
          }
          paramString = paramHashMap.get(localObject);
          try
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("callBatch <call> class : ");
            ((StringBuilder)localObject).append(paramString.getClass().getName());
            ((StringBuilder)localObject).append(" , method : ");
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append("\n , args : ");
            ((StringBuilder)localObject).append(localArrayList.toString());
            LogUtility.c("Common", ((StringBuilder)localObject).toString());
            if (localArrayList.size() == 0) {
              paramString = paramWebView.invoke(paramString, new Object[0]);
            } else {
              paramString = paramWebView.invoke(paramString, localArrayList.toArray());
            }
            paramWebView = paramWebView.getReturnType();
            if ((paramWebView == Void.TYPE) || (paramWebView == Void.class) || (paramString == null)) {
              break label802;
            }
            paramWebView = "";
            if ((paramString instanceof String))
            {
              ((String)paramString).replace("\\", "\\\\").replace("'", "\\'");
              paramWebView = (String)paramString;
            }
            else if ((!(paramString instanceof Number)) && (!(paramString instanceof Long)) && (!(paramString instanceof Integer)) && (!(paramString instanceof Double)) && (!(paramString instanceof Float)))
            {
              if ((paramString instanceof Boolean)) {
                paramWebView = paramString.toString();
              }
            }
            else
            {
              paramWebView = paramString.toString();
            }
            paramString = new JSONObject();
            localObject = new JSONArray();
            paramString.put("guid", str2);
            paramString.put("r", 0);
            paramString.put("data", paramWebView);
            paramWebView = new StringBuilder();
            paramWebView.append("interface.");
            paramWebView.append(str1);
            ((JSONArray)localObject).put(paramWebView.toString());
            ((JSONArray)localObject).put(paramString);
            localJSONArray1.put(localObject);
          }
          catch (Exception paramWebView)
          {
            LogUtility.c("Common", "callBatch error", paramWebView);
          }
        }
        localJSONObject.put("r", 0);
        localJSONObject.put("data", localJSONArray1);
        paramWebView = new StringBuilder();
        paramWebView.append("Response<callBatch> syncCallBatch result : ");
        paramWebView.append(localJSONObject);
        LogUtility.c("Common", paramWebView.toString());
      }
      catch (JSONException paramWebView) {}catch (UnsupportedEncodingException paramWebView)
      {
        break label764;
      }
      LogUtility.b("Common", "callBatch request params format err", paramWebView);
      break label772;
      label764:
      LogUtility.b("Common", "callBatch decode params format err", paramWebView);
      label772:
      return localJSONObject.toString();
      for (;;)
      {
        label778:
        break label802;
        label781:
        if (paramWebView == null) {}
        break;
        label788:
        j += 1;
        break label268;
        label797:
        paramWebView = null;
        break label312;
      }
      label802:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.Commons
 * JD-Core Version:    0.7.0.1
 */