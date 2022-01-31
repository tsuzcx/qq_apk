package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bekr;
import betc;
import org.json.JSONObject;

class UIJsPlugin$4$1
  implements DialogInterface.OnClickListener
{
  UIJsPlugin$4$1(UIJsPlugin.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("confirm", true);
      this.this$1.val$req.a(localJSONObject);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      betc.d("UIJsPlugin", "show modalView error." + paramDialogInterface);
      this.this$1.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */