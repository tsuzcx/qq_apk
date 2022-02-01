package com.tencent.mobileqq.richmedia.mediacodec;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.mobileqq.videocodec.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.decoder.HWDecodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.decoder.HWVideoDecoder;
import com.tencent.ttpic.video.AEDecoder;

public class AEVDecoder
  implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener, AEDecoder
{
  private final int a = 1;
  private final int b = 2;
  private final int c = 3;
  private final int d = 4;
  private final int e = 5;
  private final int f = 6;
  private int g = 1;
  private HWVideoDecoder h = new HWVideoDecoder();
  private DecodeConfig i;
  private final Object j = new Object();
  private int k = -1;
  private int l = -1;
  private int m;
  private int n;
  private SurfaceTextureFilter o;
  private Frame p = new Frame();
  private float[] q = new float[16];
  
  public AEVDecoder(String paramString)
  {
    this.i = new DecodeConfig(paramString, 0, false, false);
  }
  
  private void e()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.n = arrayOfInt[0];
    this.o = new SurfaceTextureFilter();
    this.o.apply();
  }
  
  private void f()
  {
    GLES20.glDeleteTextures(1, new int[] { this.n }, 0);
    this.p.clear();
    this.o.clearGLSLSelf();
  }
  
  public void a() {}
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.g = 6;
    this.j.notifyAll();
  }
  
  public void a(long paramLong)
  {
    synchronized (this.j)
    {
      while (this.g != 2) {
        this.j.wait();
      }
      this.g = 3;
      this.j.notifyAll();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b()
  {
    this.g = 5;
    this.j.notifyAll();
  }
  
  public void b(long paramLong) {}
  
  public void c() {}
  
  public void d() {}
  
  public int getNextFrameTexture()
  {
    try
    {
      synchronized (this.j)
      {
        while ((this.g != 4) && (this.g != 5) && (this.g != 6)) {
          this.j.wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label52:
      break label52;
    }
    if (this.g == 4)
    {
      if ((this.k == -1) || (this.l == -1))
      {
        this.k = this.h.a();
        this.l = this.h.b();
      }
      this.o.updateMatrix(this.q);
      this.o.RenderProcess(this.n, this.k, this.l, this.m, 0.0D, this.p);
      this.g = 2;
      this.j.notifyAll();
      return 0;
    }
    return -1;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture.updateTexImage();
    paramSurfaceTexture.getTransformMatrix(this.q);
    this.g = 4;
    this.j.notifyAll();
  }
  
  public void release()
  {
    f();
    this.h.c();
  }
  
  public void setTexture(int paramInt)
  {
    e();
    this.m = paramInt;
    this.h.a(this.i, this.n, this, this);
    this.g = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.AEVDecoder
 * JD-Core Version:    0.7.0.1
 */