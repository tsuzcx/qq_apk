package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import java.util.List;

public class BodyPointsFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}";
  private int bodyPointsCount = 59;
  float[] lineVertex;
  private boolean mNoPoints;
  float[] pointsVertex;
  
  public BodyPointsFilter()
  {
    super("attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}", " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n");
    int i = this.bodyPointsCount;
    this.lineVertex = new float[i * 4];
    this.pointsVertex = new float[i * 2];
    this.mNoPoints = true;
  }
  
  private void normalizePoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int j = 0;
      int i = 0;
      while (i < paramList.size() - 1)
      {
        arrayOfFloat = this.lineVertex;
        k = i * 4;
        f2 = ((PointF)paramList.get(i)).x;
        f1 = paramInt1;
        arrayOfFloat[(k + 0)] = (f2 * 2.0F / f1 - 1.0F);
        arrayOfFloat = this.lineVertex;
        f2 = ((PointF)paramList.get(i)).y;
        f3 = paramInt2;
        arrayOfFloat[(k + 1)] = (f2 * 2.0F / f3 - 1.0F);
        arrayOfFloat = this.lineVertex;
        i += 1;
        arrayOfFloat[(k + 2)] = (((PointF)paramList.get(i)).x * 2.0F / f1 - 1.0F);
        this.lineVertex[(k + 3)] = (((PointF)paramList.get(i)).y * 2.0F / f3 - 1.0F);
      }
      i = paramList.size() - 1;
      float[] arrayOfFloat = this.lineVertex;
      int k = i * 4;
      float f2 = ((PointF)paramList.get(i)).x;
      float f1 = paramInt1;
      arrayOfFloat[(k + 0)] = (f2 * 2.0F / f1 - 1.0F);
      arrayOfFloat = this.lineVertex;
      f2 = ((PointF)paramList.get(i)).y;
      float f3 = paramInt2;
      arrayOfFloat[(k + 1)] = (f2 * 2.0F / f3 - 1.0F);
      this.lineVertex[(k + 2)] = (((PointF)paramList.get(0)).x * 2.0F / f1 - 1.0F);
      this.lineVertex[(k + 3)] = (((PointF)paramList.get(0)).y * 2.0F / f3 - 1.0F);
      paramInt1 = j;
      while (paramInt1 < paramList.size())
      {
        arrayOfFloat = this.pointsVertex;
        paramInt2 = paramInt1 * 2;
        arrayOfFloat[paramInt2] = (((PointF)paramList.get(paramInt1)).x * 2.0F / f1 - 1.0F);
        this.pointsVertex[(paramInt2 + 1)] = (((PointF)paramList.get(paramInt1)).y * 2.0F / f3 - 1.0F);
        paramInt1 += 1;
      }
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
    if (!this.mNoPoints)
    {
      GLES20.glLineWidth(4.0F);
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.LINES);
      setCoordNum(this.bodyPointsCount * 2);
      setPositions(this.lineVertex);
      GlUtil.setBlendMode(true);
      OnDrawFrameGLSL();
      renderTexture(paramInt1, paramInt2, paramInt3);
      GlUtil.setBlendMode(false);
      GLES20.glLineWidth(8.0F);
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.POINTS);
      setCoordNum(this.bodyPointsCount);
      setPositions(this.pointsVertex);
      GlUtil.setBlendMode(true);
      OnDrawFrameGLSL();
      renderTexture(paramInt1, paramInt2, paramInt3);
      GlUtil.setBlendMode(false);
    }
  }
  
  public void setBodyPointsSize(int paramInt)
  {
    this.bodyPointsCount = paramInt;
  }
  
  public void updatePoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() == this.bodyPointsCount))
    {
      this.mNoPoints = false;
      normalizePoints(paramList, paramInt1, paramInt2);
      return;
    }
    this.mNoPoints = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BodyPointsFilter
 * JD-Core Version:    0.7.0.1
 */