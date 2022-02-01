package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoController$10
  implements AbsVideoPlayer.OnErrorListener
{
  MiniAppVideoController$10(MiniAppVideoController paramMiniAppVideoController) {}
  
  public boolean onError(AbsVideoPlayer paramAbsVideoPlayer, int paramInt1, int paramInt2)
  {
    paramAbsVideoPlayer = new StringBuilder();
    paramAbsVideoPlayer.append("video onError: m what=");
    paramAbsVideoPlayer.append(paramInt1);
    paramAbsVideoPlayer.append(" extra=");
    paramAbsVideoPlayer.append(paramInt2);
    QMLog.e("MiniAppVideoController", paramAbsVideoPlayer.toString());
    if ((MiniAppVideoController.access$1400(this.this$0) != null) && (MiniAppVideoController.access$1400(this.this$0).isMiniGame())) {
      MiniAppVideoController.access$2700(this.this$0, "error");
    } else {
      try
      {
        paramAbsVideoPlayer = new JSONObject();
        paramAbsVideoPlayer.put("videoId", MiniAppVideoController.access$2900(this.this$0));
        paramAbsVideoPlayer.put("data", MiniAppVideoController.access$2800(this.this$0));
        Object localObject = MiniAppVideoController.access$1400(this.this$0);
        if (localObject != null) {
          MiniAppVideoController.access$1400(this.this$0).performAction(ServiceSubscribeEvent.obtain("onVideoError", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0)));
        }
        MiniAppVideoController.access$3100(this.this$0).evaluateSubscribeJS("onVideoError", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("evaluateSubcribeJS onVideoError = ");
        ((StringBuilder)localObject).append(paramAbsVideoPlayer.toString());
        QMLog.d("MiniAppVideoController", ((StringBuilder)localObject).toString());
      }
      catch (JSONException paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.10
 * JD-Core Version:    0.7.0.1
 */