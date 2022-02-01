package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.json.JSONException;
import org.json.JSONObject;

class HuayangJsPlugin$2
  extends Handler
{
  HuayangJsPlugin$2(HuayangJsPlugin paramHuayangJsPlugin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if ((i < HuayangJsPlugin.b(this.a)) || (i > 95)) {
      return;
    }
    HuayangJsPlugin.b(this.a, i);
    HuayangJsPlugin.a(this.a, "STATE_Loading:" + i);
    paramMessage = new JSONObject();
    try
    {
      paramMessage.putOpt("state", Integer.valueOf(4));
      paramMessage.putOpt("totalSize", Integer.valueOf(100));
      paramMessage.putOpt("pro", Integer.valueOf(i));
      this.a.callJs(this.a.a, new String[] { paramMessage.toString() });
      paramMessage = Message.obtain();
      paramMessage.arg1 = (i + 5);
      sendMessageDelayed(paramMessage, 500L);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */