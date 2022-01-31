package tencent.im.oidb.oidb_0xd4a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;

public final class oidb_0xd4a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "rpt_msg_friend_data", "rpt_msg_not_friend_data", "uint64_group_code", "rpt_msg_common_rspbody" }, new Object[] { null, null, Long.valueOf(0L), null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xcf4.CommonBody> rpt_msg_common_rspbody = PBField.initRepeatMessage(oidb_0xcf4.CommonBody.class);
  public final PBRepeatMessageField<oidb_0xd4a.FriendData> rpt_msg_friend_data = PBField.initRepeatMessage(oidb_0xd4a.FriendData.class);
  public final PBRepeatMessageField<oidb_0xd4a.NotFriendData> rpt_msg_not_friend_data = PBField.initRepeatMessage(oidb_0xd4a.NotFriendData.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.RspBody
 * JD-Core Version:    0.7.0.1
 */