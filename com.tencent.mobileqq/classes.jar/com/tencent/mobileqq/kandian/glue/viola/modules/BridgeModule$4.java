package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment.ViolaGestureLayoutListener;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$4
  implements ViolaFragment.ViolaGestureLayoutListener
{
  BridgeModule$4(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((BridgeModule.access$000(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule) != paramInt) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getViolaInstance() != null)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = CommonSuspensionGestureLayout.c;
      if ((paramInt != i) && (paramInt != CommonSuspensionGestureLayout.e)) {
        localJSONObject.put("state", 0);
      } else {
        localJSONObject.put("state", 1);
      }
      BridgeModule.access$002(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, paramInt);
      ViolaBridgeManager.getInstance().callbackJavascript(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getViolaInstance().getInstanceId(), this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getModuleName(), "callback", this.jdField_a_of_type_JavaLangString, localJSONObject, true);
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.4
 * JD-Core Version:    0.7.0.1
 */