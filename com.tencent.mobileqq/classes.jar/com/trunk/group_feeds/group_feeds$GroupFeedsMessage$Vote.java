package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_feeds$GroupFeedsMessage$Vote
  extends MessageMicro<Vote>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_max_vote_per_uin = PBField.initInt32(0);
  public group_feeds.GroupFeedsMessage.ContentList msg_title = new group_feeds.GroupFeedsMessage.ContentList();
  public group_feeds.GroupFeedsMessage.ContentList msg_vote_des = new group_feeds.GroupFeedsMessage.ContentList();
  public group_feeds.GroupFeedsMessage.ContentList msg_vote_res = new group_feeds.GroupFeedsMessage.ContentList();
  public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.ContentList> rpt_msg_options = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.ContentList.class);
  public final PBFixed32Field uint32_vote_deadline = PBField.initFixed32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 53 }, new String[] { "msg_title", "int32_max_vote_per_uin", "rpt_msg_options", "msg_vote_des", "msg_vote_res", "uint32_vote_deadline" }, new Object[] { null, localInteger, null, null, null, localInteger }, Vote.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.Vote
 * JD-Core Version:    0.7.0.1
 */