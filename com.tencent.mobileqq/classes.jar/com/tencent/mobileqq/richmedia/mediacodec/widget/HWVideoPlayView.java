package com.tencent.mobileqq.richmedia.mediacodec.widget;

import ahau;
import ahav;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioDecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.IVideoDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(11)
public class HWVideoPlayView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, HWDecodeListener
{
  protected int a;
  public long a;
  protected SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new ahau(this);
  public final AudioDecoder.AudioDecodeConfig a;
  public AudioDecoder a;
  public final DecodeConfig a;
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener;
  public IVideoDecoder a;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public boolean b;
  public int c;
  public volatile boolean c;
  int d = 0;
  int e = 0;
  
  public HWVideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HWVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig = new DecodeConfig();
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder = a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder = new AudioDecoder();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig = new AudioDecoder.AudioDecodeConfig();
    a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int;
  }
  
  public IVideoDecoder a()
  {
    return new HWVideoDecoder();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    setRenderer(this);
    setRenderMode(0);
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    QLog.e("HWVideoPlayView", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    ShortVideoExceptionReporter.a(paramThrowable);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(paramLong);
    }
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(this.jdField_a_of_type_Int, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_JavaLangString)) {
      throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig, this.jdField_a_of_type_Int, this, this);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig);
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramLong);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "pausePlay");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.c();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "resumePlay");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.d();
  }
  
  public void e()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeStart");
    this.d = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.e();
    }
  }
  
  public void f()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.b();
  }
  
  public void h()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeFinish");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.h();
    }
  }
  
  public void i()
  {
    setPlayRange(0, 0);
  }
  
  public void j()
  {
    queueEvent(new ahav(this));
  }
  
  public void k()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeCancel");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.k();
    }
  }
  
  public void l()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeRepeat");
    this.d = 0;
    this.e = 0;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.l();
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "surfaceDestroyed");
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    g();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    int i = this.e;
    this.e = (i + 1);
    SLog.a("HWVideoPlayView", "onDrawFrame index = %d", Integer.valueOf(i));
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        paramGL10 = new float[16];
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramGL10);
        a(paramGL10, GPUBaseFilter.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      }
      return;
    }
    catch (Throwable paramGL10)
    {
      QLog.e("HWVideoPlayView", 2, "onDrawFrame error.", paramGL10);
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    int i = this.d;
    this.d = (i + 1);
    SLog.a("HWVideoPlayView", "yarkey onFrameAvailable %d", Integer.valueOf(i));
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    requestRender();
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onPause");
    }
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onResume");
    }
    this.jdField_a_of_type_Boolean = false;
    d();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceChanged : " + paramInt1 + ";" + paramInt2);
    }
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceCreated");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter = ((GPUOESBaseFilter)FilterFactory.a(102));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a();
    this.jdField_a_of_type_Int = GlUtil.a(36197);
    if (QLog.isColorLevel()) {
      QLog.d("DIDI", 1, "onSurfaceChanged mHaveDanceRankShowed=" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      b();
      if (this.jdField_a_of_type_Boolean) {
        c();
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void setDecodeListener(HWDecodeListener paramHWDecodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener = paramHWDecodeListener;
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData = AudioEncoder.a(paramString2, null, 0);
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, "setFilePath: videoFilePath = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_JavaLangString + " ; audioFilePath = " + paramString2);
    }
    this.jdField_a_of_type_Long = VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.c = this.jdField_a_of_type_Long;
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramBoolean);
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Long = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Long = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramInt1, paramInt2);
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRotate(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Int = paramInt;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramInt);
  }
  
  public void setVideoDecodeConfig(DecodeConfig paramDecodeConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.a(paramDecodeConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView
 * JD-Core Version:    0.7.0.1
 */