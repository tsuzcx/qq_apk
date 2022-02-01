package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class BridgeModuleHelper$4
  implements DialogInterface.OnClickListener
{
  BridgeModuleHelper$4(JSONObject paramJSONObject, BridgeModule paramBridgeModule, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("button", 1);
      paramDialogInterface.put("buttonText", this.a.optString("okBtnText", ""));
      if (this.b != null)
      {
        this.b.invokeCallJS(this.c, paramDialogInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.4
 * JD-Core Version:    0.7.0.1
 */