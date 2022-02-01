package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;

public class FrameAlphaFilter
  extends VideoFilterBase
{
  public FrameAlphaFilter()
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.ALPHA));
    initParams();
  }
  
  public void initParams()
  {
    updateParams(1.0F, 0.0F, 1.0F, new PointF(), new PointF(), new PointF(1.0F, 1.0F));
  }
  
  public void updateAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
  
  public void updateParams(float paramFloat1, float paramFloat2, float paramFloat3, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    addParam(new UniformParam.FloatParam("texScale", paramFloat1));
    addParam(new UniformParam.FloatParam("texRotate", paramFloat2));
    addParam(new UniformParam.Float2fParam("translate", paramPointF2.x, paramPointF2.y));
    addParam(new UniformParam.Float2fParam("anchor", paramPointF1.x, paramPointF1.y));
    addParam(new UniformParam.FloatParam("alpha", paramFloat3));
    addParam(new UniformParam.Float2fParam("canvasSize", paramPointF3.x, paramPointF3.y));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FrameAlphaFilter
 * JD-Core Version:    0.7.0.1
 */