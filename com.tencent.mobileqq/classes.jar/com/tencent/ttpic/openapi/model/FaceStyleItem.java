package com.tencent.ttpic.openapi.model;

import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import java.util.ArrayList;

public class FaceStyleItem
{
  public boolean alwaysTriggered;
  public String dataPath;
  public String id;
  public int[] imageSize = { 320, 320 };
  public String modelName;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.FaceStyleItem
 * JD-Core Version:    0.7.0.1
 */