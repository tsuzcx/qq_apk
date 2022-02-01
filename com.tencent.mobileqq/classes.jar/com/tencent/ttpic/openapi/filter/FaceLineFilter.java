package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.List;

public class FaceLineFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n uniform lowp float blurAlpha;\n \n void main(void) {\n     gl_FragColor = vec4(0.0+blurAlpha, 1.0, 0.0, 1.0);\n }";
  private static final String TAG = "FaceLineFilter";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}\n";
  private float blurAlpha = 0.5F;
  private float[] faceVertices = new float[2760];
  private float[] irisVertices = new float[96];
  
  public FaceLineFilter()
  {
    super("attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}\n", " precision highp float;\n uniform lowp float blurAlpha;\n \n void main(void) {\n     gl_FragColor = vec4(0.0+blurAlpha, 1.0, 0.0, 1.0);\n }");
    initParams();
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.LINES);
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("blurAlpha", this.blurAlpha));
  }
  
  public void render(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glLineWidth(3.0F);
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(false);
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    this.blurAlpha = paramFloat;
    addParam(new UniformParam.FloatParam("blurAlpha", paramFloat));
  }
  
  public void updateIrisPoints(List<PointF> paramList)
  {
    paramList = VideoMaterial.copyList(paramList);
    double d1 = this.width;
    double d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int i = (int)(d1 * d2);
    d1 = this.height;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    setPositions(FaceOffUtil.initIrisLinePositions(paramList, i, (int)(d1 * d2), this.irisVertices));
    setCoordNum(48);
  }
  
  public void updatePoints(List<List<PointF>> paramList, double paramDouble, int paramInt)
  {
    if (paramList.size() == 0)
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    paramList = VideoMaterial.copyList((List)paramList.get(paramInt));
    FaceOffUtil.getFullCoords(paramList, 2.0F);
    double d = this.width;
    Double.isNaN(d);
    paramInt = (int)(d * paramDouble);
    d = this.height;
    Double.isNaN(d);
    setPositions(FaceOffUtil.initFaceLinePositions(paramList, paramInt, (int)(d * paramDouble), this.faceVertices));
    setCoordNum(1380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FaceLineFilter
 * JD-Core Version:    0.7.0.1
 */