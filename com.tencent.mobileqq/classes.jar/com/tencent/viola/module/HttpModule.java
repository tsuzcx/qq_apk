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
        Object localObject1 = paramJSONObject.keys();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next().toString();
          String str = paramJSONObject.getString((String)localObject2);
          if (!TextUtils.isEmpty(str))
          {
            str = URLEncoder.encode(str);
            if (!TextUtils.isEmpty(str)) {
              paramJSONObject.put((String)localObject2, str.replace("+", "%20"));
            }
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("encodeDataFromJson Exception e:");
        ((StringBuilder)localObject2).append(paramJSONObject.getMessage());
        ViolaLogUtils.e((String)localObject1, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  static String getHeader(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap != null) && (paramString != null))
    {
      if (paramMap.containsKey(paramString)) {
        return (String)paramMap.get(paramString);
      }
      return (String)paramMap.get(paramString.toLowerCase());
    }
    return null;
  }
  
  static String readAsString(byte[] paramArrayOfByte, String paramString)
  {
    if (paramString != null)
    {
      paramString = CHARSET_PATTERN.matcher(paramString.toLowerCase());
      if (paramString.find())
      {
        paramString = paramString.group(1);
        break label34;
      }
    }
    paramString = "utf-8";
    try
    {
      label34:
      paramString = new String(paramArrayOfByte, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Log.e("", paramString.getMessage());
    }
    return new String(paramArrayOfByte);
  }
  
  private void reuqestHttp(String paramString1, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    getViolaInstance();
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.url = paramString1;
    localHttpRequset.method = paramString3;
    if ((!paramString3.equals("GET")) || (paramJSONObject1 != null)) {}
    try
    {
      paramString3 = new JSONObject(paramJSONObject1.toString());
      encodeDataFromJson(paramString3);
      localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramString3, paramString1);
    }
    catch (JSONException paramString3)
    {
      label73:
      break label73;
    }
    localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramJSONObject1, paramString1);
    break label96;
    localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramJSONObject1, paramString1);
    label96:
    localHttpRequset.timeoutMs = paramInt;
    paramString1 = new HashMap();
    if (paramJSONObject2 != null)
    {
      paramString3 = paramJSONObject2.keys();
      while (paramString3.hasNext())
      {
        String str = (String)paramString3.next();
        paramString1.put(str, paramJSONObject2.optString(str));
      }
      localHttpRequset.paramMap = paramString1;
    }
    if (paramJSONObject1 != null) {
      if ((paramString1.containsKey("Content-Type")) && (!TextUtils.isEmpty((CharSequence)paramString1.get("Content-Type"))) && (((String)paramString1.get("Content-Type")).contains("application/json"))) {
        localHttpRequset.body = paramJSONObject1.toString();
      } else {
        localHttpRequset.body = ViolaUtils.splittBodyEncodeUrl(paramJSONObject1);
      }
    }
    paramString1 = getViolaInstance().getInstanceId();
    if (this.mAdapter == null) {
      this.mAdapter = ViolaSDKManager.getInstance().getHttpAdapter();
    }
    this.mAdapter.sendRequest(localHttpRequset, new HttpModule.HttpListener(this, new HttpModule.1(this, paramString2, paramString1)), paramBoolean);
  }
  
  public void destroy()
  {
    Handler localHandler = this.handler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.handler = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (getViolaInstance() != null)) {
      try
      {
        localObject = new JSONObject(paramMessage.getData().getString("resp"));
        ViolaBridgeManager.getInstance().callbackJavascript(paramMessage.getData().getString("inctanceId"), "http", "callback", paramMessage.getData().getString("callback"), localObject, true);
      }
      catch (JSONException paramMessage)
      {
        Object localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage JSONException e:");
        localStringBuilder.append(paramMessage.getMessage());
        ViolaLogUtils.e((String)localObject, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  Object parseData(String paramString1, String paramString2)
  {
    if ("json".equals(paramString2)) {
      return new JSONObject(paramString1);
    }
    Object localObject = paramString1;
    if ("jsonp".equals(paramString2))
    {
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        int i = paramString1.indexOf("(") + 1;
        int j = paramString1.lastIndexOf(")");
        if ((i != 0) && (i < j) && (j > 0)) {
          return new JSONObject(paramString1.substring(i, j));
        }
        return new JSONObject();
      }
      localObject = new JSONObject();
    }
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.module.HttpModule
 * JD-Core Version:    0.7.0.1
 */