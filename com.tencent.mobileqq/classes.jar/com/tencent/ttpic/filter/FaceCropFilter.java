package com.tencent.ttpic.filter;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.model.FaceCropItem;
import com.tencent.ttpic.model.FaceCropItem.CropFrame;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaceCropFilter
  extends VideoFilterBase
{
  private float[] attrPositions = new float[8];
  private float[] attrTexCoords = new float[8];
  private FaceCropItem faceCropItem;
  private boolean needRender;
  private List<RenderItem> normalRenderItems;
  
  public FaceCropFilter(VideoMaterial paramVideoMaterial)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.FACE_CROP));
    this.faceCropItem = paramVideoMaterial.getFaceCropItem();
  }
  
  private void updateParams(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    Object localObject2 = (FaceCropItem.CropFrame)this.faceCropItem.frameList.get(paramInt);
    paramFloat = (float)Math.min(((FaceCropItem.CropFrame)localObject2).width / this.width, ((FaceCropItem.CropFrame)localObject2).height / this.height);
    float f1 = (float)(((FaceCropItem.CropFrame)localObject2).width / paramFloat);
    float f2 = (float)(((FaceCropItem.CropFrame)localObject2).height / paramFloat);
    Object localObject3 = FaceOffUtil.getFullCoords(paramList, 3.0F);
    paramList = ((List)localObject3).iterator();
    while (paramList.hasNext())
    {
      localObject1 = (PointF)paramList.next();
      ((PointF)localObject1).x = ((float)(((PointF)localObject1).x / this.mFaceDetScale));
      ((PointF)localObject1).y = ((float)(((PointF)localObject1).y / this.mFaceDetScale));
    }
    float f3 = distanceOf((PointF)((List)localObject3).get(0), (PointF)((List)localObject3).get(18));
    paramList = new ArrayList();
    paramList.add(((List)localObject3).get(99));
    paramList.add(((List)localObject3).get(105));
    paramList.add(((List)localObject3).get(101));
    paramList.add(((List)localObject3).get(103));
    f3 = (float)(((FaceCropItem.CropFrame)localObject2).faceWidth / paramFloat) / f3;
    Object localObject1 = new Matrix();
    ((Matrix)localObject1).reset();
    float f4 = ((PointF)((List)localObject3).get(64)).x;
    float f5 = ((PointF)((List)localObject3).get(64)).y;
    ((Matrix)localObject1).postRotate(radians2DEGREES((float)(paramArrayOfFloat[2] - ((FaceCropItem.CropFrame)localObject2).faceAngle)), f4, f5);
    ((Matrix)localObject1).postScale(f3, f3, f4, f5);
    paramArrayOfFloat = new PointF((f1 - this.width) / 2.0F, (f2 - this.height) / 2.0F);
    ((Matrix)localObject1).postTranslate((float)(((FaceCropItem.CropFrame)localObject2).noseX / paramFloat - paramArrayOfFloat.x) - f4, (float)(((FaceCropItem.CropFrame)localObject2).noseY / paramFloat - paramArrayOfFloat.y) - f5);
    paramArrayOfFloat = new ArrayList();
    localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (PointF)((Iterator)localObject2).next();
      float[] arrayOfFloat = new float[2];
      ((Matrix)localObject1).mapPoints(arrayOfFloat, new float[] { ((PointF)localObject3).x, ((PointF)localObject3).y });
      paramArrayOfFloat.add(new PointF(arrayOfFloat[0], arrayOfFloat[1]));
    }
    int i = 0;
    paramInt = 0;
    while (paramInt < 4)
    {
      localObject1 = (PointF)paramArrayOfFloat.get(paramInt);
      this.attrPositions[i] = (2.0F * ((PointF)localObject1).x / this.width - 1.0F);
      this.attrPositions[(i + 1)] = (((PointF)localObject1).y * 2.0F / this.height - 1.0F);
      localObject1 = (PointF)paramList.get(paramInt);
      this.attrTexCoords[i] = (((PointF)localObject1).x / this.width);
      this.attrTexCoords[(i + 1)] = (((PointF)localObject1).y / this.height);
      i += 2;
      paramInt += 1;
    }
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
    setPositions(this.attrPositions);
    setTexCords(this.attrTexCoords);
  }
  
  final float distanceOf(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public void initParams() {}
  
  public boolean isNeedRender()
  {
    return this.needRender;
  }
  
  final float radians2DEGREES(float paramFloat)
  {
    return 180.0F * paramFloat / 3.14159F;
  }
  
  public void setNormalRenderItems(List<RenderItem> paramList)
  {
    this.normalRenderItems = paramList;
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if ((this.faceCropItem == null) || (paramObject.facePoints == null) || (paramObject.facePoints.size() < 90) || (paramObject.faceAngles == null) || (paramObject.faceAngles.length < 3)) {
        this.needRender = false;
      }
    }
    else
    {
      return;
    }
    boolean bool;
    label75:
    label101:
    int j;
    if (!CollectionUtils.isEmpty(this.normalRenderItems))
    {
      bool = true;
      this.needRender = bool;
      if (this.normalRenderItems == null) {
        break label195;
      }
      Iterator localIterator = this.normalRenderItems.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label197;
      }
      AEFilterI localAEFilterI = ((RenderItem)localIterator.next()).filter;
      if (!(localAEFilterI instanceof NormalVideoFilter)) {
        break label239;
      }
      localAEFilterI.updatePreview(paramObject);
      if ((!this.needRender) || (!((NormalVideoFilter)localAEFilterI).isRenderReady())) {
        break label189;
      }
      bool = true;
      label165:
      this.needRender = bool;
      i = ((NormalVideoFilter)localAEFilterI).getLastFrameIndex();
    }
    label189:
    label195:
    label197:
    label239:
    for (;;)
    {
      break label101;
      bool = false;
      break label75;
      bool = false;
      break label165;
      j = 0;
      if ((!this.needRender) || (CollectionUtils.indexOutOfBounds(this.faceCropItem.frameList, j))) {
        break;
      }
      updateParams(VideoMaterialUtil.copyList(paramObject.facePoints), paramObject.faceAngles, paramObject.phoneAngle, j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceCropFilter
 * JD-Core Version:    0.7.0.1
 */