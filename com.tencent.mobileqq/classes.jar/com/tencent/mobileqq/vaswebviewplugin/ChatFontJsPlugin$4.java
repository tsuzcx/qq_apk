package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import org.json.JSONException;
import org.json.JSONObject;

class ChatFontJsPlugin$4
  implements DialogInterface.OnCancelListener
{
  ChatFontJsPlugin$4(ChatFontJsPlugin paramChatFontJsPlugin, JSONObject paramJSONObject, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    try
    {
      this.val$result.put("isUse", 0);
      this.val$result.put("selectbutton", -1);
      this.this$0.callJs(this.val$callbackId, new String[] { this.val$result.toString() });
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
      this.this$0.callJs(this.val$callbackId, new String[] { paramDialogInterface.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */