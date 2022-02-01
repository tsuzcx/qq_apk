package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.Float4sParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.OvalDistortionItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.TransformUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class OvalDistortionFilter
  extends VideoFilterBase
{
  private static final int DISTORTION_LIST_MAX_SIZE = 20;
  private static final int XCOORD_NUM = 64;
  private static final int YCOORD_NUM = 64;
  private static List<PointF> mFullscreenVerticesPortrait = VideoMaterial.genFullScreenVertices(66, 66, -1.03125F, 1.03125F, -1.03125F, 1.03125F);
  private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterial.genFullScreenVertices(66, 66, -0.015625F, 1.015625F, -0.015625F, 1.015625F);
  private float cropCenterX = 0.0F;
  private float cropCenterY = 0.0F;
  private float cropEdge = 1.0F;
  private float[] flatMesh = new float['ð'];
  private List<OvalDistortionItem> items;
  private VideoFilterBase mCopyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private OvalDistortionFilter.OvalMeshDistortionType[] meshs = new OvalDistortionFilter.OvalMeshDistortionType[20];
  private List<StickerItem> stickerItems;
  
  public OvalDistortionFilter(List<OvalDistortionItem> paramList, List<StickerItem> paramList1)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.OVALDISTORTION));
    this.items = paramList;
    this.stickerItems = paramList1;
    setRenderMode(1);
    initParams();
  }
  
  private void adjustFacePoints(List<PointF> paramList)
  {
    int k = paramList.size();
    int j = 0;
    float f7 = 0.0F;
    int i = 0;
    float f3 = 3.4028235E+38F;
    float f2 = 0.0F;
    float f9;
    for (float f1 = 3.4028235E+38F; i < 83; f1 = f9)
    {
      float f8 = ((PointF)paramList.get(i)).x;
      f4 = ((PointF)paramList.get(i)).y;
      float f5 = f7;
      if (f8 > f7) {
        f5 = f8;
      }
      float f6 = f3;
      if (f8 < f3) {
        f6 = f8;
      }
      f8 = f2;
      if (f4 > f2) {
        f8 = f4;
      }
      f9 = f1;
      if (f4 < f1) {
        f9 = f4;
      }
      i += 1;
      f7 = f5;
      f3 = f6;
      f2 = f8;
    }
    float f4 = Math.max(f7 - f3, f2 - f1) * 1.25F;
    this.cropCenterX = ((f7 + f3) / 2.0F);
    this.cropCenterY = ((f2 + f1) / 2.0F);
    f1 = this.cropCenterX;
    f2 = this.cropCenterY;
    i = j;
    while (i < k)
    {
      PointF localPointF = (PointF)paramList.get(i);
      localPointF.x += f4 - f1;
      localPointF = (PointF)paramList.get(i);
      localPointF.y += f4 - f2;
      i += 1;
    }
    this.cropEdge = (f4 * 2.0F);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.mCopyFilter.apply();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    double d1 = this.cropCenterX - this.cropEdge / 2.0F;
    double d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int j = (int)(d1 / d2);
    d1 = this.cropCenterY - this.cropEdge / 2.0F;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int k = (int)(d1 / d2);
    d1 = this.cropCenterX + this.cropEdge / 2.0F;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int m = (int)(d1 / d2);
    d1 = this.cropCenterY + this.cropEdge / 2.0F;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int n = (int)(d1 / d2);
    float f2 = paramFrame.width;
    float f3 = paramFrame.height;
    float[] arrayOfFloat = new float[8];
    float f4 = j / f2;
    int i = 0;
    arrayOfFloat[0] = f4;
    float f1 = k / f3;
    arrayOfFloat[1] = f1;
    arrayOfFloat[2] = f4;
    f3 = n / f3;
    arrayOfFloat[3] = f3;
    f2 = m / f2;
    arrayOfFloat[4] = f2;
    arrayOfFloat[5] = f3;
    arrayOfFloat[6] = f2;
    arrayOfFloat[7] = f1;
    this.mCopyFilter.setPositions(new float[] { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
    this.mCopyFilter.setTexCords(arrayOfFloat);
    Frame localFrame = super.RenderProcess(this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), m - j, n - k));
    while (i < 8)
    {
      arrayOfFloat[i] = (arrayOfFloat[i] * 2.0F - 1.0F);
      i += 1;
    }
    this.mCopyFilter.setPositions(arrayOfFloat);
    this.mCopyFilter.setTexCords(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F });
    this.mCopyFilter.RenderProcess(localFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
    localFrame.unlock();
    return paramFrame;
  }
  
  public void clearGLSLSelf()
  {
    this.mCopyFilter.clear();
    super.clearGLSLSelf();
  }
  
  public void initAttribParams()
  {
    setPositions(VideoMaterial.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterial.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(8779);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.Float1sParam("item", this.flatMesh));
    int i = 0;
    while (i < 20)
    {
      this.meshs[i] = new OvalDistortionFilter.OvalMeshDistortionType(this);
      i += 1;
    }
  }
  
  public void updateParams(List<PointF> paramList, Set<Integer> paramSet)
  {
    Arrays.fill(this.flatMesh, -1.0F);
    List localList = VideoMaterial.copyList(paramList);
    if ((localList != null) && (localList.size() >= 90) && (!CollectionUtils.isEmpty(this.items)) && (VideoFilterUtil.actionTriggered(paramList, this.stickerItems, paramSet)))
    {
      adjustFacePoints(localList);
      localList = TransformUtil.getFullPoints(localList);
      int i = 0;
      int k;
      while (i < this.items.size())
      {
        OvalDistortionItem localOvalDistortionItem = (OvalDistortionItem)this.items.get(i);
        this.meshs[i].type = localOvalDistortionItem.distortionType;
        this.meshs[i].strength = localOvalDistortionItem.strength;
        this.meshs[i].innerCirc = localOvalDistortionItem.innerCircle;
        this.meshs[i].outerCirc = localOvalDistortionItem.outerCircle;
        j = 0;
        k = 0;
        float f2 = 0.0F;
        float f1 = 0.0F;
        while (j < 4)
        {
          if (localOvalDistortionItem.center[j] != -1)
          {
            f2 += ((PointF)localList.get(localOvalDistortionItem.center[j])).x;
            f1 += ((PointF)localList.get(localOvalDistortionItem.center[j])).y;
            k += 1;
          }
          j += 1;
        }
        float f3;
        if (k > 0)
        {
          paramList = this.meshs[i].center;
          f3 = k;
          paramList[0] = (f2 / f3);
          this.meshs[i].center[1] = (f1 / f3);
        }
        else
        {
          this.meshs[i].center[0] = 0.0F;
          this.meshs[i].center[1] = 0.0F;
        }
        j = 0;
        k = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        while (j < 4)
        {
          if (localOvalDistortionItem.centerOffsetStart[j] != -1)
          {
            f2 += ((PointF)localList.get(localOvalDistortionItem.centerOffsetStart[j])).x;
            f1 += ((PointF)localList.get(localOvalDistortionItem.centerOffsetStart[j])).y;
            k += 1;
          }
          j += 1;
        }
        if (k > 0)
        {
          f3 = k;
          paramList = new PointF(f2 / f3, f1 / f3);
        }
        else
        {
          paramList = new PointF(0.0F, 0.0F);
        }
        j = 0;
        k = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        while (j < 4)
        {
          if (localOvalDistortionItem.centerOffsetEnd[j] != -1)
          {
            f2 += ((PointF)localList.get(localOvalDistortionItem.centerOffsetEnd[j])).x;
            f1 += ((PointF)localList.get(localOvalDistortionItem.centerOffsetEnd[j])).y;
            k += 1;
          }
          j += 1;
        }
        if (k > 0)
        {
          f3 = k;
          paramSet = new PointF(f2 / f3, f1 / f3);
        }
        else
        {
          paramSet = new PointF(0.0F, 0.0F);
        }
        float[] arrayOfFloat = this.meshs[i].center;
        arrayOfFloat[0] += (paramSet.x - paramList.x) * localOvalDistortionItem.centerOffsetMultiplier;
        arrayOfFloat = this.meshs[i].center;
        arrayOfFloat[1] += (paramSet.y - paramList.y) * localOvalDistortionItem.centerOffsetMultiplier;
        j = 0;
        k = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        while (j < 4)
        {
          if (localOvalDistortionItem.lengthStart[j] != -1)
          {
            f2 += ((PointF)localList.get(localOvalDistortionItem.lengthStart[j])).x;
            f1 += ((PointF)localList.get(localOvalDistortionItem.lengthStart[j])).y;
            k += 1;
          }
          j += 1;
        }
        if (k > 0)
        {
          f3 = k;
          paramList = new PointF(f2 / f3, f1 / f3);
        }
        else
        {
          paramList = new PointF(0.0F, 0.0F);
        }
        j = 0;
        k = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        while (j < 4)
        {
          if (localOvalDistortionItem.lengthEnd[j] != -1)
          {
            f2 += ((PointF)localList.get(localOvalDistortionItem.lengthEnd[j])).x;
            f1 += ((PointF)localList.get(localOvalDistortionItem.lengthEnd[j])).y;
            k += 1;
          }
          j += 1;
        }
        if (k > 0)
        {
          f3 = k;
          paramSet = new PointF(f2 / f3, f1 / f3);
        }
        else
        {
          paramSet = new PointF(0.0F, 0.0F);
        }
        this.meshs[i].length = (AlgoUtils.getDistance(paramList, paramSet) * localOvalDistortionItem.lengthMultiplier);
        j = 0;
        k = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        while (j < 4)
        {
          if (localOvalDistortionItem.widthStart[j] != -1)
          {
            f2 += ((PointF)localList.get(localOvalDistortionItem.widthStart[j])).x;
            f1 += ((PointF)localList.get(localOvalDistortionItem.widthStart[j])).y;
            k += 1;
          }
          j += 1;
        }
        if (k > 0)
        {
          f3 = k;
          paramList = new PointF(f2 / f3, f1 / f3);
        }
        else
        {
          paramList = new PointF(0.0F, 0.0F);
        }
        j = 0;
        k = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        while (j < 4)
        {
          if (localOvalDistortionItem.widthEnd[j] != -1)
          {
            f2 += ((PointF)localList.get(localOvalDistortionItem.widthEnd[j])).x;
            f1 += ((PointF)localList.get(localOvalDistortionItem.widthEnd[j])).y;
            k += 1;
          }
          j += 1;
        }
        if (k > 0)
        {
          f3 = k;
          paramSet = new PointF(f2 / f3, f1 / f3);
        }
        else
        {
          paramSet = new PointF(0.0F, 0.0F);
        }
        this.meshs[i].width = (AlgoUtils.getDistance(paramList, paramSet) * localOvalDistortionItem.widthMultiplier);
        j = 0;
        k = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        while (j < 4)
        {
          if (localOvalDistortionItem.angleStart[j] != -1)
          {
            f2 += ((PointF)localList.get(localOvalDistortionItem.angleStart[j])).x;
            f1 += ((PointF)localList.get(localOvalDistortionItem.angleStart[j])).y;
            k += 1;
          }
          j += 1;
        }
        if (k > 0)
        {
          f3 = k;
          paramList = new PointF(f2 / f3, f1 / f3);
        }
        else
        {
          paramList = new PointF(0.0F, 0.0F);
        }
        j = 0;
        k = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        while (j < 4)
        {
          if (localOvalDistortionItem.angleEnd[j] != -1)
          {
            f2 += ((PointF)localList.get(localOvalDistortionItem.angleEnd[j])).x;
            f1 += ((PointF)localList.get(localOvalDistortionItem.angleEnd[j])).y;
            k += 1;
          }
          j += 1;
        }
        if (k > 0)
        {
          f3 = k;
          paramSet = new PointF(f2 / f3, f1 / f3);
        }
        else
        {
          paramSet = new PointF(0.0F, 0.0F);
        }
        this.meshs[i].angle = ((float)Math.atan2(paramSet.y - paramList.y, paramSet.x - paramList.x));
        if (paramSet.x - paramList.x < 0.0F)
        {
          paramList = this.meshs[i];
          double d = paramList.angle;
          Double.isNaN(d);
          paramList.angle = ((float)(d + 3.141592653589793D));
        }
        if ((this.meshs[i].type != 1) && (this.meshs[i].type != 2))
        {
          j = 0;
          k = 0;
          f2 = 0.0F;
          f1 = 0.0F;
          while (j < 4)
          {
            if (localOvalDistortionItem.pushStart[j] != -1)
            {
              f2 += ((PointF)localList.get(localOvalDistortionItem.pushStart[j])).x;
              f1 += ((PointF)localList.get(localOvalDistortionItem.pushStart[j])).y;
              k += 1;
            }
            j += 1;
          }
          if (k > 0)
          {
            f3 = k;
            paramList = new PointF(f2 / f3, f1 / f3);
          }
          else
          {
            paramList = new PointF(0.0F, 0.0F);
          }
          j = 0;
          k = 0;
          f2 = 0.0F;
          f1 = 0.0F;
          while (j < 4)
          {
            if (localOvalDistortionItem.pushEnd[j] != -1)
            {
              f2 += ((PointF)localList.get(localOvalDistortionItem.pushEnd[j])).x;
              f1 += ((PointF)localList.get(localOvalDistortionItem.pushEnd[j])).y;
              k += 1;
            }
            j += 1;
          }
          if (k > 0)
          {
            f3 = k;
            paramSet = new PointF(f2 / f3, f1 / f3);
          }
          else
          {
            paramSet = new PointF(0.0F, 0.0F);
          }
          this.meshs[i].pushDx = (paramSet.x - paramList.x);
          this.meshs[i].pushDy = (paramSet.y - paramList.y);
        }
        else
        {
          this.meshs[i].scaleArea = localOvalDistortionItem.scaleArea;
        }
        i += 1;
      }
      i = this.items.size();
      while (i < 20)
      {
        this.meshs[i].type = 0;
        i += 1;
      }
      i = 0;
      for (int j = 0; i < this.items.size(); j = k + 1)
      {
        paramList = this.flatMesh;
        k = j + 1;
        paramList[j] = this.meshs[i].type;
        paramList = this.flatMesh;
        j = k + 1;
        paramList[k] = this.meshs[i].strength;
        paramList = this.flatMesh;
        k = j + 1;
        paramList[j] = (this.meshs[i].center[0] / this.cropEdge * 2.0F - 1.0F);
        paramList = this.flatMesh;
        j = k + 1;
        paramList[k] = (this.meshs[i].center[1] / this.cropEdge * 2.0F - 1.0F);
        paramList = this.flatMesh;
        k = j + 1;
        paramList[j] = (this.meshs[i].length / this.cropEdge);
        paramList = this.flatMesh;
        j = k + 1;
        paramList[k] = (this.meshs[i].width / this.cropEdge);
        paramList = this.flatMesh;
        k = j + 1;
        paramList[j] = this.meshs[i].angle;
        paramList = this.flatMesh;
        j = k + 1;
        paramList[k] = this.meshs[i].innerCirc;
        paramList = this.flatMesh;
        k = j + 1;
        paramList[j] = this.meshs[i].outerCirc;
        paramList = this.flatMesh;
        j = k + 1;
        paramList[k] = this.meshs[i].scaleArea;
        paramList = this.flatMesh;
        k = j + 1;
        paramList[j] = (this.meshs[i].pushDx / this.cropEdge * 2.0F);
        this.flatMesh[k] = (this.meshs[i].pushDy / this.cropEdge * 2.0F);
        i += 1;
      }
      addParam(new UniformParam.Float1sParam("item", this.flatMesh));
      return;
    }
    addParam(new UniformParam.Float4sParam("item", this.flatMesh));
  }
  
  public void updatePreview(Object paramObject)
  {
    if (!(paramObject instanceof PTDetectInfo)) {
      return;
    }
    paramObject = (PTDetectInfo)paramObject;
    updateParams(paramObject.facePoints, paramObject.triggeredExpression);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.OvalDistortionFilter
 * JD-Core Version:    0.7.0.1
 */