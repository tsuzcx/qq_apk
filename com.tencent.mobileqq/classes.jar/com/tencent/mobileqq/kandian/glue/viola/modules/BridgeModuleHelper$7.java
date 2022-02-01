package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class BridgeModuleHelper$7
  implements View.OnClickListener
{
  BridgeModuleHelper$7(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new JSONObject();
    try
    {
      paramView.put("timestamp", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setTitleClickListener]: ");
      localStringBuilder.append(paramView.getMessage());
      QLog.e("BridgeModuleHelper", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.7
 * JD-Core Version:    0.7.0.1
 */