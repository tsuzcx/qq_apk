package com.tencent.ttpic.openapi.watermark;

import com.tencent.ttpic.audio.LocalAudioDataManager;

class LogicDataManager$69
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$69(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    return LocalAudioDataManager.getInstance().getDB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.69
 * JD-Core Version:    0.7.0.1
 */