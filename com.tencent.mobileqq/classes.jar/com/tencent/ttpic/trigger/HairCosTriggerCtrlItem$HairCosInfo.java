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
    if (paramArrayOfInt != null)
    {
      if (paramInt < 0) {
        return true;
      }
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return true;
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
    boolean bool;
    if ((this.triggerCtrlItem.isTriggered()) && (isInCurPart(paramInt, this.activeParts)) && ((this.genderType == 0) || ((paramPTDetectInfo.faceStatus != null) && (this.genderType == paramPTDetectInfo.faceStatus.gender)))) {
      bool = true;
    } else {
      bool = false;
    }
    this.needRender = bool;
    return this.needRender;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.trigger.HairCosTriggerCtrlItem.HairCosInfo
 * JD-Core Version:    0.7.0.1
 */