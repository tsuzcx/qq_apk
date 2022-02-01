package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xcf4$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154 }, new String[] { "uint64_from_uin", "uint64_to_uin", "msg_cur_mutual_mark_info", "msg_friend_info", "msg_common_group_chat_info", "rpt_msg_mutual_mark_info", "rpt_msg_dna_info", "rpt_msg_prefetch_mutual_mark_info", "rpt_msg_data_tips", "rpt_msg_common_rspbody", "rpt_msg_mutual_score", "rpt_msg_mutual_score_card" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null, null, null, null, null, null }, RspBody.class);
  public oidb_0xcf4.CommonGroupChatInfo msg_common_group_chat_info = new oidb_0xcf4.CommonGroupChatInfo();
  public oidb_0xcf4.MutualMarkInfo msg_cur_mutual_mark_info = new oidb_0xcf4.MutualMarkInfo();
  public oidb_0xcf4.FriendInfo msg_friend_info = new oidb_0xcf4.FriendInfo();
  public final PBRepeatMessageField<oidb_0xcf4.CommonBody> rpt_msg_common_rspbody = PBField.initRepeatMessage(oidb_0xcf4.CommonBody.class);
  public final PBRepeatMessageField<oidb_0xcf4.DateTips> rpt_msg_data_tips = PBField.initRepeatMessage(oidb_0xcf4.DateTips.class);
  public final PBRepeatMessageField<oidb_0xcf4.DnaInfo> rpt_msg_dna_info = PBField.initRepeatMessage(oidb_0xcf4.DnaInfo.class);
  public final PBRepeatMessageField<oidb_0xcf4.MutualMarkInfo> rpt_msg_mutual_mark_info = PBField.initRepeatMessage(oidb_0xcf4.MutualMarkInfo.class);
  public oidb_0xcf4.MutualScore rpt_msg_mutual_score = new oidb_0xcf4.MutualScore();
  public oidb_0xcf4.MutualScoreCard rpt_msg_mutual_score_card = new oidb_0xcf4.MutualScoreCard();
  public final PBRepeatMessageField<oidb_0xcf4.PrefetchMutualMarkInfo> rpt_msg_prefetch_mutual_mark_info = PBField.initRepeatMessage(oidb_0xcf4.PrefetchMutualMarkInfo.class);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.RspBody
 * JD-Core Version:    0.7.0.1
 */