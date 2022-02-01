package com.tencent.ttpic.openapi.model;

import android.graphics.PointF;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.util.TriggerUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TriggerExpression
{
  public String externalTriggerWords;
  public int mTriggerType;
  public ArrayList<StickerItem.TriggerArea> triggerArea;
  public int triggerFingerIndex = 0;
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
    Object localObject1 = TriggerStateManager.getInstance().getPTDetectInfo();
    if (localObject1 == null) {}
    Object localObject2;
    List localList;
    AIAttr localAIAttr;
    do
    {
      return false;
      localObject2 = ((PTDetectInfo)localObject1).triggeredExpression;
      localList = ((PTDetectInfo)localObject1).bodyPoints;
      localAIAttr = ((PTDetectInfo)localObject1).aiAttr;
      if ((!VideoMaterial.isFaceTriggerType(this.mTriggerType)) && (!VideoMaterial.isCatTriggerType(this.mTriggerType))) {
        break;
      }
    } while (localObject2 == null);
    return ((Set)localObject2).contains(Integer.valueOf(this.mTriggerType));
    if (VideoMaterial.isGestureTriggerType(this.mTriggerType))
    {
      localObject2 = (PTHandAttr)localAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (localObject2 == null) {
        break label337;
      }
    }
    label337:
    for (bool = TriggerUtil.isGestureTriggered((PTHandAttr)localObject2, this.mTriggerType, this.triggerHandPoint, this.triggerFingerIndex, this.triggerArea, localAIAttr);; bool = false)
    {
      if (((PTDetectInfo)localObject1).isFreezeInfo)
      {
        if (((PTDetectInfo)localObject1).gestureTrigger != this.mTriggerType) {
          break;
        }
        return true;
      }
      return bool;
      if (VideoMaterial.isAudioTextTriggerType(this.mTriggerType)) {
        return true;
      }
      if (VideoMaterial.isAllFreezeFrameTriggerType(this.mTriggerType)) {
        return ((Set)localObject2).contains(Integer.valueOf(this.mTriggerType));
      }
      if (VideoMaterial.isTouchTriggerType(this.mTriggerType))
      {
        if (this.triggerArea != null)
        {
          localObject1 = TouchTriggerManager.getInstance().getCurTouchPosition();
          return TriggerUtil.isTouchAreaTriggered(this.triggerArea, (PointF)localObject1);
        }
        return ((Set)localObject2).contains(Integer.valueOf(this.mTriggerType));
      }
      if (VideoMaterial.isBodyDetectType(this.mTriggerType))
      {
        if ((localList != null) && (!localList.isEmpty())) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      if ((!VideoMaterial.isExternalWordsTriggerType(this.mTriggerType)) || (localAIAttr == null)) {
        break;
      }
      localObject1 = (List)localAIAttr.getRealtimeData(AEDetectorType.VOICE_RECOGNIZE.value);
      if ((localObject1 == null) || (!((List)localObject1).contains(this.externalTriggerWords))) {
        break;
      }
      AIActionCounter.updateAction(AEDetectorType.VOICE_RECOGNIZE + this.externalTriggerWords);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TriggerExpression
 * JD-Core Version:    0.7.0.1
 */