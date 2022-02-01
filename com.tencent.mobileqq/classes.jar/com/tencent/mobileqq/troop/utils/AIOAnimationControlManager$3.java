package com.tencent.mobileqq.troop.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class AIOAnimationControlManager$3
  implements Comparator<AIOAnimationControlManager.IAnimationMessage>
{
  AIOAnimationControlManager$3(AIOAnimationControlManager paramAIOAnimationControlManager) {}
  
  public int a(AIOAnimationControlManager.IAnimationMessage paramIAnimationMessage1, AIOAnimationControlManager.IAnimationMessage paramIAnimationMessage2)
  {
    long l1;
    long l2;
    if (((paramIAnimationMessage1 instanceof MessageForDeliverGiftTips)) && ((paramIAnimationMessage2 instanceof MessageForDeliverGiftTips)))
    {
      paramIAnimationMessage1 = (MessageForDeliverGiftTips)paramIAnimationMessage1;
      paramIAnimationMessage2 = (MessageForDeliverGiftTips)paramIAnimationMessage2;
      if ((paramIAnimationMessage1.isToAll()) && (paramIAnimationMessage2.isToAll()))
      {
        l1 = paramIAnimationMessage1.time;
        l2 = paramIAnimationMessage2.time;
      }
    }
    for (;;)
    {
      return (int)(l1 - l2);
      if (paramIAnimationMessage1.isToAll()) {
        return -1;
      }
      if (paramIAnimationMessage2.isToAll()) {
        return 1;
      }
      if ((paramIAnimationMessage1.receiverUin == this.a.a.getLongAccountUin()) && (paramIAnimationMessage2.receiverUin == this.a.a.getLongAccountUin()))
      {
        l1 = paramIAnimationMessage1.time;
        l2 = paramIAnimationMessage2.time;
      }
      else
      {
        if (paramIAnimationMessage1.receiverUin == this.a.a.getLongAccountUin()) {
          return -1;
        }
        if (paramIAnimationMessage2.receiverUin == this.a.a.getLongAccountUin()) {
          return 1;
        }
        l1 = paramIAnimationMessage1.time;
        l2 = paramIAnimationMessage2.time;
        continue;
        l1 = paramIAnimationMessage1.getShmsgseq();
        l2 = paramIAnimationMessage2.getShmsgseq();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.3
 * JD-Core Version:    0.7.0.1
 */