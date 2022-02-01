package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class MiniAppVideoPlayer$8
  implements AbsVideoPlayer.OnCompletionListener
{
  MiniAppVideoPlayer$8(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onCompletion(AbsVideoPlayer paramAbsVideoPlayer)
  {
    if (this.this$0.isFullScreen) {
      ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.8.1(this));
    }
    if (this.this$0.mMiniAppContext != null)
    {
      paramAbsVideoPlayer = (IMiniAppContext)this.this$0.mMiniAppContext.get();
      if ((paramAbsVideoPlayer == null) || (!paramAbsVideoPlayer.isMiniGame())) {
        break label92;
      }
      MiniAppVideoPlayer.access$2500(this.this$0, "ended");
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.8.2(this));
      return;
      paramAbsVideoPlayer = null;
      break;
      try
      {
        label92:
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", this.this$0.data);
        localJSONObject.put("videoId", this.this$0.videoId);
        if (paramAbsVideoPlayer != null) {
          paramAbsVideoPlayer.performAction(ServiceSubscribeEvent.obtain("onVideoEnded", localJSONObject.toString(), this.this$0.webviewId));
        }
        this.this$0.pageWebview.evaluateSubscribeJS("onVideoEnded", localJSONObject.toString(), this.this$0.webviewId);
        QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoEnded = " + localJSONObject.toString());
      }
      catch (Exception paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.8
 * JD-Core Version:    0.7.0.1
 */