package com.tencent.mobileqq.mini.out.nativePlugins;

import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class NowLiveNativePlugin
  implements NativePlugin
{
  private static final String ACTION_PRELOAD = "preload";
  public static final String PLUGIN_NAME = "nowlive";
  private static final String TAG = "NowLiveNativePlugin";
  private TroopMemberApiClient mApiClient;
  final ITroopMemberApiClientApi.Callback mCallback = new NowLiveNativePlugin.1(this);
  private int mPluginState;
  
  private void preload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveNativePlugin", 2, "NowLiveNativePlugin | preload()");
    }
    if (this.mApiClient == null)
    {
      this.mApiClient = TroopMemberApiClient.a();
      this.mApiClient.a();
      this.mApiClient.g(this.mCallback);
    }
    this.mApiClient.a(null);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveNativePlugin", 2, "NowLiveNativePlugin | onDestroy()");
    }
    TroopMemberApiClient localTroopMemberApiClient = this.mApiClient;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.g();
    }
  }
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if ((paramJSContext != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSContext = paramJSONObject.optString("api_name");
      if (!TextUtils.equals("nowlive", paramJSContext))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onInvoke| the api name: ");
        paramJSONObject.append(paramJSContext);
        QLog.d("NowLiveNativePlugin", 2, paramJSONObject.toString());
        return;
      }
      paramJSONObject = new JSONObject(paramJSONObject.getString("data")).getString("action");
      if (QLog.isColorLevel())
      {
        paramJSContext = new StringBuilder();
        paramJSContext.append("onInvoke|");
        paramJSContext.append(paramJSONObject);
        QLog.d("NowLiveNativePlugin", 2, paramJSContext.toString());
      }
      if (!TextUtils.equals(paramJSONObject, "preload")) {
        break label149;
      }
      preload();
      return;
    }
    catch (Exception paramJSONObject)
    {
      label135:
      break label135;
    }
    if (QLog.isColorLevel()) {
      QLog.w("NowLiveNativePlugin", 2, "decode param error");
    }
    label149:
    return;
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveNativePlugin", 2, "onInvoke| jsContext or param is null.");
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin
 * JD-Core Version:    0.7.0.1
 */