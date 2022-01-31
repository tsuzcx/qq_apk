package com.tencent.mobileqq.shortvideo.ptvfilter;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.BuckleFaceItem;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.BuckleFrameItem;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BuckleFaceFilter
  extends VideoFilterBase
{
  public static final String a;
  public static final String b;
  private BuckleFaceItem jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialBuckleFaceItem;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[8];
  private float[] b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceCropVertexShader.dat");
    jdField_b_of_type_JavaLangString = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceCropFragmentShader.dat");
  }
  
  public BuckleFaceFilter(BuckleFaceItem paramBuckleFaceItem, String paramString)
  {
    super(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, null);
    this.jdField_b_of_type_ArrayOfFloat = new float[8];
    if ((paramBuckleFaceItem == null) || (paramBuckleFaceItem.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      throw new IllegalArgumentException("BuckleFaceFilter| items length error!");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialBuckleFaceItem = paramBuckleFaceItem;
  }
  
  private static float a(float paramFloat)
  {
    return (float)(180.0F * paramFloat / 3.141592653589793D);
  }
  
  private static float a(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void a(List paramList, float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    Object localObject1 = (BuckleFrameItem)this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialBuckleFaceItem.jdField_a_of_type_JavaUtilList.get(paramInt);
    double d1 = localObject1.jdField_b_of_type_ArrayOfDouble[0];
    double d2 = localObject1.jdField_b_of_type_ArrayOfDouble[1];
    double d3 = localObject1.jdField_a_of_type_ArrayOfDouble[0];
    double d4 = localObject1.jdField_a_of_type_ArrayOfDouble[1];
    paramFloat = (float)Math.min(d1 / this.width, d2 / this.height);
    float f1 = (float)(d1 / paramFloat);
    float f2 = (float)(d2 / paramFloat);
    Object localObject2 = new PointF((f1 - this.width) / 2.0F, (f2 - this.height) / 2.0F);
    float f5 = (float)(((BuckleFrameItem)localObject1).jdField_b_of_type_Double / paramFloat);
    f1 = (float)(d3 / paramFloat - ((PointF)localObject2).x);
    f2 = (float)(d4 / paramFloat - ((PointF)localObject2).y);
    localObject2 = FaceOffUtil.getFullCoords(paramList, 3.0F);
    paramList = ((List)localObject2).iterator();
    PointF localPointF;
    while (paramList.hasNext())
    {
      localPointF = (PointF)paramList.next();
      localPointF.x = ((float)(localPointF.x / this.mScreenScale));
      localPointF.y = ((float)(localPointF.y / this.mScreenScale));
    }
    paramFloat = a((PointF)((List)localObject2).get(0), (PointF)((List)localObject2).get(18));
    float f3 = ((PointF)((List)localObject2).get(64)).x;
    float f4 = ((PointF)((List)localObject2).get(64)).y;
    paramList = new ArrayList();
    paramList.add(((List)localObject2).get(99));
    paramList.add(((List)localObject2).get(105));
    paramList.add(((List)localObject2).get(101));
    paramList.add(((List)localObject2).get(103));
    float f6 = f5 / paramFloat;
    float f7 = paramArrayOfFloat[1];
    paramFloat = 0.0F;
    if (Math.abs(f7) > 0.2D) {
      if (f7 <= 0.0F) {
        break label580;
      }
    }
    label580:
    for (paramFloat = (f7 - 0.2F) * f5;; paramFloat = (0.2F + f7) * f5)
    {
      localObject2 = new Matrix();
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).postRotate(a((float)(paramArrayOfFloat[2] - ((BuckleFrameItem)localObject1).jdField_a_of_type_Double)), f3, f4);
      ((Matrix)localObject2).postScale(f6, f6, f3, f4);
      ((Matrix)localObject2).postTranslate(f1 - f3, f2 - f4);
      ((Matrix)localObject2).postTranslate(paramFloat, 0.0F);
      paramArrayOfFloat = new ArrayList();
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localPointF = (PointF)((Iterator)localObject1).next();
        float[] arrayOfFloat = new float[2];
        ((Matrix)localObject2).mapPoints(arrayOfFloat, new float[] { localPointF.x, localPointF.y });
        paramArrayOfFloat.add(new PointF(arrayOfFloat[0], arrayOfFloat[1]));
      }
    }
    int i = 0;
    paramInt = 0;
    while (paramInt < 4)
    {
      localObject1 = (PointF)paramArrayOfFloat.get(paramInt);
      this.jdField_a_of_type_ArrayOfFloat[i] = (2.0F * ((PointF)localObject1).x / this.width - 1.0F);
      this.jdField_a_of_type_ArrayOfFloat[(i + 1)] = (((PointF)localObject1).y * 2.0F / this.height - 1.0F);
      localObject1 = (PointF)paramList.get(paramInt);
      this.jdField_b_of_type_ArrayOfFloat[i] = (((PointF)localObject1).x / this.width);
      this.jdField_b_of_type_ArrayOfFloat[(i + 1)] = (((PointF)localObject1).y / this.height);
      i += 2;
      paramInt += 1;
    }
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLE_STRIP);
    setRenderMode(0);
    setPositions(this.jdField_a_of_type_ArrayOfFloat);
    setTexCords(this.jdField_b_of_type_ArrayOfFloat);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void initParams() {}
  
  public void updatePreview(List paramList, float[] paramArrayOfFloat, Map paramMap, float paramFloat, long paramLong)
  {
    if (!VideoUtil.isEmpty(this.jdField_a_of_type_JavaUtilList))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label160;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      label40:
      NormalVideoFilter localNormalVideoFilter;
      do
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localNormalVideoFilter = (NormalVideoFilter)localIterator.next();
        localNormalVideoFilter.updatePreview(paramList, paramArrayOfFloat, paramMap, paramFloat, paramLong);
      } while ((localNormalVideoFilter.getStickerItem().id.equals("bgm")) || (localNormalVideoFilter.getStickerItem().frameDuration != this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialBuckleFaceItem.jdField_a_of_type_Int));
      i = localNormalVideoFilter.getLastFrameIndex();
      if ((!this.jdField_a_of_type_Boolean) || (!localNormalVideoFilter.isRenderReady())) {
        break label154;
      }
    }
    label154:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      break label40;
      bool = false;
      break;
    }
    label160:
    int j = 0;
    if ((!this.jdField_a_of_type_Boolean) || (VideoUtil.indexOutOfBounds(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialBuckleFaceItem.jdField_a_of_type_JavaUtilList, j))) {
      return;
    }
    a(paramList, paramArrayOfFloat, paramFloat, j);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.BuckleFaceFilter
 * JD-Core Version:    0.7.0.1
 */