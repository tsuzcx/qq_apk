package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class NowLiveJsPlugin
  extends BaseJsPlugin
{
  final ITroopMemberApiClientApi.Callback a = new NowLiveJsPlugin.1(this);
  private TroopMemberApiClient b;
  private int c;
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveJsPlugin", 2, "NowLiveJsPlugin | preload()");
    }
    if (this.b == null)
    {
      this.b = TroopMemberApiClient.a();
      this.b.e();
      this.b.i(this.a);
    }
    this.b.a(null);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveJsPlugin", 2, "NowLiveNativePlugin | onDestroy()");
    }
    TroopMemberApiClient localTroopMemberApiClient = this.b;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.k();
    }
  }
  
  @JsEvent({"nowlive"})
  public void onInvoke(RequestEvent paramRequestEvent)
  {
    if ((paramRequestEvent != null) && (!TextUtils.isEmpty(paramRequestEvent.jsonParams))) {}
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      paramRequestEvent = ((JSONObject)localObject).optString("api_name");
      if (!TextUtils.equals("nowlive", paramRequestEvent))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onInvoke() the api name: ");
        ((StringBuilder)localObject).append(paramRequestEvent);
        QLog.d("NowLiveJsPlugin", 2, ((StringBuilder)localObject).toString());
        return;
      }
      paramRequestEvent = new JSONObject(((JSONObject)localObject).getString("data")).getString("action");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onInvoke()");
        ((StringBuilder)localObject).append(paramRequestEvent);
        QLog.d("NowLiveJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.equals(paramRequestEvent, "preload")) {
        break label167;
      }
      a();
      return;
    }
    catch (Exception paramRequestEvent)
    {
      label153:
      break label153;
    }
    if (QLog.isColorLevel()) {
      QLog.w("NowLiveJsPlugin", 2, "decode param error");
    }
    label167:
    return;
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveJsPlugin", 2, "onInvoke(): request event  is null.");
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.NowLiveJsPlugin
 * JD-Core Version:    0.7.0.1
 */