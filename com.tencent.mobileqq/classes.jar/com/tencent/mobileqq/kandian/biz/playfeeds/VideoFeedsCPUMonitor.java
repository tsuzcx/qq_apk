package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.BroadcastReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoFeedsCPUMonitor
{
  private static final String a = "VideoFeedsCPUMonitor";
  private static AtomicInteger b = new AtomicInteger(0);
  private static AtomicBoolean c = new AtomicBoolean(false);
  private static AtomicInteger d = new AtomicInteger(0);
  private static int e = 5;
  private static Thread f = null;
  private static BroadcastReceiver g = new VideoFeedsCPUMonitor.1();
  
  private static long g()
  {
    for (long l = 0L; b.get() == 1; l += 1L) {}
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCPUMonitor
 * JD-Core Version:    0.7.0.1
 */