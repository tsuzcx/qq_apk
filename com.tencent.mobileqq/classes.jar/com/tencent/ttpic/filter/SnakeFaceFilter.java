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
    Object localObject = this.srcPoints;
    if (localObject != null)
    {
      PointF[] arrayOfPointF = this.dstPoints;
      if (arrayOfPointF != null)
      {
        if (localObject.length != arrayOfPointF.length) {
          return;
        }
        int i = 0;
        while (i < paramInt)
        {
          localObject = this.srcPoints[i];
          double d = ((PointF)localObject).x;
          Double.isNaN(d);
          ((PointF)localObject).x = ((float)(d + 0.02D));
          localObject = this.srcPoints[i];
          d = ((PointF)localObject).y;
          Double.isNaN(d);
          ((PointF)localObject).y = ((float)(d + 0.02D));
          localObject = this.dstPoints[i];
          d = ((PointF)localObject).x;
          Double.isNaN(d);
          ((PointF)localObject).x = ((float)(d + 0.02D));
          localObject = this.dstPoints[i];
          d = ((PointF)localObject).y;
          Double.isNaN(d);
          ((PointF)localObject).y = ((float)(d + 0.02D));
          i += 1;
        }
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
    int k = 1;
    int i = 1;
    int j;
    float f1;
    float f2;
    float f3;
    float f4;
    for (;;)
    {
      j = k;
      if (i > 9) {
        break;
      }
      f1 = localPointF1.x;
      f2 = 9 - i;
      f3 = localPointF2.x;
      f4 = i;
      paramArrayOfPointF2[i] = new PointF((f1 * f2 + f3 * f4) / 9.0F, (localPointF1.y * f2 + localPointF2.y * f4) / 9.0F);
      paramArrayOfPointF2[(18 - i)] = new PointF((localPointF3.x * f2 + localPointF2.x * f4) / 9.0F, (localPointF3.y * f2 + localPointF2.y * f4) / 9.0F);
      i += 1;
    }
    while (j < 18)
    {
      f1 = paramArrayOfPointF2[j].x;
      f2 = paramArrayOfPointF1[j].x;
      f3 = paramArrayOfPointF2[j].y;
      f4 = paramArrayOfPointF1[j].y;
      paramArrayOfPointF2[j] = new PointF(paramArrayOfPointF1[j].x + (f1 - f2) * 0.3F, paramArrayOfPointF1[j].y + (f3 - f4) * 0.3F);
      j += 1;
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
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = VideoMaterial.copyList(((PTDetectInfo)paramObject).facePoints);
      int k = 102;
      int j = 0;
      int i;
      if ((paramObject != null) && (paramObject.size() >= 90))
      {
        double d1 = this.height;
        double d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        VideoMaterial.flipYPoints(paramObject, (int)(d1 * d2));
        i = 0;
        Object localObject;
        while (i < 90)
        {
          localObject = this.pSrc;
          if (localObject[i] == null) {
            localObject[i] = new PointF();
          }
          localObject = this.pDst;
          if (localObject[i] == null) {
            localObject[i] = new PointF();
          }
          localObject = this.pSrc[i];
          PointF localPointF = this.pDst[i];
          f1 = ((PointF)paramObject.get(i)).x;
          localPointF.x = f1;
          ((PointF)localObject).x = f1;
          localObject = this.pSrc[i];
          localPointF = this.pDst[i];
          f1 = ((PointF)paramObject.get(i)).y;
          localPointF.y = f1;
          ((PointF)localObject).y = f1;
          i += 1;
        }
        float f1 = this.pSrc[9].x;
        float f2 = this.pSrc[64].x;
        float f3 = this.pSrc[9].y;
        float f4 = this.pSrc[64].y;
        paramObject = this.pDst[9];
        paramObject.x += (f1 - f2) * 0.05F;
        paramObject = this.pDst[9];
        paramObject.y += (f3 - f4) * 0.05F;
        refineSnakeFacePoint(this.pSrc, this.pDst);
        refineSnakeEyePoint(this.pSrc, this.pDst);
        paramObject = this.srcPoints;
        if ((paramObject == null) || (paramObject.length != 102)) {
          this.srcPoints = new PointF[102];
        }
        paramObject = this.dstPoints;
        if (paramObject != null)
        {
          i = j;
          if (paramObject.length == 102) {}
        }
        else
        {
          this.dstPoints = new PointF[102];
          i = j;
        }
        for (;;)
        {
          j = 83;
          if (i >= 83) {
            break;
          }
          this.srcPoints[i] = this.pSrc[i];
          this.dstPoints[i] = this.pDst[i];
          i += 1;
        }
        while (j < 101)
        {
          i = j - 83;
          paramObject = this.srcPoints;
          f1 = this.pSrc[i].x;
          localObject = this.pSrc;
          int m = i + 1;
          paramObject[j] = new PointF((f1 + localObject[m].x) / 2.0F, (this.pSrc[i].y + this.pSrc[m].y) / 2.0F);
          this.dstPoints[j] = new PointF((this.pDst[i].x + this.pDst[m].x) / 2.0F, (this.pDst[i].y + this.pDst[m].y) / 2.0F);
          j += 1;
        }
        paramObject = this.srcPoints;
        d1 = this.width;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        f1 = (float)(d1 * d2);
        d1 = this.height;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        paramObject[101] = new PointF(f1, (float)(d1 * d2));
        paramObject = this.dstPoints;
        d1 = this.width;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        f1 = (float)(d1 * d2);
        d1 = this.height;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        paramObject[101] = new PointF(f1, (float)(d1 * d2));
        i = k;
      }
      else
      {
        this.srcPoints = new PointF[0];
        this.dstPoints = new PointF[0];
        i = 0;
      }
      adjustPoints(i);
      updateGLParams(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.SnakeFaceFilter
 * JD-Core Version:    0.7.0.1
 */