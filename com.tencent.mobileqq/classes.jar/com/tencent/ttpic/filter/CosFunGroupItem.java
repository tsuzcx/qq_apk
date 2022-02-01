package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.filter.StyleChildFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.customFilter.StyleCustomFilterGroup;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunGroupItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.trigger.TriggerManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CosFunGroupItem
{
  private Map<Integer, FaceActionCounter> actionCounterMap;
  private AIAttr aiAttr;
  private CosFun.CosFunGroupItem cosFunGroupItem;
  private CosFunFilter currentCosFunFilter = null;
  private List<StyleCustomFilterGroup> customFilterGroupList;
  private boolean durationComplete = false;
  private boolean enableGAN;
  private StyleChildFilter ganFilter;
  private boolean isFirstUpdate = true;
  private int itemIndex = -1;
  private int lastFrameFaceCount = -1;
  private String materialPath;
  private TriggerManager triggerManager;
  private int triggerType = 1;
  private Set<Integer> triggeredExpression;
  
  public CosFunGroupItem(String paramString, CosFun.CosFunGroupItem paramCosFunGroupItem, int paramInt, TriggerManager paramTriggerManager, StyleChildFilter paramStyleChildFilter, List<StyleCustomFilterGroup> paramList, boolean paramBoolean)
  {
    this.materialPath = paramString;
    this.cosFunGroupItem = paramCosFunGroupItem;
    this.itemIndex = calcItemIndex(paramCosFunGroupItem, -1);
    if (paramCosFunGroupItem.getLoopMode().equals("random")) {
      this.itemIndex = paramInt;
    }
    this.triggerManager = paramTriggerManager;
    this.ganFilter = paramStyleChildFilter;
    this.customFilterGroupList = paramList;
    this.enableGAN = paramBoolean;
    updateTriggerType(paramCosFunGroupItem);
  }
  
  private CosFunFilter createFilter(String paramString, int paramInt)
  {
    CosFunFilter localCosFunFilter = new CosFunFilter();
    if ((this.customFilterGroupList != null) && (this.customFilterGroupList.size() > paramInt)) {}
    for (StyleCustomFilterGroup localStyleCustomFilterGroup = (StyleCustomFilterGroup)this.customFilterGroupList.get(paramInt);; localStyleCustomFilterGroup = null)
    {
      localCosFunFilter.init(paramString, (CosFun.CosFunItem)this.cosFunGroupItem.getCosFunItems().get(paramInt), this.triggerManager, localStyleCustomFilterGroup);
      localCosFunFilter.setGanFilter(this.ganFilter);
      localCosFunFilter.setEnableGAN(this.enableGAN);
      return localCosFunFilter;
    }
  }
  
  private CosFunFilter createNewFilter()
  {
    return createFilter(this.materialPath, this.itemIndex);
  }
  
  private CosFunFilter createRandomFilter()
  {
    return createFilter(this.materialPath, this.itemIndex);
  }
  
  private CosFunFilter getCurrentCosFunFilter(long paramLong)
  {
    if (this.currentCosFunFilter == null) {
      return createNewFilter();
    }
    if (this.currentCosFunFilter.durationComplete(paramLong))
    {
      this.currentCosFunFilter.release();
      if (this.itemIndex == this.cosFunGroupItem.getCosFunItems().size() - 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.durationComplete = bool;
        this.itemIndex = calcItemIndex(this.cosFunGroupItem, this.itemIndex);
        return createNewFilter();
      }
    }
    return this.currentCosFunFilter;
  }
  
  private void updateTriggerType(CosFun.CosFunGroupItem paramCosFunGroupItem)
  {
    paramCosFunGroupItem = paramCosFunGroupItem.getCosFunItems().iterator();
    if (paramCosFunGroupItem.hasNext()) {
      this.triggerType = ((CosFun.CosFunItem)paramCosFunGroupItem.next()).getTriggerType();
    }
  }
  
  public int calcItemIndex(CosFun.CosFunGroupItem paramCosFunGroupItem, int paramInt)
  {
    if (paramCosFunGroupItem.getLoopMode().equals("sequence")) {
      return (paramInt + 1) % paramCosFunGroupItem.getCosFunItems().size();
    }
    return new Random().nextInt(paramCosFunGroupItem.getCosFunItems().size());
  }
  
  public boolean durationComplete()
  {
    return this.durationComplete;
  }
  
  public int getCosFunItemsCount()
  {
    return this.cosFunGroupItem.getCosFunItems().size();
  }
  
  public int getItemCount()
  {
    return this.cosFunGroupItem.getCosFunItems().size();
  }
  
  public int getItemIndex()
  {
    if (this.triggerType == 1) {
      return this.itemIndex;
    }
    if ((this.currentCosFunFilter == null) || (!this.currentCosFunFilter.isTriggered())) {
      return -1;
    }
    return this.itemIndex;
  }
  
  public void release()
  {
    if (this.currentCosFunFilter != null) {
      this.currentCosFunFilter.release();
    }
    this.currentCosFunFilter = null;
    this.lastFrameFaceCount = -1;
    this.itemIndex = -1;
    this.durationComplete = false;
    this.isFirstUpdate = true;
  }
  
  public Frame render(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    Frame localFrame = paramFrame;
    if (this.currentCosFunFilter != null) {
      localFrame = this.currentCosFunFilter.render(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
    }
    return localFrame;
  }
  
  public void updateCurrentTriggerParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, AIAttr paramAIAttr)
  {
    this.actionCounterMap = paramMap;
    this.triggeredExpression = paramSet;
    this.aiAttr = paramAIAttr;
  }
  
  public void updateParams(PTFaceAttr paramPTFaceAttr)
  {
    if (this.cosFunGroupItem.getLoopMode().equals("sequence")) {}
    for (this.currentCosFunFilter = getCurrentCosFunFilter(paramPTFaceAttr.getTimeStamp());; this.currentCosFunFilter = createRandomFilter())
    {
      do
      {
        this.currentCosFunFilter.updateParams(paramPTFaceAttr);
        this.isFirstUpdate = false;
        return;
      } while ((this.currentCosFunFilter != null) && (!this.currentCosFunFilter.durationComplete(paramPTFaceAttr.getTimeStamp())));
      if (this.currentCosFunFilter != null)
      {
        this.currentCosFunFilter.release();
        this.durationComplete = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.CosFunGroupItem
 * JD-Core Version:    0.7.0.1
 */