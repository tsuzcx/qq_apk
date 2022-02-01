package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import java.util.Comparator;

class FTSMessageSearchEngine$6
  implements Comparator<FTSEntity>
{
  FTSMessageSearchEngine$6(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public int a(FTSEntity paramFTSEntity1, FTSEntity paramFTSEntity2)
  {
    paramFTSEntity1 = (TextMsgExts)((FTSMessage)paramFTSEntity1).msgExts;
    paramFTSEntity2 = (TextMsgExts)((FTSMessage)paramFTSEntity2).msgExts;
    long l2 = 0L;
    long l1;
    if (paramFTSEntity1 != null) {
      l1 = paramFTSEntity1.time;
    } else {
      l1 = 0L;
    }
    if (paramFTSEntity2 != null) {
      l2 = paramFTSEntity2.time;
    }
    return Long.signum(l2 - l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.6
 * JD-Core Version:    0.7.0.1
 */