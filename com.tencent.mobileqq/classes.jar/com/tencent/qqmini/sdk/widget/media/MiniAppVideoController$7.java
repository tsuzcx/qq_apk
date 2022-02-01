package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import android.os.Message;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import java.util.Queue;
import org.json.JSONException;

class MiniAppVideoController$7
  implements AbsVideoPlayer.OnVideoPreparedListener
{
  MiniAppVideoController$7(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void onVideoPrepared(AbsVideoPlayer paramAbsVideoPlayer)
  {
    MiniAppVideoController.access$1602(this.this$0, true);
    if (!MiniAppVideoController.access$1700(this.this$0)) {
      return;
    }
    for (;;)
    {
      try
      {
        MiniAppVideoController.access$1802(this.this$0, false);
        MiniAppVideoController.access$1702(this.this$0, true);
        MiniAppVideoController.access$1900(this.this$0);
        MiniAppVideoController.access$2000(this.this$0, false);
        if (MiniAppVideoController.access$700(this.this$0))
        {
          if (paramAbsVideoPlayer.isPlaying()) {
            paramAbsVideoPlayer.pause();
          }
          ThreadManager.getUIHandler().post(new MiniAppVideoController.7.1(this));
          MiniAppVideoController.access$702(this.this$0, false);
          if (MiniAppVideoController.access$2500(this.this$0).size() <= 0) {
            break;
          }
          MiniAppVideoController.access$2600(this.this$0).sendMessage((Message)MiniAppVideoController.access$2500(this.this$0).poll());
          continue;
        }
        paramAbsVideoPlayer.start();
      }
      catch (JSONException paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
        return;
      }
      MiniAppVideoController.access$2100(this.this$0);
      MiniAppVideoController.access$2200(this.this$0);
      ThreadManager.getUIHandler().postDelayed(new MiniAppVideoController.7.2(this, paramAbsVideoPlayer), 200L);
      MiniAppVideoController.access$2400(this.this$0, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.7
 * JD-Core Version:    0.7.0.1
 */