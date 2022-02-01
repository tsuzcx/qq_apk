package tencent.im.s2c.msgtype0x210.submsgtype0x116;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x116$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_event_type = PBField.initEnum(1);
  public final PBRepeatMessageField<submsgtype0x116.MemberInfo> rpt_msg_member_join = PBField.initRepeatMessage(submsgtype0x116.MemberInfo.class);
  public final PBRepeatMessageField<submsgtype0x116.MemberInfo> rpt_msg_member_quit = PBField.initRepeatMessage(submsgtype0x116.MemberInfo.class);
  public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_invite_list_total_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_room_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "rpt_msg_member_join", "rpt_msg_member_quit", "uint32_group_id", "uint32_room_id", "uint32_invite_list_total_count", "enum_event_type" }, new Object[] { null, null, localInteger, localInteger, localInteger, Integer.valueOf(1) }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody
 * JD-Core Version:    0.7.0.1
 */