package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import bgho;
import bgjd;
import bgjw;
import bgkd;
import bgkk;
import bglq;
import bgte;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.MD5Utils;
import org.json.JSONException;
import org.json.JSONObject;

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
  public static final String URL_PAY_BY_H5 = bglq.a("qqminiapp", "mini_game_pay_by_h5_url", "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&_proxy=1&_wv=17301504");
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
  
  private String getSDKPf(String paramString)
  {
    Object localObject2 = "null";
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString)) {
      localObject1 = localObject2;
    }
    int i;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString).optString("prepayId");
        paramString = (String)localObject2;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString = "null";
        }
        localObject2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName();
        localObject1 = localObject2;
        if (this.mMiniAppInfo != null)
        {
          localObject1 = localObject2;
          if (this.mMiniAppInfo.launchParam != null) {
            localObject1 = (String)localObject2 + "_" + this.mMiniAppInfo.launchParam.scene;
          }
        }
        String str = bgte.a().a();
        localObject2 = str;
        if (TextUtils.isEmpty(str)) {
          localObject2 = "null";
        }
        i = bgte.a().a();
        if (i != 2) {
          break;
        }
        return "qq_m_qq-20031-android-2011-" + this.mMiniAppInfo.appId + "-" + paramString + "-" + (String)localObject1 + "-" + (String)localObject2;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      paramString = (String)localObject1;
    }
    if (i == 1) {
      return "qq_m_wx-20031-android-2011-" + this.mMiniAppInfo.appId + "-" + paramString + "-" + (String)localObject1 + "-" + (String)localObject2;
    }
    return "";
  }
  
  private void handleMidasGoodsPay(Activity paramActivity, JSONObject paramJSONObject, bgkd parambgkd)
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
    int i = parambgkd.jdField_b_of_type_Int;
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
    paramJSONObject.putString("payparmas_callback_sn", String.valueOf(i));
    paramJSONObject.putString("payparmas_json", localJSONObject.toString());
    paramJSONObject.putInt("payparmas_paytype", 1);
    paramJSONObject.putLong("payparmas_h5_start", System.currentTimeMillis());
    paramJSONObject.putInt("payparmas_request_code", 7);
    paramJSONObject.putString("payparmas_sdk_pf", getSDKPf(localJSONObject.toString()));
    if (paramActivity != null) {}
    for (paramActivity = ((PayProxy)ProxyManager.get(PayProxy.class)).midasPay(paramActivity, localJSONObject.toString(), new PayJsPlugin.8(this, parambgkd), paramJSONObject);; paramActivity = null)
    {
      if (paramActivity != null) {}
      for (i = paramActivity.getInt("retCode", 0);; i = 0)
      {
        if ((paramActivity != null) && (i != 0)) {
          handleNativeResponseFail(parambgkd, null, "");
        }
        return;
      }
    }
  }
  
  private void handleMidasMonthCardPay(Activity paramActivity, String paramString, bgkd parambgkd)
  {
    int i = parambgkd.jdField_b_of_type_Int;
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", String.valueOf(i));
    localBundle.putString("payparmas_json", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", System.currentTimeMillis());
    localBundle.putInt("payparmas_request_code", 14);
    localBundle.putString("payparmas_sdk_pf", getSDKPf(paramString));
    if (paramActivity != null) {}
    for (paramActivity = ((PayProxy)ProxyManager.get(PayProxy.class)).midasPay(paramActivity, paramString, new PayJsPlugin.7(this, parambgkd), localBundle);; paramActivity = null)
    {
      if (paramActivity != null) {}
      for (i = paramActivity.getInt("retCode", 0);; i = 0)
      {
        if ((paramActivity != null) && (i != 0)) {
          handleNativeResponseFail(parambgkd, null, "");
        }
        return;
      }
    }
  }
  
  private void handleNativeResponseCancel(bgkd parambgkd, JSONObject paramJSONObject)
  {
    if (parambgkd != null) {
      parambgkd.b(paramJSONObject);
    }
  }
  
  private void handleNativeResponseFail(bgkd parambgkd, JSONObject paramJSONObject, String paramString)
  {
    if (parambgkd != null) {
      parambgkd.a(paramJSONObject, paramString);
    }
  }
  
  private void handleNativeResponseOk(bgkd parambgkd, JSONObject paramJSONObject)
  {
    if (parambgkd != null) {
      parambgkd.a(paramJSONObject);
    }
  }
  
  private void handleQQPay(bgkd parambgkd)
  {
    Object localObject1 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
    Object localObject3 = ((JSONObject)localObject1).optString("prepayId", "");
    Object localObject4 = ((JSONObject)localObject1).getJSONObject("payInfo");
    Object localObject2 = ((JSONObject)localObject4).optString("miniAppId", "");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.mApkgInfo.appId;
    }
    String str = ((JSONObject)localObject4).optString("bargainor_id", "");
    localObject4 = ((JSONObject)localObject4).optString("channel", "");
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("tokenId", localObject3);
    ((JSONObject)localObject2).put("comeForm", 9);
    ((JSONObject)localObject2).put("appInfo", "appid#" + (String)localObject1 + "|bargainor_id#" + str + "|channel#" + (String)localObject4);
    int i = parambgkd.jdField_b_of_type_Int;
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("payparmas_callback_sn", String.valueOf(i));
    ((Bundle)localObject3).putString("payparmas_json", ((JSONObject)localObject2).toString());
    ((Bundle)localObject3).putInt("payparmas_paytype", 1);
    ((Bundle)localObject3).putLong("payparmas_h5_start", System.currentTimeMillis());
    ((Bundle)localObject3).putInt("payparmas_request_code", 9);
    ((Bundle)localObject3).putString("payparmas_sdk_pf", getSDKPf(((JSONObject)localObject2).toString()));
    if (this.mMiniAppContext != null)
    {
      localObject1 = this.mMiniAppContext.a();
      if (localObject1 == null) {
        break label339;
      }
    }
    label339:
    for (localObject1 = ((PayProxy)ProxyManager.get(PayProxy.class)).midasPay((Activity)localObject1, ((JSONObject)localObject2).toString(), new PayJsPlugin.9(this, parambgkd), (Bundle)localObject3);; localObject1 = null)
    {
      if (localObject1 != null) {}
      for (i = ((Bundle)localObject1).getInt("retCode", 0);; i = 0)
      {
        if ((localObject1 != null) && (i != 0)) {
          handleNativeResponseFail(parambgkd, null, "");
        }
        return;
        localObject1 = null;
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
      label119:
      QMLog.d("PayJsPlugin", "putAid, aid = " + paramString1);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label119;
    }
  }
  
  private void reChargeStarCurrency(bgkd parambgkd, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      String str2 = localJSONObject.optString("prepayId", null);
      int i = localJSONObject.optInt("balanceAmount", -1);
      int j = localJSONObject.optInt("topupAmount", -1);
      int k = localJSONObject.optInt("starCurrency", -1);
      int m = localJSONObject.optInt("setEnv", 0);
      String str1 = localJSONObject.optString("aid", "");
      Object localObject = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (str1.contains("{appid}")) {
          localObject = str1.replace("{appid}", this.mApkgInfo.appId);
        }
      }
      localJSONObject.put("userId", bgte.a().a());
      localJSONObject.put("aid", localObject);
      localJSONObject.put("comeForm", 9);
      localJSONObject.put("setMidasEnv", m);
      if (this.mIsMiniGame)
      {
        localObject = this.mMiniAppInfo;
        if (localObject != null)
        {
          localObject = this.mApkgInfo.appId + "_" + ((MiniAppInfo)localObject).verType;
          str1 = MD5Utils.encodeHexStr((String)localObject);
          this.mContext.getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", str1).commit();
          localJSONObject.put("miniAppVertypeStr", localObject);
        }
      }
      str1 = String.valueOf(parambgkd.jdField_b_of_type_Int);
      localObject = str1;
      if (i != -1)
      {
        localObject = str1;
        if (j != -1)
        {
          localObject = str1;
          if (k != -1)
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("appId", this.mApkgInfo.appId);
            ((JSONObject)localObject).put("prepayId", str2);
            ((JSONObject)localObject).put("balanceAmount", i);
            ((JSONObject)localObject).put("topupAmount", j);
            ((JSONObject)localObject).put("starCurrency", k);
            ((JSONObject)localObject).put("seq", parambgkd.jdField_b_of_type_Int);
            ((JSONObject)localObject).put("setEnv", m);
            localObject = ((JSONObject)localObject).toString();
          }
        }
      }
      if (!TextUtils.isEmpty(this.mRealOfferId)) {
        localJSONObject.put("offerId", this.mRealOfferId);
      }
      handleRechargeGame(parambgkd, this.mMiniAppContext.a(), localJSONObject.toString(), (String)localObject, paramBoolean);
      return;
    }
    catch (JSONException parambgkd)
    {
      QMLog.e("PayJsPlugin", "API_RECHARGE_STAR_CURRENCY JSONException ", parambgkd);
    }
  }
  
  private void startPayBrowserActivity(Activity paramActivity, bgkd parambgkd, String paramString)
  {
    bgjd.a().a(new PayJsPlugin.3(this, parambgkd));
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).startTransparentBrowserActivityForResult(paramActivity, paramString, 3003);
  }
  
  public void checkH5PayStatus(bgkd parambgkd)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", bglq.a("qqminiapp", "mini_game_pay_by_h5", 1));
      handleNativeResponseOk(parambgkd, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("PayJsPlugin", "checkH5PayStatus JSONException ", localJSONException);
      }
    }
  }
  
  public void consumeStarCurrency(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      String str = localJSONObject1.optString("prepayId");
      int i = localJSONObject1.optInt("starCurrency");
      int j = localJSONObject1.optInt("balanceAmount");
      int k = localJSONObject1.optInt("topupAmount");
      int m = localJSONObject1.optInt("payChannel");
      int n = localJSONObject1.optInt("setEnv", 0);
      invokeMidasConsume(parambgkd, this.mApkgInfo.appId, str, i, j, k, m, n);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PayJsPlugin", "consumestarcurrency error = ", localJSONException);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("resultCode", 1000);
        handleNativeResponseFail(parambgkd, localJSONObject2, "参数错误");
        return;
      }
      catch (JSONException parambgkd)
      {
        QMLog.e("PayJsPlugin", "handleNativeResponse error = ", parambgkd);
      }
    }
  }
  
  public void handleRechargeGame(bgkd parambgkd, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      handleNativeResponseFail(parambgkd, null, "activity is null");
      return;
    }
    bgkk.a(new PayJsPlugin.10(this, paramString2, paramString1, paramActivity, parambgkd, paramBoolean));
  }
  
  public void invokeMidasConsume(bgkd parambgkd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    QMLog.i("PayJsPlugin", "invokeMidasConsume prepayId= " + paramString2 + " starCurrency=" + String.valueOf(paramInt1));
    if ((TextUtils.isEmpty(paramString2)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", -4);
        paramString1.put("resultMsg", "消耗参数错误");
        handleNativeResponseFail(parambgkd, paramString1, "");
        return;
      }
      catch (JSONException parambgkd)
      {
        QMLog.e("PayJsPlugin", "invokeMidasConsume JSONException ", parambgkd);
        return;
      }
    }
    String str2 = "";
    String str1 = str2;
    if (this.mMiniAppInfo != null)
    {
      str1 = str2;
      if (this.mMiniAppInfo.launchParam != null) {
        str1 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName() + "_" + this.mMiniAppInfo.launchParam.scene;
      }
    }
    if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.via != null)) {}
    for (str2 = this.mMiniAppInfo.via;; str2 = "")
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, str1, str2, new PayJsPlugin.5(this, parambgkd));
      return;
    }
  }
  
  public void invokeMidasQuery(String paramString1, String paramString2, int paramInt1, int paramInt2, PayJsPlugin.IStarQueryListener paramIStarQueryListener)
  {
    QMLog.i("PayJsPlugin", "invokeMidasQuery prepayId= " + paramString1 + " starCurrency=" + String.valueOf(paramInt1) + " setEnv:" + paramInt2);
    if ((TextUtils.isEmpty(paramString1)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", 1000);
        paramString1.put("errMsg", "参数错误");
        if (paramIStarQueryListener != null) {
          paramIStarQueryListener.onResult(false, paramString1);
        }
        return;
      }
      catch (JSONException paramString1)
      {
        QMLog.e("PayJsPlugin", "invokeMidasQuery JSONException ", paramString1);
        return;
      }
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).queryCurrency(paramString1, paramString2, paramInt1, paramInt2, new PayJsPlugin.6(this, paramIStarQueryListener));
  }
  
  public void onCreate(bgho parambgho)
  {
    super.onCreate(parambgho);
  }
  
  public boolean onInterceptJsEvent(bgkd parambgkd)
  {
    Object localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localObject != null) && (((ChannelProxy)localObject).isGooglePlayVersion()))
    {
      int i;
      if (bglq.a("qqminiapp", "mini_app_google_play_pay_switch", 0) == 1) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("retCode", -123);
            ((JSONObject)localObject).put("errMsg", "googlePlay PayAPI no supported!");
            handleNativeResponseFail(parambgkd, (JSONObject)localObject, "googlePlay PayAPI no supported!");
            return true;
            i = 0;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    return super.onInterceptJsEvent(parambgkd);
  }
  
  public void queryStarCurrency(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      String str = localJSONObject1.optString("prepayId");
      int i = localJSONObject1.optInt("starCurrency");
      int j = localJSONObject1.optInt("setEnv", 0);
      invokeMidasQuery(str, this.mApkgInfo.appId, i, j, new PayJsPlugin.4(this, parambgkd));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PayJsPlugin", "querystarcurrency error = ", localJSONException);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("resultCode", 1000);
        handleNativeResponseFail(parambgkd, null, "参数错误");
        return;
      }
      catch (JSONException parambgkd)
      {
        QMLog.e("PayJsPlugin", "handleNativeResponse error = ", parambgkd);
      }
    }
  }
  
  public void rechargeAndConsumeStarCurrency(bgkd parambgkd)
  {
    reChargeStarCurrency(parambgkd, true);
  }
  
  public void rechargeStarCurrency(bgkd parambgkd)
  {
    reChargeStarCurrency(parambgkd, false);
  }
  
  public void requestMidasGoodsPay(bgkd parambgkd)
  {
    try
    {
      String str = bgte.a().a();
      JSONObject localJSONObject = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      localJSONObject.put("userId", str);
      handleMidasGoodsPay(this.mMiniAppContext.a(), localJSONObject, parambgkd);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PayJsPlugin", parambgkd.a + " error.", localJSONException);
      handleNativeResponseFail(parambgkd, null, "");
    }
  }
  
  public void requestMidasMonthCardPay(bgkd parambgkd)
  {
    try
    {
      String str = bgte.a().a();
      JSONObject localJSONObject = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      localJSONObject.put("userId", str);
      handleMidasMonthCardPay(this.mMiniAppContext.a(), localJSONObject.toString(), parambgkd);
      return;
    }
    catch (JSONException parambgkd)
    {
      parambgkd.printStackTrace();
    }
  }
  
  public void requestMidasPayment(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      String str1 = localJSONObject.optString("offerId");
      localJSONObject.put("userId", bgte.a().a());
      localJSONObject.put("comeForm", 9);
      String str2 = this.mApkgInfo.appId;
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).checkOfferId(str2, str1, new PayJsPlugin.2(this, localJSONObject, parambgkd));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PayJsPlugin", " error,", localException);
      handleNativeResponseFail(parambgkd, null, "");
    }
  }
  
  public void requestMidasPaymentByH5(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("prepayId");
      int i = ((JSONObject)localObject).optInt("starCurrency");
      int j = ((JSONObject)localObject).optInt("setEnv", 0);
      localObject = ((JSONObject)localObject).optString("offerId", "1450023163");
      str = URL_PAY_BY_H5.replace("{offerId}", (CharSequence)localObject).replace("{prepayId}", str).replace("{starCurrency}", i + "").replace("{setEnv}", j + "").replace("{appid}", this.mMiniAppInfo.appId);
      startPayBrowserActivity(this.mMiniAppContext.a(), parambgkd, str);
      return;
    }
    catch (JSONException parambgkd)
    {
      parambgkd.printStackTrace();
    }
  }
  
  public void requestPayment(bgkd parambgkd)
  {
    bgjd.a().a(new PayJsPlugin.1(this, parambgkd));
    try
    {
      handleQQPay(parambgkd);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PayJsPlugin", parambgkd.a + " error,", localException);
      handleNativeResponseFail(parambgkd, null, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */