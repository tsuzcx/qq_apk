package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.graphics.PointF;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.ttpic.model.StickerItem;
import java.util.List;
import java.util.Map;

public class GestureFilterManager$AnimationWrapper
{
  private long jdField_a_of_type_Long = 0L;
  public GestureKeyInfo a;
  public NonFit2DFilter a;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GestureFilterManager$AnimationWrapper(StickerItem paramStickerItem, String paramString, GestureKeyInfo paramGestureKeyInfo, PointF paramPointF, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter = new NonFit2DFilter(paramStickerItem, paramString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = paramGestureKeyInfo;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.a(paramPointF);
  }
  
  public static boolean a(GestureKeyInfo paramGestureKeyInfo1, GestureKeyInfo paramGestureKeyInfo2, float paramFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(paramGestureKeyInfo1.a[0].x - paramGestureKeyInfo2.a[0].x) <= paramFloat)
    {
      bool1 = bool2;
      if (Math.abs(paramGestureKeyInfo1.a[0].y - paramGestureKeyInfo2.a[0].y) <= paramFloat) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.a(paramLong)) {
      return 1;
    }
    return 2;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.a();
  }
  
  public void a(int paramInt1, int paramInt2, double paramDouble)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.ApplyGLSLFilter();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.setRenderMode(1);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.OnDrawFrameGLSL();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(GestureKeyInfo paramGestureKeyInfo, PointF paramPointF)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = paramGestureKeyInfo;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.a(paramPointF);
  }
  
  public void a(List paramList, float[] paramArrayOfFloat, Map paramMap, float paramFloat, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.updatePreview(null, null, paramMap, paramFloat, paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.c();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureNonFit2DFilter.clearGLSLSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.AnimationWrapper
 * JD-Core Version:    0.7.0.1
 */