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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.pluginshare.ITenCookie;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCallback: ");
      localStringBuilder.append(paramString);
      QLog.i("QWalletPayJsHandler", 2, localStringBuilder.toString());
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
      Object localObject = ((ITenCookie)QRoute.api(ITenCookie.class)).getTempArgs(str1);
      paramJSONObject = (JSONObject)localObject;
      if (StringUtil.a((String)localObject))
      {
        paramJSONObject = SharedPreferencesProxyManager.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("common_h5_hb_info");
        ((StringBuilder)localObject).append(str2);
        paramJSONObject = paramJSONObject.getProxy(((StringBuilder)localObject).toString(), 0).getString(str1, "");
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getHbResult dataStr: ");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.i("QWalletPayJsHandler", 2, ((StringBuilder)localObject).toString());
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
    if (mFirstUrls != null)
    {
      Object localObject = mSequence;
      if (localObject != null)
      {
        int i = ((ArrayList)localObject).size() - 1;
        while (i >= 0)
        {
          localObject = (Integer)mSequence.get(i);
          if (localObject != null) {
            localObject = (String)mFirstUrls.get(((Integer)localObject).intValue());
          } else {
            localObject = null;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            int j = ((String)localObject).indexOf("qqwallet_appinfo=");
            if (j != -1)
            {
              int k = j + 17;
              j = ((String)localObject).indexOf('&', k);
              i = j;
              if (j == -1) {
                i = ((String)localObject).length();
              }
              return ((String)localObject).substring(k, i);
            }
          }
          i -= 1;
        }
      }
    }
    return "";
  }
  
  private void grapH5CommonHb(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = QLog.isColorLevel();
      StringBuilder localStringBuilder;
      if (bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("grapH5CommonHb params: ");
        localStringBuilder.append(paramJSONObject);
        QLog.d("QWalletPayJsHandler", 2, localStringBuilder.toString());
      }
      paramJSONObject = ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getExtraDataForGrapH5CommonHbResult(this.app, paramJSONObject);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("grapH5CommonHb extraData: ");
        localStringBuilder.append(paramJSONObject);
        QLog.d("QWalletPayJsHandler", 2, localStringBuilder.toString());
      }
      if (paramJSONObject != null)
      {
        if ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().getUrl() != null)) {
          paramJSONObject.put("domain", new URL(this.mRuntime.a().getUrl()).getHost());
        }
        ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getGrapH5CommonHbResult(this.app, paramJSONObject.toString(), this.mRecevicer);
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handJsError: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("QWalletPayJsHandler", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("retcode", paramString1);
      ((JSONObject)localObject).put("retmsg", paramString2);
      doCallback(((JSONObject)localObject).toString());
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
    if (localObject1 != null) {
      localObject1 = ((CustomWebView)localObject1).getUrl();
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = URLEncoder.encode((String)localObject1, "utf-8");
      }
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      if (QLog.isDevelopLevel())
      {
        localException.printStackTrace();
        localObject2 = localObject1;
      }
    }
    try
    {
      Object localObject3 = new JSONObject(paramString);
      localObject1 = ((JSONObject)localObject3).getString("data");
      localObject3 = ((JSONObject)localObject3).getString("requestId");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("HandleUrl params objectName=qw.pay,methodName=openSuperVip,jsonParams=");
        localStringBuilder.append(paramString);
        QLog.i("QWalletPayJsHandler", 2, localStringBuilder.toString());
      }
      paramString = new Bundle();
      paramString.putString("json", (String)localObject1);
      paramString.putString("callbackSn", (String)localObject3);
      paramString.putInt("payparmas_paytype", 1);
      paramString.putLong("payparmas_h5_start", this.mReceiveRequestTime);
      paramString.putLong("vacreport_key_seq", this.mReportSeq);
      paramString.putString("payparmas_h5_url", (String)localObject2);
      PayBridgeActivity.tenpay(this.mRuntime.a(), 11, paramString);
      return true;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("jsonParams JSONException,jsonParams=");
        ((StringBuilder)localObject2).append(paramString);
        QLog.i("QWalletPayJsHandler", 2, ((StringBuilder)localObject2).toString());
      }
      localJSONException.printStackTrace();
    }
    return false;
  }
  
  private void parseCallback(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.toLowerCase().indexOf("callback") < 0) {
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
  }
  
  private boolean qWalletBridge(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("action");
      JSONObject localJSONObject = paramString.optJSONObject("params");
      if ("graphb".equals(str))
      {
        grapH5CommonHb(localJSONObject);
      }
      else if ("getHbResult".equals(str))
      {
        getHbResult(localJSONObject);
      }
      else
      {
        boolean bool = "refreshHbDetail".equals(str);
        if (bool) {
          try
          {
            ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getHbDetailInfo(this.app, localJSONObject, "redgiftH5CommonDetail", this.mRecevicer);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        } else {
          handJsError("-1001", "params exception: no match action");
        }
      }
      if ((paramString.optInt("closeWebView") == 1) && (this.mActivity != null))
      {
        this.mActivity.finish();
        return true;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("params exception: ");
      localStringBuilder.append(paramString.getLocalizedMessage());
      handJsError("-1001", localStringBuilder.toString());
    }
    return true;
  }
  
  public void buyGoods(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buyGoods requet params json=");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.i("QWalletPayJsHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("json", paramJSONObject.toString());
    ((Bundle)localObject).putString("callbackSn", paramString);
    ((Bundle)localObject).putInt("payparmas_paytype", 1);
    ((Bundle)localObject).putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.tenpay(this.mRuntime.a(), 7, (Bundle)localObject);
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 32L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("qw.bridge.publicTube('");
          localStringBuilder.append(paramMap);
          localStringBuilder.append("', '{\"code\":0, \"msg\":\"ok\", \"data\":");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("}')");
          callJs(localStringBuilder.toString());
          paramString.append("result : ");
          paramString.append((String)localObject);
        }
        MonitorManager.a().a(1, 2, "会员：返回支付结果", paramString.toString());
        return true;
      }
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (paramVarArgs != null))
    {
      if (paramVarArgs.length <= 0) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleJsRequeste pkgName :");
        paramString1.append(paramString2);
        paramString1.append(" method: ");
        paramString1.append(paramString3);
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append(" arg: ");
          paramJsBridgeListener.append(paramVarArgs[0]);
          paramJsBridgeListener = paramJsBridgeListener.toString();
        }
        else
        {
          paramJsBridgeListener = "";
        }
        paramString1.append(paramJsBridgeListener);
        QLog.i("QWalletPayJsHandler", 2, paramString1.toString());
      }
      this.mReceiveRequestTime = System.currentTimeMillis();
      if ((!"qw.pay".equals(paramString2)) && (!"qw_pay".equals(paramString2)))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("can not handle objectname:");
          paramJsBridgeListener.append(paramString2);
          QLog.i("QWalletPayJsHandler", 2, paramJsBridgeListener.toString());
          return false;
        }
      }
      else
      {
        if ("openSuperVip".equals(paramString3))
        {
          this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "openSVip", "payinvoke", null, 0, null);
          MonitorManager.a().a(1, 1, "会员：调用支付支付sdk", "");
          return openSuperVip(paramVarArgs[0]);
        }
        if ("qWalletBridge".equals(paramString3))
        {
          parseCallback(paramVarArgs[0]);
          return qWalletBridge(paramVarArgs[0]);
        }
      }
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return handleThemeAndBubbleSchemaRequest(paramString1, paramString2, "pay");
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return paramString2.equals("qqjsbridge");
  }
  
  protected void onCreate()
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
  
  protected void onDestroy()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      localObject = this.mRuntime.a();
      mFirstUrls.remove(localObject.hashCode());
      mSequence.remove(Integer.valueOf(localObject.hashCode()));
    }
    Object localObject = this.mRecevicer;
    if (localObject != null) {
      ((QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver)localObject).onDestroy();
    }
    this.mActivity = null;
    this.app = null;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openService requet params json=");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.i("QWalletPayJsHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("json", paramJSONObject.toString());
    ((Bundle)localObject).putString("callbackSn", paramString);
    ((Bundle)localObject).putInt("payparmas_paytype", 1);
    ((Bundle)localObject).putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.tenpay(this.mRuntime.a(), 4, (Bundle)localObject);
  }
  
  public void openTenpayView(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openTenpayView requet params json=");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.i("QWalletPayJsHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("json", paramJSONObject.toString());
    ((Bundle)localObject).putString("callbackSn", paramString);
    ((Bundle)localObject).putInt("payparmas_paytype", 1);
    ((Bundle)localObject).putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.tenpay(this.mRuntime.a(), 5, (Bundle)localObject);
  }
  
  public void pay(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pay requet params json=");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.i("QWalletPayJsHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("json", paramJSONObject.toString());
    ((Bundle)localObject).putString("callbackSn", paramString);
    ((Bundle)localObject).putString("payparmas_url_appinfo", getPayAppInfo());
    ((Bundle)localObject).putInt("payparmas_paytype", 1);
    ((Bundle)localObject).putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.tenpay(this.mRuntime.a(), 9, (Bundle)localObject);
  }
  
  public void rechargeGameCurrency(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("rechargeCurrency requet params json=");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.i("QWalletPayJsHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("json", paramJSONObject.toString());
    ((Bundle)localObject).putString("callbackSn", paramString);
    ((Bundle)localObject).putInt("payparmas_paytype", 1);
    ((Bundle)localObject).putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.tenpay(this.mRuntime.a(), 6, (Bundle)localObject);
  }
  
  public void rechargeQb(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("rechargeQb requet params json=");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.i("QWalletPayJsHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("json", paramJSONObject.toString());
    ((Bundle)localObject).putString("callbackSn", paramString);
    ((Bundle)localObject).putInt("payparmas_paytype", 1);
    ((Bundle)localObject).putLong("payparmas_h5_start", this.mReceiveRequestTime);
    PayBridgeActivity.tenpay(this.mRuntime.a(), 8, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin
 * JD-Core Version:    0.7.0.1
 */