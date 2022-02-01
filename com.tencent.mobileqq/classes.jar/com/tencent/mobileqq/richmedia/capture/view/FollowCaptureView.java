package com.tencent.mobileqq.richmedia.capture.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import bapq;
import bapr;
import basr;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.io.IOException;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(17)
public class FollowCaptureView
  extends EffectsCameraCaptureView
  implements MediaPlayer.OnPreparedListener
{
  private static boolean l = true;
  private int A;
  private int B;
  private int C;
  private SurfaceTexture.OnFrameAvailableListener jdField_a_of_type_AndroidGraphicsSurfaceTexture$OnFrameAvailableListener = new bapq(this);
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private FollowCaptureParam jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener = new bapr(this);
  private HWVideoDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private SurfaceTexture jdField_b_of_type_AndroidGraphicsSurfaceTexture;
  private TextureRender jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private long d;
  private long e = -1L;
  private volatile boolean m;
  private boolean n;
  private int z = -1;
  
  public FollowCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FollowCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void F()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.videoPath))) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = new HWVideoDecoder();
      DecodeConfig localDecodeConfig = new DecodeConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.videoPath, 0, true, false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.startDecode(localDecodeConfig, this.z, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture$OnFrameAvailableListener, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.pauseDecode();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.videoPath);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      ThreadManagerV2.excute(new FollowCaptureView.3(this), 16, null, true);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.pauseDecode();
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureView", 2, "pausePlay : " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.getLastFrameSampleTimeMs());
      }
    }
  }
  
  private void H()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.m)) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureView", 2, "resumePlay before : " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.getLastFrameSampleTimeMs());
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.resumeDecode();
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureView", 2, "resumePlay after : " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.getLastFrameSampleTimeMs());
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.d <= this.e) && (b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("hwVideoFollowView", 2, "frameToMediaCodec null ");
      }
      return;
    }
    super.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, this.d);
    this.e = this.d;
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    super.a_(paramInt, paramThrowable);
    G();
  }
  
  protected int b()
  {
    return this.jdField_b_of_type_Int / 2;
  }
  
  protected int b(int paramInt)
  {
    paramInt = super.b(paramInt);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_n_of_type_Int, this.o, this.jdField_b_of_type_Int / 2, this.c);
    Matrix.scaleM((float[])???, 0, 0.5F, 1.0F, 1.0F);
    Matrix.translateM((float[])???, 0, -1.0F, 0.0F, 0.0F);
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, (float[])???);
    if ((this.jdField_n_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsSurfaceTexture != null)) {}
    for (;;)
    {
      synchronized (this.jdField_b_of_type_AndroidGraphicsSurfaceTexture)
      {
        float[] arrayOfFloat1 = new float[16];
        this.jdField_b_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(arrayOfFloat1);
        float[] arrayOfFloat2 = GPUBaseFilter.caculateCenterCropMvpMatrix(this.B, this.C, this.jdField_b_of_type_Int / 2, this.c);
        Matrix.scaleM(arrayOfFloat2, 0, 0.5F, 1.0F, 1.0F);
        Matrix.translateM(arrayOfFloat2, 0, 1.0F, 0.0F, 0.0F);
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.z, arrayOfFloat1, arrayOfFloat2);
        if ((QLog.isColorLevel()) && (l)) {
          QLog.d("FollowCaptureView", 2, "video texture time : " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.getLastFrameSampleTimeMs());
        }
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        return this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
      }
      ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(this.B, this.C, this.jdField_b_of_type_Int / 2, this.c);
      Matrix.scaleM((float[])???, 0, 1.0F, -1.0F, 1.0F);
      Matrix.scaleM((float[])???, 0, 0.5F, 1.0F, 1.0F);
      Matrix.translateM((float[])???, 0, 1.0F, 0.0F, 0.0F);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.A, null, (float[])???);
    }
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hwVideoFollowView", 2, new Object[] { "seekTo : ", Integer.valueOf(paramInt) });
    }
    this.e = (paramInt - 1);
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.m)) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.seekTo(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.decodeFrame();
    }
  }
  
  public int f()
  {
    return (int)(this.d / 1000000L);
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.m = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = null;
    }
  }
  
  public void i()
  {
    super.i();
    H();
  }
  
  public void j()
  {
    super.j();
    G();
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.m = true;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth() != paramInt1) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight() != paramInt2))) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.z = basr.a(36197);
    this.A = basr.a(3553);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null) {
      F();
    }
  }
  
  public void setData(FollowCaptureParam paramFollowCaptureParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = paramFollowCaptureParam;
    if (this.z != -1) {
      F();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView
 * JD-Core Version:    0.7.0.1
 */