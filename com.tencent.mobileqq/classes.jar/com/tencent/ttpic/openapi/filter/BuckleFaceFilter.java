package com.tencent.ttpic.openapi.filter;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.BuckleFaceItem;
import com.tencent.ttpic.openapi.model.BuckleFrameItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuckleFaceFilter
  extends VideoFilterBase
{
  public static final String FACE_CROP_FRAGMENT = "precision mediump float;\nvarying lowp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n\nvoid main(void) {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
  public static final String FACE_CROP_VERTEX = "precision highp float;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(void) {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  private float[] attrPositions = new float[8];
  private float[] attrTexCoords = new float[8];
  private List<PointF> faceCheckPoint = new ArrayList();
  private BuckleFaceItem mBuckleItem;
  private boolean needRender;
  private List<NormalVideoFilter> normalFilters;
  private List<RenderItem> normalRenderItems;
  
  public BuckleFaceFilter(BuckleFaceItem paramBuckleFaceItem, String paramString)
  {
    super(BaseFilter.nativeDecrypt("precision highp float;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(void) {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}"), BaseFilter.nativeDecrypt("precision mediump float;\nvarying lowp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n\nvoid main(void) {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}"));
    if ((paramBuckleFaceItem == null) || (paramBuckleFaceItem.frameList.size() <= 0)) {
      throw new IllegalArgumentException("BuckleFaceFilter| items length error!");
    }
    this.needRender = false;
    this.mBuckleItem = paramBuckleFaceItem;
  }
  
  private static float distanceOf(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private static float radians2DEGREES(float paramFloat)
  {
    return (float)(180.0F * paramFloat / 3.141592653589793D);
  }
  
  private void updateParams(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0)) {
      this.needRender = false;
    }
    Object localObject1;
    double d3;
    double d4;
    float f1;
    PointF localPointF1;
    Object localObject2;
    Object localObject3;
    do
    {
      return;
      localObject1 = (BuckleFrameItem)this.mBuckleItem.frameList.get(paramInt);
      double d1 = localObject1.size[0];
      double d2 = localObject1.size[1];
      d3 = localObject1.nosePoint[0];
      d4 = localObject1.nosePoint[1];
      f1 = (float)Math.min(d1 / this.width, d2 / this.height);
      paramFloat = (float)(d1 / f1);
      f2 = (float)(d2 / f1);
      localPointF1 = new PointF((paramFloat - this.width) / 2.0F, (f2 - this.height) / 2.0F);
      localObject2 = FaceOffUtil.getFullCoords(paramList, 3.0F);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        this.needRender = false;
        return;
      }
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject3 = (PointF)paramList.next();
        ((PointF)localObject3).x = ((float)(((PointF)localObject3).x / this.mFaceDetScale));
        ((PointF)localObject3).y = ((float)(((PointF)localObject3).y / this.mFaceDetScale));
      }
      paramList = new ArrayList();
      paramList.add(((List)localObject2).get(99));
      paramList.add(((List)localObject2).get(105));
      paramList.add(((List)localObject2).get(101));
      paramList.add(((List)localObject2).get(103));
      this.faceCheckPoint.add(((List)localObject2).get(9));
      this.faceCheckPoint.add(((List)localObject2).get(86));
      this.faceCheckPoint.add(((List)localObject2).get(88));
      this.faceCheckPoint.add(((List)localObject2).get(0));
      this.faceCheckPoint.add(((List)localObject2).get(18));
      localObject3 = this.faceCheckPoint.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        PointF localPointF2 = (PointF)((Iterator)localObject3).next();
        if ((localPointF2.x < 0.0F) || (localPointF2.y < 0.0F) || (localPointF2.x >= this.width) || (localPointF2.y >= this.height)) {
          this.needRender = false;
        }
      }
      this.faceCheckPoint.clear();
    } while (!this.needRender);
    float f2 = (float)(((BuckleFrameItem)localObject1).faceWidth / f1);
    float f3 = distanceOf((PointF)((List)localObject2).get(0), (PointF)((List)localObject2).get(18));
    paramFloat = paramArrayOfFloat[1];
    if (Math.abs(paramFloat) > 0.2D) {
      if (paramFloat > 0.0F) {
        paramFloat = (paramFloat - 0.2F) * f2;
      }
    }
    for (;;)
    {
      localObject3 = new Matrix();
      ((Matrix)localObject3).reset();
      float f4 = ((PointF)((List)localObject2).get(64)).x;
      float f5 = ((PointF)((List)localObject2).get(64)).y;
      f2 /= f3;
      ((Matrix)localObject3).postRotate(radians2DEGREES((float)(paramArrayOfFloat[2] - ((BuckleFrameItem)localObject1).faceAngle)), f4, f5);
      ((Matrix)localObject3).postScale(f2, f2, f4, f5);
      ((Matrix)localObject3).postTranslate((float)(d3 / f1 - localPointF1.x) - f4, (float)(d4 / f1 - localPointF1.y) - f5);
      ((Matrix)localObject3).postTranslate(paramFloat, 0.0F);
      paramArrayOfFloat = new ArrayList();
      localObject1 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localPointF1 = (PointF)((Iterator)localObject1).next();
          localObject2 = new float[2];
          ((Matrix)localObject3).mapPoints((float[])localObject2, new float[] { localPointF1.x, localPointF1.y });
          paramArrayOfFloat.add(new PointF(localObject2[0], localObject2[1]));
          continue;
          paramFloat = (0.2F + paramFloat) * f2;
          break;
        }
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
      setRenderMode(0);
      setPositions(this.attrPositions);
      setTexCords(this.attrTexCoords);
      return;
      paramFloat = 0.0F;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
  }
  
  public void initParams() {}
  
  public boolean isNeedRender()
  {
    return this.needRender;
  }
  
  public void setNormalRenderItems(List<RenderItem> paramList)
  {
    this.normalRenderItems = paramList;
  }
  
  public void updatePreview(Object paramObject)
  {
    label51:
    int j;
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      int i;
      if (!CollectionUtils.isEmpty(this.normalRenderItems))
      {
        bool = true;
        this.needRender = bool;
        if (this.normalRenderItems == null) {
          break label196;
        }
        Iterator localIterator = this.normalRenderItems.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label198;
        }
        AEFilterI localAEFilterI = ((RenderItem)localIterator.next()).filter;
        j = i;
        if ((localAEFilterI instanceof NormalVideoFilter))
        {
          localAEFilterI.updatePreview(paramObject);
          j = i;
          if (!((NormalVideoFilter)localAEFilterI).getStickerItem().id.equals("bgm"))
          {
            j = i;
            if (((NormalVideoFilter)localAEFilterI).getStickerItem().frameDuration == this.mBuckleItem.frameDuration)
            {
              j = ((NormalVideoFilter)localAEFilterI).getLastFrameIndex();
              if ((!this.needRender) || (!((NormalVideoFilter)localAEFilterI).isRenderReady())) {
                break label190;
              }
            }
          }
        }
      }
      label190:
      for (boolean bool = true;; bool = false)
      {
        this.needRender = bool;
        i = j;
        break label51;
        bool = false;
        break;
      }
      label196:
      j = 0;
      label198:
      if ((this.needRender) && (!CollectionUtils.indexOutOfBounds(this.mBuckleItem.frameList, j))) {}
    }
    else
    {
      return;
    }
    updateParams(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle, j);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BuckleFaceFilter
 * JD-Core Version:    0.7.0.1
 */