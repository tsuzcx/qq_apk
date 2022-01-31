package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import com.tencent.filter.Frame;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.filter.PTSmoothBeauty;
import com.tencent.ttpic.util.BenchUtil;

public class QQPtBeautyFilter
  extends QQBaseFilter
{
  private Frame jdField_a_of_type_ComTencentFilterFrame = new Frame();
  private PTSmoothBeauty jdField_a_of_type_ComTencentTtpicFilterPTSmoothBeauty = new PTSmoothBeauty();
  private String jdField_a_of_type_JavaLangString = "QQPtBeautyFilter";
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private boolean b;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  
  public QQPtBeautyFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    this.jdField_a_of_type_ComTencentTtpicFilterPTSmoothBeauty.ClearGLSL();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (a().d())
    {
      a();
      this.jdField_a_of_type_ComTencentTtpicFilterPTSmoothBeauty.ApplyGLSLFilter(true, paramInt1, paramInt2);
      if (!Boolean.valueOf(this.jdField_a_of_type_ComTencentTtpicFilterPTSmoothBeauty.checkApplyGLSLFilterResult()).booleanValue()) {
        SLog.a(this.jdField_a_of_type_JavaLangString, "ApplyGLSLFilter failed!");
      }
      this.jdField_a_of_type_ComTencentTtpicFilterPTSmoothBeauty.setBeautyLevel(this.e);
      GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      this.jdField_b_of_type_Boolean = true;
      SLog.d(this.jdField_a_of_type_JavaLangString, "init by beauty");
      return;
    }
    SLog.a(this.jdField_a_of_type_JavaLangString, "beauty init failed");
  }
  
  private boolean b()
  {
    if (this.e == 0) {}
    while ((QmcfManager.a().a()) || (a().e() == 3)) {
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentTtpicFilterPTSmoothBeauty.setBeautyLevel(this.e);
    }
    if (SLog.a()) {
      SLog.c(this.jdField_a_of_type_JavaLangString, "setBeautyLevel " + this.e);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.g != paramInt1) || (this.g != paramInt2)) {
      a(paramInt1, paramInt2);
    }
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      a();
    }
  }
  
  public boolean f_()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void h()
  {
    this.f = a().f();
    this.g = a().g();
    if ((this.jdField_a_of_type_ComTencentTtpicFilterPTSmoothBeauty != null) && (b()))
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        a(this.f, this.g);
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        return;
      }
      BenchUtil.benchStart("mBeautyFilter");
      this.jdField_a_of_type_ComTencentTtpicFilterPTSmoothBeauty.RenderProcess(this.jdField_a_of_type_Int, this.f, this.g, this.jdField_a_of_type_ArrayOfInt[0], 0.0D, this.jdField_a_of_type_ComTencentFilterFrame);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ArrayOfInt[0];
      QQFilterLogManager.a("QQPtBeautyFilter", true);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    QQFilterLogManager.a("QQPtBeautyFilter", false);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPtBeautyFilter
 * JD-Core Version:    0.7.0.1
 */