package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

class HWVideoDecoder$DecodeRunnable
  implements Runnable
{
  final long a;
  ByteBuffer[] b;
  ByteBuffer[] c;
  MediaCodec.BufferInfo d;
  boolean e = false;
  long f = System.currentTimeMillis();
  private final HWDecodeListener g;
  private final AtomicLong h = new AtomicLong(-1L);
  private final DecodeConfig i;
  private final DecodeConfig j;
  private final String k;
  private MediaExtractor l;
  private MediaCodec m;
  private Surface n;
  private int o;
  private int p;
  private boolean q = false;
  private boolean r = false;
  private long s = 0L;
  private long t = 0L;
  
  HWVideoDecoder$DecodeRunnable(String paramString, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create DecodeRunnable filePath: ");
    localStringBuilder.append(paramString);
    TLog.a("HWVideoDecoder.DecodeRunnable", localStringBuilder.toString());
    this.n = paramSurface;
    if (paramHWDecodeListener == null) {
      paramHWDecodeListener = new EmptyHWDecodeListener();
    }
    this.g = paramHWDecodeListener;
    this.k = paramString;
    this.a = FileUtils.d(paramString);
    this.i = new DecodeConfig(paramString, 0, true, false, 0L, this.a);
    this.j = new DecodeConfig(paramString, 0, true, false, 0L, this.a);
  }
  
  private boolean a()
  {
    this.l = new MediaExtractor();
    try
    {
      this.l.setDataSource(this.k);
      int i1 = 0;
      while (i1 < this.l.getTrackCount()) {
        try
        {
          MediaFormat localMediaFormat = this.l.getTrackFormat(i1);
          localObject = localMediaFormat.getString("mime");
          if (((String)localObject).startsWith("video/"))
          {
            this.o = localMediaFormat.getInteger("width");
            this.p = localMediaFormat.getInteger("height");
            this.l.selectTrack(i1);
            try
            {
              this.m = MediaCodec.createDecoderByType((String)localObject);
              if (this.n.isValid())
              {
                this.m.configure(localMediaFormat, this.n, null, 0);
                return true;
              }
              throw new RuntimeException("surface is not valid.");
            }
            catch (Throwable localThrowable)
            {
              if (Thread.interrupted())
              {
                TLog.b("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localThrowable);
                return false;
              }
              localObject = new RuntimeException(localThrowable);
              if (!this.e) {
                this.g.a(1, (Throwable)localObject);
              }
              TLog.b("HWVideoDecoder.DecodeRunnable", "decode configure error", localThrowable);
              return false;
            }
          }
          i1 += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (Thread.interrupted())
          {
            TLog.b("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localIllegalArgumentException);
            return false;
          }
          Object localObject = new RuntimeException(localIllegalArgumentException);
          this.g.a(1, (Throwable)localObject);
          TLog.b("HWVideoDecoder.DecodeRunnable", "decode configure getTrackFormat error", localIllegalArgumentException);
          return false;
        }
      }
      return true;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  private long b(long paramLong1, long paramLong2)
  {
    return paramLong1 + paramLong2;
  }
  
  private void b(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      this.m.flush();
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("decoder flush error ");
      localStringBuilder2.append(localRuntimeException.toString());
      TLog.d("HWVideoDecoder.DecodeRunnable", localStringBuilder2.toString());
    }
    this.l.seekTo(paramLong, 0);
    long l2 = this.l.getSampleTime();
    this.g.b(l2 / 1000L);
    this.f = System.currentTimeMillis();
    this.q = false;
    this.r = false;
    if (l2 == -1L) {
      c();
    }
    this.s = l2;
    this.t = 0L;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("end seekTo timecost=");
    localStringBuilder1.append(System.currentTimeMillis() - l1);
    localStringBuilder1.append(" seekTargetTimeUs:");
    localStringBuilder1.append(paramLong);
    localStringBuilder1.append(" realStartTime:");
    localStringBuilder1.append(l2);
    TLog.b("HWVideoDecoder.DecodeRunnable", localStringBuilder1.toString());
  }
  
  private boolean b()
  {
    if (this.m == null)
    {
      TLog.d("HWVideoDecoder.DecodeRunnable", "Can't find video info!");
      return false;
    }
    this.g.a();
    try
    {
      this.m.start();
      try
      {
        this.b = this.m.getInputBuffers();
        this.c = this.m.getOutputBuffers();
        this.d = new MediaCodec.BufferInfo();
        this.f = System.currentTimeMillis();
        return true;
      }
      catch (Exception localException)
      {
        if (!this.e) {
          this.g.a(2, localException);
        }
        TLog.b("HWVideoDecoder.DecodeRunnable", "decode start error2", localException);
        return false;
      }
      RuntimeException localRuntimeException;
      return false;
    }
    catch (Throwable localThrowable)
    {
      if (Thread.interrupted())
      {
        TLog.b("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localThrowable);
        return false;
      }
      localRuntimeException = new RuntimeException(localThrowable);
      if (!this.e) {
        this.g.a(2, localRuntimeException);
      }
      TLog.b("HWVideoDecoder.DecodeRunnable", "decode start error", localThrowable);
    }
  }
  
  private void c()
  {
    this.s = 0L;
  }
  
  private void d()
  {
    if (!this.q) {
      e();
    }
    if (!this.r) {
      f();
    }
  }
  
  private void e()
  {
    int i1 = this.m.dequeueInputBuffer(10000L);
    if (i1 >= 0)
    {
      localObject = this.b[i1];
      int i2 = this.l.readSampleData((ByteBuffer)localObject, 0);
      long l1 = this.l.getSampleTime();
      long l2 = this.j.b;
      long l3 = this.j.c * 1000L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("intput sampleTime = ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" sampleSize = ");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" endTime = ");
      ((StringBuilder)localObject).append(l3);
      TLog.b("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
      if ((i2 >= 0) && ((l3 <= 0L) || (l1 <= l3)))
      {
        l2 = this.s;
        this.s = l1;
        this.t = b(this.t, l1 - l2);
        this.m.queueInputBuffer(i1, 0, i2, this.t, 0);
        this.l.advance();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" endTime=");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(" startTime=");
      ((StringBuilder)localObject).append(l2 * 1000L);
      ((StringBuilder)localObject).append(" sampleSize=");
      ((StringBuilder)localObject).append(i2);
      TLog.b("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
      this.m.queueInputBuffer(i1, 0, 0, 0L, 4);
      this.q = true;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("queueSampleToCodec inIndex = ");
    ((StringBuilder)localObject).append(i1);
    TLog.c("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
  }
  
  private void f()
  {
    int i1 = this.m.dequeueOutputBuffer(this.d, 10000L);
    if (i1 != -3)
    {
      if (i1 != -2)
      {
        if (i1 != -1)
        {
          if ((this.d.flags & 0x4) != 0)
          {
            TLog.b("HWVideoDecoder.DecodeRunnable", "output EOS");
            this.r = true;
          }
          if (!this.j.e) {
            while (this.d.presentationTimeUs / 1000L > System.currentTimeMillis() - this.f) {
              try
              {
                Thread.sleep(10L);
              }
              catch (InterruptedException localInterruptedException1)
              {
                localInterruptedException1.printStackTrace();
                this.e = true;
              }
            }
          }
          boolean bool;
          if (this.d.size != 0) {
            bool = true;
          } else {
            bool = false;
          }
          this.m.releaseOutputBuffer(i1, bool);
          if (!bool) {
            return;
          }
          try
          {
            this.g.a(this.d.presentationTimeUs * 1000L);
            return;
          }
          catch (InterruptedException localInterruptedException2)
          {
            localInterruptedException2.printStackTrace();
            this.e = true;
            return;
          }
        }
        TLog.b("HWVideoDecoder.DecodeRunnable", "dequeueOutputBuffer timed out!");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("New format ");
        localStringBuilder.append(this.m.getOutputFormat());
        TLog.b("HWVideoDecoder.DecodeRunnable", localStringBuilder.toString());
      }
    }
    else
    {
      TLog.b("HWVideoDecoder.DecodeRunnable", "INFO_OUTPUT_BUFFERS_CHANGED");
      this.c = this.m.getOutputBuffers();
    }
  }
  
  void a(int paramInt)
  {
    this.i.d = paramInt;
  }
  
  void a(long paramLong)
  {
    this.h.set(paramLong * 1000L);
  }
  
  void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L))
    {
      if (paramLong2 >= paramLong1)
      {
        long l2 = this.a;
        if (paramLong1 >= l2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setPlayRange ignore, startTimeMs=");
          ((StringBuilder)localObject).append(paramLong1);
          ((StringBuilder)localObject).append(", videoDuration=");
          ((StringBuilder)localObject).append(this.a);
          TLog.d("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
          return;
        }
        long l1 = paramLong2;
        if (paramLong2 > l2) {
          l1 = l2;
        }
        paramLong2 = l1;
        if (l1 == 0L) {
          paramLong2 = this.a;
        }
        if ((paramLong1 == this.i.b) && (paramLong2 == this.i.c))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("segment not changed, setPlayRange ignore, startTimeMs=");
          ((StringBuilder)localObject).append(paramLong1);
          ((StringBuilder)localObject).append(", endTimeMs=");
          ((StringBuilder)localObject).append(paramLong2);
          TLog.c("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
          return;
        }
        Object localObject = this.i;
        ((DecodeConfig)localObject).b = paramLong1;
        ((DecodeConfig)localObject).c = paramLong2;
        a(paramLong1);
        return;
      }
      throw new IllegalArgumentException("end time should not less than start time");
    }
    throw new IllegalArgumentException("both start time and end time should not less than 0");
  }
  
  void a(DecodeConfig paramDecodeConfig)
  {
    if (!TextUtils.equals(this.k, paramDecodeConfig.a)) {
      TLog.c("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
    }
    a(paramDecodeConfig.d);
    a(paramDecodeConfig.b, paramDecodeConfig.c);
    b(paramDecodeConfig.f);
    a(paramDecodeConfig.e);
  }
  
  void a(boolean paramBoolean)
  {
    this.i.e = paramBoolean;
  }
  
  void b(boolean paramBoolean)
  {
    this.i.f = paramBoolean;
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.j.a(this.i);
    if (!a()) {
      return;
    }
    if (!b()) {
      return;
    }
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("decode ready time cost=");
    localStringBuilder1.append(l2 - l1);
    TLog.b("HWVideoDecoder.DecodeRunnable", localStringBuilder1.toString());
    label302:
    Object localObject;
    while ((!Thread.interrupted()) && (!this.e))
    {
      this.j.a(this.i);
      l1 = this.j.b * 1000L;
      l2 = this.j.c;
      int i2 = 0;
      long l3 = this.h.get();
      int i1 = i2;
      if (l3 >= 0L)
      {
        i1 = i2;
        if (l3 >= l1)
        {
          i1 = i2;
          if (l3 <= l2 * 1000L)
          {
            b(l3);
            i1 = 1;
          }
        }
      }
      this.h.compareAndSet(l3, -1L);
      l2 = System.currentTimeMillis();
      try
      {
        d();
      }
      catch (Throwable localThrowable)
      {
        if (!Thread.interrupted()) {
          break label302;
        }
      }
      TLog.b("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localThrowable);
      l3 = System.currentTimeMillis();
      StringBuilder localStringBuilder2;
      if (i1 != 0)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("decode ready time cost=");
        localStringBuilder2.append(l3 - l2);
        TLog.b("HWVideoDecoder.DecodeRunnable", localStringBuilder2.toString());
      }
      if (this.r)
      {
        TLog.b("HWVideoDecoder.DecodeRunnable", "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
        if (this.j.f)
        {
          b(l1);
          this.g.d();
          continue;
          localObject = new RuntimeException(localStringBuilder2);
          if (!this.e) {
            this.g.a(3, (Throwable)localObject);
          }
          TLog.b("HWVideoDecoder.DecodeRunnable", "decode configure error", localStringBuilder2);
          return;
        }
      }
    }
    try
    {
      this.m.stop();
      this.m.release();
      this.l.release();
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decoder stop error ");
      ((StringBuilder)localObject).append(localException.toString());
      TLog.d("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
    }
    if (this.r)
    {
      this.g.b();
      return;
    }
    this.g.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.HWVideoDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */