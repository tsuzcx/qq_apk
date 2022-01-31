package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class UIJsPlugin$1$2
  implements DialogInterface.OnClickListener
{
  UIJsPlugin$1$2(UIJsPlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cancel", true);
      this.this$1.val$req.a(localJSONObject);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QMLog.e("UIJsPlugin", "show modalView error." + paramDialogInterface);
      this.this$1.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.1.2
 * JD-Core Version:    0.7.0.1
 */