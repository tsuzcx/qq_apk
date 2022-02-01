package com.tencent.qqmini.nativePlugins;

import alig;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import anzj;
import bhsr;
import bmrz;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
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
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("TenpayPlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  private void a(RequestEvent paramRequestEvent, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TenpayPlugin", 2, "handJsError: " + paramString2);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retcode", paramString1);
      localJSONObject.put("retmsg", paramString2);
      paramRequestEvent.fail(localJSONObject, paramString2);
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
      if (QLog.isColorLevel()) {
        QLog.d("TenpayPlugin", 2, "grapH5CommonHb params: " + paramJSONObject);
      }
      paramJSONObject = alig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("TenpayPlugin", 2, "grapH5CommonHb extraData: " + paramJSONObject);
      }
      if (paramJSONObject != null)
      {
        alig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramJSONObject.toString(), this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$QWalletPayJsPluginResultReceiver);
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
          a(paramRequestEvent, localJSONObject);
          if ((paramString.optInt("closeWebView") != 1) || (this.mMiniAppContext == null) || (this.mMiniAppContext.getAttachedActivity() == null)) {
            break;
          }
          this.mMiniAppContext.getAttachedActivity().finish();
          return true;
        }
        if ("getHbResult".equals(str))
        {
          b(paramRequestEvent, localJSONObject);
          continue;
        }
        bool = "refreshHbDetail".equals(str);
      }
      catch (Exception paramString)
      {
        a(paramRequestEvent, "-1001", "params exception: " + paramString.getLocalizedMessage());
        return true;
      }
      boolean bool;
      if (bool) {
        try
        {
          alig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localJSONObject, "redgiftH5CommonDetail", this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$QWalletPayJsPluginResultReceiver);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      } else {
        a(paramRequestEvent, "-1001", "params exception: no match action");
      }
    }
    return true;
  }
  
  private void b(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("listid");
    String str2 = paramJSONObject.optString("uin");
    if ((!bhsr.a(str2)) && (str2.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) && (!bhsr.a(str1)))
    {
      Object localObject = bmrz.a().b(str1);
      paramJSONObject = (JSONObject)localObject;
      if (bhsr.a((String)localObject)) {
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
    this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$TenpayRecevicer = new TenpayPlugin.TenpayRecevicer(this, paramRequestEvent, new Handler(Looper.getMainLooper()));
    QLog.e("TenpayPlugin", 1, "param: " + localJSONObject.toString());
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("json", localJSONObject.getString("data"));
      localBundle.putString("callbackSn", "0");
      localBundle.putInt("payparmas_paytype", 1);
      if (!PayBridgeActivity.a(this.mMiniAppContext.getAttachedActivity(), 5, localBundle, this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$TenpayRecevicer)) {
        paramRequestEvent.fail(anzj.a(2131713648));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      paramRequestEvent.fail(anzj.a(2131713647));
    }
  }
  
  @JsEvent({"qWalletBridge"})
  public void qWalletBridge(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = a(paramRequestEvent);
    QLog.e("TenpayPlugin", 1, "param: " + localJSONObject.toString());
    BaseActivity localBaseActivity = (BaseActivity)this.mMiniAppContext.getAttachedActivity();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = localBaseActivity.getAppInterface();
    this.jdField_a_of_type_ComTencentQqminiNativePluginsTenpayPlugin$QWalletPayJsPluginResultReceiver = new TenpayPlugin.QWalletPayJsPluginResultReceiver(paramRequestEvent, new Handler(Looper.getMainLooper()), this.jdField_a_of_type_ComTencentCommonAppAppInterface, new WeakReference(localBaseActivity));
    if (localJSONObject != null) {
      a(paramRequestEvent, localJSONObject.optString("data"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin
 * JD-Core Version:    0.7.0.1
 */