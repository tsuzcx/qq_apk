package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoController$11
  implements AbsVideoPlayer.OnSeekCompleteListener
{
  MiniAppVideoController$11(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void onSeekComplete(AbsVideoPlayer paramAbsVideoPlayer)
  {
    ThreadManager.getUIHandler().post(new MiniAppVideoController.11.1(this));
    try
    {
      paramAbsVideoPlayer = new JSONObject();
      paramAbsVideoPlayer.put("data", MiniAppVideoController.access$2800(this.this$0));
      Object localObject = MiniAppVideoController.access$1400(this.this$0);
      if (localObject != null) {
        MiniAppVideoController.access$1400(this.this$0).performAction(ServiceSubscribeEvent.obtain("onVideoSeeked", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0)));
      }
      MiniAppVideoController.access$3100(this.this$0).evaluateSubscribeJS("onVideoSeeked", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("evaluateSubcribeJS onVideoSeeked = ");
      ((StringBuilder)localObject).append(paramAbsVideoPlayer.toString());
      QMLog.d("MiniAppVideoController", ((StringBuilder)localObject).toString());
      return;
    }
    catch (JSONException paramAbsVideoPlayer)
    {
      paramAbsVideoPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.11
 * JD-Core Version:    0.7.0.1
 */