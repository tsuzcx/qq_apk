package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$5
  implements AbsVideoPlayer.OnSeekCompleteListener
{
  MiniAppVideoPlayer$5(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onSeekComplete(AbsVideoPlayer paramAbsVideoPlayer)
  {
    ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.5.1(this));
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.this$0.data);
      if (this.this$0.mMiniAppContext != null) {}
      for (paramAbsVideoPlayer = (IMiniAppContext)this.this$0.mMiniAppContext.get();; paramAbsVideoPlayer = null)
      {
        if (paramAbsVideoPlayer != null) {
          paramAbsVideoPlayer.performAction(ServiceSubscribeEvent.obtain("onVideoSeeked", localJSONObject.toString(), this.this$0.webviewId));
        }
        this.this$0.pageWebview.evaluateSubscribeJS("onVideoSeeked", localJSONObject.toString(), this.this$0.webviewId);
        QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoSeeked = " + localJSONObject.toString());
        return;
      }
      return;
    }
    catch (JSONException paramAbsVideoPlayer)
    {
      paramAbsVideoPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */