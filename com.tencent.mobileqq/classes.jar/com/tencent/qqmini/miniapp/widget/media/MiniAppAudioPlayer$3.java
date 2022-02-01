package com.tencent.qqmini.miniapp.widget.media;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener.ReceiveListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppAudioPlayer$3
  implements ScreenOffOnListener.ReceiveListener
{
  MiniAppAudioPlayer$3(MiniAppAudioPlayer paramMiniAppAudioPlayer) {}
  
  public void onReceiveListener(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QMLog.i("MiniAppAudioPlayer", "onReceiveListener:" + paramContext);
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) && (this.this$0.isPlaying())) {
      this.this$0.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.3
 * JD-Core Version:    0.7.0.1
 */