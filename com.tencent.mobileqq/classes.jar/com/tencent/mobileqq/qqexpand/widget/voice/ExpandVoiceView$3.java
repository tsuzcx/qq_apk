package com.tencent.mobileqq.qqexpand.widget.voice;

import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import mqq.app.AppRuntime;

final class ExpandVoiceView$3
  implements Runnable
{
  ExpandVoiceView$3(AppRuntime paramAppRuntime, File paramFile) {}
  
  public void run()
  {
    HttpDownloadUtil.downloadData(this.a, "https://down.qq.com/extendfriend/voicewave.png", this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView.3
 * JD-Core Version:    0.7.0.1
 */