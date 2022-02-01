package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@TargetApi(18)
public class HWAudioRecoder
{
  private final MediaMuxerWrapper b;
  private final DecodeConfig c;
  private MediaExtractor d;
  private HWAudioRecoder.TrackResult e;
  private boolean f;
  private final MediaCodec.BufferInfo g = new MediaCodec.BufferInfo();
  private int h = 1024;
  private ByteBuffer i;
  private volatile boolean j;
  private volatile boolean k;
  private long l;
  
  public HWAudioRecoder(DecodeConfig paramDecodeConfig, MediaMuxerWrapper paramMediaMuxerWrapper)
  {
    this.b = paramMediaMuxerWrapper;
    this.c = paramDecodeConfig;
    this.l = (paramDecodeConfig.endTimeMillSecond * 1000L);
    try
    {
      this.d = new MediaExtractor();
      this.d.setDataSource(paramDecodeConfig.inputFilePath);
      this.e = a(this.d);
      if (this.e.a >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioRecoder", 1, "audio track normal");
        }
        this.b.a(1, this.e.c);
        this.d.selectTrack(this.e.a);
        if (this.e.c.containsKey("max-input-size")) {
          this.h = this.e.c.getInteger("max-input-size");
        }
        if (this.e.d >= 0)
        {
          this.b.a(2);
          this.b.a(2, this.e.f);
          this.d.selectTrack(this.e.d);
          if (this.e.f.containsKey("max-input-size"))
          {
            int m = this.e.f.getInteger("max-input-size");
            if (m > this.h) {
              this.h = m;
            }
          }
        }
      }
      else
      {
        this.b.a(0);
        this.b.a(1, null);
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioRecoder", 1, "no audio track");
        }
      }
      this.i = ByteBuffer.allocateDirect(this.h).order(ByteOrder.nativeOrder());
      this.d.seekTo(this.c.startTimeMillSecond * 1000L, 0);
      return;
    }
    catch (Exception paramDecodeConfig)
    {
      QLog.e("HWAudioRecoder", 1, "getAudioTrack,", paramDecodeConfig);
    }
  }
  
  public HWAudioRecoder.TrackResult a(MediaExtractor paramMediaExtractor)
  {
    HWAudioRecoder.TrackResult localTrackResult = new HWAudioRecoder.TrackResult();
    int n = paramMediaExtractor.getTrackCount();
    long l2 = 0L;
    int m = 0;
    while (m < n)
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(m);
      String str = localMediaFormat.getString("mime");
      long l1 = l2;
      if (localTrackResult.a < 0)
      {
        l1 = l2;
        if (str.startsWith("audio/"))
        {
          l2 += 1L;
          if (l2 == 1L)
          {
            localTrackResult.a = m;
            localTrackResult.b = str;
            localTrackResult.c = localMediaFormat;
          }
          else if (l2 == 2L)
          {
            localTrackResult.d = m;
            localTrackResult.e = str;
            localTrackResult.f = localMediaFormat;
          }
          l1 = l2;
          if (l2 >= 2L) {
            break;
          }
        }
      }
      m += 1;
      l2 = l1;
    }
    boolean bool;
    if (localTrackResult.a >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    QLog.d("HWAudioRecoder", 1, new Object[] { "getAudioTrack, ", Integer.valueOf(localTrackResult.a), " ", Integer.valueOf(localTrackResult.d) });
    return localTrackResult;
  }
  
  public boolean a()
  {
    if (!this.f) {
      return true;
    }
    if (this.e.d < 0) {
      return this.j;
    }
    return (this.j) && (this.k);
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
        this.i.clear();
        this.g.set(0, 0, 0L, 4);
        this.b.a(1, this.i, this.g);
        this.b.a(2, this.i, this.g);
        this.j = true;
        this.k = true;
        return true;
      }
      if (n == this.e.a) {
        m = 1;
      } else {
        if (n != this.e.d) {
          break label325;
        }
      }
      this.i.clear();
      int i1 = this.d.readSampleData(this.i, 0);
      long l1 = this.d.getSampleTime();
      if ((!a) && (i1 > this.h)) {
        throw new AssertionError();
      }
      if (i1 >= 0)
      {
        long l2 = this.l;
        if ((l2 <= 0L) || (l1 <= l2))
        {
          if ((this.d.getSampleFlags() & 0x1) != 0) {
            n = 1;
          } else {
            n = 0;
          }
          this.g.set(0, i1, this.d.getSampleTime(), n);
          this.b.a(m, this.i, this.g);
          this.d.advance();
          return true;
        }
      }
      this.i.clear();
      this.g.set(0, 0, 0L, 4);
      this.b.a(m, this.i, this.g);
      if (n == this.e.a)
      {
        this.j = true;
        return true;
      }
      this.k = true;
      return true;
    }
    label325:
    return false;
  }
  
  public void c()
  {
    QLog.d("HWAudioRecoder", 1, "stopRecording audio");
    while ((!a()) && (b())) {}
    QLog.d("HWAudioRecoder", 1, "stopRecording audio, indeed");
    this.b.a();
    MediaExtractor localMediaExtractor = this.d;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioRecoder
 * JD-Core Version:    0.7.0.1
 */