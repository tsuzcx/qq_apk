package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;

public class FaceLineFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceLineFragmentShader.dat");
  private static final String TAG = FaceLineFilter.class.getSimpleName();
  public static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceLineVertexShader.dat");
  private float[] faceVertices = new float[2760];
  
  public FaceLineFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER, null);
    initParams();
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setDrawMode(VideoFilterUtil.DRAW_MODE.LINES);
  }
  
  public void initAttribParams()
  {
    setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void initParams() {}
  
  public void render(int paramInt1, int paramInt2, int paramInt3)
  {
    VideoFilterUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    VideoFilterUtil.setBlendMode(false);
  }
  
  public void updatePoints(List<List<PointF>> paramList)
  {
    if (paramList.size() == 0)
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    setPositions(FaceOffUtil.initFaceLinePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList((List)paramList.get(0))), (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.faceVertices));
    setCoordNum(1380);
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceLineFilter
 * JD-Core Version:    0.7.0.1
 */