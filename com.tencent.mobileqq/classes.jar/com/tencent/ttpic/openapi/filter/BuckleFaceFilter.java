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
    if ((paramBuckleFaceItem != null) && (paramBuckleFaceItem.frameList.size() > 0))
    {
      this.needRender = false;
      this.mBuckleItem = paramBuckleFaceItem;
      return;
    }
    throw new IllegalArgumentException("BuckleFaceFilter| items length error!");
  }
  
  private static float distanceOf(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private static float radians2DEGREES(float paramFloat)
  {
    double d = paramFloat * 180.0F;
    Double.isNaN(d);
    return (float)(d / 3.141592653589793D);
  }
  
  private void updateParams(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0))
    {
      Object localObject1 = (BuckleFrameItem)this.mBuckleItem.frameList.get(paramInt);
      double d4 = localObject1.size[0];
      double d5 = localObject1.size[1];
      double d2 = localObject1.nosePoint[0];
      double d1 = localObject1.nosePoint[1];
      double d3 = this.width;
      Double.isNaN(d3);
      d3 = d4 / d3;
      double d6 = this.height;
      Double.isNaN(d6);
      d3 = (float)Math.min(d3, d5 / d6);
      Double.isNaN(d3);
      paramFloat = (float)(d4 / d3);
      Double.isNaN(d3);
      float f1 = (float)(d5 / d3);
      Object localObject2 = new PointF((paramFloat - this.width) / 2.0F, (f1 - this.height) / 2.0F);
      Object localObject3 = FaceOffUtil.getFullCoords(paramList, 3.0F);
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        paramList = ((List)localObject3).iterator();
        while (paramList.hasNext())
        {
          localObject4 = (PointF)paramList.next();
          d4 = ((PointF)localObject4).x;
          d5 = this.mFaceDetScale;
          Double.isNaN(d4);
          ((PointF)localObject4).x = ((float)(d4 / d5));
          d4 = ((PointF)localObject4).y;
          d5 = this.mFaceDetScale;
          Double.isNaN(d4);
          ((PointF)localObject4).y = ((float)(d4 / d5));
        }
        paramList = new ArrayList();
        paramList.add(((List)localObject3).get(99));
        paramList.add(((List)localObject3).get(105));
        paramList.add(((List)localObject3).get(101));
        paramList.add(((List)localObject3).get(103));
        this.faceCheckPoint.add(((List)localObject3).get(9));
        this.faceCheckPoint.add(((List)localObject3).get(86));
        this.faceCheckPoint.add(((List)localObject3).get(88));
        this.faceCheckPoint.add(((List)localObject3).get(0));
        this.faceCheckPoint.add(((List)localObject3).get(18));
        Object localObject4 = this.faceCheckPoint.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          PointF localPointF = (PointF)((Iterator)localObject4).next();
          if ((localPointF.x < 0.0F) || (localPointF.y < 0.0F) || (localPointF.x >= this.width) || (localPointF.y >= this.height)) {
            this.needRender = false;
          }
        }
        this.faceCheckPoint.clear();
        if (!this.needRender) {
          return;
        }
        d4 = ((BuckleFrameItem)localObject1).faceWidth;
        Double.isNaN(d3);
        f1 = (float)(d4 / d3);
        float f2 = distanceOf((PointF)((List)localObject3).get(0), (PointF)((List)localObject3).get(18));
        paramFloat = paramArrayOfFloat[1];
        if (Math.abs(paramFloat) > 0.2D)
        {
          if (paramFloat > 0.0F) {
            paramFloat -= 0.2F;
          } else {
            paramFloat += 0.2F;
          }
          paramFloat *= f1;
        }
        else
        {
          paramFloat = 0.0F;
        }
        localObject4 = new Matrix();
        ((Matrix)localObject4).reset();
        float f3 = ((PointF)((List)localObject3).get(64)).x;
        float f4 = ((PointF)((List)localObject3).get(64)).y;
        f1 /= f2;
        d4 = paramArrayOfFloat[2];
        d5 = ((BuckleFrameItem)localObject1).faceAngle;
        Double.isNaN(d4);
        ((Matrix)localObject4).postRotate(radians2DEGREES((float)(d4 - d5)), f3, f4);
        ((Matrix)localObject4).postScale(f1, f1, f3, f4);
        Double.isNaN(d3);
        d2 /= d3;
        d4 = ((PointF)localObject2).x;
        Double.isNaN(d4);
        f1 = (float)(d2 - d4);
        Double.isNaN(d3);
        d1 /= d3;
        d2 = ((PointF)localObject2).y;
        Double.isNaN(d2);
        ((Matrix)localObject4).postTranslate(f1 - f3, (float)(d1 - d2) - f4);
        ((Matrix)localObject4).postTranslate(paramFloat, 0.0F);
        paramArrayOfFloat = new ArrayList();
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PointF)((Iterator)localObject1).next();
          localObject3 = new float[2];
          ((Matrix)localObject4).mapPoints((float[])localObject3, new float[] { ((PointF)localObject2).x, ((PointF)localObject2).y });
          paramArrayOfFloat.add(new PointF(localObject3[0], localObject3[1]));
        }
        paramInt = 0;
        int i = 0;
        while (paramInt < 4)
        {
          localObject1 = (PointF)paramArrayOfFloat.get(paramInt);
          this.attrPositions[i] = (((PointF)localObject1).x * 2.0F / this.width - 1.0F);
          localObject2 = this.attrPositions;
          int j = i + 1;
          localObject2[j] = (((PointF)localObject1).y * 2.0F / this.height - 1.0F);
          localObject1 = (PointF)paramList.get(paramInt);
          this.attrTexCoords[i] = (((PointF)localObject1).x / this.width);
          this.attrTexCoords[j] = (((PointF)localObject1).y / this.height);
          i += 2;
          paramInt += 1;
        }
        setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
        setRenderMode(0);
        setPositions(this.attrPositions);
        setTexCords(this.attrTexCoords);
        return;
      }
      this.needRender = false;
      return;
    }
    this.needRender = false;
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
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      this.needRender = (CollectionUtils.isEmpty(this.normalRenderItems) ^ true);
      Object localObject1 = this.normalRenderItems;
      int i = 0;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((RenderItem)((Iterator)localObject1).next()).filter;
          if ((localObject2 instanceof NormalVideoFilter))
          {
            ((AEFilterI)localObject2).updatePreview(paramObject);
            localObject2 = (NormalVideoFilter)localObject2;
            if ((!((NormalVideoFilter)localObject2).getStickerItem().id.equals("bgm")) && (((NormalVideoFilter)localObject2).getStickerItem().frameDuration == this.mBuckleItem.frameDuration))
            {
              i = ((NormalVideoFilter)localObject2).getLastFrameIndex();
              boolean bool;
              if ((this.needRender) && (((NormalVideoFilter)localObject2).isRenderReady())) {
                bool = true;
              } else {
                bool = false;
              }
              this.needRender = bool;
            }
          }
        }
      }
      if (this.needRender)
      {
        if (CollectionUtils.indexOutOfBounds(this.mBuckleItem.frameList, i)) {
          return;
        }
        updateParams(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle, i);
      }
    }
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