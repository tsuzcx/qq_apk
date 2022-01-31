package com.tencent.ttpic.trigger;

import java.util.HashMap;

public class FabbyFiltersTriggerCtrlItem
  extends TriggerCtrlItem
{
  private HashMap<Integer, TriggerCtrlItem> triggerCtrlMap;
  
  public FabbyFiltersTriggerCtrlItem(HashMap<Integer, TriggerCtrlItem> paramHashMap)
  {
    this.triggerCtrlMap = paramHashMap;
  }
  
  public HashMap<Integer, TriggerCtrlItem> getTriggerCtrlMap()
  {
    return this.triggerCtrlMap;
  }
  
  public boolean isCurrentTriggered(int paramInt)
  {
    if (this.triggerCtrlMap != null)
    {
      TriggerCtrlItem localTriggerCtrlItem = (TriggerCtrlItem)this.triggerCtrlMap.get(Integer.valueOf(paramInt));
      if (localTriggerCtrlItem != null) {
        return localTriggerCtrlItem.isTriggered();
      }
    }
    return false;
  }
  
  public void setTriggerCtrlMap(HashMap<Integer, TriggerCtrlItem> paramHashMap)
  {
    this.triggerCtrlMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.trigger.FabbyFiltersTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */