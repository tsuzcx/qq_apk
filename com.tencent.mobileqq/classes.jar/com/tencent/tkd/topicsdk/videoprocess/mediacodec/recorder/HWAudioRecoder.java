package com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.nio.ByteBuffer;

@TargetApi(18)
public class HWAudioRecoder
{
  private final MediaMuxerWrapper b;
  private final MediaCodec.BufferInfo c;
  private MediaExtractor d;
  private HWAudioRecoder.TrackResult e;
  private boolean f;
  private int g;
  private ByteBuffer h;
  private volatile boolean i;
  private volatile boolean j;
  private long k;
  
  public boolean a()
  {
    if (!this.f) {
      return true;
    }
    if (this.e.b < 0) {
      return this.i;
    }
    return (this.i) && (this.j);
  }
  
  public boolean b()
  {
    if (this.f)
    {
      if (a()) {
        return false;
      }
      int n = this.d.getSampleTrackIndex();
      int m = 2;
      if (n < 0)
      {
        this.h.clear();
        this.c.set(0, 0, 0L, 4);
        this.b.a(1, this.h, this.c);
        this.b.a(2, this.h, this.c);
        this.i = true;
        this.j = true;
        return true;
      }
      if (n == this.e.a) {
        m = 1;
      } else {
        if (n != this.e.b) {
          break label325;
        }
      }
      this.h.clear();
      int i1 = this.d.readSampleData(this.h, 0);
      long l1 = this.d.getSampleTime();
      if ((!a) && (i1 > this.g)) {
        throw new AssertionError();
      }
      if (i1 >= 0)
      {
        long l2 = this.k;
        if ((l2 <= 0L) || (l1 <= l2))
        {
          if ((this.d.getSampleFlags() & 0x1) != 0) {
            n = 1;
          } else {
            n = 0;
          }
          this.c.set(0, i1, this.d.getSampleTime(), n);
          this.b.a(m, this.h, this.c);
          this.d.advance();
          return true;
        }
      }
      this.h.clear();
      this.c.set(0, 0, 0L, 4);
      this.b.a(m, this.h, this.c);
      if (n == this.e.a)
      {
        this.i = true;
        return true;
      }
      this.j = true;
      return true;
    }
    label325:
    return false;
  }
  
  public void c()
  {
    TLog.b("HWAudioRecoder", "stopRecording audio");
    while ((!a()) && (b())) {}
    TLog.b("HWAudioRecoder", "stopRecording audio, indeed");
    this.b.a();
    MediaExtractor localMediaExtractor = this.d;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWAudioRecoder
 * JD-Core Version:    0.7.0.1
 */