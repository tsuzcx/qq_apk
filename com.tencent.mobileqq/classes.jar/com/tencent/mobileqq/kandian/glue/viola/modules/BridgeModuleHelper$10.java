package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.startup.step.CheckPermission.SDCardPermissionCallback;
import org.json.JSONObject;

final class BridgeModuleHelper$10
  implements CheckPermission.SDCardPermissionCallback
{
  BridgeModuleHelper$10(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString) {}
  
  public void a()
  {
    BridgeModuleHelper.y(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_JavaLangString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, "saveImage reject Permission");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.10
 * JD-Core Version:    0.7.0.1
 */