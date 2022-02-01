package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AvatarPendantJsPlugin$2
  implements DialogInterface.OnClickListener
{
  AvatarPendantJsPlugin$2(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", 0);
      localObject = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$callbackId);
      localStringBuilder.append("(");
      localStringBuilder.append(paramDialogInterface.toString());
      localStringBuilder.append(");");
      ((AvatarPendantJsPlugin)localObject).callJs(localStringBuilder.toString());
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showMsgBox failed: ");
        ((StringBuilder)localObject).append(paramDialogInterface.getMessage());
        QLog.e("AvatarPendantJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      this.this$0.callJsOnError(this.val$callbackId, paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */