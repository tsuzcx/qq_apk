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
    paramAbsVideoPlayer = new StringBuilder();
    paramAbsVideoPlayer.append("onInfo: ");
    paramAbsVideoPlayer.append(paramInt1);
    paramAbsVideoPlayer.append(" ");
    paramAbsVideoPlayer.append(paramInt1);
    QMLog.i("MiniAppVideoController", paramAbsVideoPlayer.toString());
    Object localObject;
    if (paramInt1 != 21)
    {
      if (paramInt1 == 22)
      {
        QMLog.d("MiniAppVideoController", "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
        try
        {
          paramAbsVideoPlayer = new JSONObject();
          paramAbsVideoPlayer.put("data", MiniAppVideoController.access$2800(this.this$0));
          localObject = MiniAppVideoController.access$1400(this.this$0);
          if (localObject != null) {
            MiniAppVideoController.access$1400(this.this$0).performAction(ServiceSubscribeEvent.obtain("onVideoLoadedData", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0)));
          }
          MiniAppVideoController.access$3100(this.this$0).evaluateSubscribeJS("onVideoLoadedData", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("evaluateSubcribeJS onVideoLoadedData = ");
          ((StringBuilder)localObject).append(paramAbsVideoPlayer.toString());
          QMLog.d("MiniAppVideoController", ((StringBuilder)localObject).toString());
        }
        catch (JSONException paramAbsVideoPlayer)
        {
          paramAbsVideoPlayer.printStackTrace();
        }
      }
    }
    else
    {
      QMLog.d("MiniAppVideoController", "video player PLAYER_INFO_START_BUFFERING--------------");
      try
      {
        paramAbsVideoPlayer = new JSONObject();
        paramAbsVideoPlayer.put("data", MiniAppVideoController.access$2800(this.this$0));
        localObject = MiniAppVideoController.access$1400(this.this$0);
        if (localObject != null) {
          MiniAppVideoController.access$1400(this.this$0).performAction(ServiceSubscribeEvent.obtain("onVideoLoadStart", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0)));
        }
        MiniAppVideoController.access$3100(this.this$0).evaluateSubscribeJS("onVideoLoadStart", paramAbsVideoPlayer.toString(), MiniAppVideoController.access$3000(this.this$0));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("evaluateSubcribeJS onVideoLoadStart = ");
        ((StringBuilder)localObject).append(paramAbsVideoPlayer.toString());
        QMLog.d("MiniAppVideoController", ((StringBuilder)localObject).toString());
      }
      catch (JSONException paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.9
 * JD-Core Version:    0.7.0.1
 */