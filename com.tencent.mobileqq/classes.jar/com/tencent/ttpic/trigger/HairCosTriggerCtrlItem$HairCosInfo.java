package com.tencent.ttpic.trigger;

import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTDetectInfo;

public class HairCosTriggerCtrlItem$HairCosInfo
{
  public int[] activeParts;
  public int genderType = 0;
  public String id;
  public boolean needRender = false;
  public TriggerCtrlItem triggerCtrlItem;
  
  public HairCosTriggerCtrlItem$HairCosInfo(HairCosTriggerCtrlItem paramHairCosTriggerCtrlItem, String paramString, int[] paramArrayOfInt, int paramInt, TriggerCtrlItem paramTriggerCtrlItem)
  {
    this.id = paramString;
    this.activeParts = paramArrayOfInt;
    this.genderType = paramInt;
    this.triggerCtrlItem = paramTriggerCtrlItem;
  }
  
  private boolean isInCurPart(int paramInt, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramInt < 0)) {
      return true;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label36;
      }
      if (paramArrayOfInt[i] == paramInt) {
        break;
      }
      i += 1;
    }
    label36:
    return false;
  }
  
  public int getFrameIndex()
  {
    return this.triggerCtrlItem.getFrameIndex();
  }
  
  public boolean updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
  {
    this.triggerCtrlItem.updateTriggerStatus(paramPTDetectInfo);
    this.needRender = this.triggerCtrlItem.isTriggered();
    return this.needRender;
  }
  
  public boolean updateTriggerStatus(PTDetectInfo paramPTDetectInfo, int paramInt)
  {
    this.triggerCtrlItem.updateTriggerStatus(paramPTDetectInfo);
    if ((this.triggerCtrlItem.isTriggered()) && (isInCurPart(paramInt, this.activeParts)) && ((this.genderType == 0) || ((paramPTDetectInfo.faceStatus != null) && (this.genderType == paramPTDetectInfo.faceStatus.gender)))) {}
    for (boolean bool = true;; bool = false)
    {
      this.needRender = bool;
      return this.needRender;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.trigger.HairCosTriggerCtrlItem.HairCosInfo
 * JD-Core Version:    0.7.0.1
 */