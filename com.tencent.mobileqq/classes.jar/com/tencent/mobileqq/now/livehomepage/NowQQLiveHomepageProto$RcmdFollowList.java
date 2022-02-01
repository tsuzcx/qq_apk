package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class NowQQLiveHomepageProto$RcmdFollowList
  extends MessageMicro<RcmdFollowList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_rcmd_follow" }, new Object[] { null }, RcmdFollowList.class);
  public final PBRepeatMessageField<NowQQLiveHomepageProto.RcmdFollowItem> rpt_rcmd_follow = PBField.initRepeatMessage(NowQQLiveHomepageProto.RcmdFollowItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RcmdFollowList
 * JD-Core Version:    0.7.0.1
 */