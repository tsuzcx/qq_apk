package com.tencent.ttpic.trigger;

import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.filter.zoomfilter.ZoomInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ZoomTriggerCtrlItem
  extends TriggerCtrlItem
{
  private HashMap<String, ZoomInfo> mZoomMap;
  private HashMap<String, TriggerCtrlItem> triggerCtrlMap;
  private String triggeredID;
  private ZoomTriggerCtrlItem.ZoomModel zoomModel;
  
  private String checkTriggeredID(PTDetectInfo paramPTDetectInfo, int paramInt)
  {
    if ((this.triggerCtrlMap == null) || (this.mZoomMap == null)) {
      return null;
    }
    Iterator localIterator = this.triggerCtrlMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      TriggerCtrlItem localTriggerCtrlItem = (TriggerCtrlItem)this.triggerCtrlMap.get(str);
      ZoomInfo localZoomInfo = (ZoomInfo)this.mZoomMap.get(str);
      if ((localTriggerCtrlItem != null) && (localZoomInfo != null) && (localTriggerCtrlItem.isCurrentFrameTriggered(paramPTDetectInfo)) && (localZoomInfo.isInCurPart(paramInt))) {
        return str;
      }
    }
    return null;
  }
  
  public void addItem(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {
      return;
    }
    if (this.triggerCtrlMap == null) {
      this.triggerCtrlMap = new HashMap();
    }
    if (this.mZoomMap == null) {
      this.mZoomMap = new HashMap();
    }
    Object localObject = new TriggerCtrlItem(paramStickerItem);
    this.triggerCtrlMap.put(paramStickerItem.id, localObject);
    localObject = new ZoomInfo(paramStickerItem);
    this.mZoomMap.put(paramStickerItem.id, localObject);
  }
  
  public void clear() {}
  
  public ZoomTriggerCtrlItem.ZoomModel getZoomModel()
  {
    return this.zoomModel;
  }
  
  public boolean isTriggered()
  {
    return (this.zoomModel != null) && (this.zoomModel.zoomId != null);
  }
  
  public void reset() {}
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo) {}
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo, int paramInt)
  {
    this.zoomModel = new ZoomTriggerCtrlItem.ZoomModel(this);
    int i;
    if (this.triggeredID == null) {
      i = 1;
    }
    TriggerCtrlItem localTriggerCtrlItem;
    while (this.triggeredID == null)
    {
      this.triggeredID = checkTriggeredID(paramPTDetectInfo, paramInt);
      if (this.triggeredID == null)
      {
        return;
        i = 0;
      }
      else if (this.triggerCtrlMap != null)
      {
        localTriggerCtrlItem = (TriggerCtrlItem)this.triggerCtrlMap.get(this.triggeredID);
        if (localTriggerCtrlItem != null) {
          localTriggerCtrlItem.setFrameStartTime(paramPTDetectInfo.timestamp);
        }
      }
    }
    if (this.triggerCtrlMap != null)
    {
      localTriggerCtrlItem = (TriggerCtrlItem)this.triggerCtrlMap.get(this.triggeredID);
      ZoomInfo localZoomInfo = (ZoomInfo)this.mZoomMap.get(this.triggeredID);
      if (localTriggerCtrlItem != null) {
        localTriggerCtrlItem.isCurrentFrameTriggered(paramPTDetectInfo);
      }
      if ((localTriggerCtrlItem == null) || (localZoomInfo == null) || (!localZoomInfo.isInCurPart(paramInt)) || (!localTriggerCtrlItem.isTriggered())) {
        break label199;
      }
      localTriggerCtrlItem.updateFrameIndex(paramPTDetectInfo.timestamp);
      this.zoomModel.frameIndex = localTriggerCtrlItem.getFrameIndex();
    }
    for (;;)
    {
      this.zoomModel.zoomId = this.triggeredID;
      return;
      label199:
      this.triggeredID = null;
      if (localTriggerCtrlItem != null) {
        localTriggerCtrlItem.reset();
      }
      if (i == 0)
      {
        this.triggeredID = checkTriggeredID(paramPTDetectInfo, paramInt);
        if (this.triggeredID != null)
        {
          localTriggerCtrlItem.setFrameStartTime(paramPTDetectInfo.timestamp);
          localTriggerCtrlItem.updateFrameIndex(paramPTDetectInfo.timestamp);
          this.zoomModel.frameIndex = localTriggerCtrlItem.getFrameIndex();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.trigger.ZoomTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */