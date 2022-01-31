package dov.com.tencent.mobileqq.shortvideo.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.TextUtils;
import aoaj;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ShortVideoJsApiPlugin
  extends WebViewPlugin
{
  public BroadcastReceiver a = new aoaj(this);
  
  public ShortVideoJsApiPlugin()
  {
    this.mPluginNameSpace = "ptv";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoJsApiPlugin", 2, "Call ShortVideoJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
    }
    if ("ptv".equals(paramString2))
    {
      if ("GSBase64Encode".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api GSBaze64Encode, args:" + paramVarArgs);
        }
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
      }
      for (;;)
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("need_encode_string");
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = NearbyURLSafeUtil.a(paramString1);
            paramString2 = new JSONObject();
            paramString2.put("encoded_string", paramString1);
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          continue;
        }
        if ("isSupportPTV".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportPTV, args:" + paramVarArgs);
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                continue;
              }
              boolean bool = ShortVideoGuideUtil.c(this.mRuntime.a());
              paramString1 = new JSONObject();
              paramString1.put("is_support_ptv", bool);
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        else if ("startPTVActivity".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api startPTVActivity, args:" + paramVarArgs);
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              Object localObject = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = ((JSONObject)localObject).optString("callback");
              paramString1 = ((JSONObject)localObject).optString("supportvideo");
              paramString2 = ((JSONObject)localObject).optString("supportphoto");
              paramString3 = ((JSONObject)localObject).optString("cameramode");
              paramVarArgs = ((JSONObject)localObject).optString("beauty");
              String str1 = ((JSONObject)localObject).optString("unfoldtemplate");
              String str2 = ((JSONObject)localObject).optString("defaulttemplate");
              String str3 = ((JSONObject)localObject).optString("templatebtn");
              localObject = ((JSONObject)localObject).optString("dealtype");
              if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                ShortVideoGuideUtil.a(this.mRuntime.a(), this.mRuntime.a(), paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs, str1, str2, str3, (String)localObject);
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.shortVideoJsApiPulgin");
    this.mRuntime.a().registerReceiver(this.a, localIntentFilter);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mRuntime.a().unregisterReceiver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.ShortVideoJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */