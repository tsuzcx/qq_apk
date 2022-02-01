package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent;
import org.json.JSONException;
import org.json.JSONObject;

class CustomWebModule$7
  implements Observer<SendChatInputEvent>
{
  CustomWebModule$7(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable SendChatInputEvent paramSendChatInputEvent)
  {
    if ((paramSendChatInputEvent == null) || (this.a.a == null)) {}
    int i;
    do
    {
      return;
      i = paramSendChatInputEvent.mType;
      if (i == 1) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("content", paramSendChatInputEvent.mContent);
          paramSendChatInputEvent = "javascript:(__WEBVIEW_SENDTEXT(" + localJSONObject.toString() + "))";
          this.a.a.evaluateJavascript(paramSendChatInputEvent, new CustomWebModule.7.1(this));
          return;
        }
        catch (JSONException paramSendChatInputEvent)
        {
          paramSendChatInputEvent.printStackTrace();
          return;
        }
      }
    } while (i != 2);
    this.a.a.evaluateJavascript("javascript:__WEBVIEW_CANCELKEYBOARD()", new CustomWebModule.7.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.7
 * JD-Core Version:    0.7.0.1
 */