package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import bdkn;
import org.json.JSONObject;

class ThemeAndBubbleCommonJsPlugin$4
  implements DialogInterface.OnKeyListener
{
  ThemeAndBubbleCommonJsPlugin$4(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin, bdkn parambdkn, String paramString) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.val$treeBtnDialog.isShowing()))
    {
      this.val$treeBtnDialog.dismiss();
      paramDialogInterface = new JSONObject();
      try
      {
        paramDialogInterface.put("result", -1);
        paramDialogInterface.put("message", "home back pressed");
        this.this$0.callJs(this.val$callbackId + "(" + paramDialogInterface.toString() + ");");
        return true;
      }
      catch (Exception paramDialogInterface)
      {
        for (;;)
        {
          this.this$0.callJsOnError(this.val$callbackId, paramDialogInterface.getMessage());
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */