package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class LivePusherEmbeddedWidgetClient$1
  implements Runnable
{
  LivePusherEmbeddedWidgetClient$1(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient) {}
  
  public void run()
  {
    QMLog.d("miniapp-embedded-live-pusher", "stopDumpAudio at maxDuration");
    LivePusherEmbeddedWidgetClient.access$000(this.this$0).stopDumpAudioData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.1
 * JD-Core Version:    0.7.0.1
 */