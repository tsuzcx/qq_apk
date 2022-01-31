package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class group_feeds$GroupFeedsMessage$VoteRecord
  extends MessageMicro<VoteRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 29 }, new String[] { "rpt_option_id", "fixed32_vote_uin", "fixed32_vote_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VoteRecord.class);
  public final PBFixed32Field fixed32_vote_time = PBField.initFixed32(0);
  public final PBFixed32Field fixed32_vote_uin = PBField.initFixed32(0);
  public final PBRepeatField<Integer> rpt_option_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.VoteRecord
 * JD-Core Version:    0.7.0.1
 */