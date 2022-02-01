package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.model.TextRenderItem;
import com.tencent.ttpic.model.Transition;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.PARTICLE_CLEAR_MODE;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.particlesystem2d.Particle;
import com.tencent.ttpic.particlesystem2d.ParticleItem;
import com.tencent.ttpic.particlesystem2d.ParticleSystem2D;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VoiceTextFilter
  extends VideoFilterBase
{
  private static final String TAG = "VoiceTextFilter";
  private float faceDetScale;
  private FastRenderFilter fastRenderFilter = new FastRenderFilter();
  private int frameInterval;
  private boolean isBackground;
  private long lastFrameTimestamp = -1L;
  private int lastHeight = -1;
  private int lastWidth = -1;
  private ParticleItem[] particleItems;
  private ParticleSystem2D particleSystem2D = new ParticleSystem2D(AEModule.getContext());
  private List<RenderParam> renderParams = new ArrayList();
  private List<String> renderParticleIds;
  private List<TextRenderItem> textRenderItems = new ArrayList();
  private int zIndex;
  
  public VoiceTextFilter(int paramInt, List<StickerItem> paramList)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.FAST_STICKER));
    this.zIndex = paramInt;
    boolean bool;
    if (paramInt < 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.isBackground = bool;
    initParticleItems(paramList);
  }
  
  private void buildRenderParams(ParticleItem paramParticleItem)
  {
    if (paramParticleItem.particles != null)
    {
      Particle[] arrayOfParticle = paramParticleItem.particles;
      int m = arrayOfParticle.length;
      int i = 0;
      while (i < m)
      {
        Particle localParticle = arrayOfParticle[i];
        if ((localParticle.texture > 0) && (localParticle.alive))
        {
          RenderParam localRenderParam = new RenderParam();
          localRenderParam.texture = localParticle.texture;
          int j = paramParticleItem.emissionMode;
          float f2 = 0.0F;
          if (j != 0)
          {
            if (j != 1)
            {
              if (j != 2)
              {
                f1 = 0.0F;
                break label218;
              }
              f1 = localParticle.positionX;
              f2 = paramParticleItem.screenRatioScale * f1;
              f1 = localParticle.positionY * paramParticleItem.screenRatioScale;
              break label218;
            }
            f1 = paramParticleItem.emitterX;
            f1 = localParticle.positionX * paramParticleItem.screenRatioScale + f1;
            f2 = paramParticleItem.emitterY;
            f3 = localParticle.positionY;
            f4 = paramParticleItem.screenRatioScale;
          }
          else
          {
            f1 = localParticle.startX;
            f1 = localParticle.positionX * paramParticleItem.screenRatioScale + f1;
            f2 = localParticle.startY;
            f3 = localParticle.positionY;
            f4 = paramParticleItem.screenRatioScale;
          }
          float f3 = f2 + f3 * f4;
          f2 = f1;
          float f1 = f3;
          label218:
          int k;
          if (paramParticleItem.stickerItem.anchorPoint != null)
          {
            j = paramParticleItem.stickerItem.anchorPoint[0];
            k = paramParticleItem.stickerItem.anchorPoint[1];
          }
          else
          {
            j = 0;
            k = 0;
          }
          f2 -= j;
          f1 -= k;
          f3 = f2 + paramParticleItem.stickerItem.width * paramParticleItem.screenRatioScale;
          float f4 = f1 + paramParticleItem.stickerItem.height * paramParticleItem.screenRatioScale;
          localRenderParam.texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
          localRenderParam.texScale = localParticle.scale;
          localRenderParam.texAnchor[0] = ((f2 + f3) / 2.0F - this.width / 2);
          localRenderParam.texAnchor[1] = ((f4 + f1) / 2.0F - this.height / 2);
          localRenderParam.texRotate[2] = localParticle.rotate;
          localRenderParam.position = AlgoUtils.calPositionsTriangles(f2, f4, f3, f1, this.width, this.height);
          this.renderParams.add(localRenderParam);
        }
        i += 1;
      }
    }
  }
  
  private void initParticleItems(List<StickerItem> paramList)
  {
    if (paramList != null)
    {
      this.particleItems = new ParticleItem[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        StickerItem localStickerItem = (StickerItem)paramList.get(i);
        ParticleItem localParticleItem = new ParticleItem(localStickerItem);
        localParticleItem.id = localStickerItem.id;
        localParticleItem.particles = new Particle[localStickerItem.transition.particleCountMax];
        localParticleItem.maxRepeatCount = localStickerItem.transition.repeatCount;
        localParticleItem.emissionMode = localStickerItem.transition.emissionMode;
        localParticleItem.particleAlwaysUpdate = localStickerItem.transition.particleAlwaysUpdate;
        localParticleItem.clearMode = localStickerItem.transition.clearMode;
        int j = 0;
        while (j < localParticleItem.particles.length)
        {
          localParticleItem.particles[j] = new Particle();
          j += 1;
        }
        this.particleItems[i] = localParticleItem;
        i += 1;
      }
      this.particleSystem2D.createParticles(paramList);
    }
  }
  
  private void recycleUnusedWMGroups()
  {
    ParticleItem[] arrayOfParticleItem = this.particleItems;
    int k = arrayOfParticleItem.length;
    int i = 0;
    while (i < k)
    {
      Object localObject1 = arrayOfParticleItem[i];
      if (((ParticleItem)localObject1).particles != null)
      {
        HashSet localHashSet = new HashSet();
        localObject1 = ((ParticleItem)localObject1).particles;
        int m = localObject1.length;
        int j = 0;
        while (j < m)
        {
          Object localObject2 = localObject1[j];
          if (localObject2.alive) {
            localHashSet.add(Integer.valueOf(localObject2.wmGroupId));
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  private void reset(int paramInt)
  {
    this.particleSystem2D.clearParticles(paramInt);
    ParticleItem[] arrayOfParticleItem = this.particleItems;
    if ((arrayOfParticleItem != null) && (paramInt < arrayOfParticleItem.length)) {
      arrayOfParticleItem[paramInt].reset();
    }
  }
  
  private void resetAll()
  {
    this.particleSystem2D.reset();
    int i = 0;
    for (;;)
    {
      ParticleItem[] arrayOfParticleItem = this.particleItems;
      if (i >= arrayOfParticleItem.length) {
        break;
      }
      arrayOfParticleItem[i].reset();
      i += 1;
    }
  }
  
  private void updateCurEmitterPos(List<PointF> paramList1, List<PointF> paramList2)
  {
    ParticleItem[] arrayOfParticleItem = this.particleItems;
    int k = arrayOfParticleItem.length;
    int i = 0;
    while (i < k)
    {
      ParticleItem localParticleItem = arrayOfParticleItem[i];
      StickerItem localStickerItem = localParticleItem.stickerItem;
      if (localStickerItem != null)
      {
        int j = localStickerItem.type;
        if (j != 1)
        {
          if ((j == 2) || (j == 4))
          {
            Object localObject;
            if (VideoMaterial.isGestureItem(localStickerItem)) {
              localObject = paramList2;
            } else {
              localObject = paramList1;
            }
            if ((localObject != null) && (!((List)localObject).isEmpty()))
            {
              PointF localPointF = (PointF)((List)localObject).get(localStickerItem.alignFacePoints[0]);
              if (localStickerItem.alignFacePoints.length == 1) {
                j = localStickerItem.alignFacePoints[0];
              } else {
                j = localStickerItem.alignFacePoints[1];
              }
              localObject = (PointF)((List)localObject).get(j);
              localObject = new PointF((localPointF.x + ((PointF)localObject).x) / 2.0F, (localPointF.y + ((PointF)localObject).y) / 2.0F);
              if (VideoMaterial.isFaceItem(localStickerItem))
              {
                ((PointF)localObject).x /= this.faceDetScale;
                ((PointF)localObject).y /= this.faceDetScale;
              }
              localParticleItem.emitterX = ((PointF)localObject).x;
              localParticleItem.emitterY = ((PointF)localObject).y;
            }
          }
        }
        else
        {
          double d1 = this.width;
          double d2 = this.height;
          Double.isNaN(d1);
          Double.isNaN(d2);
          int m;
          if (d1 / d2 >= 0.75D)
          {
            d1 = this.width;
            Double.isNaN(d1);
            int n = (int)(d1 / 0.75D);
            d1 = n;
            d2 = localStickerItem.position[1];
            Double.isNaN(d1);
            j = (int)(d1 * d2);
            d1 = this.width;
            d2 = localStickerItem.position[0];
            Double.isNaN(d1);
            m = (int)(d1 * d2);
            n = (n - this.height) / 2;
            localParticleItem.emitterX = m;
            localParticleItem.emitterY = (j - n);
            localParticleItem.screenRatioScale = (this.width * 1.0F / 720.0F);
          }
          else
          {
            d1 = this.height;
            Double.isNaN(d1);
            j = (int)(d1 * 0.75D);
            d1 = this.height;
            d2 = localStickerItem.position[1];
            Double.isNaN(d1);
            m = (int)(d1 * d2);
            d1 = j;
            d2 = localStickerItem.position[0];
            Double.isNaN(d1);
            localParticleItem.emitterX = ((int)(d1 * d2) - (j - this.width) / 2);
            localParticleItem.emitterY = m;
            localParticleItem.screenRatioScale = (this.height * 1.0F / 960.0F);
          }
        }
      }
      i += 1;
    }
  }
  
  private void updateParticleState(ParticleItem paramParticleItem, int paramInt, long paramLong) {}
  
  private void updateParticleStateAndBuildRenderParams(long paramLong)
  {
    this.renderParams.clear();
    int i = 0;
    for (;;)
    {
      Object localObject = this.particleItems;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (((!this.isBackground) || (((ParticleItem)localObject).stickerItem.zIndex < 0)) && ((this.isBackground) || (((ParticleItem)localObject).stickerItem.zIndex >= 0)) && (((ParticleItem)localObject).clearMode == VideoMaterial.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (!((ParticleItem)localObject).lastFrameParticleReachMax)) {
        ((ParticleItem)localObject).lastFrameParticleReachMax = ((ParticleItem)localObject).particleReachMax;
      }
      i += 1;
    }
  }
  
  private void updateParticles(List<PointF> paramList1, List<PointF> paramList2, long paramLong)
  {
    if (this.particleItems != null)
    {
      updateCurEmitterPos(paramList1, paramList2);
      updateParticleStateAndBuildRenderParams(paramLong);
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.fastRenderFilter.applyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    Iterator localIterator = this.textRenderItems.iterator();
    while (localIterator.hasNext()) {
      ((TextRenderItem)localIterator.next()).clear();
    }
    this.fastRenderFilter.clearGLSLSelf();
    this.particleSystem2D.release();
  }
  
  public int getZIndex()
  {
    return this.zIndex;
  }
  
  public void initParams() {}
  
  public boolean isBackground()
  {
    return this.isBackground;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    updateAndRender(null, System.currentTimeMillis(), this.isBackground);
    return true;
  }
  
  public void setRenderParticleIds(List<String> paramList)
  {
    this.renderParticleIds = paramList;
  }
  
  public void updateAndRender(Frame paramFrame, long paramLong, boolean paramBoolean)
  {
    if (!this.renderParams.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(" fastRenderFilter.render");
      BenchUtil.benchStart(localStringBuilder.toString());
      this.fastRenderFilter.render(this.renderParams, paramFrame, true);
      paramFrame = new StringBuilder();
      paramFrame.append(TAG);
      paramFrame.append(" fastRenderFilter.render");
      BenchUtil.benchEnd(paramFrame.toString());
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(" updatePreview");
      BenchUtil.benchStart(((StringBuilder)localObject).toString());
      if (this.lastFrameTimestamp != -1L) {
        this.frameInterval = ((int)(paramObject.timestamp - this.lastFrameTimestamp));
      }
      this.lastFrameTimestamp = paramObject.timestamp;
      int i = 0;
      for (;;)
      {
        localObject = this.particleItems;
        if (i >= localObject.length) {
          break;
        }
        List localList = this.renderParticleIds;
        if ((localList != null) && (localList.contains(localObject[i].id))) {
          this.particleItems[i].triggered = true;
        } else {
          this.particleItems[i].triggered = false;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(" updateParticles");
      BenchUtil.benchStart(((StringBuilder)localObject).toString());
      updateParticles(paramObject.facePoints, paramObject.handPoints, paramObject.timestamp);
      paramObject = new StringBuilder();
      paramObject.append(TAG);
      paramObject.append(" updateParticles");
      BenchUtil.benchEnd(paramObject.toString());
      paramObject = new StringBuilder();
      paramObject.append(TAG);
      paramObject.append(" particleSystem2D.advance");
      BenchUtil.benchStart(paramObject.toString());
      this.particleSystem2D.advance(this.particleItems, this.frameInterval);
      paramObject = new StringBuilder();
      paramObject.append(TAG);
      paramObject.append(" particleSystem2D.advance");
      BenchUtil.benchEnd(paramObject.toString());
      paramObject = new StringBuilder();
      paramObject.append(TAG);
      paramObject.append(" recycleUnusedWMGroups");
      BenchUtil.benchStart(paramObject.toString());
      recycleUnusedWMGroups();
      paramObject = new StringBuilder();
      paramObject.append(TAG);
      paramObject.append(" recycleUnusedWMGroups");
      BenchUtil.benchEnd(paramObject.toString());
      paramObject = new StringBuilder();
      paramObject.append(TAG);
      paramObject.append(" updatePreview");
      BenchUtil.benchEnd(paramObject.toString());
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.fastRenderFilter.updateVideoSize(paramInt1, paramInt2);
    this.faceDetScale = ((float)paramDouble);
    Iterator localIterator = this.textRenderItems.iterator();
    while (localIterator.hasNext()) {
      ((TextRenderItem)localIterator.next()).updateVideoSize(paramInt1, paramInt2);
    }
    int i = this.lastWidth;
    if (i > 0)
    {
      int j = this.lastHeight;
      if ((j > 0) && ((paramInt1 != i) || (paramInt2 != j))) {
        resetAll();
      }
    }
    this.lastWidth = paramInt1;
    this.lastHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.VoiceTextFilter
 * JD-Core Version:    0.7.0.1
 */