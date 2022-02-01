package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$18
  implements Runnable
{
  MiniAppVideoPlayer$18(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    if ((!MiniAppVideoPlayer.access$3000(this.this$0)) && (MiniAppVideoPlayer.access$5500(this.this$0) == 0)) {}
    label170:
    do
    {
      return;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", this.this$0.data);
          if (!MiniAppVideoPlayer.access$3000(this.this$0)) {
            continue;
          }
          i = MiniAppVideoPlayer.access$5500(this.this$0);
          localJSONObject.put("buffered", i);
          localJSONObject.put("videoId", this.this$0.videoId);
          this.this$0.serviceWebview.evaluateSubcribeJS("onVideoProgress", localJSONObject.toString(), this.this$0.webviewId);
          QLog.d("MiniAppVideoPlayer", 4, "updateBufferProgress onVideoProgress = " + localJSONObject.toString());
        }
        catch (JSONException localJSONException)
        {
          int i;
          localJSONException.printStackTrace();
          continue;
        }
        if (MiniAppVideoPlayer.access$3000(this.this$0)) {
          break label170;
        }
        MiniAppVideoPlayer.access$5502(this.this$0, 0);
        return;
        i = 100;
      }
    } while (MiniAppVideoPlayer.access$5500(this.this$0) > 98);
    if (MiniAppVideoPlayer.access$5500(this.this$0) < 60) {
      MiniAppVideoPlayer.access$5502(this.this$0, MiniAppVideoPlayer.access$5500(this.this$0) + 10);
    }
    for (;;)
    {
      MiniAppVideoPlayer.access$3100(this.this$0, true);
      return;
      if (MiniAppVideoPlayer.access$5500(this.this$0) < 90) {
        MiniAppVideoPlayer.access$5502(this.this$0, MiniAppVideoPlayer.access$5500(this.this$0) + 5);
      } else {
        MiniAppVideoPlayer.access$5508(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.18
 * JD-Core Version:    0.7.0.1
 */