package com.tencent.ttpic.openapi.model;

import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import java.util.ArrayList;

public class NumberRollEffectParams
{
  public int activateTriggerCount;
  public int activateTriggerTotalCount;
  public int activateTriggerType;
  public boolean alwaysTriggered;
  public int countTriggerType;
  public String id;
  public int materialImageHeight = 0;
  public int materialImageWidth = 0;
  public String numberImageFile = "";
  public ArrayList<NumberRollItem> numberRollItems = null;
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
    catch (NumberFormatException localNumberFormatException)
    {
      label10:
      break label10;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.NumberRollEffectParams
 * JD-Core Version:    0.7.0.1
 */