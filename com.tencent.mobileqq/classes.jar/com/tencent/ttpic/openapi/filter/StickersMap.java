package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
    this.mStickerOrderList.add("particle");
    this.mStickerOrderList.add("faceHeadCrop");
    this.mStickerOrderList.add("background");
    this.mStickerOrderList.add("lut");
    this.mStickerOrderList.add("hairCos");
    this.mStickerOrderList.add("skySegment");
    this.mStickerOrderList.add("staticSticker");
    this.mStickerOrderList.add("3d");
    this.mStickerOrderList.add("filament");
    this.mStickerOrderList.add("styleChange");
    this.mStickerOrderList.add("dynamic");
    this.mStickerOrderList.add("multiview");
    this.mStickerOrderList.add("filamentParticle");
    this.mStickerOrderList.add("expression");
    this.mStickerOrderList.add("zoom");
    this.mStickerOrderList.add("mv");
    this.mStickerOrderList.add("blurEffectAfter");
    this.mStickerOrderList.add("crazyFace");
  }
  
  public Frame chainStickerFilters(AESticker paramAESticker, Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    int j = paramPTFaceAttr.getRotation();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    if (paramAIAttr != null)
    {
      localObject1 = (PTHandAttr)paramAIAttr.getAvailableData("PTSTHandDetector");
      if (localObject1 != null) {
        localSet.add(Integer.valueOf(((PTHandAttr)localObject1).getHandType()));
      }
    }
    HashMap localHashMap = new HashMap();
    if (this.mStickerChain != null) {
      this.mStickerChain.clear();
    }
    Iterator localIterator = this.mStickerOrderList.iterator();
    Object localObject1 = paramFrame;
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      label300:
      int i;
      switch (((String)localObject2).hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        localObject2 = localObject1;
        switch (i)
        {
        default: 
          break;
        case 0: 
          if (paramAESticker == null) {
            break;
          }
          localObject1 = paramAESticker.processTransformRelatedFilters((Frame)localObject1, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
          break;
          if (!((String)localObject2).equals("beforeTransform")) {
            break label300;
          }
          i = 0;
          continue;
          if (!((String)localObject2).equals("fabbyStroke")) {
            break label300;
          }
          i = 1;
          continue;
          if (!((String)localObject2).equals("particle")) {
            break label300;
          }
          i = 2;
          continue;
          if (!((String)localObject2).equals("faceHeadCrop")) {
            break label300;
          }
          i = 3;
          continue;
          if (!((String)localObject2).equals("background")) {
            break label300;
          }
          i = 4;
          continue;
          if (!((String)localObject2).equals("lut")) {
            break label300;
          }
          i = 5;
          continue;
          if (!((String)localObject2).equals("hairCos")) {
            break label300;
          }
          i = 6;
          continue;
          if (!((String)localObject2).equals("skySegment")) {
            break label300;
          }
          i = 7;
          continue;
          if (!((String)localObject2).equals("staticSticker")) {
            break label300;
          }
          i = 8;
          continue;
          if (!((String)localObject2).equals("3d")) {
            break label300;
          }
          i = 9;
          continue;
          if (!((String)localObject2).equals("filament")) {
            break label300;
          }
          i = 10;
          continue;
          if (!((String)localObject2).equals("styleChange")) {
            break label300;
          }
          i = 11;
          continue;
          if (!((String)localObject2).equals("dynamic")) {
            break label300;
          }
          i = 12;
          continue;
          if (!((String)localObject2).equals("multiview")) {
            break label300;
          }
          i = 13;
          continue;
          if (!((String)localObject2).equals("filamentParticle")) {
            break label300;
          }
          i = 14;
          continue;
          if (!((String)localObject2).equals("expression")) {
            break label300;
          }
          i = 15;
          continue;
          if (!((String)localObject2).equals("zoom")) {
            break label300;
          }
          i = 16;
          continue;
          if (!((String)localObject2).equals("mv")) {
            break label300;
          }
          i = 17;
          continue;
          if (!((String)localObject2).equals("blurEffectAfter")) {
            break label300;
          }
          i = 18;
          continue;
          if (!((String)localObject2).equals("crazyFace")) {
            break label300;
          }
          i = 19;
        }
      }
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
                localObject1 = paramAESticker.renderEffectFilter((Frame)localObject1);
                continue;
                if (paramAESticker != null)
                {
                  localObject1 = paramAESticker.renderHairCos((Frame)localObject1, paramPTFaceAttr, paramAIAttr);
                  continue;
                  if (paramAESticker != null)
                  {
                    localObject1 = paramAESticker.renderSkyFilter((Frame)localObject1, paramPTFaceAttr, paramAIAttr);
                    continue;
                    localObject2 = localObject1;
                    if (paramAESticker != null) {
                      localObject2 = paramAESticker.renderStaticSticker((Frame)localObject1, paramPTFaceAttr);
                    }
                    localObject1 = localObject2;
                    if (paramAESticker != null)
                    {
                      localObject1 = paramAESticker.renderGamePlay((Frame)localObject2, paramPTFaceAttr);
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
                              paramAESticker.renderMultiViewer((Frame)localObject1, paramPTFaceAttr, paramAIAttr, paramPTSegAttr, localHashMap);
                              continue;
                              if (paramAESticker != null)
                              {
                                localObject1 = paramAESticker.renderFilamentParticle((Frame)localObject1, paramPTFaceAttr);
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
    return localObject1;
  }
  
  public void setRenderOrder(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.mStickerOrderList.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          this.mStickerOrderList.add(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StickersMap
 * JD-Core Version:    0.7.0.1
 */