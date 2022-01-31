package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bdfz;
import bdnw;
import org.json.JSONObject;

class UIJsPlugin$3$1
  implements DialogInterface.OnClickListener
{
  UIJsPlugin$3$1(UIJsPlugin.3 param3) {}
  
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
      bdnw.d("UIJsPlugin", "show modalView error." + paramDialogInterface);
      this.this$1.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */