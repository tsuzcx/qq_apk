package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class group_feeds$GroupFeedsMessage$VoteStatistic
  extends MessageMicro<VoteStatistic>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_option_id = PBField.initInt32(0);
  public final PBInt32Field int32_vote_count = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_option_id", "int32_vote_count" }, new Object[] { localInteger, localInteger }, VoteStatistic.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.VoteStatistic
 * JD-Core Version:    0.7.0.1
 */