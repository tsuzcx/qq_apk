package dov.com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeNextListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import java.util.List;

@TargetApi(11)
public class MultiMp4ReEncoder
  implements SurfaceTexture.OnFrameAvailableListener, HWEncodeListener, HWEncodeNextListener, HWDecodeListener
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private HWEncodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private volatile int d;
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.c();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.c();
  }
  
  public void a()
  {
    try
    {
      this.jdField_c_of_type_Int = GlUtil.a(36197);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, 33984);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter = ((GPUOESBaseFilter)FilterFactory.a(102));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = FilterFactory.a(101);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
      ((HWVideoDecoder)this.jdField_a_of_type_JavaUtilList.get(this.d)).a((DecodeConfig)this.jdField_b_of_type_JavaUtilList.get(this.d), this.jdField_c_of_type_Int, this, this);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.a();
      }
      return;
    }
    catch (Exception localException)
    {
      a_(4, localException);
      QLog.e("MultiMp4ReEncoder", 1, "onEncodeStart ex=" + localException);
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    a_(paramInt + 10000, paramThrowable);
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMp4ReEncoder", 2, "onDecodeFrame wait timestamp = " + paramLong1);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Long = paramLong1;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaLangObject.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("MultiMp4ReEncoder", 2, "onDecodeFrame start timestamp = " + paramLong1);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.a(paramString);
    }
    if (this.jdField_c_of_type_Int != -1)
    {
      GlUtil.a(this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Int = -1;
    }
    GlUtil.a(this.jdField_c_of_type_Int);
    h();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_b_of_type_Int = paramInt;
    ((HWVideoDecoder)this.jdField_a_of_type_JavaUtilList.get(this.d)).a();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.a_(paramInt, paramThrowable);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.b();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMp4ReEncoder", 2, "onEncodeNextStart " + this.d);
    }
    ((HWVideoDecoder)this.jdField_a_of_type_JavaUtilList.get(this.d)).a((DecodeConfig)this.jdField_b_of_type_JavaUtilList.get(this.d), this.jdField_c_of_type_Int, this, this);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMp4ReEncoder", 2, "onDecodeStart: " + this.d);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMp4ReEncoder", 2, "onDecodeFinish: " + this.d + " lastTs:" + this.jdField_b_of_type_Long);
    }
    if (this.d < this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      this.d += 1;
      this.jdField_c_of_type_Long += this.jdField_b_of_type_Long;
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMp4ReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
  }
  
  public void g() {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMp4ReEncoder", 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.jdField_b_of_type_Long + " , mLastDecodeTimestamp " + this.jdField_a_of_type_Long);
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("MultiMp4ReEncoder", 2, "onFrameAvailable wait");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Int != 0))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        QLog.w("MultiMp4ReEncoder", 2, "onFrameAvailable error=" + this.jdField_b_of_type_Int + " ; canceled=" + this.jdField_b_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMp4ReEncoder", 2, "onFrameAvailable start");
      }
      if (this.jdField_a_of_type_Boolean) {
        a_(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
      }
      paramSurfaceTexture.updateTexImage();
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMp4ReEncoder", 2, "onFrameAvailable timestap = " + this.jdField_b_of_type_Long);
      }
      float[] arrayOfFloat1 = new float[16];
      paramSurfaceTexture.getTransformMatrix(arrayOfFloat1);
      paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.h != 0)
      {
        float[] arrayOfFloat2 = new float[16];
        Matrix.setIdentityM(arrayOfFloat2, 0);
        Matrix.rotateM(arrayOfFloat2, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.h, 0.0F, 0.0F, 1.0F);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(this.jdField_c_of_type_Int, null, arrayOfFloat2);
        paramSurfaceTexture.c();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(paramSurfaceTexture.a(), arrayOfFloat1, null);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, paramSurfaceTexture.a(), arrayOfFloat1, null, this.jdField_b_of_type_Long + this.jdField_c_of_type_Long);
        int i = 1;
        while (i <= this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, paramSurfaceTexture.a(), arrayOfFloat1, null, this.jdField_b_of_type_Long + this.jdField_c_of_type_Long + i * 5 * 1000);
          i += 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(this.jdField_c_of_type_Int, null, null);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMp4ReEncoder", 2, "onFrameAvailable end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.MultiMp4ReEncoder
 * JD-Core Version:    0.7.0.1
 */