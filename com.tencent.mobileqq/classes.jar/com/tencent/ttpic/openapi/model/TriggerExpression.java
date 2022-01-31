package com.tencent.ttpic.openapi.model;

import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.util.TriggerUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TriggerExpression
{
  public int mTriggerType;
  public ArrayList<StickerItem.TriggerArea> triggerArea;
  public int triggerHandPoint;
  
  public TriggerExpression(int paramInt)
  {
    this.mTriggerType = paramInt;
  }
  
  public int getTriggerExpression()
  {
    return this.mTriggerType;
  }
  
  public boolean isTriggered()
  {
    boolean bool = true;
    PTDetectInfo localPTDetectInfo = TriggerStateManager.getInstance().getPTDetectInfo();
    if (localPTDetectInfo == null) {}
    Object localObject;
    List localList;
    AIAttr localAIAttr;
    do
    {
      return false;
      localObject = localPTDetectInfo.triggeredExpression;
      localList = localPTDetectInfo.bodyPoints;
      localAIAttr = localPTDetectInfo.aiAttr;
      if (!VideoMaterialUtil.isFaceTriggerType(this.mTriggerType)) {
        break;
      }
    } while (localObject == null);
    return ((Set)localObject).contains(Integer.valueOf(this.mTriggerType));
    if (VideoMaterialUtil.isGestureTriggerType(this.mTriggerType))
    {
      localObject = (PTHandAttr)localAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (localObject == null) {
        break label227;
      }
    }
    label227:
    for (bool = TriggerUtil.isGestureTriggered((PTHandAttr)localObject, this.mTriggerType, this.triggerHandPoint, this.triggerArea, localAIAttr);; bool = false)
    {
      if (localPTDetectInfo.isFreezeInfo)
      {
        if (localPTDetectInfo.gestureTrigger != this.mTriggerType) {
          break;
        }
        return true;
      }
      return bool;
      if (VideoMaterialUtil.isAudioTextTriggerType(this.mTriggerType)) {
        return true;
      }
      if (VideoMaterialUtil.isAllFreezeFrameTriggerType(this.mTriggerType)) {
        return ((Set)localObject).contains(Integer.valueOf(this.mTriggerType));
      }
      if (VideoMaterialUtil.isTouchTriggerType(this.mTriggerType)) {
        return ((Set)localObject).contains(Integer.valueOf(this.mTriggerType));
      }
      if (!VideoMaterialUtil.isBodyDetectType(this.mTriggerType)) {
        break;
      }
      if ((localList != null) && (!localList.isEmpty())) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TriggerExpression
 * JD-Core Version:    0.7.0.1
 */