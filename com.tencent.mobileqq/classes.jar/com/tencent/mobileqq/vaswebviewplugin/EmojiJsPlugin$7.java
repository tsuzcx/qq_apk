package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class EmojiJsPlugin$7
  implements DialogInterface.OnKeyListener
{
  EmojiJsPlugin$7(EmojiJsPlugin paramEmojiJsPlugin, QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, String paramString) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.val$treeBtnDialog.isShowing()))
    {
      this.val$treeBtnDialog.dismiss();
      paramDialogInterface = new JSONObject();
      try
      {
        paramDialogInterface.put("result", 2);
        paramDialogInterface.put("message", this.this$0.mRuntime.d().getString(2131888890));
        if (QLog.isColorLevel())
        {
          paramKeyEvent = EmojiJsPlugin.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startDownloadEmoji resp to js:");
          localStringBuilder.append(paramDialogInterface.toString());
          QLog.i(paramKeyEvent, 2, localStringBuilder.toString());
        }
        this.this$0.onAppResponse(this.val$callbackid, paramDialogInterface.toString());
      }
      catch (JSONException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */