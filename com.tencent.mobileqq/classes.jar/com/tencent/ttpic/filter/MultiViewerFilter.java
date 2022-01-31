package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTHairAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.util.FrameUtil;
import java.util.Map;
import java.util.Set;

public class MultiViewerFilter
{
  private static final String TAG = MultiViewerFilter.class.getSimpleName();
  private Set<Integer> activeParts;
  private BaseFilter copyFilter;
  private BaseFilter effectFilter;
  private Frame emptyFrame = new Frame();
  private boolean needOriginFrame;
  private int renderId;
  private VideoFilterList videoFilterList;
  
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
    paramFrame = this.videoFilterList.renderCustomEffectFilter(paramFrame, 1);
    paramFrame = this.videoFilterList.updateAndRenderDynamicStickers(paramFrame, paramPTFaceAttr, paramAIAttr);
    BenchUtil.benchEnd(TAG + " videoFilterList.process");
    BenchUtil.benchStart(TAG + " videoFilterList.updateAndRenderStaticStickers");
    paramFrame = this.videoFilterList.updateAndRenderStaticStickers(paramFrame, paramPTFaceAttr);
    paramFrame = this.videoFilterList.renderCustomEffectFilter(paramFrame, 2);
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
  
  public void clear()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.destroy();
    }
    if (this.effectFilter != null) {
      this.effectFilter.ClearGLSL();
    }
    if (this.copyFilter != null) {
      this.copyFilter.ClearGLSL();
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
  
  public int getRenderId()
  {
    return this.renderId;
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
  
  public boolean hasZoomFilter()
  {
    if (this.videoFilterList != null) {
      return this.videoFilterList.hasZoomFilter();
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
  
  public Frame render(Frame paramFrame1, Frame paramFrame2, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, PTHairAttr paramPTHairAttr)
  {
    int i = 0;
    Frame localFrame1;
    Frame localFrame2;
    if (this.needOriginFrame)
    {
      localFrame1 = this.videoFilterList.blurBeforeRender(paramFrame1, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
      localFrame2 = localFrame1;
      paramFrame1 = localFrame1;
      if (this.effectFilter != null)
      {
        BenchUtil.benchStart(TAG + " effectFilter.RenderProcess");
        this.effectFilter.RenderProcess(localFrame1.getTextureId(), paramFrame2.width, paramFrame2.height, -1, 0.0D, paramFrame2);
        BenchUtil.benchEnd(TAG + " effectFilter.RenderProcess");
        paramFrame1 = FrameUtil.getLastRenderFrame(paramFrame2);
        i = 1;
      }
      localFrame1 = paramFrame1;
      if (this.videoFilterList != null)
      {
        paramFrame1 = this.videoFilterList.updateAndRenderBeforeEffectTriggerFilters(paramFrame1, paramPTFaceAttr);
        paramFrame1 = this.videoFilterList.updateAndRenderBeforeComicEffectFilters(paramFrame1, paramPTFaceAttr);
        paramFrame1 = this.videoFilterList.updateAndRenderRapidNet(paramFrame1, paramPTFaceAttr);
        if (this.videoFilterList.getFastFaceStickerFilter() == null) {
          break label323;
        }
        if (i != 0) {
          break label304;
        }
        this.videoFilterList.setMultiViewerSrcTexture(paramFrame1.getTextureId());
        this.videoFilterList.setMultiViewerOutFrame(paramFrame2);
      }
    }
    for (;;)
    {
      localFrame1 = renderStickers(paramFrame1, paramAIAttr, paramPTFaceAttr);
      paramFrame1 = this.videoFilterList.updateAndRenderHairCos(localFrame1, paramPTFaceAttr, paramPTHairAttr);
      paramFrame1 = this.videoFilterList.blurAfterRender(paramFrame1, paramPTFaceAttr, paramPTSegAttr);
      paramFrame1 = this.videoFilterList.undateAndRenderMaskSticker(paramFrame1, paramPTFaceAttr);
      return this.videoFilterList.zoomFrame(paramFrame1);
      this.emptyFrame.bindFrame(-1, paramFrame2.width, paramFrame2.height, 0.0D);
      FrameUtil.clearFrame(this.emptyFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame2.width, paramFrame2.height);
      localFrame1 = this.emptyFrame;
      i = 1;
      localFrame2 = paramFrame1;
      break;
      label304:
      this.videoFilterList.setMultiViewerSrcTexture(0);
      this.videoFilterList.setMultiViewerOutFrame(paramFrame1);
    }
    label323:
    if (i == 0) {
      copyFrame(localFrame2, paramFrame2);
    }
    for (;;)
    {
      localFrame1 = renderStickers(paramFrame2, paramAIAttr, paramPTFaceAttr);
      break;
      paramFrame2 = paramFrame1;
    }
  }
  
  public void reset()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.reset();
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
  
  public void setEffectFilter(BaseFilter paramBaseFilter)
  {
    this.effectFilter = paramBaseFilter;
  }
  
  public void setNeedOriginFrame(boolean paramBoolean)
  {
    this.needOriginFrame = paramBoolean;
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
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.MultiViewerFilter
 * JD-Core Version:    0.7.0.1
 */