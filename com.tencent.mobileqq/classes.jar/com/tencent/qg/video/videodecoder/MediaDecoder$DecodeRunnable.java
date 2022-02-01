package com.tencent.qg.video.videodecoder;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qg.video.VideoPerformanceMonitor;

class MediaDecoder$DecodeRunnable
  implements Runnable
{
  private final Object a;
  public volatile boolean a;
  
  private void a()
  {
    SLog.b("Q.qqstory.mediadecoderMediaDecoder", "release");
    MediaDecoder.a(this.this$0).b();
    if (MediaDecoder.a(this.this$0)) {
      MediaDecoder.a(this.this$0).b();
    }
    if (MediaDecoder.a(this.this$0) != null) {
      MediaDecoder.a(this.this$0).interrupt();
    }
    MediaDecoder.a(this.this$0, null);
  }
  
  private boolean a()
  {
    MediaDecoder localMediaDecoder = this.this$0;
    boolean bool;
    if ((MediaDecoder.c(localMediaDecoder)) && (MediaDecoder.a(this.this$0).a())) {
      bool = true;
    } else {
      bool = false;
    }
    MediaDecoder.b(localMediaDecoder, bool);
    return MediaDecoder.a(this.this$0).a();
  }
  
  private void b()
  {
    SLog.b("Q.qqstory.mediadecoderMediaDecoder", "onPauseFinish");
    MediaDecoder.a(this.this$0).a();
    if (MediaDecoder.a(this.this$0)) {
      MediaDecoder.a(this.this$0).a();
    }
  }
  
  private boolean b()
  {
    if (MediaDecoder.a(this.this$0)) {
      MediaDecoder.a(this.this$0).b();
    }
    boolean bool = MediaDecoder.a(this.this$0).b();
    SLog.a("Q.qqstory.mediadecoderMediaDecoder", "start finish : %s", Boolean.valueOf(bool));
    return bool;
  }
  
  private boolean c()
  {
    int i;
    if (MediaDecoder.a(this.this$0).a() / 1000L <= System.currentTimeMillis() - MediaDecoder.a(this.this$0).b())
    {
      MediaDecoder.a(this.this$0).c();
      MediaDecoder.a(this.this$0).a(MediaDecoder.a(this.this$0).a());
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (MediaDecoder.a(this.this$0))
    {
      j = i;
      if (MediaDecoder.a(this.this$0).a() <= MediaDecoder.a(this.this$0).a() - 500000L)
      {
        MediaDecoder.a(this.this$0).c();
        j = 1;
      }
    }
    if (j == 0) {
      try
      {
        SLog.b("Q.qqstory.mediadecoderMediaDecoder", "no render decode in this round !");
        Thread.sleep(10L);
      }
      catch (InterruptedException localInterruptedException)
      {
        SLog.b("Q.qqstory.mediadecoderMediaDecoder", "decodeFrame sleep error :%s", localInterruptedException);
      }
    }
    if (MediaDecoder.a(this.this$0).c())
    {
      if (MediaDecoder.d(this.this$0))
      {
        MediaDecoder.a(this.this$0).a(0L);
        if (MediaDecoder.a(this.this$0)) {
          MediaDecoder.a(this.this$0).a(0L);
        }
        MediaDecoder.a(this.this$0).d();
        return false;
      }
      return true;
    }
    return false;
  }
  
  public void run()
  {
    try
    {
      VideoPerformanceMonitor.a(MediaDecoder.a(this.this$0).a, "[MediaDecoder] decode thread start run");
      MediaDecoder.a(this.this$0, false);
      if (!a())
      {
        MediaDecoder.a(this.this$0).a(1000, new Exception("init error"));
        MediaDecoder.a(this.this$0, false);
        if (MediaDecoder.a(this.this$0).c()) {
          MediaDecoder.a(this.this$0).b();
        } else {
          MediaDecoder.a(this.this$0).c();
        }
        a();
        return;
      }
      VideoPerformanceMonitor.a(MediaDecoder.a(this.this$0).a, "[MediaDecoder] init decoder finish");
      if (!b())
      {
        MediaDecoder.a(this.this$0).a(1001, new Exception("start error"));
        MediaDecoder.a(this.this$0, false);
        if (MediaDecoder.a(this.this$0).c()) {
          MediaDecoder.a(this.this$0).b();
        } else {
          MediaDecoder.a(this.this$0).c();
        }
        a();
        return;
      }
      VideoPerformanceMonitor.a(MediaDecoder.a(this.this$0).a, "[MediaDecoder] start decoder finish");
      MediaDecoder.a(this.this$0, true);
      MediaDecoder.a(this.this$0).a();
      for (;;)
      {
        if ((!Thread.interrupted()) && (!this.jdField_a_of_type_Boolean))
        {
          if (MediaDecoder.a(this.this$0) >= 0L)
          {
            MediaDecoder.a(this.this$0).a(MediaDecoder.a(this.this$0) * 1000L);
            if (MediaDecoder.a(this.this$0)) {
              MediaDecoder.a(this.this$0).a(MediaDecoder.a(this.this$0) * 1000L);
            }
            MediaDecoder.a(this.this$0, -1L);
          }
          if (!c())
          {
            boolean bool = MediaDecoder.b(this.this$0);
            if (!bool) {
              continue;
            }
            try
            {
              synchronized (this.jdField_a_of_type_JavaLangObject)
              {
                MediaDecoder.a(this.this$0, false);
                if (!this.jdField_a_of_type_Boolean) {
                  this.jdField_a_of_type_JavaLangObject.wait();
                }
                MediaDecoder.a(this.this$0, true);
                b();
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              SLog.b("Q.qqstory.mediadecoderMediaDecoder", "pause error ! %s", localInterruptedException);
              this.jdField_a_of_type_Boolean = true;
            }
          }
        }
      }
      MediaDecoder.a(this.this$0, false);
      if (MediaDecoder.a(this.this$0).c()) {
        MediaDecoder.a(this.this$0).b();
      } else {
        MediaDecoder.a(this.this$0).c();
      }
      a();
      return;
    }
    finally
    {
      MediaDecoder.a(this.this$0, false);
      if (MediaDecoder.a(this.this$0).c()) {
        MediaDecoder.a(this.this$0).b();
      } else {
        MediaDecoder.a(this.this$0).c();
      }
      a();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */