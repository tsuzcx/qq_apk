package com.tencent.qqmini.sdk.core.widget.media;

import bdcy;
import bdnw;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$16
  implements Runnable
{
  MiniAppVideoPlayer$16(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    if ((!MiniAppVideoPlayer.b(this.this$0)) && (MiniAppVideoPlayer.j(this.this$0) == 0)) {}
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
          i = MiniAppVideoPlayer.j(this.this$0);
          localJSONObject.put("buffered", i);
          localJSONObject.put("videoId", this.this$0.jdField_a_of_type_Long);
          this.this$0.jdField_a_of_type_Bdcy.a("onVideoProgress", localJSONObject.toString(), this.this$0.jdField_a_of_type_Int);
          bdnw.a("MiniAppVideoPlayer", "updateBufferProgress onVideoProgress = " + localJSONObject.toString());
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
        MiniAppVideoPlayer.e(this.this$0, 0);
        return;
        i = 100;
      }
    } while (MiniAppVideoPlayer.j(this.this$0) > 98);
    if (MiniAppVideoPlayer.j(this.this$0) < 60) {
      MiniAppVideoPlayer.e(this.this$0, MiniAppVideoPlayer.j(this.this$0) + 10);
    }
    for (;;)
    {
      MiniAppVideoPlayer.b(this.this$0, true);
      return;
      if (MiniAppVideoPlayer.j(this.this$0) < 90) {
        MiniAppVideoPlayer.e(this.this$0, MiniAppVideoPlayer.j(this.this$0) + 5);
      } else {
        MiniAppVideoPlayer.k(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.16
 * JD-Core Version:    0.7.0.1
 */