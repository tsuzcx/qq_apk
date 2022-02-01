package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowSummaryCard$VoteInfo
  extends MessageMicro<VoteInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field latest_vote_count = PBField.initUInt32(0);
  public final PBUInt32Field vote_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "vote_count", "latest_vote_count" }, new Object[] { localInteger, localInteger }, VoteInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.VoteInfo
 * JD-Core Version:    0.7.0.1
 */