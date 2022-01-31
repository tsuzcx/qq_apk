package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import begz;
import beil;
import bejy;
import beka;
import beki;
import besl;
import beuc;
import bfgc;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
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
  
  private String getSDKPf()
  {
    int i = beuc.a().a();
    String str = "";
    if (i == 2) {
      str = "qq_m_qq-20031-android-2011-" + this.mMiniAppInfo.appId;
    }
    while (i != 1) {
      return str;
    }
    return "qq_m_wx-20031-android-2011-" + this.mMiniAppInfo.appId;
  }
  
  private void handleMidasGoodsPay(Activity paramActivity, JSONObject paramJSONObject, beka parambeka)
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
    int i = parambeka.jdField_b_of_type_Int;
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
    paramJSONObject.putString("payparmas_sdk_pf", getSDKPf());
    if (paramActivity != null) {}
    for (paramActivity = ((PayProxy)ProxyManager.get(PayProxy.class)).midasPay(paramActivity, localJSONObject.toString(), new PayJsPlugin.7(this, parambeka), paramJSONObject);; paramActivity = null)
    {
      if (paramActivity != null) {}
      for (i = paramActivity.getInt("retCode", 0);; i = 0)
      {
        if ((paramActivity != null) && (i != 0)) {
          handleNativeResponseFail(parambeka, null, "");
        }
        return;
      }
    }
  }
  
  private void handleMidasMonthCardPay(Activity paramActivity, String paramString, beka parambeka)
  {
    int i = parambeka.jdField_b_of_type_Int;
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", String.valueOf(i));
    localBundle.putString("payparmas_json", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", System.currentTimeMillis());
    localBundle.putInt("payparmas_request_code", 14);
    localBundle.putString("payparmas_sdk_pf", getSDKPf());
    if (paramActivity != null) {}
    for (paramActivity = ((PayProxy)ProxyManager.get(PayProxy.class)).midasPay(paramActivity, paramString, new PayJsPlugin.6(this, parambeka), localBundle);; paramActivity = null)
    {
      if (paramActivity != null) {}
      for (i = paramActivity.getInt("retCode", 0);; i = 0)
      {
        if ((paramActivity != null) && (i != 0)) {
          handleNativeResponseFail(parambeka, null, "");
        }
        return;
      }
    }
  }
  
  private void handleNativeResponseCancel(beka parambeka, JSONObject paramJSONObject)
  {
    if (parambeka != null) {
      parambeka.b(paramJSONObject);
    }
  }
  
  private void handleNativeResponseFail(beka parambeka, JSONObject paramJSONObject, String paramString)
  {
    if (parambeka != null) {
      parambeka.a(paramJSONObject, paramString);
    }
  }
  
  private void handleNativeResponseOk(beka parambeka, JSONObject paramJSONObject)
  {
    if (parambeka != null) {
      parambeka.a(paramJSONObject);
    }
  }
  
  private void handleQQPay(beka parambeka)
  {
    Object localObject1 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
    Object localObject3 = ((JSONObject)localObject1).optString("prepayId", "");
    Object localObject4 = ((JSONObject)localObject1).getJSONObject("payInfo");
    Object localObject2 = ((JSONObject)localObject4).optString("miniAppId", "");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.mApkgInfo.d;
    }
    String str = ((JSONObject)localObject4).optString("bargainor_id", "");
    localObject4 = ((JSONObject)localObject4).optString("channel", "");
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("tokenId", localObject3);
    ((JSONObject)localObject2).put("comeForm", 9);
    ((JSONObject)localObject2).put("appInfo", "appid#" + (String)localObject1 + "|bargainor_id#" + str + "|channel#" + (String)localObject4);
    int i = parambeka.jdField_b_of_type_Int;
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("payparmas_callback_sn", String.valueOf(i));
    ((Bundle)localObject3).putString("payparmas_json", ((JSONObject)localObject2).toString());
    ((Bundle)localObject3).putInt("payparmas_paytype", 1);
    ((Bundle)localObject3).putLong("payparmas_h5_start", System.currentTimeMillis());
    ((Bundle)localObject3).putInt("payparmas_request_code", 9);
    ((Bundle)localObject3).putString("payparmas_sdk_pf", getSDKPf());
    if (this.mMiniAppContext != null)
    {
      localObject1 = this.mMiniAppContext.a();
      if (localObject1 == null) {
        break label329;
      }
    }
    label329:
    for (localObject1 = ((PayProxy)ProxyManager.get(PayProxy.class)).midasPay((Activity)localObject1, ((JSONObject)localObject2).toString(), new PayJsPlugin.8(this, parambeka), (Bundle)localObject3);; localObject1 = null)
    {
      if (localObject1 != null) {}
      for (i = ((Bundle)localObject1).getInt("retCode", 0);; i = 0)
      {
        if ((localObject1 != null) && (i != 0)) {
          handleNativeResponseFail(parambeka, null, "");
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
      label124:
      besl.a("PayJsPlugin", "putAid, aid = " + paramString1);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label124;
    }
  }
  
  private void reChargeStarCurrency(beka parambeka, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
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
          localObject = str1.replace("{appid}", this.mApkgInfo.d);
        }
      }
      localJSONObject.put("userId", beuc.a().a());
      localJSONObject.put("aid", localObject);
      localJSONObject.put("comeForm", 9);
      localJSONObject.put("setMidasEnv", m);
      if (this.mIsMiniGame)
      {
        localObject = this.mMiniAppInfo;
        if (localObject != null)
        {
          localObject = this.mApkgInfo.d + "_" + ((MiniAppInfo)localObject).verType;
          str1 = bfgc.b((String)localObject);
          this.mContext.getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", str1).commit();
          localJSONObject.put("miniAppVertypeStr", localObject);
        }
      }
      str1 = String.valueOf(parambeka.jdField_b_of_type_Int);
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
            ((JSONObject)localObject).put("appId", this.mApkgInfo.d);
            ((JSONObject)localObject).put("prepayId", str2);
            ((JSONObject)localObject).put("balanceAmount", i);
            ((JSONObject)localObject).put("topupAmount", j);
            ((JSONObject)localObject).put("starCurrency", k);
            ((JSONObject)localObject).put("seq", parambeka.jdField_b_of_type_Int);
            ((JSONObject)localObject).put("setEnv", m);
            localObject = ((JSONObject)localObject).toString();
          }
        }
      }
      if (!TextUtils.isEmpty(this.mRealOfferId)) {
        localJSONObject.put("offerId", this.mRealOfferId);
      }
      handleRechargeGame(parambeka, this.mMiniAppContext.a(), localJSONObject.toString(), (String)localObject, paramBoolean);
      return;
    }
    catch (JSONException parambeka)
    {
      besl.d("PayJsPlugin", "API_RECHARGE_STAR_CURRENCY JSONException ", parambeka);
    }
  }
  
  public void consumeStarCurrency(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      String str = localJSONObject1.optString("prepayId");
      int i = localJSONObject1.optInt("starCurrency");
      int j = localJSONObject1.optInt("balanceAmount");
      int k = localJSONObject1.optInt("topupAmount");
      int m = localJSONObject1.optInt("payChannel");
      int n = localJSONObject1.optInt("setEnv", 0);
      invokeMidasConsume(parambeka, this.mApkgInfo.d, str, i, j, k, m, n);
      return;
    }
    catch (JSONException localJSONException)
    {
      besl.d("PayJsPlugin", "consumestarcurrency error = ", localJSONException);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("resultCode", 1000);
        handleNativeResponseFail(parambeka, localJSONObject2, "参数错误");
        return;
      }
      catch (JSONException parambeka)
      {
        besl.d("PayJsPlugin", "handleNativeResponse error = ", parambeka);
      }
    }
  }
  
  public void handleRechargeGame(beka parambeka, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      handleNativeResponseFail(parambeka, null, "activity is null");
      return;
    }
    beki.a(new PayJsPlugin.9(this, paramString2, paramString1, paramActivity, parambeka, paramBoolean));
  }
  
  public void invokeMidasConsume(beka parambeka, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    besl.b("PayJsPlugin", "invokeMidasConsume prepayId= " + paramString2 + " starCurrency=" + String.valueOf(paramInt1));
    if ((TextUtils.isEmpty(paramString2)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", -4);
        paramString1.put("resultMsg", "消耗参数错误");
        handleNativeResponseFail(parambeka, paramString1, "");
        return;
      }
      catch (JSONException parambeka)
      {
        besl.d("PayJsPlugin", "invokeMidasConsume JSONException ", parambeka);
        return;
      }
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, new PayJsPlugin.4(this, parambeka));
  }
  
  public void invokeMidasQuery(String paramString1, String paramString2, int paramInt1, int paramInt2, PayJsPlugin.IStarQueryListener paramIStarQueryListener)
  {
    besl.b("PayJsPlugin", "invokeMidasQuery prepayId= " + paramString1 + " starCurrency=" + String.valueOf(paramInt1) + " setEnv:" + paramInt2);
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
        besl.d("PayJsPlugin", "invokeMidasQuery JSONException ", paramString1);
        return;
      }
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).queryCurrency(paramString1, paramString2, paramInt1, paramInt2, new PayJsPlugin.5(this, paramIStarQueryListener));
  }
  
  public void onCreate(begz parambegz)
  {
    super.onCreate(parambegz);
  }
  
  public void queryStarCurrency(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      String str = localJSONObject1.optString("prepayId");
      int i = localJSONObject1.optInt("starCurrency");
      int j = localJSONObject1.optInt("setEnv", 0);
      invokeMidasQuery(str, this.mApkgInfo.d, i, j, new PayJsPlugin.3(this, parambeka));
      return;
    }
    catch (JSONException localJSONException)
    {
      besl.d("PayJsPlugin", "querystarcurrency error = ", localJSONException);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("resultCode", 1000);
        handleNativeResponseFail(parambeka, null, "参数错误");
        return;
      }
      catch (JSONException parambeka)
      {
        besl.d("PayJsPlugin", "handleNativeResponse error = ", parambeka);
      }
    }
  }
  
  public void rechargeAndConsumeStarCurrency(beka parambeka)
  {
    reChargeStarCurrency(parambeka, true);
  }
  
  public void rechargeStarCurrency(beka parambeka)
  {
    reChargeStarCurrency(parambeka, false);
  }
  
  public void requestMidasGoodsPay(beka parambeka)
  {
    try
    {
      String str = beuc.a().a();
      JSONObject localJSONObject = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      localJSONObject.put("userId", str);
      handleMidasGoodsPay(this.mMiniAppContext.a(), localJSONObject, parambeka);
      return;
    }
    catch (JSONException localJSONException)
    {
      besl.d("PayJsPlugin", parambeka.a + " error.", localJSONException);
      handleNativeResponseFail(parambeka, null, "");
    }
  }
  
  public void requestMidasMonthCardPay(beka parambeka)
  {
    try
    {
      String str = beuc.a().a();
      JSONObject localJSONObject = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      localJSONObject.put("userId", str);
      handleMidasMonthCardPay(this.mMiniAppContext.a(), localJSONObject.toString(), parambeka);
      return;
    }
    catch (JSONException parambeka)
    {
      parambeka.printStackTrace();
    }
  }
  
  public void requestMidasPayment(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      String str1 = localJSONObject.optString("offerId");
      localJSONObject.put("userId", beuc.a().a());
      localJSONObject.put("comeForm", 9);
      String str2 = this.mApkgInfo.d;
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).checkOfferId(str2, str1, new PayJsPlugin.2(this, localJSONObject, parambeka));
      return;
    }
    catch (Exception localException)
    {
      besl.d("PayJsPlugin", " error,", localException);
      handleNativeResponseFail(parambeka, null, "");
    }
  }
  
  public void requestPayment(beka parambeka)
  {
    beil.a().a(new PayJsPlugin.1(this, parambeka));
    try
    {
      handleQQPay(parambeka);
      return;
    }
    catch (Exception localException)
    {
      besl.d("PayJsPlugin", parambeka.a + " error,", localException);
      handleNativeResponseFail(parambeka, null, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */