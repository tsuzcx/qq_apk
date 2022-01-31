package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.List;
import java.util.Map;

public class VideoFlipFilter
  extends VideoFilterBase
{
  public static String FRAGMENT_SHADER = null;
  public static String VERTEX_SHADER = null;
  
  public VideoFlipFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2, null);
  }
  
  public static VideoFlipFilter createVideoFlipFilter()
  {
    if (TextUtils.isEmpty(VERTEX_SHADER)) {
      VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FlipAndRotateVertexShader.dat");
    }
    if (TextUtils.isEmpty(FRAGMENT_SHADER)) {
      FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FlipAndRotateFragmentShader.dat");
    }
    return new VideoFlipFilter(VERTEX_SHADER, FRAGMENT_SHADER);
  }
  
  public void ApplyGLSLFilter()
  {
    initParams();
    super.ApplyGLSLFilter();
    setTexCords(VideoFilterUtil.ORIGIN_TEX_COORDS);
    setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void initParams()
  {
    addParam(new Param.IntParam("texNeedTransform", -1));
    addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new Param.FloatParam("texRotate", 0.0F));
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFlipFilter
 * JD-Core Version:    0.7.0.1
 */