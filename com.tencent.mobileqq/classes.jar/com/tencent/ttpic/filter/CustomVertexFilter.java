package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.util.List;

public class CustomVertexFilter
  extends VideoFilterBase
{
  private static final int SIZE_POINT_FACE = 90;
  private static final int XCOORD_NUM = 24;
  private static final int YCOORD_NUM = 32;
  private float[] facePoints = new float['¶'];
  private List<PointF> mFullscreenVertices;
  private List<PointF> mInitTextureCoordinates;
  
  public CustomVertexFilter(String paramString1, String paramString2)
  {
    super(BaseFilter.nativeDecrypt(paramString1), BaseFilter.nativeDecrypt(paramString2));
    initCoordinates();
    initParams();
  }
  
  private void initCoordinates()
  {
    this.mFullscreenVertices = VideoMaterialUtil.genFullScreenVertices(24, 32, -1.0F, 1.0F, -1.0F, 1.0F);
    this.mInitTextureCoordinates = VideoMaterialUtil.genFullScreenVertices(24, 32, 0.0F, 1.0F, 0.0F, 1.0F);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])this.mFullscreenVertices.toArray(new PointF[0])));
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])this.mInitTextureCoordinates.toArray(new PointF[0])));
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
    setCoordNum(1561);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.Float1sParam("facePoints", new float[0]));
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = VideoMaterialUtil.toFlatArray(((PTDetectInfo)paramObject).facePoints);
      VideoMaterialUtil.flipYPoints(paramObject, (int)(this.height * this.mFaceDetScale));
      int i = 0;
      if (i < 180)
      {
        if ((paramObject == null) || (i >= paramObject.length)) {
          this.facePoints[i] = -1.0F;
        }
        for (;;)
        {
          i += 1;
          break;
          this.facePoints[i] = ((float)(paramObject[i] / this.mFaceDetScale));
        }
      }
      if (paramObject != null) {
        break label129;
      }
      this.facePoints['´'] = -1.0F;
      this.facePoints['µ'] = -1.0F;
    }
    for (;;)
    {
      addParam(new UniformParam.Float1sParam("facePoints", this.facePoints));
      return;
      label129:
      this.facePoints['´'] = this.width;
      this.facePoints['µ'] = this.height;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.CustomVertexFilter
 * JD-Core Version:    0.7.0.1
 */