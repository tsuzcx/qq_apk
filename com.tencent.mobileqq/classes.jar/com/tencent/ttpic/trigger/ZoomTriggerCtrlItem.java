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
    Object localObject = this.triggerCtrlMap;
    if (localObject != null)
    {
      if (this.mZoomMap == null) {
        return null;
      }
      localObject = ((HashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        TriggerCtrlItem localTriggerCtrlItem = (TriggerCtrlItem)this.triggerCtrlMap.get(str);
        ZoomInfo localZoomInfo = (ZoomInfo)this.mZoomMap.get(str);
        if ((localTriggerCtrlItem != null) && (localZoomInfo != null) && (localTriggerCtrlItem.isCurrentFrameTriggered(paramPTDetectInfo)) && (localZoomInfo.isInCurPart(paramInt))) {
          return str;
        }
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
    ZoomTriggerCtrlItem.ZoomModel localZoomModel = this.zoomModel;
    return (localZoomModel != null) && (localZoomModel.zoomId != null);
  }
  
  public void reset() {}
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo) {}
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo, int paramInt)
  {
    this.zoomModel = new ZoomTriggerCtrlItem.ZoomModel(this);
    int i;
    if (this.triggeredID == null) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2;
    if (this.triggeredID == null)
    {
      this.triggeredID = checkTriggeredID(paramPTDetectInfo, paramInt);
      localObject1 = this.triggeredID;
      if (localObject1 == null) {
        return;
      }
      localObject2 = this.triggerCtrlMap;
      if (localObject2 != null)
      {
        localObject1 = (TriggerCtrlItem)((HashMap)localObject2).get(localObject1);
        if (localObject1 != null) {
          ((TriggerCtrlItem)localObject1).setFrameStartTime(paramPTDetectInfo.timestamp);
        }
      }
    }
    Object localObject1 = this.triggerCtrlMap;
    if (localObject1 != null)
    {
      localObject1 = (TriggerCtrlItem)((HashMap)localObject1).get(this.triggeredID);
      localObject2 = (ZoomInfo)this.mZoomMap.get(this.triggeredID);
      if (localObject1 != null) {
        ((TriggerCtrlItem)localObject1).isCurrentFrameTriggered(paramPTDetectInfo);
      }
      if ((localObject1 != null) && (localObject2 != null) && (((ZoomInfo)localObject2).isInCurPart(paramInt)) && (((TriggerCtrlItem)localObject1).isTriggered()))
      {
        ((TriggerCtrlItem)localObject1).updateFrameIndex(paramPTDetectInfo.timestamp);
        this.zoomModel.frameIndex = ((TriggerCtrlItem)localObject1).getFrameIndex();
      }
      else
      {
        this.triggeredID = null;
        if (localObject1 != null) {
          ((TriggerCtrlItem)localObject1).reset();
        }
        if (i == 0)
        {
          this.triggeredID = checkTriggeredID(paramPTDetectInfo, paramInt);
          if (this.triggeredID != null)
          {
            ((TriggerCtrlItem)localObject1).setFrameStartTime(paramPTDetectInfo.timestamp);
            ((TriggerCtrlItem)localObject1).updateFrameIndex(paramPTDetectInfo.timestamp);
            this.zoomModel.frameIndex = ((TriggerCtrlItem)localObject1).getFrameIndex();
          }
        }
      }
    }
    this.zoomModel.zoomId = this.triggeredID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.trigger.ZoomTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */