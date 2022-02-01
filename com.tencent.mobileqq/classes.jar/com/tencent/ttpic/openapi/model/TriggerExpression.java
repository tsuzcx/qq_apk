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
    Object localObject1 = TriggerStateManager.getInstance().getPTDetectInfo();
    boolean bool2 = false;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((PTDetectInfo)localObject1).triggeredExpression;
    List localList = ((PTDetectInfo)localObject1).bodyPoints;
    AIAttr localAIAttr = ((PTDetectInfo)localObject1).aiAttr;
    boolean bool1;
    if ((!VideoMaterial.isFaceTriggerType(this.mTriggerType)) && (!VideoMaterial.isCatTriggerType(this.mTriggerType)))
    {
      if (VideoMaterial.isGestureTriggerType(this.mTriggerType))
      {
        localObject2 = (PTHandAttr)localAIAttr.getAvailableData(AEDetectorType.HAND.value);
        if (localObject2 != null) {
          bool1 = TriggerUtil.isGestureTriggered((PTHandAttr)localObject2, this.mTriggerType, this.triggerHandPoint, this.triggerFingerIndex, this.triggerArea, localAIAttr);
        } else {
          bool1 = false;
        }
        if (((PTDetectInfo)localObject1).isFreezeInfo)
        {
          bool1 = bool2;
          if (((PTDetectInfo)localObject1).gestureTrigger != this.mTriggerType) {
            return bool1;
          }
        }
        else
        {
          return bool1;
        }
      }
      else
      {
        if (!VideoMaterial.isAudioTextTriggerType(this.mTriggerType)) {
          break label153;
        }
      }
      for (;;)
      {
        return true;
        label153:
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
          bool1 = bool2;
          if (localList == null) {
            break;
          }
          bool1 = bool2;
          if (localList.isEmpty()) {
            break;
          }
        }
        else
        {
          bool1 = bool2;
          if (!VideoMaterial.isExternalWordsTriggerType(this.mTriggerType)) {
            break;
          }
          if (localAIAttr == null) {
            return false;
          }
          localObject1 = (List)localAIAttr.getRealtimeData(AEDetectorType.VOICE_RECOGNIZE.value);
          bool1 = bool2;
          if (localObject1 == null) {
            break;
          }
          bool1 = bool2;
          if (!((List)localObject1).contains(this.externalTriggerWords)) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(AEDetectorType.VOICE_RECOGNIZE);
          ((StringBuilder)localObject1).append(this.externalTriggerWords);
          AIActionCounter.updateAction(((StringBuilder)localObject1).toString());
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (localObject2 != null) {
        bool1 = ((Set)localObject2).contains(Integer.valueOf(this.mTriggerType));
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TriggerExpression
 * JD-Core Version:    0.7.0.1
 */