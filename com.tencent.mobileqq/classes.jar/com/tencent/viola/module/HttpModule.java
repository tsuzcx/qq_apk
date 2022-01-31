package com.tencent.viola.module;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpModule
  extends BaseModule
  implements Handler.Callback, Destroyable
{
  static final Pattern CHARSET_PATTERN = Pattern.compile("charset=([a-z0-9-]+)");
  public static final String HTPP_ERROR_TEXT = "errorText";
  public static final String HTTP_CODE = "code";
  public static final String HTTP_DATA = "data";
  public static final String HTTP_METHOD_GET = "GET";
  public static final String HTTP_METHOD_POST = "POST";
  public static final String HTTP_SUCCESS = "success";
  public static final String MODULE_NAME = "http";
  public static String TAG = "HttpModule";
  public final int MSG_CALLBACK = 1;
  public final String MSG_KEY_CALLBACK_ID = "callback";
  public final String MSG_KEY_INSTANCE_ID = "inctanceId";
  public final String MSG_KEY_REP = "resp";
  private Handler handler = new Handler(this);
  private IHttpAdapter mAdapter;
  
  public static void encodeDataFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = localIterator.next().toString();
          String str2 = paramJSONObject.getString(str1);
          if (!TextUtils.isEmpty(str2))
          {
            str2 = URLEncoder.encode(str2);
            if (!TextUtils.isEmpty(str2)) {
              paramJSONObject.put(str1, str2.replace("+", "%20"));
            }
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        ViolaLogUtils.e(TAG, "encodeDataFromJson Exception e:" + paramJSONObject.getMessage());
      }
    }
  }
  
  static String getHeader(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramString == null)) {
      return null;
    }
    if (paramMap.containsKey(paramString)) {
      return (String)paramMap.get(paramString);
    }
    return (String)paramMap.get(paramString.toLowerCase());
  }
  
  static String readAsString(byte[] paramArrayOfByte, String paramString)
  {
    if (paramString != null)
    {
      paramString = CHARSET_PATTERN.matcher(paramString.toLowerCase());
      if (!paramString.find()) {}
    }
    for (paramString = paramString.group(1);; paramString = "utf-8") {
      try
      {
        paramString = new String(paramArrayOfByte, paramString);
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        Log.e("", paramString.getMessage());
        return new String(paramArrayOfByte);
      }
    }
  }
  
  private void reuqestHttp(String paramString1, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    getViolaInstance();
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.url = paramString1;
    localHttpRequset.method = paramString3;
    if ((!paramString3.equals("GET")) || (paramJSONObject1 != null)) {}
    for (;;)
    {
      try
      {
        paramString3 = new JSONObject(paramJSONObject1.toString());
        encodeDataFromJson(paramString3);
        localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramString3, paramString1);
        localHttpRequset.timeoutMs = paramInt;
        paramString1 = new HashMap();
        if (paramJSONObject2 == null) {
          break label167;
        }
        paramString3 = paramJSONObject2.keys();
        if (!paramString3.hasNext()) {
          break;
        }
        String str = (String)paramString3.next();
        paramString1.put(str, paramJSONObject2.optString(str));
        continue;
      }
      catch (JSONException paramString3)
      {
        localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramJSONObject1, paramString1);
        continue;
      }
      localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramJSONObject1, paramString1);
    }
    localHttpRequset.paramMap = paramString1;
    label167:
    if (paramJSONObject1 != null) {
      if ((!paramString1.containsKey("Content-Type")) || (TextUtils.isEmpty((CharSequence)paramString1.get("Content-Type"))) || (!((String)paramString1.get("Content-Type")).contains("application/json"))) {
        break label283;
      }
    }
    label283:
    for (localHttpRequset.body = paramJSONObject1.toString();; localHttpRequset.body = ViolaUtils.splittBodyEncodeUrl(paramJSONObject1))
    {
      paramString1 = getViolaInstance().getInstanceId();
      if (this.mAdapter == null) {
        this.mAdapter = ViolaSDKManager.getInstance().getHttpAdapter();
      }
      this.mAdapter.sendRequest(localHttpRequset, new HttpModule.HttpListener(this, new HttpModule.1(this, paramString2, paramString1)), paramBoolean);
      return;
    }
  }
  
  public void destroy()
  {
    if (this.handler != null)
    {
      this.handler.removeCallbacksAndMessages(null);
      this.handler = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (getViolaInstance() != null) {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramMessage.getData().getString("resp"));
          ViolaBridgeManager.getInstance().callbackJavascript(paramMessage.getData().getString("inctanceId"), "http", "callback", paramMessage.getData().getString("callback"), localJSONObject, true);
        }
        catch (JSONException paramMessage)
        {
          ViolaLogUtils.e(TAG, "handleMessage JSONException e:" + paramMessage.getMessage());
        }
      }
    }
  }
  
  Object parseData(String paramString1, String paramString2)
  {
    Object localObject;
    if ("json".equals(paramString2)) {
      localObject = new JSONObject(paramString1);
    }
    do
    {
      return localObject;
      localObject = paramString1;
    } while (!"jsonp".equals(paramString2));
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      return new JSONObject();
    }
    int i = paramString1.indexOf("(") + 1;
    int j = paramString1.lastIndexOf(")");
    if ((i == 0) || (i >= j) || (j <= 0)) {
      return new JSONObject();
    }
    return new JSONObject(paramString1.substring(i, j));
  }
  
  @JSMethod(uiThread=false)
  public void request(JSONObject paramJSONObject, String paramString)
  {
    if (TextUtils.isEmpty(paramJSONObject.optString("url"))) {
      return;
    }
    int i = paramJSONObject.optInt("timeout", 10000);
    boolean bool = paramJSONObject.optBoolean("forReport", false);
    reuqestHttp(paramJSONObject.optString("url"), paramJSONObject.optJSONObject("data"), paramJSONObject.optJSONObject("headers"), i, paramString, paramJSONObject.optString("method", "POST").toUpperCase(), bool);
  }
  
  @JSMethod(uiThread=false)
  public void requestGet(@NonNull String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    reuqestHttp(paramString1, paramJSONObject, null, 10000, paramString2, "GET", false);
  }
  
  @JSMethod(uiThread=false)
  public void requestPost(@NonNull String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    reuqestHttp(paramString1, paramJSONObject, null, 10000, paramString2, "POST", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.module.HttpModule
 * JD-Core Version:    0.7.0.1
 */