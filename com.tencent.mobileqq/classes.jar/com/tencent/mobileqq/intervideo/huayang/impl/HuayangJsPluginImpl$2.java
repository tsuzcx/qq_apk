package com.tencent.mobileqq.intervideo.huayang.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.json.JSONException;
import org.json.JSONObject;

class HuayangJsPluginImpl$2
  extends Handler
{
  HuayangJsPluginImpl$2(HuayangJsPluginImpl paramHuayangJsPluginImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (i >= HuayangJsPluginImpl.access$600(this.a))
    {
      if (i > 95) {
        return;
      }
      HuayangJsPluginImpl.access$602(this.a, i);
      paramMessage = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("STATE_Loading:");
      localStringBuilder.append(i);
      HuayangJsPluginImpl.access$200(paramMessage, localStringBuilder.toString());
      paramMessage = new JSONObject();
      try
      {
        paramMessage.putOpt("state", Integer.valueOf(4));
        paramMessage.putOpt("totalSize", Integer.valueOf(100));
        paramMessage.putOpt("pro", Integer.valueOf(i));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      HuayangJsPluginImpl localHuayangJsPluginImpl = this.a;
      localHuayangJsPluginImpl.callJs(localHuayangJsPluginImpl.mJsNotifyCallback, new String[] { paramMessage.toString() });
      paramMessage = Message.obtain();
      paramMessage.arg1 = (i + 5);
      sendMessageDelayed(paramMessage, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangJsPluginImpl.2
 * JD-Core Version:    0.7.0.1
 */