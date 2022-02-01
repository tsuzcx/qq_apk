package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.pluginshare.ITenCookie;
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
    if ((!StringUtil.isEmpty(str2)) && (str2.equals(this.app.getCurrentAccountUin())) && (!StringUtil.isEmpty(str1)))
    {
      Object localObject = ((ITenCookie)QRoute.api(ITenCookie.class)).getTempArgs(str1);
      paramJSONObject = (JSONObject)localObject;
      if (StringUtil.isEmpty((String)localObject))
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
        QLog.i("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
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
      boolean bool = QLog.isColorLevel();
      StringBuilder localStringBuilder;
      if (bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("grapH5CommonHb params: ");
        localStringBuilder.append(paramJSONObject);
        QLog.d("TenpayPlugin", 2, localStringBuilder.toString());
      }
      paramJSONObject = ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getExtraDataForGrapH5CommonHbResult(this.app, paramJSONObject);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("grapH5CommonHb extraData: ");
        localStringBuilder.append(paramJSONObject);
        QLog.d("TenpayPlugin", 2, localStringBuilder.toString());
      }
      if (paramJSONObject != null)
      {
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
      QLog.d("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("retcode", paramString1);
      ((JSONObject)localObject).put("retmsg", paramString2);
      this.jsContext.evaluateCallback(false, (JSONObject)localObject, paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean qWalletBridge(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[qWalletBridge] paramStr: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
      }
      paramString = new JSONObject(paramString);
      Object localObject = paramString.optString("action");
      JSONObject localJSONObject = paramString.optJSONObject("params");
      if ("graphb".equals(localObject))
      {
        grapH5CommonHb(localJSONObject);
      }
      else if ("getHbResult".equals(localObject))
      {
        getHbResult(localJSONObject);
      }
      else
      {
        boolean bool = "refreshHbDetail".equals(localObject);
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
      if ((paramString.optInt("closeWebView") == 1) && (this.jsContext != null) && (this.jsContext.getActivity() != null))
      {
        this.jsContext.getActivity().finish();
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
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    this.jsContext = paramJSContext;
    paramJSContext = this.jsContext;
    if (paramJSContext != null) {
      try
      {
        this.app = ((BaseActivity)paramJSContext.getActivity()).getAppInterface();
        if (paramJSONObject == null)
        {
          this.jsContext.evaluateCallback(false, null, HardCodeUtil.a(2131912162));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TenpayPlugin", 2, paramJSONObject.toString());
        }
        paramJSContext = paramJSONObject.optString("api_name");
        boolean bool = paramJSContext.equals("openTenpayView");
        if (bool)
        {
          this.payRecevicer = new TenpayPlugin.TenpayRecevicer(this, new Handler(Looper.getMainLooper()));
          paramJSContext = new StringBuilder();
          paramJSContext.append("param: ");
          paramJSContext.append(paramJSONObject);
          QLog.e("TenpayPlugin", 1, paramJSContext.toString());
          paramJSContext = new Bundle();
          paramJSContext.putString("json", paramJSONObject.getString("data"));
          paramJSContext.putString("callbackSn", "0");
          paramJSContext.putInt("payparmas_paytype", 1);
          if (PayBridgeActivity.tenpay(this.jsContext.getActivity(), 5, paramJSContext, this.payRecevicer)) {
            return;
          }
          this.jsContext.evaluateCallback(false, null, HardCodeUtil.a(2131912163));
          return;
        }
        if (!paramJSContext.equals("qWalletBridge")) {
          return;
        }
        this.mRecevicer = new TenpayPlugin.QWalletPayJsPluginResultReceiver(this.jsContext, new Handler(Looper.getMainLooper()), this.app);
        qWalletBridge(paramJSONObject.optString("data"));
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        this.jsContext.evaluateCallback(false, null, HardCodeUtil.a(2131912162));
        return;
      }
    } else {
      QLog.i("TenpayPlugin", 1, "js context is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin
 * JD-Core Version:    0.7.0.1
 */