package com.tencent.mobileqq.shortvideo.filter;

import ahnh;
import ahni;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;

@TargetApi(11)
public class QQMovieFilter
  extends QQBaseFilter
{
  private float jdField_a_of_type_Float = 0.0F;
  private ahni jdField_a_of_type_Ahni;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private GPUOESMovieFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private DecodePlayer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private boolean jdField_b_of_type_Boolean = false;
  protected int e = -1;
  protected int f = -1;
  private int g = -1;
  private int h = 1;
  
  public QQMovieFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(100, paramQQFilterRenderManager);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer.a();
    }
  }
  
  public void a()
  {
    if (SdkContext.a().a().a()) {
      SdkContext.a().a().d("QQMovieFilter", "onSurfaceCreated");
    }
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        int i = GLES20.glGetError();
        if ((i != 0) && (SdkContext.a().a().a()))
        {
          String str = "previousUnknownError: glError 0x" + Integer.toHexString(i);
          SdkContext.a().a().a("QQMovieFilter", str);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter = new GPUOESMovieFilter();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter.a();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter.a(a().f(), a().g());
          if (this.jdField_a_of_type_JavaLangString != null) {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter.a(VideoUtil.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = new GPUBaseFilter();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
        }
        GPUBaseFilter.a("filter init");
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
      this.g = -1;
      SdkContext.a().a().a("QQMovieFilter", "onSurfaceCreate error.", localThrowable);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (SdkContext.a().a().a()) {
      SdkContext.a().a().d("QQMovieFilter", "onSurfaceChanged : " + paramInt1 + ";" + paramInt2);
    }
    this.e = paramInt1;
    this.f = paramInt2;
    try
    {
      int i = GLES20.glGetError();
      if ((i != 0) && (SdkContext.a().a().a()))
      {
        String str = "previousUnknownError: glError 0x" + Integer.toHexString(i);
        SdkContext.a().a().a("QQMovieFilter", str);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter.a(paramInt1, paramInt2);
        if (this.jdField_a_of_type_JavaLangString != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter.a(VideoUtil.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(paramInt1, paramInt2);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
      this.g = -1;
      SdkContext.a().a().a("QQMovieFilter", "onSurfaceChange error.", localThrowable);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer.a() == 3) {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, float paramFloat1, float paramFloat2, HWDecodeListener paramHWDecodeListener)
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive()))
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("movieTouchThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new ahnh(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
    if (this.jdField_a_of_type_Ahni != null) {
      this.jdField_a_of_type_Ahni.a();
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    if (FileUtil.b(paramString1)) {}
    for (paramString1 = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramHWDecodeListener });; paramString1 = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      this.h = paramString1.what;
      SLog.c("QQMovieFilter", "send movie filter msg, what = " + this.h);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((i_()) && (this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (int i = 3;; i = 4)
    {
      Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, i);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      SLog.c("QQMovieFilter", "send movie filter msg, what = " + localMessage.what);
      return;
    }
  }
  
  public void d()
  {
    super.d();
    this.g = GlUtil.a(36197);
  }
  
  public void e()
  {
    if (SdkContext.a().a().a()) {
      SdkContext.a().a().d("QQMovieFilter", "surfaceDestroyed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.c();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive()) {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      }
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    b();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer.a() == 3) && (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null))
    {
      if (!this.jdField_a_of_type_Boolean) {
        a();
      }
      if ((this.e == a().f()) || (this.f == a().g())) {
        break label288;
      }
      a(a().f(), a().g());
      this.jdField_b_of_type_Boolean = true;
    }
    while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer.a() == 3) && (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b() <= 0) || (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(true, a().f(), a().g(), 33984);
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
        GPUBaseFilter localGPUBaseFilter = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
        GPUBaseFilter.a("fbo bind");
        i = GLES20.glCheckFramebufferStatus(36160);
        if (i == 36053) {
          break label296;
        }
        SLog.a("QQMovieFilter", "fbo status incomplete, status: " + i);
        throw new RuntimeException("fbo status incomplete");
      }
      catch (Throwable localThrowable)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        SdkContext.a().a().a("QQMovieFilter", "onDrawFrame error.", localThrowable);
        return;
      }
      label288:
      this.jdField_b_of_type_Boolean = false;
      continue;
      label296:
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
      Object localObject = new float[16];
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix((float[])localObject);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESMovieFilter.a(this.g, (float[])localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
      GPUBaseFilter.a("oes draw");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      int i = GLES20.glCheckFramebufferStatus(36160);
      if (i != 36053)
      {
        SLog.a("QQMovieFilter", "fbo status2 incomplete, status: " + i);
        throw new RuntimeException("fbo status incomplete");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
      GPUBaseFilter.a("pre clear");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_a_of_type_Int, null, null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public boolean i_()
  {
    return (this.h == 2) && (this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQMovieFilter
 * JD-Core Version:    0.7.0.1
 */