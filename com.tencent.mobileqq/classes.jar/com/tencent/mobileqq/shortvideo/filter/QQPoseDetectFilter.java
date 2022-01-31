package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.processor.PoseDetectProcessor;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.shortvideo.dancemachine.tempDir.HumanPoseFilter;
import com.tencent.sveffects.SLog;

public class QQPoseDetectFilter
  extends QQBaseFilter
{
  private PoseDetectProcessor jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor = null;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private HumanPoseFilter jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirHumanPoseFilter = new HumanPoseFilter(this.h, this.i);
  private boolean jdField_a_of_type_Boolean = false;
  float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private RenderBuffer b;
  private RenderBuffer c;
  private int e;
  private int f;
  private int g;
  private int h = 144;
  private int i = 256;
  
  public QQPoseDetectFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    QmcfManager.a().b(0);
    this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor = new PoseDetectProcessor(this.h, this.i);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
    }
    if (this.c != null) {
      this.c.d();
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor.b();
    int k = this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor.a();
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(j, k, 33984, bool);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.e, this.f, 33984);
      this.c = new RenderBuffer(this.e, this.f);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirHumanPoseFilter.a(this.c);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
      return;
    }
  }
  
  public int a()
  {
    return this.h;
  }
  
  public float[] a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor.a();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (SLog.a()) {
      SLog.d("QQPoseDetectFilter", "onSurfaceChange");
    }
    this.e = paramInt1;
    this.f = paramInt2;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor.a();
    if ((this.e > 0) && (this.f > 0) && (QmcfManager.a().b() != 1))
    {
      this.h = (this.i * this.e / this.f);
      if (this.h < 144) {
        this.h = 144;
      }
      this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor.a(this.h, this.i);
      if (QmcfManager.d) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirHumanPoseFilter.a(this.h, this.i);
      }
    }
  }
  
  public void d()
  {
    if (SLog.a()) {
      SLog.d("QQPoseDetectFilter", "onSurfaceCreate");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirHumanPoseFilter.a();
  }
  
  public int e()
  {
    return this.i;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor.a();
    QmcfManager.a().a();
    if (SLog.a()) {
      SLog.d("QQPoseDetectFilter", "onSurfaceDestroy");
    }
  }
  
  public boolean f_()
  {
    return QmcfManager.a().a() == 2;
  }
  
  public void h()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor.b();
      if (this.jdField_a_of_type_Boolean)
      {
        a();
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        return;
      }
      Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.setRotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 180.0F, 1.0F, 0.0F, 0.0F);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, this.jdField_a_of_type_Int, QmcfManager.a().jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      this.g = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor.b(this.g, this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a());
      if ((QmcfManager.d) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirHumanPoseFilter != null))
      {
        this.c.a(this.jdField_a_of_type_Int);
        this.c.b();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirHumanPoseFilter.a(this.c, this.jdField_a_of_type_ComTencentMobileqqQmcfProcessorPoseDetectProcessor.a());
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirHumanPoseFilter.b(this.c);
      }
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      return;
    }
    catch (Exception localException)
    {
      QmcfManager.a().a(false, false, 2);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      SLog.a("QQPoseDetectFilter", "process excep!", localException);
      return;
    }
    catch (Error localError)
    {
      QmcfManager.a().a(false, false, 2);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      SLog.a("QQPoseDetectFilter", "process excep!", localError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPoseDetectFilter
 * JD-Core Version:    0.7.0.1
 */