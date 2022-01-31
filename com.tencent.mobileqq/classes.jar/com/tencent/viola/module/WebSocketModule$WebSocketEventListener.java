package com.tencent.viola.module;

import android.text.TextUtils;
import com.tencent.viola.adapter.VWebSocketAdapter.EventListener;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

class WebSocketModule$WebSocketEventListener
  implements VWebSocketAdapter.EventListener
{
  private String onClose;
  private String onError;
  private String onMessage;
  private String onOpen;
  
  private WebSocketModule$WebSocketEventListener(WebSocketModule paramWebSocketModule) {}
  
  public void onClose(int paramInt, String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if ((!TextUtils.isEmpty(this.onClose)) && (this.this$0.getViolaInstance() != null)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("reason", paramString);
      localJSONObject.put("wasClean", paramBoolean);
      ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), "webSocket", "callback", this.onClose, localJSONObject, true);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void onError(String paramString)
  {
    JSONObject localJSONObject;
    if ((!TextUtils.isEmpty(this.onError)) && (this.this$0.getViolaInstance() != null)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("data", paramString);
      ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), "webSocket", "callback", this.onError, localJSONObject, true);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void onMessage(String paramString)
  {
    JSONObject localJSONObject;
    if ((!TextUtils.isEmpty(this.onMessage)) && (this.this$0.getViolaInstance() != null)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("data", paramString);
      ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), "webSocket", "callback", this.onMessage, localJSONObject, true);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void onOpen()
  {
    if ((!TextUtils.isEmpty(this.onOpen)) && (this.this$0.getViolaInstance() != null)) {
      ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), "webSocket", "callback", this.onOpen, new JSONObject(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.module.WebSocketModule.WebSocketEventListener
 * JD-Core Version:    0.7.0.1
 */