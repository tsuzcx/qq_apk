package com.tencent.qqmini.sdk.plugins;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.PayResponse;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class PayJsPlugin
  extends BaseJsPlugin
{
  public static final int COME_FROM_MINI = 9;
  public static final String KEY_MINI_GAME_PAY_ENV = "keyMiniGamePayEnv";
  public static final String KEY_MINI_GAME_PAY_ENV_APPID_VERTYPE = "keyMiniGamePayEnvAppidVertype";
  public static final String PAYJSON_KEY_MINI_APP_VERTYPE_STR = "miniAppVertypeStr";
  public static final String PAYJSON_KEY_SET_MIDAS_ENV = "setMidasEnv";
  public static final int PAY_CHANNEL_WECHAT = 8;
  public static final int PAY_DISABLE = 2;
  public static final int PAY_ENABLE = 1;
  public static final int PAY_TYPE_BUILDIN_H5 = 1;
  public static final int PAY_UNKNOWN = 0;
  public static final int SET_MIDAS_ENV_VAL_RELEASE = 0;
  public static final int SET_MIDAS_ENV_VAL_TEST = 1;
  private static final String TAG = "PayJsPlugin";
  private static final int TMP_MODE_FOR_H5 = 0;
  public static final String URL_PAY_BY_H5 = WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5_url", "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&zoneId={zoneId}&buyQuantity={buyQuantity}&isCanChange={isCanChange}&currencyType={currencyType}&platform={platform}&remark={remark}&numberVisible={numberVisible}&other={other}&acctType={acctType}&aid={aid}&firstRefer={firstRefer}&firstVia={firstVia}&refer={refer}&via={via}&_proxy=1&_wv=17301504&_wwv=1");
  public static final String URL_PAY_BY_H5_LANDSCAPE = WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5_url_landscape", "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&zoneId={zoneId}&buyQuantity={buyQuantity}&isCanChange={isCanChange}&currencyType={currencyType}&platform={platform}&remark={remark}&numberVisible={numberVisible}&other={other}&acctType={acctType}&aid={aid}&firstRefer={firstRefer}&firstVia={firstVia}&refer={refer}&via={via}&_proxy=1&_wv=17303552&_wwv=1");
  protected String mRealOfferId = "";
  
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
  
  private void checkWxPayUrl(RequestEvent paramRequestEvent, String paramString1, String paramString2, String paramString3)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).checkWxPayUrl(paramString3, paramString1, new PayJsPlugin.3(this, paramString1, paramString2, paramRequestEvent));
  }
  
  @NotNull
  private PayProxy.IPayResultCallBack getIPayResultCallBack(RequestEvent paramRequestEvent, boolean paramBoolean, String paramString)
  {
    return new PayJsPlugin.15(this, paramRequestEvent, paramBoolean, paramString);
  }
  
  private int getPayChannel(PayProxy.PayResponse paramPayResponse)
  {
    if (paramPayResponse.getPayChannel() == 8) {
      return 2;
    }
    return 3;
  }
  
  private String getSDKH5Url(String paramString)
  {
    Object localObject1 = paramString;
    if (!QUAUtil.isQQApp())
    {
      Object localObject2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName();
      localObject1 = localObject2;
      if (this.mMiniAppInfo != null)
      {
        localObject1 = localObject2;
        if (this.mMiniAppInfo.launchParam != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("_");
          ((StringBuilder)localObject1).append(this.mMiniAppInfo.launchParam.scene);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      String str = LoginManager.getInstance().getAccount();
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = "null";
      }
      paramString = new StringBuilder(paramString);
      str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
      paramString.append("&");
      paramString.append("refer=");
      paramString.append((String)localObject1);
      paramString.append("&");
      paramString.append("shareuid=");
      paramString.append((String)localObject2);
      paramString.append("&");
      paramString.append("platform=");
      paramString.append(str);
      paramString.append("&");
      paramString.append("fromSDK=1");
      localObject1 = paramString.toString();
    }
    return localObject1;
  }
  
  private String getSDKPf(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = "null";
    if (!bool) {
      try
      {
        paramString = new JSONObject(paramString).optString("prepayId");
        try
        {
          bool = TextUtils.isEmpty(paramString);
          if (!bool) {
            break label64;
          }
        }
        catch (JSONException localJSONException1) {}
        localJSONException2.printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        paramString = "null";
      }
    } else {
      paramString = "null";
    }
    label64:
    Object localObject3 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName();
    Object localObject1 = localObject3;
    if (this.mMiniAppInfo != null)
    {
      localObject1 = localObject3;
      if (this.mMiniAppInfo.launchParam != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(this.mMiniAppInfo.launchParam.scene);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localObject3 = LoginManager.getInstance().getAccount();
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = localObject3;
    }
    int i = LoginManager.getInstance().getLoginType();
    if ((i != 2) && (i != 3))
    {
      if (i == 1)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("qq_m_wx-20031-android-2011-");
        ((StringBuilder)localObject3).append(this.mMiniAppInfo.appId);
        ((StringBuilder)localObject3).append("-");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append("-");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("-");
        ((StringBuilder)localObject3).append((String)localObject2);
        return ((StringBuilder)localObject3).toString();
      }
      return "";
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("qq_m_qq-20031-android-2011-");
    ((StringBuilder)localObject3).append(this.mMiniAppInfo.appId);
    ((StringBuilder)localObject3).append("-");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("-");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("-");
    ((StringBuilder)localObject3).append((String)localObject2);
    return ((StringBuilder)localObject3).toString();
  }
  
  @NotNull
  private PayJsPlugin.IStarQueryListener getStarQueryListener(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, RequestEvent paramRequestEvent)
  {
    return new PayJsPlugin.16(this, paramRequestEvent, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  private void handleMidasGoodsPay(Activity paramActivity, JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    Object localObject1 = paramJSONObject.optString("offerId", "");
    Object localObject3 = paramJSONObject.getJSONObject("payInfo");
    Object localObject2 = paramJSONObject.getString("userId");
    String str1 = ((JSONObject)localObject3).getString("tokenUrl");
    String str2 = ((JSONObject)localObject3).optString("aid", "");
    String str3 = ((JSONObject)localObject3).optString("zoneId", "1");
    String str4 = ((JSONObject)localObject3).optString("numberVisible", "");
    String str5 = ((JSONObject)localObject3).optString("unit", "");
    String str6 = ((JSONObject)localObject3).optString("discountId", "");
    localObject3 = ((JSONObject)localObject3).optString("other", "");
    int i = paramRequestEvent.callbackId;
    paramJSONObject = new JSONObject();
    paramJSONObject.put("offerId", localObject1);
    paramJSONObject.put("userId", localObject2);
    paramJSONObject.put("tokenUrl", str1);
    paramJSONObject.put("zoneId", str3);
    paramJSONObject.put("numberVisible", str4);
    paramJSONObject.put("unit", str5);
    paramJSONObject.put("aid", str2);
    paramJSONObject.put("discountId", str6);
    paramJSONObject.put("other", localObject3);
    paramJSONObject.put("comeForm", 9);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("payparmas_callback_sn", String.valueOf(i));
    ((Bundle)localObject1).putString("payparmas_json", paramJSONObject.toString());
    ((Bundle)localObject1).putInt("payparmas_paytype", 1);
    ((Bundle)localObject1).putLong("payparmas_h5_start", System.currentTimeMillis());
    ((Bundle)localObject1).putInt("payparmas_request_code", 7);
    ((Bundle)localObject1).putString("payparmas_sdk_pf", getSDKPf(paramJSONObject.toString()));
    if (paramActivity != null)
    {
      localObject2 = (PayProxy)ProxyManager.get(PayProxy.class);
      if (localObject2 == null)
      {
        handleNativeResponseFail(paramRequestEvent, null, "not support pay");
        return;
      }
      paramActivity = ((PayProxy)localObject2).midasPay(paramActivity, paramJSONObject.toString(), new PayJsPlugin.12(this, paramRequestEvent), (Bundle)localObject1);
    }
    else
    {
      paramActivity = null;
    }
    i = 0;
    if (paramActivity != null) {
      i = paramActivity.getInt("retCode", 0);
    }
    if ((paramActivity != null) && (i != 0)) {
      handleNativeResponseFail(paramRequestEvent, null, "");
    }
  }
  
  private void handleMidasMonthCardPay(Activity paramActivity, String paramString, RequestEvent paramRequestEvent)
  {
    int i = paramRequestEvent.callbackId;
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", String.valueOf(i));
    localBundle.putString("payparmas_json", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", System.currentTimeMillis());
    localBundle.putInt("payparmas_request_code", 14);
    localBundle.putString("payparmas_sdk_pf", getSDKPf(paramString));
    if (paramActivity != null)
    {
      PayProxy localPayProxy = (PayProxy)ProxyManager.get(PayProxy.class);
      if (localPayProxy == null)
      {
        handleNativeResponseFail(paramRequestEvent, null, "not support pay");
        return;
      }
      paramActivity = localPayProxy.midasPay(paramActivity, paramString, new PayJsPlugin.11(this, paramRequestEvent), localBundle);
    }
    else
    {
      paramActivity = null;
    }
    i = 0;
    if (paramActivity != null) {
      i = paramActivity.getInt("retCode", 0);
    }
    if ((paramActivity != null) && (i != 0)) {
      handleNativeResponseFail(paramRequestEvent, null, "");
    }
  }
  
  private void handleNativeResponseCancel(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (paramRequestEvent != null) {
      paramRequestEvent.cancel(paramJSONObject);
    }
  }
  
  private void handleNativeResponseFail(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    if (paramRequestEvent != null) {
      paramRequestEvent.fail(paramJSONObject, paramString);
    }
  }
  
  private void handleNativeResponseOk(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (paramRequestEvent != null) {
      paramRequestEvent.ok(paramJSONObject);
    }
  }
  
  private void handlePayResultSuc(JSONObject paramJSONObject, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, RequestEvent paramRequestEvent)
  {
    if (paramBoolean)
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramInt3 != -1) && (paramInt2 != -1) && (paramInt1 != -1) && (paramInt5 != -1))
      {
        invokeMidasConsume(paramRequestEvent, paramString1, paramString2, paramInt3, paramInt1, paramInt2, paramInt5, paramInt4);
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("handleRechargeGame onPayCallBack, , consumeAppid = ");
      paramJSONObject.append(paramString1);
      paramJSONObject.append(", consumePrepayId = ");
      paramJSONObject.append(paramString2);
      paramJSONObject.append(", consumeStarCurrency = ");
      paramJSONObject.append(paramInt3);
      paramJSONObject.append(", consumeTopupAmount = ");
      paramJSONObject.append(paramInt2);
      paramJSONObject.append(", consumeBalanceAmount = ");
      paramJSONObject.append(paramInt1);
      paramJSONObject.append(", payChannel = ");
      paramJSONObject.append(paramInt5);
      QMLog.i("PayJsPlugin", paramJSONObject.toString());
      return;
    }
    handleNativeResponseOk(paramRequestEvent, paramJSONObject);
  }
  
  private void handleQQPay(RequestEvent paramRequestEvent)
  {
    Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
    Object localObject3 = ((JSONObject)localObject1).optString("prepayId", "");
    Object localObject5 = ((JSONObject)localObject1).getJSONObject("payInfo");
    Object localObject2 = ((JSONObject)localObject5).optString("miniAppId", "");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.mApkgInfo.appId;
    }
    Object localObject4 = ((JSONObject)localObject5).optString("bargainor_id", "");
    localObject5 = ((JSONObject)localObject5).optString("channel", "");
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("tokenId", localObject3);
    ((JSONObject)localObject2).put("comeForm", 9);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("appid#");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("|bargainor_id#");
    ((StringBuilder)localObject3).append((String)localObject4);
    ((StringBuilder)localObject3).append("|channel#");
    ((StringBuilder)localObject3).append((String)localObject5);
    ((JSONObject)localObject2).put("appInfo", ((StringBuilder)localObject3).toString());
    int i = paramRequestEvent.callbackId;
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("payparmas_callback_sn", String.valueOf(i));
    ((Bundle)localObject3).putString("payparmas_json", ((JSONObject)localObject2).toString());
    ((Bundle)localObject3).putInt("payparmas_paytype", 1);
    ((Bundle)localObject3).putLong("payparmas_h5_start", System.currentTimeMillis());
    ((Bundle)localObject3).putInt("payparmas_request_code", 9);
    ((Bundle)localObject3).putString("payparmas_sdk_pf", getSDKPf(((JSONObject)localObject2).toString()));
    if (this.mMiniAppContext != null) {
      localObject1 = this.mMiniAppContext.getAttachedActivity();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject4 = (PayProxy)ProxyManager.get(PayProxy.class);
      if (localObject4 == null)
      {
        handleNativeResponseFail(paramRequestEvent, null, "not support pay");
        return;
      }
      localObject1 = ((PayProxy)localObject4).midasPay((Activity)localObject1, ((JSONObject)localObject2).toString(), new PayJsPlugin.13(this, paramRequestEvent), (Bundle)localObject3);
    }
    else
    {
      localObject1 = null;
    }
    i = 0;
    if (localObject1 != null) {
      i = ((Bundle)localObject1).getInt("retCode", 0);
    }
    if ((localObject1 != null) && (i != 0)) {
      handleNativeResponseFail(paramRequestEvent, null, "");
    }
  }
  
  private void onPlayCallback(PayProxy.PayResponse paramPayResponse, RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", paramPayResponse.getResultCode());
      String str = paramPayResponse.getExtendInfo();
      if ((!TextUtils.isEmpty(str)) && (JSONUtil.isJson(str))) {
        localJSONObject.put("data", new JSONObject(str).optJSONObject("data"));
      }
      label65:
      if ((paramPayResponse.getResultCode() == 0) && (paramPayResponse.getPayState() == 0)) {
        handleNativeResponseOk(paramRequestEvent, localJSONObject);
      } else if ((paramPayResponse.getResultCode() != 2) && (paramPayResponse.getPayState() != 1)) {
        handleNativeResponseFail(paramRequestEvent, localJSONObject, paramPayResponse.getResultMsg());
      } else {
        handleNativeResponseCancel(paramRequestEvent, localJSONObject);
      }
      paramRequestEvent = new StringBuilder();
      paramRequestEvent.append("handleMidasGoodsPay onPayCallBack, , resultCode = ");
      paramRequestEvent.append(paramPayResponse.getResultCode());
      paramRequestEvent.append(", resultMsg = ");
      paramRequestEvent.append(paramPayResponse.getResultMsg());
      paramRequestEvent.append("extendInfo = ");
      paramRequestEvent.append(paramPayResponse.getExtendInfo());
      QMLog.i("PayJsPlugin", paramRequestEvent.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      break label65;
    }
  }
  
  private String processPayByH5Param(JSONObject paramJSONObject)
  {
    Object localObject2 = URL_PAY_BY_H5;
    if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject2 = URL_PAY_BY_H5_LANDSCAPE;
    }
    Object localObject5 = paramJSONObject.optString("prepayId", "");
    int i = paramJSONObject.optInt("starCurrency");
    Object localObject4 = paramJSONObject.optString("offerId", "");
    Object localObject3 = paramJSONObject.optString("zoneId", "");
    String str8 = paramJSONObject.optString("acctType", "");
    int j = paramJSONObject.optInt("saveValue");
    boolean bool1 = paramJSONObject.optBoolean("isCanChange");
    String str5 = paramJSONObject.optString("currencyType", "");
    String str6 = paramJSONObject.optString("platform", "");
    String str7 = paramJSONObject.optString("remark", "");
    String str1 = paramJSONObject.optString("aid", "");
    boolean bool2 = paramJSONObject.optBoolean("numberVisible");
    String str2 = paramJSONObject.optString("other", "");
    int k = paramJSONObject.optInt("setEnv");
    String str3 = paramJSONObject.optString("firstRefer", "");
    String str4 = paramJSONObject.optString("firstVia", "");
    Object localObject1 = this.mMiniAppInfo;
    if ((localObject1 != null) && (((MiniAppInfo)localObject1).launchParam != null)) {
      paramJSONObject = String.valueOf(((MiniAppInfo)localObject1).launchParam.scene);
    } else {
      paramJSONObject = "";
    }
    if (localObject1 != null) {
      localObject1 = ((MiniAppInfo)localObject1).via;
    } else {
      localObject1 = "";
    }
    localObject2 = ((String)localObject2).replace("{prepayId}", (CharSequence)localObject5);
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(i);
    ((StringBuilder)localObject5).append("");
    localObject2 = ((String)localObject2).replace("{starCurrency}", ((StringBuilder)localObject5).toString()).replace("{offerId}", (CharSequence)localObject4);
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(k);
    ((StringBuilder)localObject4).append("");
    localObject2 = ((String)localObject2).replace("{setEnv}", ((StringBuilder)localObject4).toString()).replace("{appid}", this.mMiniAppInfo.appId).replace("{acctType}", str8).replace("{zoneId}", (CharSequence)localObject3);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(j);
    ((StringBuilder)localObject3).append("");
    str8 = ((String)localObject2).replace("{buyQuantity}", ((StringBuilder)localObject3).toString());
    localObject3 = "1";
    if (bool1) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    str5 = str8.replace("{isCanChange}", (CharSequence)localObject2).replace("{currencyType}", str5).replace("{platform}", str6).replace("{remark}", str7);
    if (bool2) {
      localObject2 = localObject3;
    } else {
      localObject2 = "0";
    }
    return str5.replace("{numberVisible}", (CharSequence)localObject2).replace("{other}", str2).replace("{aid}", str1).replace("{firstRefer}", str3).replace("{firstVia}", str4).replace("{refer}", paramJSONObject).replace("{via}", (CharSequence)localObject1);
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
      label125:
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("putAid, aid = ");
      paramJSONObject.append(paramString1);
      QMLog.d("PayJsPlugin", paramJSONObject.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label125;
    }
  }
  
  private void reChargeStarCurrency(RequestEvent paramRequestEvent, boolean paramBoolean)
  {
    label478:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        String str = localJSONObject.optString("prepayId", null);
        int i = localJSONObject.optInt("balanceAmount", -1);
        int j = localJSONObject.optInt("topupAmount", -1);
        int k = localJSONObject.optInt("starCurrency", -1);
        int m = localJSONObject.optInt("setEnv", 0);
        Object localObject1 = localJSONObject.optString("aid", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("{appid}")))
        {
          localObject1 = ((String)localObject1).replace("{appid}", this.mApkgInfo.appId);
          localJSONObject.put("userId", LoginManager.getInstance().getAccount());
          localJSONObject.put("aid", localObject1);
          localJSONObject.put("comeForm", 9);
          localJSONObject.put("setMidasEnv", m);
          if (!this.mIsMiniGame) {
            break label478;
          }
          localObject1 = this.mMiniAppInfo;
          if (localObject1 == null) {
            break label478;
          }
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.mApkgInfo.appId);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(((MiniAppInfo)localObject1).verType);
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = MD5Utils.encodeHexStr((String)localObject1);
          this.mContext.getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", (String)localObject2).commit();
          localJSONObject.put("miniAppVertypeStr", localObject1);
          localObject2 = String.valueOf(paramRequestEvent.callbackId);
          localObject1 = localObject2;
          if (i != -1)
          {
            localObject1 = localObject2;
            if (j != -1)
            {
              localObject1 = localObject2;
              if (k != -1)
              {
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("appId", this.mApkgInfo.appId);
                ((JSONObject)localObject1).put("prepayId", str);
                ((JSONObject)localObject1).put("balanceAmount", i);
                ((JSONObject)localObject1).put("topupAmount", j);
                ((JSONObject)localObject1).put("starCurrency", k);
                ((JSONObject)localObject1).put("seq", paramRequestEvent.callbackId);
                ((JSONObject)localObject1).put("setEnv", m);
                localObject1 = ((JSONObject)localObject1).toString();
              }
            }
          }
          if (!TextUtils.isEmpty(this.mRealOfferId)) {
            localJSONObject.put("offerId", this.mRealOfferId);
          }
          handleRechargeGame(paramRequestEvent, this.mMiniAppContext.getAttachedActivity(), localJSONObject.toString(), (String)localObject1, paramBoolean);
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("PayJsPlugin", "API_RECHARGE_STAR_CURRENCY JSONException ", paramRequestEvent);
        return;
      }
    }
  }
  
  private void reportWithGroupId(String paramString)
  {
    Object localObject = this.mMiniAppInfo;
    String str = "";
    if ((localObject != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null))
    {
      int i = this.mMiniAppInfo.launchParam.entryModel.type;
      long l = this.mMiniAppInfo.launchParam.entryModel.uin;
      if (i == 1) {
        str = String.valueOf(l);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report 4329 type=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", uin=");
      ((StringBuilder)localObject).append(l);
      QMLog.i("PayJsPlugin", ((StringBuilder)localObject).toString());
    }
    else
    {
      QMLog.i("PayJsPlugin", "no groupId");
    }
    SDKMiniProgramLpReportDC04239.reportWithGroupId(this.mMiniAppInfo, "wechat_pay", "launch_wechatpay", "", paramString, str);
  }
  
  @JsEvent({"requestWxPayment"})
  private void requestWxPayment(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("url");
      localObject = ((JSONObject)localObject).optString("referer");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleWxPayment, url=");
      localStringBuilder.append(str);
      QMLog.i("PayJsPlugin", localStringBuilder.toString());
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if ((!URLUtil.isHttpsUrl(str)) && (!URLUtil.isHttpUrl(str)))
        {
          paramRequestEvent.fail("url is not http url, please check!");
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleWxPayment, url=");
          ((StringBuilder)localObject).append(str);
          QMLog.i("PayJsPlugin", ((StringBuilder)localObject).toString());
          return;
        }
        checkWxPayUrl(paramRequestEvent, str, (String)localObject, this.mMiniAppInfo.appId);
        reportWithGroupId(str);
        return;
      }
      paramRequestEvent.fail("url or referer is empty, please check!");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleWxPayment, url=");
      localStringBuilder.append(str);
      localStringBuilder.append(", referer=");
      localStringBuilder.append((String)localObject);
      QMLog.i("PayJsPlugin", localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      QMLog.i("PayJsPlugin", "handleWxPayment error", localException);
      paramRequestEvent.fail();
    }
  }
  
  private void setCookieIfNeed(Bundle paramBundle)
  {
    if (!QUAUtil.isQQApp())
    {
      int i = LoginManager.getInstance().getLoginType();
      String str2 = LoginManager.getInstance().getPayOpenId();
      String str3 = LoginManager.getInstance().getPayOpenKey();
      String str5 = LoginManager.getInstance().getPayAccessToken();
      String str4 = LoginManager.getInstance().getAppId();
      Object localObject1 = LoginManager.getInstance().getLoginSig();
      String str1 = LoginManager.getInstance().getAccount();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("openid=");
      ((StringBuilder)localObject2).append(str2);
      str2 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("openkey=");
      ((StringBuilder)localObject2).append(str3);
      str3 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("accesstoken=");
      ((StringBuilder)localObject2).append(str5);
      str5 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("login_type=");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login_appid=");
      localStringBuilder.append(str4);
      str4 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("login_sig=");
      localStringBuilder.append(new String((byte[])localObject1));
      localObject1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("login_uin=");
      localStringBuilder.append(str1);
      str1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(";");
      localStringBuilder.append(str3);
      localStringBuilder.append(";");
      localStringBuilder.append(str5);
      localStringBuilder.append(";");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(";");
      localStringBuilder.append(str4);
      localStringBuilder.append(";");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(";");
      localStringBuilder.append(str1);
      paramBundle.putString("cookie", localStringBuilder.toString());
    }
  }
  
  private void startPayBrowserActivity(Activity paramActivity, RequestEvent paramRequestEvent, String paramString)
  {
    ActivityResultManager.g().addActivityResultListener(new PayJsPlugin.6(this, paramRequestEvent));
    paramRequestEvent = new Bundle();
    setCookieIfNeed(paramRequestEvent);
    paramRequestEvent.putBoolean("hide_title_bar", true);
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    paramString = getSDKH5Url(paramString);
    localChannelProxy.startTransparentBrowserActivityForResult(paramActivity, paramString, paramRequestEvent, 3003);
    paramRequestEvent = new StringBuilder();
    paramRequestEvent.append("startPayBrowserActivity, url=");
    paramRequestEvent.append(paramString);
    QMLog.i("PayJsPlugin", paramRequestEvent.toString());
    paramRequestEvent = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ((paramRequestEvent != null) && (paramRequestEvent.isDebugVersion())) {
      AppBrandTask.runTaskOnUiThread(new PayJsPlugin.7(this, paramActivity));
    }
  }
  
  private void startWxPayBrowser(Activity paramActivity, String paramString1, String paramString2, RequestEvent paramRequestEvent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("hide_more_button", true);
    localBundle.putBoolean("keyForForceCloseAfterJump", true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("Referer", paramString2);
    localBundle.putSerializable("key_header", localHashMap);
    ActivityResultManager.g().addActivityResultListener(new PayJsPlugin.5(this, paramRequestEvent));
    paramString2 = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((paramString2 != null) && (paramActivity != null)) {
      paramString2.startBrowserSupportHeaderActivityForResult(paramActivity, paramString1, localBundle, 3005);
    }
  }
  
  @JsEvent({"checkH5PayStatus"})
  public void checkH5PayStatus(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      int i = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPayMode();
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("not support pay mode:");
            localStringBuilder.append(i);
            handleNativeResponseFail(paramRequestEvent, localJSONObject, localStringBuilder.toString());
          }
        }
        else
        {
          localJSONObject.put("resultCode", 1);
          handleNativeResponseOk(paramRequestEvent, localJSONObject);
          return;
        }
      }
      localJSONObject.put("resultCode", 0);
      handleNativeResponseOk(paramRequestEvent, localJSONObject);
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("PayJsPlugin", "checkH5PayStatus JSONException ", paramRequestEvent);
    }
  }
  
  @JsEvent({"consumeStarCurrency"})
  public void consumeStarCurrency(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject1.optString("prepayId");
      int i = localJSONObject1.optInt("starCurrency");
      int j = localJSONObject1.optInt("balanceAmount");
      int k = localJSONObject1.optInt("topupAmount");
      int m = localJSONObject1.optInt("payChannel");
      int n = localJSONObject1.optInt("setEnv", 0);
      invokeMidasConsume(paramRequestEvent, this.mApkgInfo.appId, str, i, j, k, m, n);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PayJsPlugin", "consumestarcurrency error = ", localJSONException);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("resultCode", 1000);
        handleNativeResponseFail(paramRequestEvent, localJSONObject2, "参数错误");
        return;
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("PayJsPlugin", "handleNativeResponse error = ", paramRequestEvent);
      }
    }
  }
  
  public void handleRechargeGame(RequestEvent paramRequestEvent, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      handleNativeResponseFail(paramRequestEvent, null, "activity is null");
      return;
    }
    AppBrandTask.runTaskOnUiThread(new PayJsPlugin.14(this, paramString2, paramString1, paramRequestEvent, paramActivity, paramBoolean));
  }
  
  public void invokeMidasConsume(RequestEvent paramRequestEvent, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invokeMidasConsume prepayId= ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" starCurrency=");
    ((StringBuilder)localObject).append(String.valueOf(paramInt1));
    QMLog.i("PayJsPlugin", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString2)) && (paramInt1 > 0) && (!TextUtils.isEmpty(paramString1)))
    {
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName());
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(this.mMiniAppInfo.launchParam.scene);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      String str;
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.via != null)) {
        str = this.mMiniAppInfo.via;
      } else {
        str = "";
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, (String)localObject, str, new PayJsPlugin.9(this, paramRequestEvent));
      return;
    }
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("resultCode", -4);
      paramString1.put("resultMsg", "消耗参数错误");
      handleNativeResponseFail(paramRequestEvent, paramString1, "");
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("PayJsPlugin", "invokeMidasConsume JSONException ", paramRequestEvent);
    }
  }
  
  public void invokeMidasQuery(String paramString1, String paramString2, int paramInt1, int paramInt2, PayJsPlugin.IStarQueryListener paramIStarQueryListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeMidasQuery prepayId= ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" starCurrency=");
    localStringBuilder.append(String.valueOf(paramInt1));
    localStringBuilder.append(" setEnv:");
    localStringBuilder.append(paramInt2);
    QMLog.i("PayJsPlugin", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && (paramInt1 > 0) && (!TextUtils.isEmpty(paramString2)))
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).queryCurrency(paramString1, paramString2, paramInt1, paramInt2, new PayJsPlugin.10(this, paramIStarQueryListener));
      return;
    }
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("resultCode", 1000);
      paramString1.put("errMsg", "参数错误");
      if (paramIStarQueryListener != null)
      {
        paramIStarQueryListener.onResult(false, paramString1);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      QMLog.e("PayJsPlugin", "invokeMidasQuery JSONException ", paramString1);
    }
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    Object localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localObject != null) && (((ChannelProxy)localObject).isGooglePlayVersion()))
    {
      int i = 0;
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_pay_switch", 0) == 1) {
        i = 1;
      }
      if (i == 0)
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("retCode", -123);
          ((JSONObject)localObject).put("errMsg", "googlePlay PayAPI no supported!");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        handleNativeResponseFail(paramRequestEvent, (JSONObject)localObject, "googlePlay PayAPI no supported!");
        return true;
      }
    }
    return super.onInterceptJsEvent(paramRequestEvent);
  }
  
  @JsEvent({"queryStarCurrency"})
  public void queryStarCurrency(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject1.optString("prepayId");
      int i = localJSONObject1.optInt("starCurrency");
      int j = localJSONObject1.optInt("setEnv", 0);
      invokeMidasQuery(str, this.mApkgInfo.appId, i, j, new PayJsPlugin.8(this, paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PayJsPlugin", "querystarcurrency error = ", localJSONException);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("resultCode", 1000);
        handleNativeResponseFail(paramRequestEvent, null, "参数错误");
        return;
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("PayJsPlugin", "handleNativeResponse error = ", paramRequestEvent);
      }
    }
  }
  
  @JsEvent({"rechargeAndConsumeStarCurrency"})
  public void rechargeAndConsumeStarCurrency(RequestEvent paramRequestEvent)
  {
    reChargeStarCurrency(paramRequestEvent, true);
  }
  
  @JsEvent({"rechargeStarCurrency"})
  public void rechargeStarCurrency(RequestEvent paramRequestEvent)
  {
    reChargeStarCurrency(paramRequestEvent, false);
  }
  
  @JsEvent({"requestFriendPayment"})
  public void requestFriendPayment(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject4 = ((JSONObject)localObject1).getString("prepayId");
      int i = ((JSONObject)localObject1).optInt("setEnv", 0);
      Object localObject2 = ((JSONObject)localObject1).optString("title");
      Object localObject3 = ((JSONObject)localObject1).optString("imageUrl");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = GameWnsUtils.defaultPayShareTitle();
      }
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = GameWnsUtils.defaultPayShareImg();
      }
      localObject3 = new COMM.StCommonExt();
      Object localObject5 = new COMM.Entry();
      ((COMM.Entry)localObject5).key.set("prepay_id");
      ((COMM.Entry)localObject5).value.set((String)localObject4);
      ((COMM.StCommonExt)localObject3).mapInfo.get().add(localObject5);
      localObject4 = new COMM.Entry();
      ((COMM.Entry)localObject4).key.set("set_env");
      localObject5 = ((COMM.Entry)localObject4).value;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ((PBStringField)localObject5).set(localStringBuilder.toString());
      ((COMM.StCommonExt)localObject3).mapInfo.get().add(localObject4);
      localObject4 = GetShareState.obtain(this.mMiniAppContext);
      if (this.mMiniAppInfo != null) {
        ((ShareState)localObject4).shareAppid = this.mMiniAppInfo.appId;
      }
      ((ShareState)localObject4).shareEvent = paramRequestEvent.event;
      ((ShareState)localObject4).shareCallbackId = paramRequestEvent.callbackId;
      ((ShareState)localObject4).requestEvent = paramRequestEvent;
      new InnerShareData.Builder().setShareSource(13).setShareTarget(0).setShareScene(4).setTitle(this.mMiniAppInfo.name).setSummary((String)localObject1).setEntryPath(null).setWebUrl("").setTemplateId("").setTemplateData("").setEntryModel(null).setShareChatModel(null).setWithShareTicket(false).setSharePicPath((String)localObject2).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setExtInfo((COMM.StCommonExt)localObject3).setShareInMiniProcess(true).build().shareAppMessage();
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PayJsPlugin", "requestFriendPayment error = ", localJSONException);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("resultCode", 1000);
        handleNativeResponseFail(paramRequestEvent, localJSONObject, "参数错误");
        return;
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("PayJsPlugin", "handleNativeResponse error = ", paramRequestEvent);
      }
    }
  }
  
  @JsEvent({"requestMidasCoinPaymentByH5"})
  public void requestMidasCoinPaymentByH5(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = localJSONObject.getString("offerId");
      String str2 = this.mApkgInfo.appId;
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).checkOfferId(str2, str1, new PayJsPlugin.4(this, localJSONObject, paramRequestEvent));
      return;
    }
    catch (Exception localException)
    {
      QMLog.i("PayJsPlugin", "requestMidasCoinPaymentByH5 error", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"requestMidasGoodsPay"})
  public void requestMidasGoodsPay(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = LoginManager.getInstance().getAccount();
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      ((JSONObject)localObject).put("userId", str);
      handleMidasGoodsPay(this.mMiniAppContext.getAttachedActivity(), (JSONObject)localObject, paramRequestEvent);
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRequestEvent.event);
      ((StringBuilder)localObject).append(" error.");
      QMLog.e("PayJsPlugin", ((StringBuilder)localObject).toString(), localJSONException);
      handleNativeResponseFail(paramRequestEvent, null, "");
    }
  }
  
  @JsEvent({"requestMidasMonthCardPay"})
  public void requestMidasMonthCardPay(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = LoginManager.getInstance().getAccount();
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      localJSONObject.put("userId", str);
      handleMidasMonthCardPay(this.mMiniAppContext.getAttachedActivity(), localJSONObject.toString(), paramRequestEvent);
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"requestMidasPayment"})
  public void requestMidasPayment(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = localJSONObject.optString("offerId");
      localJSONObject.put("userId", LoginManager.getInstance().getAccount());
      localJSONObject.put("comeForm", 9);
      String str2 = this.mApkgInfo.appId;
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).checkOfferId(str2, str1, new PayJsPlugin.2(this, localJSONObject, paramRequestEvent));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PayJsPlugin", " error,", localException);
      handleNativeResponseFail(paramRequestEvent, null, "");
    }
  }
  
  @JsEvent({"requestMidasPaymentByH5"})
  public void requestMidasPaymentByH5(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = processPayByH5Param(new JSONObject(paramRequestEvent.jsonParams));
      startPayBrowserActivity(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent, str);
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"requestPayment"})
  public void requestPayment(RequestEvent paramRequestEvent)
  {
    ActivityResultManager.g().addActivityResultListener(new PayJsPlugin.1(this, paramRequestEvent));
    try
    {
      handleQQPay(paramRequestEvent);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error,");
      QMLog.e("PayJsPlugin", localStringBuilder.toString(), localException);
      handleNativeResponseFail(paramRequestEvent, null, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */