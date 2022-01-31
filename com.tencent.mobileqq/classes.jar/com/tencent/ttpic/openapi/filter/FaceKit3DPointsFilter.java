package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;

public class FaceKit3DPointsFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}";
  private int POINTS_COUNT = 6445;
  float[] pointsVertex = new float[this.POINTS_COUNT * 2];
  
  public FaceKit3DPointsFilter()
  {
    super("attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}", " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n");
  }
  
  private void normalizePoints(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramArrayOfFloat.length / 3)
    {
      this.pointsVertex[(i * 2)] = (paramArrayOfFloat[(i * 3)] * 2.0F / paramInt1 - 1.0F);
      this.pointsVertex[(i * 2 + 1)] = (1.0F - paramArrayOfFloat[(i * 3 + 1)] * 2.0F / paramInt2);
      i += 1;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void initParams() {}
  
  public void render(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glLineWidth(4.0F);
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.POINTS);
    setCoordNum(this.POINTS_COUNT);
    setPositions(this.pointsVertex);
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(false);
  }
  
  public void updatePoints(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    normalizePoints(paramArrayOfFloat, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FaceKit3DPointsFilter
 * JD-Core Version:    0.7.0.1
 */