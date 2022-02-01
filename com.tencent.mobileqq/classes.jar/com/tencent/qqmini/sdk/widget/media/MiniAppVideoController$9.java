package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoController$9
  implements AbsVideoPlayer.OnInfoListener
{
  MiniAppVideoController$9(MiniAppVideoController paramMiniAppVideoController) {}
  
  public boolean onInfo(AbsVideoPlayer paramAbsVideoPlayer, int paramInt1, int paramInt2)
  {
    QMLog.i("MiniAppVideoController", "onInfo: " + paramInt1 + " " + paramInt1);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return false;
      QMLog.d("MiniAppVideoController", "video player PLAYER_INFO_START_BUFFERING--------------");
      try
      {
        paramAbsVideoPlayer = new JSONObject();
        paramAbsVideoPlayer.put("data", MiniAppVideoController.access$2800(this.this$0));
        if (MiniAppVideoController.access$1400(this.this$0) != null) {
          MiniAppVideoController.access$1400(this.this$0).performAction(ServiceSubscribeEvent.obtain("onVideoLoadStart", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0)));
        }
        MiniAppVideoController.access$3100(this.this$0).evaluateSubscribeJS("onVideoLoadStart", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0));
        QMLog.d("MiniAppVideoController", "evaluateSubcribeJS onVideoLoadStart = " + paramAbsVideoPlayer.toString());
      }
      catch (JSONException paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
      }
      continue;
      QMLog.d("MiniAppVideoController", "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
      try
      {
        paramAbsVideoPlayer = new JSONObject();
        paramAbsVideoPlayer.put("data", MiniAppVideoController.access$2800(this.this$0));
        if (MiniAppVideoController.access$1400(this.this$0) != null) {
          MiniAppVideoController.access$1400(this.this$0).performAction(ServiceSubscribeEvent.obtain("onVideoLoadedData", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0)));
        }
        MiniAppVideoController.access$3100(this.this$0).evaluateSubscribeJS("onVideoLoadedData", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0));
        QMLog.d("MiniAppVideoController", "evaluateSubcribeJS onVideoLoadedData = " + paramAbsVideoPlayer.toString());
      }
      catch (JSONException paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.9
 * JD-Core Version:    0.7.0.1
 */