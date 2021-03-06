package com.tencent.ttpic.util;

import com.tencent.ttpic.trigger.TRIGGERED_STATUS;
import java.util.HashMap;

public class StickerTriggerStatusUtil
{
  private static HashMap<String, TRIGGERED_STATUS> TRIGGER_STATUS_BOARD = new HashMap();
  
  public static void clear()
  {
    HashMap localHashMap = TRIGGER_STATUS_BOARD;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public static TRIGGERED_STATUS getTriggerStatus(String paramString)
  {
    if (paramString != null) {
      return (TRIGGERED_STATUS)TRIGGER_STATUS_BOARD.get(paramString);
    }
    return TRIGGERED_STATUS.NOT_TRIGGERED;
  }
  
  public static void putTriggerStatus(String paramString, TRIGGERED_STATUS paramTRIGGERED_STATUS)
  {
    if (paramString != null) {
      TRIGGER_STATUS_BOARD.put(paramString, paramTRIGGERED_STATUS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.StickerTriggerStatusUtil
 * JD-Core Version:    0.7.0.1
 */