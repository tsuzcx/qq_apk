package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoController$12
  implements Runnable
{
  MiniAppVideoController$12(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void run()
  {
    if ((!MiniAppVideoController.access$1800(this.this$0)) && (MiniAppVideoController.access$3200(this.this$0) == 0)) {}
    label208:
    do
    {
      return;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", MiniAppVideoController.access$2800(this.this$0));
          if (!MiniAppVideoController.access$1800(this.this$0)) {
            continue;
          }
          i = MiniAppVideoController.access$3200(this.this$0);
          localJSONObject.put("buffered", i);
          localJSONObject.put("videoId", MiniAppVideoController.access$2900(this.this$0));
          if (MiniAppVideoController.access$1400(this.this$0) != null) {
            MiniAppVideoController.access$1400(this.this$0).performAction(ServiceSubscribeEvent.obtain("onVideoProgress", localJSONObject.toString(), MiniAppVideoController.access$3000(this.this$0)));
          }
          MiniAppVideoController.access$3100(this.this$0).evaluateSubscribeJS("onVideoProgress", localJSONObject.toString(), MiniAppVideoController.access$3000(this.this$0));
          QMLog.d("MiniAppVideoController", "updateBufferProgress onVideoProgress = " + localJSONObject.toString());
        }
        catch (JSONException localJSONException)
        {
          int i;
          localJSONException.printStackTrace();
          continue;
        }
        if (MiniAppVideoController.access$1800(this.this$0)) {
          break label208;
        }
        MiniAppVideoController.access$3202(this.this$0, 0);
        return;
        i = 100;
      }
    } while (MiniAppVideoController.access$3200(this.this$0) > 98);
    if (MiniAppVideoController.access$3200(this.this$0) < 60) {
      MiniAppVideoController.access$3202(this.this$0, MiniAppVideoController.access$3200(this.this$0) + 10);
    }
    for (;;)
    {
      MiniAppVideoController.access$2000(this.this$0, true);
      return;
      if (MiniAppVideoController.access$3200(this.this$0) < 90) {
        MiniAppVideoController.access$3202(this.this$0, MiniAppVideoController.access$3200(this.this$0) + 5);
      } else {
        MiniAppVideoController.access$3208(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.12
 * JD-Core Version:    0.7.0.1
 */