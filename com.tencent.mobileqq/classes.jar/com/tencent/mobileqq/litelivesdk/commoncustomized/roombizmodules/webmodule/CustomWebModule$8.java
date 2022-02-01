package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent;
import org.json.JSONException;
import org.json.JSONObject;

class CustomWebModule$8
  implements Observer<SendChatInputEvent>
{
  CustomWebModule$8(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable SendChatInputEvent paramSendChatInputEvent)
  {
    if (paramSendChatInputEvent != null)
    {
      if (this.a.a == null) {
        return;
      }
      int i = paramSendChatInputEvent.mType;
      if (i == 1) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("content", paramSendChatInputEvent.mContent);
          paramSendChatInputEvent = new StringBuilder();
          paramSendChatInputEvent.append("javascript:(__WEBVIEW_SENDTEXT(");
          paramSendChatInputEvent.append(localJSONObject.toString());
          paramSendChatInputEvent.append("))");
          paramSendChatInputEvent = paramSendChatInputEvent.toString();
          this.a.a.evaluateJavascript(paramSendChatInputEvent, new CustomWebModule.8.1(this));
          return;
        }
        catch (JSONException paramSendChatInputEvent)
        {
          paramSendChatInputEvent.printStackTrace();
          return;
        }
      }
      if (i == 2) {
        this.a.a.evaluateJavascript("javascript:__WEBVIEW_CANCELKEYBOARD()", new CustomWebModule.8.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.8
 * JD-Core Version:    0.7.0.1
 */