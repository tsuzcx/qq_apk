package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.troop.NearbyVideoChatProxyActivity;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

class NearbyJsInterface$3$1
  implements ITroopMemberApiClientApi.Callback
{
  NearbyJsInterface$3$1(NearbyJsInterface.3 param3, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isOtherTypeChatting", false))
    {
      paramBundle = DialogUtil.a(this.b.e.mRuntime.d(), 230);
      paramBundle.setMessage(this.b.e.mRuntime.d().getString(2131893650));
      paramBundle.setNegativeButton(HardCodeUtil.a(2131899883), new NearbyJsInterface.3.1.1(this));
      paramBundle.show();
      return;
    }
    TroopMemberApiClient.a();
    paramBundle = new oidb_0x8dd.SelfInfo();
    paramBundle.uint32_gender.set(this.b.b);
    paramBundle.uint32_charm_level.set(this.b.c);
    paramBundle.uint32_age.set(this.b.d);
    NearbyVideoChatProxyActivity.a(this.b.e.mRuntime.b(), this.b.e.mRuntime.d(), null, this.a, paramBundle, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.3.1
 * JD-Core Version:    0.7.0.1
 */