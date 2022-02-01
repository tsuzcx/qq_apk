package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$8
  implements DialogInterface.OnDismissListener
{
  BridgeModule$8(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("type", -1);
      paramDialogInterface.put("action", "close");
      if (!TextUtils.isEmpty(this.a))
      {
        this.b.invokeCallJS(this.a, paramDialogInterface);
        return;
      }
    }
    catch (JSONException paramDialogInterface)
    {
      QLog.e("BridgeModule", 2, QLog.getStackTraceString(paramDialogInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.8
 * JD-Core Version:    0.7.0.1
 */