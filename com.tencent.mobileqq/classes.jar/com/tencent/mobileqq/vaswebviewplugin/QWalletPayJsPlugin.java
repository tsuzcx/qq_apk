package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.H5HbUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.pluginshare.TenCookie;
import cooperation.vip.manager.MonitorManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletPayJsPlugin
  extends VasWebviewJsPlugin
  implements IPreCreatePluginChecker
{
  private static final String METHOD_NAME_OPENSUPERVIP = "openSuperVip";
  private static final String METHOD_NAME_QWALLETBRIDGE = "qWalletBridge";
  public static final String OBJECT_NAME_NEW = "qw.pay";
  public static final String OBJECT_NAME_NEW_COMPATIBLE_IOS = "qw_pay";
  private static final String OBJECT_NAME_OLD = "pay";
  private static final String TAG = "QWalletPayJsHandler";
  public static SparseArray<String> mFirstUrls = new SparseArray();
  public static ArrayList<Integer> mSequence = new ArrayList();
  private AppInterface app;
  private Activity mActivity = null;
  private String mCallback;
  private Context mContext;
  protected long mReceiveRequestTime;
  private QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver mRecevicer;
  public long mReportSeq;
  
  public QWalletPayJsPlugin()
  {
    this.mPluginNameSpace = "qw.pay";
  }
  
  private void doCallback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "doCallback: " + paramString);
    }
    doCallback(this.mCallback, paramString);
  }
  
  private void doCallback(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  private void getHbResult(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("listid");
    String str2 = paramJSONObject.optString("uin", "");
    if ((!StringUtil.a(str1)) && (str2.equals(this.app.getCurrentAccountUin())))
    {
      Object localObject = TenCookie.a().b(str1);
      paramJSONObject = (JSONObject)localObject;
      if (StringUtil.a((String)localObject)) {
        paramJSONObject = SharedPreferencesProxyManager.getInstance().getProxy("common_h5_hb_info" + str2, 0).getString(str1, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("QWalletPayJsHandler", 2, "getHbResult dataStr: " + paramJSONObject);
      }
      paramJSONObject = new JSONObject(paramJSONObject);
      if (paramJSONObject.has("detail_data"))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retcode", 0);
        ((JSONObject)localObject).put("retmsg", "ok");
        ((JSONObject)localObject).put("detail_data", paramJSONObject.optJSONObject("detail_data"));
        doCallback(((JSONObject)localObject).toString());
        return;
      }
      if (paramJSONObject.has("exception_data"))
      {
        doCallback(paramJSONObject.optString("exception_data"));
        return;
      }
      handJsError("-1001", "params error, detail_data is empty");
      return;
    }
    handJsError("-1001", "params error,listid is empty or is not current user");
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
  
  private void grapH5CommonHb(JSONObject paramJSONObject)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletPayJsHandler", 2, "grapH5CommonHb params: " + paramJSONObject);
      }
      paramJSONObject = H5HbUtil.a(this.app, paramJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("QWalletPayJsHandler", 2, "grapH5CommonHb extraData: " + paramJSONObject);
      }
      if (paramJSONObject != null)
      {
        if ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().getUrl() != null)) {
          paramJSONObject.put("domain", new URL(this.mRuntime.a().getUrl()).getHost());
        }
        H5HbUtil.a(this.app, paramJSONObject.toString(), this.mRecevicer);
        return;
      }
      handJsError("-1001", "params error");
      return;
    }
    catch (Throwable paramJSONObject)
    {
      handJsError("-1001", paramJSONObject.getLocalizedMessage());
    }
  }
  
  private void handJsError(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletPayJsHandler", 2, "handJsError: " + paramString2);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retcode", paramString1);
      localJSONObject.put("retmsg", paramString2);
      doCallback(localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
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
          PayBridgeActivity.tenpay(this.mRuntime.a(), 11, paramString);
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
  
  private void parseCallback(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.toLowerCase().indexOf("callback") < 0)) {
      return;
    }
    try
    {
      this.mCallback = new JSONObject(paramString).optString("callback");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean qWalletBridge(String paramString)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        paramString = new JSONObject(paramString);
        String str = paramString.optString("action");
        localJSONObject = paramString.optJSONObject("params");
        if ("graphb".equals(str))
        {
          grapH5CommonHb(localJSONObject);
          if ((paramString.optInt("closeWebView") != 1) || (this.mActivity == null)) {
            break;
          }
          this.mActivity.finish();
          return true;
        }
        if ("getHbResult".equals(str))
        {
          getHbResult(localJSONObject);
          continue;
        }
        bool = "refreshHbDetail".equals(str);
      }
      catch (Exception paramString)
      {
        handJsError("-1001", "params exception: " + paramString.getLocalizedMessage());
        return true;
      }
      boolean bool;
      if (bool) {
        try
        {
          H5HbUtil.a(this.app, localJSONObject, "redgiftH5CommonDetail", this.mRecevicer);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      } else {
        handJsError("-1001", "params exception: no match action");
      }
    }
    return true;
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
    PayBridgeActivity.tenpay(this.mRuntime.a(), 7, localBundle);
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 32L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (8589934600L == paramLong)
    {
      paramString = (Integer)paramMap.get("requestCode");
      if ((paramString != null) && (paramString.intValue() == 11))
      {
        Object localObject = (Intent)paramMap.get("data");
        paramString = new StringBuilder();
        if (localObject != null)
        {
          paramMap = ((Intent)localObject).getStringExtra("callbackSn");
          localObject = ((Intent)localObject).getStringExtra("result");
          callJs("qw.bridge.publicTube('" + paramMap + "', '{\"code\":0, \"msg\":\"ok\", \"data\":" + (String)localObject + "}')");
          paramString.append("result : ").append((String)localObject);
        }
        MonitorManager.a().a(1, 2, "会员：返回支付结果", paramString.toString());
        return true;
      }
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    label196:
    label229:
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder().append("handleJsRequeste pkgName :").append(paramString2).append(" method: ").append(paramString3);
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
            break label196;
          }
        }
        for (paramJsBridgeListener = " arg: " + paramVarArgs[0];; paramJsBridgeListener = "")
        {
          QLog.i("QWalletPayJsHandler", 2, paramJsBridgeListener);
          this.mReceiveRequestTime = System.currentTimeMillis();
          if ((!"qw.pay".equals(paramString2)) && (!"qw_pay".equals(paramString2))) {
            break label229;
          }
          if (!"openSuperVip".equals(paramString3)) {
            break;
          }
          this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "openSVip", "payinvoke", null, 0, null);
          MonitorManager.a().a(1, 1, "会员：调用支付支付sdk", "");
          return openSuperVip(paramVarArgs[0]);
        }
      } while (!"qWalletBridge".equals(paramString3));
      parseCallback(paramVarArgs[0]);
      return qWalletBridge(paramVarArgs[0]);
    } while (!QLog.isColorLevel());
    QLog.i("QWalletPayJsHandler", 2, "can not handle objectname:" + paramString2);
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return handleThemeAndBubbleSchemaRequest(paramString1, paramString2, "pay");
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return paramString2.equals("qqjsbridge");
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.a();
      this.mActivity = localActivity;
      if (localActivity != null)
      {
        this.app = this.mRuntime.a();
        this.mContext = this.mActivity.getApplicationContext();
        this.mRecevicer = new QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver(this, new Handler());
      }
    }
  }
  
  public void onDestroy()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      Activity localActivity = this.mRuntime.a();
      mFirstUrls.remove(localActivity.hashCode());
      mSequence.remove(Integer.valueOf(localActivity.hashCode()));
    }
    this.mActivity = null;
    this.app = null;
    super.onDestroy();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
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
    PayBridgeActivity.tenpay(this.mRuntime.a(), 4, localBundle);
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
    PayBridgeActivity.tenpay(this.mRuntime.a(), 5, localBundle);
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
    PayBridgeActivity.tenpay(this.mRuntime.a(), 9, localBundle);
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
    PayBridgeActivity.tenpay(this.mRuntime.a(), 6, localBundle);
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
    PayBridgeActivity.tenpay(this.mRuntime.a(), 8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin
 * JD-Core Version:    0.7.0.1
 */