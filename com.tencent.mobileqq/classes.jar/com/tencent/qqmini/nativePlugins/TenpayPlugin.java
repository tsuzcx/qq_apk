package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import cooperation.qwallet.pluginshare.ITenCookie;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class TenpayPlugin
  extends BaseJsPlugin
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private TenpayPlugin.QWalletPayJsPluginResultReceiver jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$QWalletPayJsPluginResultReceiver;
  private TenpayPlugin.TenpayRecevicer jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$TenpayRecevicer;
  
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to parse jsonParams=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    QLog.e("TenpayPlugin", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  private void a(RequestEvent paramRequestEvent, String paramString1, String paramString2)
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
      paramRequestEvent.fail((JSONObject)localObject, paramString2);
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  private void a(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
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
      paramJSONObject = ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getExtraDataForGrapH5CommonHbResult(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramJSONObject);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("grapH5CommonHb extraData: ");
        localStringBuilder.append(paramJSONObject);
        QLog.d("TenpayPlugin", 2, localStringBuilder.toString());
      }
      if (paramJSONObject != null)
      {
        ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getGrapH5CommonHbResult(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramJSONObject.toString(), this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$QWalletPayJsPluginResultReceiver);
        return;
      }
      a(paramRequestEvent, "-1001", "params error");
      return;
    }
    catch (Throwable paramJSONObject)
    {
      a(paramRequestEvent, "-1001", paramJSONObject.getLocalizedMessage());
    }
  }
  
  private boolean a(RequestEvent paramRequestEvent, String paramString)
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
        a(paramRequestEvent, localJSONObject);
      }
      else if ("getHbResult".equals(localObject))
      {
        b(paramRequestEvent, localJSONObject);
      }
      else
      {
        boolean bool = "refreshHbDetail".equals(localObject);
        if (bool) {
          try
          {
            ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getHbDetailInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localJSONObject, "redgiftH5CommonDetail", this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$QWalletPayJsPluginResultReceiver);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        } else {
          a(paramRequestEvent, "-1001", "params exception: no match action");
        }
      }
      if ((paramString.optInt("closeWebView") == 1) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null))
      {
        this.mMiniAppContext.getAttachedActivity().finish();
        return true;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("params exception: ");
      localStringBuilder.append(paramString.getLocalizedMessage());
      a(paramRequestEvent, "-1001", localStringBuilder.toString());
    }
    return true;
  }
  
  private void b(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("listid");
    String str2 = paramJSONObject.optString("uin");
    if ((!StringUtil.a(str2)) && (str2.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) && (!StringUtil.a(str1)))
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
        QLog.i("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
      }
      paramJSONObject = new JSONObject(paramJSONObject);
      if (paramJSONObject.has("detail_data"))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retcode", 0);
        ((JSONObject)localObject).put("retmsg", "ok");
        ((JSONObject)localObject).put("detail_data", paramJSONObject.optJSONObject("detail_data"));
        paramRequestEvent.ok((JSONObject)localObject);
        return;
      }
      if (paramJSONObject.has("exception_data"))
      {
        paramRequestEvent.ok(paramJSONObject.optJSONObject("exception_data"));
        return;
      }
      a(paramRequestEvent, "-1001", "params error, detail_data is empty");
      return;
    }
    a(paramRequestEvent, "-1001", "params error,listid is empty or is not current user");
  }
  
  @JsEvent({"openTenpayView"})
  public void openTenpayView(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = a(paramRequestEvent);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("param: ");
      ((StringBuilder)localObject).append(localJSONObject);
      QLog.e("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (localJSONObject == null)
    {
      paramRequestEvent.fail(HardCodeUtil.a(2131714653));
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$TenpayRecevicer = new TenpayPlugin.TenpayRecevicer(this, paramRequestEvent, new Handler(Looper.getMainLooper()));
    try
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("json", localJSONObject.getString("data"));
      ((Bundle)localObject).putString("callbackSn", "0");
      ((Bundle)localObject).putInt("payparmas_paytype", 1);
      if (!PayBridgeActivity.tenpay(this.mMiniAppContext.getAttachedActivity(), 5, (Bundle)localObject, this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$TenpayRecevicer))
      {
        paramRequestEvent.fail(HardCodeUtil.a(2131714654));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      paramRequestEvent.fail(HardCodeUtil.a(2131714653));
    }
  }
  
  @JsEvent({"qWalletBridge"})
  public void qWalletBridge(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = a(paramRequestEvent);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("param: ");
      ((StringBuilder)localObject).append(localJSONObject);
      QLog.d("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (BaseActivity)this.mMiniAppContext.getAttachedActivity();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((BaseActivity)localObject).getAppInterface();
    this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$QWalletPayJsPluginResultReceiver = new TenpayPlugin.QWalletPayJsPluginResultReceiver(paramRequestEvent, new Handler(Looper.getMainLooper()), this.jdField_a_of_type_ComTencentCommonAppAppInterface, new WeakReference(localObject));
    if (localJSONObject != null) {
      a(paramRequestEvent, localJSONObject.optString("data"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin
 * JD-Core Version:    0.7.0.1
 */