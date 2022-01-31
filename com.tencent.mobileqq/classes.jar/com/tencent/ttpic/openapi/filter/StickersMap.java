package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIActionCounter.AI_TYPE;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
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
    this.mStickerOrderList.add("blurEffectBefore");
    this.mStickerOrderList.add("mesh");
    this.mStickerOrderList.add("fabbyStroke");
    this.mStickerOrderList.add("particle");
    this.mStickerOrderList.add("faceHeadCrop");
    this.mStickerOrderList.add("background");
    this.mStickerOrderList.add("lutBefore");
    this.mStickerOrderList.add("hairCos");
    this.mStickerOrderList.add("skySegment");
    this.mStickerOrderList.add("triggerLutBefore");
    this.mStickerOrderList.add("comicBefore");
    this.mStickerOrderList.add("stickerBefore");
    this.mStickerOrderList.add("blingbling");
    this.mStickerOrderList.add("3d");
    this.mStickerOrderList.add("filament");
    this.mStickerOrderList.add("styleChange");
    this.mStickerOrderList.add("customBefore");
    this.mStickerOrderList.add("dynamic");
    this.mStickerOrderList.add("faceSwap");
    this.mStickerOrderList.add("faceAverage");
    this.mStickerOrderList.add("phantom");
    this.mStickerOrderList.add("tdParticle");
    this.mStickerOrderList.add("comicAfter");
    this.mStickerOrderList.add("triggerLutAfter");
    this.mStickerOrderList.add("multiview");
    this.mStickerOrderList.add("filamentParticle");
    this.mStickerOrderList.add("stickerAfter");
    this.mStickerOrderList.add("customAfter");
    this.mStickerOrderList.add("lutAfter");
    this.mStickerOrderList.add("expression");
    this.mStickerOrderList.add("zoom");
    this.mStickerOrderList.add("mv");
    this.mStickerOrderList.add("blurEffectAfter");
    this.mStickerOrderList.add("mask");
    this.mStickerOrderList.add("crazyFace");
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
      Object localObject3 = new PTDetectInfo.Builder().aiAttr(paramAIAttr).triggeredExpression(localSet).handPoints((List)localObject2).faceActionCounter((Map)localObject1).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).faceDetector(paramPTFaceAttr.getFaceDetector()).starPoints(localList3).phoneAngle((i + 360) % 360).timestamp(l);
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
        localObject3 = ((PTDetectInfo.Builder)localObject1).build();
        TouchTriggerManager.getInstance().updateTouchTriggerState((PTDetectInfo)localObject3);
        TriggerStateManager.getInstance().setPTDetectInfo((PTDetectInfo)localObject3);
        TriggerStateManager.getInstance().updateAllTriggerState();
        HashMap localHashMap = new HashMap();
        Iterator localIterator = this.mStickerOrderList.iterator();
        localObject1 = paramFrame;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          switch (str.hashCode())
          {
          default: 
            label600:
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              break;
            case 0: 
              if (paramAESticker == null) {
                break;
              }
              localObject1 = paramAESticker.renderBlurBefore((Frame)localObject1, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
              break;
              if (!str.equals("blurEffectBefore")) {
                break label600;
              }
              i = 0;
              continue;
              if (!str.equals("mesh")) {
                break label600;
              }
              i = 1;
              continue;
              if (!str.equals("fabbyStroke")) {
                break label600;
              }
              i = 2;
              continue;
              if (!str.equals("particle")) {
                break label600;
              }
              i = 3;
              continue;
              if (!str.equals("faceHeadCrop")) {
                break label600;
              }
              i = 4;
              continue;
              if (!str.equals("background")) {
                break label600;
              }
              i = 5;
              continue;
              if (!str.equals("lutBefore")) {
                break label600;
              }
              i = 6;
              continue;
              if (!str.equals("hairCos")) {
                break label600;
              }
              i = 7;
              continue;
              if (!str.equals("skySegment")) {
                break label600;
              }
              i = 8;
              continue;
              if (!str.equals("comicBefore")) {
                break label600;
              }
              i = 9;
              continue;
              if (!str.equals("triggerLutBefore")) {
                break label600;
              }
              i = 10;
              continue;
              if (!str.equals("stickerBefore")) {
                break label600;
              }
              i = 11;
              continue;
              if (!str.equals("blingbling")) {
                break label600;
              }
              i = 12;
              continue;
              if (!str.equals("filament")) {
                break label600;
              }
              i = 13;
              continue;
              if (!str.equals("styleChange")) {
                break label600;
              }
              i = 14;
              continue;
              if (!str.equals("dynamic")) {
                break label600;
              }
              i = 15;
              continue;
              if (!str.equals("faceSwap")) {
                break label600;
              }
              i = 16;
              continue;
              if (!str.equals("faceAverage")) {
                break label600;
              }
              i = 17;
              continue;
              if (!str.equals("phantom")) {
                break label600;
              }
              i = 18;
              continue;
              if (!str.equals("tdParticle")) {
                break label600;
              }
              i = 19;
              continue;
              if (!str.equals("comicAfter")) {
                break label600;
              }
              i = 20;
              continue;
              if (!str.equals("triggerLutAfter")) {
                break label600;
              }
              i = 21;
              continue;
              if (!str.equals("multiview")) {
                break label600;
              }
              i = 22;
              continue;
              if (!str.equals("filamentParticle")) {
                break label600;
              }
              i = 23;
              continue;
              if (!str.equals("stickerAfter")) {
                break label600;
              }
              i = 24;
              continue;
              if (!str.equals("lutAfter")) {
                break label600;
              }
              i = 25;
              continue;
              if (!str.equals("expression")) {
                break label600;
              }
              i = 26;
              continue;
              if (!str.equals("zoom")) {
                break label600;
              }
              i = 27;
              continue;
              if (!str.equals("mv")) {
                break label600;
              }
              i = 28;
              continue;
              if (!str.equals("blurEffectAfter")) {
                break label600;
              }
              i = 29;
              continue;
              if (!str.equals("crazyFace")) {
                break label600;
              }
              i = 30;
            }
          }
          if (paramAESticker != null)
          {
            localObject1 = paramAESticker.renderFaceTransform(paramAESticker.processTransformRelatedFiltersPluggable((Frame)localObject1, paramPTFaceAttr, paramAIAttr, localSet));
            continue;
            if (paramAESticker != null)
            {
              localObject1 = paramAESticker.renderFabbyStrokeShake((Frame)localObject1, paramPTFaceAttr, paramPTSegAttr);
              continue;
              if (paramAESticker != null)
              {
                paramAESticker.renderARFilter((Frame)localObject1);
                continue;
                if (paramAESticker != null)
                {
                  localObject1 = paramAESticker.renderHeadCropFilter((Frame)localObject1, paramPTFaceAttr);
                  continue;
                  if (paramAESticker != null)
                  {
                    localObject1 = paramAESticker.renderBgFilter((Frame)localObject1, paramPTFaceAttr);
                    continue;
                    if (paramAESticker != null)
                    {
                      localObject1 = paramAESticker.renderEffectFilterBefore((Frame)localObject1);
                      continue;
                      if (paramAESticker != null)
                      {
                        localObject1 = paramAESticker.renderHairCos((Frame)localObject1, paramPTFaceAttr, paramAIAttr);
                        continue;
                        if (paramAESticker != null)
                        {
                          localObject1 = paramAESticker.renderSkyFilter((Frame)localObject1, paramPTFaceAttr, paramAIAttr);
                          continue;
                          if (paramAESticker != null)
                          {
                            localObject1 = paramAESticker.renderComicEffectBefore((Frame)localObject1, paramPTFaceAttr);
                            continue;
                            if (paramAESticker != null)
                            {
                              localObject1 = paramAESticker.renderEffectTriggerBefore((Frame)localObject1, paramPTFaceAttr);
                              continue;
                              if (paramAESticker != null)
                              {
                                localObject1 = paramAESticker.renderStickerBefore((Frame)localObject1, paramPTFaceAttr);
                                continue;
                                if (paramAESticker != null)
                                {
                                  localObject1 = paramAESticker.renderBlingFilter((Frame)localObject1, paramPTFaceAttr, (PTDetectInfo)localObject3, localList3);
                                  continue;
                                  if (paramAESticker != null)
                                  {
                                    localObject1 = paramAESticker.renderFilament((Frame)localObject1, paramPTFaceAttr);
                                    continue;
                                    if (paramAESticker != null)
                                    {
                                      localObject1 = paramAESticker.renderRapidNet((Frame)localObject1, paramPTFaceAttr);
                                      continue;
                                      if (paramAESticker != null)
                                      {
                                        localObject1 = paramAESticker.renderDynamicFilter((Frame)localObject1, paramPTFaceAttr, paramAIAttr);
                                        continue;
                                        if (paramAESticker != null)
                                        {
                                          localObject1 = paramAESticker.renderFaceSwitchFilter((Frame)localObject1, localList1, localSet);
                                          continue;
                                          if (paramAESticker != null)
                                          {
                                            localObject1 = paramAESticker.renderCrazyFaceFilter((Frame)localObject1, localList1, localList2);
                                            continue;
                                            if (paramAESticker != null)
                                            {
                                              localObject1 = paramAESticker.renderPhantomFilter((Frame)localObject1, paramPTFaceAttr);
                                              continue;
                                              if (paramAESticker != null)
                                              {
                                                localObject1 = paramAESticker.renderParticleStatic((Frame)localObject1, (PTDetectInfo)localObject3, (List)localObject2);
                                                continue;
                                                if (paramAESticker != null)
                                                {
                                                  localObject1 = paramAESticker.renderComicEffectAfter((Frame)localObject1, paramPTFaceAttr);
                                                  continue;
                                                  if (paramAESticker != null)
                                                  {
                                                    localObject1 = paramAESticker.renderEffectTriggerAfter((Frame)localObject1, paramPTFaceAttr);
                                                    continue;
                                                    if (paramAESticker != null)
                                                    {
                                                      paramAESticker.renderMultiViewer((Frame)localObject1, paramPTFaceAttr, paramAIAttr, paramPTSegAttr, localHashMap);
                                                      continue;
                                                      if (paramAESticker != null)
                                                      {
                                                        localObject1 = paramAESticker.renderFilamentParticle((Frame)localObject1, paramPTFaceAttr);
                                                        continue;
                                                        if (paramAESticker != null)
                                                        {
                                                          localObject1 = paramAESticker.renderStickerAfter((Frame)localObject1, paramPTFaceAttr);
                                                          continue;
                                                          if (paramAESticker != null)
                                                          {
                                                            localObject1 = paramAESticker.renderEffectFilterAfter((Frame)localObject1);
                                                            continue;
                                                            if (paramAESticker != null)
                                                            {
                                                              localObject1 = paramAESticker.renderActFilter((Frame)localObject1, localList1, localList2, j, paramPTFaceAttr);
                                                              continue;
                                                              if (paramAESticker != null)
                                                              {
                                                                localObject1 = paramAESticker.renderZoomFilter((Frame)localObject1, localHashMap);
                                                                continue;
                                                                if (paramAESticker != null)
                                                                {
                                                                  localObject1 = paramAESticker.renderFabbyMVFilter(paramFrame, paramAIAttr, localHashMap, localSet, paramPTFaceAttr);
                                                                  continue;
                                                                  if (paramAESticker != null)
                                                                  {
                                                                    localObject1 = paramAESticker.renderAfterBlur((Frame)localObject1, paramPTFaceAttr, paramPTSegAttr);
                                                                    continue;
                                                                    if (paramAESticker != null) {
                                                                      localObject1 = paramAESticker.renderCosFun((Frame)localObject1, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
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
        if (paramAESticker != null)
        {
          paramAESticker.clearTouchPoint();
          paramAESticker.unclockHairMaskFrame();
        }
        return localObject1;
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
      localObject2 = AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND);
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
          break label1129;
        }
        localObject2 = (String)localIterator.next();
        paramMultiViewerFilter.setFastStickerConfig(paramFrame2, (Frame)localObject1, paramFrame1);
        paramMultiViewerFilter.updateFaceParams(paramFrame2, paramAIAttr, paramPTFaceAttr);
        switch (((String)localObject2).hashCode())
        {
        default: 
          label400:
          i = -1;
          label403:
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
          break label400;
        }
        i = 0;
        break label403;
        if (!((String)localObject2).equals("mesh")) {
          break label400;
        }
        i = 1;
        break label403;
        if (!((String)localObject2).equals("lutBefore")) {
          break label400;
        }
        i = 2;
        break label403;
        if (!((String)localObject2).equals("hairCos")) {
          break label400;
        }
        i = 3;
        break label403;
        if (!((String)localObject2).equals("comicBefore")) {
          break label400;
        }
        i = 4;
        break label403;
        if (!((String)localObject2).equals("triggerLutBefore")) {
          break label400;
        }
        i = 5;
        break label403;
        if (!((String)localObject2).equals("stickerBefore")) {
          break label400;
        }
        i = 6;
        break label403;
        if (!((String)localObject2).equals("styleChange")) {
          break label400;
        }
        i = 7;
        break label403;
        if (!((String)localObject2).equals("customBefore")) {
          break label400;
        }
        i = 8;
        break label403;
        if (!((String)localObject2).equals("dynamic")) {
          break label400;
        }
        i = 9;
        break label403;
        if (!((String)localObject2).equals("faceSwap")) {
          break label400;
        }
        i = 10;
        break label403;
        if (!((String)localObject2).equals("faceAverage")) {
          break label400;
        }
        i = 11;
        break label403;
        if (!((String)localObject2).equals("phantom")) {
          break label400;
        }
        i = 12;
        break label403;
        if (!((String)localObject2).equals("tdParticle")) {
          break label400;
        }
        i = 13;
        break label403;
        if (!((String)localObject2).equals("stickerAfter")) {
          break label400;
        }
        i = 14;
        break label403;
        if (!((String)localObject2).equals("customAfter")) {
          break label400;
        }
        i = 15;
        break label403;
        if (!((String)localObject2).equals("zoom")) {
          break label400;
        }
        i = 16;
        break label403;
        if (!((String)localObject2).equals("blurEffectAfter")) {
          break label400;
        }
        i = 17;
        break label403;
        if (!((String)localObject2).equals("mask")) {
          break label400;
        }
        i = 18;
        break label403;
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
                      if (paramMultiViewerFilter != null)
                      {
                        paramFrame2 = paramMultiViewerFilter.renderRapidNet(paramFrame2, paramPTFaceAttr);
                        continue;
                        if (paramMultiViewerFilter != null)
                        {
                          paramFrame2 = paramMultiViewerFilter.renderCustomFilter(paramFrame2, 1);
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
                                        paramFrame2 = paramMultiViewerFilter.renderCustomFilter(paramFrame2, 2);
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
                                              paramFrame2 = paramMultiViewerFilter.renderMaskSticker(paramFrame2, paramPTFaceAttr);
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
      label1129:
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
          if (j > i)
          {
            i = j;
          }
          else if (j < i)
          {
            this.mStickerOrderList.remove(j);
            this.mStickerOrderList.add(i, str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StickersMap
 * JD-Core Version:    0.7.0.1
 */