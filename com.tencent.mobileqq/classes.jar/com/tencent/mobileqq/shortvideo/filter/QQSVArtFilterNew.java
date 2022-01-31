package com.tencent.mobileqq.shortvideo.filter;

import android.os.Build.VERSION;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.processor.ArtFilterProcessor;
import com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.sveffects.SLog;

public class QQSVArtFilterNew
  extends QQBaseFilter
{
  private BaseQmcfProcessor jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor = null;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private boolean jdField_a_of_type_Boolean = false;
  private RenderBuffer b;
  private RenderBuffer c;
  private int e;
  private int f;
  private int g = 480;
  private int h = 640;
  private int i = 0;
  
  public QQSVArtFilterNew(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    QmcfManager.a().b(0);
    this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor = new ArtFilterProcessor(this.g, this.h);
  }
  
  private void a()
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.c != null) {
      this.c.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor.a();
    int k = this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor.b();
    if (Build.VERSION.SDK_INT >= 21)
    {
      bool1 = true;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(j, k, 33984, bool1);
      j = this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor.a();
      k = this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor.b();
      if (Build.VERSION.SDK_INT < 21) {
        break label188;
      }
    }
    label188:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(j, k, 33984, bool1);
      this.c = new RenderBuffer(a().f(), a().g(), 33984);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
      return;
      bool1 = false;
      break;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (SLog.a()) {
      SLog.d("QQSVArtFilter", "onSurfaceChange");
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      paramInt1 = this.h * paramInt1 / paramInt2;
      paramInt1 -= paramInt1 % 4;
      if (paramInt1 != this.g)
      {
        this.g = paramInt1;
        this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor.a(this.g, this.h);
        if (SLog.a()) {
          SLog.d("QQSVArtFilter", String.format("onSurfaceChange resize input width[%d], height[%d]", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.h) }));
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor.a();
      }
    }
  }
  
  public void d()
  {
    if (SLog.a()) {
      SLog.d("QQSVArtFilter", "onSurfaceCreate");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor.a();
  }
  
  public void e()
  {
    QmcfManager.a().a();
    if (SLog.a()) {
      SLog.d("QQSVArtFilter", "onSurfaceDestroy");
    }
  }
  
  public boolean f_()
  {
    return QmcfManager.a().a() == 1;
  }
  
  public void h()
  {
    if (QmcfManager.a().a() != 1) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    }
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor.b();
        if (this.jdField_a_of_type_Boolean)
        {
          this.i = 0;
          a();
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          return;
        }
      }
      catch (Exception localException)
      {
        QmcfManager.a().a(false, false, 1);
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        SLog.a("QQSVArtFilter", "process excep!", localException);
        return;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, this.jdField_a_of_type_Int, null, null);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
        this.e = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
        this.f = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
        this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorBaseQmcfProcessor.b(this.e, this.f);
        this.c.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, this.f, null, null);
        this.c.c();
        this.jdField_b_of_type_Int = this.c.a();
        QQFilterLogManager.a("QQSVArtFilter", true);
        int j = this.i + 1;
        this.i = j;
        if (j < 3)
        {
          this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          return;
        }
      }
      catch (Error localError)
      {
        QmcfManager.a().a(false, false, 1);
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        SLog.a("QQSVArtFilter", "process excep!", localError);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQSVArtFilterNew
 * JD-Core Version:    0.7.0.1
 */