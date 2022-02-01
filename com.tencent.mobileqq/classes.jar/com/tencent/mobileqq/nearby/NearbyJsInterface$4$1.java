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

class NearbyJsInterface$4$1
  implements ITroopMemberApiClientApi.Callback
{
  NearbyJsInterface$4$1(NearbyJsInterface.4 param4, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isOtherTypeChatting", false))
    {
      paramBundle = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$4.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), 230);
      paramBundle.setMessage(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$4.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a().getString(2131695889));
      paramBundle.setNegativeButton(HardCodeUtil.a(2131707231), new NearbyJsInterface.4.1.1(this));
      paramBundle.show();
      return;
    }
    TroopMemberApiClient.a();
    paramBundle = new oidb_0x8dd.SelfInfo();
    paramBundle.uint32_gender.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$4.jdField_a_of_type_Int);
    paramBundle.uint32_charm_level.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$4.b);
    paramBundle.uint32_age.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$4.c);
    NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$4.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$4.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), null, this.jdField_a_of_type_JavaLangString, paramBundle, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.4.1
 * JD-Core Version:    0.7.0.1
 */