package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

final class BridgeModuleHelper$9
  implements Runnable
{
  BridgeModuleHelper$9(BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).jdField_a_of_type_JavaLangString = "ce2d9f";
    localObject = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
    if (localObject != null) {
      localObject = ((GdtDeviceInfoHelper.Result)localObject).a;
    } else {
      localObject = null;
    }
    if (localObject != null) {}
    try
    {
      localJSONObject.put("aid_ticket", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get());
      localJSONObject.put("taid_ticket", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).taid_ticket.get());
      localJSONObject.put("md5_android_id", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id.get());
      localJSONObject.put("md5_mac", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_mac.get());
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, "GdtDeviceInfo is null");
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.9
 * JD-Core Version:    0.7.0.1
 */