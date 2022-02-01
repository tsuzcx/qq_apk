package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class TroopMessageProcessor$1
  implements Comparator<MessageRecord>
{
  TroopMessageProcessor$1(TroopMessageProcessor paramTroopMessageProcessor) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */