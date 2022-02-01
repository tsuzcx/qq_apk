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
    float f1 = 3.4028235E+38F;
    float f4 = 0.0F;
    int j = paramList.size();
    int i = 0;
    float f2 = 3.4028235E+38F;
    float f6 = 0.0F;
    float f5;
    float f3;
    if (i < 83)
    {
      float f7 = ((PointF)paramList.get(i)).x;
      f5 = ((PointF)paramList.get(i)).y;
      f3 = f6;
      if (f7 > f6) {
        f3 = f7;
      }
      if (f7 >= f2) {
        break label264;
      }
      f2 = f7;
    }
    label264:
    for (;;)
    {
      f6 = f4;
      if (f5 > f4) {
        f6 = f5;
      }
      if (f5 < f1) {
        f1 = f5;
      }
      for (;;)
      {
        i += 1;
        f4 = f6;
        f6 = f3;
        break;
        f3 = 1.25F * Math.max(f6 - f2, f4 - f1);
        this.cropCenterX = ((f6 + f2) / 2.0F);
        this.cropCenterY = ((f4 + f1) / 2.0F);
        f1 = this.cropCenterX;
        f2 = this.cropCenterY;
        i = 0;
        while (i < j)
        {
          PointF localPointF = (PointF)paramList.get(i);
          localPointF.x += f3 - f1;
          localPointF = (PointF)paramList.get(i);
          localPointF.y += f3 - f2;
          i += 1;
        }
        this.cropEdge = (f3 * 2.0F);
        return;
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.mCopyFilter.apply();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    int i = 0;
    int j = (int)((this.cropCenterX - this.cropEdge / 2.0F) / this.mFaceDetScale);
    int k = (int)((this.cropCenterY - this.cropEdge / 2.0F) / this.mFaceDetScale);
    int m = (int)((this.cropCenterX + this.cropEdge / 2.0F) / this.mFaceDetScale);
    int n = (int)((this.cropCenterY + this.cropEdge / 2.0F) / this.mFaceDetScale);
    float f1 = paramFrame.width;
    float f2 = paramFrame.height;
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (j / f1);
    arrayOfFloat[1] = (k / f2);
    arrayOfFloat[2] = (j / f1);
    arrayOfFloat[3] = (n / f2);
    arrayOfFloat[4] = (m / f1);
    arrayOfFloat[5] = (n / f2);
    arrayOfFloat[6] = (m / f1);
    arrayOfFloat[7] = (k / f2);
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
    if ((localList == null) || (localList.size() < 90) || (CollectionUtils.isEmpty(this.items)) || (!VideoFilterUtil.actionTriggered(paramList, this.stickerItems, paramSet)))
    {
      addParam(new UniformParam.Float4sParam("item", this.flatMesh));
      return;
    }
    adjustFacePoints(localList);
    localList = TransformUtil.getFullPoints(localList);
    int j = 0;
    int k;
    if (j < this.items.size())
    {
      OvalDistortionItem localOvalDistortionItem = (OvalDistortionItem)this.items.get(j);
      this.meshs[j].type = localOvalDistortionItem.distortionType;
      this.meshs[j].strength = localOvalDistortionItem.strength;
      this.meshs[j].innerCirc = localOvalDistortionItem.innerCircle;
      this.meshs[j].outerCirc = localOvalDistortionItem.outerCircle;
      i = 0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      k = 0;
      float f3;
      if (k < 4)
      {
        if (localOvalDistortionItem.center[k] == -1)
        {
          f3 = f2;
          f2 = f1;
          f1 = f3;
        }
        for (;;)
        {
          k += 1;
          f3 = f2;
          f2 = f1;
          f1 = f3;
          break;
          f3 = ((PointF)localList.get(localOvalDistortionItem.center[k])).x;
          f2 = ((PointF)localList.get(localOvalDistortionItem.center[k])).y + f2;
          i += 1;
          f3 = f1 + f3;
          f1 = f2;
          f2 = f3;
        }
      }
      if (i > 0)
      {
        this.meshs[j].center[0] = (f1 / i);
        this.meshs[j].center[1] = (f2 / i);
        f2 = 0.0F;
        i = 0;
        k = 0;
        f1 = 0.0F;
        label358:
        if (k >= 4) {
          break label505;
        }
        if (localOvalDistortionItem.centerOffsetStart[k] != -1) {
          break label434;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        k += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label358;
        this.meshs[j].center[0] = 0.0F;
        this.meshs[j].center[1] = 0.0F;
        break;
        label434:
        f3 = ((PointF)localList.get(localOvalDistortionItem.centerOffsetStart[k])).x;
        f2 = ((PointF)localList.get(localOvalDistortionItem.centerOffsetStart[k])).y + f2;
        i += 1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
      }
      label505:
      if (i > 0)
      {
        paramList = new PointF(f1 / i, f2 / i);
        f2 = 0.0F;
        i = 0;
        k = 0;
        f1 = 0.0F;
        if (k >= 4) {
          break label671;
        }
        if (localOvalDistortionItem.centerOffsetEnd[k] != -1) {
          break label600;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        label540:
        k += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label540;
        paramList = new PointF(0.0F, 0.0F);
        break;
        label600:
        f3 = ((PointF)localList.get(localOvalDistortionItem.centerOffsetEnd[k])).x;
        f2 = ((PointF)localList.get(localOvalDistortionItem.centerOffsetEnd[k])).y + f2;
        i += 1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
      }
      label671:
      if (i > 0)
      {
        paramSet = new PointF(f1 / i, f2 / i);
        float[] arrayOfFloat = this.meshs[j].center;
        arrayOfFloat[0] += (paramSet.x - paramList.x) * localOvalDistortionItem.centerOffsetMultiplier;
        arrayOfFloat = this.meshs[j].center;
        f1 = arrayOfFloat[1];
        arrayOfFloat[1] = ((paramSet.y - paramList.y) * localOvalDistortionItem.centerOffsetMultiplier + f1);
        f2 = 0.0F;
        i = 0;
        k = 0;
        f1 = 0.0F;
        if (k >= 4) {
          break label911;
        }
        if (localOvalDistortionItem.lengthStart[k] != -1) {
          break label840;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        label780:
        k += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label780;
        paramSet = new PointF(0.0F, 0.0F);
        break;
        label840:
        f3 = ((PointF)localList.get(localOvalDistortionItem.lengthStart[k])).x;
        f2 = ((PointF)localList.get(localOvalDistortionItem.lengthStart[k])).y + f2;
        i += 1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
      }
      label911:
      if (i > 0)
      {
        paramList = new PointF(f1 / i, f2 / i);
        f2 = 0.0F;
        i = 0;
        k = 0;
        f1 = 0.0F;
        label946:
        if (k >= 4) {
          break label1077;
        }
        if (localOvalDistortionItem.lengthEnd[k] != -1) {
          break label1006;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        k += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label946;
        paramList = new PointF(0.0F, 0.0F);
        break;
        label1006:
        f3 = ((PointF)localList.get(localOvalDistortionItem.lengthEnd[k])).x;
        f2 = ((PointF)localList.get(localOvalDistortionItem.lengthEnd[k])).y + f2;
        i += 1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
      }
      label1077:
      if (i > 0)
      {
        paramSet = new PointF(f1 / i, f2 / i);
        this.meshs[j].length = (AlgoUtils.getDistance(paramList, paramSet) * localOvalDistortionItem.lengthMultiplier);
        f2 = 0.0F;
        i = 0;
        k = 0;
        f1 = 0.0F;
        label1133:
        if (k >= 4) {
          break label1264;
        }
        if (localOvalDistortionItem.widthStart[k] != -1) {
          break label1193;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        k += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label1133;
        paramSet = new PointF(0.0F, 0.0F);
        break;
        label1193:
        f3 = ((PointF)localList.get(localOvalDistortionItem.widthStart[k])).x;
        f2 = ((PointF)localList.get(localOvalDistortionItem.widthStart[k])).y + f2;
        i += 1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
      }
      label1264:
      if (i > 0)
      {
        paramList = new PointF(f1 / i, f2 / i);
        f2 = 0.0F;
        i = 0;
        k = 0;
        f1 = 0.0F;
        if (k >= 4) {
          break label1430;
        }
        if (localOvalDistortionItem.widthEnd[k] != -1) {
          break label1359;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        label1299:
        k += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label1299;
        paramList = new PointF(0.0F, 0.0F);
        break;
        label1359:
        f3 = ((PointF)localList.get(localOvalDistortionItem.widthEnd[k])).x;
        f2 = ((PointF)localList.get(localOvalDistortionItem.widthEnd[k])).y + f2;
        i += 1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
      }
      label1430:
      if (i > 0)
      {
        paramSet = new PointF(f1 / i, f2 / i);
        this.meshs[j].width = (AlgoUtils.getDistance(paramList, paramSet) * localOvalDistortionItem.widthMultiplier);
        f2 = 0.0F;
        i = 0;
        k = 0;
        f1 = 0.0F;
        label1486:
        if (k >= 4) {
          break label1617;
        }
        if (localOvalDistortionItem.angleStart[k] != -1) {
          break label1546;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        k += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label1486;
        paramSet = new PointF(0.0F, 0.0F);
        break;
        label1546:
        f3 = ((PointF)localList.get(localOvalDistortionItem.angleStart[k])).x;
        f2 = ((PointF)localList.get(localOvalDistortionItem.angleStart[k])).y + f2;
        i += 1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
      }
      label1617:
      if (i > 0)
      {
        paramList = new PointF(f1 / i, f2 / i);
        f2 = 0.0F;
        i = 0;
        k = 0;
        f1 = 0.0F;
        label1652:
        if (k >= 4) {
          break label1783;
        }
        if (localOvalDistortionItem.angleEnd[k] != -1) {
          break label1712;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        k += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label1652;
        paramList = new PointF(0.0F, 0.0F);
        break;
        label1712:
        f3 = ((PointF)localList.get(localOvalDistortionItem.angleEnd[k])).x;
        f2 = ((PointF)localList.get(localOvalDistortionItem.angleEnd[k])).y + f2;
        i += 1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
      }
      label1783:
      if (i > 0) {}
      for (paramSet = new PointF(f1 / i, f2 / i);; paramSet = new PointF(0.0F, 0.0F))
      {
        this.meshs[j].angle = ((float)Math.atan2(paramSet.y - paramList.y, paramSet.x - paramList.x));
        if (paramSet.x - paramList.x < 0.0F)
        {
          paramList = this.meshs[j];
          paramList.angle = ((float)(paramList.angle + 3.141592653589793D));
        }
        if ((this.meshs[j].type != 1) && (this.meshs[j].type != 2)) {
          break label1942;
        }
        this.meshs[j].scaleArea = localOvalDistortionItem.scaleArea;
        j += 1;
        break;
      }
      label1942:
      f2 = 0.0F;
      i = 0;
      k = 0;
      f1 = 0.0F;
      if (k < 4)
      {
        if (localOvalDistortionItem.pushStart[k] == -1)
        {
          f3 = f2;
          f2 = f1;
          f1 = f3;
        }
        for (;;)
        {
          k += 1;
          f3 = f2;
          f2 = f1;
          f1 = f3;
          break;
          f3 = ((PointF)localList.get(localOvalDistortionItem.pushStart[k])).x;
          f2 = ((PointF)localList.get(localOvalDistortionItem.pushStart[k])).y + f2;
          i += 1;
          f3 = f1 + f3;
          f1 = f2;
          f2 = f3;
        }
      }
      if (i > 0)
      {
        paramList = new PointF(f1 / i, f2 / i);
        f2 = 0.0F;
        i = 0;
        k = 0;
        f1 = 0.0F;
        label2106:
        if (k >= 4) {
          break label2237;
        }
        if (localOvalDistortionItem.pushEnd[k] != -1) {
          break label2166;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        k += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label2106;
        paramList = new PointF(0.0F, 0.0F);
        break;
        label2166:
        f3 = ((PointF)localList.get(localOvalDistortionItem.pushEnd[k])).x;
        f2 = ((PointF)localList.get(localOvalDistortionItem.pushEnd[k])).y + f2;
        i += 1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
      }
      label2237:
      if (i > 0) {}
      for (paramSet = new PointF(f1 / i, f2 / i);; paramSet = new PointF(0.0F, 0.0F))
      {
        this.meshs[j].pushDx = (paramSet.x - paramList.x);
        this.meshs[j].pushDy = (paramSet.y - paramList.y);
        break;
      }
    }
    int i = this.items.size();
    while (i < 20)
    {
      this.meshs[i].type = 0;
      i += 1;
    }
    j = 0;
    i = 0;
    while (i < this.items.size())
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
      paramList = this.flatMesh;
      j = k + 1;
      paramList[k] = (this.meshs[i].pushDy / this.cropEdge * 2.0F);
      i += 1;
    }
    addParam(new UniformParam.Float1sParam("item", this.flatMesh));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.OvalDistortionFilter
 * JD-Core Version:    0.7.0.1
 */