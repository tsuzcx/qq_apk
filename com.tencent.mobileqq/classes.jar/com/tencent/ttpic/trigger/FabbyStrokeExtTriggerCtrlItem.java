package com.tencent.ttpic.trigger;

import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.VideoFilterFactory.SEGMENT_STROKE_TRIGGER_TYPE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FabbyStrokeExtTriggerCtrlItem
  extends TriggerCtrlItem
{
  private boolean isFirstTriggered = false;
  private StickerItem item;
  private boolean mIsCtrInit = false;
  private boolean mNeedDrawStroke = false;
  private FabbyStrokeExtTriggerCtrlItem.FabbyExtModel model;
  private Map<String, StickerItem> stickerItemMap = new HashMap();
  private TriggerCtrlItem trigger;
  private List<TriggerCtrlItem> triggerCtrlItems = new ArrayList();
  
  public FabbyStrokeExtTriggerCtrlItem(List<StickerItem> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (StickerItem)paramList.next();
      this.stickerItemMap.put(((StickerItem)localObject).id, localObject);
      localObject = new TriggerCtrlItem((StickerItem)localObject);
      this.triggerCtrlItems.add(localObject);
    }
  }
  
  public FabbyStrokeExtTriggerCtrlItem.FabbyExtModel getModel()
  {
    return this.model;
  }
  
  public void initCtrItems(long paramLong)
  {
    if (!this.mIsCtrInit)
    {
      Object localObject = this.triggerCtrlItems;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((TriggerCtrlItem)((Iterator)localObject).next()).updateFrameIndex(paramLong);
        }
        this.mIsCtrInit = true;
      }
    }
  }
  
  public boolean isFirstTriggered()
  {
    return this.isFirstTriggered;
  }
  
  public boolean isTriggered()
  {
    return this.mNeedDrawStroke;
  }
  
  public void reset()
  {
    super.reset();
    Iterator localIterator = this.triggerCtrlItems.iterator();
    while (localIterator.hasNext()) {
      ((TriggerCtrlItem)localIterator.next()).reset();
    }
    this.isFirstTriggered = false;
    this.mNeedDrawStroke = false;
  }
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
  {
    this.model = null;
    initCtrItems(paramPTDetectInfo.timestamp);
    this.model = new FabbyStrokeExtTriggerCtrlItem.FabbyExtModel(this);
    Object localObject = this.triggerCtrlItems.iterator();
    TriggerCtrlItem localTriggerCtrlItem;
    while (((Iterator)localObject).hasNext())
    {
      localTriggerCtrlItem = (TriggerCtrlItem)((Iterator)localObject).next();
      if (localTriggerCtrlItem.isCurrentFrameTriggered(paramPTDetectInfo))
      {
        StickerItem localStickerItem = (StickerItem)this.stickerItemMap.get(localTriggerCtrlItem.getStickerItemID());
        if (localStickerItem != null) {
          if ((localStickerItem != null) && (localStickerItem.getTriggerTypeInt() == PTFaceAttr.PTExpression.ALWAYS.value))
          {
            if (this.trigger == null)
            {
              this.trigger = localTriggerCtrlItem;
              this.item = localStickerItem;
            }
          }
          else
          {
            localObject = this.trigger;
            if ((localObject != null) && (localObject != localTriggerCtrlItem) && (this.item.getTriggerTypeInt() != PTFaceAttr.PTExpression.TIME_TRIGGER.value)) {
              this.trigger.reset();
            }
            this.trigger = localTriggerCtrlItem;
            this.item = localStickerItem;
          }
        }
      }
    }
    if (this.item != null)
    {
      localTriggerCtrlItem = this.trigger;
      if (localTriggerCtrlItem != null)
      {
        this.isFirstTriggered = (this.mNeedDrawStroke ^ true);
        this.mNeedDrawStroke = true;
        if (localTriggerCtrlItem.isTriggered())
        {
          if (this.item.strokeType != VideoFilterFactory.SEGMENT_STROKE_TRIGGER_TYPE.MASK_LINE_STROKE.type) {
            break label286;
          }
          this.trigger.getTriggeredStatus(paramPTDetectInfo);
          this.trigger.updateFrameIndex(paramPTDetectInfo.timestamp);
          break label286;
        }
        this.trigger.reset();
        this.trigger = null;
        this.item = null;
        this.model.renderEnded = true;
        break label286;
      }
    }
    this.mNeedDrawStroke = false;
    label286:
    if (this.mNeedDrawStroke)
    {
      paramPTDetectInfo = this.trigger;
      if (paramPTDetectInfo != null)
      {
        this.model.frameIndex = paramPTDetectInfo.getFrameIndex();
        this.model.itemId = this.trigger.getStickerItemID();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.trigger.FabbyStrokeExtTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */