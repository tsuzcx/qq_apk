package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import org.json.JSONObject;

class ThemeAndBubbleCommonJsPlugin$3
  implements DialogInterface.OnClickListener
{
  ThemeAndBubbleCommonJsPlugin$3(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", 1);
      paramDialogInterface.put("message", "btn1 press");
      this.this$0.callJs(this.val$callbackId + "(" + paramDialogInterface.toString() + ");");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      this.this$0.callJsOnError(this.val$callbackId, paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */