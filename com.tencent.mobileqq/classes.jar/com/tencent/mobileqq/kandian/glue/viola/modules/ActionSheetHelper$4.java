package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class ActionSheetHelper$4
  implements DialogInterface.OnCancelListener
{
  ActionSheetHelper$4(ActionSheetHelper paramActionSheetHelper, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", ActionSheetHelper.c(this.b));
      paramDialogInterface.put("type", 1);
      if (ActionSheetHelper.a(this.b) != null) {
        ((BridgeModule)ActionSheetHelper.a(this.b).get()).invokeCallJS(this.a, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.ActionSheetHelper.4
 * JD-Core Version:    0.7.0.1
 */