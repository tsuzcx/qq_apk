package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.widget.ActionSheet.OnDismissListener;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class ActionSheetHelper$3
  implements ActionSheet.OnDismissListener
{
  ActionSheetHelper$3(ActionSheetHelper paramActionSheetHelper, String paramString) {}
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("index", -1);
      localJSONObject.put("type", 1);
      if (ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesActionSheetHelper) != null) {
        ((BridgeModule)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesActionSheetHelper).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.ActionSheetHelper.3
 * JD-Core Version:    0.7.0.1
 */