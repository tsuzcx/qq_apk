package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.GlMatricUtil;
import com.tencent.sveffects.SLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQDynamicStickersFilter
  extends QQBaseFilter
{
  private static String jdField_a_of_type_JavaLangString = "QQDynamicStickersFilter";
  private GPUAlphaBlendFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = null;
  private float[][] jdField_a_of_type_Array2dOfFloat;
  private boolean b;
  private int e;
  private int f = 0;
  private int g = 0;
  
  public QQDynamicStickersFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.jdField_b_of_type_Boolean = true;
  }
  
  TrackerStickerParam.MotionInfo a(long paramLong, DynamicStickerData paramDynamicStickerData)
  {
    TrackerStickerParam.MotionInfo localMotionInfo = (TrackerStickerParam.MotionInfo)paramDynamicStickerData.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    paramDynamicStickerData = localMotionInfo;
    if (localMotionInfo == null) {
      paramDynamicStickerData = new TrackerStickerParam.MotionInfo(true, 0L, 0.0F, 0.0F, 1.0F, 0.0F);
    }
    return paramDynamicStickerData;
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((DynamicStickerData)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder.a();
      }
      this.jdField_a_of_type_Array2dOfFloat = new float[paramList.size()][];
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfFloat = null;
      return;
    }
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public float[] a(DynamicStickerData paramDynamicStickerData, TrackerStickerParam.MotionInfo paramMotionInfo)
  {
    float f3 = this.f / this.g;
    GlMatricUtil localGlMatricUtil = new GlMatricUtil();
    localGlMatricUtil.a(-1.0F * f3, 1.0F * f3, -1.0F, 1.0F, 3.0F, 20.0F);
    localGlMatricUtil.a(0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    float f1 = paramDynamicStickerData.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = paramDynamicStickerData.jdField_c_of_type_Float + f1;
    f1 = paramDynamicStickerData.jdField_a_of_type_AndroidGraphicsPointF.y + paramDynamicStickerData.d;
    if (paramMotionInfo != null)
    {
      f2 = paramMotionInfo.jdField_a_of_type_Float;
      f1 = paramMotionInfo.jdField_b_of_type_Float;
    }
    f2 = f2 * 2.0F / paramDynamicStickerData.jdField_b_of_type_Int;
    f1 = f1 * 2.0F / paramDynamicStickerData.jdField_c_of_type_Int;
    if (this.jdField_b_of_type_Boolean) {
      localGlMatricUtil.a((f2 - 1.0F) * f3, f1 - 1.0F, 0.0F);
    }
    for (;;)
    {
      float f4 = this.f / paramDynamicStickerData.jdField_b_of_type_Int;
      f1 = this.g / paramDynamicStickerData.jdField_c_of_type_Int;
      float f5 = paramDynamicStickerData.e / this.f;
      f2 = paramDynamicStickerData.f / this.g;
      f3 = f4 * paramDynamicStickerData.jdField_a_of_type_Float * f5 * f3;
      f1 = f1 * paramDynamicStickerData.jdField_a_of_type_Float * f2;
      localGlMatricUtil.a(paramDynamicStickerData.jdField_b_of_type_Float, 0.0F, 0.0F, 1.0F);
      localGlMatricUtil.b(f3, f1, 1.0F);
      SLog.d("giftrackerMatrix ", "finalScaleX : " + f3 + " finalScaleY:" + f1);
      paramMotionInfo = localGlMatricUtil.a();
      paramDynamicStickerData = "mvp: ";
      int i = 0;
      while (i < 16)
      {
        paramDynamicStickerData = paramDynamicStickerData + " " + paramMotionInfo[i];
        i += 1;
      }
      localGlMatricUtil.a((f2 - 1.0F) * f3, 1.0F - f1, 0.0F);
    }
    SLog.d("giftrackerMatrix ", paramDynamicStickerData);
    return paramMotionInfo;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    this.e = GlUtil.a(3553);
    if ((paramInt1 != this.f) || (paramInt2 != this.g))
    {
      this.f = paramInt1;
      this.g = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.f, this.g, 33984);
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_a_of_type_Array2dOfFloat[paramInt1] = a((DynamicStickerData)this.jdField_a_of_type_JavaUtilList.get(paramInt1), null);
        paramInt1 += 1;
      }
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
    this.f = a().h();
    this.g = a().i();
    int i;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_a_of_type_Array2dOfFloat[i] = a((DynamicStickerData)this.jdField_a_of_type_JavaUtilList.get(i), null);
        i += 1;
      }
    }
    try
    {
      i = GLES20.glGetError();
      if (i != 0)
      {
        localObject = "previousUnknownError: glError 0x" + Integer.toHexString(i);
        SLog.a(jdField_a_of_type_JavaLangString, (String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.f, this.g, 33984);
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.c();
  }
  
  @TargetApi(17)
  public void h()
  {
    long l2;
    long l3;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null))
    {
      l2 = a().c();
      l3 = a().b();
      l1 = a().a();
      l3 /= 1000000L;
      if (l3 <= l1) {
        break label423;
      }
    }
    label411:
    label416:
    label423:
    for (long l1 = l3 - l1;; l1 = 0L)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
      for (;;)
      {
        int j;
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
          j = 0;
          if (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            Bitmap localBitmap = ((DynamicStickerData)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder.a(l2);
            if (!((DynamicStickerData)this.jdField_a_of_type_JavaUtilList.get(j)).a((int)l1)) {
              break label416;
            }
            DynamicStickerData localDynamicStickerData = (DynamicStickerData)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localDynamicStickerData.jdField_a_of_type_JavaUtilMap.size() == 0) {
              break label411;
            }
            TrackerStickerParam.MotionInfo localMotionInfo = a(l2, localDynamicStickerData);
            if (!localMotionInfo.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Array2dOfFloat[j] = a(localDynamicStickerData, localMotionInfo);
              i = 0;
              if ((localBitmap == null) || (i != 0)) {
                break label416;
              }
              GLES20.glBindTexture(3553, this.e);
              GlUtil.a("glBindTexture " + this.e);
              GLES20.glTexParameterf(3553, 10241, 9729.0F);
              GLES20.glTexParameterf(3553, 10240, 9729.0F);
              GLES20.glTexParameteri(3553, 10242, 33071);
              GLES20.glTexParameteri(3553, 10243, 33071);
              GLUtils.texImage2D(3553, 0, localBitmap, 0);
              GlUtil.a("glTexParameter");
              this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.a(this.e, this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Array2dOfFloat[j]);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        }
        for (;;)
        {
          this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          return;
          i = 1;
          break;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
          this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
        }
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        return;
        int i = 0;
        continue;
        j += 1;
      }
    }
  }
  
  public boolean i_()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQDynamicStickersFilter
 * JD-Core Version:    0.7.0.1
 */