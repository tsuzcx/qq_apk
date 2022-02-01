package com.tencent.mobileqq.gamecenter.web;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class QQGameFeedWebFragment$8
  implements Runnable
{
  QQGameFeedWebFragment$8(QQGameFeedWebFragment paramQQGameFeedWebFragment, long paramLong) {}
  
  public void run()
  {
    try
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clickTime", this.this$0.l);
      localJSONObject.put("initPageTime", this.this$0.b);
      localJSONObject.put("showWebViewTime", this.this$0.c + this.a);
      localJSONObject.put("initWebViewTime", this.this$0.c);
      localJSONObject.put("loadRequestStart", this.this$0.d);
      localJSONObject.put("finishLoadEnd", this.this$0.e);
      localMessage.obj = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "pref data:" + localJSONObject.toString());
      }
      QQGameFeedWebFragment.a(this.this$0).sendMessage(localMessage);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.8
 * JD-Core Version:    0.7.0.1
 */