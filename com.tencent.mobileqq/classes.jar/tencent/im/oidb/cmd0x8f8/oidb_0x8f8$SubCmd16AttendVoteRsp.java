package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.VoteRecord;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.VoteStatistic;

public final class oidb_0x8f8$SubCmd16AttendVoteRsp
  extends MessageMicro<SubCmd16AttendVoteRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Integer> rpt_uint32_voteids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.VoteRecord> rpt_vote_record = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteRecord.class);
  public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.VoteStatistic> rpt_vote_statistic = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteStatistic.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 114, 122 }, new String[] { "bytes_feeds_id", "rpt_uint32_voteids", "rpt_vote_statistic", "rpt_vote_record" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null, null }, SubCmd16AttendVoteRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f8.oidb_0x8f8.SubCmd16AttendVoteRsp
 * JD-Core Version:    0.7.0.1
 */