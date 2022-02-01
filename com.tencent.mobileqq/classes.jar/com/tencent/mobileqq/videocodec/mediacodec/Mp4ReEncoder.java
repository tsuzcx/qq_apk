package com.tencent.mobileqq.videocodec.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.filter.FilterFactory;
import com.tencent.mobileqq.filter.GPUImagePixelationFilter;
import com.tencent.mobileqq.filter.GpuImageFilterGroup;
import com.tencent.mobileqq.filter.QQVideoGaussianBlurFilter;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.shortvideo.filter.QQTransferFilter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class Mp4ReEncoder
  implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener, HWEncodeListener
{
  private boolean A;
  private boolean B;
  private QQFilterRenderManager C;
  private ArrayList<DynamicStickerData> D;
  private ArrayList<TrackerStickerParam> E = null;
  private TransferData F;
  private boolean G = false;
  protected HWVideoRecorder a = new HWVideoRecorder();
  protected HWVideoDecoder b = new HWVideoDecoder();
  protected DecodeConfig c;
  protected EncodeConfig d;
  public int e = 0;
  public int f = 0;
  private HWEncodeListener g;
  private Mp4ReEncoder.EncodeFilterRender h;
  private Object i = new Object();
  private Object j = new Object();
  private boolean k = false;
  private long l = -1L;
  private long m = -1L;
  private long n = -1L;
  private long o = -1L;
  private boolean p = false;
  private int q;
  private int r = -1;
  private int s;
  private int t;
  private GPUOESBaseFilter u;
  private QQVideoGaussianBlurFilter v;
  private GpuImageFilterGroup w;
  private GPUAlphaBlendFilter x;
  private RenderBuffer y;
  private RenderBuffer z;
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null)
    {
      QLog.e("Mp4ReEncoder", 1, "rotateBitmap, arg source is null");
      return null;
    }
    android.graphics.Matrix localMatrix = new android.graphics.Matrix();
    localMatrix.postRotate(paramFloat);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  private void c()
  {
    this.u.destroy();
    Object localObject = this.v;
    if (localObject != null) {
      ((QQVideoGaussianBlurFilter)localObject).a();
    }
    localObject = this.w;
    if (localObject != null) {
      ((GpuImageFilterGroup)localObject).destroy();
    }
    localObject = this.x;
    if (localObject != null) {
      ((GPUAlphaBlendFilter)localObject).destroy();
    }
  }
  
  public void a()
  {
    SLog.d("Richard", "cancelEncode");
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "cancelEncode");
    }
    this.A = true;
    this.e = 6;
    this.b.stopDecode();
  }
  
  public void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, Mp4ReEncoder.EncodeFilterRender paramEncodeFilterRender)
  {
    this.c = paramDecodeConfig;
    this.d = paramEncodeConfig;
    if ((paramDecodeConfig.speedType == 1) || (paramDecodeConfig.speedType == 3)) {
      this.G = true;
    }
    this.g = paramHWEncodeListener;
    this.h = paramEncodeFilterRender;
    this.a.a(paramEncodeConfig, this);
    this.A = false;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.F = new TransferData();
      this.F.fromJSONObject(paramString);
    }
  }
  
  public void a(ArrayList<DynamicStickerData> paramArrayList)
  {
    this.D = paramArrayList;
  }
  
  public boolean b()
  {
    return this.a.c();
  }
  
  public void onDecodeCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
    }
    this.a.b();
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    this.B = true;
    this.e = (paramInt + 10000);
    this.a.b();
    HWEncodeListener localHWEncodeListener = this.g;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.onEncodeError(this.e, paramThrowable);
    }
  }
  
  public void onDecodeFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.B = true;
    this.a.b();
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onDecodeFrame wait timestamp = ");
      ((StringBuilder)???).append(paramLong1);
      ((StringBuilder)???).append(" orgSampleTime: ");
      ((StringBuilder)???).append(paramLong2);
      QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.i)
    {
      this.l = paramLong1;
      this.m = paramLong2;
      synchronized (this.j)
      {
        this.j.notifyAll();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onDecodeFrame start timestamp = ");
          ((StringBuilder)???).append(paramLong1);
          QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
        }
        try
        {
          this.i.wait(2000L);
          if ((!this.k) && (this.e == 0) && (!this.A))
          {
            this.n = -1L;
            this.l = 0L;
            this.m = 0L;
            onEncodeError(3, new RuntimeException("frame wait timed out"));
          }
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onDecodeFrame end timestamp = ");
            ((StringBuilder)???).append(paramLong1);
            QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
          }
          this.k = false;
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onDecodeFrame InterruptedException");
          }
          this.k = false;
          throw localInterruptedException;
        }
      }
    }
  }
  
  public void onDecodeRepeat() {}
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    this.B = false;
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.e = paramInt;
    this.b.stopDecode();
    HWEncodeListener localHWEncodeListener = this.g;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.onEncodeError(paramInt, paramThrowable);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    HWEncodeListener localHWEncodeListener = this.g;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.onEncodeFinish(paramString);
    }
    int i1 = this.r;
    if (i1 != -1)
    {
      GlUtil.deleteTexture(i1);
      this.r = -1;
    }
    this.C.surfaceDestroyed();
    i1 = this.q;
    if (i1 != -1)
    {
      GlUtil.deleteTexture(i1);
      this.q = -1;
    }
    GlUtil.deleteTexture(this.q);
    c();
    this.y.destroy();
    this.z.destroy();
  }
  
  public void onEncodeFrame()
  {
    HWEncodeListener localHWEncodeListener = this.g;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.onEncodeFrame();
    }
  }
  
  public void onEncodeStart()
  {
    for (;;)
    {
      try
      {
        this.q = GlUtil.createTexture(36197);
        this.y = new RenderBuffer(this.d.c, this.d.d, 33984);
        this.z = new RenderBuffer(this.d.c, this.d.d, 33984);
        this.u = ((GPUOESBaseFilter)FilterFactory.a(102));
        this.u.onOutputSizeChanged(this.d.c, this.d.d);
        this.u.init();
        if ((this.c.isLocal) && (this.d.r))
        {
          if (!this.c.isLandscape) {
            break label975;
          }
          i1 = -90;
          this.v = new QQVideoGaussianBlurFilter(i1);
          this.v.a(this.c.width, this.c.height, this.d.c, this.d.d);
          this.v.a(this.d.c, this.d.d);
        }
        if ((FilterFactory.b(this.d.h)) || (this.d.k != null))
        {
          this.w = new GpuImageFilterGroup();
          if (FilterFactory.b(this.d.h)) {
            this.w.a(FilterFactory.a(this.d.h));
          }
          Object localObject1 = this.d.k;
          if (localObject1 != null) {
            try
            {
              localObject1 = FilterFactory.a(106);
              ((GPUImagePixelationFilter)localObject1).a(this.d.k);
              this.w.a((GPUBaseFilter)localObject1);
            }
            catch (Exception localException1)
            {
              QLog.e("Mp4ReEncoder", 1, "mosaic filter create error, ", localException1);
            }
          }
          this.w.onOutputSizeChanged(this.d.c, this.d.d);
          this.w.init();
        }
        Object localObject2 = this.d.j;
        if (localObject2 != null) {
          try
          {
            localObject3 = BitmapFactory.decodeFile(this.d.j);
            if (this.c.isLocal)
            {
              localObject2 = localObject3;
              if (this.d.u)
              {
                localObject2 = localObject3;
                if (((Bitmap)localObject3).getWidth() > ((Bitmap)localObject3).getHeight()) {
                  localObject2 = a((Bitmap)localObject3, 90.0F);
                }
              }
            }
            else
            {
              localObject2 = a((Bitmap)localObject3, 360 - this.c.adjustRotation);
            }
            this.r = GlUtil.createTexture(3553, (Bitmap)localObject2);
            this.s = ((Bitmap)localObject2).getWidth();
            this.t = ((Bitmap)localObject2).getHeight();
            ((Bitmap)localObject2).recycle();
            this.x = new GPUAlphaBlendFilter();
            this.x.onOutputSizeChanged(this.d.c, this.d.d);
            this.x.init();
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= ");
              ((StringBuilder)localObject3).append(this.d.j);
              QLog.e("Mp4ReEncoder", 2, ((StringBuilder)localObject3).toString(), localOutOfMemoryError);
            }
            onEncodeError(1, localOutOfMemoryError);
            return;
          }
        }
        this.C = new QQFilterRenderManager();
        localObject3 = this.C.getChainBuilder();
        ((QQFilterRenderManager.ChainBuilder)localObject3).setUseSort(true);
        Object localObject4 = this.D;
        QQTransferFilter localQQTransferFilter = null;
        if ((localObject4 != null) && (this.D.size() > 0)) {
          ((QQFilterRenderManager.ChainBuilder)localObject3).addFilter(120, null);
        }
        if (this.E != null) {
          ((QQFilterRenderManager.ChainBuilder)localObject3).addFilter(110, null);
        }
        ((QQFilterRenderManager.ChainBuilder)localObject3).commit();
        this.C.getBusinessOperation().setDynamicStickerParam(this.D);
        this.C.getBusinessOperation().setTrackerStickerParam(this.E);
        this.C.surfaceCreate(this.d.c, this.d.d, this.d.c, this.d.d);
        if (this.h != null) {
          this.h.a(this.d.c, this.d.d, this.d.c, this.d.d);
        }
        this.C.getBusinessOperation().setVideoStartTime(this.c.startTimeMillSecond);
        if (this.F != null)
        {
          if (!this.C.hasQQFilter(160))
          {
            this.C.pushChainBasedStackTopChain(160, null);
            localQQTransferFilter = (QQTransferFilter)this.C.getQQFilterByType(160);
          }
          localObject3 = localQQTransferFilter;
          if (localQQTransferFilter == null)
          {
            localObject4 = this.C.getQQFilters(160);
            localObject3 = localQQTransferFilter;
            if (localObject4 != null)
            {
              localObject3 = localQQTransferFilter;
              if (((List)localObject4).size() > 0)
              {
                localObject3 = localQQTransferFilter;
                if ((((List)localObject4).get(0) instanceof QQTransferFilter)) {
                  localObject3 = (QQTransferFilter)((List)localObject4).get(0);
                }
              }
            }
          }
          if (localObject3 != null)
          {
            ((QQTransferFilter)localObject3).setTransferData(this.F);
            ((QQTransferFilter)localObject3).setSpeedRate(HWVideoDecoder.getSpeedRate(this.c.speedType));
          }
        }
        this.b.startDecode(this.c, this.q, this, this);
        if (this.g != null)
        {
          this.g.onEncodeStart();
          return;
        }
      }
      catch (Exception localException2)
      {
        onEncodeError(4, localException2);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onEncodeStart ex=");
        ((StringBuilder)localObject3).append(localException2);
        QLog.e("Mp4ReEncoder", 1, ((StringBuilder)localObject3).toString());
      }
      return;
      label975:
      int i1 = 0;
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    for (;;)
    {
      if ((this.n < this.l) || (this.B)) {
        break label146;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = ");
        ((StringBuilder)???).append(this.n);
        ((StringBuilder)???).append(", mLastDecodeTimestamp ");
        ((StringBuilder)???).append(this.l);
        ((StringBuilder)???).append(", mLastDecodeSampleTimestamp :");
        ((StringBuilder)???).append(this.m);
        QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
      }
      try
      {
        synchronized (this.j)
        {
          this.j.wait(5L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    throw paramSurfaceTexture;
    label146:
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait");
    }
    synchronized (this.i)
    {
      if ((!this.A) && (this.e == 0) && (!this.B))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onFrameAvailable start");
        }
        if (this.k) {
          onEncodeError(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
        }
        try
        {
          paramSurfaceTexture.updateTexImage();
          this.n = this.l;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onFrameAvailable timestap = ");
            ((StringBuilder)???).append(this.n);
            QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
          }
          float[] arrayOfFloat = new float[16];
          paramSurfaceTexture.getTransformMatrix(arrayOfFloat);
          ??? = this.y;
          this.y.recoverInitialTexId();
          paramSurfaceTexture = new float[16];
          android.opengl.Matrix.setIdentityM(paramSurfaceTexture, 0);
          android.opengl.Matrix.rotateM(paramSurfaceTexture, 0, this.d.m, 0.0F, 0.0F, 1.0F);
          android.opengl.Matrix.scaleM(paramSurfaceTexture, 0, 1.0F, -1.0F, 1.0F);
          this.y.bind();
          this.u.drawTexture(this.q, arrayOfFloat, paramSurfaceTexture);
          this.y.unbind();
          int i1;
          if (this.v != null)
          {
            ((RenderBuffer)???).bind();
            i1 = this.v.a(((RenderBuffer)???).getTexId());
            if (i1 != -1) {
              ((RenderBuffer)???).setTexId(i1);
            }
            ((RenderBuffer)???).unbind();
          }
          if (this.h != null)
          {
            ((RenderBuffer)???).bind();
            i1 = this.h.a(((RenderBuffer)???).getTexId(), this.n);
            if (i1 != -1) {
              ((RenderBuffer)???).setTexId(i1);
            }
            ((RenderBuffer)???).unbind();
          }
          paramSurfaceTexture = (SurfaceTexture)???;
          if (this.w != null)
          {
            ((RenderBuffer)???).bind();
            this.w.drawTexture(((RenderBuffer)???).getTexId(), null, null);
            paramSurfaceTexture = this.w.a();
            paramSurfaceTexture.unbind();
          }
          paramSurfaceTexture.bind();
          if (this.x != null)
          {
            ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(this.d.c, this.d.d, this.s, this.t);
            this.x.drawTexture(this.r, null, (float[])???);
          }
          paramSurfaceTexture.unbind();
          long l2 = this.n;
          long l1 = l2;
          if (!this.p)
          {
            this.p = true;
            l1 = l2;
            if (this.n > 0L) {
              l1 = 0L;
            }
          }
          this.C.getBusinessOperation().SetTimeStamp(l1, this.m);
          paramSurfaceTexture.setTexId(this.C.drawFrame(paramSurfaceTexture.getTexId()));
          if ((!this.G) || (this.o == -1L) || (this.n - this.o >= 16666666L))
          {
            ??? = new float[16];
            android.opengl.Matrix.setIdentityM((float[])???, 0);
            android.opengl.Matrix.scaleM((float[])???, 0, 1.0F, -1.0F, 1.0F);
            this.o = this.n;
            this.a.a(3553, paramSurfaceTexture.getTexId(), null, (float[])???, this.n);
            i1 = 1;
            while (i1 <= this.f)
            {
              this.a.a(3553, paramSurfaceTexture.getTexId(), null, (float[])???, this.n + i1 * 5 * 1000);
              i1 += 1;
            }
          }
          paramSurfaceTexture.recoverInitialTexId();
          this.k = true;
          this.i.notifyAll();
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onFrameAvailable end");
          }
          return;
        }
        catch (Exception paramSurfaceTexture)
        {
          paramSurfaceTexture.printStackTrace();
          this.k = true;
          this.i.notifyAll();
          paramSurfaceTexture = new StringBuilder();
          paramSurfaceTexture.append("onFrameAvailable error=");
          paramSurfaceTexture.append(this.e);
          paramSurfaceTexture.append(" ; canceled=");
          paramSurfaceTexture.append(this.A);
          QLog.w("Mp4ReEncoder", 2, paramSurfaceTexture.toString());
          return;
        }
      }
      this.k = true;
      this.i.notifyAll();
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append("onFrameAvailable error=");
      paramSurfaceTexture.append(this.e);
      paramSurfaceTexture.append("; canceled=");
      paramSurfaceTexture.append(this.A);
      paramSurfaceTexture.append("; stopped=");
      paramSurfaceTexture.append(this.B);
      QLog.w("Mp4ReEncoder", 2, paramSurfaceTexture.toString());
      return;
    }
    for (;;)
    {
      throw paramSurfaceTexture;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder
 * JD-Core Version:    0.7.0.1
 */