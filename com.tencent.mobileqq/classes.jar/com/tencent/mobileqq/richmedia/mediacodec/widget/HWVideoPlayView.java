package com.tencent.mobileqq.richmedia.mediacodec.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.text.TextUtils;
import android.util.AttributeSet;
import axtq;
import axtu;
import axtx;
import axty;
import axwe;
import axwu;
import bnsf;
import bnsg;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import upd;
import wxe;

@TargetApi(11)
public class HWVideoPlayView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, axtx
{
  protected int a;
  public long a;
  protected SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new axwu(this);
  protected final axtq a;
  protected final axtu a;
  private axtx jdField_a_of_type_Axtx;
  protected axty a;
  protected AudioDecoder a;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  public boolean b;
  protected int c;
  public volatile boolean c;
  protected int d;
  protected int e;
  int f = 0;
  int g = 0;
  
  public HWVideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HWVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Axtu = new axtu();
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Axty = a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder = new AudioDecoder();
    this.jdField_a_of_type_Axtq = new axtq();
    a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Axtu.jdField_a_of_type_Int;
  }
  
  protected axty a()
  {
    return new HWVideoDecoder();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Axtu.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    setRenderer(this);
    setRenderMode(0);
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    QLog.e("HWVideoPlayView", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Axtx != null) {
      this.jdField_a_of_type_Axtx.a(paramLong);
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.jdField_a_of_type_Int, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_Axtu.jdField_a_of_type_JavaLangString)) {
      throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }
    this.jdField_a_of_type_Axty.a();
    this.jdField_a_of_type_Axty.a(this.jdField_a_of_type_Axtu, this.jdField_a_of_type_Int, this, this);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Axtq.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_Axtq);
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
    this.jdField_a_of_type_Axty.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.c();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "resumePlay");
    }
    this.jdField_a_of_type_Axty.c();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.d();
  }
  
  public void e()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Axtq.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_Axtq);
    }
  }
  
  public void f()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeStart");
    this.f = 0;
    if (this.jdField_a_of_type_Axtx != null) {
      this.jdField_a_of_type_Axtx.f();
    }
  }
  
  public void g()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeFinish");
    if (this.jdField_a_of_type_Axtx != null) {
      this.jdField_a_of_type_Axtx.g();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_Axty.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.b();
  }
  
  public void i()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeCancel");
    if (this.jdField_a_of_type_Axtx != null) {
      this.jdField_a_of_type_Axtx.i();
    }
  }
  
  public void j()
  {
    setPlayRange(0, 0);
  }
  
  public void k()
  {
    queueEvent(new HWVideoPlayView.2(this));
  }
  
  public void l()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeRepeat");
    this.f = 0;
    this.g = 0;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a();
    if (this.jdField_a_of_type_Axtx != null) {
      this.jdField_a_of_type_Axtx.l();
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "surfaceDestroyed");
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    h();
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    int i = this.g;
    this.g = (i + 1);
    wxe.a("HWVideoPlayView", "onDrawFrame index = %d", Integer.valueOf(i));
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        paramGL10 = new float[16];
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramGL10);
        a(paramGL10, GPUBaseFilter.caculateCenterCropMvpMatrix(this.d, this.e, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
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
    int i = this.f;
    this.f = (i + 1);
    wxe.a("HWVideoPlayView", "yarkey onFrameAvailable %d", Integer.valueOf(i));
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
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.onOutputSizeChanged(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceCreated");
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter = ((GPUOESBaseFilter)axwe.a(102));
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.init();
    this.jdField_a_of_type_Int = GlUtil.createTexture(36197);
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
  
  public void setDecodeListener(axtx paramaxtx)
  {
    this.jdField_a_of_type_Axtx = paramaxtx;
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Axtu.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Axtq.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Axtq.jdField_a_of_type_Azjw = AudioEncoder.a(paramString2, null, 0);
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, "setFilePath: videoFilePath = " + this.jdField_a_of_type_Axtu.jdField_a_of_type_JavaLangString + " ; audioFilePath = " + paramString2);
    }
    this.jdField_a_of_type_Long = upd.a(this.jdField_a_of_type_Axtu.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Axtq.c = this.jdField_a_of_type_Long;
    paramString2 = new bnsg();
    int i = bnsf.a(paramString1, paramString2);
    this.d = paramString2.a[0];
    this.e = paramString2.a[1];
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, "setFilePath: errcode = " + i + " ; videoWidth = " + this.d + " , videoHeight=" + this.e);
    }
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    this.jdField_a_of_type_Axtq.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramBoolean);
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Axtu.jdField_a_of_type_Long = paramInt1;
    this.jdField_a_of_type_Axtu.jdField_b_of_type_Long = paramInt2;
    this.jdField_a_of_type_Axty.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramInt1, paramInt2);
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.jdField_a_of_type_Axtu.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Axtq.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRotate(int paramInt)
  {
    this.jdField_a_of_type_Axtu.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Axtu.jdField_b_of_type_Int = paramInt;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.jdField_a_of_type_Axtu.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Axtq.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Axty.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramInt);
  }
  
  public void setVideoDecodeConfig(axtu paramaxtu)
  {
    this.jdField_a_of_type_Axtu.a(paramaxtu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView
 * JD-Core Version:    0.7.0.1
 */