package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.util.VideoFilterUtil;

public class SegmentMonitorFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int segSlow;\n \n void main(void) {\n    if(segSlow == 1){\n        gl_FragColor = vec4(1, 0, 0, 0.5); \n    } else{\n        gl_FragColor = vec4(0, 1, 0, 0.5); \n    }\n}";
  
  public SegmentMonitorFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int segSlow;\n \n void main(void) {\n    if(segSlow == 1){\n        gl_FragColor = vec4(1, 0, 0, 0.5); \n    } else{\n        gl_FragColor = vec4(0, 1, 0, 0.5); \n    }\n}");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new Param.IntParam("segSlow", 0));
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setPositions(new float[] { -1.0F, -1.0F, -1.0F, -0.25F, -0.25F, -0.25F, -0.25F, -1.0F });
  }
  
  public Frame updateAndRender(int paramInt, Frame paramFrame)
  {
    addParam(new Param.IntParam("segSlow", paramInt));
    VideoFilterUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    VideoFilterUtil.setBlendMode(false);
    return paramFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.SegmentMonitorFilter
 * JD-Core Version:    0.7.0.1
 */