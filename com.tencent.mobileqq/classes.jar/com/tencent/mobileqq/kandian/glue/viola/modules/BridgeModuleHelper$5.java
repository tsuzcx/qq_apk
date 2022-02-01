package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class BridgeModuleHelper$5
  implements DialogInterface.OnClickListener
{
  BridgeModuleHelper$5(JSONObject paramJSONObject, BridgeModule paramBridgeModule, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("button", 0);
      paramDialogInterface.put("buttonText", this.jdField_a_of_type_OrgJsonJSONObject.optString("cancelBtnText", ""));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
        return;
      }
    }
    catch (JSONException paramDialogInterface)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showDialog error");
        localStringBuilder.append(paramDialogInterface.getMessage());
        QLog.e("BridgeModuleHelper", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.5
 * JD-Core Version:    0.7.0.1
 */