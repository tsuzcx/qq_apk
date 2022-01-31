package com.tencent.mobileqq.vaswebviewplugin;

import agwb;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.SparseArray;
import baip;
import bbac;
import bfom;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.vip.manager.MonitorManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletPayJsPlugin
  extends VasWebviewJsPlugin
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
  
  private static JSONObject filterUinByNickName(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject != null)
    {
      localJSONObject = paramJSONObject.optJSONObject("send_object");
      String str = localJSONObject.optString("lucky_uin");
      localJSONObject.remove("lucky_uin");
      if (!baip.a(str)) {
        localJSONObject.put("lucky_name", agwb.a(str));
      }
      paramJSONObject.remove("send_object");
      paramJSONObject.put("send_object", localJSONObject);
      return paramJSONObject;
    }
    return localJSONObject;
  }
  
  private void getHbDetail(AppInterface paramAppInterface, String paramString, QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver paramQWalletPayJsPluginResultReceiver)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("extra_data", paramString);
      localBundle.putString("callbackSn", "0");
      paramString = new Bundle();
      paramString.putInt("PayInvokerId", 22);
      Parcel localParcel = Parcel.obtain();
      paramQWalletPayJsPluginResultReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      paramQWalletPayJsPluginResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramString.putParcelable("_qwallet_payresult_receiver", paramQWalletPayJsPluginResultReceiver);
      paramString.putBundle("_qwallet_payparams_data", localBundle);
      paramString.putString("_qwallet_payparams_tag", "redgiftH5CommonDetail");
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, paramAppInterface, paramString);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  private void getHbDetailInfo(JSONObject paramJSONObject, String paramString)
  {
    String str1 = paramJSONObject.optString("listid");
    String str2 = paramJSONObject.optString("uin");
    String str3 = paramJSONObject.optString("offset");
    String str4 = paramJSONObject.optString("limit");
    if ((!TextUtils.isEmpty(str2)) && (str2.equals(this.app.getCurrentAccountUin())) && (!TextUtils.isEmpty(str1)))
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("listid", str1);
      paramJSONObject.put("uin", str2);
      paramJSONObject.put("offset", str3);
      paramJSONObject.put("limit", str4);
      paramJSONObject.put("viewTag", paramString);
      getHbDetail(this.app, paramJSONObject.toString(), this.mRecevicer);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QWalletPayJsHandler", 2, "notifyViewUpdate extstr = " + paramJSONObject);
  }
  
  private void getHbResult(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("listid");
    String str2 = paramJSONObject.optString("uin", "");
    if ((!baip.a(str1)) && (str2.equals(this.app.getCurrentAccountUin())))
    {
      Object localObject = bfom.a().b(str1);
      paramJSONObject = (JSONObject)localObject;
      if (baip.a((String)localObject)) {
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
              break label86;
            }
          }
          i -= 1;
          break;
        }
        label86:
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
  
  private String getPreCode(String paramString)
  {
    String str = "";
    if (paramString.contains("pre_code="))
    {
      str = paramString.substring(paramString.indexOf("pre_code="));
      paramString = str;
      if (str.contains("&")) {
        paramString = str.substring(0, str.indexOf("&"));
      }
      str = paramString;
      if (paramString.contains("=")) {
        str = paramString.split("=")[1];
      }
    }
    return str;
  }
  
  private void grapH5CommonHb(JSONObject paramJSONObject)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletPayJsHandler", 2, "grapH5CommonHb params: " + paramJSONObject);
      }
      String str1 = paramJSONObject.optString("listid");
      String str2 = paramJSONObject.optString("uin");
      if ((!baip.a(str2)) && (str2.equals(this.app.getCurrentAccountUin())) && (!baip.a(str1)))
      {
        String str3 = paramJSONObject.optString("feedsid");
        String str4 = paramJSONObject.optString("token");
        String str5 = str1 + "_" + getPreCode(str4);
        if (QLog.isColorLevel()) {
          QLog.i("QWalletPayJsHandler", 2, "cache key: " + str5);
        }
        bfom localbfom = bfom.a();
        str1 = localbfom.b(str5);
        paramJSONObject = str1;
        if (baip.a(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QWalletPayJsHandler", 2, "get cache from disk");
          }
          paramJSONObject = localbfom.a(str2, str5, SharedPreferencesProxyManager.getInstance().getProxy("qb_tenpay_h5_common_hb_" + str2, 0));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QWalletPayJsHandler", 2, "paramForGarpH5CommonHb:" + paramJSONObject);
        }
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramJSONObject = new JSONObject(paramJSONObject);
          paramJSONObject.put("feedsid", str3);
          paramJSONObject.put("uin", str2);
          paramJSONObject.put("token", str4);
          paramJSONObject.put("viewTag", "grapH5CommonHb");
          if ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().getUrl() != null)) {
            paramJSONObject.put("domain", new URL(this.mRuntime.a().getUrl()).getHost());
          }
          getGrapH5CommonHbResult(this.app, paramJSONObject.toString(), this.mRecevicer);
          return;
        }
        handJsError("-1001", "params error");
        return;
      }
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
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.optString("action");
      localJSONObject = localJSONObject.optJSONObject("params");
      if ("graphb".equals(paramString)) {
        grapH5CommonHb(localJSONObject);
      } else if ("getHbResult".equals(paramString)) {
        getHbResult(localJSONObject);
      }
    }
    catch (Exception paramString)
    {
      handJsError("-1001", "params exception: " + paramString.getLocalizedMessage());
    }
    boolean bool = "refreshHbDetail".equals(paramString);
    if (bool) {
      try
      {
        getHbDetailInfo(localJSONObject, "redgiftH5CommonDetail");
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    } else {
      handJsError("-1001", "params exception: no match action");
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
    PayBridgeActivity.a(this.mRuntime.a(), 7, localBundle);
  }
  
  public void getGrapH5CommonHbResult(AppInterface paramAppInterface, String paramString, QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver paramQWalletPayJsPluginResultReceiver)
  {
    if (paramAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_data", paramString);
    localBundle.putString("callbackSn", "0");
    paramString = new Bundle();
    paramString.putInt("PayInvokerId", 22);
    Parcel localParcel = Parcel.obtain();
    paramQWalletPayJsPluginResultReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramQWalletPayJsPluginResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    paramString.putParcelable("_qwallet_payresult_receiver", paramQWalletPayJsPluginResultReceiver);
    paramString.putBundle("_qwallet_payparams_data", localBundle);
    paramString.putString("_qwallet_payparams_tag", "grapH5CommonHb");
    QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, paramAppInterface, paramString);
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
    label197:
    label231:
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder().append("handleJsRequeste pkgName :").append(paramString2).append(" method: ").append(paramString3);
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
            break label197;
          }
        }
        for (paramJsBridgeListener = " arg: " + paramVarArgs[0];; paramJsBridgeListener = "")
        {
          QLog.i("QWalletPayJsHandler", 2, paramJsBridgeListener);
          this.mReceiveRequestTime = System.currentTimeMillis();
          if ((!"qw.pay".equals(paramString2)) && (!"qw_pay".equals(paramString2))) {
            break label231;
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
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null)
      {
        this.app = this.mRuntime.a();
        this.mContext = localActivity.getApplicationContext();
        this.mRecevicer = new QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver(this, new Handler(), this.app);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin
 * JD-Core Version:    0.7.0.1
 */