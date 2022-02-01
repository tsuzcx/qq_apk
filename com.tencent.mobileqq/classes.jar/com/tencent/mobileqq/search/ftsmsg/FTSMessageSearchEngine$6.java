package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import java.util.Comparator;

class FTSMessageSearchEngine$6
  implements Comparator<FTSEntity>
{
  FTSMessageSearchEngine$6(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public int a(FTSEntity paramFTSEntity1, FTSEntity paramFTSEntity2)
  {
    paramFTSEntity1 = (FTSMessageCodec.TextMsgExts)((FTSMessage)paramFTSEntity1).msgExts;
    paramFTSEntity2 = (FTSMessageCodec.TextMsgExts)((FTSMessage)paramFTSEntity2).msgExts;
    long l1;
    if (paramFTSEntity1 != null)
    {
      l1 = paramFTSEntity1.time;
      if (paramFTSEntity2 == null) {
        break label54;
      }
    }
    label54:
    for (long l2 = paramFTSEntity2.time;; l2 = 0L)
    {
      return Long.signum(l2 - l1);
      l1 = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.6
 * JD-Core Version:    0.7.0.1
 */