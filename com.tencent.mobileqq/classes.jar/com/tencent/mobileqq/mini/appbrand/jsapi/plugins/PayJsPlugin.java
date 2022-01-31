package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_COMM.COMM.StCommonExt;
import ajya;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bdik;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("PayJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    paramJsRuntime = new BridgeInfo(paramJsRuntime, paramInt);
    if (this.bridgeMap != null) {
      this.bridgeMap.put(Integer.valueOf(paramInt), paramJsRuntime);
    }
    if ("requestPayment".equals(paramString1)) {
      MiniAppController.getInstance().setActivityResultListener(new PayJsPlugin.2(this, paramInt, paramString1));
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
          MiniAppCmdUtil.getInstance().checkOfferId(this.jsPluginEngine.appBrandRuntime.appId, paramJsRuntime, null, new PayJsPlugin.3(this, paramString2, paramString1, paramInt));
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
              handleNativeResponseFail(paramInt, paramString1, paramString2, ajya.a(2131707918));
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
              handleNativeResponseFail(paramInt, paramString1, null, ajya.a(2131707916));
            }
            catch (JSONException paramString1)
            {
              QLog.e("PayJsPlugin", 1, "handleNativeResponse error = ", paramString1);
            }
          }
        }
        else if (("rechargeStarCurrency".equals(paramString1)) || ("rechargeAndConsumeStarCurrency".equals(paramString1)))
        {
          if ("rechargeAndConsumeStarCurrency".equals(paramString1)) {
            this.miniGameAutoConsume = true;
          }
          try
          {
            JSONObject localJSONObject = new JSONObject(paramString2);
            String str = localJSONObject.optString("prepayId", null);
            i = localJSONObject.optInt("balanceAmount", -1);
            j = localJSONObject.optInt("topupAmount", -1);
            k = localJSONObject.optInt("starCurrency", -1);
            m = localJSONObject.optInt("setEnv", 0);
            paramJsRuntime = localJSONObject.optString("aid", "");
            paramString2 = paramJsRuntime;
            if (!TextUtils.isEmpty(paramJsRuntime))
            {
              paramString2 = paramJsRuntime;
              if (paramJsRuntime.contains("{appid}")) {
                paramString2 = paramJsRuntime.replace("{appid}", this.jsPluginEngine.appBrandRuntime.appId);
              }
            }
            localJSONObject.put("userId", AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getCurrentAccountUin());
            localJSONObject.put("aid", paramString2);
            localJSONObject.put("comeForm", 9);
            localJSONObject.put("setMidasEnv", m);
            if ((this.jsPluginEngine.getActivityContext() instanceof GameActivity))
            {
              paramString2 = GameInfoManager.g().getMiniAppConfig();
              if ((paramString2 != null) && (paramString2.config != null))
              {
                paramString2 = this.jsPluginEngine.appBrandRuntime.appId + "_" + paramString2.config.verType;
                paramJsRuntime = bdik.b(paramString2);
                AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", paramJsRuntime).commit();
                localJSONObject.put("miniAppVertypeStr", paramString2);
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
            handleRechargeGame(this.jsPluginEngine.getActivityContext(), paramString1, localJSONObject.toString(), paramString2, paramInt, this.miniGameAutoConsume);
          }
          catch (JSONException paramString1)
          {
            QLog.e("PayJsPlugin", 1, "API_RECHARGE_STAR_CURRENCY JSONException ", paramString1);
          }
        }
        else if ("requestMidasGoodsPay".equals(paramString1))
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
      }
    }
  }
  
  public void handleRechargeGame(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppBrandTask.runTaskOnUiThread(new PayJsPlugin.4(this, paramString3, paramString2, paramBoolean, paramInt, paramString1, paramActivity));
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
        paramString1.put("resultMsg", ajya.a(2131707915));
        handleNativeResponseFail(paramInt5, paramString3, paramString1, "");
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("PayJsPlugin", 1, "invokeMidasConsume JSONException ", paramString1);
        return;
      }
    }
    MiniAppCmdUtil.getInstance().getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramStCommonExt, new PayJsPlugin.6(this, paramInt5, paramString3));
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
        handleNativeResponseFail(paramInt2, paramString3, null, ajya.a(2131707917));
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("PayJsPlugin", 1, "invokeMidasQuery JSONException ", paramString1);
        return;
      }
    }
    MiniAppCmdUtil.getInstance().getMidasQueryResult(paramString1, paramString2, paramInt1, paramInt3, paramStCommonExt, new PayJsPlugin.5(this, paramInt2, paramString3));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */