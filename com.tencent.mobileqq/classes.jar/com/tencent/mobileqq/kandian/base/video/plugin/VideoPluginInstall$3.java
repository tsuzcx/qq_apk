package com.tencent.mobileqq.kandian.base.video.plugin;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class VideoPluginInstall$3
  implements Handler.Callback
{
  VideoPluginInstall$3(VideoPluginInstall paramVideoPluginInstall) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        VideoPluginInstall.a(this.a, true);
        return true;
      }
      VideoPluginInstall.a(this.a, false);
      VideoPluginInstall.b(this.a).removeMessages(1);
      if (VideoPluginInstall.d(this.a) != null)
      {
        VideoPluginInstall.d(this.a).a(false);
        return true;
      }
    }
    else
    {
      VideoPluginInstall.a(this.a, false);
      VideoPluginInstall.b(this.a).removeMessages(0);
      if (VideoPluginInstall.d(this.a) != null) {
        VideoPluginInstall.d(this.a).a(true);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall.3
 * JD-Core Version:    0.7.0.1
 */