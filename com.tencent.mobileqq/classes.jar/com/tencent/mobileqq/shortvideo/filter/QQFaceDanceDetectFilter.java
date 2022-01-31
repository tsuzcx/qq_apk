package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.os.SystemClock;
import com.tencent.filter.Frame;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask;
import com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager;
import com.tencent.ttpic.filter.VideoFlipFilter;
import com.tencent.util.PhoneProperty;
import java.util.TreeSet;

@SuppressLint({"NewApi"})
public class QQFaceDanceDetectFilter
  extends QQBaseFilter
{
  public Frame a;
  QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  VideoFlipFilter jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter = VideoFlipFilter.createVideoFlipFilter();
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  boolean b;
  boolean c = false;
  private boolean d = false;
  
  public QQFaceDanceDetectFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.jdField_a_of_type_ComTencentFilterFrame = new Frame();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = paramQQFilterRenderManager;
  }
  
  private void c()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.e();
      FaceDanceDetectTask.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager);
      this.jdField_b_of_type_Boolean = true;
    }
    if (!this.c)
    {
      a();
      this.c = true;
    }
  }
  
  public void a()
  {
    GestureDetectManager.a().a();
  }
  
  public void a(TreeSet paramTreeSet)
  {
    if ((paramTreeSet == null) || (paramTreeSet.size() == 0)) {}
    do
    {
      return;
      c();
    } while (FaceDanceDetectTask.a().a());
    if (!this.jdField_a_of_type_Boolean)
    {
      GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ClearGLSL();
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ApplyGLSLFilter();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    long l2 = SystemClock.elapsedRealtimeNanos();
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a();
    int j = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b();
    byte[] arrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(this.jdField_a_of_type_Int, i, j);
    long l1 = SystemClock.elapsedRealtimeNanos();
    FaceDanceDetectTask.a("frist getFaceDetectDataByTexture", l2, l1);
    this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.RenderProcess(this.jdField_a_of_type_Int, a().f(), a().g(), this.jdField_a_of_type_ArrayOfInt[0], 0.0D, this.jdField_a_of_type_ComTencentFilterFrame);
    if (PhoneProperty.instance().isCannotReuseFrameBuffer()) {
      this.jdField_a_of_type_ComTencentFilterFrame.clear();
    }
    l2 = SystemClock.elapsedRealtimeNanos();
    FaceDanceDetectTask.a("Flip Texture", l1, l2);
    byte[] arrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(this.jdField_a_of_type_ArrayOfInt[0], i, j);
    FaceDanceDetectTask.a("second getFaceDetectDataByTexture", l2, SystemClock.elapsedRealtimeNanos());
    FaceDanceDetectTask.a().a(arrayOfByte1, arrayOfByte2, i, j, paramTreeSet);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentFilterFrame != null) {
      this.jdField_a_of_type_ComTencentFilterFrame.clear();
    }
  }
  
  public void e()
  {
    super.e();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    FaceDanceDetectTask.a().c();
    if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ClearGLSL();
      this.jdField_a_of_type_ComTencentFilterFrame.clear();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void h()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public boolean i_()
  {
    return QQFaceDanceMechineFilter.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFaceDanceDetectFilter
 * JD-Core Version:    0.7.0.1
 */