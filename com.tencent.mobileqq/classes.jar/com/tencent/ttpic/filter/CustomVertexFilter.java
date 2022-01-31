package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.Param.Float1sParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;

public class CustomVertexFilter
  extends VideoFilterBase
{
  private static final int SIZE_POINT_FACE = 90;
  private static final int XCOORD_NUM = 24;
  private static final int YCOORD_NUM = 32;
  private float[] facePoints = new float['¶'];
  private List<PointF> mFullscreenVertices;
  private List<PointF> mInitTextureCoordinates;
  
  public CustomVertexFilter(String paramString1, String paramString2, StickerItem paramStickerItem)
  {
    super(paramString1, paramString2, paramStickerItem);
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
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLE_STRIP);
    setCoordNum(1561);
  }
  
  public void initParams()
  {
    addParam(new Param.Float1sParam("facePoints", new float[0]));
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    paramList = VideoMaterialUtil.toFlatArray(paramList);
    VideoMaterialUtil.flipYPoints(paramList, (int)(this.height * this.mScreenScale));
    int i = 0;
    if (i < 180)
    {
      if ((paramList == null) || (i >= paramList.length)) {
        this.facePoints[i] = -1.0F;
      }
      for (;;)
      {
        i += 1;
        break;
        this.facePoints[i] = ((float)(paramList[i] / this.mScreenScale));
      }
    }
    if (paramList == null)
    {
      this.facePoints['´'] = -1.0F;
      this.facePoints['µ'] = -1.0F;
    }
    for (;;)
    {
      addParam(new Param.Float1sParam("facePoints", this.facePoints));
      return;
      this.facePoints['´'] = this.width;
      this.facePoints['µ'] = this.height;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.CustomVertexFilter
 * JD-Core Version:    0.7.0.1
 */