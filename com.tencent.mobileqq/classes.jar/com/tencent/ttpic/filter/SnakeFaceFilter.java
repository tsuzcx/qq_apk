package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float2sParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import java.util.List;

public class SnakeFaceFilter
  extends VideoFilterBase
{
  private static final float CHIN_DOWN_SCALE = 0.05F;
  private static final float EYE_MAGNIFY_SCALE = 0.4F;
  private static final float FACE_SLIM_SCALE = 0.3F;
  private static final int SIZE_POINT = 102;
  private static final int XCOORD_NUM = 24;
  private static final int YCOORD_NUM = 32;
  private PointF[] dstPoints;
  private List<PointF> mFullscreenVertices;
  private List<PointF> mInitTextureCoordinates;
  private PointF[] pDst = new PointF[90];
  private PointF[] pSrc = new PointF[90];
  private PointF[] srcPoints;
  
  public SnakeFaceFilter()
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.SNAKE_FACE));
    initCoordinates();
    initParams();
  }
  
  private void adjustPoints(int paramInt)
  {
    if ((this.srcPoints == null) || (this.dstPoints == null) || (this.srcPoints.length != this.dstPoints.length)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramInt)
      {
        PointF localPointF = this.srcPoints[i];
        localPointF.x = ((float)(localPointF.x + 0.02D));
        localPointF = this.srcPoints[i];
        localPointF.y = ((float)(localPointF.y + 0.02D));
        localPointF = this.dstPoints[i];
        localPointF.x = ((float)(localPointF.x + 0.02D));
        localPointF = this.dstPoints[i];
        localPointF.y = ((float)(localPointF.y + 0.02D));
        i += 1;
      }
    }
  }
  
  private void initCoordinates()
  {
    this.mFullscreenVertices = VideoMaterial.genFullScreenVertices(24, 32, -1.0F, 1.0F, -1.0F, 1.0F);
    this.mInitTextureCoordinates = VideoMaterial.genFullScreenVertices(24, 32, 0.0F, 1.0F, 0.0F, 1.0F);
  }
  
  private void refineSnakeEyePoint(PointF[] paramArrayOfPointF1, PointF[] paramArrayOfPointF2)
  {
    PointF localPointF1 = paramArrayOfPointF2[44];
    PointF localPointF2 = paramArrayOfPointF2[54];
    int i = 35;
    while (i <= 42)
    {
      paramArrayOfPointF2[i] = new PointF(paramArrayOfPointF1[i].x + (paramArrayOfPointF1[i].x - localPointF1.x) * 0.4F, paramArrayOfPointF1[i].y + (paramArrayOfPointF1[i].y - localPointF1.y) * 0.4F);
      i += 1;
    }
    i = 45;
    while (i <= 52)
    {
      paramArrayOfPointF2[i] = new PointF(paramArrayOfPointF1[i].x + (paramArrayOfPointF1[i].x - localPointF2.x) * 0.4F, paramArrayOfPointF1[i].y + (paramArrayOfPointF1[i].y - localPointF2.y) * 0.4F);
      i += 1;
    }
  }
  
  private void refineSnakeFacePoint(PointF[] paramArrayOfPointF1, PointF[] paramArrayOfPointF2)
  {
    PointF localPointF1 = paramArrayOfPointF2[0];
    PointF localPointF2 = paramArrayOfPointF2[9];
    PointF localPointF3 = paramArrayOfPointF2[18];
    int i = 1;
    while (i <= 9)
    {
      paramArrayOfPointF2[i] = new PointF((localPointF1.x * (9 - i) + localPointF2.x * i) / 9.0F, (localPointF1.y * (9 - i) + localPointF2.y * i) / 9.0F);
      paramArrayOfPointF2[(18 - i)] = new PointF((localPointF3.x * (9 - i) + localPointF2.x * i) / 9.0F, (localPointF3.y * (9 - i) + localPointF2.y * i) / 9.0F);
      i += 1;
    }
    i = 1;
    while (i < 18)
    {
      float f1 = paramArrayOfPointF2[i].x;
      float f2 = paramArrayOfPointF1[i].x;
      float f3 = paramArrayOfPointF2[i].y;
      float f4 = paramArrayOfPointF1[i].y;
      paramArrayOfPointF2[i] = new PointF((f1 - f2) * 0.3F + paramArrayOfPointF1[i].x, (f3 - f4) * 0.3F + paramArrayOfPointF1[i].y);
      i += 1;
    }
  }
  
  private void updateGLParams(int paramInt)
  {
    addParam(new UniformParam.IntParam(SnakeFaceFilter.SHADER_FIELD.NPOINT.name, paramInt));
    addParam(new UniformParam.Float2sParam(SnakeFaceFilter.SHADER_FIELD.FSRC.name, VideoMaterial.toFlatArray(this.srcPoints)));
    addParam(new UniformParam.Float2sParam(SnakeFaceFilter.SHADER_FIELD.FDST.name, VideoMaterial.toFlatArray(this.dstPoints)));
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setPositions(VideoMaterial.toFlatArray((PointF[])this.mFullscreenVertices.toArray(new PointF[0])));
    setTexCords(VideoMaterial.toFlatArray((PointF[])this.mInitTextureCoordinates.toArray(new PointF[0])));
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
    setCoordNum(1561);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam(SnakeFaceFilter.SHADER_FIELD.NPOINT.name, 0));
    addParam(new UniformParam.Float2sParam(SnakeFaceFilter.SHADER_FIELD.FSRC.name, new float[0]));
    addParam(new UniformParam.Float2sParam(SnakeFaceFilter.SHADER_FIELD.FDST.name, new float[0]));
  }
  
  public void updatePreview(Object paramObject)
  {
    int j = 0;
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = VideoMaterial.copyList(((PTDetectInfo)paramObject).facePoints);
      if ((paramObject != null) && (paramObject.size() >= 90)) {
        break label68;
      }
      this.srcPoints = new PointF[0];
      this.dstPoints = new PointF[0];
    }
    for (int i = 0;; i = 102)
    {
      adjustPoints(i);
      updateGLParams(i);
      return;
      label68:
      VideoMaterial.flipYPoints(paramObject, (int)(this.height * this.mFaceDetScale));
      i = 0;
      while (i < 90)
      {
        if (this.pSrc[i] == null) {
          this.pSrc[i] = new PointF();
        }
        if (this.pDst[i] == null) {
          this.pDst[i] = new PointF();
        }
        PointF localPointF1 = this.pSrc[i];
        PointF localPointF2 = this.pDst[i];
        f1 = ((PointF)paramObject.get(i)).x;
        localPointF2.x = f1;
        localPointF1.x = f1;
        localPointF1 = this.pSrc[i];
        localPointF2 = this.pDst[i];
        f1 = ((PointF)paramObject.get(i)).y;
        localPointF2.y = f1;
        localPointF1.y = f1;
        i += 1;
      }
      float f1 = this.pSrc[9].x;
      float f2 = this.pSrc[64].x;
      float f3 = this.pSrc[9].y;
      float f4 = this.pSrc[64].y;
      paramObject = this.pDst[9];
      paramObject.x = ((f1 - f2) * 0.05F + paramObject.x);
      paramObject = this.pDst[9];
      paramObject.y = ((f3 - f4) * 0.05F + paramObject.y);
      refineSnakeFacePoint(this.pSrc, this.pDst);
      refineSnakeEyePoint(this.pSrc, this.pDst);
      if ((this.srcPoints == null) || (this.srcPoints.length != 102)) {
        this.srcPoints = new PointF[102];
      }
      if (this.dstPoints != null)
      {
        i = j;
        if (this.dstPoints.length == 102) {}
      }
      else
      {
        this.dstPoints = new PointF[102];
        i = j;
      }
      while (i < 83)
      {
        this.srcPoints[i] = this.pSrc[i];
        this.dstPoints[i] = this.pDst[i];
        i += 1;
      }
      i = 83;
      while (i < 101)
      {
        j = i - 83;
        this.srcPoints[i] = new PointF((this.pSrc[j].x + this.pSrc[(j + 1)].x) / 2.0F, (this.pSrc[j].y + this.pSrc[(j + 1)].y) / 2.0F);
        paramObject = this.dstPoints;
        f1 = (this.pDst[j].x + this.pDst[(j + 1)].x) / 2.0F;
        f2 = this.pDst[j].y;
        paramObject[i] = new PointF(f1, (this.pDst[(j + 1)].y + f2) / 2.0F);
        i += 1;
      }
      this.srcPoints[101] = new PointF((float)(this.width * this.mFaceDetScale), (float)(this.height * this.mFaceDetScale));
      this.dstPoints[101] = new PointF((float)(this.width * this.mFaceDetScale), (float)(this.height * this.mFaceDetScale));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.SnakeFaceFilter
 * JD-Core Version:    0.7.0.1
 */