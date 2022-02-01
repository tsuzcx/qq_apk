package com.tencent.mobileqq.mini.out.nativePlugins;

import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class NowLiveNativePlugin
  implements NativePlugin
{
  private static final String ACTION_PRELOAD = "preload";
  public static final String PLUGIN_NAME = "nowlive";
  private static final String TAG = "NowLiveNativePlugin";
  private TroopMemberApiClient mApiClient;
  final TroopMemberApiClient.Callback mCallback = new NowLiveNativePlugin.1(this);
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
    if (this.mApiClient != null) {
      this.mApiClient.g();
    }
  }
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if ((paramJSContext == null) || (paramJSONObject == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveNativePlugin", 2, "onInvoke| jsContext or param is null.");
      }
    }
    label87:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            paramJSContext = paramJSONObject.optString("api_name");
            if (TextUtils.equals("nowlive", paramJSContext)) {
              break label87;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("NowLiveNativePlugin", 2, "onInvoke| the api name: " + paramJSContext);
              return;
            }
          }
          catch (Exception paramJSONObject) {}
        }
      } while (!QLog.isColorLevel());
      QLog.w("NowLiveNativePlugin", 2, "decode param error");
      return;
      paramJSONObject = new JSONObject(paramJSONObject.getString("data")).getString("action");
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveNativePlugin", 2, "onInvoke|" + paramJSONObject);
      }
    } while (!TextUtils.equals(paramJSONObject, "preload"));
    preload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin
 * JD-Core Version:    0.7.0.1
 */