package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.utils.H5HbUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.pluginshare.TenCookie;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayPlugin
  implements NativePlugin
{
  public static final String PLUGIN_NAME = "openTenpayView";
  public static final String PLUGIN_NAME_QWALLETBRIDGE = "qWalletBridge";
  public static final String TAG = "TenpayPlugin";
  private AppInterface app;
  private JSContext jsContext;
  private TenpayPlugin.QWalletPayJsPluginResultReceiver mRecevicer;
  private TenpayPlugin.TenpayRecevicer payRecevicer;
  
  private void getHbResult(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("listid");
    String str2 = paramJSONObject.optString("uin");
    if ((!StringUtil.a(str2)) && (str2.equals(this.app.getCurrentAccountUin())) && (!StringUtil.a(str1)))
    {
      Object localObject = TenCookie.a().b(str1);
      paramJSONObject = (JSONObject)localObject;
      if (StringUtil.a((String)localObject)) {
        paramJSONObject = SharedPreferencesProxyManager.getInstance().getProxy("common_h5_hb_info" + str2, 0).getString(str1, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TenpayPlugin", 2, "getHbResult dataStr: " + paramJSONObject);
      }
      paramJSONObject = new JSONObject(paramJSONObject);
      if (paramJSONObject.has("detail_data"))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retcode", 0);
        ((JSONObject)localObject).put("retmsg", "ok");
        ((JSONObject)localObject).put("detail_data", paramJSONObject.optJSONObject("detail_data"));
        this.jsContext.evaluateCallback(true, (JSONObject)localObject, "");
        return;
      }
      if (paramJSONObject.has("exception_data"))
      {
        this.jsContext.evaluateCallback(true, paramJSONObject.optJSONObject("exception_data"), "");
        return;
      }
      handJsError("-1001", "params error, detail_data is empty");
      return;
    }
    handJsError("-1001", "params error,listid is empty or is not current user");
  }
  
  private void grapH5CommonHb(JSONObject paramJSONObject)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TenpayPlugin", 2, "grapH5CommonHb params: " + paramJSONObject);
      }
      paramJSONObject = H5HbUtil.a(this.app, paramJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("TenpayPlugin", 2, "grapH5CommonHb extraData: " + paramJSONObject);
      }
      if (paramJSONObject != null)
      {
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
      QLog.d("TenpayPlugin", 2, "handJsError: " + paramString2);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retcode", paramString1);
      localJSONObject.put("retmsg", paramString2);
      this.jsContext.evaluateCallback(false, localJSONObject, paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean qWalletBridge(String paramString)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("TenpayPlugin", 2, "[qWalletBridge] paramStr: " + paramString);
        }
        paramString = new JSONObject(paramString);
        String str = paramString.optString("action");
        localJSONObject = paramString.optJSONObject("params");
        if ("graphb".equals(str))
        {
          grapH5CommonHb(localJSONObject);
          if ((paramString.optInt("closeWebView") != 1) || (this.jsContext == null) || (this.jsContext.getActivity() == null)) {
            break;
          }
          this.jsContext.getActivity().finish();
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
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    this.jsContext = paramJSContext;
    if (this.jsContext != null)
    {
      try
      {
        this.app = ((BaseActivity)this.jsContext.getActivity()).getAppInterface();
        if (paramJSONObject == null)
        {
          this.jsContext.evaluateCallback(false, null, HardCodeUtil.a(2131714722));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TenpayPlugin", 2, paramJSONObject.toString());
        }
        paramJSContext = paramJSONObject.optString("api_name");
        if (paramJSContext.equals("openTenpayView"))
        {
          this.payRecevicer = new TenpayPlugin.TenpayRecevicer(this, new Handler(Looper.getMainLooper()));
          QLog.e("TenpayPlugin", 1, "param: " + paramJSONObject);
          paramJSContext = new Bundle();
          paramJSContext.putString("json", paramJSONObject.getString("data"));
          paramJSContext.putString("callbackSn", "0");
          paramJSContext.putInt("payparmas_paytype", 1);
          if (PayBridgeActivity.tenpay(this.jsContext.getActivity(), 5, paramJSContext, this.payRecevicer)) {
            return;
          }
          this.jsContext.evaluateCallback(false, null, HardCodeUtil.a(2131714723));
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        this.jsContext.evaluateCallback(false, null, HardCodeUtil.a(2131714722));
        return;
      }
      if (paramJSContext.equals("qWalletBridge"))
      {
        this.mRecevicer = new TenpayPlugin.QWalletPayJsPluginResultReceiver(this.jsContext, new Handler(Looper.getMainLooper()), this.app);
        qWalletBridge(paramJSONObject.optString("data"));
      }
    }
    else
    {
      QLog.i("TenpayPlugin", 1, "js context is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin
 * JD-Core Version:    0.7.0.1
 */