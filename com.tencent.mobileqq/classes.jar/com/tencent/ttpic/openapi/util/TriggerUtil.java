package com.tencent.ttpic.openapi.util;

import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import java.util.List;

public class TriggerUtil
{
  public static boolean isGestureTriggered(PTHandAttr paramPTHandAttr, int paramInt)
  {
    if (paramPTHandAttr == null) {}
    while (((200 > paramInt) || (paramInt > 212) || (paramPTHandAttr.getHandType() != paramInt)) && ((paramPTHandAttr.getHandPointList() == null) || (paramPTHandAttr.getHandPointList().size() == 0) || (paramInt != 200)) && (paramInt != PTFaceAttr.PTExpression.ALWAYS.value)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.TriggerUtil
 * JD-Core Version:    0.7.0.1
 */