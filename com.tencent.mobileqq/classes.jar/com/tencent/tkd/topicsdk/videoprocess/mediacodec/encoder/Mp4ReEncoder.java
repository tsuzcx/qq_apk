package com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.DecodeConfig;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.HWDecodeListener;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.HWVideoDecoder;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow.GlUtil;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow.IMp4ReEncoder;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWEncodeListener;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWVideoRecorder;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer.FilterFactory;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUBaseFilter;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUOESBaseFilter;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.RenderBuffer;

@TargetApi(11)
public class Mp4ReEncoder
  implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener, IMp4ReEncoder, HWEncodeListener
{
  HWVideoRecorder a = new HWVideoRecorder();
  private final Object b = new Object();
  private final Object c = new Object();
  private HWVideoDecoder d = new HWVideoDecoder();
  private DecodeConfig e;
  private EncodeConfig f;
  private HWEncodeListener g;
  private Mp4ReEncoder.EncodeFilterRender h;
  private boolean i = false;
  private long j = -1L;
  private long k = -1L;
  private boolean l = false;
  private int m = 0;
  private int n;
  private GPUOESBaseFilter o;
  private GPUBaseFilter p;
  private RenderBuffer q;
  private boolean r;
  private boolean s;
  
  private void h()
  {
    this.o.f();
    this.p.f();
  }
  
  public void a()
  {
    TLog.b("Mp4ReEncoder", "onDecodeStart");
    this.s = false;
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    b(paramInt + 10000, paramThrowable);
  }
  
  public void a(long paramLong)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onDecodeFrame wait timestamp = ");
    ((StringBuilder)???).append(paramLong);
    TLog.b("Mp4ReEncoder", ((StringBuilder)???).toString());
    synchronized (this.b)
    {
      if (this.j >= paramLong)
      {
        this.l = true;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("mLastDecodeTimestamp >= timestampNanos; mLastDecodeTimestamp = ");
        ((StringBuilder)???).append(this.j);
        ((StringBuilder)???).append(" timestampNanos = ");
        ((StringBuilder)???).append(paramLong);
        TLog.d("Mp4ReEncoder", ((StringBuilder)???).toString());
        return;
      }
      this.l = false;
      this.j = paramLong;
      synchronized (this.c)
      {
        this.c.notifyAll();
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onDecodeFrame start timestamp = ");
        ((StringBuilder)???).append(paramLong);
        TLog.b("Mp4ReEncoder", ((StringBuilder)???).toString());
        try
        {
          this.b.wait(2000L);
          if ((!this.i) && (this.m == 0) && (!this.r)) {
            b(3, new RuntimeException("frame wait timed out"));
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onDecodeFrame end timestamp = ");
          ((StringBuilder)???).append(paramLong);
          TLog.b("Mp4ReEncoder", ((StringBuilder)???).toString());
          this.i = false;
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          TLog.b("Mp4ReEncoder", "onDecodeFrame InterruptedException");
          this.i = false;
          throw localInterruptedException;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    HWEncodeListener localHWEncodeListener = this.g;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.a(paramString);
    }
    int i1 = this.n;
    if (i1 != -1)
    {
      GlUtil.b(i1);
      this.n = -1;
    }
    GlUtil.b(this.n);
    h();
    this.q.d();
  }
  
  public void b()
  {
    TLog.b("Mp4ReEncoder", "onDecodeFinish");
    this.s = true;
    this.a.a();
  }
  
  public void b(int paramInt, Throwable paramThrowable)
  {
    this.m = paramInt;
    this.d.a();
    HWEncodeListener localHWEncodeListener = this.g;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.b(paramInt, paramThrowable);
    }
  }
  
  public void b(long paramLong) {}
  
  public void c()
  {
    TLog.b("Mp4ReEncoder", "onDecodeCancel");
    this.a.a();
  }
  
  public void d() {}
  
  public void e()
  {
    try
    {
      this.n = GlUtil.a(36197);
      this.q = new RenderBuffer(this.f.b, this.f.c, 33984);
      this.o = ((GPUOESBaseFilter)FilterFactory.a(102));
      this.o.a(this.f.b, this.f.c);
      this.o.d();
      this.p = FilterFactory.a(101);
      this.p.a(this.f.b, this.f.c);
      this.p.d();
      this.d.a(this.e, this.n, this, this);
      if (this.g != null)
      {
        this.g.e();
        return;
      }
    }
    catch (Exception localException)
    {
      b(4, localException);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEncodeStart ex=");
      localStringBuilder.append(localException);
      TLog.d("Mp4ReEncoder", localStringBuilder.toString());
    }
  }
  
  public void f()
  {
    HWEncodeListener localHWEncodeListener = this.g;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.f();
    }
  }
  
  public boolean g()
  {
    return this.a.b();
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    for (;;)
    {
      if ((this.k < this.j) || (this.l) || (this.s)) {
        break label113;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = ");
      ((StringBuilder)???).append(this.k);
      ((StringBuilder)???).append(" , mLastDecodeTimestamp ");
      ((StringBuilder)???).append(this.j);
      TLog.b("Mp4ReEncoder", ((StringBuilder)???).toString());
      try
      {
        synchronized (this.c)
        {
          this.c.wait(5L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    throw paramSurfaceTexture;
    label113:
    if (this.l)
    {
      TLog.d("Mp4ReEncoder", "onFrameAvailable skipDecode");
      return;
    }
    TLog.b("Mp4ReEncoder", "onFrameAvailable wait");
    synchronized (this.b)
    {
      if ((!this.r) && (this.m == 0) && (!this.s))
      {
        TLog.b("Mp4ReEncoder", "onFrameAvailable start");
        if (this.i) {
          b(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
        }
        try
        {
          paramSurfaceTexture.updateTexImage();
          this.k = this.j;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onFrameAvailable timestap = ");
          ((StringBuilder)localObject2).append(this.k);
          TLog.b("Mp4ReEncoder", ((StringBuilder)localObject2).toString());
          localObject2 = new float[16];
          paramSurfaceTexture.getTransformMatrix((float[])localObject2);
          this.q.b();
          this.o.a(this.n, null, null);
          if (this.h != null) {
            this.h.a();
          }
          paramSurfaceTexture = this.q;
          paramSurfaceTexture.c();
          this.p.a(paramSurfaceTexture.a(), (float[])localObject2, null);
          this.a.a(3553, paramSurfaceTexture.a(), (float[])localObject2, null, this.k);
          this.i = true;
          this.b.notifyAll();
          TLog.b("Mp4ReEncoder", "onFrameAvailable end");
          return;
        }
        catch (Exception paramSurfaceTexture)
        {
          this.i = true;
          this.b.notifyAll();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onFrameAvailable error=");
          ((StringBuilder)localObject2).append(this.m);
          ((StringBuilder)localObject2).append(" ; canceled=");
          ((StringBuilder)localObject2).append(this.r);
          TLog.a("Mp4ReEncoder", ((StringBuilder)localObject2).toString(), paramSurfaceTexture);
          return;
        }
      }
      this.i = true;
      this.b.notifyAll();
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append("onFrameAvailable error=");
      paramSurfaceTexture.append(this.m);
      paramSurfaceTexture.append(" ; canceled=");
      paramSurfaceTexture.append(this.r);
      paramSurfaceTexture.append("; stopped=");
      paramSurfaceTexture.append(this.s);
      TLog.c("Mp4ReEncoder", paramSurfaceTexture.toString());
      return;
    }
    for (;;)
    {
      throw paramSurfaceTexture;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.Mp4ReEncoder
 * JD-Core Version:    0.7.0.1
 */