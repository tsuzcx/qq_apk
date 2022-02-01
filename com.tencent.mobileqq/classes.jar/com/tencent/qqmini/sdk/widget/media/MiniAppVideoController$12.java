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
    if ((!MiniAppVideoController.access$1800(this.this$0)) && (MiniAppVideoController.access$3200(this.this$0) == 0)) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", MiniAppVideoController.access$2800(this.this$0));
        if (!MiniAppVideoController.access$1800(this.this$0)) {
          break label306;
        }
        i = MiniAppVideoController.access$3200(this.this$0);
        localJSONObject.put("buffered", i);
        localJSONObject.put("videoId", MiniAppVideoController.access$2900(this.this$0));
        Object localObject = MiniAppVideoController.access$1400(this.this$0);
        if (localObject != null) {
          MiniAppVideoController.access$1400(this.this$0).performAction(ServiceSubscribeEvent.obtain("onVideoProgress", localJSONObject.toString(), MiniAppVideoController.access$3000(this.this$0)));
        }
        MiniAppVideoController.access$3100(this.this$0).evaluateSubscribeJS("onVideoProgress", localJSONObject.toString(), MiniAppVideoController.access$3000(this.this$0));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateBufferProgress onVideoProgress = ");
        ((StringBuilder)localObject).append(localJSONObject.toString());
        QMLog.d("MiniAppVideoController", ((StringBuilder)localObject).toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (!MiniAppVideoController.access$1800(this.this$0))
      {
        MiniAppVideoController.access$3202(this.this$0, 0);
        return;
      }
      if (MiniAppVideoController.access$3200(this.this$0) > 98) {
        return;
      }
      MiniAppVideoController localMiniAppVideoController;
      if (MiniAppVideoController.access$3200(this.this$0) < 60)
      {
        localMiniAppVideoController = this.this$0;
        MiniAppVideoController.access$3202(localMiniAppVideoController, MiniAppVideoController.access$3200(localMiniAppVideoController) + 10);
      }
      else if (MiniAppVideoController.access$3200(this.this$0) < 90)
      {
        localMiniAppVideoController = this.this$0;
        MiniAppVideoController.access$3202(localMiniAppVideoController, MiniAppVideoController.access$3200(localMiniAppVideoController) + 5);
      }
      else
      {
        MiniAppVideoController.access$3208(this.this$0);
      }
      MiniAppVideoController.access$2000(this.this$0, true);
      return;
      label306:
      int i = 100;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.12
 * JD-Core Version:    0.7.0.1
 */