package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class UIJsPlugin$5$2
  implements DialogInterface.OnClickListener
{
  UIJsPlugin$5$2(UIJsPlugin.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cancel", true);
      this.this$1.val$req.ok((JSONObject)localObject);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.dismiss();
        return;
      }
    }
    catch (Exception paramDialogInterface)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show modalView error.");
      ((StringBuilder)localObject).append(paramDialogInterface);
      QMLog.e("UIJsPlugin", ((StringBuilder)localObject).toString());
      this.this$1.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin.5.2
 * JD-Core Version:    0.7.0.1
 */