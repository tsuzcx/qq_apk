package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$9
  implements AbsVideoPlayer.OnVideoPreparedListener
{
  MiniAppVideoPlayer$9(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onVideoPrepared(AbsVideoPlayer paramAbsVideoPlayer)
  {
    this.this$0.isVideoPrepared = true;
    if (!this.this$0.playingBefore) {
      return;
    }
    label202:
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        if (this.this$0.mMiniAppContext != null)
        {
          paramAbsVideoPlayer = (IMiniAppContext)this.this$0.mMiniAppContext.get();
          if ((paramAbsVideoPlayer == null) || (!paramAbsVideoPlayer.isMiniGame())) {
            break label202;
          }
          MiniAppVideoPlayer.access$2500(this.this$0, "waiting");
          MiniAppVideoPlayer.access$2802(this.this$0, false);
          MiniAppVideoPlayer.access$2900(this.this$0, false);
          this.this$0.playingBefore = true;
          if (!MiniAppVideoPlayer.access$3000(this.this$0)) {
            break label293;
          }
          if (MiniAppVideoPlayer.access$000(this.this$0).isPlaying()) {
            MiniAppVideoPlayer.access$000(this.this$0).pause();
          }
          ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.9.1(this));
          MiniAppVideoPlayer.access$3002(this.this$0, false);
          if (MiniAppVideoPlayer.access$4100(this.this$0).size() <= 0) {
            break;
          }
          MiniAppVideoPlayer.access$2700(this.this$0).sendMessage((Message)MiniAppVideoPlayer.access$4100(this.this$0).poll());
          continue;
        }
        paramAbsVideoPlayer = null;
      }
      catch (JSONException paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
        return;
      }
      continue;
      localJSONObject = new JSONObject();
      localJSONObject.put("videoId", this.this$0.videoId);
      localJSONObject.put("data", this.this$0.data);
      if (paramAbsVideoPlayer != null) {
        paramAbsVideoPlayer.performAction(ServiceSubscribeEvent.obtain("onVideoWaiting", localJSONObject.toString(), this.this$0.webviewId));
      }
      this.this$0.pageWebview.evaluateSubscribeJS("onVideoWaiting", localJSONObject.toString(), this.this$0.webviewId);
    }
    label293:
    MiniAppVideoPlayer.access$000(this.this$0).start();
    this.this$0.postDelayed(new MiniAppVideoPlayer.9.2(this), 200L);
    if ((paramAbsVideoPlayer != null) && (paramAbsVideoPlayer.isMiniGame()))
    {
      MiniAppVideoPlayer.access$2500(this.this$0, "play");
      label344:
      MiniAppVideoPlayer.access$3200(this.this$0);
      ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.9.3(this));
      paramAbsVideoPlayer = new StringBuilder().append("onVideoPrepared: ").append(MiniAppVideoPlayer.access$000(this.this$0).getDuration()).append(" ").append(MiniAppVideoPlayer.access$000(this.this$0).getCurrentPostion()).append(" ");
      if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        break label574;
      }
    }
    label574:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MiniAppVideoPlayer", bool);
      MiniAppVideoPlayer.access$4000(this.this$0, 200L);
      break;
      localJSONObject = new JSONObject();
      localJSONObject.put("videoId", this.this$0.videoId);
      localJSONObject.put("data", this.this$0.data);
      if (paramAbsVideoPlayer != null) {
        paramAbsVideoPlayer.performAction(ServiceSubscribeEvent.obtain("onVideoPlay", localJSONObject.toString(), this.this$0.webviewId));
      }
      this.this$0.pageWebview.evaluateSubscribeJS("onVideoPlay", localJSONObject.toString(), this.this$0.webviewId);
      QMLog.d("MiniAppVideoPlayer", "OnVideoPreparedListener - onVideoPrepared evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
      break label344;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.9
 * JD-Core Version:    0.7.0.1
 */