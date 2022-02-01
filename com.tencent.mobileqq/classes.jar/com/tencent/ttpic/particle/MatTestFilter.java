package com.tencent.ttpic.particle;

import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.util.MatrixUtil;

public class MatTestFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n\n void main() {\n\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n\n }";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n uniform mat4 mvpMat;\n void main() {\n     gl_Position = mvpMat * position;\n }";
  
  public MatTestFilter()
  {
    super("attribute vec4 position;\n uniform mat4 mvpMat;\n void main() {\n     gl_Position = mvpMat * position;\n }", "precision highp float;\n\n void main() {\n\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n\n }");
    initParams();
  }
  
  public void initParams()
  {
    this.mFilterProjMat = MatrixUtil.getDefaultMVPMatrix();
    addParam(new UniformParam.Mat4Param("mvpMat", this.mFilterProjMat));
  }
  
  public Frame render(Frame paramFrame)
  {
    return super.render(paramFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.MatTestFilter
 * JD-Core Version:    0.7.0.1
 */