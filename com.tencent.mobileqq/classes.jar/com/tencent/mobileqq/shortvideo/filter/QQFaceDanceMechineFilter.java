package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLShaderManager;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask;
import java.util.TreeSet;

public class QQFaceDanceMechineFilter
  extends QQBaseFilter
{
  public static boolean a;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private DanceManagerFilter jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter;
  private QQFaceDanceDetectFilter jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFaceDanceDetectFilter;
  private boolean b;
  private int e = 720;
  private int f = 1280;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public QQFaceDanceMechineFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter = new DanceManagerFilter(0, paramQQFilterRenderManager);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFaceDanceDetectFilter = new QQFaceDanceDetectFilter(0, paramQQFilterRenderManager);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.d();
  }
  
  private void i()
  {
    QQFilterRenderManager localQQFilterRenderManager = a();
    int i = localQQFilterRenderManager.h();
    int j = localQQFilterRenderManager.i();
    this.e = localQQFilterRenderManager.f();
    this.f = localQQFilterRenderManager.g();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.b(i, j);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(this.e, this.f);
    float f1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().a();
    j = (int)(this.f / f1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.b(i, j);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.e, this.f, 33984);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.b();
    if (i == 0)
    {
      QQDanceEventHandler localQQDanceEventHandler = a().a();
      if (localQQDanceEventHandler != null) {
        localQQDanceEventHandler.f(bool);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFaceDanceDetectFilter.b();
    GLFrameImage.g();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFaceDanceDetectFilter.e();
    GLShaderManager.a();
    GLFrameImage.am_();
  }
  
  public void f()
  {
    FaceDanceDetectTask.a("QQFaceDanceMechineFilter.onResume");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.f();
  }
  
  public boolean f_()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    FaceDanceDetectTask.a("QQFaceDanceMechineFilter.onPause");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.g();
  }
  
  public void h()
  {
    if (!jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      c();
      i();
      j();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFaceDanceDetectFilter.b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFaceDanceDetectFilter.h();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, this.jdField_a_of_type_Int, null, null);
      TreeSet localTreeSet = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a();
      FaceDanceDetectTask.a().a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.h();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFaceDanceDetectFilter.a(localTreeSet);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFaceDanceMechineFilter
 * JD-Core Version:    0.7.0.1
 */