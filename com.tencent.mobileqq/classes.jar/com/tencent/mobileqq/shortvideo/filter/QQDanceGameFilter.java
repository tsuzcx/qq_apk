package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.GLShaderManager;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.DancePosture;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.Posture;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate.MatchTemplate;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.PoseDataConvert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@TargetApi(18)
public class QQDanceGameFilter
  extends QQBaseFilter
{
  private static int g = 2;
  private long jdField_a_of_type_Long = 0L;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private DanceManagerFilter jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter;
  private QQPoseDetectFilter jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter;
  private List jdField_a_of_type_JavaUtilList = new ArrayList(18);
  private boolean jdField_a_of_type_Boolean = false;
  private long b;
  private long c = 0L;
  private long d = 0L;
  private int e = 720;
  private int f = 1280;
  
  public QQDanceGameFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter = new DanceManagerFilter(0, paramQQFilterRenderManager);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter = new QQPoseDetectFilter(0, paramQQFilterRenderManager);
    this.d = 0L;
  }
  
  private boolean b()
  {
    if (this.d == 0L) {}
    while (SystemClock.elapsedRealtime() - this.d >= 300L) {
      return true;
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter.d();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.d();
  }
  
  private void i()
  {
    QQFilterRenderManager localQQFilterRenderManager = a();
    int i = localQQFilterRenderManager.h();
    int j = localQQFilterRenderManager.i();
    this.e = localQQFilterRenderManager.f();
    this.f = localQQFilterRenderManager.g();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter.b(this.e, this.f);
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
    DanceLog.a("QQDanceGameFilter", "onCloseClicked isReady=" + bool);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.b();
    if (i == 0)
    {
      QQDanceEventHandler localQQDanceEventHandler = a().a();
      if (localQQDanceEventHandler != null)
      {
        DanceLog.a("QQDanceGameFilter", "onCloseClicked call closeEvent");
        localQQDanceEventHandler.f(bool);
        DanceLog.a("QQDanceGameFilter", "onCloseClicked call closeEvent ...");
      }
    }
  }
  
  public float[] a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter.a();
  }
  
  public void b()
  {
    this.d = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(0);
    GLFrameImage.g();
    DanceLog.b("GLFrameImage", "changeToReadyFilter: reloadTextureCache");
    BadcaseReportUtils.c();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    DanceLog.b("GLFrameImage", "onSurfaceChange");
  }
  
  public void d()
  {
    DanceLog.b("GLFrameImage", "onSurfaceCreate");
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter.e();
    GLShaderManager.a();
    DanceLog.b("GLFrameImage", "onSurfaceDestroy:clearShaderManager");
    GLFrameImage.ai_();
    DanceLog.b("GLFrameImage", "onSurfaceDestroy:clearTextureCache");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.e();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.f();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.g();
  }
  
  public void h()
  {
    Iterator localIterator = null;
    if (QmcfManager.a().a() != 2)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      c();
      i();
      j();
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool = b();
    if (!bool) {
      Log.i("onDrawFrame", "onDrawFrame[Dance]: needMatchInterval300" + bool);
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if ((!QmcfManager.b) || (this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter.b(this.jdField_a_of_type_Int);
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a() != 2)) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter.h();
      }
      this.c = (System.currentTimeMillis() - this.jdField_b_of_type_Long);
      this.jdField_a_of_type_Long = (this.jdField_b_of_type_Long + g * this.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, this.jdField_a_of_type_Int, null, null);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a();
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = localIterator;
    Object localObject3;
    if (bool)
    {
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localObject1 = a();
        localIterator = ((TreeSet)localObject2).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject2 = (GLLittleBoy)localIterator.next();
            if (((GLLittleBoy)localObject2).b())
            {
              localObject3 = ((GLLittleBoy)localObject2).a();
              if (localObject3 != null)
              {
                localObject3 = ResourceManager.a().a(((ResourceManager.DancePosture)localObject3).a);
                if (localObject3 != null)
                {
                  List localList = ((ResourceManager.Posture)localObject3).b;
                  PoseDataConvert.a(PoseDataConvert.a((float[])localObject1, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b(), this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c(), this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter.a(), this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPoseDetectFilter.e()), this.jdField_a_of_type_JavaUtilList);
                  bool = MatchTemplate.a().a(this.jdField_a_of_type_JavaUtilList, localList, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b());
                  ((GLLittleBoy)localObject2).b(bool);
                  if (bool)
                  {
                    this.d = SystemClock.elapsedRealtime();
                    BadcaseReportUtils.b();
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      BadcaseReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b(), this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c(), (float[])localObject1);
      BadcaseReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a());
      DanceLog.a("onDrawFrame", "[Match]cost = " + (SystemClock.elapsedRealtime() - l) + " ms");
      l = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.h();
      DanceLog.a("onDrawFrame", "[DanceMgrFilter]cost = " + (SystemClock.elapsedRealtime() - l) + " ms");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      return;
      if (BadcaseReportUtils.a()) {
        BadcaseReportUtils.a();
      }
      BadcaseReportUtils.a(this.c);
      BadcaseReportUtils.a(this.jdField_a_of_type_JavaUtilList, (ResourceManager.Posture)localObject3, ((GLLittleBoy)localObject2).jdField_b_of_type_Int);
      break;
    }
  }
  
  public boolean i_()
  {
    return QmcfManager.a().a() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQDanceGameFilter
 * JD-Core Version:    0.7.0.1
 */