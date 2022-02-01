package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;

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
    addParam(new UniformParam.IntParam("segSlow", 0));
  }
  
  public void apply()
  {
    super.apply();
    setPositions(new float[] { -1.0F, -1.0F, -1.0F, -0.25F, -0.25F, -0.25F, -0.25F, -1.0F });
  }
  
  public Frame updateAndRender(int paramInt, Frame paramFrame)
  {
    addParam(new UniformParam.IntParam("segSlow", paramInt));
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    GlUtil.setBlendMode(false);
    return paramFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.SegmentMonitorFilter
 * JD-Core Version:    0.7.0.1
 */