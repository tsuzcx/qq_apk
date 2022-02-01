package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
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
  private int jdField_a_of_type_Int;
  final TroopMemberApiClient.Callback jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient$Callback = new NowLiveJsPlugin.1(this);
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveJsPlugin", 2, "NowLiveJsPlugin | preload()");
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.g(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient$Callback);
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(null);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveJsPlugin", 2, "NowLiveNativePlugin | onDestroy()");
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.g();
    }
  }
  
  @JsEvent({"nowlive"})
  public void onInvoke(RequestEvent paramRequestEvent)
  {
    if ((paramRequestEvent == null) || (TextUtils.isEmpty(paramRequestEvent.jsonParams))) {
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveJsPlugin", 2, "onInvoke(): request event  is null.");
      }
    }
    label105:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
            String str = paramRequestEvent.optString("api_name");
            if (TextUtils.equals("nowlive", str)) {
              break label105;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("NowLiveJsPlugin", 2, "onInvoke() the api name: " + str);
              return;
            }
          }
          catch (Exception paramRequestEvent) {}
        }
      } while (!QLog.isColorLevel());
      QLog.w("NowLiveJsPlugin", 2, "decode param error");
      return;
      paramRequestEvent = new JSONObject(paramRequestEvent.getString("data")).getString("action");
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveJsPlugin", 2, "onInvoke()" + paramRequestEvent);
      }
    } while (!TextUtils.equals(paramRequestEvent, "preload"));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.NowLiveJsPlugin
 * JD-Core Version:    0.7.0.1
 */