package com.tencent.ttpic.module_switchface;

import alze;
import android.opengl.GLES20;
import com.tencent.av.switchface.SwitchFaceProcessorItem;
import com.tencent.av.switchface.SwitchFaceUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.RGBATexSaveProcess;
import com.tencent.ttpic.util.SwitchFaceUtil;
import java.util.List;

public class SwitchFaceProcessor
{
  private long jdField_a_of_type_Long;
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private SwitchFaceFilter jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceFilter;
  private RGBATexSaveProcess jdField_a_of_type_ComTencentTtpicUtilRGBATexSaveProcess;
  private SwitchFaceProcessorItem[] jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem = new SwitchFaceProcessorItem[2];
  
  public SwitchFaceProcessor()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[i] = new SwitchFaceProcessorItem();
      i += 1;
    }
    SwitchFaceUtil.setAllGrayImagePath(SwitchFaceUtils.a);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      return;
    }
    GLES20.glDisable(3042);
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].a(this.jdField_a_of_type_ComTencentTtpicUtilRGBATexSaveProcess)) && (this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].a(this.jdField_a_of_type_ComTencentTtpicUtilRGBATexSaveProcess))) {
      ThreadManager.post(new alze(this, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_c_of_type_Int), 5, null, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process two face detect cost " + (System.currentTimeMillis() - l));
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SwitchFaceProcessor", 2, "WL_DEBUG process retrieve data1 error");
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].d = (this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_a_of_type_Float - this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_a_of_type_Float);
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].e = (this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_b_of_type_Float - this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_b_of_type_Float);
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].f = (this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_c_of_type_Float - this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_c_of_type_Float);
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].d = (this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_a_of_type_Float - this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_a_of_type_Float);
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].e = (this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_b_of_type_Float - this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_b_of_type_Float);
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].f = (this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_c_of_type_Float - this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_c_of_type_Float);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceFilter = new SwitchFaceFilter();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ApplyGLSLFilter();
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceFilter.ApplyGLSLFilter();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[i].jdField_a_of_type_ComTencentFilterFrame = new Frame();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentTtpicUtilRGBATexSaveProcess = new RGBATexSaveProcess();
  }
  
  public int[] a(int paramInt1, List paramList1, int paramInt2, int paramInt3, int paramInt4, List paramList2, int paramInt5, int paramInt6)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_a_of_type_Int = paramInt4;
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_a_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_b_of_type_Int = paramInt5;
    this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_c_of_type_Int = paramInt6;
    if (l - this.jdField_a_of_type_Long > 2000L)
    {
      c();
      this.jdField_a_of_type_Long = l;
    }
    a(true);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_c_of_type_Int, -1, 0.0D, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_a_of_type_ComTencentFilterFrame);
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceFilter.a(this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0], this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1]);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_c_of_type_Int, -1, 0.0D, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_a_of_type_ComTencentFilterFrame);
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceFilter.a(this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1], this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0]);
    a(false);
    return new int[] { this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[0].jdField_a_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[1].jdField_a_of_type_ComTencentFilterFrame.getTextureId() };
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceFilter.ClearGLSL();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceProcessorItem[i].jdField_a_of_type_ComTencentFilterFrame.clear();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentTtpicUtilRGBATexSaveProcess.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.ttpic.module_switchface.SwitchFaceProcessor
 * JD-Core Version:    0.7.0.1
 */