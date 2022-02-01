package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.URLUtil;
import anzj;
import bjtz;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PayJsPlugin
  extends BaseJsPlugin
{
  public static final String KEY_MINI_GAME_PAY_ENV = "keyMiniGamePayEnv";
  public static final String KEY_MINI_GAME_PAY_ENV_APPID_VERTYPE = "keyMiniGamePayEnvAppidVertype";
  public static final int PAY_CHANNEL_WX = 8;
  public static final int PAY_DISABLE = 2;
  public static final int PAY_ENABLE = 1;
  public static final int PAY_INVOKER_BUY_GOODS = 7;
  public static final int PAY_INVOKER_PAY = 9;
  public static final int PAY_INVOKER_RECHARGE_GAME_CURRENCY = 6;
  public static final int PAY_INVOKER_SUBSCRIBE_MONTH_CARD = 14;
  public static final int PAY_UNKNOWN = 0;
  private static final Set<String> S_EVENT_MAP = new PayJsPlugin.1();
  private static final String TAG = "PayJsPlugin";
  public static final String TYPE_QQ_BUY_GOODS = "QQBuyGoods";
  public static final String TYPE_QQ_PAY = "QQPay";
  public static final String TYPE_QQ_PAY_GOODS = "QQPayGoods";
  private ConcurrentHashMap<Integer, BridgeInfo> bridgeMap;
  private boolean miniGameAutoConsume;
  PayJsPlugin.PayResultRecevicer payRecevicer;
  
  private String appendPayComeFrom(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("comeForm", 9);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return paramString;
  }
  
  private void handleMidasGoodsPay(Activity paramActivity, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    String str1 = paramJSONObject.optString("offerId", "");
    JSONObject localJSONObject = paramJSONObject.getJSONObject("payInfo");
    paramJSONObject = paramJSONObject.getString("userId");
    String str2 = localJSONObject.getString("tokenUrl");
    String str3 = localJSONObject.optString("aid", "");
    String str4 = localJSONObject.optString("zoneId", "1");
    String str5 = localJSONObject.optString("numberVisible", "");
    String str6 = localJSONObject.optString("unit", "");
    String str7 = localJSONObject.optString("discountId", "");
    String str8 = localJSONObject.optString("other", "");
    localJSONObject = new JSONObject();
    localJSONObject.put("offerId", str1);
    localJSONObject.put("userId", paramJSONObject);
    localJSONObject.put("tokenUrl", str2);
    localJSONObject.put("zoneId", str4);
    localJSONObject.put("numberVisible", str5);
    localJSONObject.put("unit", str6);
    localJSONObject.put("aid", str3);
    localJSONObject.put("discountId", str7);
    localJSONObject.put("other", str8);
    localJSONObject.put("comeForm", 9);
    paramJSONObject = new Bundle();
    paramJSONObject.putString("payparmas_callback_sn", String.valueOf(paramInt));
    paramJSONObject.putString("payparmas_json", localJSONObject.toString());
    paramJSONObject.putInt("payparmas_paytype", 1);
    paramJSONObject.putLong("payparmas_h5_start", System.currentTimeMillis());
    if (PayBridgeActivity.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface(), paramActivity, this.payRecevicer, 7, paramJSONObject).getInt("retCode", -1) != 0) {
      handleNativeResponseFail(paramInt, paramString, null, "");
    }
  }
  
  private void handleMidasMonthCardPay(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", String.valueOf(paramInt));
    localBundle.putString("payparmas_json", paramString2);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", System.currentTimeMillis());
    if (PayBridgeActivity.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface(), paramActivity, this.payRecevicer, 14, localBundle).getInt("retCode", -1) != 0) {
      handleNativeResponseFail(paramInt, paramString1, null, "");
    }
  }
  
  private void handleNativeResponseCancel(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      BridgeInfo localBridgeInfo = (BridgeInfo)this.bridgeMap.remove(Integer.valueOf(paramInt));
      if ((localBridgeInfo != null) && (this.jsPluginEngine != null)) {
        this.jsPluginEngine.callbackJsEventCancel(localBridgeInfo.getWebView(), paramString, paramJSONObject, localBridgeInfo.callbackId);
      }
    }
  }
  
  private void handleNativeResponseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.bridgeMap != null)
    {
      BridgeInfo localBridgeInfo = (BridgeInfo)this.bridgeMap.remove(Integer.valueOf(paramInt));
      if ((localBridgeInfo != null) && (this.jsPluginEngine != null)) {
        this.jsPluginEngine.callbackJsEventFail(localBridgeInfo.getWebView(), paramString1, paramJSONObject, paramString2, localBridgeInfo.callbackId);
      }
    }
  }
  
  private void handleNativeResponseOk(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      BridgeInfo localBridgeInfo = (BridgeInfo)this.bridgeMap.remove(Integer.valueOf(paramInt));
      if ((localBridgeInfo != null) && (this.jsPluginEngine != null)) {
        this.jsPluginEngine.callbackJsEventOK(localBridgeInfo.getWebView(), paramString, paramJSONObject, localBridgeInfo.callbackId);
      }
    }
  }
  
  private void handlePayByFriend(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    int i;
    try
    {
      localObject1 = new JSONObject(paramString1);
      Object localObject3 = ((JSONObject)localObject1).getString("prepayId");
      i = ((JSONObject)localObject1).optInt("setEnv", 0);
      paramString1 = ((JSONObject)localObject1).optString("title");
      localObject2 = ((JSONObject)localObject1).optString("imageUrl");
      localObject1 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject1 = GameWnsUtils.defaultPayShareTitle();
      }
      paramString1 = (String)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        paramString1 = GameWnsUtils.defaultPayShareImg();
      }
      localObject2 = new COMM.StCommonExt();
      COMM.Entry localEntry = new COMM.Entry();
      localEntry.key.set("prepay_id");
      localEntry.value.set((String)localObject3);
      ((COMM.StCommonExt)localObject2).mapInfo.get().add(localEntry);
      localObject3 = new COMM.Entry();
      ((COMM.Entry)localObject3).key.set("set_env");
      ((COMM.Entry)localObject3).value.set(i + "");
      ((COMM.StCommonExt)localObject2).mapInfo.get().add(localObject3);
      if (URLUtil.isHttpUrl(paramString1)) {
        break label454;
      }
      if (!URLUtil.isHttpsUrl(paramString1)) {
        break label460;
      }
    }
    catch (JSONException paramString1)
    {
      Object localObject1;
      Object localObject2;
      QLog.e("PayJsPlugin", 1, paramString2 + " error.", paramString1);
      handleNativeResponseFail(paramInt, paramString2, null, "");
      return;
    }
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (!TextUtils.isEmpty(paramString1)) && (new File(MiniAppFileManager.getInstance().getAbsolutePath(paramString1)).exists())) {}
    for (int j = 1;; j = 0)
    {
      if ((isMiniGameRuntime()) && (getGameBrandRuntime() != null))
      {
        getGameBrandRuntime().shareEvent = paramString2;
        getGameBrandRuntime().shareCallbackId = paramInt;
        getGameBrandRuntime().shareJsRuntime = paramJsRuntime;
      }
      if (i == 0) {
        if (j != 0)
        {
          paramJsRuntime = MiniAppFileManager.getInstance().getAbsolutePath(paramString1);
          this.jsPluginEngine.appBrandRuntime.startShare((String)localObject1, paramJsRuntime, "", "", "", "", null, null, 13, 0, "", 4, (COMM.StCommonExt)localObject2, new PayJsPlugin.6(this, paramInt, paramString2));
        }
      }
      for (;;)
      {
        this.jsPluginEngine.appBrandRuntime.startShare((String)localObject1, paramString1, "", "", "", "", null, null, 13, 0, "", 4, (COMM.StCommonExt)localObject2, new PayJsPlugin.7(this, paramInt, paramString2));
        return;
        paramString1 = GameWnsUtils.defaultPayShareImg();
      }
      label454:
      i = 1;
      break;
      label460:
      i = 0;
      break;
    }
  }
  
  private void handlePayCoinByH5(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      String str = paramString1.getString("offerId");
      MiniAppCmdUtil.getInstance().checkOfferId(this.jsPluginEngine.appBrandRuntime.appId, str, null, new PayJsPlugin.5(this, paramString1, paramJsRuntime, paramString2, paramInt));
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("PayJsPlugin", 1, paramString2 + " error.", paramString1);
      handleNativeResponseFail(paramInt, paramString2, null, "");
    }
  }
  
  private void handleQQPay(Activity paramActivity, String paramString1, String paramString2, JSONObject paramJSONObject, int paramInt)
  {
    String str1 = paramJSONObject.optString("prepayId", "");
    JSONObject localJSONObject = paramJSONObject.getJSONObject("payInfo");
    if (MiniLog.isColorLevel(paramString1)) {
      MiniLog.d("PayJsPlugin", 2, paramString1, "handleQQPay seq = " + paramInt + " appid=" + paramString1 + " payInfo = " + localJSONObject);
    }
    paramJSONObject = localJSONObject.optString("miniAppId", "");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    for (;;)
    {
      paramJSONObject = localJSONObject.optString("bargainor_id", "");
      String str2 = localJSONObject.optString("channel", "");
      localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", str1);
      localJSONObject.put("comeForm", 9);
      localJSONObject.put("appInfo", "appid#" + paramString1 + "|bargainor_id#" + paramJSONObject + "|channel#" + str2);
      paramString1 = new Bundle();
      paramString1.putString("payparmas_callback_sn", String.valueOf(paramInt));
      paramString1.putString("payparmas_json", localJSONObject.toString());
      paramString1.putInt("payparmas_paytype", 1);
      paramString1.putLong("payparmas_h5_start", System.currentTimeMillis());
      if (PayBridgeActivity.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface(), paramActivity, this.payRecevicer, 9, paramString1).getInt("retCode", -1) != 0) {
        handleNativeResponseFail(paramInt, paramString2, null, "");
      }
      return;
      paramString1 = paramJSONObject;
    }
  }
  
  private void handleWxPayment(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    String str1;
    try
    {
      paramString2 = new JSONObject(paramString2);
      str1 = paramString2.optString("url");
      paramString2 = paramString2.optString("referer");
      QLog.i("PayJsPlugin", 2, "handleWxPayment, url=" + str1);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(paramString2)))
      {
        handleNativeResponseFail(paramInt, paramString1, null, "url or referer is empty, please check!");
        QLog.i("PayJsPlugin", 1, "handleWxPayment, url=" + str1 + ", referer=" + paramString2);
        return;
      }
      if ((!URLUtil.isHttpsUrl(str1)) && (!URLUtil.isHttpUrl(str1)))
      {
        handleNativeResponseFail(paramInt, paramString1, null, "url is not http url, please check!");
        QLog.i("PayJsPlugin", 1, "handleWxPayment, url=" + str1);
        return;
      }
    }
    catch (Exception paramString2)
    {
      QLog.i("PayJsPlugin", 1, "handleWxPayment error", paramString2);
      handleNativeResponseFail(paramInt, paramString1, null, "");
      return;
    }
    String str2 = this.jsPluginEngine.appBrandRuntime.appId;
    MiniAppCmdUtil.getInstance().checkWxPayUrl(str2, str1, new PayJsPlugin.8(this, str1, paramString2, paramJsRuntime, paramString1, paramInt));
    paramJsRuntime = "";
    paramString2 = paramJsRuntime;
    int i;
    long l;
    if (this.jsPluginEngine != null)
    {
      paramString2 = paramJsRuntime;
      if (this.jsPluginEngine.appBrandRuntime != null)
      {
        paramString2 = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
        if ((paramString2 == null) || (paramString2.appConfig == null) || (paramString2.appConfig.launchParam == null) || (paramString2.appConfig.launchParam.entryModel == null)) {
          break label395;
        }
        i = paramString2.appConfig.launchParam.entryModel.type;
        l = paramString2.appConfig.launchParam.entryModel.uin;
        if (i != 1) {
          break label409;
        }
      }
    }
    label395:
    label409:
    for (paramString2 = String.valueOf(l);; paramString2 = "")
    {
      QLog.i("PayJsPlugin", 1, "report 4329 type=" + i + ", uin=" + l);
      for (;;)
      {
        MiniProgramLpReportDC04239.reportWithGroupId("wechat_pay", "launch_wechatpay", "", str1, paramString2);
        return;
        QLog.i("PayJsPlugin", 1, "no groupId");
        paramString2 = paramJsRuntime;
      }
    }
  }
  
  private String processPayByH5Param(JSONObject paramJSONObject)
  {
    String str2 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_pay_by_h5_url", "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&zoneId={zoneId}&buyQuantity={buyQuantity}&isCanChange={isCanChange}&currencyType={currencyType}&platform={platform}&remark={remark}&numberVisible={numberVisible}&other={other}&acctType={acctType}&firstRefer={firstRefer}&firstVia={firstVia}&refer={refer}&via={via}&_proxy=1&_wv=17301504&_wwv=1");
    if (((this.jsPluginEngine.getActivityContext() instanceof GameActivity)) && (((GameActivity)this.jsPluginEngine.getActivityContext()).getIsOrientationLandscape())) {
      str2 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_pay_by_h5_url_landscape", "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&zoneId={zoneId}&buyQuantity={buyQuantity}&isCanChange={isCanChange}&currencyType={currencyType}&platform={platform}&remark={remark}&numberVisible={numberVisible}&other={other}&acctType={acctType}&firstRefer={firstRefer}&firstVia={firstVia}&refer={refer}&via={via}&_proxy=1&_wv=17303552&_wwv=1");
    }
    for (;;)
    {
      Object localObject2 = "";
      String str1 = "";
      Object localObject1 = localObject2;
      if (this.jsPluginEngine != null)
      {
        localObject1 = localObject2;
        if (this.jsPluginEngine.appBrandRuntime != null)
        {
          localObject1 = localObject2;
          if (this.jsPluginEngine.appBrandRuntime.getApkgInfo() != null)
          {
            localObject1 = localObject2;
            if (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null)
            {
              localObject1 = localObject2;
              if (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam != null) {
                localObject1 = String.valueOf(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.scene);
              }
            }
          }
        }
      }
      localObject2 = this.jsPluginEngine.getAppInfo();
      if (localObject2 != null) {
        str1 = ((MiniAppInfo)localObject2).via;
      }
      String str8 = paramJSONObject.optString("prepayId", "");
      int i = paramJSONObject.optInt("starCurrency");
      String str9 = paramJSONObject.optString("offerId", "");
      String str10 = paramJSONObject.optString("zoneId", "");
      String str11 = paramJSONObject.optString("acctType", "");
      int j = paramJSONObject.optInt("saveValue");
      boolean bool1 = paramJSONObject.optBoolean("isCanChange");
      String str5 = paramJSONObject.optString("currencyType", "");
      String str6 = paramJSONObject.optString("platform", "");
      String str7 = paramJSONObject.optString("remark", "");
      paramJSONObject.optString("aid", "");
      boolean bool2 = paramJSONObject.optBoolean("numberVisible");
      localObject2 = paramJSONObject.optString("other", "");
      int k = paramJSONObject.optInt("setEnv");
      String str3 = paramJSONObject.optString("firstRefer", "");
      String str4 = paramJSONObject.optString("firstVia", "");
      str2 = str2.replace("{prepayId}", str8).replace("{starCurrency}", i + "").replace("{offerId}", str9).replace("{setEnv}", k + "").replace("{appid}", getAppId()).replace("{acctType}", str11).replace("{zoneId}", str10).replace("{buyQuantity}", j + "");
      if (bool1)
      {
        paramJSONObject = "1";
        str2 = str2.replace("{isCanChange}", paramJSONObject).replace("{currencyType}", str5).replace("{platform}", str6).replace("{remark}", str7);
        if (!bool2) {
          break label592;
        }
      }
      label592:
      for (paramJSONObject = "1";; paramJSONObject = "0")
      {
        return str2.replace("{numberVisible}", paramJSONObject).replace("{other}", (CharSequence)localObject2).replace("{firstRefer}", str3).replace("{firstVia}", str4).replace("{refer}", (CharSequence)localObject1).replace("{via}", str1);
        paramJSONObject = "0";
        break;
      }
    }
  }
  
  private void putAid(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "null";
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "null";
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = "null";
    }
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString3 = "null";
    }
    paramString4 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString4 = "null";
    }
    paramString1 = String.format("%s-%s-%s-%s-%s", new Object[] { str, paramString1, paramString2, paramString3, paramString4 });
    try
    {
      paramJSONObject.put("aid", paramString1);
      label124:
      QLog.d("PayJsPlugin", 1, "putAid, aid = " + paramString1);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label124;
    }
  }
  
  private void startPayBrowser(Activity paramActivity, String paramString1, String paramString2, JsRuntime paramJsRuntime, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    paramString1 = new Bundle();
    paramString1.putBoolean("hide_more_button", true);
    paramString1.putBoolean("keyForForceCloseAfterJump", true);
    localIntent.putExtra("big_brother_source_key", "biz_src_miniapp");
    localIntent.putExtra("fragmentClass", MiniAppWebviewFragment.class);
    localIntent.putExtras(paramString1);
    paramString1 = new HashMap();
    paramString1.put("Referer", paramString2);
    localIntent.putExtra("key_header", paramString1);
    MiniAppController.getInstance().setActivityResultListener(new PayJsPlugin.9(this, paramInt, paramJsRuntime, paramString3));
    if (paramActivity != null) {
      paramActivity.startActivityForResult(localIntent, 3005);
    }
  }
  
  private void startPayBrowserActivity(Activity paramActivity, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, JSONObject paramJSONObject)
  {
    paramJSONObject = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
    paramJSONObject.putExtra("url", paramString1);
    paramString1 = new Bundle();
    paramString1.putBoolean("hide_left_button", true);
    paramString1.putBoolean("hide_more_button", true);
    paramJSONObject.putExtras(paramString1);
    paramString1 = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.jsPluginEngine.appBrandRuntime.activity);
    if (paramString1 != null) {}
    for (paramString1 = paramString1.getGameInfoManager().getMiniAppConfig();; paramString1 = null)
    {
      MiniAppController.getInstance().setActivityResultListener(new PayJsPlugin.10(this, paramInt, paramString1, paramJsRuntime, paramString2));
      paramActivity.startActivityForResult(paramJSONObject, 3003);
      return;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("PayJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    Object localObject = new BridgeInfo(paramJsRuntime, paramInt);
    if (this.bridgeMap != null) {
      this.bridgeMap.put(Integer.valueOf(paramInt), localObject);
    }
    if ("requestPayment".equals(paramString1)) {
      MiniAppController.getInstance().setActivityResultListener(new PayJsPlugin.3(this, paramInt, paramString1));
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        handleQQPay(this.jsPluginEngine.getActivityContext(), this.jsPluginEngine.appBrandRuntime.appId, paramString1, paramString2, paramInt);
        return "";
      }
      catch (Exception paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PayJsPlugin", 2, paramString1 + " error,", paramString2);
        }
        handleNativeResponseFail(paramInt, paramString1, null, "");
        continue;
      }
      if ("requestMidasPayment".equals(paramString1))
      {
        try
        {
          paramString2 = new JSONObject(paramString2);
          paramJsRuntime = paramString2.optString("offerId");
          paramString2.put("userId", AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getCurrentAccountUin());
          paramString2.put("comeForm", 9);
          MiniAppCmdUtil.getInstance().checkOfferId(this.jsPluginEngine.appBrandRuntime.appId, paramJsRuntime, null, new PayJsPlugin.4(this, paramString2, paramString1, paramInt));
        }
        catch (Exception paramString2)
        {
          QLog.e("PayJsPlugin", 1, paramString1 + " error,", paramString2);
          handleNativeResponseFail(paramInt, paramString1, null, "");
        }
      }
      else
      {
        int i;
        int j;
        int k;
        int m;
        if ("consumeStarCurrency".equals(paramString1))
        {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramJsRuntime = paramString2.optString("prepayId");
            i = paramString2.optInt("starCurrency");
            j = paramString2.optInt("balanceAmount");
            k = paramString2.optInt("topupAmount");
            m = paramString2.optInt("payChannel");
            int n = paramString2.optInt("setEnv", 0);
            invokeMidasConsume(this.jsPluginEngine.appBrandRuntime.appId, paramJsRuntime, i, j, k, m, null, paramString1, paramInt, n);
          }
          catch (JSONException paramString2)
          {
            QLog.e("PayJsPlugin", 1, "consumestarcurrency error = ", paramString2);
            paramString2 = new JSONObject();
            try
            {
              paramString2.put("resultCode", 1000);
              handleNativeResponseFail(paramInt, paramString1, paramString2, anzj.a(2131706788));
            }
            catch (JSONException paramString1)
            {
              QLog.e("PayJsPlugin", 1, "handleNativeResponse error = ", paramString1);
            }
          }
        }
        else if ("queryStarCurrency".equals(paramString1))
        {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramJsRuntime = paramString2.optString("prepayId");
            i = paramString2.optInt("starCurrency");
            j = paramString2.optInt("setEnv", 0);
            this.miniGameAutoConsume = false;
            invokeMidasQuery(paramJsRuntime, this.jsPluginEngine.appBrandRuntime.appId, i, null, paramString1, paramInt, j);
          }
          catch (JSONException paramString2)
          {
            QLog.e("PayJsPlugin", 1, "querystarcurrency error = ", paramString2);
            paramString2 = new JSONObject();
            try
            {
              paramString2.put("resultCode", 1000);
              handleNativeResponseFail(paramInt, paramString1, null, anzj.a(2131706786));
            }
            catch (JSONException paramString1)
            {
              QLog.e("PayJsPlugin", 1, "handleNativeResponse error = ", paramString1);
            }
          }
        }
        else
        {
          if (("rechargeStarCurrency".equals(paramString1)) || ("rechargeAndConsumeStarCurrency".equals(paramString1)))
          {
            if ("rechargeAndConsumeStarCurrency".equals(paramString1)) {
              this.miniGameAutoConsume = true;
            }
            for (;;)
            {
              try
              {
                localObject = new JSONObject(paramString2);
                String str = ((JSONObject)localObject).optString("prepayId", null);
                i = ((JSONObject)localObject).optInt("balanceAmount", -1);
                j = ((JSONObject)localObject).optInt("topupAmount", -1);
                k = ((JSONObject)localObject).optInt("starCurrency", -1);
                m = ((JSONObject)localObject).optInt("setEnv", 0);
                paramJsRuntime = ((JSONObject)localObject).optString("aid", "");
                paramString2 = paramJsRuntime;
                if (!TextUtils.isEmpty(paramJsRuntime))
                {
                  paramString2 = paramJsRuntime;
                  if (paramJsRuntime.contains("{appid}")) {
                    paramString2 = paramJsRuntime.replace("{appid}", this.jsPluginEngine.appBrandRuntime.appId);
                  }
                }
                ((JSONObject)localObject).put("userId", AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getCurrentAccountUin());
                ((JSONObject)localObject).put("aid", paramString2);
                ((JSONObject)localObject).put("comeForm", 9);
                ((JSONObject)localObject).put("setMidasEnv", m);
                if ((this.jsPluginEngine.getActivityContext() instanceof GameActivity))
                {
                  paramString2 = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.jsPluginEngine.appBrandRuntime.activity);
                  if (paramString2 == null) {
                    break label1137;
                  }
                  paramString2 = paramString2.getGameInfoManager().getMiniAppConfig();
                  if ((paramString2 != null) && (paramString2.config != null))
                  {
                    paramString2 = this.jsPluginEngine.appBrandRuntime.appId + "_" + paramString2.config.verType;
                    paramJsRuntime = bjtz.b(paramString2);
                    AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", paramJsRuntime).commit();
                    ((JSONObject)localObject).put("miniAppVertypeStr", paramString2);
                  }
                }
                paramJsRuntime = String.valueOf(paramInt);
                paramString2 = paramJsRuntime;
                if (i != -1)
                {
                  paramString2 = paramJsRuntime;
                  if (j != -1)
                  {
                    paramString2 = paramJsRuntime;
                    if (k != -1)
                    {
                      paramString2 = new JSONObject();
                      paramString2.put("appId", this.jsPluginEngine.appBrandRuntime.appId);
                      paramString2.put("prepayId", str);
                      paramString2.put("balanceAmount", i);
                      paramString2.put("topupAmount", j);
                      paramString2.put("starCurrency", k);
                      paramString2.put("seq", paramInt);
                      paramString2.put("setEnv", m);
                      paramString2 = paramString2.toString();
                    }
                  }
                }
                handleRechargeGame(this.jsPluginEngine.getActivityContext(), paramString1, ((JSONObject)localObject).toString(), paramString2, paramInt, this.miniGameAutoConsume);
              }
              catch (JSONException paramString1)
              {
                QLog.e("PayJsPlugin", 1, "API_RECHARGE_STAR_CURRENCY JSONException ", paramString1);
              }
              break;
              label1137:
              paramString2 = null;
            }
          }
          if ("requestMidasGoodsPay".equals(paramString1))
          {
            try
            {
              paramString2 = new JSONObject(paramString2);
              paramString2.put("userId", AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getCurrentAccountUin());
              handleMidasGoodsPay(this.jsPluginEngine.getActivityContext(), paramString1, paramString2, paramInt);
            }
            catch (JSONException paramString2)
            {
              QLog.e("PayJsPlugin", 1, paramString1 + " error.", paramString2);
              handleNativeResponseFail(paramInt, paramString1, null, "");
            }
          }
          else if ("requestMidasMonthCardPay".equals(paramString1))
          {
            try
            {
              paramString2 = new JSONObject(paramString2);
              paramString2.put("userId", AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getCurrentAccountUin());
              handleMidasMonthCardPay(this.jsPluginEngine.getActivityContext(), paramString1, paramString2.toString(), paramInt);
            }
            catch (JSONException paramString1)
            {
              paramString1.printStackTrace();
            }
          }
          else if ("requestMidasPaymentByH5".equals(paramString1))
          {
            try
            {
              paramString2 = new JSONObject(paramString2);
              localObject = processPayByH5Param(paramString2);
              startPayBrowserActivity(this.jsPluginEngine.getActivityContext(), (String)localObject, paramJsRuntime, paramString1, paramInt, paramString2);
            }
            catch (JSONException paramString1)
            {
              paramString1.printStackTrace();
            }
          }
          else if ("checkH5PayStatus".equals(paramString1))
          {
            paramString2 = new JSONObject();
            try
            {
              paramString2.put("resultCode", QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_pay_by_h5", 0));
              handleNativeResponseOk(paramInt, paramString1, paramString2);
            }
            catch (JSONException paramJsRuntime)
            {
              for (;;)
              {
                paramJsRuntime.printStackTrace();
              }
            }
          }
          else if ("requestFriendPayment".equals(paramString1))
          {
            handlePayByFriend(paramString2, paramString1, paramJsRuntime, paramInt);
          }
          else if ("requestWxPayment".equals(paramString1))
          {
            handleWxPayment(paramString1, paramString2, paramJsRuntime, paramInt);
          }
          else if ("requestMidasCoinPaymentByH5".equals(paramString1))
          {
            handlePayCoinByH5(paramString2, paramString1, paramJsRuntime, paramInt);
          }
        }
      }
    }
  }
  
  public void handleRechargeGame(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppBrandTask.runTaskOnUiThread(new PayJsPlugin.11(this, paramString3, paramString2, paramBoolean, paramInt, paramString1, paramActivity));
  }
  
  public void invokeMidasConsume(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, COMM.StCommonExt paramStCommonExt, String paramString3, int paramInt5, int paramInt6)
  {
    QLog.d("PayJsPlugin", 1, "invokeMidasConsume prepayId= " + paramString2 + " starCurrency=" + String.valueOf(paramInt1));
    if ((TextUtils.isEmpty(paramString2)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", -4);
        paramString1.put("resultMsg", anzj.a(2131706785));
        handleNativeResponseFail(paramInt5, paramString3, paramString1, "");
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("PayJsPlugin", 1, "invokeMidasConsume JSONException ", paramString1);
        return;
      }
    }
    MiniAppCmdUtil.getInstance().getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramStCommonExt, new PayJsPlugin.13(this, paramInt5, paramString3));
  }
  
  public void invokeMidasQuery(String paramString1, String paramString2, int paramInt1, COMM.StCommonExt paramStCommonExt, String paramString3, int paramInt2, int paramInt3)
  {
    QLog.d("PayJsPlugin", 1, "invokeMidasQuery prepayId= " + paramString1 + " starCurrency=" + String.valueOf(paramInt1) + " setEnv:" + paramInt3);
    if ((TextUtils.isEmpty(paramString1)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", 1000);
        handleNativeResponseFail(paramInt2, paramString3, null, anzj.a(2131706787));
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("PayJsPlugin", 1, "invokeMidasQuery JSONException ", paramString1);
        return;
      }
    }
    MiniAppCmdUtil.getInstance().getMidasQueryResult(paramString1, paramString2, paramInt1, paramInt3, paramStCommonExt, new PayJsPlugin.12(this, paramInt2, paramString3));
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.bridgeMap = new ConcurrentHashMap();
    this.payRecevicer = new PayJsPlugin.PayResultRecevicer(this, new Handler(Looper.getMainLooper()));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.bridgeMap != null) {
      this.bridgeMap.clear();
    }
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */