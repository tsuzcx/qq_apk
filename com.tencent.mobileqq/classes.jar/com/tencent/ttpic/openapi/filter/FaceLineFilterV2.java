package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.List;

public class FaceLineFilterV2
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n uniform lowp float blurAlpha;\n \n void main(void) {\n     gl_FragColor = vec4(0.0+blurAlpha, 1.0, 0.0, 1.0);\n }";
  private static final String TAG = FaceLineFilterV2.class.getSimpleName();
  public static final String VERTEX_SHADER = "attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}\n";
  private float blurAlpha = 0.5F;
  private float[] faceVertices = new float[FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 12];
  private float[] irisVertices = new float[96];
  
  public FaceLineFilterV2()
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
    setPositions(FaceOffUtil.initIrisLinePositions(VideoMaterialUtil.copyList(paramList), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.irisVertices));
    setCoordNum(48);
  }
  
  public void updatePoints(List<List<PointF>> paramList, List<float[]> paramList1, int paramInt1, int paramInt2)
  {
    if (paramList.size() == 0)
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    if ((paramInt2 == 90) || (paramInt2 == 270)) {}
    for (float f = -((float[])paramList1.get(paramInt1))[0];; f = ((float[])paramList1.get(paramInt1))[1])
    {
      paramList = VideoMaterialUtil.copyList((List)paramList.get(paramInt1));
      FaceOffUtil.getFullCoords_v2(paramList, 2.0F, -f, false);
      setPositions(FaceOffUtil.initFaceLinePositions_v2(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
      setCoordNum(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 6);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FaceLineFilterV2
 * JD-Core Version:    0.7.0.1
 */