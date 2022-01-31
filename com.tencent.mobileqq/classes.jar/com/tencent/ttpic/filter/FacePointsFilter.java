package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.Float1sParam;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class FacePointsFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "DrawPoints.glsl");
  private int heigth;
  private double mFaceDetScale = 1.0D;
  private int width;
  
  public FacePointsFilter(String paramString)
  {
    super(paramString);
  }
  
  public static FacePointsFilter createFaceFilter()
  {
    return new FacePointsFilter(FRAGMENT_SHADER);
  }
  
  private void updatePoints(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null) {
      addParam(new Param.Float1sParam("facePoints", paramArrayOfFloat));
    }
  }
  
  public void ApplyGLSLFilter()
  {
    addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new Param.Float2fParam("faceDetectImageSize", 0.0F, 0.0F));
    addParam(new Param.Float1sParam("facePoints", new float[0]));
    super.ApplyGLSLFilter();
  }
  
  public void updatePoints(List<List<PointF>> paramList)
  {
    if (paramList.size() >= 1) {
      updatePoints(VideoMaterialUtil.toFlatArray((List)paramList.get(0)));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.heigth = paramInt2;
    this.mFaceDetScale = paramDouble;
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
    addParam(new Param.Float2fParam("faceDetectImageSize", (float)(paramInt1 * this.mFaceDetScale), (float)(paramInt2 * this.mFaceDetScale)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FacePointsFilter
 * JD-Core Version:    0.7.0.1
 */