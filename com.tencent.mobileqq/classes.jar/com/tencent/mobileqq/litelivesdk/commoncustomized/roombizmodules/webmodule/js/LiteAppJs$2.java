package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class LiteAppJs$2
  implements DialogInterface.OnDismissListener
{
  LiteAppJs$2(LiteAppJs paramLiteAppJs, Map paramMap) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("url", this.jdField_a_of_type_JavaUtilMap.get("url"));
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsLiteAppJs.callJsFunctionByNative("__PENDANT_WEBVIEW_CLOSE", paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs.2
 * JD-Core Version:    0.7.0.1
 */