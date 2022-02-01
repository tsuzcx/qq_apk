package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.MultiViewerFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTHairAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StickersMap
{
  private static final String TAG = "StickersMap";
  public List<String> mStickerChain;
  private List<String> mStickerOrderList = new ArrayList();
  
  public StickersMap()
  {
    setDefaultOrder();
  }
  
  private void setDefaultOrder()
  {
    this.mStickerOrderList.clear();
    this.mStickerOrderList.add("fabbyStroke");
    this.mStickerOrderList.add("blurEffectBefore");
    this.mStickerOrderList.add("styleChange");
    this.mStickerOrderList.add("triggerLutBefore");
    this.mStickerOrderList.add("comicBefore");
    this.mStickerOrderList.add("lutBefore");
    this.mStickerOrderList.add("hairCos");
    this.mStickerOrderList.add("skySegment");
    this.mStickerOrderList.add("stickerBefore");
    this.mStickerOrderList.add("faceoff");
    this.mStickerOrderList.add("customBefore");
    this.mStickerOrderList.add("dynamic");
    this.mStickerOrderList.add("styleFilterBefore");
    this.mStickerOrderList.add("faceSwap");
    this.mStickerOrderList.add("faceAverage");
    this.mStickerOrderList.add("faceHeadCrop");
    this.mStickerOrderList.add("mesh");
    this.mStickerOrderList.add("filament");
    this.mStickerOrderList.add("phantom");
    this.mStickerOrderList.add("customAfter");
    this.mStickerOrderList.add("customGroup");
    this.mStickerOrderList.add("styleFilterAfter");
    this.mStickerOrderList.add("stickerAfter");
    this.mStickerOrderList.add("particle");
    this.mStickerOrderList.add("lutAfter");
    this.mStickerOrderList.add("expression");
    this.mStickerOrderList.add("blingbling");
    this.mStickerOrderList.add("tdParticle");
    this.mStickerOrderList.add("filamentParticle");
    this.mStickerOrderList.add("comicAfter");
    this.mStickerOrderList.add("triggerLutAfter");
    this.mStickerOrderList.add("zoom");
    this.mStickerOrderList.add("blurEffectAfter");
    this.mStickerOrderList.add("mask");
    this.mStickerOrderList.add("crazyFace");
    this.mStickerOrderList.add("multiview");
    this.mStickerOrderList.add("background");
    this.mStickerOrderList.add("mv");
    this.mStickerOrderList.add("styleChangeWarp");
  }
  
  public Frame chainStickerFilters(AESticker paramAESticker, Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    paramAESticker.setAIAttr(paramAIAttr);
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    List localList3 = paramPTFaceAttr.getStarPoints();
    Object localObject1 = paramPTFaceAttr.getFaceActionCounter();
    int j = paramPTFaceAttr.getRotation();
    int i = paramPTFaceAttr.getRotation();
    long l = paramAESticker.getUpdateTimeStamp(paramPTFaceAttr.getTimeStamp());
    paramPTFaceAttr.setTimeStamp(l);
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    if (paramAIAttr != null)
    {
      localObject2 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (localObject2 != null)
      {
        localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
        if (localObject2 == null) {}
      }
    }
    for (Object localObject2 = ((PTHandAttr)localObject2).getHandPointList();; localObject2 = null)
    {
      Object localObject3 = new PTDetectInfo.Builder().aiAttr(paramAIAttr).triggeredExpression(localSet).handPoints((List)localObject2).faceActionCounter((Map)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).faceDetector(paramPTFaceAttr.getFaceDetector()).starPoints(localList3).phoneAngle((i + 360) % 360).timestamp(l);
      localObject1 = localObject3;
      if (localList1 != null)
      {
        localObject1 = localObject3;
        if (localList1.size() > 0) {
          localObject1 = ((PTDetectInfo.Builder)localObject3).facePoints((List)localList1.get(0));
        }
      }
      if ((localList2 != null) && (localList2.size() > 0)) {
        localObject1 = ((PTDetectInfo.Builder)localObject1).faceAngles((float[])localList2.get(0));
      }
      for (;;)
      {
        PTDetectInfo localPTDetectInfo = ((PTDetectInfo.Builder)localObject1).build();
        TouchTriggerManager.getInstance().updateTouchTriggerState(localPTDetectInfo);
        TriggerStateManager.getInstance().setPTDetectInfo(localPTDetectInfo);
        TriggerStateManager.getInstance().updateAllTriggerState();
        HashMap localHashMap = new HashMap();
        if (paramAESticker == null) {
          return paramFrame;
        }
        Iterator localIterator = this.mStickerOrderList.iterator();
        localObject3 = paramFrame;
        localObject1 = paramFrame;
        paramFrame = (Frame)localObject3;
        while (localIterator.hasNext())
        {
          localObject3 = (String)localIterator.next();
          switch (((String)localObject3).hashCode())
          {
          default: 
            label652:
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              break;
            case 0: 
              paramFrame = paramAESticker.renderBlurBefore(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
              break;
              if (!((String)localObject3).equals("blurEffectBefore")) {
                break label652;
              }
              i = 0;
              continue;
              if (!((String)localObject3).equals("mesh")) {
                break label652;
              }
              i = 1;
              continue;
              if (!((String)localObject3).equals("fabbyStroke")) {
                break label652;
              }
              i = 2;
              continue;
              if (!((String)localObject3).equals("particle")) {
                break label652;
              }
              i = 3;
              continue;
              if (!((String)localObject3).equals("faceHeadCrop")) {
                break label652;
              }
              i = 4;
              continue;
              if (!((String)localObject3).equals("background")) {
                break label652;
              }
              i = 5;
              continue;
              if (!((String)localObject3).equals("lutBefore")) {
                break label652;
              }
              i = 6;
              continue;
              if (!((String)localObject3).equals("hairCos")) {
                break label652;
              }
              i = 7;
              continue;
              if (!((String)localObject3).equals("skySegment")) {
                break label652;
              }
              i = 8;
              continue;
              if (!((String)localObject3).equals("comicBefore")) {
                break label652;
              }
              i = 9;
              continue;
              if (!((String)localObject3).equals("styleFilterBefore")) {
                break label652;
              }
              i = 10;
              continue;
              if (!((String)localObject3).equals("styleFilterAfter")) {
                break label652;
              }
              i = 11;
              continue;
              if (!((String)localObject3).equals("triggerLutBefore")) {
                break label652;
              }
              i = 12;
              continue;
              if (!((String)localObject3).equals("stickerBefore")) {
                break label652;
              }
              i = 13;
              continue;
              if (!((String)localObject3).equals("blingbling")) {
                break label652;
              }
              i = 14;
              continue;
              if (!((String)localObject3).equals("filament")) {
                break label652;
              }
              i = 15;
              continue;
              if (!((String)localObject3).equals("styleChange")) {
                break label652;
              }
              i = 16;
              continue;
              if (!((String)localObject3).equals("styleChangeWarp")) {
                break label652;
              }
              i = 17;
              continue;
              if (!((String)localObject3).equals("dynamic")) {
                break label652;
              }
              i = 18;
              continue;
              if (!((String)localObject3).equals("faceSwap")) {
                break label652;
              }
              i = 19;
              continue;
              if (!((String)localObject3).equals("faceAverage")) {
                break label652;
              }
              i = 20;
              continue;
              if (!((String)localObject3).equals("phantom")) {
                break label652;
              }
              i = 21;
              continue;
              if (!((String)localObject3).equals("tdParticle")) {
                break label652;
              }
              i = 22;
              continue;
              if (!((String)localObject3).equals("comicAfter")) {
                break label652;
              }
              i = 23;
              continue;
              if (!((String)localObject3).equals("triggerLutAfter")) {
                break label652;
              }
              i = 24;
              continue;
              if (!((String)localObject3).equals("multiview")) {
                break label652;
              }
              i = 25;
              continue;
              if (!((String)localObject3).equals("filamentParticle")) {
                break label652;
              }
              i = 26;
              continue;
              if (!((String)localObject3).equals("stickerAfter")) {
                break label652;
              }
              i = 27;
              continue;
              if (!((String)localObject3).equals("lutAfter")) {
                break label652;
              }
              i = 28;
              continue;
              if (!((String)localObject3).equals("expression")) {
                break label652;
              }
              i = 29;
              continue;
              if (!((String)localObject3).equals("zoom")) {
                break label652;
              }
              i = 30;
              continue;
              if (!((String)localObject3).equals("mv")) {
                break label652;
              }
              i = 31;
              continue;
              if (!((String)localObject3).equals("blurEffectAfter")) {
                break label652;
              }
              i = 32;
              continue;
              if (!((String)localObject3).equals("crazyFace")) {
                break label652;
              }
              i = 33;
              continue;
              if (!((String)localObject3).equals("faceoff")) {
                break label652;
              }
              i = 34;
              continue;
              if (!((String)localObject3).equals("customGroup")) {
                break label652;
              }
              i = 35;
            }
          }
          localObject1 = paramAESticker.processTransformRelatedFiltersPluggable(paramAESticker.renderFaceTransform(paramFrame), paramPTFaceAttr, paramAIAttr, localSet);
          paramFrame = (Frame)localObject1;
          continue;
          paramFrame = paramAESticker.renderFabbyStrokeShake(paramFrame, paramPTFaceAttr, paramPTSegAttr);
          continue;
          paramAESticker.renderARFilter(paramFrame);
          continue;
          paramFrame = paramAESticker.renderHeadCropFilter(paramFrame, paramPTFaceAttr);
          continue;
          paramFrame = paramAESticker.renderBgFilter(paramFrame, paramPTFaceAttr);
          continue;
          paramFrame = paramAESticker.renderEffectFilterBefore(paramFrame);
          continue;
          paramFrame = paramAESticker.renderHairCos(paramFrame, paramPTFaceAttr, paramAIAttr);
          continue;
          paramFrame = paramAESticker.renderSkyFilter(paramFrame, paramPTFaceAttr, paramAIAttr);
          continue;
          paramFrame = paramAESticker.renderComicEffectBefore(paramFrame, paramPTFaceAttr);
          continue;
          paramFrame = paramAESticker.renderStyleFilter(1, paramFrame);
          continue;
          paramFrame = paramAESticker.renderStyleFilter(2, paramFrame);
          continue;
          paramFrame = paramAESticker.renderEffectTriggerBefore(paramFrame, paramPTFaceAttr);
          continue;
          paramFrame = paramAESticker.renderStickerBefore(paramFrame, paramPTFaceAttr);
          continue;
          paramFrame = paramAESticker.renderBlingFilter(paramFrame, paramPTFaceAttr, localPTDetectInfo, localList3);
          continue;
          paramFrame = paramAESticker.renderFilament(paramFrame, paramPTFaceAttr);
          continue;
          if (!paramAESticker.isCosFunEnableGAN())
          {
            paramFrame = paramAESticker.renderRapidNet(paramFrame, paramPTFaceAttr);
            continue;
            if (!paramAESticker.isCosFunEnableGAN())
            {
              paramFrame = paramAESticker.renderStyleWarp(paramFrame, paramPTFaceAttr);
              continue;
              paramFrame = paramAESticker.renderDynamicFilter(paramFrame, paramPTFaceAttr, paramAIAttr);
              continue;
              paramFrame = paramAESticker.renderFaceSwitchFilter(paramFrame, localList1, localSet);
              continue;
              paramFrame = paramAESticker.renderCrazyFaceFilter(paramFrame, localList1, localList2);
              continue;
              paramFrame = paramAESticker.renderPhantomFilter(paramFrame, paramPTFaceAttr);
              continue;
              paramFrame = paramAESticker.renderParticleStatic(paramFrame, localPTDetectInfo, (List)localObject2);
              continue;
              paramFrame = paramAESticker.renderComicEffectAfter(paramFrame, paramPTFaceAttr);
              continue;
              paramFrame = paramAESticker.renderEffectTriggerAfter(paramFrame, paramPTFaceAttr);
              continue;
              paramAESticker.renderMultiViewer(paramFrame, paramPTFaceAttr, paramAIAttr, paramPTSegAttr, localHashMap);
              continue;
              paramFrame = paramAESticker.renderFilamentParticle(paramFrame, paramPTFaceAttr);
              continue;
              paramFrame = paramAESticker.renderStickerAfter(paramFrame, paramPTFaceAttr);
              continue;
              paramFrame = paramAESticker.renderEffectFilterAfter(paramFrame);
              continue;
              paramFrame = paramAESticker.renderActFilter(paramFrame, localList1, localList2, j, paramPTFaceAttr);
              continue;
              paramFrame = paramAESticker.renderZoomFilter(paramFrame, localHashMap);
              continue;
              if (localHashMap.isEmpty()) {
                localHashMap.put(Integer.valueOf(0), paramFrame);
              }
              paramFrame = paramAESticker.renderFabbyMVFilter((Frame)localObject1, paramAIAttr, localHashMap, localSet, paramPTFaceAttr);
              continue;
              paramFrame = paramAESticker.renderAfterBlur(paramFrame, paramPTFaceAttr, paramPTSegAttr);
              continue;
              paramFrame = paramAESticker.renderCosFun(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
              continue;
              paramFrame = paramAESticker.renderFaceOff(paramFrame, paramPTFaceAttr, paramAIAttr);
              continue;
              paramFrame = paramAESticker.renderCustomGroup(paramFrame);
            }
          }
        }
        paramAESticker.clearTouchPoint();
        paramAESticker.unclockHairMaskFrame();
        return paramFrame;
      }
    }
  }
  
  public Frame chainStickerFilters(MultiViewerFilter paramMultiViewerFilter, Frame paramFrame1, Frame paramFrame2, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr, PTHairAttr paramPTHairAttr)
  {
    List localList2 = paramPTFaceAttr.getAllFacePoints();
    List localList3 = paramPTFaceAttr.getAllFaceAngles();
    long l = paramPTFaceAttr.getTimeStamp();
    Object localObject1 = paramPTFaceAttr.getAllFaceAngles();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    Object localObject2 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
    List localList1;
    if (localObject2 != null)
    {
      localList1 = ((PTHandAttr)localObject2).getHandPointList();
      localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
    }
    for (;;)
    {
      localObject2 = AIActionCounter.getActions(AEDetectorType.HAND);
      localObject2 = new PTDetectInfo.Builder().handPoints(localList1).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handActionCounter((Map)localObject2).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector());
      PTDetectInfo localPTDetectInfo;
      label192:
      int i;
      if (((List)localObject1).size() > 0)
      {
        localObject1 = (float[])((List)localObject1).get(0);
        localPTDetectInfo = ((PTDetectInfo.Builder)localObject2).faceAngles((float[])localObject1).aiAttr(paramAIAttr).build();
        Iterator localIterator = this.mStickerOrderList.iterator();
        localObject2 = paramFrame1;
        localObject1 = paramFrame2;
        paramFrame2 = (Frame)localObject2;
        if (!localIterator.hasNext()) {
          break label1189;
        }
        localObject2 = (String)localIterator.next();
        paramMultiViewerFilter.setFastStickerConfig(paramFrame2, (Frame)localObject1, paramFrame1);
        paramMultiViewerFilter.updateFaceParams(paramFrame2, paramAIAttr, paramPTFaceAttr);
        switch (((String)localObject2).hashCode())
        {
        default: 
          label408:
          i = -1;
          label411:
          switch (i)
          {
          }
          break;
        }
      }
      for (;;)
      {
        break label192;
        localObject1 = null;
        break;
        if (!((String)localObject2).equals("blurEffectBefore")) {
          break label408;
        }
        i = 0;
        break label411;
        if (!((String)localObject2).equals("mesh")) {
          break label408;
        }
        i = 1;
        break label411;
        if (!((String)localObject2).equals("lutBefore")) {
          break label408;
        }
        i = 2;
        break label411;
        if (!((String)localObject2).equals("hairCos")) {
          break label408;
        }
        i = 3;
        break label411;
        if (!((String)localObject2).equals("comicBefore")) {
          break label408;
        }
        i = 4;
        break label411;
        if (!((String)localObject2).equals("triggerLutBefore")) {
          break label408;
        }
        i = 5;
        break label411;
        if (!((String)localObject2).equals("stickerBefore")) {
          break label408;
        }
        i = 6;
        break label411;
        if (!((String)localObject2).equals("styleChange")) {
          break label408;
        }
        i = 7;
        break label411;
        if (!((String)localObject2).equals("customBefore")) {
          break label408;
        }
        i = 8;
        break label411;
        if (!((String)localObject2).equals("dynamic")) {
          break label408;
        }
        i = 9;
        break label411;
        if (!((String)localObject2).equals("faceSwap")) {
          break label408;
        }
        i = 10;
        break label411;
        if (!((String)localObject2).equals("faceAverage")) {
          break label408;
        }
        i = 11;
        break label411;
        if (!((String)localObject2).equals("phantom")) {
          break label408;
        }
        i = 12;
        break label411;
        if (!((String)localObject2).equals("tdParticle")) {
          break label408;
        }
        i = 13;
        break label411;
        if (!((String)localObject2).equals("stickerAfter")) {
          break label408;
        }
        i = 14;
        break label411;
        if (!((String)localObject2).equals("customAfter")) {
          break label408;
        }
        i = 15;
        break label411;
        if (!((String)localObject2).equals("customGroup")) {
          break label408;
        }
        i = 16;
        break label411;
        if (!((String)localObject2).equals("zoom")) {
          break label408;
        }
        i = 17;
        break label411;
        if (!((String)localObject2).equals("blurEffectAfter")) {
          break label408;
        }
        i = 18;
        break label411;
        if (!((String)localObject2).equals("mask")) {
          break label408;
        }
        i = 19;
        break label411;
        if (paramMultiViewerFilter != null)
        {
          paramFrame2 = paramMultiViewerFilter.renderBlurBefore(paramFrame1, (Frame)localObject1, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
          continue;
          if (paramMultiViewerFilter != null)
          {
            paramFrame2 = paramMultiViewerFilter.renderTransform(paramFrame2, paramPTFaceAttr);
            continue;
            if (paramMultiViewerFilter != null)
            {
              paramFrame2 = paramMultiViewerFilter.renderEffectFilter(paramFrame2, (Frame)localObject1);
              continue;
              if (paramMultiViewerFilter != null)
              {
                paramFrame2 = paramMultiViewerFilter.renderHairCos(paramFrame2, paramPTFaceAttr, paramPTHairAttr);
                continue;
                if (paramMultiViewerFilter != null)
                {
                  paramFrame2 = paramMultiViewerFilter.renderComicEffectBefore(paramFrame2, paramPTFaceAttr);
                  continue;
                  if (paramMultiViewerFilter != null)
                  {
                    paramFrame2 = paramMultiViewerFilter.renderEffectTriggerBefore(paramFrame2, paramPTFaceAttr);
                    continue;
                    if (paramMultiViewerFilter != null)
                    {
                      paramFrame2 = paramMultiViewerFilter.renderStaticStickerBefore(paramFrame2, paramPTFaceAttr);
                      continue;
                      if ((paramMultiViewerFilter != null) && (!paramMultiViewerFilter.isCosFunEnableGAN()))
                      {
                        paramFrame2 = paramMultiViewerFilter.renderRapidNet(paramFrame2, paramPTFaceAttr);
                        continue;
                        if (paramMultiViewerFilter != null)
                        {
                          paramFrame2 = paramMultiViewerFilter.renderCustomFilter(paramFrame2, 100);
                          continue;
                          if (paramMultiViewerFilter != null)
                          {
                            paramFrame2 = paramMultiViewerFilter.renderDynamicStickers(paramFrame2, paramAIAttr, paramPTFaceAttr);
                            continue;
                            if (paramMultiViewerFilter != null)
                            {
                              localObject1 = paramMultiViewerFilter.renderFaceSwitchFilter((Frame)localObject1, localList2, localSet);
                              continue;
                              if (paramMultiViewerFilter != null)
                              {
                                localObject1 = paramMultiViewerFilter.renderCrazyFaceFilter((Frame)localObject1, localList2, localList3);
                                continue;
                                if (paramMultiViewerFilter != null)
                                {
                                  localObject1 = paramMultiViewerFilter.renderPhantomFilter((Frame)localObject1, paramPTFaceAttr);
                                  continue;
                                  if (paramMultiViewerFilter != null)
                                  {
                                    localObject1 = paramMultiViewerFilter.renderParticleStatic((Frame)localObject1, localPTDetectInfo, localList1);
                                    continue;
                                    if (paramMultiViewerFilter != null)
                                    {
                                      paramFrame2 = paramMultiViewerFilter.renderStaticStickers(paramFrame2, paramPTFaceAttr);
                                      continue;
                                      if (paramMultiViewerFilter != null)
                                      {
                                        paramFrame2 = paramMultiViewerFilter.renderCustomFilter(paramFrame2, 101);
                                        continue;
                                        if ((paramMultiViewerFilter != null) && (!paramMultiViewerFilter.isCosFunEnableGAN()))
                                        {
                                          paramFrame2 = paramMultiViewerFilter.renderCustomGroup(paramFrame2);
                                          continue;
                                          if (paramMultiViewerFilter != null)
                                          {
                                            paramFrame2 = paramMultiViewerFilter.renderZoomFilter(paramFrame2);
                                            continue;
                                            if (paramMultiViewerFilter != null)
                                            {
                                              paramFrame2 = paramMultiViewerFilter.renderBlurAfter(paramFrame2, paramPTFaceAttr, paramPTSegAttr);
                                              continue;
                                              if (paramMultiViewerFilter != null) {
                                                paramFrame2 = paramMultiViewerFilter.renderMaskSticker(paramFrame2, paramPTFaceAttr, paramAIAttr);
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label1189:
      return paramFrame2;
      localList1 = null;
    }
  }
  
  public boolean isChangeRenderOrder()
  {
    return (this.mStickerChain != null) && (this.mStickerChain.size() > 0);
  }
  
  public void setRenderOrder(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      this.mStickerChain = paramList;
      paramList = paramList.iterator();
      int i = -1;
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        int j;
        if (i == -1)
        {
          j = this.mStickerOrderList.indexOf(str);
          if (j != -1) {
            i = j;
          }
        }
        else
        {
          j = this.mStickerOrderList.indexOf(str);
          if (j > i) {
            i = j;
          } else if (j < i) {
            if (j >= 0)
            {
              this.mStickerOrderList.remove(j);
              this.mStickerOrderList.add(i, str);
            }
            else
            {
              LogUtils.e("StickersMap", "ERROR: setRenderOrder index < 0");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StickersMap
 * JD-Core Version:    0.7.0.1
 */