package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.GlMatricUtil;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;
import java.util.Map;

public class QQTrackerStickersFilter
  extends QQBaseFilter
{
  private static String jdField_a_of_type_JavaLangString = "QQTrackerStickersFilter";
  private GPUAlphaBlendFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = null;
  private int[] jdField_a_of_type_ArrayOfInt;
  private float[][] jdField_a_of_type_Array2dOfFloat;
  private boolean b;
  private int e = 0;
  private int f = 0;
  
  public QQTrackerStickersFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.jdField_b_of_type_Boolean = true;
  }
  
  TrackerStickerParam.MotionInfo a(long paramLong, TrackerStickerParam paramTrackerStickerParam)
  {
    TrackerStickerParam.MotionInfo localMotionInfo = (TrackerStickerParam.MotionInfo)paramTrackerStickerParam.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    paramTrackerStickerParam = localMotionInfo;
    if (localMotionInfo == null) {
      paramTrackerStickerParam = new TrackerStickerParam.MotionInfo(true, 0L, 0.0F, 0.0F, 1.0F, 0.0F);
    }
    return paramTrackerStickerParam;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilArrayList.size()];
      this.jdField_a_of_type_Array2dOfFloat = new float[this.jdField_a_of_type_JavaUtilArrayList.size()][];
      this.jdField_a_of_type_Boolean = true;
    }
    while (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfFloat = null;
      return;
      this.jdField_a_of_type_Boolean = false;
      SLog.c(jdField_a_of_type_JavaLangString, "TrackerStickerParam is null or zero");
    }
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public float[] a(TrackerStickerParam paramTrackerStickerParam, TrackerStickerParam.MotionInfo paramMotionInfo)
  {
    float f1 = this.e / this.f;
    GlMatricUtil localGlMatricUtil = new GlMatricUtil();
    localGlMatricUtil.a(-1.0F * f1, 1.0F * f1, -1.0F, 1.0F, 3.0F, 20.0F);
    localGlMatricUtil.a(0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    float f2 = paramMotionInfo.jdField_a_of_type_Float * 2.0F / paramTrackerStickerParam.jdField_a_of_type_Int;
    float f3 = paramMotionInfo.jdField_b_of_type_Float * 2.0F / paramTrackerStickerParam.jdField_b_of_type_Int;
    if (this.jdField_b_of_type_Boolean) {
      localGlMatricUtil.a((f2 - 1.0F) * f1, f3 - 1.0F, 0.0F);
    }
    for (;;)
    {
      float f4 = this.e / paramTrackerStickerParam.jdField_a_of_type_Int;
      f2 = this.f / paramTrackerStickerParam.jdField_b_of_type_Int;
      float f5 = paramTrackerStickerParam.e / this.e;
      f3 = paramTrackerStickerParam.f / this.f;
      f1 = f4 * paramTrackerStickerParam.jdField_a_of_type_Float * f5 * f1;
      f2 = f2 * paramTrackerStickerParam.jdField_a_of_type_Float * f3;
      localGlMatricUtil.a(paramTrackerStickerParam.jdField_b_of_type_Float, 0.0F, 0.0F, 1.0F);
      localGlMatricUtil.b(f1, f2, 1.0F);
      SLog.d("trackerMatrix ", "finalScaleX : " + f1 + " finalScaleY:" + f2);
      paramMotionInfo = localGlMatricUtil.a();
      paramTrackerStickerParam = "mvp: ";
      int i = 0;
      while (i < 16)
      {
        paramTrackerStickerParam = paramTrackerStickerParam + " " + paramMotionInfo[i];
        i += 1;
      }
      localGlMatricUtil.a((f2 - 1.0F) * f1, 1.0F - f3, 0.0F);
    }
    SLog.d("trackerMatrix ", paramTrackerStickerParam);
    return paramMotionInfo;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    if ((paramInt1 != this.e) || (paramInt2 != this.f))
    {
      this.e = paramInt1;
      this.f = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.e, this.f, 33984);
    }
  }
  
  public void d()
  {
    super.d();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter = new GPUAlphaBlendFilter();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter;
      GPUAlphaBlendFilter.a("filter init");
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = BitmapFactory.decodeFile(((TrackerStickerParam)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_ArrayOfInt[i] = GlUtil.a(3553, (Bitmap)localObject);
        }
        i += 1;
      }
    }
    this.e = a().h();
    this.f = a().i();
    try
    {
      i = GLES20.glGetError();
      if (i != 0)
      {
        localObject = "previousUnknownError: glError 0x" + Integer.toHexString(i);
        SLog.a(jdField_a_of_type_JavaLangString, (String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.e, this.f, 33984);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.d();
  }
  
  public boolean f_()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @TargetApi(17)
  public void h()
  {
    long l2;
    long l3;
    long l4;
    if (this.jdField_a_of_type_Boolean)
    {
      l2 = a().b();
      l3 = a().c();
      l1 = a().a();
      l4 = l2 / 1000000L;
      if (l4 <= l1) {
        break label344;
      }
    }
    label309:
    label337:
    label344:
    for (long l1 = l4 - l1;; l1 = 0L) {
      for (;;)
      {
        int i;
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
          i = 0;
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label309;
          }
          TrackerStickerParam localTrackerStickerParam = (TrackerStickerParam)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (!localTrackerStickerParam.a((int)l1)) {
            break label337;
          }
          if ((localTrackerStickerParam.jdField_a_of_type_JavaUtilMap == null) || (localTrackerStickerParam.jdField_a_of_type_JavaUtilMap.size() == 0))
          {
            localMotionInfo = new TrackerStickerParam.MotionInfo(false, l3, localTrackerStickerParam.jdField_a_of_type_AndroidGraphicsPointF.x + localTrackerStickerParam.c, localTrackerStickerParam.jdField_a_of_type_AndroidGraphicsPointF.y + localTrackerStickerParam.d, 1.0F, 0.0F);
            this.jdField_a_of_type_Array2dOfFloat[i] = a(localTrackerStickerParam, localMotionInfo);
            GLES20.glViewport(0, 0, this.e, this.f);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.a(this.jdField_a_of_type_ArrayOfInt[i], this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Array2dOfFloat[i]);
          }
        }
        catch (Throwable localThrowable)
        {
          this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          return;
        }
        TrackerStickerParam.MotionInfo localMotionInfo = a(l2, localThrowable);
        if (!localMotionInfo.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Array2dOfFloat[i] = a(localThrowable, localMotionInfo);
          GLES20.glViewport(0, 0, this.e, this.f);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.a(this.jdField_a_of_type_ArrayOfInt[i], this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Array2dOfFloat[i]);
          break label337;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
          this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
          return;
          this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQTrackerStickersFilter
 * JD-Core Version:    0.7.0.1
 */