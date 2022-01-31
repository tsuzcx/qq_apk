package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qphone.base.util.QLog;

class MiniAppLivePusher$1
  implements Runnable
{
  MiniAppLivePusher$1(MiniAppLivePusher paramMiniAppLivePusher) {}
  
  public void run()
  {
    QLog.d("MiniAppLivePusher", 1, "stopDumpAudio at maxDuration");
    MiniAppLivePusher.access$000(this.this$0).stopDumpAudioData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePusher.1
 * JD-Core Version:    0.7.0.1
 */