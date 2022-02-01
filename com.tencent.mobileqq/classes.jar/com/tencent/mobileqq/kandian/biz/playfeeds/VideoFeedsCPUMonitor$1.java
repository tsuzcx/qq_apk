package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

final class VideoFeedsCPUMonitor$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(VideoFeedsCPUMonitor.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((VideoFeedsCPUMonitor.b().get() == 0) && (VideoFeedsCPUMonitor.c().get() < VideoFeedsCPUMonitor.d()))
      {
        VideoFeedsCPUMonitor.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        VideoFeedsCPUMonitor.b().set(1);
        VideoFeedsCPUMonitor.f().start();
      }
    }
    else if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(VideoFeedsCPUMonitor.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
      if (VideoFeedsCPUMonitor.b().get() == 1)
      {
        if ((VideoFeedsCPUMonitor.f() != null) && (VideoFeedsCPUMonitor.f().isAlive())) {
          VideoFeedsCPUMonitor.f().interrupt();
        }
        VideoFeedsCPUMonitor.b().set(3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCPUMonitor.1
 * JD-Core Version:    0.7.0.1
 */