package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.model.Transition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.particlesystemx.ParticleItemX;
import com.tencent.ttpic.particlesystemx.ParticleSystemX;
import com.tencent.ttpic.particlesystemx.ParticleX;
import com.tencent.ttpic.util.AlgoUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class ParticleXFilter
  extends NormalVideoFilter
{
  private FastRenderFilter fastRenderFilter = new FastRenderFilter();
  private float frameInterval;
  private long lastFrameTimestamp = -1L;
  private FloatBuffer particleDataBuffer;
  private ParticleItemX particleItemX = new ParticleItemX();
  private List<RenderParam> renderParams = new ArrayList();
  private int templateIndex;
  
  public ParticleXFilter(StickerItem paramStickerItem, String paramString, int paramInt)
  {
    super(paramStickerItem, paramString);
    this.templateIndex = paramInt;
    this.particleDataBuffer = ByteBuffer.allocateDirect(paramStickerItem.transition.particleCountMax * 6 * 2 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.fastRenderFilter.applyGLSLFilter();
    this.fastRenderFilter.setBlendMode(this.item.blendMode);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.fastRenderFilter.clearGLSLSelf();
    ParticleSystemX.getInstance().release();
  }
  
  protected void clearTextureParam()
  {
    super.clearTextureParam();
    this.renderParams.clear();
    ParticleSystemX.getInstance().clearParticles(this.templateIndex);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    BenchUtil.benchStart("fastRenderFilter.render");
    this.fastRenderFilter.render(paramInt1, this.renderParams, null, true);
    BenchUtil.benchEnd("fastRenderFilter.render");
    return true;
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    this.renderParams.clear();
    long l1 = System.currentTimeMillis();
    long l2 = this.lastFrameTimestamp;
    if (l2 != -1L) {
      this.frameInterval = ((float)(l1 - l2) * 1.0F / 1000.0F);
    }
    this.lastFrameTimestamp = l1;
    int i = this.item.type;
    double d1;
    double d2;
    int k;
    int j;
    if (i != 1)
    {
      if (((i == 2) || (i == 4)) && (paramList != null) && (!paramList.isEmpty()))
      {
        paramArrayOfFloat = (PointF)paramList.get(this.item.alignFacePoints[0]);
        if (this.item.alignFacePoints.length == 1) {
          i = this.item.alignFacePoints[0];
        } else {
          i = this.item.alignFacePoints[1];
        }
        localObject = (PointF)paramList.get(i);
        paramArrayOfFloat = new PointF((paramArrayOfFloat.x + ((PointF)localObject).x) / 2.0F, (paramArrayOfFloat.y + ((PointF)localObject).y) / 2.0F);
        if (VideoMaterial.isFaceItem(this.item))
        {
          d1 = paramArrayOfFloat.x;
          d2 = this.mFaceDetScale;
          Double.isNaN(d1);
          paramArrayOfFloat.x = ((float)(d1 / d2));
          d1 = paramArrayOfFloat.y;
          d2 = this.mFaceDetScale;
          Double.isNaN(d1);
          paramArrayOfFloat.y = ((float)(d1 / d2));
        }
        this.particleItemX.emitterX = paramArrayOfFloat.x;
        this.particleItemX.emitterY = paramArrayOfFloat.y;
      }
    }
    else
    {
      d1 = this.width;
      d2 = this.height;
      Double.isNaN(d1);
      Double.isNaN(d2);
      if (d1 / d2 >= 0.75D)
      {
        d1 = this.width;
        Double.isNaN(d1);
        k = (int)(d1 / 0.75D);
        d1 = k;
        d2 = this.item.position[1];
        Double.isNaN(d1);
        i = (int)(d1 * d2);
        d1 = this.width;
        d2 = this.item.position[0];
        Double.isNaN(d1);
        j = (int)(d1 * d2);
        k = (k - this.height) / 2;
        paramArrayOfFloat = this.particleItemX;
        paramArrayOfFloat.emitterX = j;
        paramArrayOfFloat.emitterY = (i - k);
        paramArrayOfFloat.screenRatioScale = (this.width * 1.0F / 720.0F);
      }
      else
      {
        d1 = this.height;
        Double.isNaN(d1);
        k = (int)(d1 * 0.75D);
        d1 = this.height;
        d2 = this.item.position[1];
        Double.isNaN(d1);
        i = (int)(d1 * d2);
        d1 = k;
        d2 = this.item.position[0];
        Double.isNaN(d1);
        j = (int)(d1 * d2);
        k = (k - this.width) / 2;
        paramArrayOfFloat = this.particleItemX;
        paramArrayOfFloat.emitterX = (j - k);
        paramArrayOfFloat.emitterY = i;
        paramArrayOfFloat.screenRatioScale = (this.height * 1.0F / 960.0F);
      }
    }
    paramArrayOfFloat = ParticleSystemX.getInstance();
    i = this.templateIndex;
    paramFloat = this.particleItemX.emitterX;
    float f1 = this.particleItemX.emitterY;
    Object localObject = this.particleDataBuffer;
    float f2 = this.frameInterval;
    boolean bool;
    if ((paramList != null) && (!paramList.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    i = paramArrayOfFloat.advanceByTemplate(i, paramFloat, f1, (FloatBuffer)localObject, f2, bool);
    paramArrayOfFloat = new float[i * 6];
    this.particleDataBuffer.position(0);
    this.particleDataBuffer.get(paramArrayOfFloat);
    paramList = new ParticleX[i];
    i = 0;
    while (i < paramList.length)
    {
      localObject = new ParticleX();
      j = i * 6;
      ((ParticleX)localObject).startX = paramArrayOfFloat[(j + 0)];
      ((ParticleX)localObject).startY = paramArrayOfFloat[(j + 1)];
      ((ParticleX)localObject).positionX = paramArrayOfFloat[(j + 2)];
      ((ParticleX)localObject).positionY = paramArrayOfFloat[(j + 3)];
      ((ParticleX)localObject).scale = paramArrayOfFloat[(j + 4)];
      ((ParticleX)localObject).rotate = paramArrayOfFloat[(j + 5)];
      paramList[i] = localObject;
      i += 1;
    }
    int m = paramList.length;
    i = 0;
    while (i < m)
    {
      paramArrayOfFloat = paramList[i];
      j = this.item.transition.emissionMode;
      f1 = 0.0F;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            paramFloat = 0.0F;
            break label1002;
          }
          paramFloat = paramArrayOfFloat.positionX;
          f1 = this.particleItemX.screenRatioScale * paramFloat;
          paramFloat = paramArrayOfFloat.positionY * this.particleItemX.screenRatioScale;
          break label1002;
        }
        paramFloat = this.particleItemX.emitterX;
        paramFloat = paramArrayOfFloat.positionX * this.particleItemX.screenRatioScale + paramFloat;
        f1 = this.particleItemX.emitterY;
        f2 = paramArrayOfFloat.positionY;
        f3 = this.particleItemX.screenRatioScale;
      }
      else
      {
        paramFloat = paramArrayOfFloat.startX;
        paramFloat = paramArrayOfFloat.positionX * this.particleItemX.screenRatioScale + paramFloat;
        f1 = paramArrayOfFloat.startY;
        f2 = paramArrayOfFloat.positionY;
        f3 = this.particleItemX.screenRatioScale;
      }
      f2 = f1 + f2 * f3;
      f1 = paramFloat;
      paramFloat = f2;
      label1002:
      if (this.item.anchorPoint != null)
      {
        j = this.item.anchorPoint[0];
        k = this.item.anchorPoint[1];
      }
      else
      {
        j = 0;
        k = 0;
      }
      f1 -= j;
      paramFloat -= k;
      f2 = f1 + this.item.width * this.particleItemX.screenRatioScale;
      float f3 = paramFloat + this.item.height * this.particleItemX.screenRatioScale;
      localObject = new RenderParam();
      ((RenderParam)localObject).texture = getTextureId();
      ((RenderParam)localObject).texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
      ((RenderParam)localObject).texScale = paramArrayOfFloat.scale;
      ((RenderParam)localObject).texAnchor[0] = ((f1 + f2) / 2.0F - this.width / 2);
      ((RenderParam)localObject).texAnchor[1] = ((f3 + paramFloat) / 2.0F - this.height / 2);
      ((RenderParam)localObject).texRotate[2] = paramArrayOfFloat.rotate;
      ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f1, f3, f2, paramFloat, this.width, this.height);
      this.renderParams.add(localObject);
      i += 1;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.fastRenderFilter.updateVideoSize(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.ParticleXFilter
 * JD-Core Version:    0.7.0.1
 */