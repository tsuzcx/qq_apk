package com.tencent.ttpic.openapi.watermark;

import com.tencent.ttpic.audio.LocalAudioDataManager;

class LogicDataManager$70
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$70(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    return LocalAudioDataManager.getInstance().getDB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.70
 * JD-Core Version:    0.7.0.1
 */