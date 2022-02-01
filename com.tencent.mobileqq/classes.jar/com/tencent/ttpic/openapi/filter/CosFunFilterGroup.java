package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.filter.CosFunGroupItem;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.filter.stylizefilter.customFilter.StyleCustomFilterGroup;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.cosfun.CosFun;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunGroupItem;
import com.tencent.ttpic.trigger.TriggerManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CosFunFilterGroup
{
  private static final String TAG = "CosFunFilterGroup";
  private Map<Integer, FaceActionCounter> actionCounterMap;
  private AIAttr aiAttr;
  private int animTotalDuration;
  private CosFun cosFun;
  private List<CosFunGroupItem> cosFunGroupItemList = new ArrayList();
  private boolean countDownCalled = false;
  private int currentGroupItemIndex = -1;
  private List<StyleCustomFilterGroup> customFilterGroupList;
  private boolean enableGAN;
  private StyleChildFilter ganFilter;
  private boolean isRestartGroup = false;
  private int lastFrameFaceCount = 1;
  private int randomItemIndex = -1;
  private int startInterval;
  private long startTime = -1L;
  private TriggerManager triggerManager;
  private Set<Integer> triggeredExpression;
  private VideoMaterial videoMaterial;
  
  public CosFunFilterGroup(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager, List<RenderItem> paramList, List<StyleCustomFilterGroup> paramList1, boolean paramBoolean)
  {
    this.videoMaterial = paramVideoMaterial;
    this.cosFun = paramVideoMaterial.getCosFun();
    paramVideoMaterial = this.cosFun;
    if (paramVideoMaterial != null)
    {
      this.animTotalDuration = (paramVideoMaterial.getTipsAnimFrames() * this.cosFun.getTipsAnimFrameDuration());
      this.startInterval = this.cosFun.getStartInterval();
    }
    this.triggerManager = paramTriggerManager;
    if ((paramList != null) && (paramList.size() > 0)) {
      this.ganFilter = ((StyleChildFilter)((RenderItem)paramList.get(0)).filter);
    }
    if (paramList1 != null) {
      this.customFilterGroupList = paramList1;
    }
    this.enableGAN = paramBoolean;
    initCosGroup();
  }
  
  private CosFunGroupItem getCurrentGroupItem()
  {
    boolean bool = false;
    this.isRestartGroup = false;
    int i = this.currentGroupItemIndex;
    if (i == -1)
    {
      this.currentGroupItemIndex = 0;
      return (CosFunGroupItem)this.cosFunGroupItemList.get(this.currentGroupItemIndex);
    }
    if (((CosFunGroupItem)this.cosFunGroupItemList.get(i)).durationComplete())
    {
      this.currentGroupItemIndex = ((this.currentGroupItemIndex + 1) % this.cosFunGroupItemList.size());
      if (this.currentGroupItemIndex == 0) {
        bool = true;
      }
      this.isRestartGroup = bool;
      if (this.isRestartGroup) {
        CosFunHelper.isRestart = true;
      }
    }
    return (CosFunGroupItem)this.cosFunGroupItemList.get(this.currentGroupItemIndex);
  }
  
  private void initCosGroup()
  {
    if (this.randomItemIndex == -1) {
      this.randomItemIndex = new Random().nextInt(((CosFun.CosFunGroupItem)this.cosFun.getCosFunGroupItem().get(0)).getCosFunItems().size());
    }
    Object localObject = this.cosFun;
    if (localObject != null)
    {
      localObject = ((CosFun)localObject).getCosFunGroupItem();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          CosFun.CosFunGroupItem localCosFunGroupItem = (CosFun.CosFunGroupItem)((Iterator)localObject).next();
          this.cosFunGroupItemList.add(new CosFunGroupItem(this.videoMaterial.getDataPath(), localCosFunGroupItem, this.randomItemIndex, this.triggerManager, this.ganFilter, this.customFilterGroupList, this.enableGAN));
        }
      }
    }
  }
  
  private void restartFlow(long paramLong)
  {
    this.startTime = -1L;
    this.countDownCalled = false;
    release();
    this.cosFunGroupItemList.clear();
    initCosGroup();
  }
  
  private void updateItemIndex(int paramInt)
  {
    int i;
    if (this.lastFrameFaceCount != paramInt) {
      i = 1;
    } else {
      i = 0;
    }
    this.lastFrameFaceCount = paramInt;
    if (i != 0) {
      this.randomItemIndex = new Random().nextInt(getCurrentGroupItem().getCosFunItemsCount());
    }
  }
  
  public int getItemCount()
  {
    return getCurrentGroupItem().getItemCount();
  }
  
  public int getItemIndex()
  {
    return getCurrentGroupItem().getItemIndex();
  }
  
  public void release()
  {
    Iterator localIterator = this.cosFunGroupItemList.iterator();
    while (localIterator.hasNext()) {
      ((CosFunGroupItem)localIterator.next()).release();
    }
  }
  
  public Frame render(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    CosFunHelper.isRestart = false;
    if (paramPTFaceAttr.getTimeStamp() - this.startTime < this.startInterval) {
      return paramFrame;
    }
    return getCurrentGroupItem().render(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
  }
  
  public void reset()
  {
    restartFlow(0L);
    if (CosFunHelper.countDownListener != null) {
      CosFunHelper.countDownListener.onCountDownEnd();
    }
  }
  
  public void updateCurrentTriggerParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, AIAttr paramAIAttr)
  {
    this.actionCounterMap = paramMap;
    this.triggeredExpression = paramSet;
    this.aiAttr = paramAIAttr;
  }
  
  public void updateParams(PTFaceAttr paramPTFaceAttr)
  {
    if (this.startTime <= 0L) {
      this.startTime = paramPTFaceAttr.getTimeStamp();
    }
    updateItemIndex(paramPTFaceAttr.getFaceCount());
    long l1 = paramPTFaceAttr.getTimeStamp();
    long l2 = this.startTime;
    long l3 = this.startInterval;
    boolean bool = true;
    if (l1 - l2 < l3)
    {
      if (paramPTFaceAttr.getFaceCount() < 1) {
        this.startTime = paramPTFaceAttr.getTimeStamp();
      }
      if (paramPTFaceAttr.getFaceCount() >= 1) {
        bool = false;
      }
      CosFunHelper.isRestart = bool;
      return;
    }
    if ((paramPTFaceAttr.getFaceCount() > 0) && (!this.countDownCalled) && (this.animTotalDuration > 0) && (CosFunHelper.countDownListener != null))
    {
      CosFunHelper.countDownListener.onCountDownStart(this.videoMaterial);
      this.countDownCalled = true;
    }
    CosFunGroupItem localCosFunGroupItem = getCurrentGroupItem();
    localCosFunGroupItem.updateCurrentTriggerParam(this.actionCounterMap, this.triggeredExpression, this.aiAttr);
    localCosFunGroupItem.updateParams(paramPTFaceAttr);
    if (CosFunHelper.isRestart) {
      restartFlow(paramPTFaceAttr.getTimeStamp());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CosFunFilterGroup
 * JD-Core Version:    0.7.0.1
 */