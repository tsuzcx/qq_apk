package com.tencent.ttpic.model;

import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import java.util.ArrayList;

public class FaceMeshItem
{
  public boolean alwaysTriggered;
  public CharmRange charmRange;
  public String externalTriggerWords;
  public int featureStatType;
  public StickerItem.ValueRange featureStatValueRange;
  public double frameDuration;
  public int frameType;
  public int frames;
  public int genderType = 0;
  public String id;
  public int personID;
  public int playCount;
  public ArrayList<String> triggerState;
  private String triggerType;
  
  public int getTriggerTypeInt()
  {
    try
    {
      int i = Integer.parseInt(this.triggerType);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return PTFaceAttr.PTExpression.FACE_DETECT.value;
  }
  
  public String getTriggerTypeString()
  {
    return this.triggerType;
  }
  
  public void setTriggerType(String paramString)
  {
    this.triggerType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceMeshItem
 * JD-Core Version:    0.7.0.1
 */