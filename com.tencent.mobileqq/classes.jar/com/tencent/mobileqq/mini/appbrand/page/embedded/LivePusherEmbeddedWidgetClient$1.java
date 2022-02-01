package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qphone.base.util.QLog;

class LivePusherEmbeddedWidgetClient$1
  implements Runnable
{
  LivePusherEmbeddedWidgetClient$1(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient) {}
  
  public void run()
  {
    QLog.d("miniapp-embedded-live-pusher", 1, "stopDumpAudio at maxDuration");
    LivePusherEmbeddedWidgetClient.access$000(this.this$0).stopDumpAudioData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.LivePusherEmbeddedWidgetClient.1
 * JD-Core Version:    0.7.0.1
 */