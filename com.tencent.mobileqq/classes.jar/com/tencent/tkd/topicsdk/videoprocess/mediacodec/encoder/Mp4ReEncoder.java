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
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private DecodeConfig jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig;
  private HWVideoDecoder jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWVideoDecoder = new HWVideoDecoder();
  private EncodeConfig jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig;
  private Mp4ReEncoder.EncodeFilterRender jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMp4ReEncoder$EncodeFilterRender;
  private HWEncodeListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener;
  HWVideoRecorder jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
  private GPUBaseFilter jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicRenderBuffer;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d;
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter.e();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter.e();
  }
  
  public void a()
  {
    TLog.b("Mp4ReEncoder", "onDecodeStart");
    this.d = false;
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    b(paramInt + 10000, paramThrowable);
  }
  
  public void a(long paramLong)
  {
    TLog.b("Mp4ReEncoder", "onDecodeFrame wait timestamp = " + paramLong);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Long >= paramLong)
      {
        this.jdField_b_of_type_Boolean = true;
        TLog.d("Mp4ReEncoder", "mLastDecodeTimestamp >= timestampNanos; mLastDecodeTimestamp = " + this.jdField_a_of_type_Long + " timestampNanos = " + paramLong);
        return;
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = paramLong;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaLangObject.notifyAll();
      TLog.b("Mp4ReEncoder", "onDecodeFrame start timestamp = " + paramLong);
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(2000L);
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (!this.c)) {
          b(3, new RuntimeException("frame wait timed out"));
        }
        TLog.b("Mp4ReEncoder", "onDecodeFrame end timestamp = " + paramLong);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        TLog.b("Mp4ReEncoder", "onDecodeFrame InterruptedException");
        this.jdField_a_of_type_Boolean = false;
        throw localInterruptedException;
      }
      localObject3 = finally;
      throw localObject3;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.a(paramString);
    }
    if (this.jdField_b_of_type_Int != -1)
    {
      GlUtil.a(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_Int = -1;
    }
    GlUtil.a(this.jdField_b_of_type_Int);
    g();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicRenderBuffer.c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder.a();
  }
  
  public void b()
  {
    TLog.b("Mp4ReEncoder", "onDecodeFinish");
    this.d = true;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder.a();
  }
  
  public void b(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWVideoDecoder.a();
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.b(paramInt, paramThrowable);
    }
  }
  
  public void b(long paramLong) {}
  
  public void c()
  {
    TLog.b("Mp4ReEncoder", "onDecodeCancel");
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder.a();
  }
  
  public void d() {}
  
  public void e()
  {
    try
    {
      this.jdField_b_of_type_Int = GlUtil.a(36197);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, 33984);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter = ((GPUOESBaseFilter)FilterFactory.a(102));
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter.d();
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter = FilterFactory.a(101);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter.d();
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWVideoDecoder.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig, this.jdField_b_of_type_Int, this, this);
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.e();
      }
      return;
    }
    catch (Exception localException)
    {
      b(4, localException);
      TLog.d("Mp4ReEncoder", "onEncodeStart ex=" + localException);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.f();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long) && (!this.jdField_b_of_type_Boolean) && (!this.d))
    {
      TLog.b("Mp4ReEncoder", "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.jdField_b_of_type_Long + " , mLastDecodeTimestamp " + this.jdField_a_of_type_Long);
      try
      {
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          this.jdField_b_of_type_JavaLangObject.wait(5L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      TLog.d("Mp4ReEncoder", "onFrameAvailable skipDecode");
      return;
    }
    TLog.b("Mp4ReEncoder", "onFrameAvailable wait");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.c) || (this.jdField_a_of_type_Int != 0) || (this.d))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        TLog.c("Mp4ReEncoder", "onFrameAvailable error=" + this.jdField_a_of_type_Int + " ; canceled=" + this.c + "; stopped=" + this.d);
        return;
      }
    }
    TLog.b("Mp4ReEncoder", "onFrameAvailable start");
    if (this.jdField_a_of_type_Boolean) {
      b(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
    }
    try
    {
      paramSurfaceTexture.updateTexImage();
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      TLog.b("Mp4ReEncoder", "onFrameAvailable timestap = " + this.jdField_b_of_type_Long);
      float[] arrayOfFloat = new float[16];
      paramSurfaceTexture.getTransformMatrix(arrayOfFloat);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicRenderBuffer.a();
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter.a(this.jdField_b_of_type_Int, null, null);
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMp4ReEncoder$EncodeFilterRender != null) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMp4ReEncoder$EncodeFilterRender.a();
      }
      paramSurfaceTexture = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicRenderBuffer;
      paramSurfaceTexture.b();
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter.a(paramSurfaceTexture.a(), arrayOfFloat, null);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder.a(3553, paramSurfaceTexture.a(), arrayOfFloat, null, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      TLog.b("Mp4ReEncoder", "onFrameAvailable end");
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      TLog.b("Mp4ReEncoder", "onFrameAvailable error=" + this.jdField_a_of_type_Int + " ; canceled=" + this.c, paramSurfaceTexture);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.Mp4ReEncoder
 * JD-Core Version:    0.7.0.1
 */