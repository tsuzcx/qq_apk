package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import arpd;
import arph;
import bhod;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
  public static final String Tag = "QQVIPFunctionJsPlugin";
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
    sendRemoteReq(arph.a("QQVIPFunctionReport643", "callback", this.mOnRemoteResp.key, localBundle), false, false);
  }
  
  private void reportToClientTo644(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    VipUtils.a(null, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramArrayOfString);
  }
  
  public void callPJs(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQVIPFunctionJsPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQVIPFunctionJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"QQVIPFunction".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        localObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (localObject == null) {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQVIPFunctionJsPlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject).toString());
        }
        ((JSONObject)localObject).optString("callback");
        ((JSONObject)localObject).optInt("id");
        ((JSONObject)localObject).optInt("status");
        if ("reportToClientTo644".equals(paramString3))
        {
          if (!((JSONObject)localObject).has("businessFlag")) {
            break label641;
          }
          paramJsBridgeListener = ((JSONObject)localObject).getString("businessFlag");
          if (!((JSONObject)localObject).has("actionType")) {
            break label647;
          }
          paramString1 = ((JSONObject)localObject).getString("actionType");
          if (!((JSONObject)localObject).has("actionName")) {
            break label653;
          }
          paramString2 = ((JSONObject)localObject).getString("actionName");
          if (!((JSONObject)localObject).has("entry")) {
            break label659;
          }
          i = ((JSONObject)localObject).getInt("entry");
          if (!((JSONObject)localObject).has("result")) {
            break label665;
          }
          j = ((JSONObject)localObject).getInt("result");
          if (!((JSONObject)localObject).has("reserves1")) {
            break label671;
          }
          paramString3 = ((JSONObject)localObject).getString("reserves1");
          if (!((JSONObject)localObject).has("reserves2")) {
            break label678;
          }
          paramVarArgs = ((JSONObject)localObject).getString("reserves2");
          if (!((JSONObject)localObject).has("reserves3")) {
            break label685;
          }
          str1 = ((JSONObject)localObject).getString("reserves3");
          if (!((JSONObject)localObject).has("reserves4")) {
            break label692;
          }
          str2 = ((JSONObject)localObject).getString("reserves4");
          reportToClientTo644(paramJsBridgeListener, paramString1, paramString2, i, j, new String[] { paramString3, paramVarArgs, str1, str2 });
        }
        else if ("reportToClientTo643".equals(paramString3))
        {
          if (((JSONObject)localObject).has("tag"))
          {
            paramJsBridgeListener = ((JSONObject)localObject).getString("tag");
            if (!((JSONObject)localObject).has("mainAction")) {
              break label699;
            }
            paramString1 = ((JSONObject)localObject).getString("mainAction");
            if (!((JSONObject)localObject).has("toUin")) {
              break label705;
            }
            paramString2 = ((JSONObject)localObject).getString("toUin");
            if (!((JSONObject)localObject).has("actionType")) {
              break label711;
            }
            paramString3 = ((JSONObject)localObject).getString("actionType");
            if (!((JSONObject)localObject).has("actionName")) {
              break label718;
            }
            paramVarArgs = ((JSONObject)localObject).getString("actionName");
            if (!((JSONObject)localObject).has("entry")) {
              break label725;
            }
            i = ((JSONObject)localObject).getInt("entry");
            if (!((JSONObject)localObject).has("result")) {
              break label731;
            }
            j = ((JSONObject)localObject).getInt("result");
            if (!((JSONObject)localObject).has("reserves1")) {
              break label737;
            }
            str1 = ((JSONObject)localObject).getString("reserves1");
            if (!((JSONObject)localObject).has("reserves2")) {
              break label744;
            }
            str2 = ((JSONObject)localObject).getString("reserves2");
            if (!((JSONObject)localObject).has("reserves3")) {
              break label751;
            }
            str3 = ((JSONObject)localObject).getString("reserves3");
            if (!((JSONObject)localObject).has("reserves4")) {
              break label758;
            }
            localObject = ((JSONObject)localObject).getString("reserves4");
            reportToClientTo643(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs, i, j, new String[] { str1, str2, str3, localObject });
          }
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      paramJsBridgeListener = "CliOper";
      continue;
      throw new Exception("No Such Method:" + paramString3);
      return true;
      label641:
      paramJsBridgeListener = "";
      continue;
      label647:
      paramString1 = "";
      continue;
      label653:
      paramString2 = "";
      continue;
      label659:
      int i = -1;
      continue;
      label665:
      int j = -1;
      continue;
      label671:
      paramString3 = "";
      continue;
      label678:
      paramVarArgs = "";
      continue;
      label685:
      String str1 = "";
      continue;
      label692:
      String str2 = "";
      continue;
      label699:
      paramString1 = "";
      continue;
      label705:
      paramString2 = "";
      continue;
      label711:
      paramString3 = "";
      continue;
      label718:
      paramVarArgs = "";
      continue;
      label725:
      i = -1;
      continue;
      label731:
      j = -1;
      continue;
      label737:
      str1 = "";
      continue;
      label744:
      str2 = "";
      continue;
      label751:
      String str3 = "";
      continue;
      label758:
      Object localObject = "";
    }
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (paramCustomWebView != null) {
      this.mUserAgent = paramCustomWebView.getSettings().getUserAgentString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VipFunctionJsPlugin
 * JD-Core Version:    0.7.0.1
 */