package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import org.json.JSONObject;

class ThemeAndBubbleCommonJsPlugin$2
  implements DialogInterface.OnClickListener
{
  ThemeAndBubbleCommonJsPlugin$2(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", 1);
      paramDialogInterface.put("message", "btn1 press");
      ThemeAndBubbleCommonJsPlugin localThemeAndBubbleCommonJsPlugin = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$callbackId);
      localStringBuilder.append("(");
      localStringBuilder.append(paramDialogInterface.toString());
      localStringBuilder.append(");");
      localThemeAndBubbleCommonJsPlugin.callJs(localStringBuilder.toString());
      return;
    }
    catch (Exception paramDialogInterface)
    {
      this.this$0.callJsOnError(this.val$callbackId, paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */