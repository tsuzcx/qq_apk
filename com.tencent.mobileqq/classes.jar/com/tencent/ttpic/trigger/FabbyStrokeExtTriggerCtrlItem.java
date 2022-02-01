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
    if ((!this.mIsCtrInit) && (this.triggerCtrlItems != null))
    {
      Iterator localIterator = this.triggerCtrlItems.iterator();
      while (localIterator.hasNext()) {
        ((TriggerCtrlItem)localIterator.next()).updateFrameIndex(paramLong);
      }
      this.mIsCtrInit = true;
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
    Iterator localIterator = this.triggerCtrlItems.iterator();
    while (localIterator.hasNext())
    {
      TriggerCtrlItem localTriggerCtrlItem = (TriggerCtrlItem)localIterator.next();
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
            if ((this.trigger != null) && (this.trigger != localTriggerCtrlItem) && (this.item.getTriggerTypeInt() != PTFaceAttr.PTExpression.TIME_TRIGGER.value)) {
              this.trigger.reset();
            }
            this.trigger = localTriggerCtrlItem;
            this.item = localStickerItem;
          }
        }
      }
    }
    boolean bool;
    if ((this.item != null) && (this.trigger != null)) {
      if (!this.mNeedDrawStroke)
      {
        bool = true;
        this.isFirstTriggered = bool;
        this.mNeedDrawStroke = true;
        if (!this.trigger.isTriggered()) {
          break label307;
        }
        if (this.item.strokeType == VideoFilterFactory.SEGMENT_STROKE_TRIGGER_TYPE.MASK_LINE_STROKE.type)
        {
          this.trigger.getTriggeredStatus(paramPTDetectInfo);
          this.trigger.updateFrameIndex(paramPTDetectInfo.timestamp);
        }
      }
    }
    for (;;)
    {
      if ((this.mNeedDrawStroke) && (this.trigger != null))
      {
        this.model.frameIndex = this.trigger.getFrameIndex();
        this.model.itemId = this.trigger.getStickerItemID();
      }
      return;
      bool = false;
      break;
      label307:
      this.trigger.reset();
      this.trigger = null;
      this.item = null;
      this.model.renderEnded = true;
      continue;
      this.mNeedDrawStroke = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.trigger.FabbyStrokeExtTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */