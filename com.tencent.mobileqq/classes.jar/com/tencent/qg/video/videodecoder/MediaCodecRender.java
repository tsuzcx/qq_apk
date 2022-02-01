package com.tencent.qg.video.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qg.video.VideoPerformanceMonitor;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public abstract class MediaCodecRender
{
  protected MediaExtractor b;
  protected MediaCodec c;
  protected ByteBuffer[] d;
  protected ByteBuffer[] e;
  protected MediaCodec.BufferInfo f;
  protected boolean g;
  protected boolean h;
  protected long i;
  protected long j;
  protected long k;
  protected MediaCodecRender.MediaContext l;
  protected MediaCodecRender.MediaCodecInfo m;
  protected MediaFormat n;
  protected MediaDecoder.DecodeListener o;
  
  public long a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      this.c.flush();
    }
    catch (RuntimeException localRuntimeException)
    {
      SLog.c(a(), "decoder flush error %s", localRuntimeException);
    }
    this.b.seekTo(paramLong, 0);
    long l2 = this.b.getSampleTime();
    Object localObject = this.o;
    if (localObject != null) {
      ((MediaDecoder.DecodeListener)localObject).b(l2 / 1000L);
    }
    this.g = false;
    this.h = false;
    this.j = l2;
    this.k = l2;
    this.f = new MediaCodec.BufferInfo();
    this.f.presentationTimeUs = l2;
    this.i = (System.currentTimeMillis() - l2 / 1000L);
    localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("end seekTo timecost=");
    localStringBuilder.append(System.currentTimeMillis() - l1);
    localStringBuilder.append(" seekTargetTimeUs:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" realStartTime:");
    localStringBuilder.append(l2);
    SLog.b((String)localObject, localStringBuilder.toString());
    return l2;
  }
  
  protected abstract String a();
  
  protected abstract void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo);
  
  protected abstract void a(MediaCodecRender.MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat);
  
  public void b()
  {
    this.i = (System.currentTimeMillis() - this.f.presentationTimeUs / 1000L);
  }
  
  public void c()
  {
    try
    {
      if (this.c != null)
      {
        this.c.stop();
        this.c.release();
        this.c = null;
      }
      if (this.b != null)
      {
        this.b.release();
        this.b = null;
        return;
      }
    }
    catch (Exception localException)
    {
      SLog.c(a(), "onRelease error :%s ", localException);
    }
  }
  
  public boolean d()
  {
    long l1 = this.l.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] init now");
    VideoPerformanceMonitor.a(l1, ((StringBuilder)localObject).toString());
    this.c = null;
    this.b = new MediaExtractor();
    boolean bool2 = false;
    try
    {
      this.b.setDataSource(this.m.b);
      l1 = this.l.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] extractor setDataSource");
      VideoPerformanceMonitor.a(l1, ((StringBuilder)localObject).toString());
      int i1 = 0;
      boolean bool1;
      for (;;)
      {
        bool1 = bool2;
        if (i1 >= this.b.getTrackCount()) {
          break;
        }
        this.n = this.b.getTrackFormat(i1);
        localObject = this.n.getString("mime");
        if (((String)localObject).startsWith(this.m.a))
        {
          this.b.selectTrack(i1);
          l1 = this.l.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(a());
          localStringBuilder.append("] find and selectTrack");
          VideoPerformanceMonitor.a(l1, localStringBuilder.toString());
          try
          {
            this.c = MediaCodec.createDecoderByType((String)localObject);
            l1 = this.l.b;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[");
            ((StringBuilder)localObject).append(a());
            ((StringBuilder)localObject).append("] create codec");
            VideoPerformanceMonitor.a(l1, ((StringBuilder)localObject).toString());
            a(this.m, this.c, this.n);
            l1 = this.l.b;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[");
            ((StringBuilder)localObject).append(a());
            ((StringBuilder)localObject).append("] configureCodec");
            VideoPerformanceMonitor.a(l1, ((StringBuilder)localObject).toString());
            bool1 = true;
          }
          catch (Throwable localThrowable)
          {
            SLog.b(a(), "init createDecoderByType error :%s", localThrowable);
            bool1 = bool2;
          }
        }
        i1 += 1;
      }
      if (bool1)
      {
        SLog.b(a(), "create media decoder success!");
        return bool1;
      }
      SLog.d(a(), "create media decoder error!");
      return bool1;
    }
    catch (IOException localIOException)
    {
      SLog.b(a(), "init set data source error :%s", localIOException);
    }
    return false;
  }
  
  public boolean e()
  {
    SLog.a(a(), "start ! %s", this.m);
    try
    {
      this.c.start();
      try
      {
        this.d = this.c.getInputBuffers();
        this.e = this.c.getOutputBuffers();
        this.f = new MediaCodec.BufferInfo();
        this.i = System.currentTimeMillis();
        return true;
      }
      catch (Exception localException)
      {
        SLog.c(a(), "decode start error :%s", localException);
        return false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      SLog.c(a(), "decode start error", localThrowable);
    }
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public void g()
  {
    if (!this.g) {
      j();
    }
    if (!this.h) {
      a(this.c, this.f);
    }
    boolean bool = this.h;
  }
  
  public long h()
  {
    MediaCodec.BufferInfo localBufferInfo = this.f;
    if (localBufferInfo != null) {
      return localBufferInfo.presentationTimeUs;
    }
    return 0L;
  }
  
  public long i()
  {
    return this.i;
  }
  
  protected void j()
  {
    int i1 = this.c.dequeueInputBuffer(10000L);
    if (i1 >= 0)
    {
      ByteBuffer localByteBuffer = this.d[i1];
      int i2 = this.b.readSampleData(localByteBuffer, 0);
      long l1 = this.b.getSampleTime();
      if (i2 < 0)
      {
        this.c.queueInputBuffer(i1, 0, 0, 0L, 4);
        this.g = true;
        return;
      }
      long l2 = this.j;
      this.j = l1;
      this.k += l1 - l2;
      this.c.queueInputBuffer(i1, 0, i2, this.k, 0);
      this.b.advance();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaCodecRender
 * JD-Core Version:    0.7.0.1
 */