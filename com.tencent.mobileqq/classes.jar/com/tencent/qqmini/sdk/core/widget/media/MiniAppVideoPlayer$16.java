package com.tencent.qqmini.sdk.core.widget.media;

import bglu;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$16
  implements Runnable
{
  MiniAppVideoPlayer$16(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    if ((!MiniAppVideoPlayer.b(this.this$0)) && (MiniAppVideoPlayer.l(this.this$0) == 0)) {}
    label169:
    do
    {
      return;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", this.this$0.jdField_a_of_type_JavaLangString);
          if (!MiniAppVideoPlayer.b(this.this$0)) {
            continue;
          }
          i = MiniAppVideoPlayer.l(this.this$0);
          localJSONObject.put("buffered", i);
          localJSONObject.put("videoId", this.this$0.jdField_a_of_type_Long);
          this.this$0.jdField_a_of_type_Bglu.a("onVideoProgress", localJSONObject.toString(), this.this$0.jdField_a_of_type_Int);
          QMLog.d("MiniAppVideoPlayer", "updateBufferProgress onVideoProgress = " + localJSONObject.toString());
        }
        catch (JSONException localJSONException)
        {
          int i;
          localJSONException.printStackTrace();
          continue;
        }
        if (MiniAppVideoPlayer.b(this.this$0)) {
          break label169;
        }
        MiniAppVideoPlayer.g(this.this$0, 0);
        return;
        i = 100;
      }
    } while (MiniAppVideoPlayer.l(this.this$0) > 98);
    if (MiniAppVideoPlayer.l(this.this$0) < 60) {
      MiniAppVideoPlayer.g(this.this$0, MiniAppVideoPlayer.l(this.this$0) + 10);
    }
    for (;;)
    {
      MiniAppVideoPlayer.b(this.this$0, true);
      return;
      if (MiniAppVideoPlayer.l(this.this$0) < 90) {
        MiniAppVideoPlayer.g(this.this$0, MiniAppVideoPlayer.l(this.this$0) + 5);
      } else {
        MiniAppVideoPlayer.m(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.16
 * JD-Core Version:    0.7.0.1
 */