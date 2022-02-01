package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class MiniAppVideoController$8
  implements AbsVideoPlayer.OnCompletionListener
{
  MiniAppVideoController$8(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void onCompletion(AbsVideoPlayer paramAbsVideoPlayer)
  {
    MiniAppVideoController.access$000(this.this$0).initialTime = 0.0D;
    if (MiniAppVideoController.access$000(this.this$0).isFullScreen) {
      this.this$0.smallScreen();
    }
    if ((MiniAppVideoController.access$1400(this.this$0) != null) && (MiniAppVideoController.access$1400(this.this$0).isMiniGame())) {
      MiniAppVideoController.access$2700(this.this$0, "ended");
    } else {
      try
      {
        paramAbsVideoPlayer = new JSONObject();
        paramAbsVideoPlayer.put("data", MiniAppVideoController.access$2800(this.this$0));
        paramAbsVideoPlayer.put("videoId", MiniAppVideoController.access$2900(this.this$0));
        Object localObject = MiniAppVideoController.access$1400(this.this$0);
        if (localObject != null) {
          MiniAppVideoController.access$1400(this.this$0).performAction(ServiceSubscribeEvent.obtain("onVideoEnded", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0)));
        }
        MiniAppVideoController.access$3100(this.this$0).evaluateSubscribeJS("onVideoEnded", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("evaluateSubcribeJS onVideoEnded = ");
        ((StringBuilder)localObject).append(paramAbsVideoPlayer.toString());
        QMLog.d("MiniAppVideoController", ((StringBuilder)localObject).toString());
      }
      catch (Exception paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
      }
    }
    ThreadManager.getUIHandler().post(new MiniAppVideoController.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.8
 * JD-Core Version:    0.7.0.1
 */