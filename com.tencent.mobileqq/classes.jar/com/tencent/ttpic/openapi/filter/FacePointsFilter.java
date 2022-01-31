package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.util.List;

public class FacePointsFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(AEModule.getContext(), "DrawPoints.glsl");
  
  public FacePointsFilter()
  {
    super(FRAGMENT_SHADER);
  }
  
  public void apply()
  {
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam("faceDetectImageSize", 0.0F, 0.0F));
    addParam(new UniformParam.Float1sParam("facePoints", new float[0]));
    addParam(new UniformParam.Float1sParam("pointsVis", new float[0]));
    addParam(new UniformParam.Float4fParam("pointColor", 1.0F, 0.0F, 0.0F, 1.0F));
    addParam(new UniformParam.FloatParam("pointSize", 3.0F));
    super.apply();
  }
  
  public float[] toFlatArray(Float[] paramArrayOfFloat)
  {
    int i = 0;
    if (paramArrayOfFloat == null) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i].floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public void updateMultiPoints(List<List<PointF>> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return;
    }
    updatePoints(VideoMaterialUtil.toFlatArray((List)paramList.get(0)));
  }
  
  public void updatePointColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    addParam(new UniformParam.Float4fParam("pointColor", paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public void updatePointSize(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("pointSize", paramFloat));
  }
  
  public void updatePoints(List<PointF> paramList)
  {
    updatePoints(VideoMaterialUtil.toFlatArray(paramList));
  }
  
  public void updatePoints(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null) {
      addParam(new UniformParam.Float1sParam("facePoints", paramArrayOfFloat));
    }
  }
  
  public void updatePointsVis(List<Float[]> paramList, int paramInt)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    while (paramList.size() <= paramInt) {
      return;
    }
    updatePointsVis(toFlatArray((Float[])paramList.get(paramInt)));
  }
  
  public void updatePointsVis(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null) {
      addParam(new UniformParam.Float1sParam("pointsVis", paramArrayOfFloat));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
    addParam(new UniformParam.Float2fParam("faceDetectImageSize", (float)(paramInt1 * paramDouble), (float)(paramInt2 * paramDouble)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FacePointsFilter
 * JD-Core Version:    0.7.0.1
 */