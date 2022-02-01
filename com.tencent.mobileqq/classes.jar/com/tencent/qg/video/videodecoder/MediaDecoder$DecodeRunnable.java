package com.tencent.qg.video.videodecoder;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qg.video.VideoPerformanceMonitor;

class MediaDecoder$DecodeRunnable
  implements Runnable
{
  public volatile boolean a;
  private final Object b;
  
  private boolean a()
  {
    MediaDecoder localMediaDecoder = this.this$0;
    boolean bool;
    if ((MediaDecoder.h(localMediaDecoder)) && (MediaDecoder.f(this.this$0).d())) {
      bool = true;
    } else {
      bool = false;
    }
    MediaDecoder.b(localMediaDecoder, bool);
    return MediaDecoder.d(this.this$0).d();
  }
  
  private boolean b()
  {
    if (MediaDecoder.e(this.this$0)) {
      MediaDecoder.f(this.this$0).e();
    }
    boolean bool = MediaDecoder.d(this.this$0).e();
    SLog.a("Q.qqstory.mediadecoderMediaDecoder", "start finish : %s", Boolean.valueOf(bool));
    return bool;
  }
  
  private boolean c()
  {
    int i;
    if (MediaDecoder.d(this.this$0).h() / 1000L <= System.currentTimeMillis() - MediaDecoder.d(this.this$0).i())
    {
      MediaDecoder.d(this.this$0).g();
      MediaDecoder.b(this.this$0).a(MediaDecoder.d(this.this$0).h());
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (MediaDecoder.e(this.this$0))
    {
      j = i;
      if (MediaDecoder.f(this.this$0).h() <= MediaDecoder.d(this.this$0).h() - 500000L)
      {
        MediaDecoder.f(this.this$0).g();
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
    if (MediaDecoder.d(this.this$0).f())
    {
      if (MediaDecoder.i(this.this$0))
      {
        MediaDecoder.d(this.this$0).a(0L);
        if (MediaDecoder.e(this.this$0)) {
          MediaDecoder.f(this.this$0).a(0L);
        }
        MediaDecoder.b(this.this$0).d();
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void d()
  {
    SLog.b("Q.qqstory.mediadecoderMediaDecoder", "release");
    MediaDecoder.d(this.this$0).c();
    if (MediaDecoder.e(this.this$0)) {
      MediaDecoder.f(this.this$0).c();
    }
    if (MediaDecoder.j(this.this$0) != null) {
      MediaDecoder.j(this.this$0).interrupt();
    }
    MediaDecoder.a(this.this$0, null);
  }
  
  private void e()
  {
    SLog.b("Q.qqstory.mediadecoderMediaDecoder", "onPauseFinish");
    MediaDecoder.d(this.this$0).b();
    if (MediaDecoder.e(this.this$0)) {
      MediaDecoder.f(this.this$0).b();
    }
  }
  
  public void run()
  {
    try
    {
      VideoPerformanceMonitor.a(MediaDecoder.a(this.this$0).b, "[MediaDecoder] decode thread start run");
      MediaDecoder.a(this.this$0, false);
      if (!a())
      {
        MediaDecoder.b(this.this$0).a(1000, new Exception("init error"));
        MediaDecoder.a(this.this$0, false);
        if (MediaDecoder.d(this.this$0).f()) {
          MediaDecoder.b(this.this$0).b();
        } else {
          MediaDecoder.b(this.this$0).c();
        }
        d();
        return;
      }
      VideoPerformanceMonitor.a(MediaDecoder.a(this.this$0).b, "[MediaDecoder] init decoder finish");
      if (!b())
      {
        MediaDecoder.b(this.this$0).a(1001, new Exception("start error"));
        MediaDecoder.a(this.this$0, false);
        if (MediaDecoder.d(this.this$0).f()) {
          MediaDecoder.b(this.this$0).b();
        } else {
          MediaDecoder.b(this.this$0).c();
        }
        d();
        return;
      }
      VideoPerformanceMonitor.a(MediaDecoder.a(this.this$0).b, "[MediaDecoder] start decoder finish");
      MediaDecoder.a(this.this$0, true);
      MediaDecoder.b(this.this$0).a();
      for (;;)
      {
        if ((!Thread.interrupted()) && (!this.a))
        {
          if (MediaDecoder.c(this.this$0) >= 0L)
          {
            MediaDecoder.d(this.this$0).a(MediaDecoder.c(this.this$0) * 1000L);
            if (MediaDecoder.e(this.this$0)) {
              MediaDecoder.f(this.this$0).a(MediaDecoder.c(this.this$0) * 1000L);
            }
            MediaDecoder.a(this.this$0, -1L);
          }
          if (!c())
          {
            boolean bool = MediaDecoder.g(this.this$0);
            if (!bool) {
              continue;
            }
            try
            {
              synchronized (this.b)
              {
                MediaDecoder.a(this.this$0, false);
                if (!this.a) {
                  this.b.wait();
                }
                MediaDecoder.a(this.this$0, true);
                e();
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              SLog.b("Q.qqstory.mediadecoderMediaDecoder", "pause error ! %s", localInterruptedException);
              this.a = true;
            }
          }
        }
      }
      MediaDecoder.a(this.this$0, false);
      if (MediaDecoder.d(this.this$0).f()) {
        MediaDecoder.b(this.this$0).b();
      } else {
        MediaDecoder.b(this.this$0).c();
      }
      d();
      return;
    }
    finally
    {
      MediaDecoder.a(this.this$0, false);
      if (MediaDecoder.d(this.this$0).f()) {
        MediaDecoder.b(this.this$0).b();
      } else {
        MediaDecoder.b(this.this$0).c();
      }
      d();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */