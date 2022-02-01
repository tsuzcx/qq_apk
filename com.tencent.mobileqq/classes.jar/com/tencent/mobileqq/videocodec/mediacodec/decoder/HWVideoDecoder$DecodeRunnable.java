package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.editor.composite.util.CompositeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

class HWVideoDecoder$DecodeRunnable
  implements Runnable
{
  ByteBuffer[] a;
  ByteBuffer[] b;
  MediaCodec.BufferInfo c;
  boolean d = false;
  long e = System.currentTimeMillis();
  public final long f;
  private String g = "HWVideoDecoder.DecodeRunnable";
  private MediaExtractor h;
  private MediaCodec i;
  private Surface j;
  private int k;
  private int l;
  @NonNull
  private final HWDecodeListener m;
  private boolean n = false;
  private boolean o = false;
  private long p = 0L;
  private long q = 0L;
  private final AtomicLong r = new AtomicLong(-1L);
  private final AtomicLong s = new AtomicLong(-1L);
  private boolean t = false;
  private final DecodeConfig u;
  private final DecodeConfig v;
  private volatile boolean w = false;
  private final Object x = new Object();
  private final String y;
  
  public HWVideoDecoder$DecodeRunnable(@NonNull String paramString, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HWVideoDecoder.DecodeRunnable.");
    localStringBuilder.append(hashCode());
    this.g = localStringBuilder.toString();
    SLog.b("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: %s", paramString);
    this.j = paramSurface;
    if (paramHWDecodeListener == null) {
      paramHWDecodeListener = new EmptyHWDecodeListener();
    }
    this.m = paramHWDecodeListener;
    this.y = paramString;
    this.f = CompositeUtil.a(paramString);
    this.u = new DecodeConfig(paramString, 0, true, false, 0L, this.f);
    this.v = new DecodeConfig(paramString, 0, true, false, 0L, this.f);
  }
  
  private long a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramLong1 + paramLong2;
        }
        return paramLong1 - paramLong2;
      }
      Long.signum(paramLong2);
    }
    for (paramLong2 *= 2L;; paramLong2 /= 2L) {
      return paramLong1 + paramLong2;
    }
  }
  
  private boolean a(boolean paramBoolean, long paramLong)
  {
    if (!this.t) {
      return paramBoolean;
    }
    if (!paramBoolean) {
      return paramBoolean;
    }
    if (this.o) {
      return false;
    }
    long l1 = this.s.get();
    if (l1 <= 0L) {
      return paramBoolean;
    }
    StringBuilder localStringBuilder;
    if ((l1 > this.v.e) && (l1 < this.v.f))
    {
      if (l1 > paramLong)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkToRender, do not render, renderpos:");
          localStringBuilder.append(l1);
          localStringBuilder.append(" sampletime:");
          localStringBuilder.append(paramLong);
          QLog.d("HWVideoDecoder.DecodeRunnable", 2, localStringBuilder.toString());
        }
        return false;
      }
      this.s.compareAndSet(l1, -1L);
      return paramBoolean;
    }
    this.s.compareAndSet(l1, -1L);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkToRender, not in playrange, pos:");
      localStringBuilder.append(l1);
      localStringBuilder.append(": [");
      localStringBuilder.append(this.v.e);
      localStringBuilder.append("-");
      localStringBuilder.append(this.v.f);
      localStringBuilder.append("]");
      QLog.d("HWVideoDecoder.DecodeRunnable", 2, localStringBuilder.toString());
    }
    return paramBoolean;
  }
  
  private long b(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    try
    {
      this.i.flush();
    }
    catch (RuntimeException localRuntimeException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decoder flush error ");
      localStringBuilder.append(localRuntimeException.toString());
      QLog.e("HWVideoDecoder.DecodeRunnable", 1, localStringBuilder.toString());
    }
    this.h.seekTo(paramLong, 0);
    long l2 = this.h.getSampleTime();
    this.m.b(l2 / 1000L);
    this.e = System.currentTimeMillis();
    this.n = false;
    this.o = false;
    if (l2 == -1L) {
      e();
    }
    this.p = l2;
    this.q = 0L;
    if (QLog.isColorLevel())
    {
      String str = this.g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("end seekTo seekTime=");
      localStringBuilder.append(0);
      localStringBuilder.append(" timecost=");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      localStringBuilder.append(" seekTargetTimeUs:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" realStartTime:");
      localStringBuilder.append(l2);
      QLog.d(str, 4, localStringBuilder.toString());
    }
    return l2;
  }
  
  private void c(boolean paramBoolean)
  {
    if (!this.n) {
      f();
    }
    if (!this.o) {
      d(paramBoolean);
    }
  }
  
  private boolean c()
  {
    this.h = new MediaExtractor();
    try
    {
      this.h.setDataSource(this.y);
      int i1 = 0;
      while (i1 < this.h.getTrackCount()) {
        try
        {
          MediaFormat localMediaFormat = this.h.getTrackFormat(i1);
          localObject = localMediaFormat.getString("mime");
          if (((String)localObject).startsWith("video/"))
          {
            this.k = localMediaFormat.getInteger("width");
            this.l = localMediaFormat.getInteger("height");
            this.h.selectTrack(i1);
            if (this.v.h) {
              i1 = this.v.g;
            } else {
              i1 = 0;
            }
            localMediaFormat.setInteger("rotation-degrees", i1);
            try
            {
              this.i = MediaCodec.createDecoderByType((String)localObject);
              if (this.j.isValid())
              {
                this.i.configure(localMediaFormat, this.j, null, 0);
                return true;
              }
              throw new RuntimeException("surface is not valid.");
            }
            catch (Throwable localThrowable)
            {
              if (Thread.interrupted())
              {
                QLog.e(this.g, 2, "Thread is interrupted.", localThrowable);
                return false;
              }
              localObject = new RuntimeException(localThrowable);
              if (!this.d) {
                this.m.a(1, (Throwable)localObject);
              }
              QLog.e(this.g, 2, "decode configure error", localThrowable);
              return false;
            }
          }
          i1 += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (Thread.interrupted())
          {
            QLog.e(this.g, 2, "Thread is interrupted.", localIllegalArgumentException);
            return false;
          }
          Object localObject = new RuntimeException(localIllegalArgumentException);
          this.m.a(1, (Throwable)localObject);
          QLog.e(this.g, 2, "decode configure getTrackFormat error", localIllegalArgumentException);
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
  
  private boolean d()
  {
    if (this.i == null)
    {
      QLog.e(this.g, 2, "Can't find video info!");
      return false;
    }
    this.m.a();
    try
    {
      this.i.start();
      try
      {
        this.a = this.i.getInputBuffers();
        this.b = this.i.getOutputBuffers();
        this.c = new MediaCodec.BufferInfo();
        this.e = System.currentTimeMillis();
        if (this.v.b == 3) {
          this.p = (this.v.f * 1000L);
        }
        return true;
      }
      catch (Exception localException)
      {
        if (!this.d) {
          this.m.a(2, localException);
        }
        QLog.e(this.g, 2, "decode start error2", localException);
        return false;
      }
      RuntimeException localRuntimeException;
      return false;
    }
    catch (Throwable localThrowable)
    {
      if (Thread.interrupted())
      {
        QLog.e(this.g, 2, "Thread is interrupted.", localThrowable);
        return false;
      }
      localRuntimeException = new RuntimeException(localThrowable);
      if (!this.d) {
        this.m.a(2, localRuntimeException);
      }
      QLog.e(this.g, 2, "decode start error", localThrowable);
    }
  }
  
  private boolean d(boolean paramBoolean)
  {
    int i1 = this.i.dequeueOutputBuffer(this.c, 10000L);
    if (i1 != -3)
    {
      StringBuilder localStringBuilder;
      if (i1 != -2)
      {
        if (i1 != -1)
        {
          if ((this.c.flags & 0x4) != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.g, 2, "output EOS");
            }
            this.o = true;
          }
          paramBoolean = a(paramBoolean, this.p / 1000L);
          if (QLog.isColorLevel())
          {
            String str1 = this.g;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkToRender, render :");
            localStringBuilder.append(paramBoolean);
            localStringBuilder.append(" info.presentationTimeUs:");
            localStringBuilder.append(this.c.presentationTimeUs / 1000L);
            localStringBuilder.append(" - ");
            localStringBuilder.append(System.currentTimeMillis() - this.e);
            QLog.d(str1, 2, localStringBuilder.toString());
          }
          if ((!this.v.c) && (paramBoolean)) {
            while (this.c.presentationTimeUs / 1000L > System.currentTimeMillis() - this.e) {
              try
              {
                Thread.sleep(10L);
              }
              catch (InterruptedException localInterruptedException1)
              {
                localInterruptedException1.printStackTrace();
                this.d = true;
              }
            }
          }
          if ((paramBoolean) && (this.c.size != 0)) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          this.i.releaseOutputBuffer(i1, paramBoolean);
          if (!paramBoolean) {
            break label403;
          }
          try
          {
            this.m.a(this.c.presentationTimeUs * 1000L);
            return true;
          }
          catch (InterruptedException localInterruptedException2)
          {
            localInterruptedException2.printStackTrace();
            this.d = true;
            return true;
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d(this.g, 2, "dequeueOutputBuffer timed out!");
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        String str2 = this.g;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("New format ");
        localStringBuilder.append(this.i.getOutputFormat());
        QLog.d(str2, 2, localStringBuilder.toString());
        return true;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.g, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
      }
      this.b = this.i.getOutputBuffers();
    }
    label403:
    return true;
  }
  
  private void e()
  {
    if (this.v.b == 3)
    {
      this.p = (this.v.f * 1000L);
      return;
    }
    this.p = 0L;
  }
  
  private boolean f()
  {
    int i1 = this.i.dequeueInputBuffer(10000L);
    Object localObject1;
    Object localObject2;
    if (i1 >= 0)
    {
      localObject1 = this.a[i1];
      long l1;
      if (this.v.b == 3)
      {
        l1 = this.p - 1000;
        if (("xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("MI 6".equalsIgnoreCase(Build.MODEL)))
        {
          localObject2 = this.h;
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          ((MediaExtractor)localObject2).seekTo(l2, 1);
        }
        else
        {
          localObject2 = this.h;
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          ((MediaExtractor)localObject2).seekTo(l2, 0);
        }
      }
      int i2 = this.h.readSampleData((ByteBuffer)localObject1, 0);
      long l3 = this.h.getSampleTime();
      long l2 = this.v.e * 1000L;
      long l4 = this.v.f * 1000L;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("intput sampleTime = ");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(" sampleSize = ");
        ((StringBuilder)localObject1).append(i2);
        ((StringBuilder)localObject1).append(" endTime = ");
        ((StringBuilder)localObject1).append(l4);
        QLog.d("HWVideoDecoder.DecodeRunnable", 2, ((StringBuilder)localObject1).toString());
      }
      if ((i2 >= 0) && ((l4 <= 0L) || (l3 <= l4))) {
        if (this.v.b == 3)
        {
          if (l2 > 0L) {
            l1 = l2;
          } else {
            l1 = 10000;
          }
          if (l3 < l1) {}
        }
        else
        {
          l1 = this.p;
          this.p = l3;
          this.q = a(this.v.b, this.q, l3 - l1);
          this.i.queueInputBuffer(i1, 0, i2, this.q, 0);
          this.h.advance();
          return true;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.g;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=");
        ((StringBuilder)localObject2).append(l3);
        ((StringBuilder)localObject2).append(" endTime=");
        ((StringBuilder)localObject2).append(l4);
        ((StringBuilder)localObject2).append(" startTime=");
        ((StringBuilder)localObject2).append(l2);
        ((StringBuilder)localObject2).append(" sampleSize=");
        ((StringBuilder)localObject2).append(i2);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      this.i.queueInputBuffer(i1, 0, 0, 0L, 4);
      this.n = true;
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.g;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("queueSampleToCodec inIndex = ");
      ((StringBuilder)localObject2).append(i1);
      QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return false;
  }
  
  public int a()
  {
    return this.k;
  }
  
  public void a(int paramInt)
  {
    this.u.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.r.set(paramLong * 1000L);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L))
    {
      if (paramLong2 >= paramLong1)
      {
        long l2 = this.f;
        if (paramLong1 >= l2)
        {
          SLog.e("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=%d, videoDuration=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.f) });
          return;
        }
        long l1 = paramLong2;
        if (paramLong2 > l2) {
          l1 = l2;
        }
        paramLong2 = l1;
        if (l1 == 0L) {
          paramLong2 = this.f;
        }
        if ((paramLong1 == this.u.e) && (paramLong2 == this.u.f))
        {
          SLog.d("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
          return;
        }
        DecodeConfig localDecodeConfig = this.u;
        localDecodeConfig.e = paramLong1;
        localDecodeConfig.f = paramLong2;
        if (localDecodeConfig.b == 3)
        {
          a(paramLong2);
          return;
        }
        a(paramLong1);
        return;
      }
      throw new IllegalArgumentException("end time should not less than start time");
    }
    throw new IllegalArgumentException("both start time and end time should not less than 0");
  }
  
  public void a(@NonNull DecodeConfig paramDecodeConfig)
  {
    if (!TextUtils.equals(this.y, paramDecodeConfig.a)) {
      SLog.d("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
    }
    a(paramDecodeConfig.b);
    a(paramDecodeConfig.e, paramDecodeConfig.f);
    b(paramDecodeConfig.d);
    a(paramDecodeConfig.c);
    this.u.g = paramDecodeConfig.g;
    this.u.h = paramDecodeConfig.h;
  }
  
  public void a(boolean paramBoolean)
  {
    this.u.c = paramBoolean;
  }
  
  public int b()
  {
    return this.l;
  }
  
  public void b(boolean paramBoolean)
  {
    this.u.d = paramBoolean;
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.v.a(this.u);
    if (!c()) {
      return;
    }
    if (!d()) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      String str = this.g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decode ready time cost=");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    for (;;)
    {
      if ((Thread.interrupted()) || (this.d)) {
        break label514;
      }
      if ((this.u.b != this.v.b) && (this.u.b == 3)) {
        this.p = (this.v.f * 1000L);
      }
      this.v.a(this.u);
      l1 = this.v.e * 1000L;
      long l2 = this.v.f * 1000L;
      int i2 = 0;
      long l3 = this.r.get();
      int i1 = i2;
      if (l3 >= 0L)
      {
        i1 = i2;
        if (l3 >= l1)
        {
          i1 = i2;
          if (l3 <= l2)
          {
            b(l3);
            i1 = 1;
          }
        }
      }
      this.r.compareAndSet(l3, -1L);
      l3 = System.currentTimeMillis();
      try
      {
        c(true);
      }
      catch (Throwable localThrowable)
      {
        if (!Thread.interrupted()) {
          break label470;
        }
      }
      QLog.e(this.g, 2, "Thread is interrupted.", localThrowable);
      if ((i1 != 0) && (QLog.isColorLevel()))
      {
        ??? = this.g;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode ready time cost=");
        localStringBuilder.append(System.currentTimeMillis() - l3);
        QLog.d((String)???, 2, localStringBuilder.toString());
      }
      if (this.o)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.g, 2, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
        }
        if (!this.v.d) {
          break label514;
        }
        if (this.v.b == 3) {
          l1 = l2;
        }
        b(l1);
        this.m.d();
      }
      if (this.w) {
        try
        {
          synchronized (this.x)
          {
            if (!this.d) {
              this.x.wait();
            }
            this.e = (System.currentTimeMillis() - this.c.presentationTimeUs / 1000L);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          this.d = true;
        }
      }
    }
    label470:
    Object localObject3 = new RuntimeException(localInterruptedException);
    if (!this.d) {
      this.m.a(3, (Throwable)localObject3);
    }
    QLog.e(this.g, 2, "decode configure error", localInterruptedException);
    return;
    try
    {
      label514:
      this.i.stop();
      this.i.release();
      this.h.release();
    }
    catch (Exception localException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("decoder stop error ");
      ((StringBuilder)localObject3).append(localException.toString());
      QLog.e("HWVideoDecoder.DecodeRunnable", 1, ((StringBuilder)localObject3).toString());
    }
    if (this.o)
    {
      this.m.b();
      return;
    }
    this.m.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.decoder.HWVideoDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */