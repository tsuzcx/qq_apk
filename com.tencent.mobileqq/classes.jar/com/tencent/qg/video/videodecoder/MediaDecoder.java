package com.tencent.qg.video.videodecoder;

import com.tencent.biz.qqstory.support.logging.SLog;

public class MediaDecoder
{
  private Thread a;
  private MediaDecoder.DecodeRunnable b;
  private MediaCodecRender.MediaContext c;
  private MediaDecoder.DecodeListener d;
  private final MediaCodecVideoRender e;
  private final MediaCodecAudioRender f;
  private final boolean g;
  private boolean h;
  private volatile long i;
  private volatile boolean j;
  private volatile boolean k;
  private volatile boolean l;
  
  private boolean g()
  {
    return (this.g) && (this.h);
  }
  
  public void a(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean a()
  {
    return this.l;
  }
  
  public void b()
  {
    SLog.b("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.l = false;
    MediaDecoder.DecodeRunnable localDecodeRunnable = this.b;
    if (localDecodeRunnable != null)
    {
      localDecodeRunnable.a = true;
      this.b = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.a = paramBoolean;
  }
  
  public void c()
  {
    SLog.b("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.b != null)
    {
      this.k = true;
      return;
    }
    SLog.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public boolean d()
  {
    if (this.b != null) {
      return this.k;
    }
    return false;
  }
  
  public long e()
  {
    return this.e.h() / 1000L;
  }
  
  public boolean f()
  {
    return this.c.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */