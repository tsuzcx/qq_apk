package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopManageProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

class UiApiPlugin$4
  implements ITroopMemberApiClientApi.Callback
{
  UiApiPlugin$4(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("isSuccess"))
      {
        paramBundle = new Intent();
        paramBundle.putExtra("troop_uin", this.a);
        int i;
        if (this.b.mRuntime.f() != null) {
          i = this.b.mRuntime.f().switchRequestCode(this.b, (byte)12);
        } else {
          i = 12;
        }
        TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.j, TroopManageProxyActivity.class, this.b.mRuntime.d(), paramBundle, TroopManageProxyActivity.a(this.b.mRuntime.d()), "com.tencent.mobileqq.activity.TroopSetJoinTypeActivity", this.b.mRuntime.b().getAccount(), i);
        return;
      }
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("gc", this.a);
        paramBundle.put("ret", 1);
        this.b.callJs(this.b.t, new String[] { paramBundle.toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.4
 * JD-Core Version:    0.7.0.1
 */