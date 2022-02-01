package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class VipFunctionJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "QQVIPFunction";
  private static final int MAX_REDIRECT = 5;
  public static final String Method_openPreview = "reportToClientTo644";
  public static final String Method_report643 = "reportToClientTo643";
  public static final String TAG = "QQVIPFunctionJsPlugin";
  private volatile String mCurrentURL;
  private Set<String> mUrlFilter;
  private volatile String mUserAgent;
  
  public VipFunctionJsPlugin()
  {
    this.mPluginNameSpace = "QQVIPFunction";
  }
  
  private void reportToClientTo643(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("tag", paramString1);
    localBundle.putString("mainAction", paramString2);
    localBundle.putString("toUin", paramString3);
    localBundle.putString("subAction", paramString4);
    localBundle.putString("actionName", paramString5);
    localBundle.putInt("fromeType", paramInt1);
    localBundle.putInt("result", paramInt2);
    localBundle.putStringArray("reserves", paramArrayOfString);
    sendRemoteReq(DataFactory.a("QQVIPFunctionReport643", "callback", this.mOnRemoteResp.key, localBundle), false, false);
  }
  
  private void reportToClientTo644(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      VipUtils.a(null, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramArrayOfString);
    }
  }
  
  public void callPJs(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("method:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", json:");
      localStringBuilder.append(paramString2);
      QLog.d("QQVIPFunctionJsPlugin", 2, localStringBuilder.toString());
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L)
    {
      this.mCurrentURL = paramString;
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        this.mUserAgent = localCustomWebView.getSettings().getUserAgentString();
      }
    }
    return super.excuteEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      QLog.d("QQVIPFunctionJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if (("QQVIPFunction".equals(paramString2)) && (paramString1 != null)) {
      if (paramString3 == null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (localJSONObject == null) {
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("handleJsRequest JSON = ");
          paramJsBridgeListener.append(localJSONObject.toString());
          QLog.d("QQVIPFunctionJsPlugin", 2, paramJsBridgeListener.toString());
        }
        localJSONObject.optString("callback");
        localJSONObject.optInt("id");
        localJSONObject.optInt("status");
        boolean bool = "reportToClientTo644".equals(paramString3);
        paramJsBridgeListener = "";
        if (bool)
        {
          if (!localJSONObject.has("businessFlag")) {
            break label711;
          }
          paramString1 = localJSONObject.getString("businessFlag");
          if (!localJSONObject.has("actionType")) {
            break label717;
          }
          paramString2 = localJSONObject.getString("actionType");
          if (!localJSONObject.has("actionName")) {
            break label723;
          }
          paramString3 = localJSONObject.getString("actionName");
          if (!localJSONObject.has("entry")) {
            break label730;
          }
          i = localJSONObject.getInt("entry");
          if (!localJSONObject.has("result")) {
            break label736;
          }
          j = localJSONObject.getInt("result");
          if (!localJSONObject.has("reserves1")) {
            break label742;
          }
          paramVarArgs = localJSONObject.getString("reserves1");
          if (!localJSONObject.has("reserves2")) {
            break label749;
          }
          str1 = localJSONObject.getString("reserves2");
          if (!localJSONObject.has("reserves3")) {
            break label756;
          }
          str2 = localJSONObject.getString("reserves3");
          if (localJSONObject.has("reserves4")) {
            paramJsBridgeListener = localJSONObject.getString("reserves4");
          }
          reportToClientTo644(paramString1, paramString2, paramString3, i, j, new String[] { paramVarArgs, str1, str2, paramJsBridgeListener });
          return true;
        }
        if ("reportToClientTo643".equals(paramString3))
        {
          if (!localJSONObject.has("tag")) {
            break label763;
          }
          paramString1 = localJSONObject.getString("tag");
          if (!localJSONObject.has("mainAction")) {
            break label769;
          }
          paramString2 = localJSONObject.getString("mainAction");
          if (!localJSONObject.has("toUin")) {
            break label775;
          }
          paramString3 = localJSONObject.getString("toUin");
          if (!localJSONObject.has("actionType")) {
            break label782;
          }
          paramVarArgs = localJSONObject.getString("actionType");
          if (!localJSONObject.has("actionName")) {
            break label789;
          }
          str1 = localJSONObject.getString("actionName");
          if (!localJSONObject.has("entry")) {
            break label796;
          }
          i = localJSONObject.getInt("entry");
          if (!localJSONObject.has("result")) {
            break label802;
          }
          j = localJSONObject.getInt("result");
          if (!localJSONObject.has("reserves1")) {
            break label808;
          }
          str2 = localJSONObject.getString("reserves1");
          if (!localJSONObject.has("reserves2")) {
            break label815;
          }
          str3 = localJSONObject.getString("reserves2");
          if (!localJSONObject.has("reserves3")) {
            break label822;
          }
          str4 = localJSONObject.getString("reserves3");
          if (localJSONObject.has("reserves4")) {
            paramJsBridgeListener = localJSONObject.getString("reserves4");
          }
          reportToClientTo643(paramString1, paramString2, paramString3, paramVarArgs, str1, i, j, new String[] { str2, str3, str4, paramJsBridgeListener });
          return true;
        }
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("No Such Method:");
        paramJsBridgeListener.append(paramString3);
        throw new Exception(paramJsBridgeListener.toString());
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
      return false;
      label711:
      paramString1 = "";
      continue;
      label717:
      paramString2 = "";
      continue;
      label723:
      paramString3 = "";
      continue;
      label730:
      int i = -1;
      continue;
      label736:
      int j = -1;
      continue;
      label742:
      paramVarArgs = "";
      continue;
      label749:
      String str1 = "";
      continue;
      label756:
      String str2 = "";
      continue;
      label763:
      paramString1 = "CliOper";
      continue;
      label769:
      paramString2 = "";
      continue;
      label775:
      paramString3 = "";
      continue;
      label782:
      paramVarArgs = "";
      continue;
      label789:
      str1 = "";
      continue;
      label796:
      i = -1;
      continue;
      label802:
      j = -1;
      continue;
      label808:
      str2 = "";
      continue;
      label815:
      String str3 = "";
      continue;
      label822:
      String str4 = "";
    }
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (paramCustomWebView != null) {
      this.mUserAgent = paramCustomWebView.getSettings().getUserAgentString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VipFunctionJsPlugin
 * JD-Core Version:    0.7.0.1
 */