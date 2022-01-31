package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletPayJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String METHOD_NAME_OPENSUPERVIP = "openSuperVip";
  public static final String OBJECT_NAME_NEW = "qw.pay";
  private static final String OBJECT_NAME_OLD = "pay";
  private static final String TAG = "QWalletPayJsHandler";
  public static SparseArray mFirstUrls = new SparseArray();
  public static ArrayList mSequence = new ArrayList();
  protected long mReceiveRequestTime;
  public long mReportSeq;
  
  public QWalletPayJsPlugin()
  {
    this.mPluginNameSpace = "qw.pay";
  }
  
  public static String getPayAppInfo()
  {
    if ((mFirstUrls != null) && (mSequence != null))
    {
      int i = mSequence.size() - 1;
      if (i >= 0)
      {
        Object localObject = (Integer)mSequence.get(i);
        if (localObject != null) {}
        int k;
        for (localObject = (String)mFirstUrls.get(((Integer)localObject).intValue());; localObject = null)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            k = ((String)localObject).indexOf("qqwallet_appinfo=");
            if (k != -1) {
              break label85;
            }
          }
          i -= 1;
          break;
        }
        label85:
        int j = ((String)localObject).indexOf('&', "qqwallet_appinfo=".length() + k);
        i = j;
        if (j == -1) {
          i = ((String)localObject).length();
        }
        return ((String)localObject).substring("qqwallet_appinfo=".length() + k, i);
      }
    }
    return "";
  }
  
  private boolean openSuperVip(String paramString)
  {
    Object localObject1 = this.mRuntime.a();
    String str = "";
    if (localObject1 != null) {
      str = ((CustomWebView)localObject1).getUrl();
    }
    localObject1 = str;
    try
    {
      if (!TextUtils.isEmpty(str)) {
        localObject1 = URLEncoder.encode(str, "utf-8");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = new JSONObject(paramString);
          str = ((JSONObject)localObject2).getString("data");
          localObject2 = ((JSONObject)localObject2).getString("requestId");
          if (QLog.isColorLevel()) {
            QLog.i("QWalletPayJsHandler", 2, "HandleUrl params objectName=qw.pay,methodName=openSuperVip,jsonParams=" + paramString);
          }
          paramString = new Bundle();
          paramString.putString("json", str);
          paramString.putString("callbackSn", (String)localObject2);
          paramString.putInt("payparmas_paytype", 1);
          paramString.putLong("payparmas_h5_start", this.mReceiveRequestTime);
          paramString.putLong("vacreport_key_seq", this.mReportSeq);
          paramString.putString("payparmas_h5_url", (String)localObject1);
          PayBridgeActivity.a(this.mRuntime.a(), 11, paramString);
          return true;
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("QWalletPayJsHandler", 2, "jsonParams JSONException,jsonParams=" + paramString);
          localJSONException.printStackTrace();
        }
        localException = localException;
        localObject1 = str;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject1 = str;
        }
      }
    }
    return false;
  }
  
  public void buyGoods(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "buyGoods requet params json=" + paramJSONObject.toString());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramJSONObject.toString());
    localBundle.putString("callbackSn", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.a(this.mRuntime.a(), 7, localBundle);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (8589934600L == paramLong)
    {
      paramString = (Integer)paramMap.get("requestCode");
      if ((paramString != null) && (paramString.intValue() == 11))
      {
        paramMap = (Intent)paramMap.get("data");
        if (paramMap != null)
        {
          paramString = paramMap.getStringExtra("callbackSn");
          paramMap = paramMap.getStringExtra("result");
          callJs("qw.bridge.publicTube('" + paramString + "', '{\"code\":0, \"msg\":\"ok\", \"data\":" + paramMap + "}')");
        }
        return true;
      }
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs.length <= 0)) {}
    do
    {
      do
      {
        return false;
        this.mReceiveRequestTime = System.currentTimeMillis();
        if (!"qw.pay".equals(paramString2)) {
          break;
        }
      } while (!"openSuperVip".equals(paramString3));
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "openSVip", "payinvoke", null, 0, null);
      return openSuperVip(paramVarArgs[0]);
    } while (!QLog.isColorLevel());
    QLog.i("QWalletPayJsHandler", 2, "can not handle objectname:" + paramString2);
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return handleThemeAndBubbleSchemaRequest(paramString1, paramString2, "pay");
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      Activity localActivity = this.mRuntime.a();
      mFirstUrls.remove(localActivity.hashCode());
      mSequence.remove(Integer.valueOf(localActivity.hashCode()));
    }
    super.onDestroy();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      Activity localActivity = this.mRuntime.a();
      Intent localIntent = localActivity.getIntent();
      if (localIntent != null)
      {
        String str = localIntent.getStringExtra("homepage");
        paramCustomWebView = str;
        if (TextUtils.isEmpty(str)) {
          paramCustomWebView = localIntent.getStringExtra("url");
        }
        if (paramCustomWebView != null)
        {
          mFirstUrls.append(localActivity.hashCode(), paramCustomWebView);
          mSequence.add(0, Integer.valueOf(localActivity.hashCode()));
        }
      }
    }
  }
  
  public void openService(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "openService requet params json=" + paramJSONObject.toString());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramJSONObject.toString());
    localBundle.putString("callbackSn", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.a(this.mRuntime.a(), 4, localBundle);
  }
  
  public void openTenpayView(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "openTenpayView requet params json=" + paramJSONObject.toString());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramJSONObject.toString());
    localBundle.putString("callbackSn", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.a(this.mRuntime.a(), 5, localBundle);
  }
  
  public void pay(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "pay requet params json=" + paramJSONObject.toString());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramJSONObject.toString());
    localBundle.putString("callbackSn", paramString);
    localBundle.putString("payparmas_url_appinfo", getPayAppInfo());
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.a(this.mRuntime.a(), 9, localBundle);
  }
  
  public void rechargeGameCurrency(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "rechargeCurrency requet params json=" + paramJSONObject.toString());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramJSONObject.toString());
    localBundle.putString("callbackSn", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.a(this.mRuntime.a(), 6, localBundle);
  }
  
  public void rechargeQb(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "rechargeQb requet params json=" + paramJSONObject.toString());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramJSONObject.toString());
    localBundle.putString("callbackSn", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.a(this.mRuntime.a(), 8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin
 * JD-Core Version:    0.7.0.1
 */