package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.ilive.litepages.room.webmodule.event.WebviewTransmitEvent;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class CustomWebModule$4
  implements Observer<WebviewTransmitEvent>
{
  CustomWebModule$4(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable WebviewTransmitEvent paramWebviewTransmitEvent)
  {
    QLog.d("IliveCustomWebModule", 1, "WebviewTransmitEvent WebviewTransmitEvent");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("action", paramWebviewTransmitEvent.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:(");
      localStringBuilder.append(paramWebviewTransmitEvent.b);
      localStringBuilder.append("(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append("))");
      paramWebviewTransmitEvent = localStringBuilder.toString();
      if (this.a.f != null)
      {
        this.a.f.evaluateJavascript(paramWebviewTransmitEvent, new CustomWebModule.4.1(this));
        return;
      }
    }
    catch (JSONException paramWebviewTransmitEvent)
    {
      paramWebviewTransmitEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.4
 * JD-Core Version:    0.7.0.1
 */