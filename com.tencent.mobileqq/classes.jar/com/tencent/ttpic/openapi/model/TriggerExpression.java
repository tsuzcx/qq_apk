package com.tencent.ttpic.openapi.model;

import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.util.List;
import java.util.Set;

public class TriggerExpression
{
  public int mTriggerType;
  
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
    boolean bool2 = true;
    PTDetectInfo localPTDetectInfo = TriggerStateManager.getInstance().getPTDetectInfo();
    if (localPTDetectInfo == null) {
      return false;
    }
    Object localObject = localPTDetectInfo.triggeredExpression;
    List localList = localPTDetectInfo.bodyPoints;
    AIAttr localAIAttr = localPTDetectInfo.aiAttr;
    boolean bool1;
    if (VideoMaterialUtil.isFaceTriggerType(this.mTriggerType))
    {
      if (localObject != null)
      {
        bool1 = ((Set)localObject).contains(Integer.valueOf(this.mTriggerType));
        return bool1;
      }
    }
    else if (VideoMaterialUtil.isGestureTriggerType(this.mTriggerType))
    {
      localObject = (PTHandAttr)localAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (localObject == null) {
        break label248;
      }
      if (((PTHandAttr)localObject).getHandType() == this.mTriggerType) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (localPTDetectInfo.isFreezeInfo)
      {
        bool1 = bool2;
        if (localPTDetectInfo.gestureTrigger == this.mTriggerType) {
          break;
        }
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
      break;
      bool1 = bool2;
      if (VideoMaterialUtil.isAudioTextTriggerType(this.mTriggerType)) {
        break;
      }
      if (VideoMaterialUtil.isAllFreezeFrameTriggerType(this.mTriggerType))
      {
        bool1 = ((Set)localObject).contains(Integer.valueOf(this.mTriggerType));
        break;
      }
      if (VideoMaterialUtil.isTouchTriggerType(this.mTriggerType))
      {
        bool1 = ((Set)localObject).contains(Integer.valueOf(this.mTriggerType));
        break;
      }
      if (VideoMaterialUtil.isBodyDetectType(this.mTriggerType))
      {
        if (localList != null)
        {
          bool1 = bool2;
          if (!localList.isEmpty()) {
            break;
          }
        }
        bool1 = false;
        break;
      }
      bool1 = false;
      break;
      label248:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TriggerExpression
 * JD-Core Version:    0.7.0.1
 */