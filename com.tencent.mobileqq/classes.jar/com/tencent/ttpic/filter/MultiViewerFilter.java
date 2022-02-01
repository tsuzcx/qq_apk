package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTHairAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.filter.StickersMap;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.openapi.listener.IStickerListener;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.util.FrameUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiViewerFilter
{
  private static final String TAG = MultiViewerFilter.class.getSimpleName();
  private Set<Integer> activeParts;
  private BaseFilter copyFilter;
  private Frame curFrame = null;
  private BaseFilter effectFilter;
  private Frame emptyFrame = new Frame();
  private boolean isSrcRendered = false;
  private PTDetectInfo mDetectInfo;
  private boolean needOriginFrame;
  private int renderId;
  private StickersMap stickersMap = new StickersMap();
  private VideoFilterList videoFilterList;
  
  private PTDetectInfo checkPTDetectInfo(PTDetectInfo paramPTDetectInfo)
  {
    if (this.videoFilterList.isFreezeFrame())
    {
      if (this.mDetectInfo == null)
      {
        this.mDetectInfo = paramPTDetectInfo;
        return paramPTDetectInfo;
      }
      this.mDetectInfo.timestamp = paramPTDetectInfo.timestamp;
      this.mDetectInfo.aiAttr = paramPTDetectInfo.aiAttr;
      return this.mDetectInfo;
    }
    this.mDetectInfo = null;
    return paramPTDetectInfo;
  }
  
  private void copyFrame(Frame paramFrame1, Frame paramFrame2)
  {
    if (this.copyFilter == null)
    {
      this.copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      this.copyFilter.apply();
    }
    this.copyFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame2.width, paramFrame2.height, -1, 0.0D, paramFrame2);
  }
  
  private Frame renderStickers(Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    paramPTFaceAttr.getAllFacePoints();
    paramPTFaceAttr.getAllFaceAngles();
    PTHandAttr localPTHandAttr = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
    if (localPTHandAttr != null) {
      localPTHandAttr.getHandPointList();
    }
    BenchUtil.benchStart(TAG + " videoFilterList.process");
    this.videoFilterList.updateFaceParams(paramAIAttr, paramPTFaceAttr, paramFrame.width);
    paramFrame = this.videoFilterList.updateAndRenderStaticStickersBeforeTransform(paramFrame, paramPTFaceAttr);
    paramFrame = this.videoFilterList.processTransformRelatedFilters(paramFrame, paramPTFaceAttr);
    paramFrame = this.videoFilterList.renderCustomEffectFilter(paramFrame, 100);
    paramFrame = this.videoFilterList.updateAndRenderDynamicStickers(paramFrame, paramPTFaceAttr, paramAIAttr);
    BenchUtil.benchEnd(TAG + " videoFilterList.process");
    BenchUtil.benchStart(TAG + " videoFilterList.updateAndRenderStaticStickers");
    paramFrame = this.videoFilterList.updateAndRenderStaticStickers(paramFrame, paramPTFaceAttr);
    paramFrame = this.videoFilterList.renderCustomEffectFilter(paramFrame, 101);
    BenchUtil.benchEnd(TAG + " videoFilterList.updateAndRenderStaticStickers");
    return paramFrame;
  }
  
  public void ApplyGLSLFilter()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.ApplyGLSLFilter();
    }
    if (this.effectFilter != null) {
      this.effectFilter.applyFilterChain(false, 0.0F, 0.0F);
    }
  }
  
  public void arTracked()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.arTracked();
    }
  }
  
  public void clear()
  {
    this.mDetectInfo = null;
    if (this.videoFilterList != null) {
      this.videoFilterList.destroy();
    }
    if (this.effectFilter != null) {
      this.effectFilter.clearGLSL();
    }
    if (this.copyFilter != null) {
      this.copyFilter.clearGLSL();
    }
    if (this.emptyFrame != null) {
      this.emptyFrame.clear();
    }
  }
  
  public void destroyAudio()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.destroyAudio();
    }
  }
  
  public boolean exportFilamentParams()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.exportFilamentParams();
    }
    return false;
  }
  
  public Frame getCurFrame()
  {
    return this.curFrame;
  }
  
  public float[] getFilamentAssetPosition()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.getFilamentAssetPosition();
    }
    return null;
  }
  
  public int getRenderId()
  {
    return this.renderId;
  }
  
  public StickersMap getStickersMap()
  {
    return this.stickersMap;
  }
  
  public VideoFilterList getVideoFilterList()
  {
    return this.videoFilterList;
  }
  
  public boolean hasFreezeFrameSetting()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.hasFreezeSetting();
    }
    return false;
  }
  
  public boolean hasHand(PTHandAttr paramPTHandAttr)
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.hasHands(paramPTHandAttr);
    }
    return false;
  }
  
  public boolean hasZoomFilter()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.hasZoomFilter();
    }
    return false;
  }
  
  public void hitCharmRangeItem(int paramInt)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.hitCharmRangeItem(paramInt);
    }
  }
  
  public boolean isCosFunEnableGAN()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.isCosFunEnableGAN();
    }
    return false;
  }
  
  public boolean isFilamentModelReady()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.isFilamentModelReady();
    }
    return false;
  }
  
  public int isFreezeFrame()
  {
    int j = 0;
    int i = j;
    if (this.videoFilterList != null)
    {
      i = j;
      if (this.videoFilterList.hasFreezeSetting())
      {
        if (!this.videoFilterList.isFreezeFrame()) {
          break label37;
        }
        i = 2;
      }
    }
    return i;
    label37:
    return 1;
  }
  
  public boolean isSegRequired()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.isSegmentRequired();
    }
    return false;
  }
  
  public boolean needDetectEmotion()
  {
    return false;
  }
  
  public boolean needDetectGender()
  {
    return false;
  }
  
  public boolean needDetectGesture()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.needDetectGesture();
    }
    return false;
  }
  
  public boolean needDetectGestureBonePoint()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.isNeedDetectGestureBonePoint();
    }
    return false;
  }
  
  public boolean needRenderThisPart(int paramInt)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setCurPartInMultView(paramInt);
    }
    return this.activeParts.contains(Integer.valueOf(paramInt));
  }
  
  public void pauseAnimaiton()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.pauseAnimaiton();
    }
  }
  
  public Frame render(Frame paramFrame1, Frame paramFrame2, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, PTHairAttr paramPTHairAttr)
  {
    int i = 0;
    Frame localFrame2 = this.videoFilterList.renderMaskToFrame(paramFrame1);
    if (this.needOriginFrame)
    {
      paramFrame1 = this.videoFilterList.blurBeforeRender(localFrame2, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
      localFrame2 = paramFrame1;
      Frame localFrame1 = paramFrame1;
      if (this.effectFilter != null)
      {
        BenchUtil.benchStart(TAG + " effectFilter.RenderProcess");
        this.effectFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame2.width, paramFrame2.height, -1, 0.0D, paramFrame2);
        BenchUtil.benchEnd(TAG + " effectFilter.RenderProcess");
        localFrame1 = FrameUtil.getLastRenderFrame(paramFrame2);
        i = 1;
      }
      paramFrame1 = localFrame1;
      if (this.videoFilterList != null)
      {
        paramFrame1 = this.videoFilterList.updateAndRenderBeforeEffectTriggerFilters(localFrame1, paramPTFaceAttr);
        paramFrame1 = this.videoFilterList.updateAndRenderBeforeComicEffectFilters(paramFrame1, paramPTFaceAttr);
        localFrame1 = this.videoFilterList.updateAndRenderStylyFilters(1, paramFrame1);
        if (paramFrame1 == localFrame1) {
          break label477;
        }
        i = 1;
        paramFrame1 = localFrame1;
      }
    }
    label477:
    for (;;)
    {
      if (this.videoFilterList.getFastFaceStickerFilter() != null)
      {
        if (i == 0)
        {
          this.videoFilterList.setMultiViewerSrcTexture(paramFrame1.getTextureId());
          this.videoFilterList.setMultiViewerOutFrame(paramFrame2);
        }
        for (;;)
        {
          paramFrame1 = renderStickers(paramFrame1, paramAIAttr, paramPTFaceAttr);
          paramFrame2 = paramFrame1;
          if (!this.videoFilterList.isCosFunEnableGAN())
          {
            paramFrame1 = this.videoFilterList.updateAndRenderRapidNet(paramFrame1, paramPTFaceAttr);
            paramFrame1 = this.videoFilterList.updateAndRenderStyleChild(paramFrame1, paramPTFaceAttr);
            paramFrame2 = this.videoFilterList.updateAndRenderStyleChildWarp(paramFrame1, paramPTFaceAttr);
          }
          paramFrame1 = renderFilament(this.videoFilterList.updateAndRenderHairCos(paramFrame2, paramPTFaceAttr, paramPTHairAttr), paramPTFaceAttr);
          paramFrame1 = this.videoFilterList.blurAfterRender(paramFrame1, paramPTFaceAttr, paramPTSegAttr);
          paramFrame1 = this.videoFilterList.undateAndRenderMaskSticker(paramFrame1, paramPTFaceAttr, paramAIAttr);
          paramFrame1 = this.videoFilterList.updateAndRenderStylyFilters(2, paramFrame1);
          paramFrame1 = this.videoFilterList.UKYOGameRender(paramFrame1);
          paramFrame1 = this.videoFilterList.renderCustomGroup(paramFrame1);
          paramFrame1 = this.videoFilterList.updateAndRenderPluginFilter(paramFrame1);
          paramFrame1 = this.videoFilterList.updateAndRenderDepthSmokeItems(paramFrame1);
          paramFrame1 = this.videoFilterList.updateAndRenderUVEditItems(paramFrame1);
          return this.videoFilterList.zoomFrame(paramFrame1);
          this.emptyFrame.bindFrame(-1, paramFrame2.width, paramFrame2.height, 0.0D);
          FrameUtil.clearFrame(this.emptyFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame2.width, paramFrame2.height);
          paramFrame1 = this.emptyFrame;
          i = 1;
          break;
          this.videoFilterList.setMultiViewerSrcTexture(0);
          this.videoFilterList.setMultiViewerOutFrame(paramFrame1);
        }
      }
      if (i == 0) {
        copyFrame(localFrame2, paramFrame2);
      }
      for (;;)
      {
        paramFrame1 = renderStickers(paramFrame2, paramAIAttr, paramPTFaceAttr);
        break;
        paramFrame2 = paramFrame1;
      }
    }
  }
  
  public Frame renderBlurAfter(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.blurAfterRender(paramFrame, paramPTFaceAttr, paramPTSegAttr);
    }
    return localFrame;
  }
  
  public Frame renderBlurBefore(Frame paramFrame1, Frame paramFrame2, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    if (this.needOriginFrame) {
      return this.videoFilterList.blurBeforeRender(paramFrame1, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
    }
    this.emptyFrame.bindFrame(-1, paramFrame2.width, paramFrame2.height, 0.0D);
    FrameUtil.clearFrame(this.emptyFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame2.width, paramFrame2.height);
    paramFrame1 = this.emptyFrame;
    this.isSrcRendered = true;
    return paramFrame1;
  }
  
  public Frame renderComicEffectBefore(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderBeforeComicEffectFilters(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderCrazyFaceFilter(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderCrazyFace(paramFrame, paramList, paramList1);
    }
    return localFrame;
  }
  
  public Frame renderCustomFilter(Frame paramFrame, int paramInt)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.renderCustomEffectFilter(paramFrame, paramInt);
    }
    return localFrame;
  }
  
  public Frame renderCustomGroup(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.renderCustomGroup(paramFrame);
    }
    return localFrame;
  }
  
  public Frame renderDepthSmokeFilter(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderDepthSmokeItems(paramFrame);
    }
    return localFrame;
  }
  
  public Frame renderDynamicStickers(Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null)
    {
      localFrame = paramFrame;
      if (paramFrame != null) {
        localFrame = this.videoFilterList.updateAndRenderDynamicStickersPluggable(paramFrame, paramPTFaceAttr, paramAIAttr);
      }
    }
    return localFrame;
  }
  
  public Frame renderEffectFilter(Frame paramFrame1, Frame paramFrame2)
  {
    if (this.effectFilter != null)
    {
      BenchUtil.benchStart(TAG + " effectFilter.RenderProcess");
      this.effectFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame2.width, paramFrame2.height, -1, 0.0D, paramFrame2);
      BenchUtil.benchEnd(TAG + " effectFilter.RenderProcess");
      paramFrame1 = FrameUtil.getLastRenderFrame(paramFrame2);
      this.isSrcRendered = true;
      return paramFrame1;
    }
    if (this.copyFilter == null)
    {
      this.copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      this.copyFilter.apply();
    }
    this.copyFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, paramFrame2.width, paramFrame2.height, -1, 0.0D, paramFrame2);
    return paramFrame2;
  }
  
  public Frame renderEffectTriggerBefore(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderBeforeEffectTriggerFilters(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderFaceSwitchFilter(Frame paramFrame, List<List<PointF>> paramList, Set<Integer> paramSet)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderFaceSwitch(paramFrame, paramList, paramSet);
    }
    return localFrame;
  }
  
  public Frame renderFilament(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderFilamentFilter(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderHairCos(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTHairAttr paramPTHairAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderHairCos(paramFrame, paramPTFaceAttr, paramPTHairAttr);
    }
    return localFrame;
  }
  
  public Frame renderMaskFrame(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.renderMaskToFrame(paramFrame);
    }
    return localFrame;
  }
  
  public Frame renderMaskSticker(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.undateAndRenderMaskSticker(paramFrame, paramPTFaceAttr, paramAIAttr);
    }
    return localFrame;
  }
  
  public Frame renderParticleStatic(Frame paramFrame, PTDetectInfo paramPTDetectInfo, List<PointF> paramList)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateParticleStatic(paramFrame, paramPTDetectInfo, paramList);
    }
    return localFrame;
  }
  
  public Frame renderPhantomFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderPhantomFilter(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderPlugin(Frame paramFrame1, Frame paramFrame2, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, PTHairAttr paramPTHairAttr)
  {
    return this.stickersMap.chainStickerFilters(this, paramFrame1, paramFrame2, paramPTFaceAttr, paramPTSegAttr, paramAIAttr, paramPTHairAttr);
  }
  
  public Frame renderPluginFilter(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderPluginFilter(paramFrame);
    }
    return localFrame;
  }
  
  public Frame renderRapidNet(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null)
    {
      paramFrame = this.videoFilterList.updateAndRenderRapidNet(paramFrame, paramPTFaceAttr);
      localFrame = this.videoFilterList.updateAndRenderStyleChild(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderStaticStickerBefore(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderStaticStickersBeforeTransform(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderStaticStickers(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderStaticStickers(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderStyleChild(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderStyleChild(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderTransform(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.processTransformRelatedFilters(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderUVEditFilter(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.updateAndRenderUVEditItems(paramFrame);
    }
    return localFrame;
  }
  
  public Frame renderZoomFilter(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.videoFilterList != null) {
      localFrame = this.videoFilterList.zoomFrame(paramFrame);
    }
    return localFrame;
  }
  
  public void reset()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.reset();
    }
    this.mDetectInfo = null;
  }
  
  public void resumeAnimation()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.resumeAnimation();
    }
  }
  
  public void setActiveParts(Set<Integer> paramSet)
  {
    this.activeParts = paramSet;
  }
  
  public void setAllFrameFreeze(boolean paramBoolean)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setAllFrameFreeze(paramBoolean);
    }
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setAudioPause(paramBoolean);
    }
  }
  
  public void setDownEventUnProjectionPoint(ArrayList<float[]> paramArrayList)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setDownEventUnProjectionPoint(paramArrayList);
    }
  }
  
  public void setEffectFilter(BaseFilter paramBaseFilter)
  {
    this.effectFilter = paramBaseFilter;
  }
  
  public void setFastStickerConfig(Frame paramFrame1, Frame paramFrame2, Frame paramFrame3)
  {
    if ((this.videoFilterList == null) || (paramFrame1 == null)) {}
    do
    {
      return;
      if (this.videoFilterList.getFastFaceStickerFilter() != null)
      {
        if (!this.isSrcRendered)
        {
          this.videoFilterList.setMultiViewerSrcTexture(paramFrame1.getTextureId());
          this.videoFilterList.setMultiViewerOutFrame(paramFrame2);
          return;
        }
        this.videoFilterList.setMultiViewerSrcTexture(0);
        this.videoFilterList.setMultiViewerOutFrame(paramFrame1);
        return;
      }
    } while (this.isSrcRendered);
    copyFrame(paramFrame3, paramFrame2);
  }
  
  public void setNeedOriginFrame(boolean paramBoolean)
  {
    this.needOriginFrame = paramBoolean;
  }
  
  public void setParam(String paramString, Object paramObject)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setParam(paramString, paramObject);
    }
  }
  
  public void setRatio(float paramFloat)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setRatio(paramFloat);
    }
  }
  
  public void setRenderId(int paramInt)
  {
    this.renderId = paramInt;
  }
  
  public void setScreenMidPoint(float[] paramArrayOfFloat)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setScreenMidPoint(paramArrayOfFloat);
    }
  }
  
  public void setStickerListener(int paramInt, IStickerListener paramIStickerListener)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setStickerListener(paramInt, paramIStickerListener);
    }
  }
  
  public void setStickersMap(List<String> paramList)
  {
    this.stickersMap.setRenderOrder(paramList);
  }
  
  public void setTouchRotate(float[] paramArrayOfFloat)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setTouchRotate(paramArrayOfFloat);
    }
  }
  
  public void setTouchScale(float paramFloat)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setTouchScale(paramFloat);
    }
  }
  
  public void setUnProjectionHitPoint(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setUnProjectionHitPoint(paramArrayOfFloat, paramBoolean);
    }
  }
  
  public void setVideoFilterList(VideoFilterList paramVideoFilterList)
  {
    this.videoFilterList = paramVideoFilterList;
  }
  
  public void updateCurrentTriggerParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, AIAttr paramAIAttr)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.updateCurrentTriggerParam(paramMap, paramSet, paramAIAttr);
    }
  }
  
  public void updateFaceParams(Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    if (paramFrame == null) {
      return;
    }
    this.videoFilterList.updateFaceParams(paramAIAttr, paramPTFaceAttr, paramFrame.width);
  }
  
  public void updateTriggerManager(PTDetectInfo paramPTDetectInfo)
  {
    if (this.videoFilterList != null)
    {
      paramPTDetectInfo = checkPTDetectInfo(paramPTDetectInfo);
      this.videoFilterList.updateTriggerManager(paramPTDetectInfo);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.MultiViewerFilter
 * JD-Core Version:    0.7.0.1
 */