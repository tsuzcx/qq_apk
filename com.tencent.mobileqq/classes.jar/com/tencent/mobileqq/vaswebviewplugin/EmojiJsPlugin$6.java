package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class EmojiJsPlugin$6
  implements DialogInterface.OnClickListener
{
  EmojiJsPlugin$6(EmojiJsPlugin paramEmojiJsPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", 2);
      paramDialogInterface.put("message", this.this$0.mRuntime.a().getString(2131691923));
      if (QLog.isColorLevel())
      {
        String str = EmojiJsPlugin.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startDownloadEmoji resp to js:");
        localStringBuilder.append(paramDialogInterface.toString());
        QLog.i(str, 2, localStringBuilder.toString());
      }
      this.this$0.onAppResponse(this.val$callbackid, paramDialogInterface.toString());
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */