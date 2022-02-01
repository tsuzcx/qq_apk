package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$7
  implements AbsVideoPlayer.OnErrorListener
{
  MiniAppVideoPlayer$7(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onError(AbsVideoPlayer paramAbsVideoPlayer, int paramInt1, int paramInt2)
  {
    QMLog.e("MiniAppVideoPlayer", "video onError: m what=" + paramInt1 + " extra=" + paramInt2);
    if (this.this$0.mMiniAppContext != null)
    {
      paramAbsVideoPlayer = (IMiniAppContext)this.this$0.mMiniAppContext.get();
      if ((paramAbsVideoPlayer == null) || (!paramAbsVideoPlayer.isMiniGame())) {
        break label86;
      }
      MiniAppVideoPlayer.access$2500(this.this$0, "error");
    }
    for (;;)
    {
      return true;
      paramAbsVideoPlayer = null;
      break;
      try
      {
        label86:
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoId", this.this$0.videoId);
        localJSONObject.put("data", this.this$0.data);
        if (paramAbsVideoPlayer != null) {
          paramAbsVideoPlayer.performAction(ServiceSubscribeEvent.obtain("onVideoError", localJSONObject.toString(), this.this$0.webviewId));
        }
        this.this$0.pageWebview.evaluateSubscribeJS("onVideoError", localJSONObject.toString(), this.this$0.webviewId);
        QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoError = " + localJSONObject.toString());
      }
      catch (JSONException paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.7
 * JD-Core Version:    0.7.0.1
 */