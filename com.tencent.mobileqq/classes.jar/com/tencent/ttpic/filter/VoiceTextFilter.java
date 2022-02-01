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
import com.tencent.ttpic.openapi.model.WMGroup;
import com.tencent.ttpic.openapi.model.WMGroupConfig;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.PARTICLE_CLEAR_MODE;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import com.tencent.ttpic.particlesystem2d.Particle;
import com.tencent.ttpic.particlesystem2d.ParticleItem;
import com.tencent.ttpic.particlesystem2d.ParticleSystem2D;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VoiceTextFilter
  extends VideoFilterBase
{
  private static final String TAG = VoiceTextFilter.class.getSimpleName();
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
    if (paramInt < 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isBackground = bool;
      initParticleItems(paramList);
      return;
    }
  }
  
  private void buildRenderParams(ParticleItem paramParticleItem)
  {
    if (paramParticleItem.particles != null)
    {
      Particle[] arrayOfParticle = paramParticleItem.particles;
      int m = arrayOfParticle.length;
      int i = 0;
      if (i < m)
      {
        Particle localParticle = arrayOfParticle[i];
        RenderParam localRenderParam;
        float f1;
        float f2;
        if ((localParticle.texture > 0) && (localParticle.alive))
        {
          localRenderParam = new RenderParam();
          localRenderParam.texture = localParticle.texture;
          switch (paramParticleItem.emissionMode)
          {
          default: 
            f1 = 0.0F;
            f2 = 0.0F;
          }
        }
        for (;;)
        {
          int k = 0;
          int j = 0;
          if (paramParticleItem.stickerItem.anchorPoint != null)
          {
            k = paramParticleItem.stickerItem.anchorPoint[0];
            j = paramParticleItem.stickerItem.anchorPoint[1];
          }
          f1 -= k;
          f2 -= j;
          float f3 = f1 + paramParticleItem.stickerItem.width * paramParticleItem.screenRatioScale;
          float f4 = paramParticleItem.stickerItem.height * paramParticleItem.screenRatioScale + f2;
          localRenderParam.texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
          localRenderParam.texScale = localParticle.scale;
          localRenderParam.texAnchor[0] = ((f1 + f3) / 2.0F - this.width / 2);
          localRenderParam.texAnchor[1] = ((f4 + f2) / 2.0F - this.height / 2);
          localRenderParam.texRotate[2] = localParticle.rotate;
          localRenderParam.position = AlgoUtils.calPositionsTriangles(f1, f4, f3, f2, this.width, this.height);
          this.renderParams.add(localRenderParam);
          i += 1;
          break;
          f1 = localParticle.startX;
          float f5 = localParticle.positionX;
          float f6 = paramParticleItem.screenRatioScale;
          f2 = localParticle.startY;
          f3 = localParticle.positionY;
          f4 = paramParticleItem.screenRatioScale;
          f1 = f5 * f6 + f1;
          f2 += f3 * f4;
          continue;
          f1 = paramParticleItem.emitterX;
          f5 = localParticle.positionX;
          f6 = paramParticleItem.screenRatioScale;
          f2 = paramParticleItem.emitterY;
          f3 = localParticle.positionY;
          f4 = paramParticleItem.screenRatioScale;
          f1 = f5 * f6 + f1;
          f2 += f3 * f4;
          continue;
          f1 = localParticle.positionX;
          f4 = paramParticleItem.screenRatioScale;
          f2 = localParticle.positionY;
          f3 = paramParticleItem.screenRatioScale;
          f1 = f4 * f1;
          f2 *= f3;
        }
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
        if (localStickerItem.wmGroupConfigCopies != null)
        {
          localParticleItem.wmGroupCopies = new ArrayList();
          Iterator localIterator = localStickerItem.wmGroupConfigCopies.iterator();
          while (localIterator.hasNext())
          {
            WMGroup localWMGroup = new WMGroup((WMGroupConfig)localIterator.next());
            localWMGroup.init();
            localParticleItem.wmGroupCopies.add(localWMGroup);
          }
        }
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
      ParticleItem localParticleItem = arrayOfParticleItem[i];
      if (localParticleItem.particles != null)
      {
        HashSet localHashSet = new HashSet();
        Particle[] arrayOfParticle = localParticleItem.particles;
        int m = arrayOfParticle.length;
        int j = 0;
        while (j < m)
        {
          Particle localParticle = arrayOfParticle[j];
          if (localParticle.alive) {
            localHashSet.add(Integer.valueOf(localParticle.wmGroupId));
          }
          j += 1;
        }
        j = 0;
        while (j < localParticleItem.wmGroupCopies.size())
        {
          if ((!localHashSet.contains(Integer.valueOf(j))) && (!((WMGroup)localParticleItem.wmGroupCopies.get(j)).isLock()) && ((j != localParticleItem.curWMGroupId) || ((j == localParticleItem.curWMGroupId) && (localParticleItem.takenByParticle)))) {
            localParticleItem.recycleWMGroup(j);
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
    if ((this.particleItems != null) && (paramInt < this.particleItems.length)) {
      this.particleItems[paramInt].reset();
    }
  }
  
  private void resetAll()
  {
    this.particleSystem2D.reset();
    int i = 0;
    while (i < this.particleItems.length)
    {
      this.particleItems[i].reset();
      i += 1;
    }
  }
  
  private void updateCurEmitterPos(List<PointF> paramList1, List<PointF> paramList2)
  {
    ParticleItem[] arrayOfParticleItem = this.particleItems;
    int k = arrayOfParticleItem.length;
    int i = 0;
    if (i < k)
    {
      ParticleItem localParticleItem = arrayOfParticleItem[i];
      StickerItem localStickerItem = localParticleItem.stickerItem;
      if (localStickerItem != null) {}
      switch (localStickerItem.type)
      {
      case 3: 
      default: 
      case 1: 
        for (;;)
        {
          i += 1;
          break;
          int m;
          if (this.width / this.height >= 0.75D)
          {
            int n = (int)(this.width / 0.75D);
            j = (int)(n * localStickerItem.position[1]);
            m = (int)(this.width * localStickerItem.position[0]);
            n = (n - this.height) / 2;
            localParticleItem.emitterX = m;
            localParticleItem.emitterY = (j - n);
            localParticleItem.screenRatioScale = (this.width * 1.0F / 720.0F);
          }
          else
          {
            j = (int)(this.height * 0.75D);
            m = (int)(this.height * localStickerItem.position[1]);
            localParticleItem.emitterX = ((int)(j * localStickerItem.position[0]) - (j - this.width) / 2);
            localParticleItem.emitterY = m;
            localParticleItem.screenRatioScale = (this.height * 1.0F / 960.0F);
          }
        }
      }
      Object localObject;
      label282:
      PointF localPointF;
      if (VideoMaterialUtil.isGestureItem(localStickerItem))
      {
        localObject = paramList2;
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label449;
        }
        localPointF = (PointF)((List)localObject).get(localStickerItem.alignFacePoints[0]);
        if (localStickerItem.alignFacePoints.length != 1) {
          break label451;
        }
      }
      label449:
      label451:
      for (int j = localStickerItem.alignFacePoints[0];; j = localStickerItem.alignFacePoints[1])
      {
        localObject = (PointF)((List)localObject).get(j);
        localObject = new PointF((localPointF.x + ((PointF)localObject).x) / 2.0F, (localPointF.y + ((PointF)localObject).y) / 2.0F);
        if (VideoMaterialUtil.isFaceItem(localStickerItem))
        {
          ((PointF)localObject).x /= this.faceDetScale;
          ((PointF)localObject).y /= this.faceDetScale;
        }
        localParticleItem.emitterX = ((PointF)localObject).x;
        localParticleItem.emitterY = ((PointF)localObject).y;
        break;
        localObject = paramList1;
        break label282;
        break;
      }
    }
  }
  
  private void updateParticleState(ParticleItem paramParticleItem, int paramInt, long paramLong)
  {
    if ((paramParticleItem.particleReachMax) && (paramParticleItem.clearMode == VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (paramParticleItem.lastFrameParticleReachMax)) {
      paramParticleItem.canUpdateTexture = true;
    }
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramParticleItem.canUpdateTexture) || ((paramParticleItem.clearMode == VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (paramParticleItem.lastFrameParticleReachMax)))
    {
      if (paramParticleItem.lockedWMGroups.isEmpty()) {
        break label365;
      }
      localObject1 = new ArrayList();
      localObject2 = paramParticleItem.lockedWMGroups.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (WMGroup)((Iterator)localObject2).next();
        if (((WMGroup)localObject3).isAsyncDrawFinished())
        {
          ((WMGroup)localObject3).updateTexture(paramLong, true, false, true);
          ((WMGroup)localObject3).unlock();
          ((List)localObject1).add(localObject3);
          paramParticleItem.useWMGroup(((WMGroup)localObject3).id);
          paramParticleItem.curTexture = ((WMGroup)localObject3).getCurTexture();
          paramParticleItem.curWMGroupId = ((WMGroup)localObject3).id;
          paramParticleItem.curRepeatCount = 0;
          paramParticleItem.canUpdateTexture = false;
          paramParticleItem.takenByParticle = false;
          if ((paramParticleItem.clearMode == VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (paramParticleItem.lastFrameParticleReachMax))
          {
            this.particleSystem2D.clearParticles(paramInt);
            paramParticleItem.resetWMGroup();
            paramParticleItem.useWMGroup(((WMGroup)localObject3).id);
            localObject3 = paramParticleItem.particles;
            int j = localObject3.length;
            i = 0;
            while (i < j)
            {
              localObject3[i].alive = false;
              i += 1;
            }
            this.particleSystem2D.advance(this.particleItems, this.frameInterval);
            paramParticleItem.lastFrameParticleReachMax = false;
          }
        }
      }
      paramParticleItem.lockedWMGroups.removeAll((Collection)localObject1);
    }
    while (paramParticleItem.particleAlwaysUpdate)
    {
      localObject1 = paramParticleItem.getActiveWMGroups().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WMGroup)((Iterator)localObject1).next();
        if (((WMGroup)localObject2).updateTexture(paramLong, true, false, true)) {
          ((WMGroup)localObject2).unlock();
        }
      }
      label365:
      localObject1 = paramParticleItem.getAvailableWMGroup();
      if (localObject1 != null)
      {
        if (!((WMGroup)localObject1).updateTexture(paramLong, true, false, true)) {
          break label517;
        }
        ((WMGroup)localObject1).unlock();
        paramParticleItem.useWMGroup(((WMGroup)localObject1).id);
        paramParticleItem.curTexture = ((WMGroup)localObject1).getCurTexture();
        paramParticleItem.curWMGroupId = ((WMGroup)localObject1).id;
        paramParticleItem.curRepeatCount = 0;
        paramParticleItem.canUpdateTexture = false;
        paramParticleItem.takenByParticle = false;
      }
      while ((paramParticleItem.clearMode == VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (paramParticleItem.lastFrameParticleReachMax) && (!paramParticleItem.takenByParticle))
      {
        this.particleSystem2D.clearParticles(paramInt);
        paramParticleItem.resetWMGroup();
        paramParticleItem.useWMGroup(paramParticleItem.curWMGroupId);
        localObject1 = paramParticleItem.particles;
        i = localObject1.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1[paramInt].alive = false;
          paramInt += 1;
        }
        label517:
        if (!((WMGroup)localObject1).isLock())
        {
          paramParticleItem.recycleWMGroup(((WMGroup)localObject1).id);
        }
        else
        {
          paramParticleItem.useWMGroup(((WMGroup)localObject1).id);
          paramParticleItem.lockedWMGroups.add(localObject1);
        }
      }
      continue;
      this.particleSystem2D.advance(this.particleItems, this.frameInterval);
      paramParticleItem.lastFrameParticleReachMax = false;
    }
    paramParticleItem = paramParticleItem.getActiveWMGroups().iterator();
    while (paramParticleItem.hasNext()) {
      ((WMGroup)paramParticleItem.next()).updateTexture(paramLong, false, true, true);
    }
  }
  
  private void updateParticleStateAndBuildRenderParams(long paramLong)
  {
    this.renderParams.clear();
    int i = 0;
    if (i < this.particleItems.length)
    {
      ParticleItem localParticleItem = this.particleItems[i];
      if (((this.isBackground) && (localParticleItem.stickerItem.zIndex >= 0)) || ((!this.isBackground) && (localParticleItem.stickerItem.zIndex < 0))) {}
      label142:
      for (;;)
      {
        i += 1;
        break;
        if ((localParticleItem.triggered) && (localParticleItem.wmGroupCopies != null))
        {
          updateParticleState(localParticleItem, i, paramLong);
          buildRenderParams(localParticleItem);
        }
        for (;;)
        {
          if ((localParticleItem.clearMode != VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) || (localParticleItem.lastFrameParticleReachMax)) {
            break label142;
          }
          localParticleItem.lastFrameParticleReachMax = localParticleItem.particleReachMax;
          break;
          reset(i);
        }
      }
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
    Object localObject = this.textRenderItems.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TextRenderItem)((Iterator)localObject).next()).clear();
    }
    if (this.particleItems != null)
    {
      localObject = this.particleItems;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        Iterator localIterator = localObject[i];
        if (localIterator.wmGroupCopies != null)
        {
          localIterator = localIterator.wmGroupCopies.iterator();
          while (localIterator.hasNext()) {
            ((WMGroup)localIterator.next()).clear();
          }
        }
        i += 1;
      }
    }
    this.fastRenderFilter.clearGLSLSelf();
    this.particleSystem2D.release();
    LogicDataManager.getInstance().clearVoiceTexts();
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
      BenchUtil.benchStart(TAG + " fastRenderFilter.render");
      this.fastRenderFilter.render(this.renderParams, paramFrame, true);
      BenchUtil.benchEnd(TAG + " fastRenderFilter.render");
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      BenchUtil.benchStart(TAG + " updatePreview");
      if (this.lastFrameTimestamp != -1L) {
        this.frameInterval = ((int)(paramObject.timestamp - this.lastFrameTimestamp));
      }
      this.lastFrameTimestamp = paramObject.timestamp;
      int i = 0;
      if (i < this.particleItems.length)
      {
        if ((this.renderParticleIds != null) && (this.renderParticleIds.contains(this.particleItems[i].id))) {}
        for (this.particleItems[i].triggered = true;; this.particleItems[i].triggered = false)
        {
          i += 1;
          break;
        }
      }
      BenchUtil.benchStart(TAG + " updateParticles");
      updateParticles(paramObject.facePoints, paramObject.handPoints, paramObject.timestamp);
      BenchUtil.benchEnd(TAG + " updateParticles");
      BenchUtil.benchStart(TAG + " particleSystem2D.advance");
      this.particleSystem2D.advance(this.particleItems, this.frameInterval);
      BenchUtil.benchEnd(TAG + " particleSystem2D.advance");
      BenchUtil.benchStart(TAG + " recycleUnusedWMGroups");
      recycleUnusedWMGroups();
      BenchUtil.benchEnd(TAG + " recycleUnusedWMGroups");
      BenchUtil.benchEnd(TAG + " updatePreview");
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
    if ((this.lastWidth > 0) && (this.lastHeight > 0) && ((paramInt1 != this.lastWidth) || (paramInt2 != this.lastHeight))) {
      resetAll();
    }
    this.lastWidth = paramInt1;
    this.lastHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.VoiceTextFilter
 * JD-Core Version:    0.7.0.1
 */