package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

class ChatFontJsPlugin$3
  implements DialogInterface.OnClickListener
{
  ChatFontJsPlugin$3(ChatFontJsPlugin paramChatFontJsPlugin, JSONObject paramJSONObject, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.val$result.put("selectbutton", 1);
      this.val$result.put("isUse", 0);
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
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */