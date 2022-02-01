package com.tencent.qqmini.miniapp.widget.media;

import com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppLivePusher$1
  implements Runnable
{
  MiniAppLivePusher$1(MiniAppLivePusher paramMiniAppLivePusher) {}
  
  public void run()
  {
    QMLog.d("MiniAppLivePusher", "stopDumpAudio at maxDuration");
    MiniAppLivePusher.access$000(this.this$0).stopDumpAudioData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.1
 * JD-Core Version:    0.7.0.1
 */